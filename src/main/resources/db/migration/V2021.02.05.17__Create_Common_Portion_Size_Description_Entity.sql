CREATE TABLE IF NOT EXISTS `common_portion_size_description`
(
    `id`          INT          NOT NULL AUTO_INCREMENT,
    `created_on`  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_on`  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `description` VARCHAR(256) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
    ENGINE = InnoDB;
