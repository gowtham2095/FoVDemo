-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema public-cash
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema public-cash
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `public-cash` DEFAULT CHARACTER SET latin1 ;
USE `public-cash` ;

-- -----------------------------------------------------
-- Table `public-cash`.`country_class`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `public-cash`.`country_class` (
  `country` VARCHAR(50) NOT NULL,
  `rank` INT(11) NULL DEFAULT '0',
  PRIMARY KEY (`country`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `public-cash`.`country_code`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `public-cash`.`country_code` (
  `country` VARCHAR(50) NOT NULL,
  `code` VARCHAR(6) NULL DEFAULT NULL,
  PRIMARY KEY (`country`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `public-cash`.`country_gdp`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `public-cash`.`country_gdp` (
  `country` VARCHAR(50) NOT NULL,
  `year` VARCHAR(10) NOT NULL,
  `val` FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (`country`, `year`),
  CONSTRAINT `country`
    FOREIGN KEY (`country`)
    REFERENCES `public-cash`.`country_code` (`country`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
