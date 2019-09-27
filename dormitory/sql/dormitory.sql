/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : dormitory

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2018-04-01 00:03:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_admin
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `admin_name` varchar(20) DEFAULT NULL COMMENT '管理员用户名',
  `admin_password` varchar(20) DEFAULT NULL COMMENT '管理员密码',
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='管理员表';

-- ----------------------------
-- Records of tb_admin
-- ----------------------------
INSERT INTO `tb_admin` VALUES ('1', 'admin', '123456');

-- ----------------------------
-- Table structure for tb_college
-- ----------------------------
DROP TABLE IF EXISTS `tb_college`;
CREATE TABLE `tb_college` (
  `college_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学院id',
  `college_name` varchar(40) DEFAULT NULL COMMENT '学院名称',
  PRIMARY KEY (`college_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='学院表';

-- ----------------------------
-- Records of tb_college
-- ----------------------------
INSERT INTO `tb_college` VALUES ('1', '管理学院');
INSERT INTO `tb_college` VALUES ('2', '应用数学学院');
INSERT INTO `tb_college` VALUES ('3', '经济与贸易学院');
INSERT INTO `tb_college` VALUES ('4', '政法学院');
INSERT INTO `tb_college` VALUES ('5', '机电工程学院');
INSERT INTO `tb_college` VALUES ('6', '自动化学院');
INSERT INTO `tb_college` VALUES ('7', '轻工化工学院');
INSERT INTO `tb_college` VALUES ('8', '信息工程学院');
INSERT INTO `tb_college` VALUES ('9', '土木与交通工程学院');
INSERT INTO `tb_college` VALUES ('10', '计算机学院');
INSERT INTO `tb_college` VALUES ('11', '材料与能源学院');
INSERT INTO `tb_college` VALUES ('12', '环境科学与工程学院');
INSERT INTO `tb_college` VALUES ('13', '外国语学院');
INSERT INTO `tb_college` VALUES ('14', '物理与光电工程学院');
INSERT INTO `tb_college` VALUES ('15', '艺术设计学院');
INSERT INTO `tb_college` VALUES ('16', '建筑与城市规划学院');
INSERT INTO `tb_college` VALUES ('17', '国际教育学院');

-- ----------------------------
-- Table structure for tb_dormitory
-- ----------------------------
DROP TABLE IF EXISTS `tb_dormitory`;
CREATE TABLE `tb_dormitory` (
  `dormitory_id` int(255) NOT NULL AUTO_INCREMENT COMMENT '宿舍id',
  `dormitory_number` varchar(20) DEFAULT NULL COMMENT '宿舍号',
  PRIMARY KEY (`dormitory_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='宿舍信息表';

-- ----------------------------
-- Records of tb_dormitory
-- ----------------------------
INSERT INTO `tb_dormitory` VALUES ('1', 'B一902');
INSERT INTO `tb_dormitory` VALUES ('2', 'B二202');
INSERT INTO `tb_dormitory` VALUES ('3', 'B二801');
INSERT INTO `tb_dormitory` VALUES ('4', 'B三903');

-- ----------------------------
-- Table structure for tb_express
-- ----------------------------
DROP TABLE IF EXISTS `tb_express`;
CREATE TABLE `tb_express` (
  `express_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '快递id',
  `student_id` int(11) DEFAULT NULL COMMENT '学生id',
  `receive_date` date DEFAULT NULL COMMENT '收件日期',
  PRIMARY KEY (`express_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_express
-- ----------------------------
INSERT INTO `tb_express` VALUES ('1', '1', '2018-03-23');
INSERT INTO `tb_express` VALUES ('2', '2', '2018-03-20');
INSERT INTO `tb_express` VALUES ('3', '1', '2018-03-26');
INSERT INTO `tb_express` VALUES ('4', '1', '2018-03-15');
INSERT INTO `tb_express` VALUES ('5', '1', '2018-03-23');
INSERT INTO `tb_express` VALUES ('6', '3', '2018-03-07');
INSERT INTO `tb_express` VALUES ('7', '1', '2018-03-26');
INSERT INTO `tb_express` VALUES ('8', '1', '2018-05-03');

-- ----------------------------
-- Table structure for tb_late_back
-- ----------------------------
DROP TABLE IF EXISTS `tb_late_back`;
CREATE TABLE `tb_late_back` (
  `late_back_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '夜归id',
  `late_back_time` timestamp NULL DEFAULT NULL COMMENT '夜归时间',
  `late_back_reason` tinytext COMMENT '夜归时间',
  `late_back_student_id` int(11) NOT NULL COMMENT '夜归学生id',
  PRIMARY KEY (`late_back_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='夜归信息表';

-- ----------------------------
-- Records of tb_late_back
-- ----------------------------
INSERT INTO `tb_late_back` VALUES ('1', '2018-03-23 00:38:55', '学习', '2');
INSERT INTO `tb_late_back` VALUES ('2', '2018-03-24 23:47:00', '夜宵', '1');
INSERT INTO `tb_late_back` VALUES ('3', '2018-04-13 12:12:12', '学习', '1');
INSERT INTO `tb_late_back` VALUES ('4', '2018-03-17 03:03:04', '学习', '1');

-- ----------------------------
-- Table structure for tb_leave_school
-- ----------------------------
DROP TABLE IF EXISTS `tb_leave_school`;
CREATE TABLE `tb_leave_school` (
  `leave_school_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '离校id',
  `leave_school_time` datetime DEFAULT NULL COMMENT '离校时间',
  `leave_student_id` int(11) DEFAULT NULL COMMENT '离校学生id',
  `leave_school_reason` tinytext COMMENT '离校原因',
  `valuables` varchar(255) DEFAULT NULL COMMENT '贵重物品',
  PRIMARY KEY (`leave_school_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='离校信息表';

-- ----------------------------
-- Records of tb_leave_school
-- ----------------------------
INSERT INTO `tb_leave_school` VALUES ('1', '2018-03-30 15:03:58', '1', '放假', '电脑');

-- ----------------------------
-- Table structure for tb_profession
-- ----------------------------
DROP TABLE IF EXISTS `tb_profession`;
CREATE TABLE `tb_profession` (
  `profession_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '专业id',
  `profession_name` varchar(40) DEFAULT NULL COMMENT '专业名称',
  PRIMARY KEY (`profession_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='专业表';

-- ----------------------------
-- Records of tb_profession
-- ----------------------------
INSERT INTO `tb_profession` VALUES ('1', '信息管理与信息系统');
INSERT INTO `tb_profession` VALUES ('2', '电子商务');
INSERT INTO `tb_profession` VALUES ('3', '工商管理');
INSERT INTO `tb_profession` VALUES ('4', '市场营销');
INSERT INTO `tb_profession` VALUES ('5', '会计学');
INSERT INTO `tb_profession` VALUES ('6', ' 财务管理');
INSERT INTO `tb_profession` VALUES ('7', '物流管理');
INSERT INTO `tb_profession` VALUES ('8', '人力资源管理');
INSERT INTO `tb_profession` VALUES ('9', '管理科学');
INSERT INTO `tb_profession` VALUES ('10', ' 旅游管理 ');
INSERT INTO `tb_profession` VALUES ('11', '房地产开发与管理');
INSERT INTO `tb_profession` VALUES ('12', ' 土地资源管理');

-- ----------------------------
-- Table structure for tb_repair
-- ----------------------------
DROP TABLE IF EXISTS `tb_repair`;
CREATE TABLE `tb_repair` (
  `repair_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '报修id',
  `repair_project` tinytext COMMENT '报修项目',
  `repair_date` date DEFAULT NULL COMMENT '报修时间',
  `dormitory_id` int(11) DEFAULT NULL COMMENT '报修宿舍id',
  `finish_date` date DEFAULT NULL COMMENT '修复时间',
  `student_id` int(11) DEFAULT NULL COMMENT '报修学生id',
  PRIMARY KEY (`repair_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='报修信息表';

-- ----------------------------
-- Records of tb_repair
-- ----------------------------
INSERT INTO `tb_repair` VALUES ('1', '灯管', '2018-03-23', '1', '2018-03-28', '1');
INSERT INTO `tb_repair` VALUES ('2', '水龙头', '2018-04-20', '1', null, '1');
INSERT INTO `tb_repair` VALUES ('3', '灯管', '2018-04-20', '1', null, '1');
INSERT INTO `tb_repair` VALUES ('4', '灯管', '2018-03-21', '1', null, '2');
INSERT INTO `tb_repair` VALUES ('5', '水管', '2018-03-14', '1', null, '1');
INSERT INTO `tb_repair` VALUES ('6', '空调', '2018-03-31', '1', null, '1');
INSERT INTO `tb_repair` VALUES ('7', '洗衣机', '2018-03-31', '1', null, '1');
INSERT INTO `tb_repair` VALUES ('8', '冰箱', '2018-04-02', '1', null, '1');
INSERT INTO `tb_repair` VALUES ('9', '桌子', '2018-03-31', '3', null, '4');
INSERT INTO `tb_repair` VALUES ('10', '灯管', '2018-03-31', '1', null, '1');

-- ----------------------------
-- Table structure for tb_student
-- ----------------------------
DROP TABLE IF EXISTS `tb_student`;
CREATE TABLE `tb_student` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生id',
  `student_number` varchar(20) NOT NULL COMMENT '学号',
  `student_password` varchar(20) NOT NULL COMMENT '密码',
  `student_name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `student_phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `sex` int(11) DEFAULT NULL COMMENT '性别，1代表男生，2代表女生',
  `college_id` int(11) DEFAULT NULL COMMENT '学院id',
  `profession_id` int(11) DEFAULT NULL COMMENT '专业id',
  `grade` int(11) DEFAULT NULL COMMENT '年级',
  `clazz` varchar(20) DEFAULT NULL COMMENT '班级',
  `student_dormitory_id` int(11) DEFAULT NULL COMMENT '学生宿舍id',
  PRIMARY KEY (`student_id`),
  UNIQUE KEY `student_number` (`student_number`),
  KEY `college_id` (`college_id`),
  KEY `profession_id` (`profession_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='学生信息表';

-- ----------------------------
-- Records of tb_student
-- ----------------------------
INSERT INTO `tb_student` VALUES ('1', '3114002747', '123456', '陈俊杰', '15626218647', '1', '1', '1', '2014', '1', '1');
INSERT INTO `tb_student` VALUES ('2', '3114002748', '123456', '叶加荣', '15626218648', '1', '1', '2', '2014', '2', '1');
INSERT INTO `tb_student` VALUES ('3', '3114002749', '123456', '张广宏', '15626218649', '1', '1', '3', '2014', '4', '2');
INSERT INTO `tb_student` VALUES ('4', '3114002750', '123456', '钟春瑶', '15626218650', '2', '2', '4', '2014', '3', '3');
