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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_brand`
--

LOCK TABLES `ms_brand` WRITE;
/*!40000 ALTER TABLE `ms_brand` DISABLE KEYS */;
INSERT INTO `ms_brand` VALUES (2,'良品铺子','','休闲食品','良品铺子是一家集休闲食品研发、加工分装、零售服务的专业品牌连锁运营公司','',0,'2016-09-07 07:02:05','2016-09-07 07:02:05'),(3,'三只松鼠','','坚果，零食','三只松鼠成立于2012年,是中国当前最大的互联网食品品牌，其坚果系列位居全网销量第一','',0,'2016-09-07 07:04:35','2016-09-07 07:04:35'),(4,'ochirly','','女装','ochirly欧时力设计主题:复古星魅、魅惑几何、迷人条纹。','',0,'2016-09-07 07:06:12','2016-09-07 07:06:12'),(5,'美之源','','果汁','美汁源是第一家进入浓缩果汁市场的公司。由可口可乐公司所拥有，为世界最大的果汁饮料销售商。','',0,'2016-09-08 00:57:52','2016-09-09 02:40:54'),(6,'汇源','','果汁','汇源果汁是由中国汇源果汁集团生产的一系列果汁产品,“汇源果汁”是中国果汁行业知名品牌。','',0,'2016-09-08 00:59:17','2016-09-08 00:59:17'),(7,'和其正','','凉茶','和其正是福建达利园集团生产的一个凉茶的名称，是中国凉茶行业的一支劲旅，一匹黑马。','',0,'2016-09-08 01:00:48','2016-09-08 01:00:48'),(9,'康师傅','','饮料，方便面，糕饼','康师傅控股有限公司（康师傅公司），总部设于天津市，主要在中国从事生产和销售方便面、饮品、糕饼以及相关配套产业的经营。','',0,'2016-09-08 01:21:42','2016-09-08 01:21:42');
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
  `creatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_modify` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `view_count` int(11) DEFAULT NULL,
  `buy_count` int(11) DEFAULT NULL,
  `thumbnail` varchar(255) DEFAULT NULL,
  `big` varchar(255) DEFAULT NULL,
  `small` varchar(255) DEFAULT NULL,
  `original` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_goods`
--

LOCK TABLES `ms_goods` WRITE;
/*!40000 ALTER TABLE `ms_goods` DISABLE KEYS */;
INSERT INTO `ms_goods` VALUES (2,'汇源果汁 100%纯果汁 苹果汁','hygz002','汇源100%苹果汁1L 出口标准升级装非可乐碳酸凉菜饮料','',24.99,20.00,30.00,0,2,6,1000.00,'','','2016-09-08 06:17:55','2016-09-09 07:24:25',0,0,'','','',''),(4,'汇源果汁 100%纯橙汁 橙汁','hygz001','汇源100%橙汁1L 出口标准升级装非可乐碳酸凉菜饮料','',23.88,20.00,30.00,0,2,6,1000.00,'','','2016-09-08 06:21:54','2016-09-08 06:21:54',0,0,'','','',''),(5,'汇源100%纯果汁 桃汁1L','hygz003','汇源100%橙汁1L 出口标准升级装非可乐碳酸凉菜饮料','',23.88,20.00,30.00,0,2,6,1000.00,'','','2016-09-09 07:42:38','2016-09-09 07:42:38',0,0,'','','','');
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_goods_cat`
--

LOCK TABLES `ms_goods_cat` WRITE;
/*!40000 ALTER TABLE `ms_goods_cat` DISABLE KEYS */;
INSERT INTO `ms_goods_cat` VALUES (1,'饮料',0,'0,1',0,0,4,0,'','2016-09-08 03:48:15','2016-09-08 03:48:15'),(2,'果蔬饮料',1,'0,1,1',0,0,4,0,'','2016-09-08 03:50:27','2016-09-08 03:50:27'),(4,'茶饮料',1,'0,1,2',0,0,4,0,'','2016-09-08 03:55:00','2016-09-09 07:12:21');
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_goods_img`
--

