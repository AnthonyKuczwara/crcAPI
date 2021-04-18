CREATE TABLE IF NOT EXISTS `food_log_entry`
(
    `id` INT NOT NULL AUTO_INCREMENT,
    `created_on` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_on` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `date` DATE NOT NULL,
    `entry_time` DATETIME NOT NULL,
    `portion` DECIMAL(10,4) NOT NULL,
    `user_id` INT NOT NULL,
    `food_id` INT NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
    INDEX `fk_food_log_entry_food1_idx` (`food_id` ASC) VISIBLE,
    INDEX `fk_food_log_entry_user1_idx` (`user_id` ASC) VISIBLE,
    CONSTRAINT `fk_food_log_entry_food1`
        FOREIGN KEY (`food_id`)
            REFERENCES `health_app`.`food` (`id`),
    CONSTRAINT `fk_food_log_entry_user1`
        FOREIGN KEY (`user_id`)
            REFERENCES `health_app`.`user` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION)
    ENGINE = InnoDB
