-- MySQL Script generated by MySQL Workbench
-- 2016年07月01日 星期五 23时02分40秒
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema homework
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema homework
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `homework` DEFAULT CHARACTER SET utf8 ;
USE `homework` ;

-- -----------------------------------------------------
-- Table `homework`.`student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `homework`.`student` (
  `student_id` VARCHAR(20) NOT NULL,
  `student_name` VARCHAR(45) NOT NULL,
  `is_cicos` CHAR(1) NOT NULL DEFAULT 'n',
  `sex` CHAR(2) NOT NULL DEFAULT '男',
  `university` VARCHAR(45) NOT NULL,
  `department` VARCHAR(45) NOT NULL,
  `class` VARCHAR(45) NOT NULL,
  `entrance` DATE NOT NULL,
  `graduation` DATE NOT NULL,
  PRIMARY KEY (`student_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `homework`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `homework`.`user` (
  `account` VARCHAR(20) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  `is_admin` CHAR(1) NOT NULL DEFAULT 'n',
  `student_id` VARCHAR(20) NOT NULL,
  `student_name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `register_time` VARCHAR(45) NOT NULL,
  `status` CHAR(1) NOT NULL DEFAULT '1',
  `validate_code` CHAR(32) NOT NULL,
  PRIMARY KEY (`account`),
  INDEX `fk_user_student1_idx` (`student_id` ASC),
  CONSTRAINT `fk_user_student1`
    FOREIGN KEY (`student_id`)
    REFERENCES `homework`.`student` (`student_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `homework`.`course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `homework`.`course` (
  `course_id` INT NOT NULL AUTO_INCREMENT,
  `course_name` VARCHAR(45) NOT NULL,
  `student_id` VARCHAR(20) NOT NULL,
  `example_name` VARCHAR(100) NOT NULL,
  `university` VARCHAR(45) NOT NULL,
  `department` VARCHAR(45) NOT NULL,
  `class` VARCHAR(45) NOT NULL,
  `term` DATE NOT NULL,
  `last_time` DATE NOT NULL,
  PRIMARY KEY (`course_id`),
  INDEX `fk_course_student1_idx` (`student_id` ASC),
  CONSTRAINT `fk_course_student1`
    FOREIGN KEY (`student_id`)
    REFERENCES `homework`.`student` (`student_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `homework`.`student_has_course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `homework`.`student_has_course` (
  `student_id` VARCHAR(20) NOT NULL,
  `course_id` INT NOT NULL,
  `file_name` VARCHAR(100) NOT NULL,
  `exp_num` INT NOT NULL,
  `exp_time` DATETIME NOT NULL,
  `exp_path` VARCHAR(160) NOT NULL,
  PRIMARY KEY (`student_id`, `course_id`, `exp_num`),
  INDEX `fk_student_has_course_course1_idx` (`course_id` ASC),
  INDEX `fk_student_has_course_student1_idx` (`student_id` ASC),
  CONSTRAINT `fk_student_has_course_student1`
    FOREIGN KEY (`student_id`)
    REFERENCES `homework`.`student` (`student_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_has_course_course1`
    FOREIGN KEY (`course_id`)
    REFERENCES `homework`.`course` (`course_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
