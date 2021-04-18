CREATE TABLE IF NOT EXISTS `user_has_frequent_gi_issues`
(
    `user_id`               INT NOT NULL,
    `frequent_gi_issues_id` INT NOT NULL,
    PRIMARY KEY (`user_id`, `frequent_gi_issues_id`),
    INDEX `fk_user_has_frequent_gi_issues_frequent_gi_issues1_idx` (`frequent_gi_issues_id` ASC) VISIBLE,
    INDEX `fk_user_has_frequent_gi_issues_user1_idx` (`user_id` ASC) VISIBLE,
    CONSTRAINT `fk_user_has_frequent_gi_issues_frequent_gi_issues1`
        FOREIGN KEY (`frequent_gi_issues_id`)
            REFERENCES `health_app`.`frequent_gi_issues` (`id`),
    CONSTRAINT `fk_user_has_frequent_gi_issues_user1`
        FOREIGN KEY (`user_id`)
            REFERENCES `health_app`.`user` (`id`))
    ENGINE = InnoDB;
