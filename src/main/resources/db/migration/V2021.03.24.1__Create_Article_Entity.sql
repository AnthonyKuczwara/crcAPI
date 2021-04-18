CREATE TABLE IF NOT EXISTS `article`
(
    `id` INT NOT NULL AUTO_INCREMENT,
    `article_name` VARCHAR(128),
    `article_author` VARCHAR(128),
    `article_subject` VARCHAR(128),
    `article_type` VARCHAR(128),
    `data` MEDIUMBLOB,
    `is_visible` TINYINT NULL DEFAULT true,
    `created_on` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_on` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
    ENGINE = InnoDB;
