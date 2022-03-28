-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: clinicms
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `patientinfo`
--

DROP TABLE IF EXISTS `patientinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patientinfo` (
  `patient_id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `created_user_id` int DEFAULT NULL,
  `del_flag` int DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  `deleted_user_id` int DEFAULT NULL,
  `patient_address` varchar(255) DEFAULT NULL,
  `patient_age` int DEFAULT NULL,
  `patient_gender` varchar(255) DEFAULT NULL,
  `patient_name` varchar(255) DEFAULT NULL,
  `patient_phone` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `updated_user_id` int DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`patient_id`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patientinfo`
--

LOCK TABLES `patientinfo` WRITE;
/*!40000 ALTER TABLE `patientinfo` DISABLE KEYS */;
INSERT INTO `patientinfo` VALUES (1,'2022-03-23 12:48:01',NULL,0,'2022-03-24 21:46:57',NULL,'Mayangone',33,'Male','LeoValeskaOK','091122331','2022-03-28','2022-03-24 19:21:39',NULL,'Finished'),(3,'2022-03-23 15:41:41',NULL,0,'2022-03-23 16:01:12',NULL,'asdfgh',22,'Male','asdfgh','11111111111','2022-03-24','2022-03-23 15:41:41',NULL,'Treating'),(5,'2022-03-24 09:29:08',NULL,0,'2022-03-24 13:42:08',NULL,'Mayangone',22,'Male','asdfgh','111','2022-03-28','2022-03-24 09:29:08',NULL,'Treating'),(13,'2022-03-24 16:05:24',NULL,0,NULL,NULL,'1111',22,'Male','LeoValeska','09111222333,09333222111','2022-03-25','2022-03-25 06:49:16',NULL,'Treating'),(14,'2022-03-24 18:48:57',NULL,0,'2022-03-24 18:50:32',NULL,'11',11,'Male','ZawL','111111111','2022-03-20','2022-03-24 18:50:29',NULL,'Treating'),(15,'2022-03-24 21:40:40',NULL,0,NULL,NULL,'Mayangone',21,'Male','LeoValeskaOK','09111222333,09333222111','2022-03-28','2022-03-27 15:40:42',NULL,'Treating'),(16,'2022-03-25 06:51:04',NULL,0,NULL,NULL,'Hello',22,'Male','Test','09998877123','2022-03-28','2022-03-25 06:51:04',NULL,'Treating');
/*!40000 ALTER TABLE `patientinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-28 13:45:16