LOCK TABLES `ms_goods_img` WRITE;
/*!40000 ALTER TABLE `ms_goods_img` DISABLE KEYS */;
INSERT INTO `ms_goods_img` VALUES (1,2,'5_thumbnail.jpg','5_big.jpg','5_small.jpg','5_original.jpg',0,'2016-09-19 03:29:18','2016-09-19 03:29:18'),(3,4,'7_thumbnail.jpg','7_big.jpg','7_small.jpg','7_original.jpg',1,'2016-09-19 03:34:27','2016-09-19 06:36:51');
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_goods_like`
--

LOCK TABLES `ms_goods_like` WRITE;
/*!40000 ALTER TABLE `ms_goods_like` DISABLE KEYS */;
INSERT INTO `ms_goods_like` VALUES (1,2,3,'2016-09-19 07:41:10','2016-09-19 07:47:14'),(2,4,2,'2016-09-19 07:42:18','2016-09-19 07:42:18');
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
  `outime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`store_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_goods_store`
--

LOCK TABLES `ms_goods_store` WRITE;
/*!40000 ALTER TABLE `ms_goods_store` DISABLE KEYS */;
INSERT INTO `ms_goods_store` VALUES (2,2,98,98,1,'2016-09-09 09:10:10','2016-09-09 09:18:00'),(3,4,200,198,0,'2016-09-09 09:11:23',NULL),(4,5,155,150,0,'2016-09-09 09:11:51',NULL);
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
  `params` text,
  `disabled` tinyint(4) DEFAULT NULL,
  `is_physical` tinyint(4) DEFAULT NULL,
  `creatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifytime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_goods_type`
--

LOCK TABLES `ms_goods_type` WRITE;
/*!40000 ALTER TABLE `ms_goods_type` DISABLE KEYS */;
INSERT INTO `ms_goods_type` VALUES (4,'饮料','{\"参数\":{\"产地\":\"\",\"储存方法\":\"\",\"净含量\":\"\",\"保质期\":\"\",\"口味\":\"\",\"配料\":\"\"}}',0,0,'2016-09-07 09:23:20','2016-09-07 09:23:20'),(5,'酒水','{\"参数\":{\"产地\":\"\",\"储存方法\":\"\",\"品种\":\"\",\"净含量\":\"\",\"保质期\":\"\",\"配料\":\"\"}}',0,0,'2016-09-07 09:25:26','2016-09-07 09:25:26'),(6,'酒水test','{\"参数\":{\"产地\":\"\",\"储存方法\":\"\",\"品种\":\"\",\"净含量\":\"\",\"保质期\":\"\",\"配料\":\"\"}}',0,0,'2016-09-08 07:47:19','2016-09-08 07:51:41');
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
INSERT INTO `ms_member` VALUES (2,'李四','123456','ls@qq.com',0,'13887432165','2016-09-07 06:31:05',NULL,''),(3,'王五','123456','ww@qq.com',0,'13643218765','2016-09-07 06:32:50',NULL,'');
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_tag`
--

LOCK TABLES `ms_tag` WRITE;
/*!40000 ALTER TABLE `ms_tag` DISABLE KEYS */;
INSERT INTO `ms_tag` VALUES (2,'本周热卖',0,5,0,1,'2016-09-08 06:30:59','2016-09-08 06:30:59'),(3,'商家推荐',0,5,0,1,'2016-09-08 06:31:29','2016-09-08 06:31:29'),(4,'品牌1',1,6,0,0,'2016-09-08 06:37:53','2016-09-09 07:34:44'),(5,'品牌2',1,6,0,0,'2016-09-08 06:38:18','2016-09-08 06:38:18');
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_tag_brand_ref`
--

LOCK TABLES `ms_tag_brand_ref` WRITE;
/*!40000 ALTER TABLE `ms_tag_brand_ref` DISABLE KEYS */;
INSERT INTO `ms_tag_brand_ref` VALUES (1,4,3,0,'2016-09-08 07:04:51','2016-09-09 08:28:48'),(2,4,6,0,'2016-09-08 07:05:02','2016-09-08 07:05:02');
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_tag_goods_ref`
--

LOCK TABLES `ms_tag_goods_ref` WRITE;
/*!40000 ALTER TABLE `ms_tag_goods_ref` DISABLE KEYS */;
INSERT INTO `ms_tag_goods_ref` VALUES (1,2,2,0,'2016-09-08 06:50:39','2016-09-08 06:50:39'),(2,2,5,0,'2016-09-08 06:51:32','2016-09-09 07:44:50');
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_type_brand`
--

LOCK TABLES `ms_type_brand` WRITE;
/*!40000 ALTER TABLE `ms_type_brand` DISABLE KEYS */;
INSERT INTO `ms_type_brand` VALUES (2,4,6,'2016-09-08 01:04:04','2016-09-08 01:04:04'),(4,4,5,'2016-09-08 01:22:14','2016-09-09 02:50:31');
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

-- Dump completed on 2016-09-20 11:05:47
