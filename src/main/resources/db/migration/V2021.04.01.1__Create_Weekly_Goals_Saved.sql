CREATE TABLE IF NOT EXISTS `weekly_goals_saved`
(
    `id` INT NOT NULL AUTO_INCREMENT,
    `type` VARCHAR(64) NOT NULL,
    `goal_description` VARCHAR(280) NOT NULL,
    `help_info` VARCHAR(280) NOT NULL,
    `user_id` INT NOT NULL,
    `created_on` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_on` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
    INDEX `fk_weekly_goals_saved_user1_idx` (`user_id` ASC) VISIBLE,
    CONSTRAINT `fk_weekly_goals_saved_user1`
        FOREIGN KEY (`user_id`)
            REFERENCES `health_app`.`user` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION)
    ENGINE = InnoDB
