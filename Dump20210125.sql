-- MySQL dump 10.13  Distrib 8.0.16, for macos10.14 (x86_64)
--
-- Host: localhost    Database: qualityspotcheck
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `base_param`
--

DROP TABLE IF EXISTS `base_param`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `base_param` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(32) NOT NULL COMMENT '参数名称',
  `type` varchar(32) NOT NULL COMMENT '参数类型',
  `unit` varchar(32) DEFAULT NULL COMMENT '参数单位',
  `status` char(1) NOT NULL DEFAULT '1' COMMENT '参数状态',
  `create_by` int DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` int DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(128) DEFAULT NULL COMMENT '备注',
  `del_flag` char(1) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='基础参数配置表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `base_param`
--

LOCK TABLES `base_param` WRITE;
/*!40000 ALTER TABLE `base_param` DISABLE KEYS */;
INSERT INTO `base_param` VALUES (2,'呼出次数','话务类型','次','1',1,'2021-01-15 14:53:07',1,'2021-01-15 14:53:07','','0'),(3,'抽检人员','抽检人员','','1',1,'2021-01-15 14:53:07',1,'2021-01-15 14:53:07','','0'),(4,'工单时效','工单类型','','1',1,'2021-01-15 14:53:07',1,'2021-01-15 14:53:07','','0'),(5,'是否超时','工单类型','','1',1,'2021-01-15 14:53:07',1,'2021-01-15 14:53:07','','0'),(6,'工单来源','工单类型','','1',1,'2021-01-15 14:53:07',1,'2021-01-15 14:53:07','','0'),(7,'工单状态','工单类型','','0',1,'2021-01-15 14:53:07',1,'2021-01-15 14:53:07','','0'),(8,'呼入次数','抽检电话','次','0',1,'2021-01-15 14:53:07',1,'2021-01-15 14:53:07','','0'),(9,'异常次数','抽检电话','次','0',1,'2021-01-15 14:53:07',1,'2021-01-15 14:53:07','','0'),(10,'拒绝次数','抽检电话','次','1',1,'2021-01-15 14:53:07',1,'2021-01-15 14:53:07','','0'),(11,'时间维度','时间段','','1',1,'2021-01-15 14:53:07',1,'2021-01-15 14:53:07','','0'),(12,'呼损率','时间段','%','1',1,'2021-01-15 14:53:07',1,'2021-01-15 14:53:07','','0'),(13,'回访率','时间段','%','1',1,'2021-01-15 14:53:07',1,'2021-01-15 14:53:07','','0'),(14,'通话时长','话务时长','秒','1',1,'2021-01-15 14:53:07',1,'2021-01-15 14:53:07','','0'),(15,'回访时长','话务时长','秒','1',1,'2021-01-15 14:53:07',1,'2021-01-15 14:53:07','','0'),(16,'回访次数','抽检电话','次','1',1,'2021-01-15 14:53:07',1,'2021-01-15 14:53:07','','0'),(17,'处理部门满意度','话务类型','','1',1,'2021-01-15 14:53:07',1,'2021-01-15 14:53:07','','0'),(18,'96166满意度','话务类型','','1',1,'2021-01-15 14:53:07',1,'2021-01-15 14:53:07','','0');
/*!40000 ALTER TABLE `base_param` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `base_project`
--

DROP TABLE IF EXISTS `base_project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `base_project` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(255) NOT NULL COMMENT '名称',
  `level` int NOT NULL COMMENT '级别，0、无级别（不扣分）1、一般，2、严重',
  `score` int NOT NULL DEFAULT '0' COMMENT '分数',
  `parent_id` int NOT NULL COMMENT '父级节点id',
  `create_by` int NOT NULL,
  `create_time` datetime NOT NULL COMMENT '创建日期',
  `update_by` int NOT NULL,
  `update_time` datetime NOT NULL,
  `remarks` varchar(128) DEFAULT NULL,
  `del_flag` char(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='基础项目配置表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `base_project`
--

LOCK TABLES `base_project` WRITE;
/*!40000 ALTER TABLE `base_project` DISABLE KEYS */;
INSERT INTO `base_project` VALUES (1,'推诿',0,0,0,1,'2021-01-19 06:45:20',1,'2021-01-19 06:45:20','','0'),(2,'急于结束通话',0,0,0,1,'2021-01-19 06:45:20',1,'2021-01-19 06:45:20','','0'),(3,'派单前',0,0,0,1,'2021-01-19 06:45:20',1,'2021-01-19 06:45:20','','0'),(4,'未安抚客户情绪',0,0,0,1,'2021-01-19 06:45:20',1,'2021-01-19 06:45:20','','0'),(5,'提供错误信息指引错误',0,0,0,1,'2021-01-19 06:45:20',1,'2021-01-19 06:45:20','','0'),(6,'预处理',0,0,0,1,'2021-01-19 06:45:20',1,'2021-01-19 06:45:20','','0'),(7,'当客户明确提出听不懂专业术语要求解释时',0,0,0,1,'2021-01-19 06:45:20',1,'2021-01-19 06:45:20','','0'),(8,'当客户需求明确时',0,0,0,1,'2021-01-19 06:45:20',1,'2021-01-19 06:45:20','','0'),(9,'使用不恰当的语言或表达方式影响服务感知',0,0,0,1,'2021-01-19 06:45:20',1,'2021-01-19 06:45:20','','0'),(10,'语速过快',0,0,0,1,'2021-01-19 06:45:20',1,'2021-01-19 06:45:20','','0'),(11,'话务员半天不出声，没有任何回应，要客户来确认是否在听',0,0,0,1,'2021-01-19 06:45:20',1,'2021-01-19 06:45:20','','0'),(12,'抢话',0,0,0,1,'2021-01-19 06:45:20',1,'2021-01-19 06:45:20','','0'),(13,'与客户交流中音量突然变大或变小',0,0,0,1,'2021-01-19 06:45:20',1,'2021-01-19 06:45:20','','0'),(14,'当客户骚扰客服时（谈到与业务无关的话题）',0,0,0,1,'2021-01-19 06:45:20',1,'2021-01-19 06:45:20','','0'),(15,'无法立即回复时',0,0,0,1,'2021-01-19 06:45:20',1,'2021-01-19 06:45:20','','0'),(16,'需要客户重复时',0,0,0,1,'2021-01-19 06:45:20',1,'2021-01-19 06:45:20','','0'),(17,'需要客户等待时',0,0,0,1,'2021-01-19 06:45:20',1,'2021-01-19 06:45:20','','0'),(18,'主动报出客户信息',0,0,0,1,'2021-01-19 06:45:20',1,'2021-01-19 06:45:20','','0'),(19,'回访',0,0,0,1,'2021-01-19 06:45:20',1,'2021-01-19 06:45:20','','0'),(20,'当客户提建议时要表示感谢',0,0,0,1,'2021-01-19 06:45:20',1,'2021-01-19 06:45:20','','0'),(21,'当无法提供准确信息和无法立即回复时',0,0,0,1,'2021-01-19 06:45:20',1,'2021-01-19 06:45:20','','0'),(22,'当询问客户信息',0,0,0,1,'2021-01-19 06:45:20',1,'2021-01-19 06:45:20','','0'),(23,'结束语',0,0,0,1,'2021-01-19 06:45:20',1,'2021-01-19 06:45:20','','0'),(24,'开头语',0,0,0,1,'2021-01-19 06:45:20',1,'2021-01-19 06:45:20','','0'),(25,'结单率',0,0,0,1,'2021-01-19 06:45:20',1,'2021-01-19 06:45:20','','0'),(26,'回访率',0,0,0,1,'2021-01-19 06:45:20',1,'2021-01-19 06:45:20','','0'),(27,'漏单',0,0,0,1,'2021-01-19 06:45:20',1,'2021-01-19 06:45:20','','0'),(28,'工单内容不完整',0,0,0,1,'2021-01-19 06:45:20',1,'2021-01-19 06:45:20','','0'),(29,'工单内容填写错误',0,0,0,1,'2021-01-19 06:45:20',1,'2021-01-19 06:45:20','','0'),(30,'投诉',0,0,0,1,'2021-01-19 06:45:20',1,'2021-01-19 06:45:20','','0'),(31,'回应客户的感谢时',0,0,0,1,'2021-01-19 06:45:20',1,'2021-01-19 06:45:20','','0'),(32,'未确认是否是集团范围服务',2,2,1,1,'2021-01-19 06:51:48',1,'2021-01-19 06:51:48','','0'),(33,'因系统直接查询不到结果的服务，需要给客户两种以上方案，征询客户意',2,2,1,1,'2021-01-19 06:51:48',1,'2021-01-19 06:51:48','','0'),(34,'如电话中断（客户先挂机的除外)',1,1,2,1,'2021-01-19 06:54:41',1,'2021-01-19 06:54:41','','0'),(35,'挂机前，应询问还有什么可以帮您？',1,1,2,1,'2021-01-19 06:54:41',1,'2021-01-19 06:54:41','','0'),(36,'需要核对客户信息、总结客户诉求、资讯类电话除外',1,1,3,1,'2021-01-19 06:57:29',1,'2021-01-19 06:57:29','','0'),(37,'如客户抱怨或急躁，未表述：很抱歉，给您带来不便、我能理解你的心情、我能感受得到，请放心、请您不要着急',1,1,4,1,'2021-01-19 06:59:12',1,'2021-01-19 06:59:12','','0'),(38,'二次来电中明确表示由于话务员指引错误再次询问',1,1,5,1,'2021-01-19 06:59:55',1,'2021-01-19 06:59:55','','0'),(39,'未根据用户诉求进行完整预处理步骤解答或提问',1,1,6,1,'2021-01-19 07:00:50',1,'2021-01-19 07:00:50','','0'),(40,'与客户交流中尽可能用通俗易懂的话描述，少用专业话术',1,1,7,1,'2021-01-19 07:01:27',1,'2021-01-19 07:01:27','','0'),(41,'因未认真倾听，出现重复询问客户已明确的问题两次，或出现答非所问、未正面回答客户问题（业务范围内）反问',1,1,8,1,'2021-01-19 07:02:57',1,'2021-01-19 07:02:57','','0'),(42,'辱骂',2,2,9,1,'2021-01-19 07:03:39',1,'2021-01-19 07:03:39','','0'),(43,'顶撞',2,2,9,1,'2021-01-19 07:03:39',1,'2021-01-19 07:03:39','','0'),(44,'训斥',2,2,9,1,'2021-01-19 07:03:39',1,'2021-01-19 07:03:39','','0'),(45,'质问',2,2,9,1,'2021-01-19 07:03:39',1,'2021-01-19 07:03:39','','0'),(46,'反问',2,2,9,1,'2021-01-19 07:03:39',1,'2021-01-19 07:03:39','','0'),(47,'未根据客户的情况，如老人、文化程度低、听不懂普通话的客户要求放慢语速等',1,1,10,1,'2021-01-19 07:05:23',1,'2021-01-19 07:05:23','','0'),(48,'倾听过程中，要有回应的语气助词',1,1,11,1,'2021-01-19 07:07:35',1,'2021-01-19 07:07:35','','0'),(49,'客户说话必须让客户先说。如需打断客户，应用标准规范用于：先生/女士,不好意思打断一下您。。。',1,1,12,1,'2021-01-19 07:11:04',1,'2021-01-19 07:11:04','','0'),(50,'因话务员资深情绪提高分贝，带来不良的服务感知。',1,1,13,1,'2021-01-19 07:12:06',1,'2021-01-19 07:12:06','','0'),(51,'未说：先生/女士，请问您有本集团业务需要咨询吗？（等待客户回答）如果没有，我这边要挂机了，祝您生活愉快,再见!（引导一次无效之后可按照特殊来电处理）',1,1,14,1,'2021-01-19 07:14:50',1,'2021-01-19 07:14:50','','0'),(52,'未说：先生/女士，很抱歉，您的问题需要进一步确认核实，我们会在今天与您联系',1,1,15,1,'2021-01-19 07:16:12',1,'2021-01-19 07:16:12','','0'),(53,'未说：很抱歉，没听清楚您的问题，请您再重复一遍好吗？',1,1,16,1,'2021-01-19 07:17:53',1,'2021-01-19 07:17:53','','0'),(54,'未告知用户：请稍等，现在帮你查询，等待超过30秒未说：您好，先生/女士，感谢您耐心的等待，如特殊情况需离开坐席，要征询客户意见在线等待还是稍后回电，告知等待的时间会比较久',1,1,17,1,'2021-01-19 07:20:17',1,'2021-01-19 07:20:17','','0'),(55,'当客户报完信息，要核对户名和地址：请您报下户名或地址；（第一次来点不能主动报出客户信息，要核对客户信息，统一电话多次来电除外）',1,1,18,1,'2021-01-19 07:22:39',1,'2021-01-19 07:22:39','','0'),(56,'未表明自己的身份，如：您好，我是XXX集团客服热线XX工号话务员',1,1,19,1,'2021-01-19 07:26:41',1,'2021-01-19 07:26:41','','0'),(57,'未询问两个满意度（请问您对处理结果是否满意、请问您对工作人员的服务态度是否满意）',1,1,19,1,'2021-01-19 07:26:41',1,'2021-01-19 07:26:41','','0'),(58,'回访结果不一致',1,1,19,1,'2021-01-19 07:26:41',1,'2021-01-19 07:26:41','','0'),(59,'非常感谢您提供的宝贵意见，我们会向公司反馈，感谢您的支持等相同意思话术',1,1,20,1,'2021-01-19 07:28:01',1,'2021-01-19 07:28:01','','0'),(60,'要使用：对不起、很抱歉、不好意思等',1,1,21,1,'2021-01-19 07:28:39',1,'2021-01-19 07:28:39','','0'),(61,'要用：请、请问',1,1,22,1,'2021-01-19 07:29:03',1,'2021-01-19 07:29:03','','0'),(62,'要用，请您对我的服务进行评价，感谢您的来电/祝您生活愉快，再见',1,1,23,1,'2021-01-19 07:29:57',1,'2021-01-19 07:29:57','','0'),(63,'问候语接入不及时，超过三秒应答',1,1,24,1,'2021-01-19 07:33:53',1,'2021-01-19 07:33:53','','0'),(64,'您好，XXX为您服务，请讲',1,1,24,1,'2021-01-19 07:33:53',1,'2021-01-19 07:33:53','','0'),(65,'未在次月3日之前完成上月指标',2,2,25,1,'2021-01-19 07:37:49',1,'2021-01-19 07:37:49','','0'),(66,'未在次月3日之前完成上月指标',2,2,26,1,'2021-01-19 07:39:32',1,'2021-01-19 07:39:32','','0'),(67,'在质检通过语音反查未按要求行程记录工单',2,2,27,1,'2021-01-19 07:42:02',1,'2021-01-19 07:42:02','','0'),(68,'姓名',1,1,28,1,'2021-01-19 07:43:20',1,'2021-01-19 07:43:20','','0'),(69,'性别',1,1,28,1,'2021-01-19 07:43:20',1,'2021-01-19 07:43:20','','0'),(70,'地址',1,1,28,1,'2021-01-19 07:43:20',1,'2021-01-19 07:43:20','','0'),(71,'客户诉求',1,1,28,1,'2021-01-19 07:43:20',1,'2021-01-19 07:43:20','','0'),(72,'填写预处理结果',1,1,28,1,'2021-01-19 07:43:20',1,'2021-01-19 07:43:20','','0'),(73,'客户情绪',1,1,28,1,'2021-01-19 07:43:20',1,'2021-01-19 07:43:20','','0'),(74,'错别字',1,1,29,1,'2021-01-19 07:45:00',1,'2021-01-19 07:45:00','','0'),(75,'电话号码',1,1,29,1,'2021-01-19 07:45:00',1,'2021-01-19 07:45:00','','0'),(76,'姓氏',1,1,29,1,'2021-01-19 07:45:00',1,'2021-01-19 07:45:00','','0'),(77,'性别',1,1,29,1,'2021-01-19 07:45:00',1,'2021-01-19 07:45:00','','0'),(78,'派错工单类型',1,1,29,1,'2021-01-19 07:45:00',1,'2021-01-19 07:45:00','','0'),(79,'派错处理部门',1,1,29,1,'2021-01-19 07:45:00',1,'2021-01-19 07:45:00','','0'),(80,'超出服务范围派单',1,1,29,1,'2021-01-19 07:45:00',1,'2021-01-19 07:45:00','','0'),(81,'话务员引导用户投诉',2,2,30,1,'2021-01-19 07:45:58',1,'2021-01-19 07:45:58','','0'),(82,'话务员的有责投诉',2,2,30,1,'2021-01-19 07:45:58',1,'2021-01-19 07:45:58','','0'),(83,'不客气、不用谢、这是我们应该做的等同意思话术',1,1,31,1,'2021-01-19 07:46:41',1,'2021-01-19 07:46:41','','0');
/*!40000 ALTER TABLE `base_project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SYS_PERMISSION`
--

DROP TABLE IF EXISTS `SYS_PERMISSION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `SYS_PERMISSION` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parent_id` int NOT NULL COMMENT '父级菜单id',
  `title` varchar(32) NOT NULL COMMENT '菜单路由标题',
  `permission_index` varchar(32) NOT NULL COMMENT '菜单路由索引',
  `icon` varchar(32) DEFAULT NULL COMMENT '图标',
  `res_type` varchar(45) NOT NULL,
  `create_by` int NOT NULL,
  `create_time` datetime NOT NULL,
  `update_by` int NOT NULL,
  `update_time` datetime NOT NULL,
  `remarks` varchar(128) DEFAULT NULL COMMENT '备注',
  `del_flag` char(1) NOT NULL,
  `sort` int DEFAULT NULL COMMENT '排序值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='菜单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SYS_PERMISSION`
--

LOCK TABLES `SYS_PERMISSION` WRITE;
/*!40000 ALTER TABLE `SYS_PERMISSION` DISABLE KEYS */;
INSERT INTO `SYS_PERMISSION` VALUES (1,0,'基础参数','1','el-icon-lx-cascades','MENU',1,'2021-01-10 14:18:32',1,'2021-01-10 14:18:32','','0',1),(3,0,'抽检列表','3','el-icon-lx-sort','MENU',1,'2021-01-10 14:32:52',1,'2021-01-10 14:32:52','','0',3),(4,0,'质检审核','4','el-icon-lx-servicefill','MENU',1,'2021-01-10 14:35:14',1,'2021-01-10 14:35:14','','0',4),(5,0,'质检报告','5','el-icon-lx-vipcard','MENU',1,'2021-01-10 14:35:41',1,'2021-01-10 14:35:41','','0',5),(6,1,'基础参数配置','baseParams','','MENU',1,'2021-01-10 14:36:39',1,'2021-01-10 14:36:39','','0',NULL),(7,1,'基础项目','baseProject','','MENU',1,'2021-01-10 14:37:00',1,'2021-01-10 14:37:00','','0',NULL),(8,3,'抽检列表','spotCheckList','','MENU',1,'2021-01-10 14:37:38',1,'2021-01-10 14:37:38','','0',NULL),(9,3,'不合格工单','notPassOrder','','MENU',1,'2021-01-10 14:38:01',1,'2021-01-10 14:38:01','','0',NULL),(10,3,'复议质检','complainCheck','','MENU',1,'2021-01-10 14:38:16',1,'2021-01-10 14:38:16','','0',NULL),(11,4,'复议工单审核','complainReview','','MENU',1,'2021-01-10 14:39:39',1,'2021-01-10 14:39:39','','0',NULL),(12,5,'质检统计报表','spotcheckStatisticsReport','','MENU',1,'2021-01-10 14:43:28',1,'2021-01-10 14:43:28','','0',NULL),(13,5,'质检报表','spotcheckTemplateReportsh','','MENU',1,'2021-01-10 14:43:50',1,'2021-01-10 14:43:50','','0',NULL),(14,0,'抽检模板管理','6','el-icon-document','MENU',1,'2021-01-15 10:45:43',1,'2021-01-15 10:45:43','','0',2),(15,14,'抽检模板','qualitytemplate','','MENU',1,'2021-01-15 11:31:38',1,'2021-01-15 11:31:38','','0',NULL);
/*!40000 ALTER TABLE `SYS_PERMISSION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SYS_ROLE`
--

DROP TABLE IF EXISTS `SYS_ROLE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `SYS_ROLE` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(32) NOT NULL COMMENT '角色名称',
  `role_code` varchar(32) NOT NULL COMMENT '角色编码',
  `usable` char(1) NOT NULL COMMENT '是否可用',
  `priority` int NOT NULL COMMENT '优先级',
  `create_by` int NOT NULL,
  `create_time` datetime NOT NULL,
  `update_by` int NOT NULL,
  `update_time` datetime NOT NULL,
  `remarks` varchar(64) DEFAULT NULL COMMENT '备注',
  `del_flag` char(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SYS_ROLE`
--

LOCK TABLES `SYS_ROLE` WRITE;
/*!40000 ALTER TABLE `SYS_ROLE` DISABLE KEYS */;
INSERT INTO `SYS_ROLE` VALUES (1,'系统管理员','SYSTEM_MANAGER','1',1,1,'2021-01-10 23:02:14',1,'2021-01-10 23:02:14','','0'),(2,'质检主管','QUALITY_CHECK_SUPERVISOR','1',2,1,'2021-01-10 23:02:34',1,'2021-01-10 23:02:34','','0'),(3,'质检人员','QUALITY_CHECK_ORDINERY','1',3,1,'2021-01-10 23:04:23',1,'2021-01-10 23:04:23','','0');
/*!40000 ALTER TABLE `SYS_ROLE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SYS_ROLE_PERMISSION`
--

DROP TABLE IF EXISTS `SYS_ROLE_PERMISSION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `SYS_ROLE_PERMISSION` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` int NOT NULL COMMENT '角色id',
  `permission_id` int NOT NULL COMMENT '菜单id',
  `create_by` int DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` int DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `remark` varchar(128) DEFAULT NULL,
  `del_flag` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色菜单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SYS_ROLE_PERMISSION`
--

LOCK TABLES `SYS_ROLE_PERMISSION` WRITE;
/*!40000 ALTER TABLE `SYS_ROLE_PERMISSION` DISABLE KEYS */;
INSERT INTO `SYS_ROLE_PERMISSION` VALUES (1,1,1,1,'2021-01-11 09:09:16',1,'2021-01-11 09:09:16','','0'),(2,1,2,1,'2021-01-11 09:09:38',1,'2021-01-11 09:09:38','','0'),(3,1,3,1,'2021-01-11 09:10:16',1,'2021-01-11 09:10:16','','0'),(4,1,4,1,'2021-01-11 09:11:39',1,'2021-01-11 09:11:39','','0'),(5,1,5,1,'2021-01-11 09:11:39',1,'2021-01-11 09:11:39','','0'),(6,1,6,1,'2021-01-11 09:11:39',1,'2021-01-11 09:11:39','','0'),(7,1,7,1,'2021-01-11 09:11:39',1,'2021-01-11 09:11:39','','0'),(8,1,8,1,'2021-01-11 09:11:39',1,'2021-01-11 09:11:39','','0'),(9,1,9,1,'2021-01-11 09:11:39',1,'2021-01-11 09:11:39','','0'),(10,1,10,1,'2021-01-11 09:11:39',1,'2021-01-11 09:11:39','','0'),(11,1,11,1,'2021-01-11 09:11:39',1,'2021-01-11 09:11:39','','0'),(12,1,12,1,'2021-01-11 09:11:39',1,'2021-01-11 09:11:39','','0'),(13,1,13,1,'2021-01-11 09:11:39',1,'2021-01-11 09:11:39','','0'),(14,1,14,1,'2021-01-15 11:37:10',1,'2021-01-15 11:37:10','','0'),(15,2,1,1,'2021-01-11 09:16:15',1,'2021-01-11 09:16:15','','0'),(16,2,2,1,'2021-01-11 09:16:15',1,'2021-01-11 09:16:15','','0'),(17,2,3,1,'2021-01-11 09:16:15',1,'2021-01-11 09:16:15','','0'),(18,2,4,1,'2021-01-11 09:16:15',1,'2021-01-11 09:16:15','','0'),(19,2,5,1,'2021-01-11 09:16:15',1,'2021-01-11 09:16:15','','0'),(20,2,6,1,'2021-01-11 09:16:15',1,'2021-01-11 09:16:15','','0'),(21,2,7,1,'2021-01-11 09:16:15',1,'2021-01-11 09:16:15','','0'),(22,2,8,1,'2021-01-11 09:16:15',1,'2021-01-11 09:16:15','','0'),(23,2,9,1,'2021-01-11 09:16:15',1,'2021-01-11 09:16:15','','0'),(24,2,10,1,'2021-01-11 09:16:15',1,'2021-01-11 09:16:15','','0'),(25,2,11,1,'2021-01-11 09:16:15',1,'2021-01-11 09:16:15','','0'),(26,2,12,1,'2021-01-11 09:16:15',1,'2021-01-11 09:16:15','','0'),(27,2,13,1,'2021-01-11 09:16:15',1,'2021-01-11 09:16:15','','0'),(28,1,14,1,'2021-01-15 11:40:10',1,'2021-01-15 11:40:10','','0'),(29,1,15,1,'2021-01-15 11:40:14',1,'2021-01-15 11:40:14','','0');
/*!40000 ALTER TABLE `SYS_ROLE_PERMISSION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SYS_USER`
--

DROP TABLE IF EXISTS `SYS_USER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `SYS_USER` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '用户主键',
  `company_id` int NOT NULL COMMENT '所属公司id',
  `login_name` varchar(32) NOT NULL COMMENT '登陆账号',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `name` varchar(32) NOT NULL COMMENT '用户名',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(32) DEFAULT NULL COMMENT '座机号码',
  `mobile` varchar(32) DEFAULT NULL COMMENT '手机号码',
  `user_type` char(1) DEFAULT NULL COMMENT '用户类型',
  `photo` varchar(1024) DEFAULT NULL COMMENT '头像路径',
  `create_by` int NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建日期',
  `update_by` int NOT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新日期',
  `remarks` varchar(512) DEFAULT NULL COMMENT '备注',
  `del_flag` char(1) NOT NULL COMMENT '删除标记',
  `wechat_num` varchar(128) DEFAULT NULL COMMENT '微信号码',
  `qq_num` varchar(128) DEFAULT NULL COMMENT 'QQ号码',
  `salt` int NOT NULL DEFAULT '1' COMMENT '加密盐值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SYS_USER`
--

LOCK TABLES `SYS_USER` WRITE;
/*!40000 ALTER TABLE `SYS_USER` DISABLE KEYS */;
INSERT INTO `SYS_USER` VALUES (1,0,'admin','123456','杨荣炳','123@123.com','13344445555','12333334444','1','',1,'2021-01-10 14:23:27',1,'2021-01-10 14:23:27','','0','','',1);
/*!40000 ALTER TABLE `SYS_USER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SYS_USER_ROLE`
--

DROP TABLE IF EXISTS `SYS_USER_ROLE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `SYS_USER_ROLE` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `USER_ID` int NOT NULL COMMENT '用户ID',
  `ROLE_ID` int NOT NULL COMMENT '角色id',
  `create_by` int NOT NULL,
  `create_time` datetime NOT NULL,
  `update_by` int NOT NULL,
  `update_time` datetime NOT NULL,
  `remark` varchar(128) DEFAULT NULL,
  `del_flag` char(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SYS_USER_ROLE`
--

LOCK TABLES `SYS_USER_ROLE` WRITE;
/*!40000 ALTER TABLE `SYS_USER_ROLE` DISABLE KEYS */;
INSERT INTO `SYS_USER_ROLE` VALUES (1,1,1,1,'2021-01-10 23:14:32',1,'2021-01-10 23:14:32','','0');
/*!40000 ALTER TABLE `SYS_USER_ROLE` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-25 15:52:20
