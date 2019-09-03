/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50527
Source Host           : 127.0.0.1:3306
Source Database       : ourlove

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2019-09-04 00:30:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for papers
-- ----------------------------
DROP TABLE IF EXISTS `papers`;
CREATE TABLE `papers` (
  `ids` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `obj_code` varchar(255) DEFAULT NULL COMMENT '文件对象的Id 合同对象的Id或者UUid',
  `obj_type` varchar(255) DEFAULT NULL COMMENT '文件对象的类型',
  `filename` varchar(255) DEFAULT NULL COMMENT '文件名称',
  `filetype` varchar(10) DEFAULT NULL COMMENT '文件类型(01 图片 02 PDF)',
  `filesize` int(10) DEFAULT NULL COMMENT '文件大小  KB',
  `fileurl` varchar(255) DEFAULT NULL COMMENT '文件路径  相对路径',
  `filepath` varchar(255) DEFAULT NULL COMMENT '所在文件夹',
  `suffixname` varchar(255) DEFAULT NULL COMMENT '后缀名 pdf jpg',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `update_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `old_file_name` varchar(255) DEFAULT NULL COMMENT '文件以前的名字',
  `reserve1` varchar(255) DEFAULT NULL COMMENT '扩展字段1',
  `reserve2` varchar(255) DEFAULT NULL COMMENT '扩展字段2',
  `reserve3` varchar(255) DEFAULT NULL COMMENT '扩展字段3',
  PRIMARY KEY (`ids`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='文件上传信息表';

-- ----------------------------
-- Records of papers
-- ----------------------------
INSERT INTO `papers` VALUES ('1', '123', '1231', '2313', '123123', '1313', '131', '3131', '3131', '2019-08-15 22:25:24', null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `ids` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ids`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', 'gaoh', '21');
INSERT INTO `student` VALUES ('2', 'wangh', '20');
INSERT INTO `student` VALUES ('3', 'gaohwangh', '20');
INSERT INTO `student` VALUES ('4', 'gaohwangh', '20');

-- ----------------------------
-- Table structure for sys_job
-- ----------------------------
DROP TABLE IF EXISTS `sys_job`;
CREATE TABLE `sys_job` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `name` varchar(255) DEFAULT NULL COMMENT '任务名称',
  `group_no` varchar(255) DEFAULT NULL COMMENT '任务分组',
  `status` varchar(255) DEFAULT NULL COMMENT '任务状态',
  `cron` varchar(255) DEFAULT NULL COMMENT '规则表达式',
  `spring_id` varchar(255) DEFAULT NULL COMMENT '调用类SpringID',
  `class_name` varchar(255) DEFAULT NULL COMMENT '调用类',
  `method` varchar(255) DEFAULT NULL COMMENT '调用类方法',
  `is_concurrent` varchar(255) DEFAULT NULL COMMENT '是否并发，默认否',
  `is_enable` varchar(255) DEFAULT NULL COMMENT '是否启用',
  `start_time` datetime DEFAULT NULL COMMENT '本次运行时间',
  `next_fire_time` datetime DEFAULT NULL COMMENT '下次运行时间',
  `is_sys` varchar(255) DEFAULT NULL COMMENT '是否是系统级(1是 其它否)',
  `memo` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(255) DEFAULT NULL COMMENT '创建人 ',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='系统定时任务表';

-- ----------------------------
-- Records of sys_job
-- ----------------------------
INSERT INTO `sys_job` VALUES ('1', 'testJob', '01', null, '0 0/1 * * * ?', '', 'com.gaohwangh.production.job.TestJob', '', '1', '0', null, null, null, '每分钟执行一次', null, null, 'admin', '2019-08-14 10:18:33');
INSERT INTO `sys_job` VALUES ('3', 'test', '01', null, '0/5 * * * * ? *', null, 'com.gaoh.mybatisplus.job.TestJob', 'execute', '1', '0', null, null, null, '每5秒执行一次', 'admin', '2019-08-13 15:51:32', 'admin', '2019-08-14 10:42:11');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '功能ID',
  `name` varchar(255) DEFAULT NULL COMMENT '功能名称',
  `type` varchar(255) DEFAULT NULL COMMENT '功能类型(0菜单 1按钮) ',
  `levels` int(5) DEFAULT NULL COMMENT '功能等级',
  `parent_id` int(5) DEFAULT NULL COMMENT '父级功能ID',
  `parent_name` varchar(255) DEFAULT NULL,
  `seq_no` int(5) DEFAULT NULL COMMENT '层级内排序序号',
  `is_leaf` varchar(255) DEFAULT NULL COMMENT '是否叶子节点(0否 1是)',
  `is_hide` varchar(255) DEFAULT NULL COMMENT '是否隐藏(1是 其它否)',
  `is_sys` varchar(255) DEFAULT NULL COMMENT ' 是否系统级(1是 其它否)',
  `func` varchar(255) DEFAULT NULL COMMENT '功能函数',
  `group_code` varchar(255) DEFAULT NULL COMMENT '功能分组编码(SYS/DEV/INTF)',
  `icon` varchar(255) DEFAULT NULL COMMENT '功能图标',
  `class` varchar(255) DEFAULT NULL COMMENT '引用得class样式',
  `memo` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统相关模块及功能';

-- ----------------------------
-- Records of sys_permission
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '角色名',
  `description` varchar(255) DEFAULT NULL COMMENT '相关描述',
  PRIMARY KEY (`id`),
  KEY `index_name` (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `userid` int(10) NOT NULL AUTO_INCREMENT,
  `usercode` varchar(255) DEFAULT '' COMMENT '用户名',
  `personid` int(11) DEFAULT NULL COMMENT '用户名大写',
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `lastlogindate` datetime DEFAULT NULL COMMENT '最后登陆日期',
  `lastloginip` varchar(255) DEFAULT '' COMMENT '最后登陆IP',
  `telno` int(11) DEFAULT NULL COMMENT '电话号码',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `qq` varchar(255) DEFAULT NULL,
  `loginno` int(10) DEFAULT NULL COMMENT '登录次数',
  `memo` varchar(255) DEFAULT NULL,
  `createUserId` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateUserId` int(11) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COMMENT='系统用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '1', 'admin', '123456', '2019-07-29 19:27:42', '', null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2', '', '12', 'gaoh', '2500340197b8af15ff51df245ea1a821', null, '', null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('3', '', '2', 'wangh', '2500340197b8af15ff51df245ea1a821', null, '', null, null, null, null, null, null, null, null, null);
