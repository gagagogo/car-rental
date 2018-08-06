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


-- Дамп структуры базы данных car_rental_tracking
CREATE DATABASE IF NOT EXISTS `car_rental_tracking` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `car_rental_tracking`;

-- Дамп структуры для таблица car_rental_tracking.VEHICLE_TRACK_POINT
CREATE TABLE IF NOT EXISTS `VEHICLE_TRACK_POINT` (
  `ID_VEHICLE_TRACK_POINT` bigint(20) NOT NULL AUTO_INCREMENT,
  `CREATION_DATE` date NOT NULL,
  `CREATION_TIME` datetime(6) DEFAULT NULL,
  `ID_VEHICLE` int(11) DEFAULT NULL,
  `LATITUDES` decimal(10,8) DEFAULT NULL,
  `LONGITUDES` decimal(11,8) DEFAULT NULL,
  PRIMARY KEY (`ID_VEHICLE_TRACK_POINT`,`CREATION_DATE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
PARTITION BY RANGE (year(CREATION_DATE))
(PARTITION p2018 VALUES LESS THAN (2019) ENGINE = InnoDB); 

-- Дамп данных таблицы car_rental_tracking.VEHICLE_TRACK_POINT: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `VEHICLE_TRACK_POINT` DISABLE KEYS */;
/*!40000 ALTER TABLE `VEHICLE_TRACK_POINT` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;