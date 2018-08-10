/*
Navicat MySQL Data Transfer

Source Server         : aws-amer
Source Server Version : 50723
Source Host           : 34.236.145.58:3306
Source Database       : CT

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2018-08-10 18:42:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for 16se3
-- ----------------------------
DROP TABLE IF EXISTS `16se3`;
CREATE TABLE `16se3` (
  `ctid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `stime` int(11) DEFAULT NULL,
  `etime` int(11) DEFAULT NULL,
  `week` int(255) DEFAULT NULL,
  `sweek` int(255) DEFAULT NULL,
  `eweek` int(255) DEFAULT NULL,
  `place` varchar(255) DEFAULT NULL,
  `teacher` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ctid`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of 16se3
-- ----------------------------
INSERT INTO `16se3` VALUES ('1', 'JavaEE技术', '1', '2', '1', '12', '17', '36-610', '夏竹青');
INSERT INTO `16se3` VALUES ('2', '软件分析与设计', '1', '2', '1', '3', '11', '35-203', '张家锐');
INSERT INTO `16se3` VALUES ('3', '操作系统', '3', '4', '1', '13', '18', '36-606', '崔海莉');
INSERT INTO `16se3` VALUES ('4', '计算机组成与结构', '5', '6', '1', '15', '16', '36-401', '刘洁群');
INSERT INTO `16se3` VALUES ('5', '计算方法', '5', '6', '1', '3', '14', '36-1JT', '谢进');
INSERT INTO `16se3` VALUES ('6', '计算机组成与结构', '7', '8', '1', '15', '16', '36-401', '刘洁群');
INSERT INTO `16se3` VALUES ('7', '软件分析与设计', '7', '8', '1', '4', '12', '36-608', '张家锐');
INSERT INTO `16se3` VALUES ('8', 'JavaEE技术', '1', '2', '2', '11', '18', '36-201', '许强');
INSERT INTO `16se3` VALUES ('9', '操作系统', '3', '4', '2', '8', '18', '35-412', '屠菁');
INSERT INTO `16se3` VALUES ('10', '计算方法', '1', '2', '3', '3', '14', '36-1JT', '谢进');
INSERT INTO `16se3` VALUES ('11', '计算机组成与结构', '5', '6', '3', '3', '16', '35-409', '张向东');
INSERT INTO `16se3` VALUES ('12', '软件分析与设计', '7', '8', '3', '3', '11', '36-210', '张家锐');
INSERT INTO `16se3` VALUES ('13', 'JavaEE技术', '1', '2', '4', '12', '18', '36-610', '夏竹青');
INSERT INTO `16se3` VALUES ('14', '软件分析与设计', '1', '2', '4', '4', '11', '36-608', '张家锐');
INSERT INTO `16se3` VALUES ('15', 'JavaEE技术', '3', '4', '4', '11', '17', '35-203', '许强');
INSERT INTO `16se3` VALUES ('16', '计算机组成与结构', '5', '6', '4', '12', '14', '36-401', '刘洁群');
INSERT INTO `16se3` VALUES ('17', '操作系统', '7', '8', '4', '8', '18', '36-201', '屠菁');
INSERT INTO `16se3` VALUES ('18', '计算机组成与结构', '1', '2', '5', '3', '16', '36-201', '张向东');
INSERT INTO `16se3` VALUES ('19', '科技文献检索', '5', '6', '5', '3', '8', '35-203', '刘原');
INSERT INTO `16se3` VALUES ('20', '科技文献检索', '7', '8', '5', '7', '8', '35-612', '刘原');
