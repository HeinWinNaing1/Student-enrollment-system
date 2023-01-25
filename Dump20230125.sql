CREATE DATABASE  IF NOT EXISTS `studentenrollment` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `studentenrollment`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: studentenrollment
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `categoryType` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (10,'PHP','PHP programming language is very popular in Myanmar.'),(11,'Japan','Japan is developed country and their language are popular in Myanmar.'),(12,'Java','Java is one of popular language in many country'),(13,'Javascript','Javascript is number one language in the world.'),(14,'Sapain','Sapain is popular in the world.'),(15,'Myanmar','Myanmar is very important language in Myanmar.');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `id` int NOT NULL AUTO_INCREMENT,
  `coursename` varchar(255) NOT NULL,
  `instructorname` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `category` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `startdate` varchar(255) NOT NULL,
  `period` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (27,'PHP Job Ready Course','Sayar Chit',500000,'PHP','This course is very helpful for people that want to be a php web developer.','2023-01-17','5 Months'),(28,'Java Job Ready course','Sayar Kyaw',500000,'Java','This course is very helpful for people that want te be a java developer','2023-01-21','5 Months'),(29,'Japan 4 Skill','Yamamoto Akio',300000,'Japan','This course is for people who interest in Japan Language','2023-01-03','3month'),(30,'Javascript starter course','Sayar Moe',300000,'Javascript','This course is very important for a web developer.','2023-01-30','3month');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enroll`
--

DROP TABLE IF EXISTS `enroll`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enroll` (
  `id` int NOT NULL AUTO_INCREMENT,
  `coursename` varchar(255) NOT NULL,
  `studentname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `enrolldate` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enroll`
--

LOCK TABLES `enroll` WRITE;
/*!40000 ALTER TABLE `enroll` DISABLE KEYS */;
INSERT INTO `enroll` VALUES (5,'Japan 4 Skill','Koko','ko@gmail.com','2023/01/16'),(6,'PHP Job Ready Course','Koko','ko@gmail.com','2023/01/16'),(7,'Javascript starter course','KyawKyaw','kyaw@gmail.com','2023/01/16'),(8,'PHP Job Ready Course','KyawKyaw','kyaw@gmail.com','2023/01/16'),(9,'Java Job Ready course','WinKo','win@gmail.com','2023/01/16'),(10,'Japan 4 Skill','KyawKyaw','kyaw@gmail.com','2023/01/16');
/*!40000 ALTER TABLE `enroll` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `createdate` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  `phNo` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Admin','admin@gmail.com','admin@123','2023/01/15','admin','09789312248'),(9,'KyawKyaw','kyaw@gmail.com','1000:71443f2ddb8c2e3a6a26e3f3367247e9:6590a6374e306648dc348652ad83eaba51d0e65ae141e0bf3229778e764c9f3a306eba54c7c368fc036073492b90124baf8d4e9a6a0f6c1a479874e6d097d039','2023/01/15','user','0999999999'),(10,'WinKo','win@gmail.com','1000:112c535ea67c88da57ae32da056cf54f:5989427b9fe7b66987b9d3ea0555ca3eabcea95d12cb469836b364f06a4606f4615012f3632566548bb315d6e5781b633e1cf3044ba3078fc6c41b0dbf08a5e3','2023/01/15','user','09987654567'),(11,'Hein Win Naing','heinwinnaing0@gmail.com','1000:8f1f296eb0b93b2d8d2573cc5297db8a:a2c0019d1f83baf16f4c0d5802d8d20252f62730426c806a30891d7852d3fefc71d3c28fbd7e6a8ed5cdf48ecac03bdf9beb81465b089ef6e879b022d9f3219b','2023/01/15','user','09976182698'),(12,'Koko','ko@gmail.com','1000:6f06fbef70b3c53a18dcb564dc7d9976:afc6fc7d11e771880d60a7c06785234eb73c49b5002cb32e084540713d260161088d40287e7cdafc200cc6ba501afff54aeb199e1ddc4ff0f10c683a7782eb18','2023/01/15','user','09402067870'),(13,'Ko Zaw','zaw@gmail.com','1000:1a527114c6a649c56e55fa3c605bf51a:6cd61d99a35f65ecf99b85ae60d8fe63d479a7e8ffebbe01c00e8a7579df0f3e2d63017bd14622bc4607aa8a0f883b3cf720180da568344f1a26ae477ca244d4','2023/01/15','user','09366388595'),(14,'Ko Hein','hein@gmail.com','1000:b47a32c498337401e54905570b9da796:ebe504482f0ddc54f1426f92390922e6e01d15c5c931960ecace61bdc19ac1c43c735151936975097ad5933e72ce0d433ef0a118820db86cd6f2f51f204a7d13','2023/01/16','user','09987654567'),(15,'Htet Htet','htet@gmail.com','1000:09f05f3754e59ba190b15d6573b961e7:5e310d84239dc6e6aa2aecc21780269712129e43a747de2b577cd8b09063dae6705388489a8a4b5928266f4fa8654b6886aecbffdb686065e178a7517a5ca4ad','2023/01/18','user','0999999999');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-25 11:09:40
