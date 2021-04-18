package crcApp.crcAPI.web.controller;

import crcApp.crcAPI.data.model.WeeklyGoalsSaved;
import crcApp.crcAPI.data.repository.WeeklyGoalsSavedRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@RestController
public class WeeklyGoalsSavedController {

    @Autowired
    private final WeeklyGoalsSavedRepository weeklyGoalsSavedRepository;

    public WeeklyGoalsSavedController(WeeklyGoalsSavedRepository weeklyGoalsSavedRepository) {
        this.weeklyGoalsSavedRepository = weeklyGoalsSavedRepository;
    }


    @GetMapping(value = "/api/weekly_goals_saved/all")
    public List<WeeklyGoalsSaved> getWeeklyGoalsSaved() {
        List<WeeklyGoalsSaved> weeklyGoalsSavedList = weeklyGoalsSavedRepository.findAll();
        return weeklyGoalsSavedList;
    }

    @GetMapping(value = "/api/weekly_goals_saved/all/{id}")
    public List<WeeklyGoalsSaved> getWeeklyGoalsSavedByID(@PathVariable("id") Long id) {
        List<WeeklyGoalsSaved> weeklyGoalsSavedList = weeklyGoalsSavedRepository.findWeeklyGoalsSavedsByUserId(id);
        return weeklyGoalsSavedList;
    }

    @PostMapping(path = "/api/weekly_goals_saved/add/")
    public boolean saveWeeklyGoalsSaved(@RequestBody WeeklyGoalsSaved weeklyGoalsSaved) {
        WeeklyGoalsSaved newWeeklyGoalsSaved = new WeeklyGoalsSaved();
        newWeeklyGoalsSaved.setId(weeklyGoalsSaved.getId());
        newWeeklyGoalsSaved.setType(weeklyGoalsSaved.getType());
        newWeeklyGoalsSaved.setGoalDescription(weeklyGoalsSaved.getGoalDescription());
        newWeeklyGoalsSaved.setHelp_info(weeklyGoalsSaved.getHelp_info());
        newWeeklyGoalsSaved.setUserId(weeklyGoalsSaved.getUserId());
        weeklyGoalsSavedRepository.save(newWeeklyGoalsSaved);
        System.out.println(newWeeklyGoalsSaved.getType());
        return true;

    }

    @Transactional
    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
    @DeleteMapping(value = "/api/weekly_goals_saved/delete/{id}")
    public void deleteWeeklyGoalsSavedByID(@PathVariable("id") Long id) { weeklyGoalsSavedRepository.deleteById(id); }
}
