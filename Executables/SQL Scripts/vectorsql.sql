-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema vector
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema vector
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `vector` DEFAULT CHARACTER SET latin1 ;
USE `vector` ;

-- -----------------------------------------------------
-- Table `vector`.`country_cluster`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vector`.`country_cluster` (
  `country` VARCHAR(50) NOT NULL,
  `cluster` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`country`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `vector`.`country_vector`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vector`.`country_vector` (
  `country` VARCHAR(50) NOT NULL,
  `health` INT(11) NULL DEFAULT NULL,
  `education` INT(11) NULL DEFAULT NULL,
  `public-cash` INT(11) NULL DEFAULT NULL,
  `public-tax` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`country`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
