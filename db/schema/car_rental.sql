-- --------------------------------------------------------
-- Хост:                         localhost
-- Версия сервера:               5.7.22 - MySQL Community Server (GPL)
-- Операционная система:         Linux
-- HeidiSQL Версия:              9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Дамп структуры базы данных car_rental
CREATE DATABASE IF NOT EXISTS `car_rental` /*!40100 DEFAULT CHARACTER SET utf16 */;
USE `car_rental`;

-- Дамп структуры для таблица car_rental.CUSTOMER
CREATE TABLE IF NOT EXISTS `CUSTOMER` (
  `ID_CUSTOMER` int(11) NOT NULL AUTO_INCREMENT,
  `DESCR` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_CUSTOMER`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

-- Дамп данных таблицы car_rental.CUSTOMER: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `CUSTOMER` DISABLE KEYS */;
/*!40000 ALTER TABLE `CUSTOMER` ENABLE KEYS */;

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

-- Дамп данных таблицы car_rental.HISTORY: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `HISTORY` DISABLE KEYS */;
/*!40000 ALTER TABLE `HISTORY` ENABLE KEYS */;

-- Дамп структуры для таблица car_rental.RENTAL
CREATE TABLE IF NOT EXISTS `RENTAL` (
  `ID_RENTAL` int(11) NOT NULL AUTO_INCREMENT,
  `ID_CUSTOMER` int(11) NOT NULL,
  `ID_VEHICLE` int(11) NOT NULL,
  `RENTAL_START` datetime DEFAULT NULL,
  `RENTAL_END` varchar(255) DEFAULT NULL,
  `NOTES` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_RENTAL`),
  KEY `RENTAL_FK_CUSTOMER` (`ID_CUSTOMER`),
  CONSTRAINT `RENTAL_FK_CUSTOMER` FOREIGN KEY (`ID_CUSTOMER`) REFERENCES `CUSTOMER` (`ID_CUSTOMER`),
  CONSTRAINT `RENTAL_FK_VEHICLE` FOREIGN KEY (`ID_VEHICLE`) REFERENCES `VEHICLE` (`ID_VEHICLE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

-- Дамп данных таблицы car_rental.RENTAL: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `RENTAL` DISABLE KEYS */;
/*!40000 ALTER TABLE `RENTAL` ENABLE KEYS */;

-- Дамп структуры для таблица car_rental.RENTAL_POINT
CREATE TABLE IF NOT EXISTS `RENTAL_POINT` (
  `ID_RENTAL_POINT` int(11) NOT NULL AUTO_INCREMENT,
  `ADDRESS` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_RENTAL_POINT`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf16;

-- Дамп данных таблицы car_rental.RENTAL_POINT: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `RENTAL_POINT` DISABLE KEYS */;
INSERT INTO `RENTAL_POINT` (`ID_RENTAL_POINT`, `ADDRESS`) VALUES
	(1, 'Волгоград землячки 110а');
/*!40000 ALTER TABLE `RENTAL_POINT` ENABLE KEYS */;

-- Дамп структуры для таблица car_rental.ROLE
CREATE TABLE IF NOT EXISTS `ROLE` (
  `ID_ROLE` int(11) NOT NULL AUTO_INCREMENT,
  `ROLE` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`ID_ROLE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COMMENT='Роли пользователей';

-- Дамп данных таблицы car_rental.ROLE: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `ROLE` DISABLE KEYS */;
/*!40000 ALTER TABLE `ROLE` ENABLE KEYS */;

-- Дамп структуры для таблица car_rental.USER
CREATE TABLE IF NOT EXISTS `USER` (
  `ID_USER` int(11) NOT NULL AUTO_INCREMENT,
  `DESCR` varchar(255) DEFAULT NULL,
  `NAME` varchar(32) DEFAULT NULL,
  `PASS` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`ID_USER`),
  UNIQUE KEY `NAME` (`NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf16;

-- Дамп данных таблицы car_rental.USER: ~12 rows (приблизительно)
/*!40000 ALTER TABLE `USER` DISABLE KEYS */;
INSERT INTO `USER` (`ID_USER`, `DESCR`, `NAME`, `PASS`) VALUES
	(1, 'Гаранин Алексей Владимирович', 'gaga', '7dd3e2ea3027569e8935f2e317134b1981f1c338f540adbe25525fcc5d3637506faece6cdfcc5f1e'),
	(2, 'Викторов Григорий Юрьевич', 'rotor', '5edb64a058190946112e57d62a416075bc2a636828d13853c9d91ab7f3bd5b5f56784c555f6c705e'),
	(3, 'Карпов Владислав Николаевич', 'repa12', '13ef37cf58c8133d942e3a76200f673189200f42833ad4cbc246fb16af8b83db74e226361621f4cc'),
	(4, 'Гаранин Алексей Владимирович', 'gaga1', 'be14937834ea76e59c61b8d67cce25e5272e911c043ab37f5673d513059502a387834afe7d4be66f'),
	(5, 'Викторов Григорий Юрьевич', 'rotor333', 'bff2f3e632f2310fe917873070721e724806e014630c3df6bddd98c1a52277a4f1d67f0080c9e1be'),
	(6, 'Карпов Владислав Николаевич', 'repa125', '453337c3a6c2c7c6ca6f9be6a9161ab3ec97f349c6162b9576bd759a100a68d3e6f8abe45285c862'),
	(7, 'Гаранин Алексей Владимирович', 'gaga2', '0123456789'),
	(8, 'Викторов Григорий Юрьевич', 'rotor2', 'Fus24q30'),
	(9, 'Карпов Владислав Николаевич', 'repa122', 'Tdfd340Fr'),
	(11, 'Викторов Григорий Юрьевич', 'rotor23', 'Fus24q30'),
	(12, 'Ivanov German', 'repa121', 'Tdfd340Fr'),
	(13, 'Никольский Игорь Варфаломеевич', 'gaga11', '59981ebf181e56f4914b333961efb954e0bf1c160a03762eec4b357acd7a2881c175603602daef62');
/*!40000 ALTER TABLE `USER` ENABLE KEYS */;

-- Дамп структуры для таблица car_rental.USER_ROLE
CREATE TABLE IF NOT EXISTS `USER_ROLE` (
  `ID_USER` int(11) NOT NULL,
  `ID_ROLE` int(11) NOT NULL,
  PRIMARY KEY (`ID_USER`,`ID_ROLE`),
  KEY `FK_USER_ROLE_ROLE_INDEX` (`ID_ROLE`),
  CONSTRAINT `FK_USER_ROLE_ROLE` FOREIGN KEY (`ID_ROLE`) REFERENCES `ROLE` (`ID_ROLE`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_USER_ROLE_USER` FOREIGN KEY (`ID_USER`) REFERENCES `USER` (`ID_USER`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

-- Дамп данных таблицы car_rental.USER_ROLE: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `USER_ROLE` DISABLE KEYS */;
/*!40000 ALTER TABLE `USER_ROLE` ENABLE KEYS */;

-- Дамп структуры для таблица car_rental.VEHICLE
CREATE TABLE IF NOT EXISTS `VEHICLE` (
  `ID_VEHICLE` int(10) NOT NULL AUTO_INCREMENT,
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf16;

-- Дамп данных таблицы car_rental.VEHICLE: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `VEHICLE` DISABLE KEYS */;
INSERT INTO `VEHICLE` (`ID_VEHICLE`, `REG_NUM`, `ID_VEHICLE_TYPE`, `ID_VEHICLE_MODEL`, `RENTAL_POINT`, `LAST_RENTAL`) VALUES
	(1, 'А034АА34RES', 2, 1, 1, NULL),
	(2, 'У156УУ777RUS', 2, 2, 1, NULL);
/*!40000 ALTER TABLE `VEHICLE` ENABLE KEYS */;

-- Дамп структуры для таблица car_rental.VEHICLE_MODEL
CREATE TABLE IF NOT EXISTS `VEHICLE_MODEL` (
  `ID_VEHICLE_MODEL` int(11) NOT NULL AUTO_INCREMENT,
  `DESCR` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_VEHICLE_MODEL`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf16;

-- Дамп данных таблицы car_rental.VEHICLE_MODEL: ~2 rows (приблизительно)
/*!40000 ALTER TABLE `VEHICLE_MODEL` DISABLE KEYS */;
INSERT INTO `VEHICLE_MODEL` (`ID_VEHICLE_MODEL`, `DESCR`) VALUES
	(1, 'Renault logan'),
	(2, 'Renault duster');
/*!40000 ALTER TABLE `VEHICLE_MODEL` ENABLE KEYS */;

-- Дамп структуры для таблица car_rental.VEHICLE_TYPE
CREATE TABLE IF NOT EXISTS `VEHICLE_TYPE` (
  `ID_VEHICLE_TYPE` int(11) NOT NULL AUTO_INCREMENT,
  `DESCR` varchar(255) NOT NULL,
  PRIMARY KEY (`ID_VEHICLE_TYPE`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf16;

-- Дамп данных таблицы car_rental.VEHICLE_TYPE: ~2 rows (приблизительно)
/*!40000 ALTER TABLE `VEHICLE_TYPE` DISABLE KEYS */;
INSERT INTO `VEHICLE_TYPE` (`ID_VEHICLE_TYPE`, `DESCR`) VALUES
	(1, 'Седан'),
	(2, 'Универсал');
/*!40000 ALTER TABLE `VEHICLE_TYPE` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
