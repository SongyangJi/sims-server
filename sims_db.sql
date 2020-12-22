CREATE DATABASE  IF NOT EXISTS `sims_db` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `sims_db`;
-- MySQL dump 10.13  Distrib 8.0.19, for macos10.15 (x86_64)
--
-- Host: localhost    Database: sims_db
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `achievement`
--

DROP TABLE IF EXISTS `achievement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `achievement` (
  `achievement_id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `description` text,
  `level` varchar(45) DEFAULT NULL,
  `kind` varchar(45) DEFAULT NULL,
  `time` date DEFAULT NULL,
  `sid` bigint NOT NULL,
  PRIMARY KEY (`achievement_id`),
  UNIQUE KEY `idachievement_UNIQUE` (`achievement_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `achievement`
--

LOCK TABLES `achievement` WRITE;
/*!40000 ALTER TABLE `achievement` DISABLE KEYS */;
INSERT INTO `achievement` VALUES (6,'保护鹦鹉','保护了大量珍稀的野生鹦鹉，蓝色金刚，玄风，虎皮...','国家级','社会服务','2020-12-01',201800202033),(7,'爱护北极熊','爱护北极动物，人人有责！','省级','社会服务','2019-12-02',201800202033);
/*!40000 ALTER TABLE `achievement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `achievement_url`
--

DROP TABLE IF EXISTS `achievement_url`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `achievement_url` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `achievement_id` bigint NOT NULL,
  `url` varchar(300) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `achievement_url`
--

LOCK TABLES `achievement_url` WRITE;
/*!40000 ALTER TABLE `achievement_url` DISABLE KEYS */;
INSERT INTO `achievement_url` VALUES (1,6,'https://sims-web-jsy.oss-cn-shanghai.aliyuncs.com/students-images/3e526cf9-5351-4518-8004-1fa4014cddf51.jpg'),(2,6,'https://sims-web-jsy.oss-cn-shanghai.aliyuncs.com/students-images/46f48524-221b-48f0-865b-7bf171f22b652.jpg'),(3,6,'https://sims-web-jsy.oss-cn-shanghai.aliyuncs.com/students-images/eb815ad5-ce83-49c0-82f4-f9d31c12d7543.jpg'),(4,7,'https://sims-web-jsy.oss-cn-shanghai.aliyuncs.com/students-images/69d2316c-ff3d-468e-857a-190ae38449964.jpg'),(5,7,'https://sims-web-jsy.oss-cn-shanghai.aliyuncs.com/students-images/fb803a2a-2da3-4213-8464-bd4c1dbb4cd95.jpg'),(6,7,'https://sims-web-jsy.oss-cn-shanghai.aliyuncs.com/students-images/ed4b4256-c2de-4bf7-8607-cd6b85bb94576.jpg'),(7,6,'https://sims-web-jsy.oss-cn-shanghai.aliyuncs.com/students-images/4272b6b0-27e7-46e1-875f-cf4f429df4947.jpg'),(8,6,'https://sims-web-jsy.oss-cn-shanghai.aliyuncs.com/students-images/cdcadca0-fb78-496c-8a90-6ee81b6f2fcc8.jpg');
/*!40000 ALTER TABLE `achievement_url` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `aid` bigint NOT NULL,
  `pwd` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`aid`),
  UNIQUE KEY `aid_UNIQUE` (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (123,NULL);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `cid` bigint NOT NULL,
  `cname` varchar(45) NOT NULL,
  `credit` double DEFAULT NULL,
  `prop` enum('必修','限选','任选') DEFAULT NULL,
  `faculty` varchar(45) DEFAULT NULL,
  `teacher_name` varchar(45) DEFAULT NULL,
  `begin` int DEFAULT NULL,
  `end` int DEFAULT NULL,
  PRIMARY KEY (`cid`),
  UNIQUE KEY `cid_UNIQUE` (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (11234005678,'高等数学',5,'必修','数学院','王丽',3,17),(123499880011,'大学英语',4,'必修','外语学院','李红',1,17),(201911001234,'离散数学',3,'必修','软件学院','刘宏',1,18),(202011005678,'C++程序设计',2,'必修','软件学院','潘荣江',3,17);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `score`
--

DROP TABLE IF EXISTS `score`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `score` (
  `sid` bigint NOT NULL,
  `cid` bigint NOT NULL,
  `score` double NOT NULL,
  PRIMARY KEY (`sid`,`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `score`
--

LOCK TABLES `score` WRITE;
/*!40000 ALTER TABLE `score` DISABLE KEYS */;
INSERT INTO `score` VALUES (123,11234005678,93.5),(456,11234005678,1),(201800202033,11234005678,100),(201800202033,123499880011,95),(201800202033,201911001234,94),(201800302088,11234005678,96),(201811110000,11234005678,95);
/*!40000 ALTER TABLE `score` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `sid` bigint NOT NULL,
  `pwd` varchar(20) NOT NULL,
  `sname` varchar(45) DEFAULT NULL,
  `gender` enum('男','女') DEFAULT NULL,
  `birth` varchar(45) DEFAULT NULL,
  `profession` varchar(45) DEFAULT NULL,
  `faculty` varchar(45) DEFAULT NULL,
  `s_class` varchar(45) DEFAULT NULL,
  `grade` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `politics_status` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `head_url` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`sid`),
  UNIQUE KEY `uid_UNIQUE` (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (201800202033,'123','吉松阳','男','1999-09-04T16:00:00.000Z','软件工程','软件学院','软工1班','2019','15662679012','共青团员','江苏省扬州市高邮市','https://sims-web-jsy.oss-cn-shanghai.aliyuncs.com/students-images/3c11de44-0c83-4583-81ff-02f92b4f532cjsyhead.jpg'),(201800301234,'123','陈启航','男','2000-01-01','工程力学','土建学院','软件1班','2018','1560001111','共青团员','海南省海南市',NULL),(201800302088,'123','龚陈博','男','2000-10-18','信息科学','数学院','信计1班','2018','15366850123','共青团员','江苏省南通市启东区','https://sims-web-jsy.oss-cn-shanghai.aliyuncs.com/students-images/4bc22cae-18c8-4622-8833-4a5bc59c36e3gcbhead.jpg'),(201800401234,'123','周学伟','男','2000-01-01','工程力学','土建学院','工程力学1班','2018','15612344321','共产党员','湖南省长沙市','https://sims-web-jsy.oss-cn-shanghai.aliyuncs.com/students-images/98e49bb6-cfcf-41f0-804e-efa982afd8a4zxy.jpg'),(201811110000,'123','方雅欣','女','2000-01-01','工程力学','土建学院','工力','2018',NULL,NULL,NULL,'https://sims-web-jsy.oss-cn-shanghai.aliyuncs.com/students-images/4b9deccd-7da0-4427-86cd-1fc620469e12CEF6858A-DC7C-4DED-80FC-950D6D7383F2.jpeg'),(201900302001,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302002,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302003,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302004,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302005,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302006,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302007,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302008,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302009,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302010,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302011,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302012,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302013,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302014,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302015,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302016,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302017,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302018,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302019,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302020,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302021,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302022,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302023,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302024,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302025,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302026,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302027,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302028,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302029,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302030,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302031,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302032,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302033,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302034,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302035,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302036,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302037,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302038,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302039,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302040,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302041,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302042,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302043,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302044,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302045,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302046,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302047,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302048,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(201900302049,'123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students_select_courses`
--

DROP TABLE IF EXISTS `students_select_courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students_select_courses` (
  `sid` bigint NOT NULL,
  `cid` bigint NOT NULL,
  PRIMARY KEY (`sid`,`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students_select_courses`
--

LOCK TABLES `students_select_courses` WRITE;
/*!40000 ALTER TABLE `students_select_courses` DISABLE KEYS */;
INSERT INTO `students_select_courses` VALUES (201800202033,11234005678),(201800202033,123499880011),(201800202033,201911001234),(201800302088,11234005678);
/*!40000 ALTER TABLE `students_select_courses` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-22 21:17:58
