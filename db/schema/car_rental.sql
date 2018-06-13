-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.7.22 - MySQL Community Server (GPL)
-- ОС Сервера:                   Linux
-- HeidiSQL Версия:              9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Дамп структуры базы данных car_rental
CREATE DATABASE IF NOT EXISTS `car_rental` /*!40100 DEFAULT CHARACTER SET utf16 */;
USE `car_rental`;


-- Дамп структуры для таблица car_rental.CUSTOMER
CREATE TABLE IF NOT EXISTS `CUSTOMER` (
  `ID_CUSTOMER` int(11) NOT NULL,
  `DESCR` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_CUSTOMER`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица car_rental.HISTORY
CREATE TABLE IF NOT EXISTS `HISTORY` (
  `ID_HISTORY` int(11) NOT NULL AUTO_INCREMENT,
  `ID_TABLE` int(11) NOT NULL,
  `ACTION` enum('CREATE','DELETE','CHANGE') NOT NULL,
  `CREATE_AT` datetime NOT NULL,
  `CREATE_BY` int(11) NOT NULL,
  `FIELD` varchar(50) NOT NULL,
  `VAL_FROM` varchar(50) NOT NULL,
  `VAL_TO` varchar(50) NOT NULL,
  `ID_RECORD` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_HISTORY`),
  KEY `HISTORY_FK_USER_BY` (`CREATE_BY`),
  KEY `HISTORY_INDEX_REC_TAB` (`ID_TABLE`,`ID_RECORD`),
  KEY `HISTORY_INDEX_RECORD` (`ID_RECORD`),
  CONSTRAINT `HISTORY_FK_USER_BY` FOREIGN KEY (`CREATE_BY`) REFERENCES `USER` (`ID_USER`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица car_rental.RENTAL
CREATE TABLE IF NOT EXISTS `RENTAL` (
  `ID_RENTAL` int(11) NOT NULL,
  `ID_CUSTOMER` int(11) NOT NULL,
  `ID_VEHICLE` varchar(255) NOT NULL,
  `RENTAL_START` datetime DEFAULT NULL,
  `RENTAL_END` varchar(255) DEFAULT NULL,
  `NOTES` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_RENTAL`),
  KEY `RENTAL_FK_CUSTOMER` (`ID_CUSTOMER`),
  CONSTRAINT `RENTAL_FK_CUSTOMER` FOREIGN KEY (`ID_CUSTOMER`) REFERENCES `CUSTOMER` (`ID_CUSTOMER`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица car_rental.RENTAL_POINT
CREATE TABLE IF NOT EXISTS `RENTAL_POINT` (
  `ID_RENTAL_POINT` int(11) NOT NULL,
  `ADDRESS` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_RENTAL_POINT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица car_rental.USER
CREATE TABLE IF NOT EXISTS `USER` (
  `ID_USER` int(11) NOT NULL,
  `DESCR` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_USER`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица car_rental.VEHICLE
CREATE TABLE IF NOT EXISTS `VEHICLE` (
  `ID_VEHICLE` int(10) NOT NULL,
  `REG_NUM` varchar(255) NOT NULL,
  `ID_VEHICLE_TYPE` int(11) NOT NULL,
  `ID_VEHICLE_MODEL` int(11) NOT NULL,
  `RENTAL_POINT` int(10) NOT NULL,
  `LAST_RENTAL` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_VEHICLE`),
  KEY `VEHICLE_FK_TYPE` (`ID_VEHICLE_TYPE`),
  KEY `VEHICLE_FK_MODEL` (`ID_VEHICLE_MODEL`),
  KEY `VEHICLE_FK_RENTAL_POINT` (`RENTAL_POINT`),
  KEY `VEHICLE_FK_LAST_RENTAL` (`LAST_RENTAL`),
  CONSTRAINT `VEHICLE_FK_LAST_RENTAL` FOREIGN KEY (`LAST_RENTAL`) REFERENCES `RENTAL` (`ID_RENTAL`),
  CONSTRAINT `VEHICLE_FK_MODEL` FOREIGN KEY (`ID_VEHICLE_MODEL`) REFERENCES `VEHICLE_MODEL` (`ID_VEHICLE_MODEL`),
  CONSTRAINT `VEHICLE_FK_RENTAL_POINT` FOREIGN KEY (`RENTAL_POINT`) REFERENCES `RENTAL_POINT` (`ID_RENTAL_POINT`),
  CONSTRAINT `VEHICLE_FK_TYPE` FOREIGN KEY (`ID_VEHICLE_TYPE`) REFERENCES `VEHICLE_TYPE` (`ID_VEHICLE_TYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица car_rental.VEHICLE_MODEL
CREATE TABLE IF NOT EXISTS `VEHICLE_MODEL` (
  `ID_VEHICLE_MODEL` int(11) NOT NULL,
  `DESCR` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_VEHICLE_MODEL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица car_rental.VEHICLE_TYPE
CREATE TABLE IF NOT EXISTS `VEHICLE_TYPE` (
  `ID_VEHICLE_TYPE` int(11) NOT NULL,
  `DESCR` varchar(255) NOT NULL,
  PRIMARY KEY (`ID_VEHICLE_TYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

-- Экспортируемые данные не выделены.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
