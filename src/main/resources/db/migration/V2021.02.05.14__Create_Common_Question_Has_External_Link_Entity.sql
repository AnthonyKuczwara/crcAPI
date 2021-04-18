CREATE TABLE IF NOT EXISTS `common_question_has_external_link`
(
    `common_question_id` INT NOT NULL,
    `external_link_id`   INT NOT NULL,
    PRIMARY KEY (`common_question_id`, `external_link_id`),
    INDEX `fk_common_question_has_external_link_external_link1_idx` (`external_link_id` ASC) VISIBLE,
    INDEX `fk_common_question_has_external_link_common_question1_idx` (`common_question_id` ASC) VISIBLE,
    CONSTRAINT `fk_common_question_has_external_link_common_question1`
        FOREIGN KEY (`common_question_id`)
            REFERENCES `health_app`.`common_question` (`id`),
    CONSTRAINT `fk_common_question_has_external_link_external_link1`
        FOREIGN KEY (`external_link_id`)
            REFERENCES `health_app`.`external_link` (`id`))
    ENGINE = InnoDB;
