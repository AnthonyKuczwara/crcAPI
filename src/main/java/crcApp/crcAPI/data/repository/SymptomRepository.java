package crcApp.crcAPI.data.repository;

import crcApp.crcAPI.data.model.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface SymptomRepository extends JpaRepository<Symptom, Long> {

    List<Symptom> findAll();

    List<Symptom> findAllByUserId(long userId);

    List<Symptom> findSymptomByDateTimeAfterAndUserId(LocalDateTime date, long userId);
}
