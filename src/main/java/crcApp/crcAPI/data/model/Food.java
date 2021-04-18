package crcApp.crcAPI.data.model;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "food")
public class Food extends AbstractEntity {

    @Column(name = "base_id")
    private Integer baseId;

    @Column(name = "keylist")
    private String keylist;

    @Column(name = "description")
    private String description;

    @Column(name = "food_type")
    private String foodType;

    @Column(name = "ncc_food_group_category_id")
    private Long nccFoodGroupCategoryId;

    @Column(name = "kcal")
    private Double kcal;

    @Column(name = "protein_in_grams")
    private Double proteinInGrams;

    @Column(name = "fat_in_grams")
    private Double fatInGrams;

    @Column(name = "carbohydrates_in_grams")
    private Double carbohydratesInGrams;

    @Column(name = "fiber_in_grams")
    private Double fiberInGrams;

    @Column(name = "soluble_fiber_in_grams")
    private Double solubleFiberInGrams;

    @Column(name = "insoluble_fiber_in_grams")
    private Double insolubleFiberInGrams;

    @Column(name = "calcium_in_milligrams")
    private Double calciumInMilligrams;

    @Column(name = "sodium_in_milligrams")
    private Double sodiumInMilligrams;

    @Column(name = "saturated_fatty_acids_in_grams")
    private Double saturatedFattyAcidsInGrams;

    @Column(name = "polyunsaturated_fatty_acids_in_grams")
    private Double polyunsaturatedFattyAcidsInGrams;

    @Column(name = "monounsaturated_fatty_acids_in_grams")
    private Double monounsaturatedFattyAcidsInGrams;

    @Column(name = "cholesterol_in_milligrams")
    private Double cholesterolInMilligrams;

    @Column(name = "sugar_in_grams")
    private Double sugarInGrams;

    @Column(name = "added_sugars_in_grams")
    private Double addedSugarsInGrams;

    @Column(name = "alcohol_in_grams")
    private Double alcoholInGrams;

    @Column(name = "caffeine_in_milligrams")
    private Double caffeineInMilligrams;

    @Column(name = "iron_in_milligrams")
    private Double ironInMilligrams;

    @Column(name = "potassium_in_milligrams")
    private Double potassiumInMilligrams;

    @Column(name = "phosphorus_in_milligrams")
    private Double phosphorusInMilligrams;

    @Column(name = "thiamin_in_milligrams")
    private Double thiaminInMilligrams;

    @Column(name = "riboflavin_in_milligrams")
    private Double riboflavinInMilligrams;

    @Column(name = "niacin_in_milligrams")
    private Double niacinInMilligrams;

    @Column(name = "pantothenic_acid_in_milligrams")
    private Double pantothenicAcidInMilligrams;

    @Column(name = "vitamin_b6_in_milligrams")
    private Double vitaminB6InMilligrams;

    @Column(name = "vitamin_b12_in_micrograms")
    private Double vitaminB12InMicrograms;

    @Column(name = "vitamin_c_in_milligrams")
    private Double vitaminCInMilligrams;

    @Column(name = "folate_in_micrograms")
    private Double folateInMicrograms;

    @Column(name = "vitamin_a_in_international_units")
    private Double vitaminAInInternationalUnits;

    @Column(name = "beta_carotene_in_micrograms")
    private Double betaCaroteneInMicrograms;

    @Column(name = "lycopene_in_micrograms")
    private Double lycopeneInMicrograms;

    @Column(name = "vitamin_d_in_micrograms")
    private Double vitaminDInMicrograms;

    @Column(name = "vitamin_e_in_international_units")
    private Double vitaminEInInternationalUnits;

    @Column(name = "common_portion_size_amount")
    private Double commonPortionSizeAmount;

    @Column(name = "common_portion_size_gram_weight")
    private Double commonPortionSizeGramWeight;

    @Column(name = "common_portion_size_description_id")
    private Long commonPortionSizeDescriptionId;

    @Column(name = "common_portion_size_unit_id")
    private Long commonPortionSizeUnitId;

}

