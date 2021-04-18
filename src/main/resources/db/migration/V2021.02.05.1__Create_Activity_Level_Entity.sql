CREATE TABLE IF NOT EXISTS `activity_level`
(
    `id` INT NOT NULL AUTO_INCREMENT,
    `level` VARCHAR(32) NOT NULL,
    `created_on` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_on` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
    UNIQUE INDEX `level_UNIQUE` (`level` ASC) VISIBLE)
    ENGINE = InnoDB;
