-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema cadastrodepartamentos
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cadastrodepartamentos
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cadastrodepartamentos` DEFAULT CHARACTER SET utf8 ;
USE `cadastrodepartamentos` ;

-- -----------------------------------------------------
-- Table `cadastrodepartamentos`.`departamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cadastrodepartamentos`.`departamento` (
  `idDepartamento` INT NOT NULL AUTO_INCREMENT,
  `nomeDepartamento` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idDepartamento`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cadastrodepartamentos`.`funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cadastrodepartamentos`.`funcionario` (
  `idFuncionario` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `cpf` VARCHAR(45) NOT NULL,
  `rg` VARCHAR(45) NULL DEFAULT NULL,
  `dataNascimento` DATE NOT NULL,
  `departamento_idDepartamento1` INT NOT NULL,
  PRIMARY KEY (`idFuncionario`),
  INDEX `fk_funcionario_departamento1_idx` (`departamento_idDepartamento1` ASC) VISIBLE,
  CONSTRAINT `fk_funcionario_departamento1`
    FOREIGN KEY (`departamento_idDepartamento1`)
    REFERENCES `cadastrodepartamentos`.`departamento` (`idDepartamento`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
