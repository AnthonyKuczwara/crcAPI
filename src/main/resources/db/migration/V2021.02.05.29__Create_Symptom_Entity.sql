CREATE TABLE IF NOT EXISTS `symptom`
(
    `id` INT NOT NULL AUTO_INCREMENT,
    `user_id` INT NOT NULL,
    `abdominal_pain` TINYINT NOT NULL,
    `bloating` TINYINT NOT NULL,
    `nausea` TINYINT NOT NULL,
    `vomiting` TINYINT NOT NULL,
    `constipation` TINYINT NOT NULL,
    `diarrhea` TINYINT NOT NULL,
    `appetite_loss` TINYINT NOT NULL,
    `stoma_problems` TINYINT NOT NULL,
    `other` VARCHAR(257),
    `date_time` DATETIME NOT NULL,
    `created_on` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_on` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
    ENGINE = InnoDB;
