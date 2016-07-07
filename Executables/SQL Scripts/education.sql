-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema education
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema education
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `education` DEFAULT CHARACTER SET latin1 ;
USE `education` ;

-- -----------------------------------------------------
-- Table `education`.`country_class`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `education`.`country_class` (
  `country` VARCHAR(50) NOT NULL,
  `rank` INT(11) NULL DEFAULT '0',
  PRIMARY KEY (`country`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `education`.`country_code`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `education`.`country_code` (
  `country` VARCHAR(100) NOT NULL,
  `code` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`country`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `education`.`country_gdp`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `education`.`country_gdp` (
  `country` VARCHAR(40) NOT NULL,
  `year` VARCHAR(5) NOT NULL,
  `val` FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (`country`, `year`),
  CONSTRAINT `country`
    FOREIGN KEY (`country`)
    REFERENCES `education`.`country_code` (`country`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
