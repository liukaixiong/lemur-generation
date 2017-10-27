/*
Navicat MySQL Data Transfer

Source Database       : easycode_dev

Target Server Type    : MYSQL
Target Server Version : 50541
File Encoding         : 65001

Date: 2017-10-27 17:46:02
Version 1.1.0 版本
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_code_dbinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_code_dbinfo`;
CREATE TABLE `t_code_dbinfo` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ALIAS` varchar(20) DEFAULT NULL,
  `DB_DRIVER` varchar(100) NOT NULL COMMENT '数据库驱动',
  `DB_URL` varchar(200) NOT NULL COMMENT '数据库地址',
  `DB_USER_NAME` varchar(100) NOT NULL COMMENT '数据库账户',
  `DB_PASSWORD` varchar(100) NOT NULL COMMENT '连接密码',
  `USER_ID` varchar(32) DEFAULT NULL,
  `DB_TYPE` varchar(10) DEFAULT NULL COMMENT '数据库类型',
  `CRT_USER_ID` varchar(16) DEFAULT NULL COMMENT '创建人',
  `CRT_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `MDF_USER_ID` varchar(16) DEFAULT NULL COMMENT '修改人',
  `MDF_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='数据库链接信息';

-- ----------------------------
-- Records of t_code_dbinfo
-- ----------------------------
INSERT INTO `t_code_dbinfo` VALUES ('1', '测试', 'com.mysql.jdbc.Driver', 'jdbc:mysql://121.42.11.118:3308/easycode_dev?autoReconnect=true&useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull', 'jueyue', 'wqeqeqwwocszjxsfakdfas', null, 'mysql', null, null, '1', '2017-10-12 09:43:07');
INSERT INTO `t_code_dbinfo` VALUES ('4', 'localhost', 'com.mysql.jdbc.Driver', 'jdbc:mysql://localhost:3306/jfinal_demo', 'root', '123456', '78', 'mysql', '78', '2017-10-06 13:57:31', '78', '2017-10-06 14:00:13');
INSERT INTO `t_code_dbinfo` VALUES ('5', 'local-company', 'com.mysql.jdbc.Driver', 'jdbc:mysql://localhost:3306/easycode?autoReconnect=true&useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull', 'root', '123456', '1', 'mysql', '1', '2017-10-24 15:15:31', null, null);
INSERT INTO `t_code_dbinfo` VALUES ('6', '123', 'com.mysql.jdbc.Driver', 'jdbc:mysql://localhost:3306/shop?useUnicode=true&characterEncoding=UTF-8', 'root', 'root', '1', 'mysql', '1', '2017-10-27 08:55:22', null, null);

-- ----------------------------
-- Table structure for t_code_gen_params
-- ----------------------------
DROP TABLE IF EXISTS `t_code_gen_params`;
CREATE TABLE `t_code_gen_params` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `ALIAS` varchar(20) DEFAULT NULL COMMENT '别名',
  `author` varchar(20) NOT NULL COMMENT '作者',
  `code_package` varchar(100) NOT NULL COMMENT 'code 包',
  `xml_package` varchar(100) DEFAULT NULL COMMENT 'xml 路径',
  `js_package` varchar(100) DEFAULT NULL COMMENT 'js 目录',
  `html_package` varchar(100) DEFAULT NULL COMMENT 'html 目录',
  `local_path` varchar(100) DEFAULT NULL COMMENT '本地路径',
  `encoded` varchar(10) DEFAULT NULL COMMENT '编码',
  `user_id` int(10) NOT NULL,
  `CRT_USER_ID` int(16) DEFAULT NULL COMMENT '创建人',
  `CRT_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `MDF_USER_ID` int(16) DEFAULT NULL COMMENT '修改人',
  `MDF_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='生成参数';

-- ----------------------------
-- Records of t_code_gen_params
-- ----------------------------
INSERT INTO `t_code_gen_params` VALUES ('7', 'lemur-gen', 'lihangyu', 'cn.afterturn.gen.modular.code', 'MET-INF.mapping', 'static.modular.code', 'WEB-INF.view.modular.code', 'D:\\mySpace\\lemur\\lemur-generation\\gen-admin\\src\\main', 'UTF-8', '0', '1', '2017-09-13 11:18:31', '1', '2017-10-27 09:18:57');
INSERT INTO `t_code_gen_params` VALUES ('8', 'review-rest', 'JueYue', 'cn.allisone.review.rest.modular.review', '', '', '', '', 'UTF-8', '1', '1', '2017-10-12 09:40:26', null, null);

-- ----------------------------
-- Table structure for t_code_table_base_field
-- ----------------------------
DROP TABLE IF EXISTS `t_code_table_base_field`;
CREATE TABLE `t_code_table_base_field` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) DEFAULT NULL COMMENT '用户ID',
  `name` varchar(10) NOT NULL COMMENT '基础字段组名称',
  `desc` varchar(400) DEFAULT NULL COMMENT '描述',
  `CRT_USER_ID` varchar(16) DEFAULT NULL COMMENT '创建人',
  `CRT_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `MDF_USER_ID` varchar(16) DEFAULT NULL COMMENT '修改人',
  `MDF_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='项目基础字段';

-- ----------------------------
-- Records of t_code_table_base_field
-- ----------------------------

-- ----------------------------
-- Table structure for t_code_table_field
-- ----------------------------
DROP TABLE IF EXISTS `t_code_table_field`;
CREATE TABLE `t_code_table_field` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `table_id` int(10) NOT NULL COMMENT '关联表ID',
  `field_name` varchar(100) NOT NULL COMMENT '列名',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `content` varchar(200) DEFAULT NULL COMMENT '功能',
  `type` varchar(20) NOT NULL COMMENT '类型',
  `is_key` varchar(2) DEFAULT NULL COMMENT '是否主键',
  `is_null` varchar(5) DEFAULT NULL COMMENT '是否可以为空',
  `is_show_add` int(1) DEFAULT '1' COMMENT '是否显示新增',
  `is_show_edit` int(1) DEFAULT '1' COMMENT '是否显示编辑',
  `is_show_detail` int(1) DEFAULT '1' COMMENT '是否显示详情',
  `is_show_list` int(1) DEFAULT '1' COMMENT '是否列表显示',
  `is_import` int(1) DEFAULT '1' COMMENT '是否Excel导入',
  `is_export` int(1) DEFAULT '1' COMMENT '是否导出Excel',
  `is_query` int(1) DEFAULT '1' COMMENT '是否查询',
  `query_mode` varchar(10) DEFAULT NULL COMMENT '查询类型',
  `show_type` varchar(10) DEFAULT NULL COMMENT '显示类型',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  `dict_name` varchar(100) DEFAULT NULL COMMENT '字段名称',
  `dict_type` int(1) DEFAULT NULL COMMENT '字段类型 1 枚举 2 字段 3 列表',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=301 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='字段对应关系';

-- ----------------------------
-- Records of t_code_table_field
-- ----------------------------
INSERT INTO `t_code_table_field` VALUES ('263', '65', 'id', 'id', '', 'Integer', '2', null, '2', '2', '2', null, '2', '2', null, '1', '1', null, '', '1');
INSERT INTO `t_code_table_field` VALUES ('264', '65', 'ip', 'ip', 'IP', 'String', null, null, '2', '2', '2', '2', '2', '2', null, '1', '1', null, '', '1');
INSERT INTO `t_code_table_field` VALUES ('265', '65', 'site_code', 'siteCode', '网址', 'String', null, null, '2', '2', '2', '2', '2', '2', null, '1', '1', null, '', '1');
INSERT INTO `t_code_table_field` VALUES ('266', '65', 'buss_code', 'bussCode', '业务', 'String', null, null, '2', '2', '2', '2', '2', '2', null, '1', '1', null, '', '1');
INSERT INTO `t_code_table_field` VALUES ('267', '65', 'buss_key', 'bussKey', '业务Key', 'String', null, null, '2', '2', '2', '2', '2', '2', null, '1', '1', null, '', '1');
INSERT INTO `t_code_table_field` VALUES ('268', '65', 'type', 'type', '类型', 'String', null, null, '2', '2', '2', '2', '2', '2', null, '1', '1', null, '', '1');
INSERT INTO `t_code_table_field` VALUES ('269', '65', 'create_time', 'createTime', '', 'Date', null, null, '2', '2', '2', '2', '2', '2', null, '1', '1', null, '', '1');
INSERT INTO `t_code_table_field` VALUES ('270', '66', 'id', 'id', '', 'String', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_code_table_field` VALUES ('271', '66', 'content', 'content', null, 'String', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_code_table_field` VALUES ('272', '66', 'dict_field', 'dictField', '', 'String', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_code_table_field` VALUES ('273', '66', 'dict_table', 'dictTable', '', 'String', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_code_table_field` VALUES ('274', '66', 'dict_text', 'dictText', '', 'String', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_code_table_field` VALUES ('275', '66', 'field_default', 'fieldDefault', '', 'String', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_code_table_field` VALUES ('276', '66', 'field_href', 'fieldHref', '', 'String', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_code_table_field` VALUES ('277', '66', 'field_length', 'fieldLength', '', 'Integer', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_code_table_field` VALUES ('278', '66', 'field_name', 'fieldName', '', 'String', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_code_table_field` VALUES ('279', '66', 'field_valid_type', 'fieldValidType', '', 'String', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_code_table_field` VALUES ('280', '66', 'is_key', 'isKey', null, 'String', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_code_table_field` VALUES ('281', '66', 'is_null', 'isNull', '', 'String', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_code_table_field` VALUES ('282', '66', 'is_query', 'isQuery', null, 'String', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_code_table_field` VALUES ('283', '66', 'is_show', 'isShow', null, 'String', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_code_table_field` VALUES ('284', '66', 'is_show_list', 'isShowList', null, 'String', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_code_table_field` VALUES ('285', '66', 'length', 'length', '', 'Integer', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_code_table_field` VALUES ('286', '66', 'order_num', 'orderNum', null, 'Integer', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_code_table_field` VALUES ('287', '66', 'point_length', 'pointLength', '', 'Integer', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_code_table_field` VALUES ('288', '66', 'query_mode', 'queryMode', null, 'String', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_code_table_field` VALUES ('289', '66', 'show_type', 'showType', null, 'String', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_code_table_field` VALUES ('290', '66', 'type', 'type', '', 'String', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_code_table_field` VALUES ('291', '66', 'update_by', 'updateBy', '', 'String', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_code_table_field` VALUES ('292', '66', 'update_date', 'updateDate', '', 'Date', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_code_table_field` VALUES ('293', '66', 'update_name', 'updateName', '', 'String', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_code_table_field` VALUES ('294', '66', 'table_id', 'tableId', null, 'String', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_code_table_field` VALUES ('295', '67', 'id', 'id', null, 'Integer', '2', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_code_table_field` VALUES ('296', '67', 'template_id', 'templateId', null, 'Integer', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_code_table_field` VALUES ('297', '67', 'file', 'file', '文件内容,', 'String', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_code_table_field` VALUES ('298', '67', 'file_type', 'fileType', '文件类型,', 'String', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_code_table_field` VALUES ('299', '67', 'CRT_TIME', 'crtTime', '创建时间,', 'Date', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_code_table_field` VALUES ('300', '67', 'MDF_TIME', 'mdfTime', '修改时间,', 'Date', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for t_code_table_field_dbinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_code_table_field_dbinfo`;
CREATE TABLE `t_code_table_field_dbinfo` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `field_id` int(10) NOT NULL COMMENT '字段ID',
  `field_name` varchar(100) CHARACTER SET utf8 NOT NULL COMMENT '列名',
  `field_default` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '字段默认值',
  `field_content` varchar(200) CHARACTER SET utf8 DEFAULT NULL COMMENT ' 字段注释',
  `field_length` int(11) DEFAULT NULL COMMENT '字段长度',
  `field_type` varchar(10) CHARACTER SET utf8 DEFAULT NULL COMMENT '字段类型',
  `field_point_length` int(11) DEFAULT NULL COMMENT '小数点位数',
  PRIMARY KEY (`id`),
  UNIQUE KEY `un_field_id` (`field_id`) USING HASH COMMENT '字段 Id'
) ENGINE=InnoDB AUTO_INCREMENT=293 DEFAULT CHARSET=latin1 COMMENT='字段的数据库信息';

-- ----------------------------
-- Records of t_code_table_field_dbinfo
-- ----------------------------
INSERT INTO `t_code_table_field_dbinfo` VALUES ('255', '263', 'id', '', '', null, 'int', '0');
INSERT INTO `t_code_table_field_dbinfo` VALUES ('256', '264', 'ip', '', '', '20', 'varchar', null);
INSERT INTO `t_code_table_field_dbinfo` VALUES ('257', '265', 'site_code', '', '', '15', 'varchar', null);
INSERT INTO `t_code_table_field_dbinfo` VALUES ('258', '266', 'buss_code', '', '', '20', 'varchar', null);
INSERT INTO `t_code_table_field_dbinfo` VALUES ('259', '267', 'buss_key', '', '', '50', 'varchar', null);
INSERT INTO `t_code_table_field_dbinfo` VALUES ('260', '268', 'type', '', '', '5', 'varchar', null);
INSERT INTO `t_code_table_field_dbinfo` VALUES ('261', '269', 'create_time', '', '', null, 'datetime', null);
INSERT INTO `t_code_table_field_dbinfo` VALUES ('262', '270', 'id', null, '', '32', 'varchar', '0');
INSERT INTO `t_code_table_field_dbinfo` VALUES ('263', '271', 'content', null, null, '200', 'varchar', '0');
INSERT INTO `t_code_table_field_dbinfo` VALUES ('264', '272', 'dict_field', null, '', '100', 'varchar', '0');
INSERT INTO `t_code_table_field_dbinfo` VALUES ('265', '273', 'dict_table', null, '', '100', 'varchar', '0');
INSERT INTO `t_code_table_field_dbinfo` VALUES ('266', '274', 'dict_text', null, '', '100', 'varchar', '0');
INSERT INTO `t_code_table_field_dbinfo` VALUES ('267', '275', 'field_default', null, '', '20', 'varchar', '0');
INSERT INTO `t_code_table_field_dbinfo` VALUES ('268', '276', 'field_href', null, '', '200', 'varchar', '0');
INSERT INTO `t_code_table_field_dbinfo` VALUES ('269', '277', 'field_length', null, '', '10', 'int', '0');
INSERT INTO `t_code_table_field_dbinfo` VALUES ('270', '278', 'field_name', null, '', '32', 'varchar', '0');
INSERT INTO `t_code_table_field_dbinfo` VALUES ('271', '279', 'field_valid_type', null, '', '10', 'varchar', '0');
INSERT INTO `t_code_table_field_dbinfo` VALUES ('272', '280', 'is_key', null, null, '2', 'varchar', '0');
INSERT INTO `t_code_table_field_dbinfo` VALUES ('273', '281', 'is_null', null, '', '5', 'varchar', '0');
INSERT INTO `t_code_table_field_dbinfo` VALUES ('274', '282', 'is_query', null, null, '5', 'varchar', '0');
INSERT INTO `t_code_table_field_dbinfo` VALUES ('275', '283', 'is_show', null, null, '5', 'varchar', '0');
INSERT INTO `t_code_table_field_dbinfo` VALUES ('276', '284', 'is_show_list', null, null, '5', 'varchar', '0');
INSERT INTO `t_code_table_field_dbinfo` VALUES ('277', '285', 'length', null, '', '10', 'int', '0');
INSERT INTO `t_code_table_field_dbinfo` VALUES ('278', '286', 'order_num', null, null, '10', 'int', '0');
INSERT INTO `t_code_table_field_dbinfo` VALUES ('279', '287', 'point_length', null, '', '10', 'int', '0');
INSERT INTO `t_code_table_field_dbinfo` VALUES ('280', '288', 'query_mode', null, null, '10', 'varchar', '0');
INSERT INTO `t_code_table_field_dbinfo` VALUES ('281', '289', 'show_type', null, null, '10', 'varchar', '0');
INSERT INTO `t_code_table_field_dbinfo` VALUES ('282', '290', 'type', null, '', '32', 'varchar', '0');
INSERT INTO `t_code_table_field_dbinfo` VALUES ('283', '291', 'update_by', null, '', '32', 'varchar', '0');
INSERT INTO `t_code_table_field_dbinfo` VALUES ('284', '292', 'update_date', null, '', '0', 'datetime', '0');
INSERT INTO `t_code_table_field_dbinfo` VALUES ('285', '293', 'update_name', null, '', '32', 'varchar', '0');
INSERT INTO `t_code_table_field_dbinfo` VALUES ('286', '294', 'table_id', null, null, '32', 'varchar', '0');
INSERT INTO `t_code_table_field_dbinfo` VALUES ('287', '295', 'id', null, null, '10', 'int', null);
INSERT INTO `t_code_table_field_dbinfo` VALUES ('288', '296', 'template_id', null, null, '10', 'int', null);
INSERT INTO `t_code_table_field_dbinfo` VALUES ('289', '297', 'file', null, '文件内容,', null, 'text', null);
INSERT INTO `t_code_table_field_dbinfo` VALUES ('290', '298', 'file_type', null, '文件类型,', '20', 'varchar', null);
INSERT INTO `t_code_table_field_dbinfo` VALUES ('291', '299', 'CRT_TIME', null, '创建时间,', null, 'datetime', null);
INSERT INTO `t_code_table_field_dbinfo` VALUES ('292', '300', 'MDF_TIME', null, '修改时间,', null, 'datetime', null);

-- ----------------------------
-- Table structure for t_code_table_field_verification
-- ----------------------------
DROP TABLE IF EXISTS `t_code_table_field_verification`;
CREATE TABLE `t_code_table_field_verification` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `field_id` int(10) NOT NULL COMMENT '字段ID',
  `view_verification` int(1) DEFAULT NULL COMMENT '前端校验',
  `server_verification` int(1) DEFAULT NULL COMMENT '后台校验',
  `not_null` int(1) DEFAULT NULL COMMENT '允许空',
  `min_num` varchar(5) DEFAULT NULL COMMENT '最小',
  `max_num` varchar(10) DEFAULT NULL COMMENT '最大',
  `regex` varchar(100) DEFAULT NULL COMMENT '正则',
  `regex_type` int(2) DEFAULT NULL COMMENT '正则类型',
  PRIMARY KEY (`id`),
  UNIQUE KEY `un_field_id` (`field_id`) USING BTREE COMMENT '字段 Id'
) ENGINE=InnoDB AUTO_INCREMENT=294 DEFAULT CHARSET=latin1 COMMENT='字段校验规则';

-- ----------------------------
-- Records of t_code_table_field_verification
-- ----------------------------
INSERT INTO `t_code_table_field_verification` VALUES ('256', '263', '2', '2', '2', '', '', '', '0');
INSERT INTO `t_code_table_field_verification` VALUES ('257', '264', '2', '2', '2', '', '', '', '0');
INSERT INTO `t_code_table_field_verification` VALUES ('258', '265', '2', '2', '2', '', '', '', '0');
INSERT INTO `t_code_table_field_verification` VALUES ('259', '266', '2', '2', '2', '', '', '', '0');
INSERT INTO `t_code_table_field_verification` VALUES ('260', '267', '2', '2', '2', '', '', '', '0');
INSERT INTO `t_code_table_field_verification` VALUES ('261', '268', '2', '2', '2', '', '', '', '0');
INSERT INTO `t_code_table_field_verification` VALUES ('262', '269', '2', '2', '2', '', '', '', '0');
INSERT INTO `t_code_table_field_verification` VALUES ('263', '270', null, null, '1', null, null, null, null);
INSERT INTO `t_code_table_field_verification` VALUES ('264', '271', null, null, '1', null, null, null, null);
INSERT INTO `t_code_table_field_verification` VALUES ('265', '272', null, null, '1', null, null, null, null);
INSERT INTO `t_code_table_field_verification` VALUES ('266', '273', null, null, '1', null, null, null, null);
INSERT INTO `t_code_table_field_verification` VALUES ('267', '274', null, null, '1', null, null, null, null);
INSERT INTO `t_code_table_field_verification` VALUES ('268', '275', null, null, '1', null, null, null, null);
INSERT INTO `t_code_table_field_verification` VALUES ('269', '276', null, null, '1', null, null, null, null);
INSERT INTO `t_code_table_field_verification` VALUES ('270', '277', null, null, '1', null, null, null, null);
INSERT INTO `t_code_table_field_verification` VALUES ('271', '278', null, null, '1', null, null, null, null);
INSERT INTO `t_code_table_field_verification` VALUES ('272', '279', null, null, '1', null, null, null, null);
INSERT INTO `t_code_table_field_verification` VALUES ('273', '280', null, null, '1', null, null, null, null);
INSERT INTO `t_code_table_field_verification` VALUES ('274', '281', null, null, '1', null, null, null, null);
INSERT INTO `t_code_table_field_verification` VALUES ('275', '282', null, null, '1', null, null, null, null);
INSERT INTO `t_code_table_field_verification` VALUES ('276', '283', null, null, '1', null, null, null, null);
INSERT INTO `t_code_table_field_verification` VALUES ('277', '284', null, null, '1', null, null, null, null);
INSERT INTO `t_code_table_field_verification` VALUES ('278', '285', null, null, '1', null, null, null, null);
INSERT INTO `t_code_table_field_verification` VALUES ('279', '286', null, null, '1', null, null, null, null);
INSERT INTO `t_code_table_field_verification` VALUES ('280', '287', null, null, '1', null, null, null, null);
INSERT INTO `t_code_table_field_verification` VALUES ('281', '288', null, null, '1', null, null, null, null);
INSERT INTO `t_code_table_field_verification` VALUES ('282', '289', null, null, '1', null, null, null, null);
INSERT INTO `t_code_table_field_verification` VALUES ('283', '290', null, null, '1', null, null, null, null);
INSERT INTO `t_code_table_field_verification` VALUES ('284', '291', null, null, '1', null, null, null, null);
INSERT INTO `t_code_table_field_verification` VALUES ('285', '292', null, null, '1', null, null, null, null);
INSERT INTO `t_code_table_field_verification` VALUES ('286', '293', null, null, '1', null, null, null, null);
INSERT INTO `t_code_table_field_verification` VALUES ('287', '294', null, null, '1', null, null, null, null);
INSERT INTO `t_code_table_field_verification` VALUES ('288', '295', null, null, '2', null, null, null, null);
INSERT INTO `t_code_table_field_verification` VALUES ('289', '296', null, null, '2', null, null, null, null);
INSERT INTO `t_code_table_field_verification` VALUES ('290', '297', null, null, '1', null, null, null, null);
INSERT INTO `t_code_table_field_verification` VALUES ('291', '298', null, null, '1', null, null, null, null);
INSERT INTO `t_code_table_field_verification` VALUES ('292', '299', null, null, '1', null, null, null, null);
INSERT INTO `t_code_table_field_verification` VALUES ('293', '300', null, null, '1', null, null, null, null);

-- ----------------------------
-- Table structure for t_code_table_head
-- ----------------------------
DROP TABLE IF EXISTS `t_code_table_head`;
CREATE TABLE `t_code_table_head` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) DEFAULT NULL COMMENT '所属用户',
  `table_name` varchar(50) NOT NULL COMMENT '表名',
  `class_name` varchar(50) DEFAULT NULL,
  `content` varchar(200) NOT NULL COMMENT '表名称',
  `is_import` int(1) DEFAULT NULL COMMENT '是否导入Excel',
  `is_export` int(1) DEFAULT NULL COMMENT '是否导出Excel',
  `is_pagination` int(1) DEFAULT NULL COMMENT '是否分页',
  `is_log` int(1) DEFAULT NULL COMMENT '是否添加日志',
  `is_protocol` int(1) DEFAULT NULL COMMENT '是否添加协议',
  `CRT_USER_ID` int(16) DEFAULT NULL COMMENT '创建人',
  `CRT_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `MDF_USER_ID` int(16) DEFAULT NULL COMMENT '修改人',
  `MDF_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='表单管理';

-- ----------------------------
-- Records of t_code_table_head
-- ----------------------------
INSERT INTO `t_code_table_head` VALUES ('65', '1', 'buss_comment_log', 'BussCommentLog', '点评日志表', '2', '2', '2', '1', null, '1', '2017-10-27 14:33:17', '1', '2017-10-27 14:34:43');
INSERT INTO `t_code_table_head` VALUES ('66', '1', 't_system_table_field', 'TSystemTableField', '表字段', null, null, null, null, null, '1', '2017-10-27 17:39:12', null, null);
INSERT INTO `t_code_table_head` VALUES ('67', '1', 't_code_template_file', 'TCodeTemplateFile', '模板文件内容', null, null, null, null, null, '1', '2017-10-27 17:41:52', null, null);

-- ----------------------------
-- Table structure for t_code_table_service_config
-- ----------------------------
DROP TABLE IF EXISTS `t_code_table_service_config`;
CREATE TABLE `t_code_table_service_config` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `table_id` int(10) NOT NULL COMMENT '对应表',
  `type` varchar(10) NOT NULL COMMENT '功能 ',
  `is_enable` int(1) DEFAULT NULL COMMENT '是否启用改功能',
  `is_permission` int(1) DEFAULT NULL COMMENT '是否需要授权',
  `is_transactional` int(1) DEFAULT NULL COMMENT '是否开启事务',
  `transactional_type` varchar(2) DEFAULT NULL COMMENT '事务类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=226 DEFAULT CHARSET=latin1 COMMENT='表功能配置';

-- ----------------------------
-- Records of t_code_table_service_config
-- ----------------------------
INSERT INTO `t_code_table_service_config` VALUES ('211', '65', 'list', '1', '1', '2', '02');
INSERT INTO `t_code_table_service_config` VALUES ('212', '65', 'add', '1', '1', '1', '01');
INSERT INTO `t_code_table_service_config` VALUES ('213', '65', 'edit', '1', '1', '1', '01');
INSERT INTO `t_code_table_service_config` VALUES ('214', '65', 'delete', '1', '1', '1', '01');
INSERT INTO `t_code_table_service_config` VALUES ('215', '65', 'detail', '2', '1', '2', '02');
INSERT INTO `t_code_table_service_config` VALUES ('216', '66', 'list', '1', '1', '2', '02');
INSERT INTO `t_code_table_service_config` VALUES ('217', '66', 'add', '1', '1', '1', '01');
INSERT INTO `t_code_table_service_config` VALUES ('218', '66', 'edit', '1', '1', '1', '01');
INSERT INTO `t_code_table_service_config` VALUES ('219', '66', 'delete', '1', '1', '1', '01');
INSERT INTO `t_code_table_service_config` VALUES ('220', '66', 'detail', '1', '1', '2', '02');
INSERT INTO `t_code_table_service_config` VALUES ('221', '67', 'list', '1', '1', '2', '02');
INSERT INTO `t_code_table_service_config` VALUES ('222', '67', 'add', '1', '1', '1', '01');
INSERT INTO `t_code_table_service_config` VALUES ('223', '67', 'edit', '1', '1', '1', '01');
INSERT INTO `t_code_table_service_config` VALUES ('224', '67', 'delete', '1', '1', '1', '01');
INSERT INTO `t_code_table_service_config` VALUES ('225', '67', 'detail', '1', '1', '2', '02');

-- ----------------------------
-- Table structure for t_code_template
-- ----------------------------
DROP TABLE IF EXISTS `t_code_template`;
CREATE TABLE `t_code_template` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `Template_NAME` varchar(50) NOT NULL COMMENT '模板名称',
  `Template_path` varchar(20) DEFAULT NULL COMMENT '模板地址',
  `USER_ID` varchar(32) DEFAULT NULL,
  `Template_DESC` varchar(1000) DEFAULT NULL,
  `FILE_NAME` varchar(100) NOT NULL COMMENT '文件名称',
  `GROUP_ID` int(10) NOT NULL COMMENT '组ID',
  `local_path` varchar(100) DEFAULT NULL COMMENT '本地路径',
  `TEMPLATE_TYPE` varchar(20) NOT NULL COMMENT '模板类型',
  `CRT_USER_ID` int(10) DEFAULT NULL COMMENT '创建人',
  `CRT_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `MDF_USER_ID` int(10) DEFAULT NULL COMMENT '修改人',
  `MDF_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='模板';

-- ----------------------------
-- Records of t_code_template
-- ----------------------------
INSERT INTO `t_code_template` VALUES ('4', 'GUNS-Controller模板', 'controller', '0', '', '%sController.java', '1', 'java', 'beetl', null, null, '76', '2017-09-17 17:23:57');
INSERT INTO `t_code_template` VALUES ('5', 'GUNS-IService模板', 'service', null, '', 'I%sService.java', '1', 'java', 'beetl', null, null, '76', '2017-09-17 17:24:13');
INSERT INTO `t_code_template` VALUES ('6', 'GUNS-ServiceImpl模板', 'service.impl', null, '', '%sServiceImpl.java', '1', 'java', 'beetl', null, null, '76', '2017-09-17 17:24:20');
INSERT INTO `t_code_template` VALUES ('7', 'GUNS-Dao模板', 'dao', null, '', '%sDao.java', '1', 'java', 'beetl', null, null, '76', '2017-09-17 17:24:26');
INSERT INTO `t_code_template` VALUES ('8', 'GUNS-Mapping模板', '', null, '', '%sMapping.xml', '1', 'resources', 'beetl', null, null, '76', '2017-09-17 18:27:06');
INSERT INTO `t_code_template` VALUES ('9', 'GUNS-Page模板', '', null, '', '%s.html', '1', 'webapp', 'beetl', null, null, '76', '2017-09-17 17:24:54');
INSERT INTO `t_code_template` VALUES ('10', 'GUNS-Page Js模板', '', null, '', '%s.js', '1', 'webapp', 'beetl', null, null, '76', '2017-09-17 17:25:08');
INSERT INTO `t_code_template` VALUES ('11', 'GUNS-Page Add', '', null, '', '%s_add.html', '1', 'webapp', 'beetl', null, null, '76', '2017-09-17 17:25:17');
INSERT INTO `t_code_template` VALUES ('12', 'GUNS-Page Info Js模板', '', null, '', '%s_info.js', '1', 'webapp', 'beetl', null, null, '76', '2017-09-17 17:25:26');
INSERT INTO `t_code_template` VALUES ('13', 'GUNS-Page Edit', '', null, '', '%s_edit.html', '1', 'webapp', 'beetl', null, null, '76', '2017-09-17 17:25:36');
INSERT INTO `t_code_template` VALUES ('14', 'GUNS-Model模板', 'model', null, '', '%sModel.java', '1', 'java', 'beetl', null, null, '76', '2017-09-17 18:22:12');

-- ----------------------------
-- Table structure for t_code_template_file
-- ----------------------------
DROP TABLE IF EXISTS `t_code_template_file`;
CREATE TABLE `t_code_template_file` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `template_id` int(10) NOT NULL,
  `file` text COMMENT '文件内容',
  `file_type` varchar(20) DEFAULT NULL COMMENT '文件类型',
  `CRT_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `MDF_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='模板文件内容';

-- ----------------------------
-- Records of t_code_template_file
-- ----------------------------
INSERT INTO `t_code_template_file` VALUES ('6', '5', 'package ${g.codePackage}.service;\n\nimport com.baomidou.mybatisplus.plugins.pagination.Pagination;\nimport ${g.codePackage}.model.${g.entityName}Model;\nimport com.baomidou.mybatisplus.mapper.Wrapper;\n\nimport java.util.List;\nimport java.util.Map;\n\n\n/**\n * ${g.name}Service\n *\n * @author ${g.author}\n * @Date ${g.date}\n */\npublic interface I${g.entityName}Service {\n\n     /**\n     * <p>\n     * 插入一条记录\n     * </p>\n     *\n     * @param entity 实体对象\n     * @return int\n     */\n    Integer insert(${g.entityName}Model entity);\n\n    /**\n     * <p>\n     * 根据 ID 删除\n     * </p>\n     *\n     * @param id 主键ID\n     * @return int\n     */\n    Integer deleteById(Integer id);\n\n    /**\n     * <p>\n     * 根据 ID 修改\n     * </p>\n     *\n     * @param entity 实体对象\n     * @return int\n     */\n    Integer updateById(${g.entityName}Model entity);\n\n    /**\n     * <p>\n     * 根据 ID 查询\n     * </p>\n     *\n     * @param id 主键ID\n     * @return ${g.entityName}Model\n     */\n    ${g.entityName}Model selectById(Integer id);\n\n    /**\n     * <p>\n     * 根据 entity 条件，查询一条记录\n     * </p>\n     *\n     * @param entity 实体对象\n     * @return ${g.entityName}Model\n     */\n    ${g.entityName}Model selectOne(${g.entityName}Model entity);\n\n    /**\n     * <p>\n     * 根据 model 条件，查询总记录数\n     * </p>\n     *\n     * @param model 实体对象\n     * @return int\n     */\n    Integer selectCount(${g.entityName}Model model);\n\n    /**\n     * <p>\n     * 根据 entity 条件，查询全部记录\n     * </p>\n     *\n     * @param model 实体对象封装操作类（可以为 null）\n     * @return List<${g.entityName}Model>\n     */\n    List<${g.entityName}Model> selectList(${g.entityName}Model model);\n\n\n    /**\n     * <p>\n     * 根据 entity 条件，查询全部记录（并翻页）\n     * </p>\n     *\n     * @param pagination 分页查询条件\n     * @param model   实体对象封装操作可以为 null）\n     * @param wrapper   SQL包装\n     * @return List<${g.entityName}Model>\n     */\n    List<${g.entityName}Model> selectPage(Pagination pagination, ${g.entityName}Model model,Wrapper<${g.entityName}Model> wrapper);\n\n}\n', 'C', '2017-09-13 15:01:49', '2017-09-13 15:01:49');
INSERT INTO `t_code_template_file` VALUES ('7', '6', 'package ${g.codePackage}.service.impl;\n\nimport com.baomidou.mybatisplus.mapper.Wrapper;\nimport com.baomidou.mybatisplus.plugins.pagination.Pagination;\nimport ${g.codePackage}.dao.${g.entityName}Dao;\nimport ${g.codePackage}.model.${g.entityName}Model;\nimport ${g.codePackage}.service.I${g.entityName}Service;\n\nimport org.springframework.beans.factory.annotation.Autowired;\nimport org.springframework.stereotype.Service;\n\nimport java.util.List;\nimport java.util.Map;\n/**\n * ${g.name}Service\n *\n * @author ${g.author}\n * @Date ${g.date}\n */\n@Service\npublic class ${g.entityName}ServiceImpl implements I${g.entityName}Service {\n\n    @Autowired\n    private ${g.entityName}Dao ${strutil.toLowerCase(strutil.subStringTo (g.entityName,0,1))}${strutil.subString  (g.entityName,1)}Dao;\n\n    @Override\n    public Integer insert(${g.entityName}Model entity) {\n        return ${strutil.toLowerCase(strutil.subStringTo (g.entityName,0,1))}${strutil.subString  (g.entityName,1)}Dao.insert(entity);\n    }\n\n    @Override\n    public Integer deleteById(Integer id) {\n        return ${strutil.toLowerCase(strutil.subStringTo (g.entityName,0,1))}${strutil.subString  (g.entityName,1)}Dao.deleteById(id);\n    }\n\n    @Override\n    public Integer updateById(${g.entityName}Model entity) {\n        return ${strutil.toLowerCase(strutil.subStringTo (g.entityName,0,1))}${strutil.subString  (g.entityName,1)}Dao.updateById(entity);\n    }\n\n    @Override\n    public ${g.entityName}Model selectById(Integer id) {\n        return ${strutil.toLowerCase(strutil.subStringTo (g.entityName,0,1))}${strutil.subString  (g.entityName,1)}Dao.selectById(id);\n    }\n\n    @Override\n    public ${g.entityName}Model selectOne(${g.entityName}Model entity) {\n        return ${strutil.toLowerCase(strutil.subStringTo (g.entityName,0,1))}${strutil.subString  (g.entityName,1)}Dao.selectOne(entity);\n    }\n\n    @Override\n    public Integer selectCount(${g.entityName}Model model) {\n        return ${strutil.toLowerCase(strutil.subStringTo (g.entityName,0,1))}${strutil.subString  (g.entityName,1)}Dao.selectCount(model);\n    }\n\n    @Override\n    public List<${g.entityName}Model> selectList(${g.entityName}Model model) {\n        return ${strutil.toLowerCase(strutil.subStringTo (g.entityName,0,1))}${strutil.subString  (g.entityName,1)}Dao.selectList(model);\n    }\n\n    @Override\n    public List<${g.entityName}Model> selectPage(Pagination pagination, ${g.entityName}Model model, Wrapper<${g.entityName}Model> wrapper) {\n        return ${strutil.toLowerCase(strutil.subStringTo (g.entityName,0,1))}${strutil.subString  (g.entityName,1)}Dao.selectPage(pagination,model,wrapper);\n    }\n\n}\n', 'Java', '2017-09-13 15:02:10', '2017-09-13 15:02:10');
INSERT INTO `t_code_template_file` VALUES ('8', '7', 'package ${g.codePackage}.dao;\n\nimport com.baomidou.mybatisplus.mapper.BaseMapper;\nimport com.baomidou.mybatisplus.mapper.Wrapper;\nimport com.baomidou.mybatisplus.plugins.pagination.Pagination;\nimport ${g.codePackage}.model.${g.entityName}Model;\n\nimport org.apache.ibatis.annotations.Param;\nimport org.springframework.stereotype.Repository;\n\nimport java.util.List;\n\n/**\n * ${g.entityName}Dao\n *\n * @author ${g.author}\n * @Date ${g.date}\n */\n@Repository\npublic interface ${g.entityName}Dao extends BaseMapper<${g.entityName}Model>{\n\n    /**\n     * 统计数量\n     * @param model\n     * @return\n     */\n    Integer selectCount(@Param(\"e\")${g.entityName}Model model);\n\n    /**\n     * 查询列表\n     * @param model\n     * @return\n     */\n    List<${g.entityName}Model> selectList(@Param(\"e\")${g.entityName}Model model);\n\n    /**\n     * 分页查询信息\n     * @param pagination\n     * @param model\n     * @param wrapper\n     * @return\n     */\n    List<${g.entityName}Model> selectPage(@Param(\"p\")Pagination pagination,@Param(\"e\") ${g.entityName}Model model,@Param(\"w\") Wrapper<${g.entityName}Model> wrapper);\n\n}\n', 'Java', '2017-09-13 15:02:27', '2017-09-13 15:02:27');
INSERT INTO `t_code_template_file` VALUES ('9', '8', '<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\n<mapper namespace=\"${g.codePackage}.dao.${g.entityName}Dao\">\n\n	<resultMap id=\"BaseResultMap\" type=\"${g.codePackage}.model.${g.entityName}Model\">\n		<%for(field in t.fields){%>\n		    <result column=\"${field.fieldName}\" property=\"${field.name}\" />\n		<%}%>\n	</resultMap>\n\n	\n	<select id=\"selectCount\" resultMap=\"BaseResultMap\">\n			select count(1) from ${strutil.toUpperCase(g.tableName)} t\n		<where>\n			<include refid=\"select_content\"/>\n		</where>\n	</select>\n	\n	<select id=\"selectList\" resultMap=\"BaseResultMap\">\n			select * from ${strutil.toUpperCase(g.tableName)} t\n		<where>\n			<include refid=\"select_content\"/>\n		</where>\n	</select>\n\n	<select id=\"selectPage\" resultMap=\"BaseResultMap\">\n			select * from ${strutil.toUpperCase(g.tableName)} t\n		<where>\n			<include refid=\"select_content\"/>\n			\\${w.sqlSegment}\n		</where>\n	</select>\n	\n	<sql id=\"select_content\">	\n			<%for(field in t.fields){%>\n				<if test=\"e.${field.name} != null and e.${field.name} != \'\' \">\n					AND t.${strutil.toUpperCase(field.fieldName)} = #{e.${field.name}}\n				</if>\n			<%}%>\n	</sql>\n\n</mapper>', 'Xml', '2017-09-13 15:02:42', '2017-09-13 15:02:42');
INSERT INTO `t_code_template_file` VALUES ('10', '9', '@layout(\"/common/_container.html\"){\n<div class=\"row\">\n    <div class=\"col-sm-12\">\n        <div class=\"ibox float-e-margins\">\n            <div class=\"ibox-title\">\n                <h5>${g.name}管理</h5>\n            </div>\n            <div class=\"ibox-content\">\n                <div class=\"row row-lg\">\n                    <div class=\"col-sm-12\">\n                        <div class=\"row\">\n                            <div class=\"col-sm-3\">\n                                <${\"#\"}NameCon id=\"condition\" name=\"名称\" />\n                            </div>\n                            <div class=\"col-sm-3\">\n                                <${\"#\"}button name=\"搜索\" icon=\"fa-search\" clickFun=\"${g.entityName}.search()\"/>\n                            </div>\n                        </div>\n                        <div class=\"hidden-xs\" id=\"${g.entityName}TableToolbar\" role=\"group\">\n                            @if(shiro.hasPermission(\"/${strutil.toLowerCase(g.entityName)}/add\")){\n                                <${\"#\"}button name=\"添加\" icon=\"fa-plus\" clickFun=\"${g.entityName}.openAdd${g.entityName}()\"/>\n                            @}\n                            @if(shiro.hasPermission(\"/${strutil.toLowerCase(g.entityName)}/update\")){\n                                <${\"#\"}button name=\"修改\" icon=\"fa-plus\" clickFun=\"${g.entityName}.open${g.entityName}Detail()\" space=\"true\"/>\n                            @}\n                            @if(shiro.hasPermission(\"/${strutil.toLowerCase(g.entityName)}/delete\")){\n                                <${\"#\"}button name=\"删除\" icon=\"fa-plus\" clickFun=\"${g.entityName}.delete()\" space=\"true\"/>\n                            @}\n                        </div>\n                        <${\"#\"}table id=\"${g.entityName}Table\"/>\n                    </div>\n                </div>\n            </div>\n        </div>\n    </div>\n</div>\n< src=\"\\${ctxPath}/static/modular/biz/${strutil.toLowerCase(g.entityName)}/${strutil.toLowerCase(g.entityName)}.js\"></>\n@}\n', 'Html', '2017-09-13 15:02:59', '2017-09-13 15:02:59');
INSERT INTO `t_code_template_file` VALUES ('11', '10', '/**\n * ${g.name}管理初始化\n */\nvar ${g.entityName} = {\n    id: \"${g.entityName}Table\",	//表格id\n    seItem: null,		//选中的条目\n    table: null,\n    layerIndex: -1\n};\n\n/**\n * 初始化表格的列\n */\n${g.entityName}.initColumn = function () {\n    return [\n        {field: \'selectItem\', radio: true},\n	<%for(field in t.fields){%>\n	     {title: \'${field.chinaName}\', field: \'${field.name}\', align: \'center\', valign: \'middle\'},\n	<%}%>\n    ];\n};\n\n/**\n * 检查是否选中\n */\n${g.entityName}.check = function () {\n    var selected = $(\'#\' + this.id).bootstrapTable(\'getSelections\');\n    if(selected.length == 0){\n        Feng.info(\"请先选中表格中的某一记录！\");\n        return false;\n    }else{\n        ${g.entityName}.seItem = selected[0];\n        return true;\n    }\n};\n\n/**\n * 点击添加${g.name}\n */\n${g.entityName}.openAdd${g.entityName} = function () {\n    var index = layer.open({\n        type: 2,\n        title: \'添加${g.name}\',\n        area: [\'800px\', \'420px\'], //宽高\n        fix: false, //不固定\n        maxmin: true,\n        content: Feng.ctxPath + \'/${strutil.toLowerCase(g.entityName)}/goto_add\'\n    });\n    this.layerIndex = index;\n};\n\n/**\n * 打开查看${g.name}详情\n */\n${g.entityName}.open${g.entityName}Detail = function () {\n    if (this.check()) {\n        var index = layer.open({\n            type: 2,\n            title: \'${g.name}详情\',\n            area: [\'800px\', \'420px\'], //宽高\n            fix: false, //不固定\n            maxmin: true,\n            content: Feng.ctxPath + \'/${strutil.toLowerCase(g.entityName)}/goto_update/\' + ${g.entityName}.seItem.id\n        });\n        this.layerIndex = index;\n    }\n};\n\n/**\n * 删除${g.name}\n */\n${g.entityName}.delete = function () {\n    if (this.check()) {\n        var ajax = new $ax(Feng.ctxPath + \"/${strutil.toLowerCase(g.entityName)}/delete\", function (data) {\n            Feng.success(\"删除成功!\");\n            ${g.entityName}.table.refresh();\n        }, function (data) {\n            Feng.error(\"删除失败!\" + data.responseJSON.message + \"!\");\n        });\n        ajax.set(\"${strutil.toLowerCase(g.entityName)}Id\",this.seItem.id);\n        ajax.start();\n    }\n};\n\n${g.entityName}.formParams = function() {\n    var queryData = {};\n    return queryData;\n};\n\n/**\n * 查询${g.name}列表\n */\n${g.entityName}.search = function () {\n    var queryData = {};\n    queryData[\'condition\'] = $(\"#condition\").val();\n    ${g.entityName}.table.refresh({query: queryData});\n};\n\n$(function () {\n    var defaultColunms = ${g.entityName}.initColumn();\n    var table = new BSTable(${g.entityName}.id, \"/${strutil.toLowerCase(g.entityName)}/list\", defaultColunms);\n    table.setPaginationType(\"server\");\n    table.setQueryParams(${g.entityName}.formParams());\n    ${g.entityName}.table = table.init();\n});\n', 'JavaScript', '2017-09-13 15:03:14', '2017-09-13 15:03:14');
INSERT INTO `t_code_template_file` VALUES ('12', '11', '@layout(\"/common/_container.html\"){\n<div class=\"ibox float-e-margins\">\n    <div class=\"ibox-content\">\n        <div class=\"form-horizontal\">\n\n            <input type=\"hidden\" id=\"id\" value=\"\">\n\n            <div class=\"row\">\n                <div class=\"col-sm-6 b-r\">\n			<%for(field in t.fields){%>\n			     <${\"#\"}input id=\"${field.name}\" name=\"${field.chinaName}\" underline=\"true\"/>\n			<%}%>\n                </div>\n\n                <div class=\"col-sm-6\">\n\n                </div>\n            </div>\n\n            <div class=\"row btn-group-m-t\">\n                <div class=\"col-sm-10\">\n                    <${\"#\"}button btnCss=\"info\" name=\"提交\" id=\"ensure\" icon=\"fa-check\" clickFun=\"${g.entityName}InfoDlg.addSubmit()\"/>\n                    <${\"#\"}button btnCss=\"danger\" name=\"取消\" id=\"cancel\" icon=\"fa-eraser\" clickFun=\"${g.entityName}InfoDlg.close()\"/>\n                </div>\n            </div>\n        </div>\n\n    </div>\n</div>\n< src=\"\\${ctxPath}/static/modular/biz/${strutil.toLowerCase(g.entityName)}/${strutil.toLowerCase(g.entityName)}_info.js\"></>\n@}\n', 'Html', '2017-09-13 15:03:42', '2017-09-13 15:03:42');
INSERT INTO `t_code_template_file` VALUES ('13', '12', '/**\n * 初始化${g.name}详情对话框\n */\nvar ${g.entityName}InfoDlg = {\n    ${strutil.toUpperCase(strutil.subStringTo (g.entityName,0,1))}${strutil.subString  (g.entityName,1)}InfoData : {}\n};\n\n/**\n * 清除数据\n */\n${g.entityName}InfoDlg.clearData = function() {\n    this.${strutil.toUpperCase(strutil.subStringTo (g.entityName,0,1))}${strutil.subString  (g.entityName,1)}InfoData = {};\n}\n\n/**\n * 设置对话框中的数据\n *\n * @param key 数据的名称\n * @param val 数据的具体值\n */\n${g.entityName}InfoDlg.set = function(key, val) {\n    this.${strutil.toUpperCase(strutil.subStringTo (g.entityName,0,1))}${strutil.subString  (g.entityName,1)}InfoData[key] = (typeof val == \"undefined\") ? $(\"#\" + key).val() : val;\n    return this;\n}\n\n/**\n * 设置对话框中的数据\n *\n * @param key 数据的名称\n * @param val 数据的具体值\n */\n${g.entityName}InfoDlg.get = function(key) {\n    return $(\"#\" + key).val();\n}\n\n/**\n * 关闭此对话框\n */\n${g.entityName}InfoDlg.close = function() {\n    parent.layer.close(window.parent.${g.entityName}.layerIndex);\n}\n\n/**\n * 收集数据\n */\n${g.entityName}InfoDlg.collectData = function() {\n    this.set(\'id\');\n}\n\n/**\n * 提交添加\n */\n${g.entityName}InfoDlg.addSubmit = function() {\n\n    this.clearData();\n    this.collectData();\n\n    //提交信息\n    var ajax = new $ax(Feng.ctxPath + \"/${strutil.toUpperCase(strutil.subStringTo (g.entityName,0,1))}${strutil.subString  (g.entityName,1)}/add\", function(data){\n        Feng.success(\"添加成功!\");\n        window.parent.${g.entityName}.table.refresh();\n        ${g.entityName}InfoDlg.close();\n    },function(data){\n        Feng.error(\"添加失败!\" + data.responseJSON.message + \"!\");\n    });\n    ajax.set(this.${strutil.toUpperCase(strutil.subStringTo (g.entityName,0,1))}${strutil.subString  (g.entityName,1)}InfoData);\n    ajax.start();\n}\n\n/**\n * 提交修改\n */\n${g.entityName}InfoDlg.editSubmit = function() {\n\n    this.clearData();\n    this.collectData();\n\n    //提交信息\n    var ajax = new $ax(Feng.ctxPath + \"/${strutil.toUpperCase(strutil.subStringTo (g.entityName,0,1))}${strutil.subString  (g.entityName,1)}/update\", function(data){\n        Feng.success(\"修改成功!\");\n        window.parent.${g.entityName}.table.refresh();\n        ${g.entityName}InfoDlg.close();\n    },function(data){\n        Feng.error(\"修改失败!\" + data.responseJSON.message + \"!\");\n    });\n    ajax.set(this.${strutil.toUpperCase(strutil.subStringTo (g.entityName,0,1))}${strutil.subString  (g.entityName,1)}InfoData);\n    ajax.start();\n}\n\n$(function() {\n\n});\n', 'JavaScript', '2017-09-13 15:03:56', '2017-09-13 15:03:56');
INSERT INTO `t_code_template_file` VALUES ('14', '13', '@layout(\"/common/_container.html\"){\n<div class=\"ibox float-e-margins\">\n    <div class=\"ibox-content\">\n        <div class=\"form-horizontal\">\n\n            <input type=\"hidden\" id=\"id\" value=\"\\${${strutil.toLowerCase(g.entityName)}.id}\">\n\n            <div class=\"row\">\n                <div class=\"col-sm-6 b-r\">\n			<%for(field in t.fields){%>\n			     <${\"#\"}input id=\"${field.name}\" name=\"${field.chinaName}\" underline=\"true\" value=\"\\${${strutil.toLowerCase(g.entityName)}.${field.name}}\"/>\n			<%}%>\n                </div>\n\n                <div class=\"col-sm-6\">\n\n                </div>\n            </div>\n\n            <div class=\"row btn-group-m-t\">\n                <div class=\"col-sm-10\">\n                    <${\"#\"}button btnCss=\"info\" name=\"提交\" id=\"ensure\" icon=\"fa-check\" clickFun=\"${g.entityName}InfoDlg.editSubmit()\"/>\n                    <${\"#\"}button btnCss=\"danger\" name=\"取消\" id=\"cancel\" icon=\"fa-eraser\" clickFun=\"${g.entityName}InfoDlg.close()\"/>\n                </div>\n            </div>\n        </div>\n\n    </div>\n</div>\n< src=\"\\${ctxPath}/static/modular/biz/${strutil.toLowerCase(g.entityName)}/${strutil.toLowerCase(g.entityName)}_info.js\"></>\n@}\n', 'Html', '2017-09-13 15:04:08', '2017-09-13 15:04:08');
INSERT INTO `t_code_template_file` VALUES ('15', '14', 'package ${g.codePackage}.model;\n\nimport com.baomidou.mybatisplus.activerecord.Model;\nimport com.baomidou.mybatisplus.annotations.TableId;\nimport com.baomidou.mybatisplus.annotations.TableField;\nimport com.baomidou.mybatisplus.annotations.TableName;\nimport com.baomidou.mybatisplus.enums.IdType;\n\nimport org.apache.commons.lang3.builder.ReflectionToStringBuilder;\n\nimport java.io.Serializable;\nimport java.util.Date;\n\n/**\n * ${g.name}\n *\n * @author ${g.author}\n * @Date ${g.date}\n */\n@TableName(\"${g.tableName}\")\npublic class ${g.entityName}Model extends Model<${g.entityName}Model> {\n\n    private static final long serialVersionUID = 1L;\n\n	\n		<%for(field in t.fields){%>\n		     /**\n		     * ${field.chinaName}\n		     * ${field.comment}\n		     */\n			<%if (field.name == \'id\') {%>\n			@TableId(value = \"id\",type = IdType.AUTO)\n			<%}else{%>\n			@TableField(value=\"${field.fieldName}\")\n			<%}%>\n			private ${field.type} ${field.name};\n		\n		<%}%>\n    \n		<%for(field in t.fields){%>\n		     /**\n		     * 获取: ${field.chinaName}\n		     * ${field.comment}\n		     */\n		    public ${field.type} get${strutil.toUpperCase(strutil.subStringTo (field.name,0,1))}${strutil.subString  (field.name,1)}() {\n			return ${field.name};\n		    }\n		     /**\n		     * 设置: ${field.chinaName}\n		     * ${field.comment}\n		     */\n		    public void set${strutil.toUpperCase(strutil.subStringTo (field.name,0,1))}${strutil.subString  (field.name,1)}(${field.type} ${field.name}) {\n			this.${field.name} = ${field.name};\n		    }\n		<%}%>\n       \n \n   \n\n	@Override\n	protected Serializable pkVal() {\n		return this.id;\n	}\n\n	@Override\n	public String toString() {\n		return ReflectionToStringBuilder.toString(this);\n	}\n}\n', 'Java', '2017-09-13 15:04:23', '2017-09-13 15:04:23');
INSERT INTO `t_code_template_file` VALUES ('17', '4', 'package ${g.codePackage}.controller;\n\nimport com.baomidou.mybatisplus.mapper.EntityWrapper;\nimport com.baomidou.mybatisplus.plugins.Page;\nimport com.baomidou.mybatisplus.plugins.pagination.Pagination;\nimport com.stylefeng.guns.common.annotion.Permission;\nimport com.stylefeng.guns.common.annotion.log.BussinessLog;\nimport com.stylefeng.guns.common.constant.factory.PageFactory;\nimport com.stylefeng.guns.common.constant.state.BizLogType;\nimport com.stylefeng.guns.common.controller.BaseController;\nimport com.stylefeng.guns.common.exception.BizExceptionEnum;\nimport com.stylefeng.guns.common.exception.BussinessException;\nimport com.stylefeng.guns.common.persistence.model.OperationLog;\nimport com.stylefeng.guns.core.util.ToolUtil;\nimport ${g.codePackage}.model.${g.entityName}Model;\nimport ${g.codePackage}.service.I${g.entityName}Service;\n\nimport org.springframework.beans.factory.annotation.Autowired;\nimport org.springframework.stereotype.Controller;\nimport org.springframework.ui.Model;\nimport org.springframework.web.bind.annotation.PathVariable;\nimport org.springframework.web.bind.annotation.RequestMapping;\nimport org.springframework.web.bind.annotation.RequestParam;\nimport org.springframework.web.bind.annotation.ResponseBody;\n\nimport javax.annotation.Resource;\nimport java.util.List;\nimport java.util.Map;\n\n/**\n * ${g.name}控制器\n *\n * @author ${g.author}\n * @Date ${g.date}\n */\n@Controller\n@RequestMapping(\"/${strutil.toLowerCase(g.entityName)}\")\npublic class ${g.entityName}Controller extends BaseController {\n\n    private static final Logger LOGGER = LoggerFactory.getLogger(${g.entityName}Controller.class);\n\n    private String PREFIX = \"/biz/${strutil.toLowerCase(g.entityName)}/\";\n\n    @Autowired\n    private I${g.entityName}Service ${strutil.toLowerCase(strutil.subStringTo (g.entityName,0,1))}${strutil.subString  (g.entityName,1)}Service;\n\n    /**\n     * 跳转到首页\n     */\n    @RequestMapping(\"\")\n    public String index() {\n        return PREFIX + \"${strutil.toLowerCase(g.entityName)}.html\";\n    }\n\n    /**\n     * 跳转到添加\n     */\n    @RequestMapping(\"/goto_add\")\n    public String ${g.entityName}Add() {\n        return PREFIX + \"${strutil.toLowerCase(g.entityName)}_add.html\";\n    }\n\n    /**\n     * 跳转到修改\n     */\n    @RequestMapping(\"/goto_update/{id}\")\n    public String ${g.entityName}Update(@PathVariable Integer id, Model model) {\n	model.addAttribute(\"${strutil.toLowerCase(g.entityName)}\", ${strutil.toLowerCase(strutil.subStringTo (g.entityName,0,1))}${strutil.subString  (g.entityName,1)}Service.selectById(id));\n        return PREFIX + \"${strutil.toLowerCase(g.entityName)}_edit.html\";\n    }\n\n    /**\n     * 获取列表\n     */\n    @RequestMapping(value = \"/list\")\n    @ResponseBody\n    public Object list(${g.entityName}Model model) {\n        Page<${g.entityName}Model> page = new PageFactory<${g.entityName}Model>().defaultPage();\n        page.setRecords(${strutil.toLowerCase(strutil.subStringTo (g.entityName,0,1))}${strutil.subString  (g.entityName,1)}Service.selectPage(page,model,new EntityWrapper<${g.entityName}Model>()));\n        return super.packForBT(page);\n    }\n\n\n    @BussinessLog(value = \"${g.name}新增\", key = \"companyid\" )\n    @RequestMapping(value = \"/add\")\n    @Permission\n    @ResponseBody\n    public Object add(${g.entityName}Model model) {\n        ${strutil.toLowerCase(strutil.subStringTo (g.entityName,0,1))}${strutil.subString  (g.entityName,1)}Service.insert(model);\n        return SUCCESS_TIP;\n    }\n\n\n    @BussinessLog(value = \"${g.name}删除\", key = \"id\" )\n    @RequestMapping(value = \"/delete\")\n    @Permission\n    @ResponseBody\n    public Object delete(Integer id) {\n        ${strutil.toLowerCase(strutil.subStringTo (g.entityName,0,1))}${strutil.subString  (g.entityName,1)}Service.deleteById(id);\n        return SUCCESS_TIP;\n    }\n\n\n    @BussinessLog(value = \"${g.name}修改\", key = \"id\" )\n    @RequestMapping(value = \"/update\")\n    @Permission\n    @ResponseBody\n    public Object update(${g.entityName}Model model) {\n        if (ToolUtil.isOneEmpty(model.getId())) {\n            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);\n        }\n        ${strutil.toLowerCase(strutil.subStringTo (g.entityName,0,1))}${strutil.subString  (g.entityName,1)}Service.updateById(model);\n        return super.SUCCESS_TIP;\n    }\n\n    /**\n     * 详情\n     */\n    @RequestMapping(value = \"/detail\")\n    @ResponseBody\n    public Object detail(${g.entityName}Model model) {\n        return ${strutil.toLowerCase(strutil.subStringTo (g.entityName,0,1))}${strutil.subString  (g.entityName,1)}Service.selectOne(model);\n    }\n}\n', 'Java', '2017-09-14 16:40:20', '2017-09-14 16:40:20');
INSERT INTO `t_code_template_file` VALUES ('18', '34', 'package ${g.codePackage}.controller;\n\nimport com.baomidou.mybatisplus.mapper.EntityWrapper;\nimport com.baomidou.mybatisplus.plugins.Page;\nimport com.baomidou.mybatisplus.plugins.pagination.Pagination;\nimport com.stylefeng.guns.common.annotion.Permission;\nimport com.stylefeng.guns.common.annotion.log.BussinessLog;\nimport com.stylefeng.guns.common.constant.factory.PageFactory;\nimport com.stylefeng.guns.common.constant.state.BizLogType;\nimport com.stylefeng.guns.common.controller.BaseController;\nimport com.stylefeng.guns.common.exception.BizExceptionEnum;\nimport com.stylefeng.guns.common.exception.BussinessException;\nimport com.stylefeng.guns.common.persistence.model.OperationLog;\nimport com.stylefeng.guns.core.util.ToolUtil;\nimport ${g.codePackage}.model.${g.entityName}Model;\nimport ${g.codePackage}.service.I${g.entityName}Service;\n\nimport org.springframework.beans.factory.annotation.Autowired;\nimport org.springframework.stereotype.Controller;\nimport org.springframework.ui.Model;\nimport org.springframework.web.bind.annotation.PathVariable;\nimport org.springframework.web.bind.annotation.RequestMapping;\nimport org.springframework.web.bind.annotation.RequestParam;\nimport org.springframework.web.bind.annotation.ResponseBody;\n\nimport javax.annotation.Resource;\nimport java.util.List;\nimport java.util.Map;\n\n/**\n * ${g.name}控制器\n *\n * @author ${g.author}\n * @Date ${g.date}\n */\n@Controller\n@RequestMapping(\"/${strutil.toLowerCase(g.entityName)}\")\npublic class ${g.entityName}Controller extends BaseController {\n\n    private static final Logger LOGGER = LoggerFactory.getLogger(${g.entityName}Controller.class);\n\n    private String PREFIX = \"/biz/${strutil.toLowerCase(g.entityName)}/\";\n\n    @Autowired\n    private I${g.entityName}Service ${strutil.toLowerCase(strutil.subStringTo (g.entityName,0,1))}${strutil.subString  (g.entityName,1)}Service;\n\n    /**\n     * 跳转到首页\n     */\n    @RequestMapping(\"\")\n    public String index() {\n        return PREFIX + \"${strutil.toLowerCase(g.entityName)}.html\";\n    }\n\n    /**\n     * 跳转到添加\n     */\n    @RequestMapping(\"/goto_add\")\n    public String ${g.entityName}Add() {\n        return PREFIX + \"${strutil.toLowerCase(g.entityName)}_add.html\";\n    }\n\n    /**\n     * 跳转到修改\n     */\n    @RequestMapping(\"/goto_update/{id}\")\n    public String ${g.entityName}Update(@PathVariable Integer id, Model model) {\n	model.addAttribute(\"${strutil.toLowerCase(g.entityName)}\", ${strutil.toLowerCase(strutil.subStringTo (g.entityName,0,1))}${strutil.subString  (g.entityName,1)}Service.selectById(id));\n        return PREFIX + \"${strutil.toLowerCase(g.entityName)}_edit.html\";\n    }\n\n    /**\n     * 获取列表\n     */\n    @RequestMapping(value = \"/list\")\n    @ResponseBody\n    public Object list(${g.entityName}Model model) {\n        Page<${g.entityName}Model> page = new PageFactory<${g.entityName}Model>().defaultPage();\n        page.setRecords(${strutil.toLowerCase(strutil.subStringTo (g.entityName,0,1))}${strutil.subString  (g.entityName,1)}Service.selectPage(page,model,new EntityWrapper<${g.entityName}Model>()));\n        return super.packForBT(page);\n    }\n\n\n    @BussinessLog(value = \"${g.name}新增\", key = \"companyid\" )\n    @RequestMapping(value = \"/add\")\n    @Permission\n    @ResponseBody\n    public Object add(${g.entityName}Model model) {\n        ${strutil.toLowerCase(strutil.subStringTo (g.entityName,0,1))}${strutil.subString  (g.entityName,1)}Service.insert(model);\n        return SUCCESS_TIP;\n    }\n\n\n    @BussinessLog(value = \"${g.name}删除\", key = \"id\" )\n    @RequestMapping(value = \"/delete\")\n    @Permission\n    @ResponseBody\n    public Object delete(Integer id) {\n        ${strutil.toLowerCase(strutil.subStringTo (g.entityName,0,1))}${strutil.subString  (g.entityName,1)}Service.deleteById(id);\n        return SUCCESS_TIP;\n    }\n\n\n    @BussinessLog(value = \"${g.name}修改\", key = \"id\" )\n    @RequestMapping(value = \"/update\")\n    @Permission\n    @ResponseBody\n    public Object update(${g.entityName}Model model) {\n        if (ToolUtil.isOneEmpty(model.getId())) {\n            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);\n        }\n        ${strutil.toLowerCase(strutil.subStringTo (g.entityName,0,1))}${strutil.subString  (g.entityName,1)}Service.updateById(model);\n        return super.SUCCESS_TIP;\n    }\n\n    /**\n     * 详情\n     */\n    @RequestMapping(value = \"/detail\")\n    @ResponseBody\n    public Object detail(${g.entityName}Model model) {\n        return ${strutil.toLowerCase(strutil.subStringTo (g.entityName,0,1))}${strutil.subString  (g.entityName,1)}Service.selectOne(model);\n    }\n}\n', 'Java', '2017-10-24 16:00:35', null);

