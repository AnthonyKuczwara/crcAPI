package crcApp.crcAPI.web.controller;

import crcApp.crcAPI.data.model.*;
import crcApp.crcAPI.data.repository.*;
import crcApp.crcAPI.data.translator.FoodLogEntryTranslator;
import crcApp.crcAPI.data.translator.FoodTranslator;
import crcApp.crcAPI.data.translator.UserTranslator;
import crcApp.crcAPI.web.models.FoodLogEntryView;
import crcApp.crcAPI.web.models.FoodView;
import crcApp.crcAPI.web.models.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private ActivityLevelRepository activityLevelRepository;
    @Autowired
    private FrequentGiIssueRepository frequentGiIssueRepository;
    @Autowired
    private UserHasFrequentGiIssuesRepository userHasFrequentGiIssueRepository;
    @Autowired
    private FoodLogEntryRepository foodLogEntryRepository;
    @Autowired
    private CancerTreatmentRepository cancerTreatmentRepository;

    @GetMapping(value = "/checkIfEmailExists/{email}")
    public boolean checkIfEmailExists(@PathVariable String email) {
        // If the user does not exist currently
        Optional<User> optionalUser = userRepository.findUserByEmail(email);
        return optionalUser.isPresent();
    }

    /**
     * This method creates the user by setting the user details and saving them to the database, returning error messages or success message when applicable.
     *
     * @param user The user
     * @return The string containing the error type or successful registration pop up
     */
    @PostMapping(value = "/register")
    public String createUser(@Valid @RequestBody User user) {
        //Checks if the entered email is already in use
        Optional<User> optionalUser = userRepository.findUserByEmail(user.getEmail());
        if (optionalUser.isPresent()) {
            return "Username already taken";
        }
        //Sets the user's details and saves them to the database
//        user.setPassword(encode(user.getPassword()));
        user.setPassword(user.getPassword());
        user.setCreated(new Date());
        user.setUpdated(new Date());
        user.setScreenerCompleted(false);
        user.setFatPercent(15L);
        user.setProteinPercent(15L);
        user.setCarbohydratePercent(70L);
        userRepository.save(user);

        //Now that the user has been created and save, retrieve the user id and return it.
        Optional<User> savedNewUser = userRepository.findUserByEmail(user.getEmail());

        if (savedNewUser.isPresent()) {
            return savedNewUser.get().getId().toString();
        }
        return null;
    }


    @PostMapping(value = "/profile/ratios")
    public String setUserNutrientRatios(@Valid @RequestBody NutrientRatioFormModel nutrientRatioFormModel) {
        Optional<User> optionalUser = userRepository.findUserById(nutrientRatioFormModel.getUserId());
        if (!optionalUser.isPresent()) {
            return "User does not exist";
        }
        System.out.println(nutrientRatioFormModel.toString());
        User user = optionalUser.get();
        user.setFatPercent(nutrientRatioFormModel.getFatPercent());
        user.setProteinPercent(nutrientRatioFormModel.getProteinPercent());
        user.setCarbohydratePercent(nutrientRatioFormModel.getCarbohydratePercent());
        user.setUpdated(new Date());
        userRepository.save(user);


        return null;
    }

