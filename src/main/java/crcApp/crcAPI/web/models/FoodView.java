package crcApp.crcAPI.web.models;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class FoodView {

    private Long id;

    private Integer baseId;

    private String description;

    private String keyList;

    private Double kcal;

    private Double proteinInGrams;

    private Double fatInGrams;

    private Double carbohydratesInGrams;

    private Double fiberInGrams;

    private Double solubleFiberInGrams;

    private Double insolubleFiberInGrams;

    private Double calciumInMilligrams;

    private Double sodiumInMilligrams;

    private Double saturatedFattyAcidsInGrams;

    private Double polyunsaturatedFattyAcidsInGrams;

    private Double monounsaturatedFattyAcidsInGrams;

    private Double sugarInGrams;

    private Double alcoholInGrams;

    private Double vitaminDInMicrograms;

    private Double commonPortionSizeAmount;

    private Double commonPortionSizeGramWeight;

    private String commonPortionSizeDescription;

    private String commonPortionSizeUnit;

    private String nccFoodGroupCategory;


}
