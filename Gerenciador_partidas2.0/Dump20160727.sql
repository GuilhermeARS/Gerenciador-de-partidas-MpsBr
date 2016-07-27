CREATE DATABASE  IF NOT EXISTS `campeonato` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `campeonato`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: campeonato
-- ------------------------------------------------------
-- Server version	5.6.26-log

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
-- Table structure for table `tab_camp`
--

DROP TABLE IF EXISTS `tab_camp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_camp` (
  `CAMP_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CAMP_NOME` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `CAMP_QUANT_TIME` int(11) DEFAULT NULL,
  PRIMARY KEY (`CAMP_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_camp`
--

LOCK TABLES `tab_camp` WRITE;
/*!40000 ALTER TABLE `tab_camp` DISABLE KEYS */;
INSERT INTO `tab_camp` VALUES (73,'COPA INTERNACIONAL',4),(76,'COPA ATENAS',3);
/*!40000 ALTER TABLE `tab_camp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_camp_jogo`
--

DROP TABLE IF EXISTS `tab_camp_jogo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_camp_jogo` (
  `CAMP_JOGO_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CAMP_JOGO_ID_CAMP` int(11) DEFAULT NULL,
  `CAMP_JOGO_ID_JOGO` int(11) DEFAULT NULL,
  PRIMARY KEY (`CAMP_JOGO_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_camp_jogo`
--

LOCK TABLES `tab_camp_jogo` WRITE;
/*!40000 ALTER TABLE `tab_camp_jogo` DISABLE KEYS */;
/*!40000 ALTER TABLE `tab_camp_jogo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_camp_time`
--

DROP TABLE IF EXISTS `tab_camp_time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_camp_time` (
  `CAMP_TIME_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CAMP_ID` int(11) DEFAULT NULL,
  `TIME_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`CAMP_TIME_ID`),
  KEY `CAMP_ID_idx` (`CAMP_ID`),
  KEY `TIME_ID_idx` (`TIME_ID`),
  CONSTRAINT `FK_CAMP_ID` FOREIGN KEY (`CAMP_ID`) REFERENCES `tab_camp` (`CAMP_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_TIME_ID` FOREIGN KEY (`TIME_ID`) REFERENCES `tab_time` (`TIME_ID`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_camp_time`
--

LOCK TABLES `tab_camp_time` WRITE;
/*!40000 ALTER TABLE `tab_camp_time` DISABLE KEYS */;
INSERT INTO `tab_camp_time` VALUES (24,73,76),(25,73,95),(26,73,90),(27,73,91),(28,76,96),(29,76,89),(30,76,1);
/*!40000 ALTER TABLE `tab_camp_time` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_jogo`
--

DROP TABLE IF EXISTS `tab_jogo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_jogo` (
  `JOGO_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CAMP_ID` int(11) NOT NULL,
  `JOGO_ID_TIME1` int(11) DEFAULT NULL,
  `JOGO_ID_TIME2` int(11) DEFAULT NULL,
  `JOGO_TIME1_GOLS` int(11) DEFAULT NULL,
  `JOGO_TIME2_GOLS` int(11) DEFAULT NULL,
  PRIMARY KEY (`JOGO_ID`),
  KEY `CAMP_ID_idx` (`CAMP_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_jogo`
--

LOCK TABLES `tab_jogo` WRITE;
/*!40000 ALTER TABLE `tab_jogo` DISABLE KEYS */;
INSERT INTO `tab_jogo` VALUES (1,73,0,0,NULL,NULL),(2,73,0,0,NULL,NULL),(3,73,0,0,NULL,NULL),(4,73,0,0,NULL,NULL),(5,73,0,0,NULL,NULL),(6,73,0,0,NULL,NULL);
/*!40000 ALTER TABLE `tab_jogo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_login`
--

DROP TABLE IF EXISTS `tab_login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_login` (
  `LOGIN_ID` int(11) NOT NULL AUTO_INCREMENT,
  `LOGIN_USER` varchar(45) DEFAULT NULL,
  `LOGIN_SENHA` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`LOGIN_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_login`
--

LOCK TABLES `tab_login` WRITE;
/*!40000 ALTER TABLE `tab_login` DISABLE KEYS */;
INSERT INTO `tab_login` VALUES (1,'antonio','1234'),(2,'rodolfo','6969'),(3,'rodolfo','6969'),(4,'márcio','12345'),(5,'márcio','12345'),(6,'chuck','999'),(7,'guilherme','122'),(8,'marco','1234');
/*!40000 ALTER TABLE `tab_login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_time`
--

DROP TABLE IF EXISTS `tab_time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tab_time` (
  `TIME_ID` int(11) NOT NULL AUTO_INCREMENT,
  `TIME_NOME` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`TIME_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=120 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_time`
--

LOCK TABLES `tab_time` WRITE;
/*!40000 ALTER TABLE `tab_time` DISABLE KEYS */;
INSERT INTO `tab_time` VALUES (1,'VASCO'),(73,'FLAMENGO'),(74,'CORINTHIAS'),(75,'FLUMINENSE'),(76,'BOTAFOGO'),(77,'PALMEIRAS'),(80,'INTERNACIONAL'),(82,'SANTA CRUZ'),(83,'CHAPECOENSE'),(84,'SPORT DE RECIFE'),(85,'GRÊMIO'),(86,'SANTOS'),(87,'SÃO PAULO'),(88,'GOIÁS'),(89,'VILA NOVA'),(90,'AVAÍ'),(91,'ATLÉTICO GOIANIENSE'),(92,'CRB'),(93,'JOINVILLE'),(94,'CEARÁ'),(95,'BAHIA'),(96,'VITÓRIA'),(119,'BRASILIENSE');
/*!40000 ALTER TABLE `tab_time` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-27 17:01:25
