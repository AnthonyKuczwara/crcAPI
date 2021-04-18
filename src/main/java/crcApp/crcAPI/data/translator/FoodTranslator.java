package crcApp.crcAPI.data.translator;


import crcApp.crcAPI.data.model.Food;
import crcApp.crcAPI.data.service.FoodService;
import crcApp.crcAPI.web.models.FoodView;

import java.util.ArrayList;
import java.util.List;

public class FoodTranslator {
    public static FoodView entityToView(final Food food) {
        return FoodView.builder()
                .id(food.getId())
                .baseId(food.getBaseId())
                .description(food.getDescription())
                .keyList(food.getKeylist())
                .kcal(food.getKcal())
                .proteinInGrams(food.getProteinInGrams())
                .fatInGrams(food.getFatInGrams())
                .carbohydratesInGrams(food.getCarbohydratesInGrams())
                .solubleFiberInGrams(food.getSolubleFiberInGrams())
                .insolubleFiberInGrams(food.getInsolubleFiberInGrams())
                .calciumInMilligrams(food.getCalciumInMilligrams())
                .sodiumInMilligrams(food.getSodiumInMilligrams())
                .saturatedFattyAcidsInGrams(food.getSaturatedFattyAcidsInGrams())
                .polyunsaturatedFattyAcidsInGrams(food.getPolyunsaturatedFattyAcidsInGrams())
                .monounsaturatedFattyAcidsInGrams(food.getMonounsaturatedFattyAcidsInGrams())
                .sugarInGrams(food.getSugarInGrams())
                .alcoholInGrams(food.getAlcoholInGrams())
                .vitaminDInMicrograms(food.getVitaminDInMicrograms())
                .commonPortionSizeAmount(food.getCommonPortionSizeAmount())
                .commonPortionSizeGramWeight(food.getCommonPortionSizeGramWeight())
                .commonPortionSizeDescription(FoodService.getCommonPortionSizeDescription(food.getCommonPortionSizeDescriptionId()))
                .commonPortionSizeUnit(FoodService.getCommonPortionSizeUnit(food.getCommonPortionSizeUnitId()))
                .nccFoodGroupCategory(FoodService.getNccFoodGroupCategory(food.getNccFoodGroupCategoryId()))
                .build();
    }

    public static List<FoodView> entitiesToViews(final List<Food> foods) {
        ArrayList<FoodView> foodViews = new ArrayList<>();
        for(Food food: foods) {
            foodViews.add(
                    FoodView.builder()
                            .id(food.getId())
                            .baseId(food.getBaseId())
                            .description(food.getDescription())
                            .keyList(food.getKeylist())
                            .kcal(food.getKcal())
                            .proteinInGrams(food.getProteinInGrams())
                            .fatInGrams(food.getFatInGrams())
                            .carbohydratesInGrams(food.getCarbohydratesInGrams())
                            .solubleFiberInGrams(food.getSolubleFiberInGrams())
                            .insolubleFiberInGrams(food.getInsolubleFiberInGrams())
                            .calciumInMilligrams(food.getCalciumInMilligrams())
                            .sodiumInMilligrams(food.getSodiumInMilligrams())
                            .saturatedFattyAcidsInGrams(food.getSaturatedFattyAcidsInGrams())
                            .polyunsaturatedFattyAcidsInGrams(food.getPolyunsaturatedFattyAcidsInGrams())
                            .monounsaturatedFattyAcidsInGrams(food.getMonounsaturatedFattyAcidsInGrams())
                            .sugarInGrams(food.getSugarInGrams())
                            .alcoholInGrams(food.getAlcoholInGrams())
                            .vitaminDInMicrograms(food.getVitaminDInMicrograms())
                            .commonPortionSizeAmount(food.getCommonPortionSizeAmount())
                            .commonPortionSizeGramWeight(food.getCommonPortionSizeGramWeight())
                            .commonPortionSizeDescription(FoodService.getCommonPortionSizeDescription(food.getCommonPortionSizeDescriptionId()))
                            .commonPortionSizeUnit(FoodService.getCommonPortionSizeUnit(food.getCommonPortionSizeUnitId()))
                            .nccFoodGroupCategory(FoodService.getNccFoodGroupCategory(food.getNccFoodGroupCategoryId()))
                            .build()
            );
        }
        return foodViews;
    }


}