-- ----------------------------
-- Table structure for t_code_template_group
-- ----------------------------
DROP TABLE IF EXISTS `t_code_template_group`;
CREATE TABLE `t_code_template_group` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) DEFAULT NULL COMMENT '用户ID',
  `name` varchar(10) NOT NULL COMMENT '组名称',
  `desc` varchar(400) DEFAULT NULL COMMENT '描述',
  `CRT_USER_ID` varchar(16) DEFAULT NULL COMMENT '创建人',
  `CRT_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `MDF_USER_ID` varchar(16) DEFAULT NULL COMMENT '修改人',
  `MDF_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='模板组';

-- ----------------------------
-- Records of t_code_template_group
-- ----------------------------
INSERT INTO `t_code_template_group` VALUES ('1', '0', 'GUNS', 'guns脚手架模板 脚手架地址:http://git.oschina.net/naan1993/guns', '1', '2017-09-12 13:58:24', '1', '2017-09-12 14:04:20');
INSERT INTO `t_code_template_group` VALUES ('3', '0', '通用', '通用,默认组', '1', '2017-09-12 14:05:13', null, null);
INSERT INTO `t_code_template_group` VALUES ('4', '1', '我的组', '测试', '1', '2017-09-12 14:05:48', null, null);

-- ----------------------------
-- Table structure for t_code_template_share
-- ----------------------------
DROP TABLE IF EXISTS `t_code_template_share`;
CREATE TABLE `t_code_template_share` (
  `ID` varchar(32) NOT NULL,
  `Template_NAME` varchar(50) DEFAULT NULL COMMENT '模板名称',
  `Template_path` varchar(1000) DEFAULT NULL COMMENT '模板地址',
  `Template_effect` varchar(1000) DEFAULT NULL COMMENT '模板效果',
  `Template_DESC` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='模板分享';

-- ----------------------------
-- Records of t_code_template_share
-- ----------------------------

-- ----------------------------
-- Table structure for t_system_dept
-- ----------------------------
DROP TABLE IF EXISTS `t_system_dept`;
CREATE TABLE `t_system_dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `num` int(11) DEFAULT NULL COMMENT '排序',
  `pid` int(11) DEFAULT NULL COMMENT '父部门id',
  `pids` varchar(255) DEFAULT NULL COMMENT '父级ids',
  `simplename` varchar(45) DEFAULT NULL COMMENT '简称',
  `fullname` varchar(255) DEFAULT NULL COMMENT '全称',
  `tips` varchar(255) DEFAULT NULL COMMENT '提示',
  `version` int(11) DEFAULT NULL COMMENT '版本（乐观锁保留字段）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of t_system_dept
-- ----------------------------
INSERT INTO `t_system_dept` VALUES ('24', '1', '0', '[0],', '总公司', '总公司', '', null);
INSERT INTO `t_system_dept` VALUES ('25', '2', '24', '[0],[24],', '开发部', '开发部', '', null);
INSERT INTO `t_system_dept` VALUES ('26', '3', '24', '[0],[24],', '运营部', '运营部', '', null);
INSERT INTO `t_system_dept` VALUES ('27', '4', '24', '[0],[24],', '战略部', '战略部', '', null);

-- ----------------------------
-- Table structure for t_system_dict
-- ----------------------------
DROP TABLE IF EXISTS `t_system_dict`;
CREATE TABLE `t_system_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `num` int(11) DEFAULT NULL COMMENT '排序',
  `pid` int(11) DEFAULT NULL COMMENT '父级字典',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `tips` varchar(255) DEFAULT NULL COMMENT '提示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8 COMMENT='字典表';

-- ----------------------------
-- Records of t_system_dict
-- ----------------------------
INSERT INTO `t_system_dict` VALUES ('16', '0', '0', '状态', null);
INSERT INTO `t_system_dict` VALUES ('17', '1', '16', '启用', null);
INSERT INTO `t_system_dict` VALUES ('18', '2', '16', '禁用', null);
INSERT INTO `t_system_dict` VALUES ('29', '0', '0', '性别', null);
INSERT INTO `t_system_dict` VALUES ('30', '1', '29', '男', null);
INSERT INTO `t_system_dict` VALUES ('31', '2', '29', '女', null);
INSERT INTO `t_system_dict` VALUES ('35', '0', '0', '账号状态', null);
INSERT INTO `t_system_dict` VALUES ('36', '1', '35', '启用', null);
INSERT INTO `t_system_dict` VALUES ('37', '2', '35', '冻结', null);
INSERT INTO `t_system_dict` VALUES ('38', '3', '35', '已删除', null);
INSERT INTO `t_system_dict` VALUES ('42', '0', '0', '启用与否', null);
INSERT INTO `t_system_dict` VALUES ('43', '1', '42', '是', null);
INSERT INTO `t_system_dict` VALUES ('44', '2', '42', '否', null);

-- ----------------------------
-- Table structure for t_system_login_log
-- ----------------------------
DROP TABLE IF EXISTS `t_system_login_log`;
CREATE TABLE `t_system_login_log` (
  `id` int(65) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `logname` varchar(255) DEFAULT NULL COMMENT '日志名称',
  `userid` int(65) DEFAULT NULL COMMENT '管理员id',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `succeed` varchar(255) DEFAULT NULL COMMENT '是否执行成功',
  `message` text COMMENT '具体消息',
  `ip` varchar(255) DEFAULT NULL COMMENT '登录ip',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=462 DEFAULT CHARSET=utf8 COMMENT='登录记录';

-- ----------------------------
-- Records of t_system_login_log
-- ----------------------------

-- ----------------------------
-- Table structure for t_system_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_system_menu`;
CREATE TABLE `t_system_menu` (
  `id` int(65) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `code` varchar(255) DEFAULT NULL COMMENT '菜单编号',
  `pcode` varchar(255) DEFAULT NULL COMMENT '菜单父编号',
  `pcodes` varchar(255) DEFAULT NULL COMMENT '当前菜单的所有父菜单编号',
  `name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `icon` varchar(255) DEFAULT NULL COMMENT '菜单图标',
  `url` varchar(255) DEFAULT NULL COMMENT 'url地址',
  `num` int(65) DEFAULT NULL COMMENT '菜单排序号',
  `levels` int(65) DEFAULT NULL COMMENT '菜单层级',
  `ismenu` int(11) DEFAULT NULL COMMENT '是否是菜单（1：是  0：不是）',
  `tips` varchar(255) DEFAULT NULL COMMENT '备注',
  `status` int(65) DEFAULT NULL COMMENT '菜单状态 :  1:启用   0:不启用',
  `isopen` int(11) DEFAULT NULL COMMENT '是否打开:    1:打开   0:不打开',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=200 DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of t_system_menu
-- ----------------------------
INSERT INTO `t_system_menu` VALUES ('105', 'system', '0', '[0],', '系统管理', 'fa-user', '', '3', '1', '1', null, '1', '1');
INSERT INTO `t_system_menu` VALUES ('106', 'mgr', 'system', '[0],[system],', '用户管理', '', '/mgr', '1', '2', '1', null, '1', '0');
INSERT INTO `t_system_menu` VALUES ('107', 'mgr_add', 'mgr', '[0],[system],[mgr],', '添加用户', null, '/mgr/add', '1', '3', '0', null, '1', '0');
INSERT INTO `t_system_menu` VALUES ('108', 'mgr_edit', 'mgr', '[0],[system],[mgr],', '修改用户', null, '/mgr/edit', '2', '3', '0', null, '1', '0');
INSERT INTO `t_system_menu` VALUES ('109', 'mgr_delete', 'mgr', '[0],[system],[mgr],', '删除用户', null, '/mgr/delete', '3', '3', '0', null, '1', '0');
INSERT INTO `t_system_menu` VALUES ('110', 'mgr_reset', 'mgr', '[0],[system],[mgr],', '重置密码', null, '/mgr/reset', '4', '3', '0', null, '1', '0');
INSERT INTO `t_system_menu` VALUES ('111', 'mgr_freeze', 'mgr', '[0],[system],[mgr],', '冻结用户', null, '/mgr/freeze', '5', '3', '0', null, '1', '0');
INSERT INTO `t_system_menu` VALUES ('112', 'mgr_unfreeze', 'mgr', '[0],[system],[mgr],', '解除冻结用户', null, '/mgr/unfreeze', '6', '3', '0', null, '1', '0');
INSERT INTO `t_system_menu` VALUES ('113', 'mgr_setRole', 'mgr', '[0],[system],[mgr],', '分配角色', null, '/mgr/setRole', '7', '3', '0', null, '1', '0');
INSERT INTO `t_system_menu` VALUES ('114', 'role', 'system', '[0],[system],', '角色管理', null, '/role', '2', '2', '1', null, '1', '0');
INSERT INTO `t_system_menu` VALUES ('115', 'role_add', 'role', '[0],[system],[role],', '添加角色', null, '/role/add', '1', '3', '0', null, '1', '0');
INSERT INTO `t_system_menu` VALUES ('116', 'role_edit', 'role', '[0],[system],[role],', '修改角色', null, '/role/edit', '2', '3', '0', null, '1', '0');
INSERT INTO `t_system_menu` VALUES ('117', 'role_remove', 'role', '[0],[system],[role],', '删除角色', null, '/role/remove', '3', '3', '0', null, '1', '0');
INSERT INTO `t_system_menu` VALUES ('118', 'role_setAuthority', 'role', '[0],[system],[role],', '配置权限', null, '/role/setAuthority', '4', '3', '0', null, '1', '0');
INSERT INTO `t_system_menu` VALUES ('119', 'menu', 'system', '[0],[system],', '菜单管理', null, '/menu', '4', '2', '1', null, '1', '0');
INSERT INTO `t_system_menu` VALUES ('120', 'menu_add', 'menu', '[0],[system],[menu],', '添加菜单', null, '/menu/add', '1', '3', '0', null, '1', '0');
INSERT INTO `t_system_menu` VALUES ('121', 'menu_edit', 'menu', '[0],[system],[menu],', '修改菜单', null, '/menu/edit', '2', '3', '0', null, '1', '0');
INSERT INTO `t_system_menu` VALUES ('122', 'menu_remove', 'menu', '[0],[system],[menu],', '删除菜单', null, '/menu/remove', '3', '3', '0', null, '1', '0');
INSERT INTO `t_system_menu` VALUES ('128', 'log', 'system', '[0],[system],', '业务日志', null, '/log', '6', '2', '1', null, '1', '0');
INSERT INTO `t_system_menu` VALUES ('130', 'druid', 'system', '[0],[system],', '监控管理', null, '/druid', '7', '2', '1', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('131', 'dept', 'system', '[0],[system],', '部门管理', null, '/dept', '3', '2', '1', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('132', 'dict', 'system', '[0],[system],', '字典管理', null, '/dict', '4', '2', '1', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('133', 'loginLog', 'system', '[0],[system],', '登录日志', null, '/loginLog', '6', '2', '1', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('134', 'log_clean', 'log', '[0],[system],[log],', '清空日志', null, '/log/delLog', '3', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('135', 'dept_add', 'dept', '[0],[system],[dept],', '添加部门', null, '/dept/add', '1', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('136', 'dept_update', 'dept', '[0],[system],[dept],', '修改部门', null, '/dept/update', '1', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('137', 'dept_delete', 'dept', '[0],[system],[dept],', '删除部门', null, '/dept/delete', '1', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('138', 'dict_add', 'dict', '[0],[system],[dict],', '添加字典', null, '/dict/add', '1', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('139', 'dict_update', 'dict', '[0],[system],[dict],', '修改字典', null, '/dict/update', '1', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('140', 'dict_delete', 'dict', '[0],[system],[dict],', '删除字典', null, '/dict/delete', '1', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('141', 'notice', 'system', '[0],[system],', '通知管理', null, '/notice', '9', '2', '1', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('142', 'notice_add', 'notice', '[0],[system],[notice],', '添加通知', null, '/notice/add', '1', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('143', 'notice_update', 'notice', '[0],[system],[notice],', '修改通知', null, '/notice/update', '2', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('144', 'notice_delete', 'notice', '[0],[system],[notice],', '删除通知', null, '/notice/delete', '3', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('145', 'hello', '0', '[0],', '通知', 'fa-rocket', '/notice/hello', '0', '1', '1', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('150', 'to_menu_edit', 'menu', '[0],[system],[menu],', '菜单编辑跳转', '', '/menu/menu_edit', '4', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('151', 'menu_list', 'menu', '[0],[system],[menu],', '菜单列表', '', '/menu/list', '5', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('152', 'to_dept_update', 'dept', '[0],[system],[dept],', '修改部门跳转', '', '/dept/dept_update', '4', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('153', 'dept_list', 'dept', '[0],[system],[dept],', '部门列表', '', '/dept/list', '5', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('154', 'dept_detail', 'dept', '[0],[system],[dept],', '部门详情', '', '/dept/detail', '6', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('155', 'to_dict_edit', 'dict', '[0],[system],[dict],', '修改菜单跳转', '', '/dict/dict_edit', '4', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('156', 'dict_list', 'dict', '[0],[system],[dict],', '字典列表', '', '/dict/list', '5', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('157', 'dict_detail', 'dict', '[0],[system],[dict],', '字典详情', '', '/dict/detail', '6', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('158', 'log_list', 'log', '[0],[system],[log],', '日志列表', '', '/log/list', '2', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('159', 'log_detail', 'log', '[0],[system],[log],', '日志详情', '', '/log/detail', '3', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('160', 'del_login_log', 'loginLog', '[0],[system],[loginLog],', '清空登录日志', '', '/loginLog/delLoginLog', '1', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('161', 'login_log_list', 'loginLog', '[0],[system],[loginLog],', '登录日志列表', '', '/loginLog/list', '2', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('162', 'to_role_edit', 'role', '[0],[system],[role],', '修改角色跳转', '', '/role/role_edit', '5', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('163', 'to_role_assign', 'role', '[0],[system],[role],', '角色分配跳转', '', '/role/role_assign', '6', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('164', 'role_list', 'role', '[0],[system],[role],', '角色列表', '', '/role/list', '7', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('165', 'to_assign_role', 'mgr', '[0],[system],[mgr],', '分配角色跳转', '', '/mgr/role_assign', '8', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('166', 'to_user_edit', 'mgr', '[0],[system],[mgr],', '编辑用户跳转', '', '/mgr/user_edit', '9', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('167', 'mgr_list', 'mgr', '[0],[system],[mgr],', '用户列表', '', '/mgr/list', '10', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('168', 'easycode', '0', '[0],', '代码生成', 'fa-film', '/', '1', '1', '1', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('169', 'dbinfo_list', 'easycode', '[0],[easycode],', '数据库管理', '', '/dbinfo', '1', '2', '1', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('170', 'dbinfo_add', 'dbinfo_list', '[0],[easycode],[dbinfo_list],', '数据库新增', '', '/dbinfo/add', '1', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('171', 'dbinfo_update', 'dbinfo_list', '[0],[easycode],[dbinfo_list],', '数据库编辑', '', '/dbinfo/update', '2', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('172', 'dbinfo_delete', 'dbinfo_list', '[0],[easycode],[dbinfo_list],', '数据库删除', '', '/dbinfo/delete', '3', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('173', 'tableinfo_list', 'easycode', '[0],[easycode],', '表管理', '', '/tableinfo', '2', '2', '1', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('174', 'tableinfo_add', 'tableinfo_list', '[0],[easycode],[tableinfo_list],', '表新增', '', '/tableinfo/add', '1', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('175', 'tableinfo_update', 'tableinfo_list', '[0],[easycode],[tableinfo_list],', '表编辑', '', '/tableinfo/update', '2', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('176', 'tableinfo_delete', 'tableinfo_list', '[0],[easycode],[tableinfo_list],', '表删除', '', '/tableinfo/delete', '3', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('181', 'template_list', 'easycode', '[0],[easycode],', '模板管理', '', '/template', '3', '2', '1', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('182', 'template_add', 'template_list', '[0],[easycode],[template_list],', '模板新增', '', '/template/add', '1', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('183', 'template_update', 'template_list', '[0],[easycode],[template_list],', '模板编辑', '', '/template/update', '2', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('184', 'template_delete', 'template_list', '[0],[easycode],[template_list],', '模板删除', '', '/template/delete', '3', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('185', 'templateshare_list', 'easycode', '[0],[easycode],', '分享管理', '', '/templateshare', '4', '2', '1', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('186', 'templateshare_add', 'templateshare_list', '[0],[easycode],[templateshare_list],', '分享新增', '', '/templateshare/add', '1', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('187', 'templateshare_update', 'templateshare_list', '[0],[easycode],[templateshare_list],', '分享编辑', '', '/templateshare/update', '2', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('188', 'templateshare_delete', 'templateshare_list', '[0],[easycode],[templateshare_list],', '分享删除', '', '/templateshare/delete', '3', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('189', 'templategroup_list', 'easycode', '[0],[easycode],', '模板组管理', '', '/templategroup', '5', '2', '1', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('190', 'templategroup_add', 'templategroup_list', '[0],[easycode],[templategroup_list],', '模板组新增', '', '/templategroup/add', '1', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('191', 'templategroup_update', 'templategroup_list', '[0],[easycode],[templategroup_list],', '模板组编辑', '', '/templategroup/update', '2', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('192', 'templategroup_delete', 'templategroup_list', '[0],[easycode],[templategroup_list],', '模板组删除', '', '/templategroup/delete', '3', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('193', 'genparam_list', 'easycode', '[0],[easycode],', '参数管理', '', '/genparam', '6', '2', '1', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('194', 'genparam_add', 'genparam_list', '[0],[easycode],[genparam_list],', '参数新增', '', '/genparam/add', '1', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('195', 'genparam_update', 'genparam_list', '[0],[easycode],[genparam_list],', '参数编辑', '', '/genparam/update', '2', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('196', 'genparam_delete', 'genparam_list', '[0],[easycode],[genparam_list],', '参数删除', '', '/genparam/delete', '3', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('197', 'code_gen', 'easycode', '[0],[easycode],', '代码生成', '', '/code', '8', '2', '1', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('198', 'tableinfo_dbimport', 'tableinfo_list', '[0],[easycode],[tableinfo_list],', 'DB导入', '', '/tableinfo/dbimport', '4', '3', '0', null, '1', null);
INSERT INTO `t_system_menu` VALUES ('199', 'tableinfo_sqlimport', 'tableinfo_list', '[0],[easycode],[tableinfo_list],', 'SQL导出', '', '/tableinfo/sqlimport', '5', '3', '0', null, '1', null);

-- ----------------------------
-- Table structure for t_system_notice
-- ----------------------------
DROP TABLE IF EXISTS `t_system_notice`;
CREATE TABLE `t_system_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `type` int(11) DEFAULT NULL COMMENT '类型',
  `content` text COMMENT '内容',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `creater` int(11) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='通知表';

-- ----------------------------
-- Records of t_system_notice
-- ----------------------------
INSERT INTO `t_system_notice` VALUES ('6', '世界', '10', 'java 的代码生成器,根据模板配置,简单生成java代码', '2017-01-11 08:53:20', '1');
INSERT INTO `t_system_notice` VALUES ('8', '你好', null, '你好,新的一天,新的开始', '2017-05-10 19:28:57', '1');
INSERT INTO `t_system_notice` VALUES ('9', '注意', null, '测试数据请不要删除,谢谢大家', null, null);

-- ----------------------------
-- Table structure for t_system_operation_log
-- ----------------------------
DROP TABLE IF EXISTS `t_system_operation_log`;
CREATE TABLE `t_system_operation_log` (
  `id` int(65) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `logtype` varchar(255) DEFAULT NULL COMMENT '日志类型',
  `logname` varchar(255) DEFAULT NULL COMMENT '日志名称',
  `userid` int(65) DEFAULT NULL COMMENT '用户id',
  `classname` varchar(255) DEFAULT NULL COMMENT '类名称',
  `method` text COMMENT '方法名称',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `succeed` varchar(255) DEFAULT NULL COMMENT '是否成功',
  `message` text COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=917 DEFAULT CHARSET=utf8 COMMENT='操作日志';

-- ----------------------------
-- Records of t_system_operation_log
-- ----------------------------

-- ----------------------------
-- Table structure for t_system_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_system_relation`;
CREATE TABLE `t_system_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menuid` int(11) DEFAULT NULL COMMENT '菜单id',
  `roleid` int(11) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4235 DEFAULT CHARSET=utf8 COMMENT='角色和菜单关联表';

-- ----------------------------
-- Records of t_system_relation
-- ----------------------------
INSERT INTO `t_system_relation` VALUES ('3377', '105', '5');
INSERT INTO `t_system_relation` VALUES ('3378', '106', '5');
INSERT INTO `t_system_relation` VALUES ('3379', '107', '5');
INSERT INTO `t_system_relation` VALUES ('3380', '108', '5');
INSERT INTO `t_system_relation` VALUES ('3381', '109', '5');
INSERT INTO `t_system_relation` VALUES ('3382', '110', '5');
INSERT INTO `t_system_relation` VALUES ('3383', '111', '5');
INSERT INTO `t_system_relation` VALUES ('3384', '112', '5');
INSERT INTO `t_system_relation` VALUES ('3385', '113', '5');
INSERT INTO `t_system_relation` VALUES ('3386', '114', '5');
INSERT INTO `t_system_relation` VALUES ('3387', '115', '5');
INSERT INTO `t_system_relation` VALUES ('3388', '116', '5');
INSERT INTO `t_system_relation` VALUES ('3389', '117', '5');
INSERT INTO `t_system_relation` VALUES ('3390', '118', '5');
INSERT INTO `t_system_relation` VALUES ('3391', '119', '5');
INSERT INTO `t_system_relation` VALUES ('3392', '120', '5');
INSERT INTO `t_system_relation` VALUES ('3393', '121', '5');
INSERT INTO `t_system_relation` VALUES ('3394', '122', '5');
INSERT INTO `t_system_relation` VALUES ('3395', '150', '5');
INSERT INTO `t_system_relation` VALUES ('3396', '151', '5');
INSERT INTO `t_system_relation` VALUES ('4048', '105', '6');
INSERT INTO `t_system_relation` VALUES ('4049', '132', '6');
INSERT INTO `t_system_relation` VALUES ('4050', '138', '6');
INSERT INTO `t_system_relation` VALUES ('4051', '139', '6');
INSERT INTO `t_system_relation` VALUES ('4052', '140', '6');
INSERT INTO `t_system_relation` VALUES ('4053', '155', '6');
INSERT INTO `t_system_relation` VALUES ('4054', '156', '6');
INSERT INTO `t_system_relation` VALUES ('4055', '157', '6');
INSERT INTO `t_system_relation` VALUES ('4056', '168', '6');
INSERT INTO `t_system_relation` VALUES ('4057', '169', '6');
INSERT INTO `t_system_relation` VALUES ('4058', '170', '6');
INSERT INTO `t_system_relation` VALUES ('4059', '171', '6');
INSERT INTO `t_system_relation` VALUES ('4060', '172', '6');
INSERT INTO `t_system_relation` VALUES ('4061', '181', '6');
INSERT INTO `t_system_relation` VALUES ('4062', '182', '6');
INSERT INTO `t_system_relation` VALUES ('4063', '183', '6');
INSERT INTO `t_system_relation` VALUES ('4064', '184', '6');
INSERT INTO `t_system_relation` VALUES ('4065', '189', '6');
INSERT INTO `t_system_relation` VALUES ('4066', '190', '6');
INSERT INTO `t_system_relation` VALUES ('4067', '191', '6');
INSERT INTO `t_system_relation` VALUES ('4068', '192', '6');
INSERT INTO `t_system_relation` VALUES ('4069', '193', '6');
INSERT INTO `t_system_relation` VALUES ('4070', '194', '6');
INSERT INTO `t_system_relation` VALUES ('4071', '195', '6');
INSERT INTO `t_system_relation` VALUES ('4072', '196', '6');
INSERT INTO `t_system_relation` VALUES ('4073', '197', '6');
INSERT INTO `t_system_relation` VALUES ('4154', '105', '1');
INSERT INTO `t_system_relation` VALUES ('4155', '106', '1');
INSERT INTO `t_system_relation` VALUES ('4156', '107', '1');
INSERT INTO `t_system_relation` VALUES ('4157', '108', '1');
INSERT INTO `t_system_relation` VALUES ('4158', '109', '1');
INSERT INTO `t_system_relation` VALUES ('4159', '110', '1');
INSERT INTO `t_system_relation` VALUES ('4160', '111', '1');
INSERT INTO `t_system_relation` VALUES ('4161', '112', '1');
INSERT INTO `t_system_relation` VALUES ('4162', '113', '1');
INSERT INTO `t_system_relation` VALUES ('4163', '165', '1');
INSERT INTO `t_system_relation` VALUES ('4164', '166', '1');
INSERT INTO `t_system_relation` VALUES ('4165', '167', '1');
INSERT INTO `t_system_relation` VALUES ('4166', '114', '1');
INSERT INTO `t_system_relation` VALUES ('4167', '115', '1');
INSERT INTO `t_system_relation` VALUES ('4168', '116', '1');
INSERT INTO `t_system_relation` VALUES ('4169', '117', '1');
INSERT INTO `t_system_relation` VALUES ('4170', '118', '1');
INSERT INTO `t_system_relation` VALUES ('4171', '162', '1');
INSERT INTO `t_system_relation` VALUES ('4172', '163', '1');
INSERT INTO `t_system_relation` VALUES ('4173', '164', '1');
INSERT INTO `t_system_relation` VALUES ('4174', '119', '1');
INSERT INTO `t_system_relation` VALUES ('4175', '120', '1');
INSERT INTO `t_system_relation` VALUES ('4176', '121', '1');
INSERT INTO `t_system_relation` VALUES ('4177', '122', '1');
INSERT INTO `t_system_relation` VALUES ('4178', '150', '1');
INSERT INTO `t_system_relation` VALUES ('4179', '151', '1');
INSERT INTO `t_system_relation` VALUES ('4180', '128', '1');
INSERT INTO `t_system_relation` VALUES ('4181', '134', '1');
INSERT INTO `t_system_relation` VALUES ('4182', '158', '1');
INSERT INTO `t_system_relation` VALUES ('4183', '159', '1');
INSERT INTO `t_system_relation` VALUES ('4184', '130', '1');
INSERT INTO `t_system_relation` VALUES ('4185', '131', '1');
INSERT INTO `t_system_relation` VALUES ('4186', '135', '1');
INSERT INTO `t_system_relation` VALUES ('4187', '136', '1');
INSERT INTO `t_system_relation` VALUES ('4188', '137', '1');
INSERT INTO `t_system_relation` VALUES ('4189', '152', '1');
INSERT INTO `t_system_relation` VALUES ('4190', '153', '1');
INSERT INTO `t_system_relation` VALUES ('4191', '154', '1');
INSERT INTO `t_system_relation` VALUES ('4192', '132', '1');
INSERT INTO `t_system_relation` VALUES ('4193', '138', '1');
INSERT INTO `t_system_relation` VALUES ('4194', '139', '1');
INSERT INTO `t_system_relation` VALUES ('4195', '140', '1');
INSERT INTO `t_system_relation` VALUES ('4196', '155', '1');
INSERT INTO `t_system_relation` VALUES ('4197', '156', '1');
INSERT INTO `t_system_relation` VALUES ('4198', '157', '1');
INSERT INTO `t_system_relation` VALUES ('4199', '133', '1');
INSERT INTO `t_system_relation` VALUES ('4200', '160', '1');
INSERT INTO `t_system_relation` VALUES ('4201', '161', '1');
INSERT INTO `t_system_relation` VALUES ('4202', '141', '1');
INSERT INTO `t_system_relation` VALUES ('4203', '142', '1');
INSERT INTO `t_system_relation` VALUES ('4204', '143', '1');
INSERT INTO `t_system_relation` VALUES ('4205', '144', '1');
INSERT INTO `t_system_relation` VALUES ('4206', '145', '1');
INSERT INTO `t_system_relation` VALUES ('4207', '168', '1');
INSERT INTO `t_system_relation` VALUES ('4208', '169', '1');
INSERT INTO `t_system_relation` VALUES ('4209', '170', '1');
INSERT INTO `t_system_relation` VALUES ('4210', '171', '1');
INSERT INTO `t_system_relation` VALUES ('4211', '172', '1');
INSERT INTO `t_system_relation` VALUES ('4212', '173', '1');
INSERT INTO `t_system_relation` VALUES ('4213', '174', '1');
INSERT INTO `t_system_relation` VALUES ('4214', '175', '1');
INSERT INTO `t_system_relation` VALUES ('4215', '176', '1');
INSERT INTO `t_system_relation` VALUES ('4216', '198', '1');
INSERT INTO `t_system_relation` VALUES ('4217', '199', '1');
INSERT INTO `t_system_relation` VALUES ('4218', '181', '1');
INSERT INTO `t_system_relation` VALUES ('4219', '182', '1');
INSERT INTO `t_system_relation` VALUES ('4220', '183', '1');
INSERT INTO `t_system_relation` VALUES ('4221', '184', '1');
INSERT INTO `t_system_relation` VALUES ('4222', '185', '1');
INSERT INTO `t_system_relation` VALUES ('4223', '186', '1');
INSERT INTO `t_system_relation` VALUES ('4224', '187', '1');
INSERT INTO `t_system_relation` VALUES ('4225', '188', '1');
INSERT INTO `t_system_relation` VALUES ('4226', '189', '1');
INSERT INTO `t_system_relation` VALUES ('4227', '190', '1');
INSERT INTO `t_system_relation` VALUES ('4228', '191', '1');
INSERT INTO `t_system_relation` VALUES ('4229', '192', '1');
INSERT INTO `t_system_relation` VALUES ('4230', '193', '1');
INSERT INTO `t_system_relation` VALUES ('4231', '194', '1');
INSERT INTO `t_system_relation` VALUES ('4232', '195', '1');
INSERT INTO `t_system_relation` VALUES ('4233', '196', '1');
INSERT INTO `t_system_relation` VALUES ('4234', '197', '1');

-- ----------------------------
-- Table structure for t_system_role
-- ----------------------------
DROP TABLE IF EXISTS `t_system_role`;
CREATE TABLE `t_system_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `num` int(11) DEFAULT NULL COMMENT '序号',
  `pid` int(11) DEFAULT NULL COMMENT '父角色id',
  `name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `deptid` int(11) DEFAULT NULL COMMENT '部门名称',
  `tips` varchar(255) DEFAULT NULL COMMENT '提示',
  `version` int(11) DEFAULT NULL COMMENT '保留字段(暂时没用）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of t_system_role
-- ----------------------------
INSERT INTO `t_system_role` VALUES ('1', '1', '0', '超级管理员', '24', 'administrator', '1');
INSERT INTO `t_system_role` VALUES ('5', '2', '1', '临时', '26', 'temp', null);
INSERT INTO `t_system_role` VALUES ('6', '2', '1', '客户', '26', 'user', null);

-- ----------------------------
-- Table structure for t_system_user
-- ----------------------------
DROP TABLE IF EXISTS `t_system_user`;
CREATE TABLE `t_system_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `account` varchar(45) DEFAULT NULL COMMENT '账号',
  `password` varchar(45) DEFAULT NULL COMMENT '密码',
  `salt` varchar(45) DEFAULT NULL COMMENT 'md5密码盐',
  `name` varchar(45) DEFAULT NULL COMMENT '名字',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `sex` int(11) DEFAULT NULL COMMENT '性别（1：男 2：女）',
  `email` varchar(45) DEFAULT NULL COMMENT '电子邮件',
  `phone` varchar(45) DEFAULT NULL COMMENT '电话',
  `roleid` varchar(255) DEFAULT NULL COMMENT '角色id',
  `deptid` int(11) DEFAULT NULL COMMENT '部门id',
  `status` int(11) DEFAULT NULL COMMENT '状态(1：启用  2：冻结  3：删除）',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `version` int(11) DEFAULT NULL COMMENT '保留字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8 COMMENT='管理员表';

-- ----------------------------
-- Records of t_system_user
-- ----------------------------
INSERT INTO `t_system_user` VALUES ('1', '786eec35-44b9-4921-b54d-23d0f6afadd0.jpg', 'admin', 'ecfadcde9305f8891bcfe5a1e28c253e', '8pgby', 'Lemur', '2017-05-05 00:00:00', '2', 'sn93@qq.com', '18200000000', '1', '27', '1', '2016-01-29 08:49:53', '25');
INSERT INTO `t_system_user` VALUES ('76', null, '15563766882', '3ff0a7e5f4e7b6c33bdc4b42ac8c4d20', '2xmvf', '15563766882', '2017-09-14 17:13:54', '1', null, null, '6', null, '1', '2017-09-14 17:13:54', null);
INSERT INTO `t_system_user` VALUES ('77', null, '13112345678', '4614e94ba9936411d270c71a93a6d666', '6aklv', '测试', null, null, '', '', null, '25', '1', '2017-09-15 11:00:25', null);
INSERT INTO `t_system_user` VALUES ('78', null, '13560220977', 'b4f109d8c45d3b94d8e255cf0586b93d', 'sp13x', '13560220977', '2017-10-06 13:56:50', '1', null, null, '6', null, '1', '2017-10-06 13:56:50', null);
INSERT INTO `t_system_user` VALUES ('79', null, '13555707715', 'c80a9f9759ee4ad520b8657c77dcc61a', 'axf5b', '13555707715', '2017-10-24 15:49:04', '1', null, null, '6', null, '1', '2017-10-24 15:49:04', null);

-- ----------------------------
-- Table structure for test_table
-- ----------------------------
DROP TABLE IF EXISTS `test_table`;
CREATE TABLE `test_table` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) DEFAULT NULL COMMENT '用户ID',
  `name` varchar(10) NOT NULL COMMENT '组名称',
  `desc` varchar(400) DEFAULT NULL COMMENT '描述',
  `CRT_USER_ID` varchar(16) DEFAULT NULL COMMENT '创建人',
  `CRT_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `MDF_USER_ID` varchar(16) DEFAULT NULL COMMENT '修改人',
  `MDF_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='测试对象';

-- ----------------------------
-- Records of test_table
-- ----------------------------
INSERT INTO `test_table` VALUES ('1', '0', 'GUNS', 'guns脚手架模板 脚手架地址:http://git.oschina.net/naan1993/guns', '1', '2017-09-12 13:58:24', '1', '2017-09-12 14:04:20');
INSERT INTO `test_table` VALUES ('3', '0', '通用', '通用,默认组', '1', '2017-09-12 14:05:13', null, null);
INSERT INTO `test_table` VALUES ('4', '1', '我的组', '测试', '1', '2017-09-12 14:05:48', null, null);
