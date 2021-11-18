-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cadastroDepartamentos` DEFAULT CHARACTER SET utf8 ;
USE `cadastroDepartamentos` ;

-- -----------------------------------------------------
-- Table `cadastroDepartamentos`.`departamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cadastroDepartamentos`.`departamento` (
  `idDepartamento` INT NOT NULL auto_increment,
  `nomeDepartamento` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idDepartamento`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cadastroDepartamentos`.`funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cadastroDepartamentos`.`funcionario` (
  `idFuncionario` INT NOT NULL AUTO_INCREMENT,
  `departamento_idDepartamento` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `cpf` VARCHAR(45) NOT NULL,
  `rg` VARCHAR(45) NULL,
  `dataNascimento` DATE NOT NULL,
  `funcionariocol` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idFuncionario`))
ENGINE = InnoDB;

CREATE INDEX `fk_funcionario_departamento_idx` ON `mydb`.`funcionario` (`departamento_idDepartamento` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `cadastroDepartamentos`.`servico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cadastroDepartamentos`.`servico` (
  `idServico` INT NOT NULL auto_increment,
  `departamento_idDepartamento` INT NOT NULL ,
  `nomeServico` VARCHAR(45) NOT NULL,
  `horasDeServico` INT NOT NULL,
  `preco` DOUBLE NOT NULL,
  PRIMARY KEY (`idServico`))
ENGINE = InnoDB;

CREATE INDEX `fk_servico_departamento1_idx` ON `cadastroDepartamentos`.`servico` (`departamento_idDepartamento` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

Alter table funcionario drop funcionariocol;


select   funcionario.*  from funcionario;

select   funcionario.*  from funcionario where nome =  'felipe';


drop table servico;

insert into departamento (nomeDepartamento) values
("Vendas");

insert into servico (departamento_idDepartamento, nomeServico, horasDeServico, preco) values
(1, "Venda", 13, 2.40);


insert into funcionario (departamento_idDepartamento, nome, cpf, rg, dataNascimento) values
(1, "Felipe", "123.456.789.00", "1.234.567", "2021/10/10");

insert into funcionario (departamento_idDepartamento, nome, cpf, rg, dataNascimento) values
(1, "Beatriz", "123.456.789.00", "1.234.567", "2021/10/10");
