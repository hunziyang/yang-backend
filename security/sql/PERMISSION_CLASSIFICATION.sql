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

 Date: 11/06/2023 11:39:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for PERMISSION_CLASSIFICATION
-- ----------------------------
DROP TABLE IF EXISTS `PERMISSION_CLASSIFICATION`;
CREATE TABLE `PERMISSION_CLASSIFICATION`  (
  `ID` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `NAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `DESCRIPTION` varchar(900) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `IS_DELETE` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  `REVISION` int NULL DEFAULT 1 COMMENT '乐观锁',
  `CREATED_ID` bigint NULL DEFAULT NULL COMMENT '创建人ID',
  `CREATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_ID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人ID',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`) USING BTREE,
  UNIQUE INDEX `UNIQUE_NAME`(`NAME` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '权限分类' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of PERMISSION_CLASSIFICATION
-- ----------------------------
INSERT INTO `PERMISSION_CLASSIFICATION` VALUES (1, '权限', NULL, 0, 1, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `PERMISSION_CLASSIFICATION` VALUES (2, '角色', NULL, 0, 1, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `PERMISSION_CLASSIFICATION` VALUES (3, '角色权限', NULL, 0, 1, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `PERMISSION_CLASSIFICATION` VALUES (4, '用户', NULL, 0, 1, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `PERMISSION_CLASSIFICATION` VALUES (5, '用户权限', NULL, 0, 1, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `PERMISSION_CLASSIFICATION` VALUES (6, '用户角色', NULL, 0, 1, NULL, NULL, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
