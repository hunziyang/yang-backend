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

 Date: 11/06/2023 11:38:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for PERMISSION
-- ----------------------------
DROP TABLE IF EXISTS `PERMISSION`;
CREATE TABLE `PERMISSION`  (
  `ID` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `CODE` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '编码',
  `PERMISSION_CLASSIFICATION_ID` bigint NOT NULL COMMENT '权限分类ID',
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
  UNIQUE INDEX `UNIQUE_CODE`(`CODE` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '权限' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of PERMISSION
-- ----------------------------
INSERT INTO `PERMISSION` VALUES (1, '权限查询', 'permission:select', 1, NULL, 0, 1, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `PERMISSION` VALUES (2, '权限分类查询', 'permissionClassification:select', 1, NULL, 0, 1, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `PERMISSION` VALUES (3, '角色查询', 'role:select', 2, NULL, 0, 1, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `PERMISSION` VALUES (4, '角色插入', 'role:insert', 2, NULL, 0, 1, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `PERMISSION` VALUES (5, '角色更新', 'role:update', 2, NULL, 0, 1, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `PERMISSION` VALUES (6, '角色删除', 'role:delete', 2, NULL, 0, 1, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `PERMISSION` VALUES (7, '角色权限查询', 'rolePermission:select', 3, NULL, 0, 1, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `PERMISSION` VALUES (8, '角色权限删除', 'rolePermission:delete', 3, NULL, 0, 1, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `PERMISSION` VALUES (9, '角色权限插入', 'rolePermission:insert', 3, NULL, 0, 1, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `PERMISSION` VALUES (10, '用户查询', 'user:select', 4, NULL, 0, 1, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `PERMISSION` VALUES (11, '用户权限查询', 'userPermission:select', 5, NULL, 0, 1, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `PERMISSION` VALUES (12, '用户权限创建', 'userPermission:insert', 5, NULL, 0, 1, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `PERMISSION` VALUES (13, '用户权限删除', 'userPermission:delete', 5, NULL, 0, 1, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `PERMISSION` VALUES (14, '用户角色查询', 'userRole:select', 6, NULL, 0, 1, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `PERMISSION` VALUES (15, '用户角色增加', 'userRole:insert', 6, NULL, 0, 1, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `PERMISSION` VALUES (16, '用户角色删除', 'userRole:delete', 6, NULL, 0, 1, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `PERMISSION` VALUES (17, '用户更新', 'user:update', 4, NULL, 0, 1, NULL, NULL, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
