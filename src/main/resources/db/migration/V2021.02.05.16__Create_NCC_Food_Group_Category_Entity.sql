CREATE TABLE IF NOT EXISTS `ncc_food_group_category`
(
    `id` INT NOT NULL AUTO_INCREMENT,
    `category` VARCHAR(128) NOT NULL,
    `created_on` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_on` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `category_UNIQUE` (`category` ASC) VISIBLE,
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
    ENGINE = InnoDB;