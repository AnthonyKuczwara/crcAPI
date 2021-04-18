package crcApp.crcAPI.data.service;

import crcApp.crcAPI.data.model.ActivityLevel;
import crcApp.crcAPI.data.model.CancerTreatment;
import crcApp.crcAPI.data.model.UserHasFrequentGiIssues;
import crcApp.crcAPI.data.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private static ActivityLevelRepository activityLevelRepository;
    private static UserHasFrequentGiIssuesRepository userHasFrequentGiIssuesRepository;
    private static CancerTreatmentRepository cancerTreatmentRepository;
    private final FoodLogEntryRepository foodLogEntryRepository;
    private final UserRepository userRepository;


    public UserService(FoodLogEntryRepository foodLogEntryRepository, UserRepository userRepository, ActivityLevelRepository activityLevelRepository, UserHasFrequentGiIssuesRepository userHasFrequentGiIssuesRepository,CancerTreatmentRepository cancerTreatmentRepository) {
        this.foodLogEntryRepository = foodLogEntryRepository;
        this.userRepository = userRepository;
        this.activityLevelRepository = activityLevelRepository;
        this.userHasFrequentGiIssuesRepository = userHasFrequentGiIssuesRepository;
        this.cancerTreatmentRepository = cancerTreatmentRepository;
    }
//
//    public String saveFoodLogEntry(Long userId, Long foodId, int portion,Date date, String mealType, String mealTime ) {
//        DailyFoodLog dailyFoodLog = new DailyFoodLog();
//        Date newDate = new Date();
//        dailyFoodLog.setCreated(newDate);
//                dailyFoodLog.setDate(date);
//        dailyFoodLogRepository.save(dailyFoodLog);
//
//        return "success";
//    }

    public static String getActivityLevel(Long activityLevelId) {
        Optional<ActivityLevel> optionalActivityLevel = activityLevelRepository.findActivityLevelById(activityLevelId);
        if (optionalActivityLevel.isPresent()) {
            return optionalActivityLevel.get().getLevel();
        }
        return "";
    }

    public static Boolean[] getUserFrequentGiIssues(Long userId) {
        List<UserHasFrequentGiIssues> userHasFrequentGiIssuesLists = userHasFrequentGiIssuesRepository.findUserHasFrequentGiIssuesByUserId(userId);
        Boolean[] temp = new Boolean[7];
        for (UserHasFrequentGiIssues userHasFrequentGiIssues : userHasFrequentGiIssuesLists) {
            temp[(int) (userHasFrequentGiIssues.getFrequentGiIssuesId() - 1)] = true;
        }

        return temp;
    }

    public static Boolean[] getCancerTreatment(Long userId){
        Optional<CancerTreatment>  optionalCancerTreatment = cancerTreatmentRepository.findCancerTreatmentByUserId(userId);
        Boolean[] temp = new Boolean[6];
        if(optionalCancerTreatment.isPresent()){
            temp[0] = optionalCancerTreatment.get().getSurgery();
            temp[1] = optionalCancerTreatment.get().getChemoTherapy();
            temp[2] = optionalCancerTreatment.get().getRadiationTherapy();
            temp[3] = optionalCancerTreatment.get().getOther();
            temp[4]= optionalCancerTreatment.get().getUncertain();
            temp[5] = optionalCancerTreatment.get().getOstomy();
        }
        return temp;
    }



}
