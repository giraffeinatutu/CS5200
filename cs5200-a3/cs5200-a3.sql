-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: hw3_riley_caitlin_fall_2017
-- ------------------------------------------------------
-- Server version	5.7.19

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
-- Table structure for table `Address`
--

DROP TABLE IF EXISTS `Address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `street1` varchar(45) DEFAULT NULL,
  `street2` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `zip` varchar(45) DEFAULT NULL,
  `primary` tinyint(4) DEFAULT NULL,
  `person_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`person_id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_Address_person1_idx` (`person_id`),
  CONSTRAINT `fk_Address_person1` FOREIGN KEY (`person_id`) REFERENCES `Person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Address`
--

LOCK TABLES `Address` WRITE;
/*!40000 ALTER TABLE `Address` DISABLE KEYS */;
/*!40000 ALTER TABLE `Address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Developer`
--

DROP TABLE IF EXISTS `Developer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Developer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `developerKey` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `developerKey_UNIQUE` (`id`),
  UNIQUE KEY `developerKey_UNIQUE1` (`developerKey`),
  KEY `id` (`id`),
  CONSTRAINT `developer_person_generalization` FOREIGN KEY (`id`) REFERENCES `Person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Developer`
--

LOCK TABLES `Developer` WRITE;
/*!40000 ALTER TABLE `Developer` DISABLE KEYS */;
INSERT INTO `Developer` (`id`, `developerKey`) VALUES (1,'4321rewq'),(2,'5432trew'),(5,'5678dfgh'),(3,'6543ytre'),(4,'7654fda');
/*!40000 ALTER TABLE `Developer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Page`
--

DROP TABLE IF EXISTS `Page`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Page` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `created` date DEFAULT NULL,
  `updated` date DEFAULT NULL,
  `views` int(11) DEFAULT NULL,
  `website_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`website_id`),
  UNIQUE KEY `pageID_UNIQUE` (`id`),
  KEY `title_UNIQUE` (`title`),
  KEY `fk_page_website1_idx` (`website_id`),
  CONSTRAINT `fk_page_website1` FOREIGN KEY (`website_id`) REFERENCES `Website` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=568 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Page`
--

LOCK TABLES `Page` WRITE;
/*!40000 ALTER TABLE `Page` DISABLE KEYS */;
INSERT INTO `Page` (`id`, `title`, `description`, `created`, `updated`, `views`, `website_id`) VALUES (1,'Home','Landing page',NULL,NULL,123434,5),(2,'About','Website description',NULL,NULL,234545,6),(3,'Contact','Addresses, phones, and contact info',NULL,NULL,345656,3),(4,'Preferences','Where users can configure their preferences',NULL,NULL,456776,4),(5,'Profile','Users can configure their personal information',NULL,NULL,567878,5);
/*!40000 ALTER TABLE `Page` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PagePriviledge`
--

DROP TABLE IF EXISTS `PagePriviledge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PagePriviledge` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `page_id` int(11) NOT NULL,
  `developer_id` int(11) NOT NULL,
  `priviledge` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `pagepriviledgeID_UNIQUE` (`id`),
  KEY `fk_PagePriviledge_Page1_idx` (`page_id`),
  KEY `fk_PagePriviledge_Developer1_idx` (`developer_id`),
  KEY `fk_PagePriviledge_Priviledge_idx` (`priviledge`),
  CONSTRAINT `fk_PagePriviledge_Developer1` FOREIGN KEY (`developer_id`) REFERENCES `Developer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_PagePriviledge_Page1` FOREIGN KEY (`page_id`) REFERENCES `Page` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_PagePriviledge_Priviledge` FOREIGN KEY (`priviledge`) REFERENCES `Priviledge` (`priviledge`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PagePriviledge`
--

LOCK TABLES `PagePriviledge` WRITE;
/*!40000 ALTER TABLE `PagePriviledge` DISABLE KEYS */;
/*!40000 ALTER TABLE `PagePriviledge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PageRole`
--

DROP TABLE IF EXISTS `PageRole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PageRole` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `developer_id` int(11) NOT NULL,
  `page_id` int(11) NOT NULL,
  `role` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`,`developer_id`,`page_id`),
  UNIQUE KEY `pageroleID_UNIQUE` (`id`),
  KEY `fk_PageRole_Page1_idx` (`page_id`),
  KEY `fk_PageRole_Developer1_idx` (`developer_id`),
  KEY `fk_PageRole_Role1_idx` (`role`),
  CONSTRAINT `fk_PageRole_Developer1` FOREIGN KEY (`developer_id`) REFERENCES `Developer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_PageRole_Page1` FOREIGN KEY (`page_id`) REFERENCES `Page` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_PageRole_Role1` FOREIGN KEY (`role`) REFERENCES `Role` (`role`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PageRole`
--

LOCK TABLES `PageRole` WRITE;
/*!40000 ALTER TABLE `PageRole` DISABLE KEYS */;
INSERT INTO `PageRole` (`id`, `developer_id`, `page_id`, `role`) VALUES (1,1,1,'editor'),(4,2,2,'editor'),(7,3,3,'editor'),(10,1,4,'editor'),(13,2,5,'editor'),(2,2,1,'reviewer'),(5,3,2,'reviewer'),(8,1,3,'reviewer'),(11,2,4,'reviewer'),(14,3,5,'reviewer'),(3,3,1,'writer'),(6,1,2,'writer'),(9,2,3,'writer'),(12,3,4,'writer'),(15,1,5,'writer');
/*!40000 ALTER TABLE `PageRole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Person`
--

DROP TABLE IF EXISTS `Person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `Type` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `dob` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`id`),
  KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Person`
--

LOCK TABLES `Person` WRITE;
/*!40000 ALTER TABLE `Person` DISABLE KEYS */;
INSERT INTO `Person` (`id`, `username`, `password`, `firstName`, `lastName`, `Type`, `email`, `dob`) VALUES (1,'alice','alice','Alice','Wonder','Developer','alice@wonder.com','2017-10-01'),(2,'bob','bob','Bob','Marley','Developer','bob@marley.com','2017-10-01'),(3,'charlie','charlie','Charlie','Garcia','Developer','chuch@garcia.com','2017-10-01'),(4,'dan','dan','Dan','Martin','Developer','dan@martin.com','2017-10-01'),(5,'ed','ed','Ed','Karaz','Developer','ed@kar.com','2017-10-01');
/*!40000 ALTER TABLE `Person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Phone`
--

DROP TABLE IF EXISTS `Phone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Phone` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(45) DEFAULT NULL,
  `primary` tinyint(4) DEFAULT NULL,
  `person_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`person_id`),
  UNIQUE KEY `phoneID_UNIQUE` (`id`),
  KEY `Phone_Person_Generalization_idx` (`person_id`),
  CONSTRAINT `phone_person_generalization` FOREIGN KEY (`person_id`) REFERENCES `Person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Phone`
--

LOCK TABLES `Phone` WRITE;
/*!40000 ALTER TABLE `Phone` DISABLE KEYS */;
/*!40000 ALTER TABLE `Phone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Priviledge`
--

DROP TABLE IF EXISTS `Priviledge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Priviledge` (
  `priviledge` varchar(15) NOT NULL,
  PRIMARY KEY (`priviledge`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Priviledge`
--

LOCK TABLES `Priviledge` WRITE;
/*!40000 ALTER TABLE `Priviledge` DISABLE KEYS */;
INSERT INTO `Priviledge` (`priviledge`) VALUES ('create'),('delete'),('read'),('update');
/*!40000 ALTER TABLE `Priviledge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Role`
--

DROP TABLE IF EXISTS `Role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Role` (
  `role` varchar(15) NOT NULL,
  PRIMARY KEY (`role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Role`
--

LOCK TABLES `Role` WRITE;
/*!40000 ALTER TABLE `Role` DISABLE KEYS */;
INSERT INTO `Role` (`role`) VALUES ('admin'),('editor'),('owner'),('reviewer'),('writer');
/*!40000 ALTER TABLE `Role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userKey` varchar(45) NOT NULL,
  `userAgreement` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `userID_UNIQUE` (`id`),
  UNIQUE KEY `userKey_UNIQUE` (`userKey`),
  CONSTRAINT `user_person_generalization` FOREIGN KEY (`id`) REFERENCES `Person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Website`
--

DROP TABLE IF EXISTS `Website`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Website` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `created` date DEFAULT NULL,
  `updated` date DEFAULT NULL,
  `visits` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `websiteID_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=679 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Website`
--

LOCK TABLES `Website` WRITE;
/*!40000 ALTER TABLE `Website` DISABLE KEYS */;
INSERT INTO `Website` (`id`, `name`, `description`, `created`, `updated`, `visits`) VALUES (1,'Facebook','an online social media and social networking service',NULL,NULL,1234234),(2,'Twitter','an online news and social networking service',NULL,NULL,4321543),(3,'Wikipedia','a free online encyclopedia',NULL,NULL,3456654),(4,'CNN','an American basic cable and satellite television news channel',NULL,NULL,6543345),(5,'CNET','an American media website that publishes reviews, news, articles, blogs, podcasts and videos on technology and consumer electronics',NULL,NULL,5433455),(6,'Gizmodo','a design, technology, science and science fiction website that also writes articles on politics',NULL,NULL,4322345);
/*!40000 ALTER TABLE `Website` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `WebsitePriviledge`
--

DROP TABLE IF EXISTS `WebsitePriviledge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `WebsitePriviledge` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `website_id` int(11) NOT NULL,
  `developer_id` int(11) NOT NULL,
  `priviledge` varchar(45) NOT NULL,
  PRIMARY KEY (`id`,`website_id`),
  UNIQUE KEY `webpriviledgeID_UNIQUE` (`id`),
  KEY `fk_websitePriviledge_website_idx` (`website_id`),
  KEY `fk_WebsitePriviledge_Priviledge_idx` (`priviledge`),
  KEY `fk_websitePriviledge_developer_idx` (`developer_id`),
  CONSTRAINT `fk_WebsitePriviledge_Priviledge` FOREIGN KEY (`priviledge`) REFERENCES `Priviledge` (`priviledge`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_websitePriviledge_developer` FOREIGN KEY (`developer_id`) REFERENCES `Developer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_websitePriviledge_website` FOREIGN KEY (`website_id`) REFERENCES `Website` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `WebsitePriviledge`
--

LOCK TABLES `WebsitePriviledge` WRITE;
/*!40000 ALTER TABLE `WebsitePriviledge` DISABLE KEYS */;
/*!40000 ALTER TABLE `WebsitePriviledge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `WebsiteRole`
--

DROP TABLE IF EXISTS `WebsiteRole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `WebsiteRole` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `developer_id` int(11) NOT NULL,
  `website_id` int(11) NOT NULL,
  `role` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`,`developer_id`,`website_id`),
  UNIQUE KEY `developerID_UNIQUE` (`id`),
  KEY `role_developer_idx` (`developer_id`),
  KEY `fk_WebsiteRole_Role_idx` (`role`),
  KEY `fk_WebsiteRole_Website_idx` (`website_id`),
  CONSTRAINT `fk_WebsiteRole_DeveloperID` FOREIGN KEY (`developer_id`) REFERENCES `Developer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_WebsiteRole_Role` FOREIGN KEY (`role`) REFERENCES `Role` (`role`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_WebsiteRole_Website` FOREIGN KEY (`website_id`) REFERENCES `Website` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `WebsiteRole`
--

LOCK TABLES `WebsiteRole` WRITE;
/*!40000 ALTER TABLE `WebsiteRole` DISABLE KEYS */;
INSERT INTO `WebsiteRole` (`id`, `developer_id`, `website_id`, `role`) VALUES (3,3,1,NULL),(6,1,2,'admin'),(9,2,3,'admin'),(12,3,4,'admin'),(15,1,5,'admin'),(16,3,6,'admin'),(18,2,6,'admin'),(2,2,1,'editor'),(5,3,2,'editor'),(8,1,3,'editor'),(11,2,4,'editor'),(14,3,5,'editor'),(17,1,6,'editor'),(1,1,1,'owner'),(4,2,2,'owner'),(7,3,3,'owner'),(10,1,4,'owner'),(13,2,5,'owner');
/*!40000 ALTER TABLE `WebsiteRole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Widget`
--

DROP TABLE IF EXISTS `Widget`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Widget` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `width` int(11) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `cssClass` varchar(45) DEFAULT NULL,
  `cssStyle` varchar(45) DEFAULT NULL,
  `text` varchar(45) DEFAULT NULL,
  `order` varchar(45) DEFAULT NULL,
  `type` varchar(15) NOT NULL,
  `url` varchar(45) DEFAULT NULL,
  `shareable` tinyint(4) DEFAULT NULL,
  `expandable` tinyint(4) DEFAULT NULL,
  `src` varchar(45) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `html` varchar(45) DEFAULT NULL,
  `page_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`page_id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `widgetID_UNIQUE` (`id`),
  KEY `fk_widget_page1_idx` (`page_id`),
  KEY `fk_widgetType_widget_idx` (`type`),
  CONSTRAINT `fk_widgetType_widget` FOREIGN KEY (`type`) REFERENCES `WidgetType` (`type`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_widget_page1` FOREIGN KEY (`page_id`) REFERENCES `Page` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Widget`
--

LOCK TABLES `Widget` WRITE;
/*!40000 ALTER TABLE `Widget` DISABLE KEYS */;
INSERT INTO `Widget` (`id`, `name`, `width`, `height`, `cssClass`, `cssStyle`, `text`, `order`, `type`, `url`, `shareable`, `expandable`, `src`, `size`, `html`, `page_id`) VALUES (1,'head123',NULL,NULL,NULL,NULL,'Welcome','0','heading',NULL,NULL,NULL,NULL,NULL,NULL,1),(2,'post234',NULL,NULL,NULL,NULL,'Lorem','0','html',NULL,NULL,NULL,NULL,NULL,'Lorem',2),(3,'head345',NULL,NULL,NULL,NULL,'Hi','1','heading',NULL,NULL,NULL,NULL,NULL,NULL,3),(4,'intro456',NULL,NULL,NULL,NULL,'<h1>Hi</h1>','2','html',NULL,NULL,NULL,NULL,NULL,'<h1>Hi</h1>',3),(5,'image345',50,100,NULL,NULL,NULL,'3','image',NULL,NULL,NULL,'/img/567.png',NULL,NULL,3),(6,'video456',400,300,NULL,NULL,NULL,'0','youtube','https://youtu.be/h67VX51QXiQ',NULL,NULL,NULL,NULL,NULL,4);
/*!40000 ALTER TABLE `Widget` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `WidgetType`
--

DROP TABLE IF EXISTS `WidgetType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `WidgetType` (
  `type` varchar(15) NOT NULL,
  PRIMARY KEY (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `WidgetType`
--

LOCK TABLES `WidgetType` WRITE;
/*!40000 ALTER TABLE `WidgetType` DISABLE KEYS */;
INSERT INTO `WidgetType` (`type`) VALUES ('Heading'),('Html'),('Image'),('YouTube');
/*!40000 ALTER TABLE `WidgetType` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-30 17:47:43
