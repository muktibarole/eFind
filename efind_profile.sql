-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: efind
-- ------------------------------------------------------
-- Server version	5.7.9-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `profile`
--

DROP TABLE IF EXISTS `profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profile` (
  `username` varchar(45) NOT NULL,
  `uid` int(11) NOT NULL,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `tnumber` varchar(45) DEFAULT NULL,
  `department` varchar(45) DEFAULT NULL,
  `program` varchar(45) DEFAULT NULL,
  `gpa` varchar(45) DEFAULT NULL,
  `skills` text,
  `projects` text,
  `interest` text,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profile`
--

LOCK TABLES `profile` WRITE;
/*!40000 ALTER TABLE `profile` DISABLE KEYS */;
INSERT INTO `profile` VALUES ('coskun',31,'Coskun','rock','T00613488','CS','ele','3.6','esrtgf','dgf','111'),('coskun1',29,'corrected coskun','baral',NULL,'ece','CS',NULL,';kn;ln;ln','klhnkibhlbk',NULL),('mmmmmmm',32,'mmm','mmm','mmm','mmm','mmm','mmm','mmm','mmm','mmm'),('oo',30,'Prajwal','Khatiwada','T00613488','ece','ele','3.6','sef','dsvf','sdf'),('prajwalfc',1,'ABC','111111','2','ece','ece','3.33','abc,def,ghi','jkl,mno,pqr','atu,wxy,z'),('prajwalfc1',2,'DEF','22222222','21','bce','bce','4.33','abc,def,ghi','jkl,mno,pqr','atu,wxy,z'),('prajwalfc2',3,'GHI','33333333','123','cvf','sdf','5.4','sef','sdf','werf'),('prajwalfc3',4,'JKL','444444444','456','sdf','sdf','1.2','wer','sdvg','sdvgs'),('prajwalfc4',5,'MNO','55555555','345','xzd','asf','2.9','j v','vj','kjv');
/*!40000 ALTER TABLE `profile` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-04 12:46:46
