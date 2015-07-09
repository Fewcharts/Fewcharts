-- MySQL dump 10.13  Distrib 5.5.41, for Win64 (x86)
--
-- Host: us-cdbr-iron-east-02.cleardb.net    Database: heroku_f7be13520b27e62
-- ------------------------------------------------------
-- Server version	5.5.42-log

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
-- Table structure for table `answer`
--

DROP TABLE IF EXISTS `answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(450) COLLATE utf8_turkish_ci DEFAULT NULL,
  `insert_date` timestamp NULL DEFAULT NULL,
  `is_active` smallint(6) DEFAULT NULL,
  `responder_id` int(11) DEFAULT NULL,
  `question_id` int(11) DEFAULT NULL,
  `UpVote` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `question_answer_fk` (`question_id`),
  KEY `question_responder_fk` (`responder_id`),
  CONSTRAINT `question_answer_fk` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=475 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `email_validation`
--

DROP TABLE IF EXISTS `email_validation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `email_validation` (
  `validation_id` int(11) NOT NULL AUTO_INCREMENT,
  `validation_code` varchar(200) COLLATE utf8_turkish_ci DEFAULT NULL,
  `email` varchar(45) COLLATE utf8_turkish_ci DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `is_validated` bit(1) DEFAULT NULL,
  `insert_date` timestamp NULL DEFAULT NULL,
  `validation_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`validation_id`),
  KEY `user_id_validation_fk` (`user_id`),
  CONSTRAINT `user_id_validation_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=233 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permission` (
  `permission_name` varchar(45) COLLATE utf8_turkish_ci NOT NULL,
  `insert_date` timestamp NULL DEFAULT NULL,
  `permission_description` varchar(45) COLLATE utf8_turkish_ci DEFAULT NULL,
  PRIMARY KEY (`permission_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(450) COLLATE utf8_turkish_ci DEFAULT NULL,
  `insert_date` timestamp NULL DEFAULT NULL,
  `is_active` varchar(45) COLLATE utf8_turkish_ci DEFAULT NULL,
  `asker_id` int(11) DEFAULT NULL,
  `up_vote` int(11) DEFAULT NULL,
  `down_vote` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `question_asker_fk` (`asker_id`)
) ENGINE=InnoDB AUTO_INCREMENT=321 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `role_permission`
--

DROP TABLE IF EXISTS `role_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_permission` (
  `role_permission_id` int(11) NOT NULL,
  `insert_date` timestamp NULL DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `role_name` varchar(45) COLLATE utf8_turkish_ci DEFAULT NULL,
  `permission_name` varchar(45) COLLATE utf8_turkish_ci DEFAULT NULL,
  PRIMARY KEY (`role_permission_id`),
  KEY `role_name_index` (`role_name`),
  KEY `rolepermission_permission_namefk_fk_idx` (`permission_name`),
  CONSTRAINT `rolepermission_permission_namefk_fk` FOREIGN KEY (`permission_name`) REFERENCES `permission` (`permission_name`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `rolepermission_role_namefk_fk` FOREIGN KEY (`role_name`) REFERENCES `roles` (`role_name`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `role_name` varchar(45) COLLATE utf8_turkish_ci NOT NULL,
  `insert_date` timestamp NULL DEFAULT NULL,
  `role_description` varchar(250) COLLATE utf8_turkish_ci DEFAULT NULL,
  PRIMARY KEY (`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) COLLATE utf8_turkish_ci DEFAULT NULL,
  `password` varchar(45) COLLATE utf8_turkish_ci DEFAULT NULL,
  `is_active` bit(1) NOT NULL,
  `name` varchar(45) COLLATE utf8_turkish_ci DEFAULT NULL,
  `surname` varchar(45) COLLATE utf8_turkish_ci DEFAULT NULL,
  `insert_date` datetime DEFAULT NULL,
  `role_name` varchar(45) COLLATE utf8_turkish_ci DEFAULT NULL,
  `email` varchar(80) COLLATE utf8_turkish_ci DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `user_role_fk_idx` (`role_name`),
  CONSTRAINT `user_role_pk` FOREIGN KEY (`role_name`) REFERENCES `roles` (`role_name`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=273 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `vote`
--

DROP TABLE IF EXISTS `vote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vote` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `type` varchar(4) COLLATE utf8_turkish_ci DEFAULT NULL,
  `date` timestamp NULL DEFAULT NULL,
  `is_cancelled` bit(1) DEFAULT NULL,
  `answer_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `vote_question_fk` (`question_id`),
  KEY `vote_user_fk` (`user_id`),
  CONSTRAINT `vote_question_fk` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `vote_user_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=373 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-07-08 23:31:05
