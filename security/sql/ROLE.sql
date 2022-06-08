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

 Date: 11/06/2023 11:39:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ROLE
-- ----------------------------
DROP TABLE IF EXISTS `ROLE`;
CREATE TABLE `ROLE`  (
  `ID` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色名',
  `CODE` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色编码',
  `UNIQUE_ID` bigint NOT NULL DEFAULT 0,
  `DESCRIPTION` varchar(900) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `IS_DELETE` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  `REVISION` int NULL DEFAULT 1 COMMENT '乐观锁',
  `CREATED_ID` bigint NULL DEFAULT NULL COMMENT '创建人ID',
  `CREATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_ID` bigint NULL DEFAULT NULL COMMENT '更新人ID',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`, `UNIQUE_ID`) USING BTREE,
  UNIQUE INDEX `UNIQUE_CODE`(`CODE` ASC, `UNIQUE_ID` ASC) USING BTREE,
  INDEX `NAME_CODE`(`IS_DELETE` ASC, `NAME` ASC, `CODE` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ROLE
-- ----------------------------
INSERT INTO `ROLE` VALUES (1, '管理员', 'ROLE_ADMIN', 0, NULL, 0, 1, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `ROLE` VALUES (2, '用户', 'ROLE_USER', 0, NULL, 0, 1, 1, 'Tommy', '2023-06-01 22:46:41', 1, 'Tommy', '2023-06-08 23:19:13');

SET FOREIGN_KEY_CHECKS = 1;
