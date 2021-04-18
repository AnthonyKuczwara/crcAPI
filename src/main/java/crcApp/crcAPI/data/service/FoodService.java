package crcApp.crcAPI.data.service;

import crcApp.crcAPI.data.model.CommonPortionSizeDescription;
import crcApp.crcAPI.data.model.CommonPortionSizeUnit;
import crcApp.crcAPI.data.model.NccFoodGroupCategory;
import crcApp.crcAPI.data.repository.CommonPortionSizeDescriptionRepository;
import crcApp.crcAPI.data.repository.CommonPortionSizeUnitRepository;
import crcApp.crcAPI.data.repository.FoodLogEntryRepository;
import crcApp.crcAPI.data.repository.NccFoodGroupCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FoodService {

    private static CommonPortionSizeDescriptionRepository commonPortionSizeDescriptionRepository;
    private static CommonPortionSizeUnitRepository commonPortionSizeUnitRepository;
    private static NccFoodGroupCategoryRepository nccFoodGroupCategoryRepository;
    //    private static NccFoodGroupCategoryRepository nccFoodGroupCategoryRepository;
    private final FoodLogEntryRepository foodLogEntryRepository;
//    private final NccFoodGroupCategoryRepository nccFoodGroupCategoryRepository;
//    private final CommonPortionSizeDescriptionRepository commonPortionSizeDescriptionRepository;
//    private final CommonPortionSizeUnitRepository commonPortionSizeUnitRepository;

    public FoodService(FoodLogEntryRepository foodLogEntryRepository, CommonPortionSizeDescriptionRepository commonPortionSizeDescriptionRepository, CommonPortionSizeUnitRepository commonPortionSizeUnitRepository, NccFoodGroupCategoryRepository nccFoodGroupCategoryRepository) {
        this.foodLogEntryRepository = foodLogEntryRepository;
        this.commonPortionSizeDescriptionRepository = commonPortionSizeDescriptionRepository;
        this.commonPortionSizeUnitRepository = commonPortionSizeUnitRepository;
        this.nccFoodGroupCategoryRepository = nccFoodGroupCategoryRepository;
    }

    public static String getCommonPortionSizeDescription(Long commonPortionSizeDescriptionId) {
        Optional<CommonPortionSizeDescription> optionalCommonPortionSizeDescription = commonPortionSizeDescriptionRepository.findCommonPortionSizeDescriptionById(commonPortionSizeDescriptionId);
        if(optionalCommonPortionSizeDescription.isPresent()) {
            return optionalCommonPortionSizeDescription.get().getDescription();
        }
        return "";
    }

    public static String getCommonPortionSizeUnit(Long commonPortionSizeUnitId) {
        Optional<CommonPortionSizeUnit> optionalCommonPortionSizeUnit = commonPortionSizeUnitRepository.findCommonPortionSizeUnitById(commonPortionSizeUnitId);
        if(optionalCommonPortionSizeUnit.isPresent()) {
            return optionalCommonPortionSizeUnit.get().getUnit();
        }
        return "";
    }

    public static String getNccFoodGroupCategory(Long nccFoodGroupCategoryId) {
        Optional<NccFoodGroupCategory> optionalNccFoodGroupCategory = nccFoodGroupCategoryRepository.findNccFoodGroupCategoryById(nccFoodGroupCategoryId);
        if(optionalNccFoodGroupCategory.isPresent()) {
            return optionalNccFoodGroupCategory.get().getCategory();
        }
        return "";
    }




}
