CREATE TABLE IF NOT EXISTS `community_post`
(
    `id`         INT          NOT NULL AUTO_INCREMENT,
    `content`    VARCHAR(512) NOT NULL,
    `user_id`    INT          NOT NULL,
    `created_on` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_on` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `post_id_UNIQUE` (`id` ASC) VISIBLE,
    INDEX `fk_post_user1_idx` (`user_id` ASC) VISIBLE,
    CONSTRAINT `fk_post_user1`
        FOREIGN KEY (`user_id`)
            REFERENCES `health_app`.`user` (`id`))
    ENGINE = InnoDB;
