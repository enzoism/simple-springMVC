/*
Navicat MySQL Data Transfer

Source Server         : Window本地连接
Source Server Version : 50537
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2017-06-10 18:34:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `username` varchar(12) DEFAULT NULL,
  `password` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2102 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'tony', '123456');
