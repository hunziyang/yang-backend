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

 Date: 11/06/2023 11:39:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for USER_ROLE
-- ----------------------------
DROP TABLE IF EXISTS `USER_ROLE`;
CREATE TABLE `USER_ROLE`  (
  `ID` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `USER_ID` bigint NOT NULL COMMENT '用户ID',
  `ROLE_ID` bigint NOT NULL COMMENT '角色ID',
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
  PRIMARY KEY (`ID`) USING BTREE,
  UNIQUE INDEX `UNIQUE_USERID_ROLEID`(`USER_ID` ASC, `ROLE_ID` ASC, `UNIQUE_ID` ASC) USING BTREE,
  INDEX `USERID_ISDELETE`(`USER_ID` ASC, `IS_DELETE` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of USER_ROLE
-- ----------------------------
INSERT INTO `USER_ROLE` VALUES (1, 1, 1, 0, NULL, 0, 1, NULL, NULL, NULL, 1, 'Tommy', '2023-06-11 11:35:25');

SET FOREIGN_KEY_CHECKS = 1;
