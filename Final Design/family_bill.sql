/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : localhost:3306
 Source Schema         : family_bill

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 09/09/2020 23:10:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for fb_account
-- ----------------------------
DROP TABLE IF EXISTS `fb_account`;
CREATE TABLE `fb_account`  (
  `account_id` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `accountMoney` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `accountType` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '消费类型',
  `payType` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支出/收入',
  `assetsType` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '银行卡/支付宝/微信',
  `time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`account_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fb_account
-- ----------------------------
INSERT INTO `fb_account` VALUES (2, '888', '100.0', '购物', '支出', '银行卡', '2020-09-01 16:04:58', '黄焖鸡');
INSERT INTO `fb_account` VALUES (6, '888', '2000.0', '饮食', '收入', '支付宝', '2020-09-04 12:13:06', '黄焖鸡');
INSERT INTO `fb_account` VALUES (12, '888', '100.5', '购物', '支出', '微信', '2020-09-04 15:46:06', '100');
INSERT INTO `fb_account` VALUES (13, '888', '500.0', '学习', '支出', '微信', '2020-09-04 15:52:24', '500');
INSERT INTO `fb_account` VALUES (14, '888', '600.0', '旅游', '支出', '银行卡', '2020-09-05 10:48:50', '600');
INSERT INTO `fb_account` VALUES (15, '888', '50.0', '交通', '支出', '微信', '2020-09-05 11:24:18', 'taxi');
INSERT INTO `fb_account` VALUES (16, '999', '2000.5', '医疗', '支出', '支付宝', '2020-09-05 11:26:54', '感冒药');
INSERT INTO `fb_account` VALUES (18, '888', '500.0', '购物', '支出', '微信', '2020-09-06 15:01:07', '鸡米饭');
INSERT INTO `fb_account` VALUES (19, '888', '200.0', '购物', '收入', '支付宝', '2020-09-09 09:45:19', '200');
INSERT INTO `fb_account` VALUES (20, '888', '400.0', '工资', '收入', '微信', '2020-09-09 17:12:50', '');

-- ----------------------------
-- Table structure for fb_assets
-- ----------------------------
DROP TABLE IF EXISTS `fb_assets`;
CREATE TABLE `fb_assets`  (
  `assets_id` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `assetsType` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '现金/银行卡...',
  `assetsMoney` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `moneyRemain` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`assets_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fb_assets
-- ----------------------------
INSERT INTO `fb_assets` VALUES (1, '777', '银行卡', '8000.0', '工资', NULL);
INSERT INTO `fb_assets` VALUES (2, '777', '银行卡', '8000.0', '工资1', NULL);
INSERT INTO `fb_assets` VALUES (4, '888', '微信', '500.0', '微信', NULL);
INSERT INTO `fb_assets` VALUES (5, '888', '银行卡1', '9999.5', '工资2222', NULL);
INSERT INTO `fb_assets` VALUES (6, '888', '银行卡', '9999.0', '工资2222', NULL);
INSERT INTO `fb_assets` VALUES (7, '999', '银行卡', '9999.0', '工资2222', NULL);
INSERT INTO `fb_assets` VALUES (8, '999', '银行卡', '9999.0', '工资2222', NULL);
INSERT INTO `fb_assets` VALUES (9, '999', '银行卡', '9999.0', '工资2222', NULL);
INSERT INTO `fb_assets` VALUES (10, '555', '银行卡', '8000.0', '工资2', NULL);
INSERT INTO `fb_assets` VALUES (11, '666', '银行卡', '8000.0', '工资2', NULL);
INSERT INTO `fb_assets` VALUES (13, '888', '支付宝', '500.0', '支付宝添加500', NULL);

-- ----------------------------
-- Table structure for fb_member
-- ----------------------------
DROP TABLE IF EXISTS `fb_member`;
CREATE TABLE `fb_member`  (
  `member_id` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` smallint(6) NULL DEFAULT NULL,
  `mobile` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `regtime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `lastlogin` timestamp(0) NULL DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`member_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fb_member
-- ----------------------------
INSERT INTO `fb_member` VALUES (1, '123456', 'bcbfacabae00b238a2e1b4db63dd7d70', '123456@qq.com', 0, '123456', '2020-08-24 20:52:41', '2020-08-27 16:02:40', '');
INSERT INTO `fb_member` VALUES (2, 'cjc', 'f8bffc12f4d2e04ff8445fd371ebf79e', 'caijiachen34@1126.com', 0, NULL, '2020-08-26 13:16:36', '2020-08-30 15:14:05', '');
INSERT INTO `fb_member` VALUES (3, '111', '47e971027299db6b64bdcecbb977a00a', '111@qq.com', 0, '111', '2020-08-27 12:35:18', '2020-09-03 13:21:13', '');
INSERT INTO `fb_member` VALUES (4, '789', '386c604e65388eb30c8274e80e23d345', '', 0, '', '2020-08-27 13:26:50', '2020-08-27 13:27:10', '');
INSERT INTO `fb_member` VALUES (5, '888', '9800f6d4589d031d129616d85725a8b8', '888', 0, '888', '2020-08-27 14:07:13', '2020-09-09 20:00:49', '');
INSERT INTO `fb_member` VALUES (6, '123', '37cc4f8e788c409bc31abe00788bd468', '123', 0, '123', '2020-08-27 15:37:26', '2020-08-27 15:37:45', '');
INSERT INTO `fb_member` VALUES (7, '8889', '48e7f37ad4921d7b88492a7ffdf06c24', '8889', 1, '8889', '2020-08-27 16:03:43', NULL, '');
INSERT INTO `fb_member` VALUES (8, '88899', '48e7f37ad4921d7b88492a7ffdf06c24', '88899', 0, '88899', '2020-08-27 16:05:39', '2020-08-27 18:36:15', '');
INSERT INTO `fb_member` VALUES (9, '969', '1765a9678bd69dda2876b7e59e448d08', '969', 1, '96', '2020-08-27 16:07:20', NULL, '');
INSERT INTO `fb_member` VALUES (10, '15961083511', 'f8bffc12f4d2e04ff8445fd371ebf79e', '15961083511', 1, NULL, '2020-08-27 16:48:57', NULL, '');
INSERT INTO `fb_member` VALUES (11, '888666', '9800f6d4589d031d129616d85725a8b8', '888333', 1, '88855', '2020-08-28 11:00:51', NULL, '');
INSERT INTO `fb_member` VALUES (12, '333', 'c94f3ddc749534dacb7993ea14f74ffd', '333', 1, '333', '2020-08-28 11:02:25', NULL, '');
INSERT INTO `fb_member` VALUES (13, '9999', '233317a8036db34c2348db4c581d2e5e', '9999', 1, '9999', '2020-08-28 11:12:30', NULL, '');
INSERT INTO `fb_member` VALUES (14, '6666', 'be7a6a2bb486e2d24c84ee43744e6266', '6666', 1, '6666', '2020-08-28 11:13:05', NULL, '');
INSERT INTO `fb_member` VALUES (15, '777', '2fcebec7eded31f6843362bf6fd344c4', '777', 1, '777', '2020-08-28 11:14:57', NULL, '');
INSERT INTO `fb_member` VALUES (16, '66666', '7d50f79b6d29dd5eaf9034694967b76b', '66666', 1, '66666', '2020-08-28 11:16:29', NULL, '');
INSERT INTO `fb_member` VALUES (17, '1212', '4616355a7368ba396a587d01fe926952', '1212', 1, '1212', '2020-08-28 11:39:58', NULL, '');
INSERT INTO `fb_member` VALUES (18, '1313', 'bc81485541cd01a20b9bd03b99a8a493', '1313', 1, '1313', '2020-08-28 11:40:31', NULL, '');
INSERT INTO `fb_member` VALUES (19, '2323', '190ceeb9ab3235e498aa070acfa96d6f', '2323', 1, '2323', '2020-08-28 11:41:48', NULL, '');
INSERT INTO `fb_member` VALUES (20, '3232', 'ad681ec58c4237006c1ff9d90a15761b', '3232', 1, '3232', '2020-08-28 11:43:13', NULL, '');
INSERT INTO `fb_member` VALUES (21, '9898', '1cf5a2bfc51a176f6f0d2291982a1140', '9898', 0, '9898', '2020-08-28 11:46:01', '2020-08-28 13:43:26', '');
INSERT INTO `fb_member` VALUES (22, '5566', 'd70ddc1a5214cf40e68262db2207eb05', '5566', 1, '5566', '2020-08-28 12:03:41', NULL, '');
INSERT INTO `fb_member` VALUES (23, '7788', '7788', '7788', 0, '7788', '2020-08-28 12:05:16', '2020-08-29 15:20:22', '');
INSERT INTO `fb_member` VALUES (24, '8888', '2272524934fa8c71de0686be0370d67d', '8888@126.com', 1, '15961083511', '2020-08-28 13:34:05', NULL, '');
INSERT INTO `fb_member` VALUES (25, '99999', 'f06c7f5e6b4b8de31d1f2ee5fd170704', '99999@126.com', 1, '15961083512', '2020-08-28 13:35:30', NULL, '');
INSERT INTO `fb_member` VALUES (26, '999', '2b9c8bad2704db4ed2a17aaf3141cb4d', '999', 0, '999', '2020-09-03 15:54:32', '2020-09-05 17:40:09', '');

-- ----------------------------
-- Function structure for assetsRemain
-- ----------------------------
DROP FUNCTION IF EXISTS `assetsRemain`;
delimiter ;;
CREATE FUNCTION `assetsRemain`(uname1 CHAR(20),assetsType1 CHAR(20))
 RETURNS double
BEGIN

	DECLARE money DOUBLE;
	DECLARE count DOUBLE;
	
	set money = 0.0;
	set count = 0.0;
	
	SELECT fb_assets.assetsMoney FROM fb_assets WHERE fb_assets.uname = uname1 and fb_assets.assetsType = assetsType1 INTO money;
	SELECT totalAccount(uname1,assetsType1) into count;
	RETURN count + money;
	
	END
;;
delimiter ;

-- ----------------------------
-- Function structure for sumaccount
-- ----------------------------
DROP FUNCTION IF EXISTS `sumaccount`;
delimiter ;;
CREATE FUNCTION `sumaccount`(uname1 CHAR(20),payType1 CHAR(20),assetsType1 CHAR(20))
 RETURNS double
BEGIN
DECLARE s1 DOUBLE;
SET s1 = 0.0;
	SELECT SUM(fb_account.accountMoney) FROM fb_account WHERE fb_account.uname = `uname1` and fb_account.payType=`payType1` and fb_account.assetsType=`assetsType1` INTO s1;
	IF s1 is NOT NULL THEN
	RETURN s1;
	else
	RETURN 0.0;
	END IF;
	END
;;
delimiter ;

-- ----------------------------
-- Function structure for totalAccount
-- ----------------------------
DROP FUNCTION IF EXISTS `totalAccount`;
delimiter ;;
CREATE FUNCTION `totalAccount`(uname1 CHAR(20),assetsType1 CHAR(20))
 RETURNS double
BEGIN

DECLARE ss1  double;
DECLARE ss2  double;
	
	SET ss1 = 0.0;
	SET ss2 = 0.0;
	
	SELECT sumaccount(uname1,'支出',assetsType1) into ss1;
	SELECT sumaccount(uname1,'收入',assetsType1) into ss2;
	RETURN ss2 - ss1;
	END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
