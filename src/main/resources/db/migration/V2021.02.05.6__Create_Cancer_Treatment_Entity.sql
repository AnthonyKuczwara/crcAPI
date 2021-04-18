CREATE TABLE IF NOT EXISTS `cancer_treatment`
(
    `id` INT NOT NULL AUTO_INCREMENT,
    `created_on` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_on` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `radiation_therapy` TINYINT NOT NULL,
    `chemo_therapy` TINYINT NOT NULL,
    `surgery` TINYINT NOT NULL,
    `ostomy` TINYINT NOT NULL,
    `other` TINYINT NOT NULL,
    `uncertain` TINYINT NOT NULL,
    `user_id` INT NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_cancer_treatment_user1_idx` (`user_id` ASC) VISIBLE,
    CONSTRAINT `fk_cancer_treatment_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `health_app`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;
