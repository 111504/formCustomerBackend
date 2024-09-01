/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80033 (8.0.33)
 Source Host           : localhost:3306
 Source Schema         : formcustom

 Target Server Type    : MySQL
 Target Server Version : 80033 (8.0.33)
 File Encoding         : 65001

 Date: 01/09/2024 22:22:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for formapprovalflow
-- ----------------------------
DROP TABLE IF EXISTS `formapprovalflow`;
CREATE TABLE `formapprovalflow`  (
  `flow_id` int NOT NULL,
  `form_id` int NULL DEFAULT NULL,
  `staff_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `approval_order` int NULL DEFAULT NULL,
  `approval_status` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `approval_date` date NULL DEFAULT NULL,
  `comments` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`flow_id`) USING BTREE,
  INDEX `FormID`(`form_id` ASC) USING BTREE,
  CONSTRAINT `formapprovalflow_ibfk_1` FOREIGN KEY (`form_id`) REFERENCES `forms` (`form_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of formapprovalflow
-- ----------------------------
INSERT INTO `formapprovalflow` VALUES (1, 101, 'EMP2001', 1, 'Approved', '2024-08-30', 'Approved by Dept Head');
INSERT INTO `formapprovalflow` VALUES (2, 101, 'EMP2002', 2, 'Pending', NULL, NULL);
INSERT INTO `formapprovalflow` VALUES (3, 102, 'EMP2001', 1, 'Approved', '2024-08-30', 'Approved by Manager');
INSERT INTO `formapprovalflow` VALUES (4, 102, 'EMP2003', 2, 'Rejected', '2024-08-30', 'Rejected due to budget');
INSERT INTO `formapprovalflow` VALUES (5, 103, 'EMP2002', 1, 'Pending', NULL, NULL);
INSERT INTO `formapprovalflow` VALUES (6, 103, 'EMP2003', 2, 'Pending', NULL, NULL);

-- ----------------------------
-- Table structure for forms
-- ----------------------------
DROP TABLE IF EXISTS `forms`;
CREATE TABLE `forms`  (
  `form_id` int NOT NULL,
  `submitter_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `submit_date` date NULL DEFAULT NULL,
  `form_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `current_approval_order` int NULL DEFAULT NULL,
  `current_approver_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`form_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of forms
-- ----------------------------
INSERT INTO `forms` VALUES (101, 'EMP1001', '2024-08-30', 'Leave Request', 2, 'EMP2002');
INSERT INTO `forms` VALUES (102, 'EMP1002', '2024-08-30', 'Expense Report', 2, 'EMP2003');
INSERT INTO `forms` VALUES (103, 'EMP1003', '2024-08-30', 'Equipment Request', 1, 'EMP2002');

-- ----------------------------
-- Table structure for organization
-- ----------------------------
DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization`  (
  `org_id` int NOT NULL AUTO_INCREMENT,
  `org_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `org_code` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`org_id`) USING BTREE,
  UNIQUE INDEX `OrgCode`(`org_code` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of organization
-- ----------------------------
INSERT INTO `organization` VALUES (1, '財務室', 'FIN');
INSERT INTO `organization` VALUES (2, '人事室', 'HR');
INSERT INTO `organization` VALUES (3, '秘書室', 'SEC');
INSERT INTO `organization` VALUES (4, '總務室', 'ADM');
INSERT INTO `organization` VALUES (5, '教務室', 'ACA');

-- ----------------------------
-- Table structure for organization_staff
-- ----------------------------
DROP TABLE IF EXISTS `organization_staff`;
CREATE TABLE `organization_staff`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `org_code` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `staff_code` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `org_code`(`org_code` ASC) USING BTREE,
  INDEX `staff_code`(`staff_code` ASC) USING BTREE,
  CONSTRAINT `organization_staff_ibfk_1` FOREIGN KEY (`org_code`) REFERENCES `organization` (`org_code`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `organization_staff_ibfk_2` FOREIGN KEY (`staff_code`) REFERENCES `staff` (`staff_code`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of organization_staff
-- ----------------------------
INSERT INTO `organization_staff` VALUES (1, 'FIN', 'FIN001');
INSERT INTO `organization_staff` VALUES (2, 'FIN', 'FIN002');
INSERT INTO `organization_staff` VALUES (3, 'FIN', 'FIN003');
INSERT INTO `organization_staff` VALUES (4, 'HR', 'HR001');
INSERT INTO `organization_staff` VALUES (5, 'HR', 'HR002');
INSERT INTO `organization_staff` VALUES (6, 'HR', 'HR003');
INSERT INTO `organization_staff` VALUES (16, 'SEC', 'SEC001');
INSERT INTO `organization_staff` VALUES (17, 'SEC', 'SEC002');
INSERT INTO `organization_staff` VALUES (18, 'SEC', 'SEC003');
INSERT INTO `organization_staff` VALUES (19, 'ADM', 'ADM001');
INSERT INTO `organization_staff` VALUES (20, 'ADM', 'ADM002');
INSERT INTO `organization_staff` VALUES (21, 'ADM', 'ADM003');
INSERT INTO `organization_staff` VALUES (22, 'ACA', 'ACA001');
INSERT INTO `organization_staff` VALUES (23, 'ACA', 'ACA002');
INSERT INTO `organization_staff` VALUES (24, 'ACA', 'ACA003');

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff`  (
  `staff_id` int NOT NULL AUTO_INCREMENT,
  `staff_code` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `staff_name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `position` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`staff_id`) USING BTREE,
  UNIQUE INDEX `idx_staff_code`(`staff_code` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES (1, 'FIN001', '許晨曦', '財務經理');
INSERT INTO `staff` VALUES (2, 'FIN002', '郭雅琪', '財務助理');
INSERT INTO `staff` VALUES (3, 'FIN003', '魏子涵', '財務專員');
INSERT INTO `staff` VALUES (4, 'HR001', '王詩涵', '人事專員');
INSERT INTO `staff` VALUES (5, 'HR002', '邱明哲', '人事主任');
INSERT INTO `staff` VALUES (6, 'HR003', '方宥勝', '人事秘書');
INSERT INTO `staff` VALUES (16, 'SEC001', '李文哲', '行政秘書');
INSERT INTO `staff` VALUES (17, 'SEC002', '張曉婷', '主任秘書');
INSERT INTO `staff` VALUES (18, 'SEC003', '王宇涵', '學務秘書');
INSERT INTO `staff` VALUES (19, 'ADM001', '陳嘉宏', '總務職員');
INSERT INTO `staff` VALUES (20, 'ADM002', '楊佳麗', '總務秘書');
INSERT INTO `staff` VALUES (21, 'ADM003', '林思遠', '總務主任');
INSERT INTO `staff` VALUES (22, 'ACA001', '劉欣怡', '教務專員');
INSERT INTO `staff` VALUES (23, 'ACA002', '周俊豪', '教學秘書');
INSERT INTO `staff` VALUES (24, 'ACA003', '朱子文', '教務處長');

SET FOREIGN_KEY_CHECKS = 1;
