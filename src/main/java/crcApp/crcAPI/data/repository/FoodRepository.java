package crcApp.crcAPI.data.repository;

import crcApp.crcAPI.data.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for Food
 */
public interface FoodRepository extends JpaRepository<Food, Long> {

    Optional<Food> findFoodByBaseIdAndCommonPortionSizeUnitId(Integer baseId, Long commonPortionSizeUnitId);
    Optional<Food> findFoodById(Long id);
    List<Food> findFoodByDescription(String description);
    List<Food> findFoodByDescriptionContaining(String description);
    List<Food> findAll();



}
