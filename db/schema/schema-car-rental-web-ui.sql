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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf16;

-- Дамп данных таблицы car_rental.CUSTOMER: ~2 rows (приблизительно)
/*!40000 ALTER TABLE `CUSTOMER` DISABLE KEYS */;
INSERT INTO `CUSTOMER` (`ID_CUSTOMER`, `DESCR`) VALUES
	(1, 'Иваненко Григорий Емельянович'),
	(2, 'Бочаров Владимир Николаевич');
/*!40000 ALTER TABLE `CUSTOMER` ENABLE KEYS */;

-- Дамп структуры для таблица car_rental.hibernate_sequence
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

-- Дамп данных таблицы car_rental.hibernate_sequence: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` (`next_val`) VALUES
	(12);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;

-- Дамп структуры для таблица car_rental.RENTAL
CREATE TABLE IF NOT EXISTS `RENTAL` (
  `ID_RENTAL` int(11) NOT NULL AUTO_INCREMENT,
  `ID_CUSTOMER` int(11) NOT NULL,
  `ID_VEHICLE` int(11) NOT NULL,
  `RENTAL_START` datetime DEFAULT NULL,
  `RENTAL_END` datetime DEFAULT NULL,
  `NOTES` varchar(255) DEFAULT NULL,
  `POINT_FROM` int(11) DEFAULT NULL,
  `POINT_TO` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_RENTAL`),
  KEY `RENTAL_FK_CUSTOMER` (`ID_CUSTOMER`),
  KEY `RENTAL_FROM` (`POINT_FROM`),
  KEY `RENTAL_TO` (`POINT_TO`),
  KEY `RENTAL_FK_VEHICLE` (`ID_VEHICLE`),
  CONSTRAINT `RENTAL_FK_CUSTOMER` FOREIGN KEY (`ID_CUSTOMER`) REFERENCES `CUSTOMER` (`ID_CUSTOMER`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `RENTAL_FK_VEHICLE` FOREIGN KEY (`ID_VEHICLE`) REFERENCES `VEHICLE` (`ID_VEHICLE`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `RENTAL_FROM` FOREIGN KEY (`POINT_FROM`) REFERENCES `RENTAL_POINT` (`ID_RENTAL_POINT`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `RENTAL_TO` FOREIGN KEY (`POINT_TO`) REFERENCES `RENTAL_POINT` (`ID_RENTAL_POINT`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf16;

-- Дамп данных таблицы car_rental.RENTAL: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `RENTAL` DISABLE KEYS */;
INSERT INTO `RENTAL` (`ID_RENTAL`, `ID_CUSTOMER`, `ID_VEHICLE`, `RENTAL_START`, `RENTAL_END`, `NOTES`, `POINT_FROM`, `POINT_TO`) VALUES
	(2, 1, 1, '2018-08-16 09:00:00', '2018-08-22 09:00:00', '123', 1, 1);
/*!40000 ALTER TABLE `RENTAL` ENABLE KEYS */;

-- Дамп структуры для таблица car_rental.RENTAL_POINT
CREATE TABLE IF NOT EXISTS `RENTAL_POINT` (
  `ID_RENTAL_POINT` int(11) NOT NULL AUTO_INCREMENT,
  `ADDRESS` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_RENTAL_POINT`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf16;

-- Дамп данных таблицы car_rental.RENTAL_POINT: ~1 rows (приблизительно)
/*!40000 ALTER TABLE `RENTAL_POINT` DISABLE KEYS */;
INSERT INTO `RENTAL_POINT` (`ID_RENTAL_POINT`, `ADDRESS`) VALUES
	(1, 'Волгоград землячки 110а');
/*!40000 ALTER TABLE `RENTAL_POINT` ENABLE KEYS */;

-- Дамп структуры для таблица car_rental.ROLE
CREATE TABLE IF NOT EXISTS `ROLE` (
  `ID_ROLE` int(11) NOT NULL,
  `ROLE` varchar(255) NOT NULL,
  PRIMARY KEY (`ID_ROLE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

-- Дамп данных таблицы car_rental.ROLE: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `ROLE` DISABLE KEYS */;
/*!40000 ALTER TABLE `ROLE` ENABLE KEYS */;

-- Дамп структуры для таблица car_rental.ROLE_AUD
CREATE TABLE IF NOT EXISTS `ROLE_AUD` (
  `ID_ROLE` int(11) NOT NULL,
  `REV` int(11) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `ROLE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_ROLE`,`REV`),
  KEY `FKfnsm5uhcqr6cx4t6jj5v4m52f` (`REV`),
  CONSTRAINT `FKfnsm5uhcqr6cx4t6jj5v4m52f` FOREIGN KEY (`REV`) REFERENCES `UserRevision` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

-- Дамп данных таблицы car_rental.ROLE_AUD: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `ROLE_AUD` DISABLE KEYS */;
/*!40000 ALTER TABLE `ROLE_AUD` ENABLE KEYS */;

-- Дамп структуры для таблица car_rental.USER
CREATE TABLE IF NOT EXISTS `USER` (
  `ID_USER` int(11) NOT NULL AUTO_INCREMENT,
  `DESCR` varchar(255) NOT NULL,
  `NAME` varchar(32) NOT NULL,
  `PASS` varchar(255) NOT NULL,
  PRIMARY KEY (`ID_USER`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf16;

-- Дамп данных таблицы car_rental.USER: ~12 rows (приблизительно)
/*!40000 ALTER TABLE `USER` DISABLE KEYS */;
INSERT INTO `USER` (`ID_USER`, `DESCR`, `NAME`, `PASS`) VALUES
	(1, 'Федоров Игорь Иванович', 'admin', '46d5f4e1b4bbfd7ac686df13ceff0ac5de550cd5f3c0a897f39d7c982a607e46af974a08051029a5'),
	(2, 'Викторов Григорий Юрьевич1111112341', 'rotor', '06f9675c5c25f1d7e246ab352a661800503f05c4daf6bcede194414c8b4c0837b3b2a1503dff5ad2'),
	(3, 'Карпов Владислав Николаевич11', 'repa12', '43ab13957f504ae3e3bebcfbf792553a564f0dc662359131d2953a6be8ad92d16d917c1b710c73fd'),
	(4, 'Гаранин Алексей Владимирович', 'gaga', '400419a4951b834d1ecbed8eba7f5956dcb7650368d37d0b57ead5bfef8fd330e2a053446c18cf9e'),
	(5, 'Викторов Григорий Юрьевич', 'rotor333', 'bff2f3e632f2310fe917873070721e724806e014630c3df6bddd98c1a52277a4f1d67f0080c9e1be'),
	(6, 'Карпов Владислав Николаевич', 'repa125', '453337c3a6c2c7c6ca6f9be6a9161ab3ec97f349c6162b9576bd759a100a68d3e6f8abe45285c862'),
	(7, 'Гаранин Алексей Владимирович', 'gaga2', '0123456789'),
	(8, 'Викторов Григорий Юрьевич', 'rotor2', 'Fus24q30'),
	(9, 'Карпов Владислав Николаевич', 'repa122', 'Tdfd340Fr'),
	(11, 'Викторов Григорий Юрьевич', 'rotor23', 'Fus24q30'),
	(12, 'Ivanov German', 'repa121', 'Tdfd340Fr'),
	(13, 'Никольский Игорь Варфаломеевич', 'gaga11', '59981ebf181e56f4914b333961efb954e0bf1c160a03762eec4b357acd7a2881c175603602daef62');
/*!40000 ALTER TABLE `USER` ENABLE KEYS */;

-- Дамп структуры для таблица car_rental.UserRevision
CREATE TABLE IF NOT EXISTS `UserRevision` (
  `id` int(11) NOT NULL,
  `timestamp` bigint(20) NOT NULL,
  `idUser` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

-- Дамп данных таблицы car_rental.UserRevision: ~9 rows (приблизительно)
/*!40000 ALTER TABLE `UserRevision` DISABLE KEYS */;
INSERT INTO `UserRevision` (`id`, `timestamp`, `idUser`) VALUES
	(1, 1532094971579, 0),
	(2, 1532095008476, 0),
	(3, 1532095578402, 0),
	(4, 1532096398756, 0),
	(5, 1532351462042, 0),
	(6, 1532432157278, 1),
	(7, 1532432273213, 1),
	(8, 1532432329649, 2),
	(9, 1532432539366, 1),
	(10, 1533563528826, 1),
	(11, 1533563553577, 1);
/*!40000 ALTER TABLE `UserRevision` ENABLE KEYS */;

-- Дамп структуры для таблица car_rental.USER_AUD
CREATE TABLE IF NOT EXISTS `USER_AUD` (
  `ID_USER` int(11) NOT NULL,
  `REV` int(11) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `DESCR` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_USER`,`REV`),
  KEY `FKk3a4jqoufp5en4k7lf8kbset5` (`REV`),
  CONSTRAINT `FKk3a4jqoufp5en4k7lf8kbset5` FOREIGN KEY (`REV`) REFERENCES `UserRevision` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

-- Дамп данных таблицы car_rental.USER_AUD: ~9 rows (приблизительно)
/*!40000 ALTER TABLE `USER_AUD` DISABLE KEYS */;
INSERT INTO `USER_AUD` (`ID_USER`, `REV`, `REVTYPE`, `DESCR`, `NAME`) VALUES
	(1, 10, 1, 'Федоров Игорь Иванович', 'admin'),
	(2, 1, 1, 'Викторов Григорий Юрьевич1', 'rotor'),
	(2, 3, 1, 'Викторов Григорий Юрьевич11', 'rotor'),
	(2, 4, 1, 'Викторов Григорий Юрьевич111', 'rotor'),
	(2, 5, 1, 'Викторов Григорий Юрьевич1111', 'rotor'),
	(2, 6, 1, 'Викторов Григорий Юрьевич11111', 'rotor'),
	(2, 7, 1, 'Викторов Григорий Юрьевич111111234', 'rotor'),
	(2, 9, 1, 'Викторов Григорий Юрьевич1111112341', 'rotor'),
	(3, 2, 1, 'Карпов Владислав Николаевич1', 'repa12'),
	(3, 8, 1, 'Карпов Владислав Николаевич11', 'repa12'),
	(4, 11, 1, 'Гаранин Алексей Владимирович', 'gaga');
/*!40000 ALTER TABLE `USER_AUD` ENABLE KEYS */;

-- Дамп структуры для таблица car_rental.USER_ROLE
CREATE TABLE IF NOT EXISTS `USER_ROLE` (
  `ID_USER` int(11) NOT NULL,
  `ID_ROLE` int(11) NOT NULL,
  KEY `FKikyntss8xtpjhdn0083ktibkv` (`ID_ROLE`),
  KEY `FKg7qj6b1g2p3et81v1q336d8l6` (`ID_USER`),
  CONSTRAINT `FKg7qj6b1g2p3et81v1q336d8l6` FOREIGN KEY (`ID_USER`) REFERENCES `USER` (`ID_USER`),
  CONSTRAINT `FKikyntss8xtpjhdn0083ktibkv` FOREIGN KEY (`ID_ROLE`) REFERENCES `ROLE` (`ID_ROLE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

-- Дамп данных таблицы car_rental.USER_ROLE: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `USER_ROLE` DISABLE KEYS */;
/*!40000 ALTER TABLE `USER_ROLE` ENABLE KEYS */;

-- Дамп структуры для таблица car_rental.USER_ROLE_AUD
CREATE TABLE IF NOT EXISTS `USER_ROLE_AUD` (
  `REV` int(11) NOT NULL,
  `ID_USER` int(11) NOT NULL,
  `ID_ROLE` int(11) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`REV`,`ID_USER`,`ID_ROLE`),
  CONSTRAINT `FK71ur40yenptmoceluyrjgenfm` FOREIGN KEY (`REV`) REFERENCES `UserRevision` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

-- Дамп данных таблицы car_rental.USER_ROLE_AUD: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `USER_ROLE_AUD` DISABLE KEYS */;
/*!40000 ALTER TABLE `USER_ROLE_AUD` ENABLE KEYS */;

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

-- Дамп данных таблицы car_rental.VEHICLE: ~2 rows (приблизительно)
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

-- Дамп структуры для таблица car_rental.VEHICLE_TRACK_POINT
CREATE TABLE IF NOT EXISTS `VEHICLE_TRACK_POINT` (
  `ID_VEHICLE_TRACK_POINT` bigint(20) NOT NULL AUTO_INCREMENT,
  `CREATION_DATE` date DEFAULT NULL,
  `CREATION_TIME` datetime(6) DEFAULT NULL,
  `ID_VEHICLE` int(11) DEFAULT NULL,
  `LATITUDES` decimal(10,8) DEFAULT NULL,
  `LONGITUDES` decimal(11,8) DEFAULT NULL,
  PRIMARY KEY (`ID_VEHICLE_TRACK_POINT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

-- Дамп данных таблицы car_rental.VEHICLE_TRACK_POINT: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `VEHICLE_TRACK_POINT` DISABLE KEYS */;
/*!40000 ALTER TABLE `VEHICLE_TRACK_POINT` ENABLE KEYS */;

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