//    @PostMapping(path = "/register/")
//    public boolean createUser(@RequestBody User user) {
//        System.out.println(user.getEmail());
//        System.out.println(user.getPassword());
//        userRepository.save(user);
//        return true;
//    }


    @GetMapping(value = "/login/{email}/{password}")
    public String login(@PathVariable String email, @PathVariable String password) {
        // If the user does not exist currently
        Optional<User> optionalUser = userRepository.findUserByEmail(email);
        if (!optionalUser.isPresent()) {
            return "invalid";
        }
        User user = optionalUser.get();
        //Checks that the entered information is correct against that user's stored information
        String storedPass = user.getPassword();
        //If it is incorrect
        if (!password.equals(storedPass)) {
            return "invalid";
        }

        return user.getId().toString();
    }

    @GetMapping(value = "/formstatus/{id}")
    public String getFormCompletionStatus(@PathVariable String id) {
        System.out.println("here");
        Optional<User> optionalUser = userRepository.findUserById(Long.parseLong(id));
        if (!optionalUser.isPresent()) {
            System.out.println('1');
            return "false";
        }
        User user = optionalUser.get();
        if (user.getScreenerCompleted()) {
            System.out.println('2');
            return "true";
        }
        System.out.println('3');
        return "false";
    }

    @Transactional
    @DeleteMapping(value = "/{id}/delete/issues")
    public void deleteUserGiIssues(@PathVariable Long id) {
        userHasFrequentGiIssueRepository.deleteAllByUserId(id);

    }


    @PostMapping(value = "/form/save/")
    public String saveFormInfo(@Valid @RequestBody FormModel formModel) throws ParseException {
        Optional<User> optionalUser = userRepository.findUserById(formModel.getUserId());
        if (!optionalUser.isPresent()) {
            return "user not found";
        }
        System.out.println(formModel.toString());
        User userFromDB = optionalUser.get();
        String year = formModel.getBirthDate().split("-")[2];
        String month = formModel.getBirthDate().split("-")[0];
        String day = formModel.getBirthDate().split("-")[1];
        String fullDob = year + "-" + month + "-" + day;
        Date dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(fullDob);
        userFromDB.setDateOfBirth(dateOfBirth);
        userFromDB.setRace(formModel.getRace());
        userFromDB.setEthnicity(formModel.getEthnicity());
        userFromDB.setGender(formModel.getGender());
        userFromDB.setHeight(formModel.getHeight());
        userFromDB.setWeight(formModel.getWeight());
        Optional<ActivityLevel> activityLevelFromDB = activityLevelRepository.findActivityLevelByLevel(formModel.getActivityLevel());
        if (!activityLevelFromDB.isPresent()) {
            ActivityLevel newActivityLevel = new ActivityLevel();
            newActivityLevel.setLevel(formModel.getActivityLevel());
            newActivityLevel.setCreated(new Date());
            newActivityLevel.setUpdated(new Date());
            activityLevelRepository.save(newActivityLevel);
        }
        activityLevelFromDB = activityLevelRepository.findActivityLevelByLevel(formModel.getActivityLevel());
        Long activityLevelId = activityLevelFromDB.get().getId();
        userFromDB.setActivityLevelId(activityLevelId);

        String[] issues = formModel.getGastroIntestinalIssues().split(",");
        for (String issue : issues) {
            Optional<FrequentGiIssues> frequentGiIssuesFromDB = frequentGiIssueRepository.findFrequentGiIssuesByIssue(issue);
            if (!frequentGiIssuesFromDB.isPresent()) {
                FrequentGiIssues newFrequentGiIssues = new FrequentGiIssues();
                newFrequentGiIssues.setIssue(issue);
                newFrequentGiIssues.setCreated(new Date());
                newFrequentGiIssues.setUpdated(new Date());
                frequentGiIssueRepository.save(newFrequentGiIssues);
            }
            frequentGiIssuesFromDB = frequentGiIssueRepository.findFrequentGiIssuesByIssue(issue);
            Long frequentGiIssuesId = frequentGiIssuesFromDB.get().getId();
            UserHasFrequentGiIssues userHasFrequentGiIssues = new UserHasFrequentGiIssues();
            userHasFrequentGiIssues.setUserId(formModel.getUserId());
            userHasFrequentGiIssues.setFrequentGiIssuesId(frequentGiIssuesId);
            userHasFrequentGiIssueRepository.save(userHasFrequentGiIssues);
        }
        userFromDB.setColorectal(formModel.getColorectalCancer());
        if (!formModel.getColorectalCancer()) {
            userFromDB.setStage((long) -1);
            year = "0000";
            month = "00";
            day = "00";
            String fullDiagDate = year + "-" + month + "-" + day;
            Date lastDiagDate = new SimpleDateFormat("yyyy-MM-dd").parse(fullDiagDate);
            userFromDB.setDiagnosisDate(lastDiagDate);
        } else {
            userFromDB.setStage(Long.parseLong(formModel.getColorectalStage().split(" ")[1]));
            Date lastDiagDate = new SimpleDateFormat("yyyy-MM-dd").parse(formModel.getLastDiagDate());
            userFromDB.setDiagnosisDate(lastDiagDate);
        }

        CancerTreatment cancerTreatment;
        Optional<CancerTreatment> optionalCancerTreatment = cancerTreatmentRepository.findCancerTreatmentByUserId(userFromDB.getId());
        if (!optionalCancerTreatment.isPresent()) {
            cancerTreatment = CancerTreatment.builder()
                    .surgery(Boolean.parseBoolean(formModel.getCancerTreatment().split(",")[0]))
                    .chemoTherapy(Boolean.parseBoolean(formModel.getCancerTreatment().split(",")[1]))
                    .radiationTherapy(Boolean.parseBoolean(formModel.getCancerTreatment().split(",")[2]))
                    .other(Boolean.parseBoolean(formModel.getCancerTreatment().split(",")[3]))
                    .uncertain(Boolean.parseBoolean(formModel.getCancerTreatment().split(",")[4]))
                    .ostomy(Boolean.parseBoolean(formModel.getCancerTreatment().split(",")[5]))
                    .userId(formModel.getUserId())
                    .created(new Date())
                    .updated(new Date())
                    .build();

        } else {
            cancerTreatment = optionalCancerTreatment.get();
            cancerTreatment.setSurgery(Boolean.parseBoolean(formModel.getCancerTreatment().split(",")[0]));
            cancerTreatment.setChemoTherapy(Boolean.parseBoolean(formModel.getCancerTreatment().split(",")[1]));
            cancerTreatment.setRadiationTherapy(Boolean.parseBoolean(formModel.getCancerTreatment().split(",")[2]));
            cancerTreatment.setOther(Boolean.parseBoolean(formModel.getCancerTreatment().split(",")[3]));
            cancerTreatment.setUncertain(Boolean.parseBoolean(formModel.getCancerTreatment().split(",")[4]));
            cancerTreatment.setOstomy(Boolean.parseBoolean(formModel.getCancerTreatment().split(",")[5]));
            cancerTreatment.setUpdated(new Date());
        }
        cancerTreatmentRepository.save(cancerTreatment);

        userFromDB.setScreenerCompleted(true);
        userRepository.save(userFromDB);
        System.out.println("DONE");


        return "form saved";
    }

    @PostMapping(value = "/form/update/")
    public String updateFormInfo(@Valid @RequestBody FormModel formModel) throws ParseException {
        Optional<User> optionalUser = userRepository.findUserById(formModel.getUserId());
        if (!optionalUser.isPresent()) {
            return "user not found";
        }
        System.out.println(formModel.toString());
        User userFromDB = optionalUser.get();
        String temp = formModel.getBirthDate().split("T")[0];
        String year = temp.split("-")[0];
        String month = temp.split("-")[1];
        String day = temp.split("-")[2];
        String fullDob = year + "-" + month + "-" + day;
        Date dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(fullDob);
        userFromDB.setDateOfBirth(dateOfBirth);
        userFromDB.setRace(formModel.getRace());
        userFromDB.setEthnicity(formModel.getEthnicity());
        userFromDB.setGender(formModel.getGender());
        userFromDB.setHeight(formModel.getHeight());
        userFromDB.setWeight(formModel.getWeight());
        Optional<ActivityLevel> activityLevelFromDB = activityLevelRepository.findActivityLevelByLevel(formModel.getActivityLevel());
        if (!activityLevelFromDB.isPresent()) {
            ActivityLevel newActivityLevel = new ActivityLevel();
            newActivityLevel.setLevel(formModel.getActivityLevel());
            newActivityLevel.setCreated(new Date());
            newActivityLevel.setUpdated(new Date());
            activityLevelRepository.save(newActivityLevel);
        }
        activityLevelFromDB = activityLevelRepository.findActivityLevelByLevel(formModel.getActivityLevel());
        Long activityLevelId = activityLevelFromDB.get().getId();
        userFromDB.setActivityLevelId(activityLevelId);
        userFromDB.setUpdated(new Date());
        userRepository.save(userFromDB);
        System.out.println("DONE UPDATING");
        return "form saved";
    }


    @GetMapping(value = "/{userId}/get")
    public UserView getUserInfo(@PathVariable String userId) {
        Optional<User> optionalUser = userRepository.findUserById(Long.parseLong(userId));
        if (optionalUser.isPresent()) {
            return UserTranslator.entityToView(optionalUser.get());
        }
        return null;
    }

    @PreAuthorize("hasRole('BASE') or hasRole('SUPER') or hasRole('MASTER')")
    @GetMapping(value = "/all")
    public List<User> getUserInfo() {
        ArrayList<User> usersFromDB = (ArrayList<User>) userRepository.findAll();
        ArrayList<User> usersToSend = new ArrayList<>();
        for (User userFromDB : usersFromDB) {
            User userToSend = new User();
            userToSend.setId(userFromDB.getId());
            usersToSend.add(userToSend);
        }
        return usersToSend;
    }


    @GetMapping(value = "/{userId}/foodlog/{date}")
    public List<FoodLogEntryView> getDailyFoodLog(@PathVariable String userId, @PathVariable String date) throws ParseException {
        List<FoodLogEntry> foodLogEntryList = foodLogEntryRepository.getDailyFoods(Long.parseLong(userId), date.split("T")[0]);
        return FoodLogEntryTranslator.entitiesToViews(foodLogEntryList);

    }

    @GetMapping(value = "/{userId}/foodlog/frequent")
    public List<FoodView> getFrequentFoods(@PathVariable String userId) {
        ArrayList<FoodView> frequentFoods = new ArrayList<>();
        List<FoodLogEntry> foodLogEntryList = foodLogEntryRepository.findFrequentFoods(Long.parseLong(userId));
        for (FoodLogEntry foodLogEntry : foodLogEntryList) {
            Optional<Food> optionalFood = foodRepository.findFoodById(foodLogEntry.getFoodId());
            if (optionalFood.isPresent()) {
                frequentFoods.add(FoodTranslator.entityToView(optionalFood.get()));
            }
        }
        return frequentFoods;

    }

    @PostMapping(value = "/foodlog/save/")
    public String saveNewFoodLog(@Valid @RequestBody FoodLogEntryModel foodLogEntryModel) throws ParseException {
        FoodLogEntry newFoodLogEntry = new FoodLogEntry();
        newFoodLogEntry.setEntryTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(foodLogEntryModel.getEntryTime()));
        newFoodLogEntry.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(foodLogEntryModel.getEntryTime().split(" ")[0]));
        newFoodLogEntry.setPortion(foodLogEntryModel.getPortion());
        newFoodLogEntry.setUserId(foodLogEntryModel.getUserId());
        newFoodLogEntry.setFoodId(foodLogEntryModel.getFoodId());
        newFoodLogEntry.setCreated(new Date());
        newFoodLogEntry.setUpdated(new Date());
        foodLogEntryRepository.save(newFoodLogEntry);
        return "new food log entry saved";
    }

    @PostMapping(value = "/foodlog/update")
    public String updateFoodLog(@Valid @RequestBody FoodLogEntryModel foodLogEntryModel) throws ParseException {
        Optional<FoodLogEntry> optionalFoodLogEntry = foodLogEntryRepository.findFoodLogEntryById(foodLogEntryModel.getId());
        if (!optionalFoodLogEntry.isPresent()) {
            return "error updating";
        }
        FoodLogEntry foodLogEntryFromDB = optionalFoodLogEntry.get();
        foodLogEntryFromDB.setEntryTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(foodLogEntryModel.getEntryTime()));
        foodLogEntryFromDB.setPortion(foodLogEntryModel.getPortion());
        foodLogEntryFromDB.setUpdated(new Date());
        foodLogEntryRepository.save(foodLogEntryFromDB);
        return "food log entry updated";
    }

    @PostMapping(value = "/{userId}/update/weight/")
    public String updateWeight(@Valid @PathVariable Long userId, @RequestBody Metric metric) {
        Optional<User> optionalUser = userRepository.findUserById(userId);
        if (!optionalUser.isPresent()) {
            return "error updating";
        }
        User user = optionalUser.get();
        Date date = Date.from(metric.getDateTime().atZone(ZoneId.systemDefault()).toInstant());

        if (date.after(user.getUpdated())) {
            user.setWeight((long) metric.getWeight());
            user.setUpdated(new Date());
            userRepository.save(user);
        }

        return "user weight updated via metric";
    }

    @Transactional
    @DeleteMapping(value = "/foodlog/delete/{id}")
    public void deleteFoodLogEntry(@PathVariable Long id) {
        foodLogEntryRepository.deleteById(id);
    }
}
