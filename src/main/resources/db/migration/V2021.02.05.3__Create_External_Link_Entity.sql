CREATE TABLE IF NOT EXISTS `external_link`
(
    `id` INT NOT NULL AUTO_INCREMENT,
    `external_link` VARCHAR(512) NOT NULL,
    `created_on` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_on` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `question_link_id_UNIQUE` (`id` ASC) VISIBLE,
    UNIQUE INDEX `question_linkcol_UNIQUE` (`external_link` ASC) VISIBLE)
    ENGINE = InnoDB;
