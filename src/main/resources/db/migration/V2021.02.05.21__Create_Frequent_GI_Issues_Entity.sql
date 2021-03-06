CREATE TABLE IF NOT EXISTS `frequent_gi_issues`
(
    `id` INT NOT NULL AUTO_INCREMENT,
    `issue` VARCHAR(64) NOT NULL,
    `created_on` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_on` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
    UNIQUE INDEX `issue_UNIQUE` (`issue` ASC) VISIBLE)
    ENGINE = InnoDB;
