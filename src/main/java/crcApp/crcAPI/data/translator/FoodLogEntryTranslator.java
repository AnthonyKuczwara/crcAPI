package crcApp.crcAPI.data.translator;


import crcApp.crcAPI.data.model.FoodLogEntry;
import crcApp.crcAPI.data.service.FoodLogEntryService;
import crcApp.crcAPI.web.models.FoodLogEntryView;

import java.util.ArrayList;
import java.util.List;

public class FoodLogEntryTranslator {
    public static FoodLogEntryView entityToView(final FoodLogEntry foodLogEntry) {
        return FoodLogEntryView.builder()
                .id(foodLogEntry.getId())
                .date(foodLogEntry.getDate())
                .entryTime(foodLogEntry.getEntryTime().toString())
                .portion(foodLogEntry.getPortion())
                .food(FoodTranslator.entityToView(FoodLogEntryService.getFood(foodLogEntry.getFoodId())))
                .build();
    }

    public static List<FoodLogEntryView> entitiesToViews(final List<FoodLogEntry> foodLogEntryList) {
        ArrayList<FoodLogEntryView> foodLogEntryViews = new ArrayList<>();
        for (FoodLogEntry foodLogEntry : foodLogEntryList) {
            foodLogEntryViews.add(
                    FoodLogEntryView.builder()
                            .id(foodLogEntry.getId())
                            .date(foodLogEntry.getDate())
                            .entryTime(foodLogEntry.getEntryTime().toString())
                            .portion(foodLogEntry.getPortion())
                            .food(FoodTranslator.entityToView(FoodLogEntryService.getFood(foodLogEntry.getFoodId())))
                            .build()
            );
        }
        return foodLogEntryViews;
    }


}
