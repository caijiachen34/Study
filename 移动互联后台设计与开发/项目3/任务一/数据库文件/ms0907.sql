CREATE DATABASE  IF NOT EXISTS `mobile_shop` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mobile_shop`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: mobile_shop
-- ------------------------------------------------------
-- Server version	5.6.14

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
-- Table structure for table `ms_brand`
--

DROP TABLE IF EXISTS `ms_brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ms_brand` (
  `brand_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `keywords` text,
  `description` text,
  `url` varchar(255) DEFAULT NULL,
  `disabled` tinyint(4) DEFAULT NULL,
  `creatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`brand_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_brand`
--

LOCK TABLES `ms_brand` WRITE;
/*!40000 ALTER TABLE `ms_brand` DISABLE KEYS */;
/*!40000 ALTER TABLE `ms_brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ms_cart`
--

DROP TABLE IF EXISTS `ms_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ms_cart` (
  `cart_id` int(11) NOT NULL AUTO_INCREMENT,
  `member_id` int(11) NOT NULL,
  `goods_id` int(11) DEFAULT NULL,
  `goods_num` int(11) DEFAULT NULL,
  `choose` tinyint(4) DEFAULT NULL,
  `amount` decimal(20,2) DEFAULT NULL,
  `creatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `midifytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_cart`
--

