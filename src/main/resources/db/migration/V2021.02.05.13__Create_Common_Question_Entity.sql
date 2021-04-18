CREATE TABLE IF NOT EXISTS `common_question`
(
    `id`         INT          NOT NULL AUTO_INCREMENT,
    `question`   VARCHAR(256) NOT NULL,
    `answer`     VARCHAR(512) NOT NULL,
    `created_on` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_on` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `common_question_id_UNIQUE` (`id` ASC) VISIBLE)
    ENGINE = InnoDB;
