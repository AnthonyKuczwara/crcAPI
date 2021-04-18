# CREATE TABLE IF NOT EXISTS `administrator`
# (
#     `id`         INT          NOT NULL AUTO_INCREMENT,
#     `email`      VARCHAR(128) NOT NULL,
#     `password`   VARCHAR(32)  NOT NULL,
#     `first_name` VARCHAR(32)  NOT NULL,
#     `last_name`  VARCHAR(32)  NOT NULL,
#     `level`      INT          NOT NULL,
#     `created_on` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
#     `updated_on` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
#     PRIMARY KEY (`id`),
#     UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE
# )
#     ENGINE = InnoDB;
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `administrator`
(
    `id`       BIGINT       NOT NULL AUTO_INCREMENT,
    `email`    VARCHAR(50)  NULL DEFAULT NULL,
    `password` VARCHAR(120) NULL DEFAULT NULL,
    `username` VARCHAR(20)  NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `UKesogmqxeek1uwdyhxvubme3qf` (`username` ASC) VISIBLE,
    UNIQUE INDEX `UKjj3mmcc0vjobqibj67dvuwihk` (`email` ASC) VISIBLE
)
    ENGINE = MyISAM
    AUTO_INCREMENT = 1
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `testdb`.`administrator_roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `administrator_roles`
(
    `user_id` BIGINT NOT NULL,
    `role_id` INT    NOT NULL,
    PRIMARY KEY (`user_id`, `role_id`),
    INDEX `FKob80dxhvlo1t39hygqiw9yg6u` (`role_id` ASC) VISIBLE
)
    ENGINE = MyISAM
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `testdb`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `roles`
(
    `id`   INT         NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(20) NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = MyISAM
    AUTO_INCREMENT = 1
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;

INSERT INTO roles(name) VALUES('ROLE_BASE');
INSERT INTO roles(name) VALUES('ROLE_SUPER');
INSERT INTO roles(name) VALUES('ROLE_MASTER');