LOCK TABLES `ms_cart` WRITE;
/*!40000 ALTER TABLE `ms_cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `ms_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ms_goods`
--

DROP TABLE IF EXISTS `ms_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ms_goods` (
  `goods_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `sn` varchar(50) NOT NULL,
  `brief` varchar(255) NOT NULL,
  `description` text,
  `price` decimal(20,2) NOT NULL,
  `cost` decimal(20,2) NOT NULL,
  `mktprice` decimal(20,2) NOT NULL,
  `mkt_enable` tinyint(4) NOT NULL,
  `cat_id` int(11) DEFAULT NULL,
  `brand_id` int(11) DEFAULT NULL,
  `weight` decimal(20,2) NOT NULL,
  `intro` text,
  `params` text,
  `specs` text,
  `creatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_modify` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `view_count` int(11) DEFAULT NULL,
  `buy_count` int(11) DEFAULT NULL,
  `thumbnail` varchar(255) DEFAULT NULL,
  `big` varchar(255) DEFAULT NULL,
  `small` varchar(255) DEFAULT NULL,
  `original` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_goods`
--

LOCK TABLES `ms_goods` WRITE;
/*!40000 ALTER TABLE `ms_goods` DISABLE KEYS */;
/*!40000 ALTER TABLE `ms_goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ms_goods_cat`
--

DROP TABLE IF EXISTS `ms_goods_cat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ms_goods_cat` (
  `cat_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `cat_path` varchar(100) NOT NULL,
  `goods_count` int(8) DEFAULT NULL,
  `sort` int(5) DEFAULT NULL,
  `type_id` int(11) NOT NULL,
  `list_show` tinyint(4) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `creatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`cat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_goods_cat`
--

LOCK TABLES `ms_goods_cat` WRITE;
/*!40000 ALTER TABLE `ms_goods_cat` DISABLE KEYS */;
/*!40000 ALTER TABLE `ms_goods_cat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ms_goods_comment`
--

DROP TABLE IF EXISTS `ms_goods_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ms_goods_comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `goods_id` int(11) NOT NULL,
  `member_id` int(11) NOT NULL,
  `score` tinyint(4) NOT NULL,
  `content` text,
  `isopen` tinyint(4) NOT NULL,
  `creatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_goods_comment`
--

LOCK TABLES `ms_goods_comment` WRITE;
/*!40000 ALTER TABLE `ms_goods_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `ms_goods_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ms_goods_img`
--

DROP TABLE IF EXISTS `ms_goods_img`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ms_goods_img` (
  `img_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_id` int(11) DEFAULT NULL,
  `thumbnail` varchar(225) DEFAULT NULL,
  `big` varchar(225) DEFAULT NULL,
  `small` varchar(225) DEFAULT NULL,
  `original` varchar(225) DEFAULT NULL,
  `isdefault` smallint(6) DEFAULT NULL,
  `creatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`img_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_goods_img`
--

LOCK TABLES `ms_goods_img` WRITE;
/*!40000 ALTER TABLE `ms_goods_img` DISABLE KEYS */;
/*!40000 ALTER TABLE `ms_goods_img` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ms_goods_like`
--

DROP TABLE IF EXISTS `ms_goods_like`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ms_goods_like` (
  `like_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_id` int(11) NOT NULL,
  `member_id` int(11) NOT NULL,
  `creatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`like_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_goods_like`
--

LOCK TABLES `ms_goods_like` WRITE;
/*!40000 ALTER TABLE `ms_goods_like` DISABLE KEYS */;
/*!40000 ALTER TABLE `ms_goods_like` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ms_goods_store`
--

DROP TABLE IF EXISTS `ms_goods_store`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ms_goods_store` (
  `store_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_id` int(11) NOT NULL,
  `store` int(8) NOT NULL,
  `enable_store` int(8) NOT NULL,
  `operate_type` tinyint(4) NOT NULL,
  `intime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `outime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`store_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_goods_store`
--

LOCK TABLES `ms_goods_store` WRITE;
/*!40000 ALTER TABLE `ms_goods_store` DISABLE KEYS */;
/*!40000 ALTER TABLE `ms_goods_store` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ms_goods_type`
--

DROP TABLE IF EXISTS `ms_goods_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ms_goods_type` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `props` text,
  `params` text,
  `disabled` tinyint(4) DEFAULT NULL,
  `is_physical` tinyint(4) DEFAULT NULL,
  `creatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_goods_type`
--

LOCK TABLES `ms_goods_type` WRITE;
/*!40000 ALTER TABLE `ms_goods_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `ms_goods_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ms_logi`
--

DROP TABLE IF EXISTS `ms_logi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ms_logi` (
  `logi_id` int(11) NOT NULL AUTO_INCREMENT,
  `ship_id` int(11) NOT NULL,
  `sn` varchar(50) NOT NULL,
  `carriage` decimal(20,2) DEFAULT NULL,
  `sender` varchar(50) DEFAULT NULL,
  `status` smallint(6) DEFAULT NULL,
  `creatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`logi_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_logi`
--

LOCK TABLES `ms_logi` WRITE;
/*!40000 ALTER TABLE `ms_logi` DISABLE KEYS */;
/*!40000 ALTER TABLE `ms_logi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ms_member`
--

DROP TABLE IF EXISTS `ms_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ms_member` (
  `member_id` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `sex` smallint(6) DEFAULT NULL,
  `mobile` varchar(50) DEFAULT NULL,
  `regtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `lastlogin` timestamp NULL DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_member`
--

LOCK TABLES `ms_member` WRITE;
/*!40000 ALTER TABLE `ms_member` DISABLE KEYS */;
INSERT INTO `ms_member` VALUES (2,'李四','123456','ls@qq.com',0,'13687654321','2016-09-07 06:31:05',NULL,''),(3,'王五','123456','ww@qq.com',0,'13643218765','2016-09-07 06:32:50',NULL,'');
/*!40000 ALTER TABLE `ms_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ms_member_address`
--

DROP TABLE IF EXISTS `ms_member_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ms_member_address` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `member_id` int(11) NOT NULL,
  `provice` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `region` varchar(50) DEFAULT NULL,
  `addr` text,
  `mobile` varchar(50) NOT NULL,
  `receiver` varchar(50) NOT NULL,
  `creatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_member_address`
--

LOCK TABLES `ms_member_address` WRITE;
/*!40000 ALTER TABLE `ms_member_address` DISABLE KEYS */;
INSERT INTO `ms_member_address` VALUES (2,2,'广东省','深圳市','南山区','西丽','13971986543','李素素','2016-09-07 06:35:43','2016-09-07 06:35:43'),(3,2,'广东省','深圳市','南山区','西丽','13976543198','李诗诗','2016-09-07 06:36:21','2016-09-07 06:36:21'),(4,2,'黑龙江省','哈尔滨市','南岗区','南岗','13576319854','李思思','2016-09-07 06:37:43','2016-09-07 06:37:43'),(5,2,'广东省','深圳市','罗湖区','罗湖体育馆','13598763154','张丽丽','2016-09-07 06:39:01','2016-09-07 06:39:01'),(6,2,'黑龙江省','哈尔滨市','道里区','和平路','13971986543','李素素','2016-09-07 06:40:18','2016-09-07 06:40:18'),(7,2,'黑龙江省','哈尔滨市','道里区','和平路','13598763154','张丽丽','2016-09-07 06:40:57','2016-09-07 06:40:57'),(8,2,'湖北省','武汉市','武昌区','武昌','13598763154','张丹丹','2016-09-07 06:41:45','2016-09-07 06:41:45'),(9,3,'湖北省','武汉市','汉阳区','汉阳','13376315498','王舞舞','2016-09-07 06:43:06','2016-09-07 06:43:06');
/*!40000 ALTER TABLE `ms_member_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ms_order`
--

DROP TABLE IF EXISTS `ms_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ms_order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `sn` varchar(255) NOT NULL,
  `member_id` int(11) DEFAULT NULL,
  `status` smallint(6) DEFAULT NULL,
  `payment_id` int(11) DEFAULT NULL,
  `logi_id` int(11) DEFAULT NULL,
  `total_amount` decimal(20,2) DEFAULT NULL,
  `address_id` char(10) DEFAULT NULL,
  `creatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_order`
--

LOCK TABLES `ms_order` WRITE;
/*!40000 ALTER TABLE `ms_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `ms_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ms_order_goods`
--

DROP TABLE IF EXISTS `ms_order_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ms_order_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_sn` varchar(255) NOT NULL,
  `goods_id` int(11) NOT NULL,
  `goods_num` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_order_goods`
--

LOCK TABLES `ms_order_goods` WRITE;
/*!40000 ALTER TABLE `ms_order_goods` DISABLE KEYS */;
/*!40000 ALTER TABLE `ms_order_goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ms_order_log`
--

DROP TABLE IF EXISTS `ms_order_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ms_order_log` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `order_status` varchar(50) NOT NULL,
  `status_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_order_log`
--

LOCK TABLES `ms_order_log` WRITE;
/*!40000 ALTER TABLE `ms_order_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `ms_order_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ms_payment`
--

DROP TABLE IF EXISTS `ms_payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ms_payment` (
  `payment_id` int(11) NOT NULL AUTO_INCREMENT,
  `sn` varchar(50) DEFAULT NULL,
  `paytype_id` int(11) DEFAULT NULL,
  `amount` decimal(20,2) DEFAULT NULL,
  `status` smallint(6) DEFAULT NULL,
  `paytime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `remark` text,
  PRIMARY KEY (`payment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_payment`
--

LOCK TABLES `ms_payment` WRITE;
/*!40000 ALTER TABLE `ms_payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `ms_payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ms_paytype`
--

DROP TABLE IF EXISTS `ms_paytype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ms_paytype` (
  `paytype_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `config` text,
  `description` text,
  `creatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`paytype_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_paytype`
--

LOCK TABLES `ms_paytype` WRITE;
/*!40000 ALTER TABLE `ms_paytype` DISABLE KEYS */;
/*!40000 ALTER TABLE `ms_paytype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ms_ship`
--

DROP TABLE IF EXISTS `ms_ship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ms_ship` (
  `ship_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `code` varchar(50) DEFAULT NULL,
  `creatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`ship_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_ship`
--

LOCK TABLES `ms_ship` WRITE;
/*!40000 ALTER TABLE `ms_ship` DISABLE KEYS */;
/*!40000 ALTER TABLE `ms_ship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ms_tag`
--

DROP TABLE IF EXISTS `ms_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ms_tag` (
  `tag_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `type` tinyint(4) NOT NULL,
  `count` int(11) NOT NULL,
  `sort` smallint(6) DEFAULT NULL,
  `team` tinyint(4) NOT NULL,
  `creatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_tag`
--

LOCK TABLES `ms_tag` WRITE;
/*!40000 ALTER TABLE `ms_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `ms_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ms_tag_brand_ref`
--

DROP TABLE IF EXISTS `ms_tag_brand_ref`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ms_tag_brand_ref` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tag_id` int(11) NOT NULL,
  `brand_id` int(11) NOT NULL,
  `sort` smallint(6) DEFAULT NULL,
  `creatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_tag_brand_ref`
--

LOCK TABLES `ms_tag_brand_ref` WRITE;
/*!40000 ALTER TABLE `ms_tag_brand_ref` DISABLE KEYS */;
/*!40000 ALTER TABLE `ms_tag_brand_ref` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ms_tag_goods_ref`
--

DROP TABLE IF EXISTS `ms_tag_goods_ref`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ms_tag_goods_ref` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tag_id` int(11) NOT NULL,
  `goods_id` int(11) NOT NULL,
  `sort` smallint(6) DEFAULT NULL,
  `creatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_tag_goods_ref`
--

LOCK TABLES `ms_tag_goods_ref` WRITE;
/*!40000 ALTER TABLE `ms_tag_goods_ref` DISABLE KEYS */;
/*!40000 ALTER TABLE `ms_tag_goods_ref` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ms_type_brand`
--

DROP TABLE IF EXISTS `ms_type_brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ms_type_brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_id` int(11) NOT NULL,
  `brand_id` int(11) NOT NULL,
  `creatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_type_brand`
--

LOCK TABLES `ms_type_brand` WRITE;
/*!40000 ALTER TABLE `ms_type_brand` DISABLE KEYS */;
/*!40000 ALTER TABLE `ms_type_brand` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-07 14:46:53
