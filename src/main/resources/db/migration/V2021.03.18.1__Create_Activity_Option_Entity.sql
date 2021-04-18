CREATE TABLE IF NOT EXISTS `activity_option`
(
    `id` INT NOT NULL AUTO_INCREMENT,
    `type` VARCHAR(64) NOT NULL,
    `intensity` INT NOT NULL,
    `coefficient` DECIMAL(10,4),
    `is_visible` TINYINT NULL DEFAULT true,
    `created_on` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_on` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
    ENGINE = InnoDB;
