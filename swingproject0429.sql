-- MySQL dump 10.13  Distrib 8.0.22, for macos10.15 (x86_64)
--
-- Host: 192.168.0.136    Database: swingproject
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
-- Table structure for table `Answer`
--

DROP TABLE IF EXISTS `Answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Answer` (
  `answerid` int NOT NULL AUTO_INCREMENT,
  `answercontent` varchar(200) NOT NULL,
  `query_queryid` int NOT NULL,
  PRIMARY KEY (`answerid`,`query_queryid`),
  KEY `fk_answer_query1_idx` (`query_queryid`),
  CONSTRAINT `fk_answer_query1` FOREIGN KEY (`query_queryid`) REFERENCES `Query` (`queryid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Answer`
--

LOCK TABLES `Answer` WRITE;
/*!40000 ALTER TABLE `Answer` DISABLE KEYS */;
/*!40000 ALTER TABLE `Answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Cloth`
--

DROP TABLE IF EXISTS `Cloth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Cloth` (
  `clothid` int NOT NULL AUTO_INCREMENT,
  `clothtype` varchar(15) NOT NULL,
  `clothname` varchar(50) NOT NULL,
  `clothimage` longblob NOT NULL,
  PRIMARY KEY (`clothid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cloth`
--

LOCK TABLES `Cloth` WRITE;
/*!40000 ALTER TABLE `Cloth` DISABLE KEYS */;
/*!40000 ALTER TABLE `Cloth` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Comment`
--

DROP TABLE IF EXISTS `Comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Comment` (
  `commentid` int NOT NULL AUTO_INCREMENT,
  `commentcontent` varchar(200) NOT NULL,
  `document_documentid` int NOT NULL,
  PRIMARY KEY (`commentid`,`document_documentid`),
  KEY `fk_comment_document1_idx` (`document_documentid`),
  CONSTRAINT `fk_comment_document1` FOREIGN KEY (`document_documentid`) REFERENCES `Document` (`documentid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Comment`
--

LOCK TABLES `Comment` WRITE;
/*!40000 ALTER TABLE `Comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `Comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Document`
--

DROP TABLE IF EXISTS `Document`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Document` (
  `documentid` int NOT NULL AUTO_INCREMENT,
  `documenttitle` varchar(50) NOT NULL,
  `documentcontent` varchar(1000) NOT NULL,
  `documenttype` tinyint NOT NULL,
  `likecount` int DEFAULT NULL,
  `Cloth_clothid` int DEFAULT NULL,
  PRIMARY KEY (`documentid`),
  KEY `fk_document_Cloth1_idx` (`Cloth_clothid`),
  CONSTRAINT `fk_document_Cloth1` FOREIGN KEY (`Cloth_clothid`) REFERENCES `Cloth` (`clothid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Document`
--

LOCK TABLES `Document` WRITE;
/*!40000 ALTER TABLE `Document` DISABLE KEYS */;
/*!40000 ALTER TABLE `Document` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `likecloth`
--

DROP TABLE IF EXISTS `likecloth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `likecloth` (
  `liketime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `User_userid` varchar(15) NOT NULL,
  `Cloth_clothid` int NOT NULL,
  PRIMARY KEY (`User_userid`,`Cloth_clothid`),
  KEY `fk_likecloth_Cloth1_idx` (`Cloth_clothid`),
  CONSTRAINT `fk_likecloth_Cloth1` FOREIGN KEY (`Cloth_clothid`) REFERENCES `Cloth` (`clothid`),
  CONSTRAINT `fk_likedocument_copy1_User1` FOREIGN KEY (`User_userid`) REFERENCES `User` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `likecloth`
--

LOCK TABLES `likecloth` WRITE;
/*!40000 ALTER TABLE `likecloth` DISABLE KEYS */;
/*!40000 ALTER TABLE `likecloth` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `likedocument`
--

DROP TABLE IF EXISTS `likedocument`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `likedocument` (
  `liketime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `User_userid` varchar(15) NOT NULL,
  `document_documentid` int NOT NULL,
  PRIMARY KEY (`User_userid`,`document_documentid`),
  KEY `fk_writedocument_user_document1_idx` (`document_documentid`),
  CONSTRAINT `fk_writedocument_user_document10` FOREIGN KEY (`document_documentid`) REFERENCES `Document` (`documentid`),
  CONSTRAINT `fk_writedocument_user_User10` FOREIGN KEY (`User_userid`) REFERENCES `User` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `likedocument`
--

LOCK TABLES `likedocument` WRITE;
/*!40000 ALTER TABLE `likedocument` DISABLE KEYS */;
/*!40000 ALTER TABLE `likedocument` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Query`
--

DROP TABLE IF EXISTS `Query`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Query` (
  `queryid` int NOT NULL AUTO_INCREMENT,
  `querytitle` varchar(50) NOT NULL,
  `querycontent` varchar(200) NOT NULL,
  PRIMARY KEY (`queryid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Query`
--

LOCK TABLES `Query` WRITE;
/*!40000 ALTER TABLE `Query` DISABLE KEYS */;
/*!40000 ALTER TABLE `Query` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registcloth`
--

DROP TABLE IF EXISTS `registcloth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registcloth` (
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `blindtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `User_userid` varchar(15) NOT NULL,
  `Cloth_clothid` int NOT NULL,
  PRIMARY KEY (`User_userid`,`Cloth_clothid`),
  KEY `fk_registcloth_user_Cloth1_idx` (`Cloth_clothid`),
  CONSTRAINT `fk_registcloth_user_Cloth1` FOREIGN KEY (`Cloth_clothid`) REFERENCES `Cloth` (`clothid`),
  CONSTRAINT `fk_registcloth_user_User1` FOREIGN KEY (`User_userid`) REFERENCES `User` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registcloth`
--

LOCK TABLES `registcloth` WRITE;
/*!40000 ALTER TABLE `registcloth` DISABLE KEYS */;
/*!40000 ALTER TABLE `registcloth` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `User` (
  `userid` varchar(15) NOT NULL,
  `userpw` varchar(15) NOT NULL,
  `useremail` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `useraddtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `userblindtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `admin` tinyint NOT NULL,
  `userimage` longblob NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `writeanswer`
--

DROP TABLE IF EXISTS `writeanswer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `writeanswer` (
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `blindtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `User_userid` varchar(15) NOT NULL,
  `answer_answerid` int NOT NULL,
  `answer_query_queryid` int NOT NULL,
  PRIMARY KEY (`User_userid`,`answer_answerid`,`answer_query_queryid`),
  KEY `fk_writeanswer_answer1_idx` (`answer_answerid`,`answer_query_queryid`),
  CONSTRAINT `fk_writeanswer_answer1` FOREIGN KEY (`answer_answerid`, `answer_query_queryid`) REFERENCES `Answer` (`answerid`, `query_queryid`),
  CONSTRAINT `fk_writeanswer_User1` FOREIGN KEY (`User_userid`) REFERENCES `User` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `writeanswer`
--

LOCK TABLES `writeanswer` WRITE;
/*!40000 ALTER TABLE `writeanswer` DISABLE KEYS */;
/*!40000 ALTER TABLE `writeanswer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `writecomment`
--

DROP TABLE IF EXISTS `writecomment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `writecomment` (
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `blindtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `User_userid` varchar(15) NOT NULL,
  `comment_commentid` int NOT NULL,
  `comment_document_documentid` int NOT NULL,
  PRIMARY KEY (`User_userid`,`comment_commentid`,`comment_document_documentid`),
  KEY `fk_writecomment_user_comment1_idx` (`comment_commentid`,`comment_document_documentid`),
  CONSTRAINT `fk_writecomment_user_comment1` FOREIGN KEY (`comment_commentid`, `comment_document_documentid`) REFERENCES `Comment` (`commentid`, `document_documentid`),
  CONSTRAINT `fk_writecomment_user_User1` FOREIGN KEY (`User_userid`) REFERENCES `User` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `writecomment`
--

LOCK TABLES `writecomment` WRITE;
/*!40000 ALTER TABLE `writecomment` DISABLE KEYS */;
/*!40000 ALTER TABLE `writecomment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `writedocument`
--

DROP TABLE IF EXISTS `writedocument`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `writedocument` (
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `blindtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `User_userid` varchar(15) NOT NULL,
  `document_documentid` int NOT NULL,
  PRIMARY KEY (`User_userid`,`document_documentid`),
  KEY `fk_writedocument_user_document1_idx` (`document_documentid`),
  CONSTRAINT `fk_writedocument_user_document1` FOREIGN KEY (`document_documentid`) REFERENCES `Document` (`documentid`),
  CONSTRAINT `fk_writedocument_user_User1` FOREIGN KEY (`User_userid`) REFERENCES `User` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `writedocument`
--

LOCK TABLES `writedocument` WRITE;
/*!40000 ALTER TABLE `writedocument` DISABLE KEYS */;
/*!40000 ALTER TABLE `writedocument` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `writequery`
--

DROP TABLE IF EXISTS `writequery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `writequery` (
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `blindtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `User_userid` varchar(15) NOT NULL,
  `query_queryid` int NOT NULL,
  PRIMARY KEY (`User_userid`,`query_queryid`),
  KEY `fk_writequery_user_query1_idx` (`query_queryid`),
  CONSTRAINT `fk_writeqna_user_User1` FOREIGN KEY (`User_userid`) REFERENCES `User` (`userid`),
  CONSTRAINT `fk_writequery_user_query1` FOREIGN KEY (`query_queryid`) REFERENCES `Query` (`queryid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `writequery`
--

LOCK TABLES `writequery` WRITE;
/*!40000 ALTER TABLE `writequery` DISABLE KEYS */;
/*!40000 ALTER TABLE `writequery` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-29 10:51:15
