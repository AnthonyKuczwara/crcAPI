CREATE TABLE IF NOT EXISTS `food`
(
    `id` INT NOT NULL AUTO_INCREMENT,
    `keylist` VARCHAR(64) NOT NULL,
    `description` VARCHAR(256) NOT NULL,
    `food_type` VARCHAR(2) NOT NULL,
    `ncc_food_group_category_id` INT NOT NULL,
    `kcal` DECIMAL(10,4) NOT NULL,
    `protein_in_grams` DECIMAL(10,4) NOT NULL,
    `fat_in_grams` DECIMAL(10,4) NOT NULL,
    `carbohydrates_in_grams` DECIMAL(10,4) NOT NULL,
    `fiber_in_grams` DECIMAL(10,4) NOT NULL,
    `calcium_in_milligrams` DECIMAL(10,4) NOT NULL,
    `sodium_in_milligrams` DECIMAL(10,4) NOT NULL,
    `saturated_fatty_acids_in_grams` DECIMAL(10,4) NOT NULL,
    `cholesterol_in_milligrams` DECIMAL(10,4) NOT NULL,
    `sugar_in_grams` DECIMAL(10,4) NOT NULL,
    `created_on` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_on` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `base_id` INT NOT NULL,
    `alcohol_in_grams` DECIMAL(10,4) NOT NULL,
    `polyunsaturated_fatty_acids_in_grams` DECIMAL(10,4) NOT NULL,
    `monounsaturated_fatty_acids_in_grams` DECIMAL(10,4) NOT NULL,
    `insoluble_fiber_in_grams` DECIMAL(10,4) NOT NULL,
    `soluble_fiber_in_grams` DECIMAL(10,4) NOT NULL,
    `added_sugars_in_grams` DECIMAL(10,4) NOT NULL,
    `caffeine_in_milligrams` DECIMAL(10,4) NOT NULL,
    `iron_in_milligrams` DECIMAL(10,4) NOT NULL,
    `potassium_in_milligrams` DECIMAL(10,4) NOT NULL,
    `phosphorus_in_milligrams` DECIMAL(10,4) NOT NULL,
    `thiamin_in_milligrams` DECIMAL(10,4) NOT NULL,
    `riboflavin_in_milligrams` DECIMAL(10,4) NOT NULL,
    `niacin_in_milligrams` DECIMAL(10,4) NOT NULL,
    `pantothenic_acid_in_milligrams` DECIMAL(10,4) NOT NULL,
    `vitamin_b6_in_milligrams` DECIMAL(10,4) NOT NULL,
    `vitamin_b12_in_micrograms` DECIMAL(10,4) NOT NULL,
    `vitamin_c_in_milligrams` DECIMAL(10,4) NOT NULL,
    `folate_in_micrograms` DECIMAL(10,4) NOT NULL,
    `vitamin_a_in_international_units` DECIMAL(10,4) NOT NULL,
    `beta_carotene_in_micrograms` DECIMAL(10,4) NOT NULL,
    `lycopene_in_micrograms` DECIMAL(10,4) NOT NULL,
    `vitamin_d_in_micrograms` DECIMAL(10,4) NOT NULL,
    `vitamin_e_in_international_units` DECIMAL(10,4) NOT NULL,
    `common_portion_size_amount` DECIMAL(10,4) NOT NULL,
    `common_portion_size_gram_weight` DECIMAL(10,4) NOT NULL,
    `common_portion_size_description_id` INT NOT NULL,
    `common_portion_size_unit_id` INT NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
    INDEX `fk_food_ncc_food_group_category1_idx` (`ncc_food_group_category_id` ASC) VISIBLE,
    INDEX `fk_food_common_portion_size_description1_idx` (`common_portion_size_description_id` ASC) VISIBLE,
    INDEX `fk_food_common_portion_size_unit1_idx` (`common_portion_size_unit_id` ASC) VISIBLE,
    CONSTRAINT `fk_food_ncc_food_group_category1`
        FOREIGN KEY (`ncc_food_group_category_id`)
            REFERENCES `health_app`.`ncc_food_group_category` (`id`),
    CONSTRAINT `fk_food_common_portion_size_description1`
        FOREIGN KEY (`common_portion_size_description_id`)
            REFERENCES `health_app`.`common_portion_size_description` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_food_common_portion_size_unit1`
        FOREIGN KEY (`common_portion_size_unit_id`)
            REFERENCES `health_app`.`common_portion_size_unit` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION)
    ENGINE = InnoDB;
