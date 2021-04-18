package crcApp.crcAPI.data.repository;

import crcApp.crcAPI.data.model.Metric;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MetricRepository  extends JpaRepository<Metric, Long> {
    List<Metric> findAll();

    List<Metric> findAllByUserId(long userId);

    List<Metric> findMetricByDateTimeAfterAndUserId(LocalDateTime date, long userId);

}
