-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema starbucks
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema starbucks
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `starbucks` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema starbucks
-- -----------------------------------------------------
USE `starbucks` ;

-- -----------------------------------------------------
-- Table `starbucks`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `starbucks`.`products` (
                                                 `id` INT NOT NULL AUTO_INCREMENT,
                                                 `name` VARCHAR(100) NOT NULL,
    `price` DOUBLE NOT NULL,
    `description` VARCHAR(500) NOT NULL,
    `region` VARCHAR(45) NOT NULL,
    `weight` INT NOT NULL,
    `category` VARCHAR(45) NOT NULL,
    `roastLevel` INT NOT NULL,
    `imageUrl` VARCHAR(1000) NOT NULL,
    `stock` INT NOT NULL,
    `roast` VARCHAR(45) NOT NULL,
    `caffeine` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `starbucks`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `starbucks`.`users` (
                                              `id` INT NOT NULL AUTO_INCREMENT,
                                              `username` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `starbucks`.`orders`

-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `starbucks`.`orders` (
                                                    `id` VARCHAR(100) NOT NULL,
                                                    `userId` INT NOT NULL,
                                                    `orderDate` DATETIME NOT NULL,
                                                    `status` VARCHAR(45) NOT NULL,
    `totalPrice` DOUBLE NOT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE = InnoDB;

-- Table `starbucks`.`order_items`
CREATE TABLE IF NOT EXISTS `starbucks`.`orderItems` (
                                                        `id` VARCHAR(100) NOT NULL,
    `productId` INT NOT NULL,
    `quantity` INT NOT NULL,
    `userId` INT NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_order_items_products`
    FOREIGN KEY (`productId`)
    REFERENCES `starbucks`.`products` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    ) ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
