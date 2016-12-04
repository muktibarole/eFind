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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `email_id` varchar(45) DEFAULT NULL,
  `account_type` enum('faculty','student') DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `telephone` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'prajwalfc','prajwal_k@live.com','faculty','prajwal1','3479719306'),(2,'prajwalfc1','prajwal_k@live.com','faculty','prajwal1','3479719306'),(3,'prajwalfc2','prajwal_k@live.com','faculty','prajwal1','3479719306'),(4,'prajwalfc3','prajwal_k@live.com','faculty','prajwal12','3479719306'),(5,'prajwalfc4','prajwal_k@live.com','faculty','prajwal1','3479719306'),(6,'Mukti Barole','mxshobhasan@ualr.edu','student','muktibarole','6579856890'),(10,'bbb','abc_drg@nksbnf.com','student','12345678','123'),(11,'prajwalk','prajwal_k@live.com','student','prajwalk1','3479719306'),(20,'pk23','prajwal_k@live.com','student','12345678','3479719306'),(29,'coskun1','coskun@abc.com','faculty','barack123','1234'),(30,'oo','prajwal_k@live.com','student','prajwal123','3479719306'),(31,'coskun','prajwal_k@live.com','student','prajwal123','3479719306'),(32,'mmmmmmm','prajwal_k@live.com','student','mmmmmmmmmmmmmmmmmmmm','3479719306');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
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
