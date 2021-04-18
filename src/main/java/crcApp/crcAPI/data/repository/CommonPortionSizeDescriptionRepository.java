package crcApp.crcAPI.data.repository;

import crcApp.crcAPI.data.model.CommonPortionSizeDescription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository for Common portion size descriptions
 */
public interface CommonPortionSizeDescriptionRepository extends JpaRepository<CommonPortionSizeDescription, Long> {

    Optional<CommonPortionSizeDescription> findCommonPortionSizeDescriptionByDescription(String description);
    Optional<CommonPortionSizeDescription> findCommonPortionSizeDescriptionById(Long id);


}
