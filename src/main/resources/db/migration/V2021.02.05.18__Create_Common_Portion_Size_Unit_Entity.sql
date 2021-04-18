CREATE TABLE IF NOT EXISTS `common_portion_size_unit`
(
    `id`         INT         NOT NULL AUTO_INCREMENT,
    `created_on` DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_on` DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `unit`       VARCHAR(16) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE
)
    ENGINE = InnoDB;
