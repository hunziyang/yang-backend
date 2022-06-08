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

 Date: 11/06/2023 11:40:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for SHEDLOCK
-- ----------------------------
DROP TABLE IF EXISTS `SHEDLOCK`;
CREATE TABLE `SHEDLOCK`  (
  `NAME` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `LOCK_UNTIL` timestamp(3) NULL DEFAULT NULL,
  `LOCKED_AT` timestamp(3) NULL DEFAULT NULL,
  `LOCKED_BY` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`NAME`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
