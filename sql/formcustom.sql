-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: formcustom
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `approval_logs`
--

DROP TABLE IF EXISTS `approval_logs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `approval_logs` (
  `log_id` int NOT NULL AUTO_INCREMENT,
  `form_id` varchar(15) DEFAULT NULL,
  `flow_id` int DEFAULT NULL,
  `action` varchar(50) DEFAULT NULL,
  `staff_code` varchar(20) DEFAULT NULL,
  `action_date` datetime DEFAULT NULL,
  `details` text,
  PRIMARY KEY (`log_id`),
  KEY `flow_id` (`flow_id`),
  KEY `approval_logs_deviceform_form_id_fk` (`form_id`),
  CONSTRAINT `approval_logs_deviceform_form_id_fk` FOREIGN KEY (`form_id`) REFERENCES `deviceform` (`form_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `approval_logs`
--

LOCK TABLES `approval_logs` WRITE;
/*!40000 ALTER TABLE `approval_logs` DISABLE KEYS */;
/*!40000 ALTER TABLE `approval_logs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `default_approval_flow`
--

DROP TABLE IF EXISTS `default_approval_flow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `default_approval_flow` (
  `flow_id` int NOT NULL AUTO_INCREMENT,
  `form_type` varchar(50) DEFAULT NULL,
  `approval_order` int DEFAULT NULL,
  `default_staff_code` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`flow_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `default_approval_flow`
--

LOCK TABLES `default_approval_flow` WRITE;
/*!40000 ALTER TABLE `default_approval_flow` DISABLE KEYS */;
INSERT INTO `default_approval_flow` VALUES (1,'device',1,'FIN001'),(2,'device',2,'FIN002'),(3,'device',3,'FIN003');
/*!40000 ALTER TABLE `default_approval_flow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `device_form_content`
--

DROP TABLE IF EXISTS `device_form_content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `device_form_content` (
  `id` int NOT NULL AUTO_INCREMENT,
  `form_id` varchar(10) DEFAULT NULL,
  `applicant` varchar(255) DEFAULT NULL,
  `purchase_date` date DEFAULT NULL,
  `purchase_no` varchar(50) DEFAULT NULL,
  `purchase_dept` varchar(100) DEFAULT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `vendor_no` varchar(50) DEFAULT NULL,
  `remarks` text,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `device_form_content_deviceform_form_id_fk` (`form_id`),
  CONSTRAINT `device_form_content_deviceform_form_id_fk` FOREIGN KEY (`form_id`) REFERENCES `deviceform` (`form_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `device_form_content`
--

LOCK TABLES `device_form_content` WRITE;
/*!40000 ALTER TABLE `device_form_content` DISABLE KEYS */;
INSERT INTO `device_form_content` VALUES (1,'TlE3WkN','洪晢為','2024-09-12','41555321','資訊部','上元','4125441','444','2024-09-03 09:02:28','2024-09-03 09:02:28');
/*!40000 ALTER TABLE `device_form_content` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `device_form_items`
--

DROP TABLE IF EXISTS `device_form_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `device_form_items` (
  `item_id` int NOT NULL AUTO_INCREMENT,
  `form_id` varchar(15) DEFAULT NULL,
  `item_code` varchar(50) DEFAULT NULL,
  `item_name` varchar(255) DEFAULT NULL,
  `item_qty` int DEFAULT NULL,
  `item_price` decimal(10,2) DEFAULT NULL,
  `item_amount` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`item_id`),
  KEY `device_form_items_deviceform_form_id_fk` (`form_id`),
  CONSTRAINT `device_form_items_deviceform_form_id_fk` FOREIGN KEY (`form_id`) REFERENCES `deviceform` (`form_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `device_form_items`
--

LOCK TABLES `device_form_items` WRITE;
/*!40000 ALTER TABLE `device_form_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `device_form_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deviceform`
--

DROP TABLE IF EXISTS `deviceform`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `deviceform` (
  `form_id` varchar(15) NOT NULL,
  `submitter_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `submit_date` date DEFAULT NULL,
  `form_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `current_approval_order` int DEFAULT NULL,
  `current_approver_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`form_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deviceform`
--

LOCK TABLES `deviceform` WRITE;
/*!40000 ALTER TABLE `deviceform` DISABLE KEYS */;
INSERT INTO `deviceform` VALUES ('101','HR001','2024-08-30','EQUIPMENT DEVICE',1,'FIN001'),('TlE3WkN','HR001','2024-09-03','device',1,'FIN001');
/*!40000 ALTER TABLE `deviceform` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formapprovalflow`
--

DROP TABLE IF EXISTS `formapprovalflow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `formapprovalflow` (
  `flow_id` int NOT NULL,
  `form_id` varchar(15) DEFAULT NULL,
  `staff_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `approval_order` int DEFAULT NULL,
  `approval_status` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `approval_date` date DEFAULT NULL,
  `comments` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`flow_id`) USING BTREE,
  KEY `FormID` (`form_id`) USING BTREE,
  CONSTRAINT `formapprovalflow_deviceform_form_id_fk` FOREIGN KEY (`form_id`) REFERENCES `deviceform` (`form_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formapprovalflow`
--

LOCK TABLES `formapprovalflow` WRITE;
/*!40000 ALTER TABLE `formapprovalflow` DISABLE KEYS */;
INSERT INTO `formapprovalflow` VALUES (1,'101','FIN001',1,'Pending','2024-08-30',''),(2,'101','FIN002',2,'Pending',NULL,NULL),(3,'101','FIN003',3,'Pending','2024-08-30','Approved by Manager');
/*!40000 ALTER TABLE `formapprovalflow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organization`
--

DROP TABLE IF EXISTS `organization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `organization` (
  `org_id` int NOT NULL AUTO_INCREMENT,
  `org_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `org_code` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`org_id`) USING BTREE,
  UNIQUE KEY `OrgCode` (`org_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organization`
--

LOCK TABLES `organization` WRITE;
/*!40000 ALTER TABLE `organization` DISABLE KEYS */;
INSERT INTO `organization` VALUES (1,'財務室','FIN'),(2,'人事室','HR'),(3,'秘書室','SEC'),(4,'總務室','ADM'),(5,'教務室','ACA');
/*!40000 ALTER TABLE `organization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organization_staff`
--

DROP TABLE IF EXISTS `organization_staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `organization_staff` (
  `id` int NOT NULL AUTO_INCREMENT,
  `org_code` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `staff_code` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `org_code` (`org_code`) USING BTREE,
  KEY `staff_code` (`staff_code`) USING BTREE,
  CONSTRAINT `organization_staff_ibfk_1` FOREIGN KEY (`org_code`) REFERENCES `organization` (`org_code`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `organization_staff_ibfk_2` FOREIGN KEY (`staff_code`) REFERENCES `staff` (`staff_code`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organization_staff`
--

LOCK TABLES `organization_staff` WRITE;
/*!40000 ALTER TABLE `organization_staff` DISABLE KEYS */;
INSERT INTO `organization_staff` VALUES (1,'FIN','FIN001'),(2,'FIN','FIN002'),(3,'FIN','FIN003'),(4,'HR','HR001'),(5,'HR','HR002'),(6,'HR','HR003'),(16,'SEC','SEC001'),(17,'SEC','SEC002'),(18,'SEC','SEC003'),(19,'ADM','ADM001'),(20,'ADM','ADM002'),(21,'ADM','ADM003'),(22,'ACA','ACA001'),(23,'ACA','ACA002'),(24,'ACA','ACA003');
/*!40000 ALTER TABLE `organization_staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff` (
  `staff_id` int NOT NULL AUTO_INCREMENT,
  `staff_code` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `staff_name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `position` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`staff_id`) USING BTREE,
  UNIQUE KEY `idx_staff_code` (`staff_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (1,'FIN001','許晨曦','財務經理'),(2,'FIN002','郭雅琪','財務助理'),(3,'FIN003','魏子涵','財務專員'),(4,'HR001','王詩涵','人事專員'),(5,'HR002','邱明哲','人事主任'),(6,'HR003','方宥勝','人事秘書'),(16,'SEC001','李文哲','行政秘書'),(17,'SEC002','張曉婷','主任秘書'),(18,'SEC003','王宇涵','學務秘書'),(19,'ADM001','陳嘉宏','總務職員'),(20,'ADM002','楊佳麗','總務秘書'),(21,'ADM003','林思遠','總務主任'),(22,'ACA001','劉欣怡','教務專員'),(23,'ACA002','周俊豪','教學秘書'),(24,'ACA003','朱子文','教務處長');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-03 17:41:33
