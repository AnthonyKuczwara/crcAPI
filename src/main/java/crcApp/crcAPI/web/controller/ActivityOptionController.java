package crcApp.crcAPI.web.controller;

import crcApp.crcAPI.data.model.ActivityOption;
import crcApp.crcAPI.data.repository.ActivityOptionRepository;
import crcApp.crcAPI.web.payload.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/activityOptions")
public class ActivityOptionController {

    @Autowired
    private ActivityOptionRepository activityOptionRepository;


    @GetMapping(value = "/all")
    public List<ActivityOption> getAllFitnessActivity() {
        return activityOptionRepository.findAll();
    }

    @PreAuthorize("hasRole('SUPER') or hasRole('MASTER')")
    @PostMapping(value = "/create")
    public ResponseEntity<?> createActivity(@Valid @RequestBody ActivityOption activityOption) {
        Optional<ActivityOption> optionalActivityOption = activityOptionRepository.findActivityOptionByType(activityOption.getType());
        if (optionalActivityOption.isPresent()) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Activity already exists!"));
        } else {
            ActivityOption newActivityOption = ActivityOption.builder()
                    .type(activityOption.getType())
                    .coefficient(activityOption.getCoefficient())
                    .intensity(activityOption.getIntensity())
                    .isVisible(true)
                    .updated(new Date())
                    .created(new Date())
                    .build();
            activityOptionRepository.save(newActivityOption);
            return ResponseEntity.ok(new MessageResponse("Activity option saved successfully!"));
        }
    }

    @PreAuthorize("hasRole('SUPER') or hasRole('MASTER')")
    @PostMapping(value = "/edit")
    public ResponseEntity<?> editActivity(@Valid @RequestBody ActivityOption activityOption) {
        Optional<ActivityOption> optionalActivityOption = activityOptionRepository.findActivityOptionById(activityOption.getId());
        if (!optionalActivityOption.isPresent()) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Activity does not exist!"));
        } else {
            ActivityOption updatedActivityOption = optionalActivityOption.get();
            updatedActivityOption.setType(activityOption.getType());
            updatedActivityOption.setIntensity(activityOption.getIntensity());
            updatedActivityOption.setCoefficient(activityOption.getCoefficient());
            updatedActivityOption.setIsVisible(activityOption.getIsVisible());
            updatedActivityOption.setUpdated(new Date());

            activityOptionRepository.save(updatedActivityOption);
            return ResponseEntity.ok(new MessageResponse("Activity option updated successfully!"));
        }
    }

}
