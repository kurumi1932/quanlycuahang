-- MySQL dump 10.13  Distrib 8.0.24, for Win64 (x86_64)
--
-- Host: localhost    Database: quanlycuahang
-- ------------------------------------------------------
-- Server version	8.0.24

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
-- Table structure for table `ct_hd`
--

DROP TABLE IF EXISTS `ct_hd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ct_hd` (
  `mahd` varchar(20) NOT NULL,
  `masp` varchar(20) NOT NULL,
  `tensp` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dvtinh` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `soluongban` int NOT NULL,
  `dongiaban` float NOT NULL,
  `thanhtien` float NOT NULL,
  PRIMARY KEY (`mahd`,`masp`),
  KEY `masp` (`masp`),
  CONSTRAINT `ct_hd_ibfk_1` FOREIGN KEY (`mahd`) REFERENCES `hoa_don` (`mahd`),
  CONSTRAINT `ct_hd_ibfk_2` FOREIGN KEY (`masp`) REFERENCES `san_pham` (`masp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ct_hd`
--

LOCK TABLES `ct_hd` WRITE;
/*!40000 ALTER TABLE `ct_hd` DISABLE KEYS */;
INSERT INTO `ct_hd` VALUES ('HD20210610003','7UP','Nước ngọt có ga 7 Up','Chai',2,7000,14000),('HD20210610003','BCPS2','P/S bài chải cho bé','Cái',1,10000,10000),('HD20210610003','BSG','Thùng bia Sài Gòn 24 lon','Thùng',1,305000,305000),('HD20210610004','7UP','Nước ngọt có ga 7 Up','Chai',3,7000,21000),('HD20210610004','BCPS2','P/S bài chải cho bé','Cái',1,10000,10000),('HD20210610004','DASPL','Dầu ăn Simply 2l','Chai',1,86000,86000),('HD20210610004','PEP','Pepsi','Chai',1,8000,8000),('HD20210610005','PEP','Pepsi','Chai',2,8000,16000),('HD20210610005','STH1','Sữa TH TrueMilk','Hộp',3,6000,18000),('HD20210610005','TX0D','Trà xanh 0 độ','Chai',2,8000,16000),('HD20210610006','7UP','Nước ngọt có ga 7 Up','Chai',1,7000,7000),('HD20210610006','BCPR','Bàn chải Premier','Cái',1,15000,15000),('HD20210610006','NB1C','Nước tăng Number One chanh ','Chai',5,10000,50000),('HD20210610006','STH1','Sữa TH TrueMilk','Hộp',10,6000,60000),('HD20210610006','VED1','Vedan 1kg','Bịch',1,48000,48000),('HD20210610007','BCPS2','P/S bài chải cho bé','Cái',8,10000,80000),('HD20210610007','BSG','Thùng bia Sài Gòn 24 lon','Thùng',1,305000,305000),('HD20210610007','COSY','Bánh Cosy thập cẩm 630g','Hộp',1,120000,120000),('HD20210610007','DAMZ2','Dầu ăn Mezan 2l','Chai',1,65000,65000),('HD20210610007','DNHI','Nước mắm Đệ Nhị','Chai',1,15000,15000),('HD20210610008','HNK','Thùng bia Heineken 24 lon','Thùng',1,405000,405000),('HD20210610008','OMA','Thùng mì Omachi 30 gói các hương vị','Thùng',1,150000,150000),('HD20210610008','TX0D','Trà xanh 0 độ','Chai',1,8000,8000),('HD20210610009','DASPL','Dầu ăn Simply 2l','Chai',1,86000,86000),('HD20210610009','OMA','Thùng mì Omachi 30 gói các hương vị','Thùng',1,150000,150000),('HD20210610009','OREO2','Bánh Oreo hộp giấy','Hộp',2,25000,50000),('HD20210610009','PEP','Pepsi','Chai',2,8000,16000),('HD20210610009','SIZZI','Sữa Izzi 180ml','Hộp',6,7000,42000),('HD20210610010','BCX1','Bột chiên xù 100g','Gói',1,10000,10000),('HD20210610010','DANT','Dầu ăn Neptune 1l','Chai',1,42000,42000),('HD20210610010','OREO1','Bánh Oreo loại thỏi','Gói',1,14000,14000),('HD20210610010','SFAMI','Sữa Fami 200ml','Hộp',7,7000,49000),('HD20210610010','TX0D','Trà xanh 0 độ','Chai',1,8000,8000),('HD20210610010','VED1','Vedan 1kg','Bịch',2,48000,96000),('HD20210610012','7UP','Nước ngọt có ga 7 Up','Chai',2,7000,14000),('HD20210610012','BCPR','Bàn chải Premier','Cái',2,15000,30000),('HD20210610012','BCX1','Bột chiên xù 100g','Gói',1,10000,10000),('HD20210610013','7UP','Nước ngọt có ga 7 Up','Chai',2,7000,14000),('HD20210610013','DASPL','Dầu ăn Simply 2l','Chai',2,86000,172000),('HD20210610013','VED1','Vedan 1kg','Bịch',1,48000,48000),('HD20210610014','333','Bia 333 1 thùng 24 lon','Thùng',1,255000,255000),('HD20210610014','BCPS1','P/S chải sạch sâu','Cái',5,20000,100000),('HD20210614001','333','Bia 333 1 thùng 24 lon','Thùng',1,255000,255000),('HD20210614001','BCPS2','P/S bài chải cho bé','Cái',2,10000,20000),('HD20210614001','DAMZ2','Dầu ăn Mezan 2l','Chai',1,65000,65000),('HD20210614001','SIZZI','Sữa Izzi 180ml','Hộp',6,7000,14000),('HD20210614001','SOL','Bánh Solite cuộn dâu và lá dứa','Hộp',1,50000,50000),('HD20210617001','7UP','Nước ngọt có ga 7 Up','Chai',1,7000,7000),('HD20210617001','COSY','Bánh Cosy thập cẩm 630g','Hộp',3,120000,360000),('HD20210617001','HNMG','Hạt nêm Magi 900g','Bịch',2,55000,110000),('HD20210618001','333','Bia 333 1 thùng 24 lon','Thùng',1,255000,255000),('HD20210618001','7UP','Nước ngọt có ga 7 Up','Chai',1,7000,7000),('HD20210618001','BCPR','Bàn chải Premier','Cái',1,15000,15000),('HD20210620001','333','Bia 333 1 thùng 24 lon','Thùng',1,255000,255000),('HD20210620001','BCPR','Bàn chải Premier','Cái',1,15000,15000),('HD20210620001','DASPL','Dầu ăn Simply 2l','Chai',1,86000,86000),('HD20210620003','BCPS1','P/S chải sạch sâu','Cái',1,20000,20000),('HD20210620003','BCPS2','P/S bài chải cho bé','Cái',1,10000,10000),('HD20210620003','BSG','Thùng bia Sài Gòn 24 lon','Thùng',1,305000,305000),('HD20210620004','7UP','Nước ngọt có ga 7 Up','Chai',1,7000,7000),('HD20210620004','BCPS2','P/S bài chải cho bé','Cái',1,10000,10000),('HD20210620004','DAMZ1','Dầu ăn Mezan 1l','Chai',1,38000,38000),('HD20210620005','BCPS1','P/S chải sạch sâu','Cái',1,20000,20000),('HD20210620005','BSG','Thùng bia Sài Gòn 24 lon','Thùng',1,305000,305000),('HD20210620005','COSY','Bánh Cosy thập cẩm 630g','Hộp',1,120000,120000),('HD20210620006','333','Bia 333 1 thùng 24 lon','Thùng',1,255000,255000),('HD20210620006','BCX1','Bột chiên xù 100g','Gói',2,10000,20000),('HD20210620008','DNHI','Nước mắm Đệ Nhị','Chai',2,15000,30000),('HD20210620008','MLT','Thùng mì Lẩu Thái 30 gói ','Thùng',2,165000,330000),('HD20210620009','7UP','Nước ngọt có ga 7 Up','Chai',1,7000,7000),('HD20210620009','BCPS1','P/S chải sạch sâu','Cái',1,20000,20000),('HD20210620010','TX0D','Trà xanh 0 độ','Chai',2,8000,16000),('HD20210620010','VED1','Vedan 1kg','Bịch',1,48000,48000),('HD20210620011','SIZZI','Sữa Izzi 180ml','Hộp',1,7000,7000),('HD20210620011','SOL','Bánh Solite cuộn dâu và lá dứa','Hộp',4,50000,200000),('HD20210620012','NB1C','Nước tăng Number One chanh ','Chai',3,10000,30000),('HD20210620012','OMA','Thùng mì Omachi 30 gói các hương vị','Thùng',4,150000,600000),('HD20210620013','BSG','Thùng bia Sài Gòn 24 lon','Thùng',1,305000,305000),('HD20210620013','DAMZ1','Dầu ăn Mezan 1l','Chai',2,38000,76000),('HD20210621001','BSG','Thùng bia Sài Gòn 24 lon','Thùng',1,305000,305000),('HD20210621001','COSY','Bánh Cosy thập cẩm 630g','Hộp',3,120000,360000),('HD20210621002','PEP','Pepsi','Chai',3,8000,24000),('HD20210621002','VED04','Vedan 400g','Bịch',3,22000,66000),('HD20210621003','7UP','Nước ngọt có ga 7 Up','Chai',2,7000,14000),('HD20210621003','BCPS1','P/S chải sạch sâu','Cái',2,20000,40000),('HD20210621004','HHAO','Thùng mì Hảo Hảo 30 gói ','Thùng',4,95000,380000),('HD20210621004','HNMG','Hạt nêm Magi 900g','Bịch',1,55000,55000),('HD20210621004','SFAMI','Sữa Fami 200ml','Hộp',4,7000,28000),('HD20210621005','COSY','Bánh Cosy thập cẩm 630g','Hộp',2,120000,240000),('HD20210621005','DANT','Dầu ăn Neptune 1l','Chai',4,42000,168000),('HD20210621006','BSG','Thùng bia Sài Gòn 24 lon','Thùng',3,305000,915000),('HD20210621006','COSY','Bánh Cosy thập cẩm 630g','Hộp',3,120000,360000),('HD20210623001','DAMZ2','Dầu ăn Mezan 2l','Chai',2,65000,130000),('HD20210623001','HHAO','Thùng mì Hảo Hảo 30 gói ','Thùng',1,95000,95000),('HD20210623001','HNMG','Hạt nêm Magi 900g','Bịch',2,55000,110000),('HD20210627001','DAKD','Dầu ăn Kiddy','Chai',1,36000,36000),('HD20210627001','DNHAT','Nam Ngư Đệ Nhất','Chai',1,36000,36000),('HD20210627001','HHAO','Thùng mì Hảo Hảo 30 gói ','Thùng',1,95000,95000),('HD20210627001','NB1C','Nước tăng Number One chanh ','Chai',1,10000,10000),('HD20210629001','COSY','Bánh Cosy thập cẩm 630g','Hộp',1,120000,120000),('HD20210629001','DHMG','Dầu hào Magi 500g','Bịch',1,21000,21000),('HD20210629002','BCPS1','P/S chải sạch sâu','Cái',1,20000,20000),('HD20210629002','BSG','Thùng bia Sài Gòn 24 lon','Thùng',1,305000,305000),('HD20210630001','DHMG','Dầu hào Magi 500g','Bịch',1,21000,21000),('HD20210630001','NTMG','Nước tương Magi','Chai',1,15000,15000),('HD20210702001','BCX1','Bột chiên xù 100g','Gói',2,10000,20000),('HD20210702001','COSY','Bánh Cosy thập cẩm 630g','Hộp',1,120000,120000),('HD20210706001','BSG','Thùng bia Sài Gòn 24 lon','Thùng',1,305000,305000),('HD20210706001','DHMG','Dầu hào Magi 500g','Bịch',1,21000,21000),('HD20210707001','DHMG','Dầu hào Magi 500g','Bịch',1,21000,21000),('HD20210707001','DNHAT','Nam Ngư Đệ Nhất','Chai',1,36000,36000),('HD20210709001','DAKD','Dầu ăn Kiddy','Chai',1,36000,36000),('HD20210709001','DNHAT','Nam Ngư Đệ Nhất','Chai',1,36000,36000),('HD20210709002','BCPS1','P/S chải sạch sâu','Cái',1,20000,20000),('HD20210709002','BCX1','Bột chiên xù 100g','Gói',2,10000,20000),('HD20210711001','BCPS1','P/S chải sạch sâu','Cái',1,20000,20000),('HD20210711001','DAMZ2','Dầu ăn Mezan 2l','Chai',1,65000,65000),('HD20210714001','DAMZ2','Dầu ăn Mezan 2l','Chai',1,65000,65000),('HD20210714001','NB1C','Nước tăng Number One chanh ','Chai',3,10000,30000),('HD20210714002','BCPS2','P/S bài chải cho bé','Cái',1,10000,10000),('HD20210714002','COSY','Bánh Cosy thập cẩm 630g','Hộp',1,120000,120000),('HD20210714002','DAKD','Dầu ăn Kiddy','Chai',2,36000,72000),('HD20210717001','BCPS2','P/S bài chải cho bé','Cái',1,10000,10000),('HD20210717001','HHAO','Thùng mì Hảo Hảo 30 gói ','Thùng',1,95000,95000),('HD20210717001','HNK','Thùng bia Heineken 24 lon','Thùng',3,405000,1215000);
/*!40000 ALTER TABLE `ct_hd` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trg_updateSLT_after_addHD` AFTER INSERT ON `ct_hd` FOR EACH ROW BEGIN
	UPDATE san_pham
    SET soluong = soluong - new.soluongban
    where masp = new.masp;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trg_updateSLT_after_deleteHD` AFTER DELETE ON `ct_hd` FOR EACH ROW BEGIN
	DECLARE today INT(11) DEFAULT -1;
    SELECT (DATE(NOW())-ngayban) into today From hoa_don 
    where mahd=old.mahd;
	if today<='7' then
		UPDATE san_pham
		SET soluong = soluong + old.soluongban
		where masp = old.masp;
    end if;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `ct_pn`
--

DROP TABLE IF EXISTS `ct_pn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ct_pn` (
  `mapn` varchar(20) NOT NULL,
  `masp` varchar(10) NOT NULL,
  `tensp` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dvtinh` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `soluongnhap` int NOT NULL,
  `dongianhap` float NOT NULL,
  `thanhtien` float NOT NULL,
  PRIMARY KEY (`mapn`,`masp`),
  KEY `masp` (`masp`),
  CONSTRAINT `ct_pn_ibfk_1` FOREIGN KEY (`mapn`) REFERENCES `phieu_nhap` (`mapn`),
  CONSTRAINT `ct_pn_ibfk_2` FOREIGN KEY (`masp`) REFERENCES `san_pham` (`masp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ct_pn`
--

LOCK TABLES `ct_pn` WRITE;
/*!40000 ALTER TABLE `ct_pn` DISABLE KEYS */;
INSERT INTO `ct_pn` VALUES ('PN20210709001','BCX1','Bột chiên xù 100g','Gói',50,10000,500000),('PN20210709001','BSG','Thùng bia Sài Gòn 24 lon','Thùng',15,290000,4350000),('PN20210709002','DAKD','Dầu ăn Kiddy','Chai',40,33000,1320000),('PN20210709002','DASPL','Dầu ăn Simply 2l','Chai',20,83000,1660000),('PN20210710001','BCPS1','P/S chải sạch sâu','Cái',50,15000,750000),('PN20210710001','DNHAT','Nam Ngư Đệ Nhất','Chai',40,33000,1320000),('PN20210710001','HNMG','Hạt nêm Magi 900g','Bịch',40,52000,2080000),('PN20210711001','DANT','Dầu ăn Neptune 1l','Chai',10,38000,380000),('PN20210711001','DHMG','Dầu hào Magi 500g','Bịch',20,19000,380000),('PN20210714001','VED04','Vedan 400g','Bịch',25,18000,450000),('PN20210714001','VED1','Vedan 1kg','Bịch',20,44000,880000),('PN20210714001','VED2','Vedan 2kg','Bịch',20,87000,1740000);
/*!40000 ALTER TABLE `ct_pn` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trg_updateSLT_after_addPN` AFTER INSERT ON `ct_pn` FOR EACH ROW BEGIN
	UPDATE san_pham
    SET soluong = soluong + new.soluongnhap
    where masp = new.masp;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trg_updateSLT_after_deletePN` AFTER DELETE ON `ct_pn` FOR EACH ROW BEGIN
	DECLARE today INT(11) DEFAULT -1;
    SELECT (DATE(NOW())-ngaynhap) into today From phieu_nhap
    where mapn=old.mapn;
	if today<='7' then
		UPDATE san_pham
		SET soluong = soluong - old.soluongnhap
		where masp = old.masp;
    end if;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `hoa_don`
--

DROP TABLE IF EXISTS `hoa_don`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoa_don` (
  `mahd` varchar(20) NOT NULL,
  `tonggiaban` float NOT NULL,
  `ngayban` date NOT NULL,
  PRIMARY KEY (`mahd`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoa_don`
--

LOCK TABLES `hoa_don` WRITE;
/*!40000 ALTER TABLE `hoa_don` DISABLE KEYS */;
INSERT INTO `hoa_don` VALUES ('HD20210610003',329000,'2021-06-10'),('HD20210610004',125000,'2021-06-10'),('HD20210610005',50000,'2021-06-10'),('HD20210610006',180000,'2021-06-10'),('HD20210610007',585000,'2021-06-10'),('HD20210610008',563000,'2021-06-10'),('HD20210610009',344000,'2021-06-10'),('HD20210610010',219000,'2021-06-10'),('HD20210610012',54000,'2021-06-10'),('HD20210610013',234000,'2021-06-10'),('HD20210610014',355000,'2021-06-10'),('HD20210614001',432000,'2021-06-14'),('HD20210617001',477000,'2021-06-17'),('HD20210618001',277000,'2021-06-18'),('HD20210620001',356000,'2021-06-20'),('HD20210620003',335000,'2021-06-20'),('HD20210620004',65000,'2021-06-20'),('HD20210620005',485000,'2021-06-20'),('HD20210620006',275000,'2021-06-20'),('HD20210620008',360000,'2021-06-20'),('HD20210620009',27000,'2021-06-20'),('HD20210620010',64000,'2021-06-20'),('HD20210620011',207000,'2021-06-20'),('HD20210620012',630000,'2021-06-20'),('HD20210620013',381000,'2021-06-20'),('HD20210621001',665000,'2021-06-21'),('HD20210621002',90000,'2021-06-21'),('HD20210621003',54000,'2021-06-21'),('HD20210621004',463000,'2021-06-21'),('HD20210621005',408000,'2021-06-21'),('HD20210621006',1275000,'2021-06-21'),('HD20210623001',335000,'2021-06-23'),('HD20210627001',177000,'2021-06-27'),('HD20210629001',141000,'2021-06-29'),('HD20210629002',325000,'2021-06-29'),('HD20210630001',36000,'2021-06-30'),('HD20210702001',140000,'2021-07-02'),('HD20210706001',326000,'2021-07-06'),('HD20210707001',57000,'2021-07-07'),('HD20210709001',72000,'2021-07-09'),('HD20210709002',40000,'2021-07-09'),('HD20210711001',85000,'2021-07-11'),('HD20210714001',95000,'2021-07-14'),('HD20210714002',202000,'2021-07-14'),('HD20210717001',1320000,'2021-07-17');
/*!40000 ALTER TABLE `hoa_don` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phieu_nhap`
--

DROP TABLE IF EXISTS `phieu_nhap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phieu_nhap` (
  `mapn` varchar(20) NOT NULL,
  `tonggianhap` float NOT NULL,
  `ngaynhap` date NOT NULL,
  PRIMARY KEY (`mapn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieu_nhap`
--

LOCK TABLES `phieu_nhap` WRITE;
/*!40000 ALTER TABLE `phieu_nhap` DISABLE KEYS */;
INSERT INTO `phieu_nhap` VALUES ('PN20210709001',4850000,'2021-07-09'),('PN20210709002',2980000,'2021-07-09'),('PN20210710001',4150000,'2021-07-10'),('PN20210711001',760000,'2021-07-11'),('PN20210714001',3070000,'2021-07-14');
/*!40000 ALTER TABLE `phieu_nhap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `san_pham`
--

DROP TABLE IF EXISTS `san_pham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `san_pham` (
  `masp` varchar(10) NOT NULL,
  `tensp` varchar(40) NOT NULL,
  `dvtinh` varchar(15) NOT NULL,
  `soluong` int NOT NULL,
  `dongiaban` float NOT NULL,
  PRIMARY KEY (`masp`),
  UNIQUE KEY `masp_UNIQUE` (`masp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `san_pham`
--

LOCK TABLES `san_pham` WRITE;
/*!40000 ALTER TABLE `san_pham` DISABLE KEYS */;
INSERT INTO `san_pham` VALUES ('333','Bia 333 1 thùng 24 lon','Thùng',40,255000),('7UP','Nước ngọt có ga 7 Up','Chai',58,7000),('BCPR','Bàn chải Premier','Cái',50,15000),('BCPS1','P/S chải sạch sâu','Cái',55,20000),('BCPS2','P/S bài chải cho bé','Cái',37,10000),('BCX1','Bột chiên xù 100g','Gói',60,10000),('BSG','Thùng bia Sài Gòn 24 lon','Thùng',35,305000),('COSY','Bánh Cosy thập cẩm 630g','Hộp',39,120000),('DACL','Dầu ăn Cái Lân 1l ','Chai',32,29000),('DAKD','Dầu ăn Kiddy','Chai',51,36000),('DAMZ1','Dầu ăn Mezan 1l','Chai',30,38000),('DAMZ2','Dầu ăn Mezan 2l','Chai',30,65000),('DANT','Dầu ăn Neptune 1l','Chai',28,42000),('DASPL','Dầu ăn Simply 2l','Chai',68,86000),('DHMG','Dầu hào Magi 500g','Bịch',36,21000),('DNHAT','Nam Ngư Đệ Nhất','Chai',52,36000),('DNHI','Nước mắm Đệ Nhị','Chai',48,15000),('HHAO','Thùng mì Hảo Hảo 30 gói ','Thùng',22,95000),('HNK','Thùng bia Heineken 24 lon','Thùng',17,405000),('HNMG','Hạt nêm Magi 900g','Bịch',52,55000),('MLT','Thùng mì Lẩu Thái 30 gói ','Thùng',20,165000),('NB1C','Nước tăng Number One chanh ','Chai',21,10000),('NTMG','Nước tương Magi','Chai',49,15000),('OMA','Thùng mì Omachi 30 gói các hương vị','Thùng',15,150000),('OREO1','Bánh Oreo loại thỏi','Gói',30,14000),('OREO2','Bánh Oreo hộp giấy','Hộp',40,25000),('PEP','Pepsi','Chai',20,8000),('SFAMI','Sữa Fami 200ml','Hộp',80,7000),('SIZZI','Sữa Izzi 180ml','Hộp',25,7000),('SOL','Bánh Solite cuộn dâu và lá dứa','Hộp',40,50000),('STH1','Sữa TH TrueMilk','Hộp',80,6000),('TX0D','Trà xanh 0 độ','Chai',25,8000),('VED04','Vedan 400g','Bịch',40,22000),('VED1','Vedan 1kg','Bịch',35,48000),('VED2','Vedan 2kg','Bịch',35,91000);
/*!40000 ALTER TABLE `san_pham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'quanlycuahang'
--

--
-- Dumping routines for database 'quanlycuahang'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-26  3:12:50
