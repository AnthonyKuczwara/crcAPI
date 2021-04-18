package crcApp.crcAPI.data.repository;

import crcApp.crcAPI.data.model.FitnessActivity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface FitnessActivityRepository extends JpaRepository<FitnessActivity, Long> {

    List<FitnessActivity> findAll();

    List<FitnessActivity> findAllByUserId(long userId);

    List<FitnessActivity> findFitnessActivitiesByDateTimeAfterAndAndIntensityIsGreaterThanAndUserId(LocalDateTime date, String intensity, long userId);

    List<FitnessActivity> findFitnessActivitiesByDateTimeAfterAndUserId(LocalDateTime date, long userId);

//Option<FitnessActivity> findFitnessActivitiesByType

}
