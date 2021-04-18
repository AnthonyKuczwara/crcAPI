CREATE TABLE IF NOT EXISTS `user`
(
    `id` INT NOT NULL AUTO_INCREMENT,
    `email` VARCHAR(128) NOT NULL,
    `username` VARCHAR(64) NULL DEFAULT NULL,
    `password` VARCHAR(64) NOT NULL,
    `first_name` VARCHAR(64) NULL DEFAULT NULL,
    `last_name` VARCHAR(64) NULL DEFAULT NULL,
    `avatar_id` INT NULL DEFAULT NULL,
    `colorectal` TINYINT NULL DEFAULT NULL,
    `stage` INT NULL DEFAULT NULL,
    `diagnosis_date` DATE NULL DEFAULT NULL,
    `created_on` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_on` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
    `height` INT NULL DEFAULT NULL,
    `weight` INT NULL DEFAULT NULL,
    `fat_percent` INT NULL DEFAULT NULL,
    `protein_percent` INT NULL DEFAULT NULL,
    `carbohydrate_percent` INT NULL DEFAULT NULL,
    `activity_level_id` INT NULL DEFAULT NULL,
    `date_of_birth` DATE NULL DEFAULT NULL,
    `race` VARCHAR(64) NULL DEFAULT NULL,
    `ethnicity` VARCHAR(64) NULL DEFAULT NULL,
    `gender` VARCHAR(32) NULL DEFAULT NULL,
    `screener_completed` TINYINT NULL DEFAULT false,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `iduser_UNIQUE` (`id` ASC) VISIBLE,
    UNIQUE INDEX `user_email_UNIQUE` (`email` ASC) VISIBLE,
    UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,
    INDEX `fk_user_activity_level1_idx` (`activity_level_id` ASC) VISIBLE,
    CONSTRAINT `fk_user_activity_level1`
    FOREIGN KEY (`activity_level_id`)
    REFERENCES `health_app`.`activity_level` (`id`))
    ENGINE = InnoDB;
