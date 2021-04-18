package crcApp.crcAPI.data.service;

import crcApp.crcAPI.data.model.Food;
import crcApp.crcAPI.data.repository.FoodLogEntryRepository;
import crcApp.crcAPI.data.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FoodLogEntryService {


    private static FoodRepository foodRepository;
    private final FoodLogEntryRepository foodLogEntryRepository;

    public FoodLogEntryService(FoodLogEntryRepository foodLogEntryRepository, FoodRepository foodRepository) {
        this.foodLogEntryRepository = foodLogEntryRepository;
        this.foodRepository = foodRepository;
    }


    public static Food getFood(Long id) {
        Optional<Food> optionalFood = foodRepository.findFoodById(id);
        if (optionalFood.isPresent()) {
            return optionalFood.get();
        }
        return null;
    }

}
