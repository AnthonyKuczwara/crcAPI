CREATE TABLE IF NOT EXISTS `comment`
(
    `id`                INT          NOT NULL AUTO_INCREMENT,
    `comment`           VARCHAR(256) NOT NULL,
    `user_id`           INT          NOT NULL,
    `community_post_id` INT          NOT NULL,
    `is_reply`          TINYINT      NOT NULL,
    `created_on`        DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_on`        DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `comment_id_UNIQUE` (`id` ASC) VISIBLE,
    INDEX `fk_comment_user1_idx` (`user_id` ASC) VISIBLE,
    INDEX `fk_comment_post1_idx` (`community_post_id` ASC) VISIBLE,
    CONSTRAINT `fk_comment_post1`
        FOREIGN KEY (`community_post_id`)
            REFERENCES `health_app`.`community_post` (`id`),
    CONSTRAINT `fk_comment_user1`
        FOREIGN KEY (`user_id`)
            REFERENCES `health_app`.`user` (`id`))
    ENGINE = InnoDB;
