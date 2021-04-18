package crcApp.crcAPI.web.controller;

import crcApp.crcAPI.data.model.*;
import crcApp.crcAPI.data.repository.*;
import crcApp.crcAPI.web.payload.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/weekly_goals")
public class WeeklyGoalsController {


    @Autowired
    private WeeklyGoalsRepository weeklyGoalsRepository;


    @GetMapping(value = "/all")
    public List<WeeklyGoals> getWeeklyGoals() {
        List<WeeklyGoals> weeklyGoalsList = weeklyGoalsRepository.findAll();
        return weeklyGoalsList;
    }

    @PostMapping(path = "/add/")
    public boolean saveFitnessActivity(@RequestBody WeeklyGoals weeklyGoals) {
        WeeklyGoals newWeeklyGoals = new WeeklyGoals();
        newWeeklyGoals.setType(weeklyGoals.getType());
        newWeeklyGoals.setGoalDescription(weeklyGoals.getGoalDescription());
        newWeeklyGoals.setHelp_info(weeklyGoals.getHelp_info());
        weeklyGoalsRepository.save(newWeeklyGoals);
        System.out.println(newWeeklyGoals.getType());
        return true;

    }

    @PreAuthorize("hasRole('SUPER') or hasRole('MASTER')")
    @PostMapping(value = "/create")
    public ResponseEntity<?> createGoal(@Valid @RequestBody WeeklyGoals weeklyGoal) {
        Optional<WeeklyGoals> optionalWeeklyGoal = weeklyGoalsRepository.findWeeklyGoalsByGoalDescription(weeklyGoal.getGoalDescription());
        if (optionalWeeklyGoal.isPresent()) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Goal already exists!"));
        } else {
            List<WeeklyGoals> weeklyGoals = weeklyGoalsRepository.findAll();
            WeeklyGoals newWeeklyGoal = WeeklyGoals.builder()
                    .id((long) (weeklyGoals.size() + 1))
                    .goalDescription(weeklyGoal.getGoalDescription())
                    .type(weeklyGoal.getType())
                    .help_info(weeklyGoal.getHelp_info())
                    .build();
            weeklyGoalsRepository.save(newWeeklyGoal);
            return ResponseEntity.ok(new MessageResponse("Goal saved successfully!"));
        }
    }

    @PreAuthorize("hasRole('SUPER') or hasRole('MASTER')")
    @PostMapping(value = "/edit")
    public ResponseEntity<?> editGoal(@Valid @RequestBody WeeklyGoals weeklyGoal) {
        Optional<WeeklyGoals> optionalWeeklyGoal = weeklyGoalsRepository.findWeeklyGoalsById(weeklyGoal.getId());
        if (!optionalWeeklyGoal.isPresent()) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Goal does not exist!"));
        } else {
            WeeklyGoals updatedWeeklyGoal = optionalWeeklyGoal.get();
            updatedWeeklyGoal.setGoalDescription(weeklyGoal.getGoalDescription());
            updatedWeeklyGoal.setHelp_info(weeklyGoal.getHelp_info());
            updatedWeeklyGoal.setType(weeklyGoal.getType());
            weeklyGoalsRepository.save(updatedWeeklyGoal);
            return ResponseEntity.ok(new MessageResponse("Goal updated successfully!"));
        }
    }


}
