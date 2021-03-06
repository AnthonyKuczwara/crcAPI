CREATE TABLE IF NOT EXISTS `article_type`
(
    `id` INT NOT NULL AUTO_INCREMENT,
    `type` VARCHAR(64) NOT NULL,
    `is_visible` TINYINT NULL DEFAULT true,
    `created_on` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_on` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
    ENGINE = InnoDB;



