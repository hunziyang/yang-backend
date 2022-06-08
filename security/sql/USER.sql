/*
 Navicat Premium Data Transfer

 Source Server         : base
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : 192.168.226.128:3306
 Source Schema         : backend-test

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 11/06/2023 11:39:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for USER
-- ----------------------------
DROP TABLE IF EXISTS `USER`;
CREATE TABLE `USER`  (
  `ID` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `USERNAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '账号',
  `UNIQUE_ID` bigint NOT NULL DEFAULT 0,
  `PASSWORD` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `SALT` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '盐值',
  `NAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `PHONE` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号',
  `NICKNAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '昵称',
  `GENDER` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别',
  `BIRTHDAY` date NULL DEFAULT NULL COMMENT '生日',
  `IS_LOCKED` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否锁定',
  `DESCRIPTION` varchar(900) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `IS_DELETE` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  `REVISION` int NULL DEFAULT 1 COMMENT '乐观锁',
  `CREATED_ID` bigint NULL DEFAULT NULL COMMENT '创建人ID',
  `CREATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_ID` bigint NULL DEFAULT NULL COMMENT '更新人ID',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`) USING BTREE,
  UNIQUE INDEX `UNIQUE_USERNAME`(`USERNAME` ASC, `UNIQUE_ID` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of USER
-- ----------------------------
INSERT INTO `USER` VALUES (1, '814230847@qq.com', 0, '$YANG$TW$ihtDeQpx4MjqzNkOYLmOD/', 'TW!GP', '王丹阳', '17806171138', 'Tommy', '1', '2022-08-04', 0, '', 0, 1, NULL, NULL, '2022-08-14 09:14:08', NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
