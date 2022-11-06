-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema golfingdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `golfingdb` ;

-- -----------------------------------------------------
-- Schema golfingdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `golfingdb` DEFAULT CHARACTER SET utf8 ;
USE `golfingdb` ;

-- -----------------------------------------------------
-- Table `player`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `player` ;

CREATE TABLE IF NOT EXISTS `player` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `state` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `course`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `course` ;

CREATE TABLE IF NOT EXISTS `course` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `state` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `round`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `round` ;

CREATE TABLE IF NOT EXISTS `round` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `player_id` INT NOT NULL,
  `course_id` INT NOT NULL,
  `holes_played` INT NOT NULL,
  `num_players` INT NULL,
  `score` INT NOT NULL,
  INDEX `fk_player_has_course_course1_idx` (`course_id` ASC),
  INDEX `fk_player_has_course_player_idx` (`player_id` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_player_has_course_player`
    FOREIGN KEY (`player_id`)
    REFERENCES `player` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_player_has_course_course1`
    FOREIGN KEY (`course_id`)
    REFERENCES `course` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS golfingadmin@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'golfingadmin'@'localhost' IDENTIFIED BY 'golfingadmin';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'golfingadmin'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `player`
-- -----------------------------------------------------
START TRANSACTION;
USE `golfingdb`;
INSERT INTO `player` (`id`, `first_name`, `last_name`, `city`, `state`) VALUES (1, 'Ruben', 'Rocha', 'Denver', 'CO');
INSERT INTO `player` (`id`, `first_name`, `last_name`, `city`, `state`) VALUES (2, 'Josh', 'Covington', 'Denver', 'CO');
INSERT INTO `player` (`id`, `first_name`, `last_name`, `city`, `state`) VALUES (3, 'Matthew', 'Jacobo', 'Midland', 'TX');
INSERT INTO `player` (`id`, `first_name`, `last_name`, `city`, `state`) VALUES (4, 'Ray ', 'Riordan', 'Morro Bay', 'CA');

COMMIT;


-- -----------------------------------------------------
-- Data for table `course`
-- -----------------------------------------------------
START TRANSACTION;
USE `golfingdb`;
INSERT INTO `course` (`id`, `name`, `city`, `state`) VALUES (1, 'City Park', 'Denver ', 'CO');
INSERT INTO `course` (`id`, `name`, `city`, `state`) VALUES (2, 'Green Valley Ranch', 'Denver', 'CO');
INSERT INTO `course` (`id`, `name`, `city`, `state`) VALUES (3, 'Green Tree Country Club', 'Midland', 'TX');
INSERT INTO `course` (`id`, `name`, `city`, `state`) VALUES (4, 'Pebble Beach', 'Monterey', 'CA');
INSERT INTO `course` (`id`, `name`, `city`, `state`) VALUES (5, 'Torry Pines', 'La Jolla', 'CA');

COMMIT;


-- -----------------------------------------------------
-- Data for table `round`
-- -----------------------------------------------------
START TRANSACTION;
USE `golfingdb`;
INSERT INTO `round` (`id`, `player_id`, `course_id`, `holes_played`, `num_players`, `score`) VALUES (DEFAULT, 1, 1, 18, 4, 90);
INSERT INTO `round` (`id`, `player_id`, `course_id`, `holes_played`, `num_players`, `score`) VALUES (DEFAULT, 1, 2, 18, 4, 88);
INSERT INTO `round` (`id`, `player_id`, `course_id`, `holes_played`, `num_players`, `score`) VALUES (DEFAULT, 2, 1, 18, 3, 91);
INSERT INTO `round` (`id`, `player_id`, `course_id`, `holes_played`, `num_players`, `score`) VALUES (DEFAULT, 2, 2, 18, 4, 90);
INSERT INTO `round` (`id`, `player_id`, `course_id`, `holes_played`, `num_players`, `score`) VALUES (DEFAULT, 3, 3, 18, 2, 88);
INSERT INTO `round` (`id`, `player_id`, `course_id`, `holes_played`, `num_players`, `score`) VALUES (DEFAULT, 3, 4, 9, 4, 105);

COMMIT;

