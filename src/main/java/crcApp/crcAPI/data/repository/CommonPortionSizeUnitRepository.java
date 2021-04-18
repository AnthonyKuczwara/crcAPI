package crcApp.crcAPI.data.repository;

import crcApp.crcAPI.data.model.CommonPortionSizeUnit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository for Common portion size units
 */
public interface CommonPortionSizeUnitRepository extends JpaRepository<CommonPortionSizeUnit, Long> {

   Optional<CommonPortionSizeUnit> findCommonPortionSizeUnitByUnit(String unit);
   Optional<CommonPortionSizeUnit> findCommonPortionSizeUnitById(Long Id);


}
