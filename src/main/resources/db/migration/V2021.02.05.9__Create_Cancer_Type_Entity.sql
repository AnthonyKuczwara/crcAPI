CREATE TABLE IF NOT EXISTS `cancer_type`
(
    `id`          INT         NOT NULL AUTO_INCREMENT,
    `cancer_name` VARCHAR(64) NOT NULL,
    `created_on`  DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_on`  DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `cancer_type_id_UNIQUE` (`id` ASC) VISIBLE,
    UNIQUE INDEX `cancer_name_UNIQUE` (`cancer_name` ASC) VISIBLE)
    ENGINE = InnoDB;
