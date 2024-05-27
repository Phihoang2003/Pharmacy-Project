CREATE DATABASE  IF NOT EXISTS `quanlihieuthuoc` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `quanlihieuthuoc`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: quanlihieuthuoc
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `chitietdoitra`
--

DROP TABLE IF EXISTS `chitietdoitra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitietdoitra` (
  `maSP` varchar(45) NOT NULL,
  `maDT` varchar(45) NOT NULL,
  `soLuong` int DEFAULT NULL,
  `giaBan` double DEFAULT NULL,
  `thanhTien` double DEFAULT NULL,
  PRIMARY KEY (`maSP`,`maDT`),
  KEY `fk_doiTra_idx` (`maDT`),
  CONSTRAINT `fk_doiTraCT` FOREIGN KEY (`maDT`) REFERENCES `doitra` (`maDT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietdoitra`
--

LOCK TABLES `chitietdoitra` WRITE;
/*!40000 ALTER TABLE `chitietdoitra` DISABLE KEYS */;
INSERT INTO `chitietdoitra` VALUES ('TH092992922','DT310220161',1,8400,8400),('TH092992922','DT492687793',1,8400,8400),('TH092992922','DT692646178',1,8400,8400),('TH101230923','DT379981555',2,35000,70000),('TH101230923','DT951012500',2,35000,70000),('TH120394024','DT317370635',3,35000,105000),('TH249853788','DT153072943',2,4200,8400),('TH249853788','DT422466485',2,4200,8400),('TH249853788','DT906596930',2,4200,8400);
/*!40000 ALTER TABLE `chitietdoitra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chitiethoadon`
--

DROP TABLE IF EXISTS `chitiethoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitiethoadon` (
  `maHD` varchar(45) DEFAULT NULL,
  `maSP` varchar(45) DEFAULT NULL,
  `soLuong` int DEFAULT NULL,
  `giaGoc` double DEFAULT NULL,
  `giaBan` double DEFAULT NULL,
  `thanhTien` double DEFAULT NULL,
  KEY `fk_thuoc_idx` (`maSP`),
  KEY `fk_hoadon` (`maHD`),
  CONSTRAINT `fk_hoadon` FOREIGN KEY (`maHD`) REFERENCES `hoadon` (`maHD`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_thuoc` FOREIGN KEY (`maSP`) REFERENCES `thuoc` (`maThuoc`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitiethoadon`
--

LOCK TABLES `chitiethoadon` WRITE;
/*!40000 ALTER TABLE `chitiethoadon` DISABLE KEYS */;
INSERT INTO `chitiethoadon` VALUES ('HD565319085','TH101230923',3,35000,35000,105000),('HD772113089','TH120394024',9,35000,35000,315000),('HD688612084','TH120394024',4,35000,35000,140000),('HD688612084','TH192023902',5,3500,3500,17500),('HD688612084','TH101230923',8,35000,35000,280000),('HD274003861','TH101230923',2,35000,24500,49000),('HD274003861','TH120394024',2,35000,24500,49000),('HD368378341','TH249853788',2,4200,4200,8400),('HD368378341','TH324928430',4,3500,3500,14000),('HD368378341','TH425904355',2,4200,4200,8400),('HD744975874','TH120394024',2,35000,24500,49000),('HD744975874','TH192023902',2,3500,3500,7000),('HD744975874','TH235984758',2,3500,3500,7000),('HD925548401','TH238578848',3,72800,72800,218400),('HD386901703','TH120394024',2,35000,24500,49000),('HD386901703','TH101230923',2,35000,24500,49000),('HD816716935','TH992929283',1,89600,89600,89600),('HD999606432','TH092992922',2,8400,8400,16800),('HD321608639','TH225484044',2,3500,2450,4900),('HD710967795','TH092992922',2,8400,8400,16800),('HD125585310','TH092992922',2,8400,8400,16800),('HD968429490','TH092992922',2,8400,8400,16800),('HD968429490','TH101230923',2,35000,28000,56000),('HD451262718','TH092992922',3,8400,8400,25200),('HD451262718','TH101230923',2,35000,28000,56000),('HD413343812','TH101230923',2,35000,35000,70000),('HD413343812','TH092992922',1,8400,6720,6720);
/*!40000 ALTER TABLE `chitiethoadon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chitietphieunhap`
--

DROP TABLE IF EXISTS `chitietphieunhap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitietphieunhap` (
  `maCTPhieuNhap` int NOT NULL,
  `maPhienBanSanPham` int NOT NULL,
  `soLuong` int DEFAULT NULL,
  `donGia` double DEFAULT NULL,
  `hinhThucNhap` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`maCTPhieuNhap`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietphieunhap`
--

LOCK TABLES `chitietphieunhap` WRITE;
/*!40000 ALTER TABLE `chitietphieunhap` DISABLE KEYS */;
/*!40000 ALTER TABLE `chitietphieunhap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chuongtrinhkhuyenmai`
--

DROP TABLE IF EXISTS `chuongtrinhkhuyenmai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chuongtrinhkhuyenmai` (
  `maCTKM` varchar(45) NOT NULL,
  `tenCTKM` varchar(45) DEFAULT NULL,
  `maLoaiKM` varchar(45) NOT NULL,
  `soTienToiThieu` double DEFAULT NULL,
  `soTienToiDa` double DEFAULT NULL,
  `giamGia` int DEFAULT NULL,
  `ngayBatDau` date DEFAULT NULL,
  `ngayKetThuc` date DEFAULT NULL,
  `trangThai` int DEFAULT NULL,
  PRIMARY KEY (`maCTKM`),
  KEY `fk_maLoai_idx` (`maLoaiKM`),
  CONSTRAINT `fk_maLoai` FOREIGN KEY (`maLoaiKM`) REFERENCES `loaikhuyenmai` (`maLoaiKM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chuongtrinhkhuyenmai`
--

LOCK TABLES `chuongtrinhkhuyenmai` WRITE;
/*!40000 ALTER TABLE `chuongtrinhkhuyenmai` DISABLE KEYS */;
INSERT INTO `chuongtrinhkhuyenmai` VALUES ('KM124334523','Mừng khai trương','GGHD',150000,200000,10,'2024-04-16','2024-04-20',1),('KM421532747','Mừng ngày quốc tế lao động','GGSP',0,0,20,'2024-04-15','2024-08-16',1),('KM436390003','Mừng ngày quốc tế cộng sản','GGSP',0,0,15,'2024-04-15','2024-07-17',1),('KM750234717','Mung Le Nha Giao','GGSP',200000,1000000,30,'2024-03-12','2024-05-20',1),('KM866829028','Mừng ngày quốc tế lao động','GGSP',0,0,10,'2024-04-15','2024-09-17',1),('KM961336351','Mừng ngày giỗ tổ Hùng Vương','GGHD',100000,300000,15,'2024-04-15','2024-08-13',1),('KM981433047','Ngày kỉ niệm của hàng','GGHD',20000,40000,30,'2024-04-05','2024-04-08',0);
/*!40000 ALTER TABLE `chuongtrinhkhuyenmai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doitra`
--

DROP TABLE IF EXISTS `doitra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doitra` (
  `maDT` varchar(45) NOT NULL,
  `maHD` varchar(45) DEFAULT NULL,
  `maNV` varchar(45) DEFAULT NULL,
  `hinhThucDoiTra` varchar(45) DEFAULT NULL,
  `lyDoDoiTra` varchar(45) DEFAULT NULL,
  `thoiGianDoiTra` datetime DEFAULT NULL,
  `tongTien` double DEFAULT NULL,
  PRIMARY KEY (`maDT`),
  KEY `fk_nhanVien_idx` (`maNV`),
  KEY `fk_hoaDon_idx` (`maHD`),
  CONSTRAINT `fk_hoaDonDT` FOREIGN KEY (`maHD`) REFERENCES `hoadon` (`maHD`),
  CONSTRAINT `fk_nhanVienDT` FOREIGN KEY (`maNV`) REFERENCES `nhanvien` (`maNhanVien`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doitra`
--

LOCK TABLES `doitra` WRITE;
/*!40000 ALTER TABLE `doitra` DISABLE KEYS */;
INSERT INTO `doitra` VALUES ('DT153072943','HD368378341','NV234534535','Đổi mới','Bị lỗi','2024-04-16 00:00:00',0),('DT310220161','HD125585310','NV234534535','Hoàn trả','Không phù hợp với khách hàng','2024-04-16 00:00:00',8400),('DT317370635','HD688612084','NV234534535','Đổi mới','Sản phẩm bị lỗi','2024-04-15 00:00:00',0),('DT379981555','HD565319085','NV234534535','Đổi mới','San pham bi hong','2024-04-15 00:00:00',0),('DT422466485','HD368378341','NV234534535','Đổi mới','Không thích','2024-04-16 00:00:00',0),('DT492687793','HD999606432','NV234534535','Hoàn trả','Không phù hợp','2024-04-16 00:00:00',8400),('DT692646178','HD125585310','NV234534535','Hoàn trả','Khong phu hop','2024-04-16 00:00:00',8400),('DT906596930','HD368378341','NV234534535','Đổi mới','','2024-04-16 00:00:00',0),('DT951012500','HD274003861','NV234534535','Hoàn trả','Sản phẩm không phù hợp','2024-04-15 00:00:00',70000);
/*!40000 ALTER TABLE `doitra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donvitinh`
--

DROP TABLE IF EXISTS `donvitinh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `donvitinh` (
  `maDonViTinh` varchar(45) NOT NULL,
  `tenDonViTinh` varchar(45) NOT NULL,
  PRIMARY KEY (`maDonViTinh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donvitinh`
--

LOCK TABLES `donvitinh` WRITE;
/*!40000 ALTER TABLE `donvitinh` DISABLE KEYS */;
INSERT INTO `donvitinh` VALUES ('DVT1','Viên'),('DVT2','Hộp'),('DVT3','Tuýt'),('DVT4','Vỉ'),('DVT5','Chai'),('DVT6','Ống'),('DVT7','Gói');
/*!40000 ALTER TABLE `donvitinh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoadon`
--

DROP TABLE IF EXISTS `hoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoadon` (
  `maHD` varchar(45) NOT NULL,
  `ngayLapHoaDon` datetime DEFAULT NULL,
  `khachHang` varchar(45) DEFAULT NULL,
  `nhanVien` varchar(45) DEFAULT NULL,
  `chuongTrinhKM` varchar(45) DEFAULT NULL,
  `tienKhuyenMai` double DEFAULT NULL,
  `tongTien` double DEFAULT NULL,
  `tienThanhToan` double DEFAULT NULL,
  `tinhTrang` int DEFAULT NULL,
  `thoiHan` int DEFAULT NULL,
  PRIMARY KEY (`maHD`),
  KEY `fk_nhanVien_idx` (`nhanVien`),
  KEY `fk_khachhang_idx` (`khachHang`),
  KEY `fk_khuyenMai_idx` (`chuongTrinhKM`),
  CONSTRAINT `fk_khachhang` FOREIGN KEY (`khachHang`) REFERENCES `khachhang` (`maKhachHang`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_khuyenMai` FOREIGN KEY (`chuongTrinhKM`) REFERENCES `chuongtrinhkhuyenmai` (`maCTKM`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_nhanVien` FOREIGN KEY (`nhanVien`) REFERENCES `nhanvien` (`maNhanVien`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoadon`
--

LOCK TABLES `hoadon` WRITE;
/*!40000 ALTER TABLE `hoadon` DISABLE KEYS */;
INSERT INTO `hoadon` VALUES ('HD125585310','2024-04-16 00:00:00','KH839306001','NV234534535',NULL,0,16800,16800,1,NULL),('HD274003861','2024-04-15 00:00:00','KH839306002','NV234534535',NULL,0,98000,98000,1,NULL),('HD321608639','2024-04-16 00:00:00','KH477879040','NV234534535',NULL,0,4900,4900,1,NULL),('HD368378341','2024-04-15 00:00:00','KH839306002','NV234534535',NULL,0,30800,30800,1,NULL),('HD386901703','2024-04-15 00:00:00','KH839306001','NV234534535',NULL,0,98000,98000,1,NULL),('HD413343812','2024-05-26 00:00:00','KH839306001','NV234534535',NULL,0,76720,76720,1,NULL),('HD451262718','2024-05-25 00:00:00','KH839306002','NV234534535',NULL,0,81200,81200,1,NULL),('HD565319085','2024-04-15 00:00:00','KH839306001','NV234534535','KM750234717',63000,210000,147000,1,NULL),('HD688612084','2024-04-15 00:00:00','KH839306001','NV234534535','KM750234717',131250,437500,306250,1,NULL),('HD710967795','2024-04-16 00:00:00','KH839306001','NV234534535',NULL,0,16800,16800,1,NULL),('HD744975874','2024-04-15 00:00:00',NULL,'NV234534535',NULL,0,63000,63000,1,NULL),('HD772113089','2024-04-15 00:00:00','KH839306001','NV234534535','KM750234717',94500,315000,220500,1,NULL),('HD816716935','2024-04-15 00:00:00',NULL,'NV234534535',NULL,0,89600,89600,1,NULL),('HD925548401','2024-04-15 00:00:00',NULL,'NV234534535','KM961336351',32760,218400,185640,1,NULL),('HD968429490','2024-04-16 00:00:00','KH839306001','NV234534535',NULL,0,72800,72800,1,NULL),('HD999606432','2024-04-16 00:00:00','KH477879040','NV234534535',NULL,0,16800,16800,1,NULL);
/*!40000 ALTER TABLE `hoadon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khachhang` (
  `maKhachHang` varchar(45) NOT NULL,
  `tenKhachHang` varchar(45) DEFAULT NULL,
  `diemTichLuy` int DEFAULT NULL,
  `soDienThoai` varchar(45) DEFAULT NULL,
  `ngayThamGia` datetime DEFAULT CURRENT_TIMESTAMP,
  `gioiTinh` int DEFAULT NULL,
  `trangThai` int DEFAULT NULL,
  PRIMARY KEY (`maKhachHang`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
INSERT INTO `khachhang` VALUES ('KH477879040','Đặng Hoàng Phi',217,'0293939234','2024-04-16 00:00:00',1,NULL),('KH839306001','Nguyễn Thị Thùy Kiều',14713,'0967312797','2024-02-24 15:33:16',0,1),('KH839306002','Nguyễn Thị Ngọc Huyền',2300,'0929393933','2024-02-24 15:33:16',0,1);
/*!40000 ALTER TABLE `khachhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loaikhuyenmai`
--

DROP TABLE IF EXISTS `loaikhuyenmai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loaikhuyenmai` (
  `maLoaiKM` varchar(45) NOT NULL,
  `moTa` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`maLoaiKM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaikhuyenmai`
--

LOCK TABLES `loaikhuyenmai` WRITE;
/*!40000 ALTER TABLE `loaikhuyenmai` DISABLE KEYS */;
INSERT INTO `loaikhuyenmai` VALUES ('GGHD','Khuyen Mai cho hoa don'),('GGSP','Khuyen mai cho san pham');
/*!40000 ALTER TABLE `loaikhuyenmai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhacungcap`
--

DROP TABLE IF EXISTS `nhacungcap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhacungcap` (
  `maNhaCungCap` varchar(45) NOT NULL,
  `tenNhaCungCap` varchar(255) DEFAULT NULL,
  `soDienThoai` varchar(45) DEFAULT NULL,
  `diaChi` varchar(45) DEFAULT NULL,
  `trangThai` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`maNhaCungCap`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhacungcap`
--

LOCK TABLES `nhacungcap` WRITE;
/*!40000 ALTER TABLE `nhacungcap` DISABLE KEYS */;
INSERT INTO `nhacungcap` VALUES ('NCC3939399393','OLIC (THAILAND) LTD','0928383833','Bangkok','1'),('NCC3944030444','CHI NHÁNH CÔNG TY CỔ PHẦN DƯỢC PHẨM TRƯỜNG THỌ','0232938922','Nghệ An','1'),('NCC403110282','Công Ty Phần Mềm Cổ Phần Đông Dương','0929238232','TPHCm','0'),('NCC626751936','Công ty TNHH Abbott Healthcare Việt Nam','0977310097','Hóc môn,tphcm','1'),('NCC737373783','TIPHARCO','0393933993','Hà nội','1'),('NCC8282929929','OPV','0337379292','Vũng Tàu','0'),('NCC838393993','MEDOPHARM','0393939393','Đà nẵng','1'),('NCC9292000020','STELLA','0928383822','Hà Tĩnh','0'),('NCC9393993933','GSK','0838339393','Huế','1');
/*!40000 ALTER TABLE `nhacungcap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhanvien` (
  `maNhanVien` varchar(45) NOT NULL,
  `hoTen` varchar(45) DEFAULT NULL,
  `gioiTinh` varchar(45) DEFAULT NULL,
  `diaChi` varchar(45) DEFAULT NULL,
  `ngaySInh` datetime DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `sdt` varchar(45) DEFAULT NULL,
  `trangThai` varchar(45) DEFAULT NULL,
  `ngayVaoLam` datetime DEFAULT NULL,
  `caLamViec` varchar(45) DEFAULT NULL,
  `chucVu` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`maNhanVien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES ('NV189929599','Hoàng Khôi','1','093393939','2024-04-05 00:00:00','hoangtu123@gmail.com','0129929229','Nghỉ việc',NULL,'Ca 1','Quản lý'),('NV221466726','Hoàng Hiệp','0','02929292','2024-04-03 00:00:00','hoanghiep123@gmail.com','0977310098','Đang làm việc',NULL,'Ca 1','Quản lý'),('NV234534535','Sơn Tùng','1','029292992','2004-12-11 00:00:00','sontung123@gmail.com','012345','Đang làm việc',NULL,'Ca 2','Nhân viên'),('NV283950415','Dang Hoang Phong','1','TPHCM','2004-04-12 00:00:00','hoangphong123@gmail.com','0977310097','Đang làm việc',NULL,'Ca 1','Quản lý'),('NV326954359','Quang Hải','1','123456789123','2000-04-06 00:00:00','quanghai123@gmail.com','0967312797','Nghỉ phép',NULL,'Ca 2','Quản lý'),('NV489101538','Công Phượng','0','0203003','2024-04-03 00:00:00','congpuong123@gmail.com','192919292','Nghỉ việc',NULL,'Ca 1','Nhân viên'),('NV526111495','Tuấn Minh','1','012345678912','1999-04-09 00:00:00','tuanminh123@gmail.com','0967312797','Nghỉ phép',NULL,'Ca 2','Quản lý'),('NV675157503','Hoàng Hải','1','0484949','2024-04-04 00:00:00','hoanghai123@gmail.com','2929299292','Nghỉ việc',NULL,'Ca 1','Nhân viên'),('NV713466402','Tuấn Khải','1','029392939294','2000-04-16 00:00:00','tuankhai123@gmail.com','0977310097','Nghỉ việc',NULL,'Ca 1','Nhân viên'),('NV854614531','Công Danh Hải','1','123456789123','2000-04-02 00:00:00','condanh123@gmail.com','0967312797','Nghỉ phép',NULL,'Ca 2','Quản lý'),('NV986517585','Nguyễn Song Kiều','0','029323929392','2002-04-10 00:00:00','songkieiu456@gmail.com','0939930092','Nghỉ phép',NULL,'Ca 1','Nhân viên');
/*!40000 ALTER TABLE `nhanvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhomhanghoa`
--

DROP TABLE IF EXISTS `nhomhanghoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhomhanghoa` (
  `maNhom` varchar(45) NOT NULL,
  `tenNhom` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`maNhom`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhomhanghoa`
--

LOCK TABLES `nhomhanghoa` WRITE;
/*!40000 ALTER TABLE `nhomhanghoa` DISABLE KEYS */;
INSERT INTO `nhomhanghoa` VALUES ('NH1','Thuốc an thần'),('NH10','Thuốc chống dị ứng'),('NH11','Dụng cụ y tế'),('NH12','Sốt rét, Viêm khớp dạng thấp'),('NH13','Điều trị nhiễm khuẩn nhẹ, vừa và nặng'),('NH14','Thuốc điều trị tiểu đường'),('NH15','Thuốc kháng virus'),('NH16','Sản phẩm dinh dưỡng'),('NH17','Dung dịch nhỏ mắt'),('NH18','Liệu pháp nội tiết trong điều trị ung thư'),('NH19','Chất điện giải'),('NH2','Thuốc chống dị ứng'),('NH3','Thuốc kháng sinh'),('NH4','Thuốc điều trị cao huyết áp'),('NH5','Thuốc corticosteroid'),('NH6','Thuốc giảm đau'),('NH7','Hormone giáp'),('NH8','Thuốc điều trị đái tháo đường'),('NH9','Thuốc chống ho');
/*!40000 ALTER TABLE `nhomhanghoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nuocsanxuat`
--

DROP TABLE IF EXISTS `nuocsanxuat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nuocsanxuat` (
  `maNuoc` varchar(45) NOT NULL,
  `tenNuoc` varchar(45) NOT NULL,
  PRIMARY KEY (`maNuoc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nuocsanxuat`
--

LOCK TABLES `nuocsanxuat` WRITE;
/*!40000 ALTER TABLE `nuocsanxuat` DISABLE KEYS */;
INSERT INTO `nuocsanxuat` VALUES ('NSX','Mỹ'),('NSX1','Việt Nam'),('NSX2','Nhật Bản'),('NSX3','Hàn Quốc'),('NSX4','Ý'),('NSX5','Ấn Độ'),('NSX6','Đan Mạch'),('NSX7','Thái Lan'),('NSX8','Anh'),('NSX9','Thụy Sĩ');
/*!40000 ALTER TABLE `nuocsanxuat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phieunhap`
--

DROP TABLE IF EXISTS `phieunhap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phieunhap` (
  `maPN` varchar(45) NOT NULL,
  `maThuoc` varchar(45) NOT NULL,
  `maNCC` varchar(45) NOT NULL,
  `soLuongNhap` int DEFAULT NULL,
  `ngayNhap` date DEFAULT NULL,
  PRIMARY KEY (`maPN`),
  KEY `maNhaCungCap_idx` (`maNCC`),
  CONSTRAINT `maNhaCungCap` FOREIGN KEY (`maNCC`) REFERENCES `nhacungcap` (`maNhaCungCap`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieunhap`
--

LOCK TABLES `phieunhap` WRITE;
/*!40000 ALTER TABLE `phieunhap` DISABLE KEYS */;
INSERT INTO `phieunhap` VALUES ('PN250199696','TH249853788','NCC626751936',45,'2024-04-15'),('PN250199699','TH743874358','NCC626751936',45,'2024-04-15'),('PN280646683','TH923478358','NCC737373783',34,'2024-04-14'),('PN298025233','TH653897340','NCC626751936',40,'2024-04-15'),('PN298025902','TH235984758','NCC626751936',40,'2024-04-15'),('PN361910623','TH908070654','NCC9393993933',33,'2024-04-15'),('PN361910680','TH345893489','NCC9393993933',33,'2024-04-15'),('PN431913135','TH901222222','NCC737373783',34,'2024-04-15'),('PN431913153','TH901222222','NCC737373783',34,'2024-04-15'),('PN457646343','TH925892735','NCC3939399393',30,'2024-04-15'),('PN457646782','TH101230923','NCC3939399393',30,'2024-04-15'),('PN496351343','TH238578848','NCC737373783',34,'2024-04-15'),('PN496351818','TH923478358','NCC737373783',34,'2024-04-15'),('PN671394232','TH238578848','NCC9393993933',27,'2024-04-15'),('PN671394638','TH396725989','NCC9393993933',27,'2024-04-15'),('PN744911044','TH345098436','NCC838393993',36,'2024-04-15'),('PN744911232','TH345098436','NCC838393993',36,'2024-04-15'),('PN776691203','TH654564646','NCC626751936',34,'2024-04-15'),('PN776691224','TH238578848','NCC626751936',34,'2024-04-15'),('PN813981234','TH238578848','NCC8282929929',42,'2024-04-15'),('PN813981357','TH295245892','NCC8282929929',42,'2024-04-15'),('PN855913315','TH435495888','NCC3939399393',34,'2024-04-15'),('PN855913929','TH435495888','NCC3939399393',34,'2024-04-15');
/*!40000 ALTER TABLE `phieunhap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taikhoan`
--

DROP TABLE IF EXISTS `taikhoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `taikhoan` (
  `maNV` varchar(45) NOT NULL,
  `tenTK` varchar(45) NOT NULL,
  `matKhau` varchar(45) NOT NULL,
  `thoiGianDN` datetime DEFAULT CURRENT_TIMESTAMP,
  `trangThai` int DEFAULT NULL,
  PRIMARY KEY (`maNV`),
  CONSTRAINT `fk_nhanVien1` FOREIGN KEY (`maNV`) REFERENCES `nhanvien` (`maNhanVien`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taikhoan`
--

LOCK TABLES `taikhoan` WRITE;
/*!40000 ALTER TABLE `taikhoan` DISABLE KEYS */;
INSERT INTO `taikhoan` VALUES ('NV221466726','0977310098','12323','2024-04-15 21:38:55',1),('NV234534535','012345','123','2024-05-26 19:18:29',1),('NV526111495','0293929','634535','2024-04-15 21:39:57',1),('NV675157503','2929299292','234242','2024-04-15 21:39:29',1);
/*!40000 ALTER TABLE `taikhoan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thuoc`
--

DROP TABLE IF EXISTS `thuoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thuoc` (
  `maThuoc` varchar(45) NOT NULL,
  `tenThuoc` varchar(255) DEFAULT NULL,
  `hanSuDung` varchar(45) DEFAULT NULL,
  `hoatChatChinh` varchar(255) DEFAULT NULL,
  `khoiLuong` varchar(255) DEFAULT NULL,
  `imgUrl` varchar(255) DEFAULT NULL,
  `duongDung` varchar(45) DEFAULT NULL,
  `donViTinh` varchar(45) DEFAULT NULL,
  `nhomHangHoa` varchar(255) DEFAULT NULL,
  `chuongTrinhKhuyenMai` varchar(45) DEFAULT NULL,
  `quyCachDongGoi` varchar(45) DEFAULT NULL,
  `nuocSanXuat` varchar(45) DEFAULT NULL,
  `donGia` double DEFAULT NULL,
  `soLuongTon` int DEFAULT NULL,
  `dieuKienBaoQuan` varchar(255) DEFAULT NULL,
  `thuongHieu` varchar(255) DEFAULT NULL,
  `thuocKeDon` tinyint DEFAULT NULL,
  `trangThai` varchar(255) DEFAULT 'Đang bán',
  PRIMARY KEY (`maThuoc`),
  KEY `fk_donvitinh_idx` (`donViTinh`),
  KEY `fk_nhomhanghoa_idx` (`nhomHangHoa`),
  KEY `fk_nuocsanxuat_idx` (`nuocSanXuat`),
  KEY `fk_CTKM_idx` (`chuongTrinhKhuyenMai`),
  KEY `fk_thuonghieu_idx` (`thuongHieu`),
  CONSTRAINT `fk_CTKM` FOREIGN KEY (`chuongTrinhKhuyenMai`) REFERENCES `chuongtrinhkhuyenmai` (`maCTKM`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_donvitinh` FOREIGN KEY (`donViTinh`) REFERENCES `donvitinh` (`maDonViTinh`),
  CONSTRAINT `fk_nhomhanghoa` FOREIGN KEY (`nhomHangHoa`) REFERENCES `nhomhanghoa` (`maNhom`),
  CONSTRAINT `fk_nuocsanxuat` FOREIGN KEY (`nuocSanXuat`) REFERENCES `nuocsanxuat` (`maNuoc`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_thuonghieu` FOREIGN KEY (`thuongHieu`) REFERENCES `thuonghieu` (`maThuongHieu`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thuoc`
--

LOCK TABLES `thuoc` WRITE;
/*!40000 ALTER TABLE `thuoc` DISABLE KEYS */;
INSERT INTO `thuoc` VALUES ('TH092992922','Chlorpheniramine ','2024-09-12','Chlorpheniramine','4mg/viên','src//imgProduct//Chlorpheniramine .jpg','PO','DVT1','NH13','KM421532747','10 viên/hộp','NSX1',6000,495,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH3453',0,'Đang bán'),('TH101230923','Thuốc Tocemux điều trị tiêu chất nhầy, bệnh lý hô hấp có đờm (10 vỉ x 10 viên)','2024-08-12','Acetylcysteine','200mg/viên','src//imgProduct//Thuốc Tocemux điều trị tiêu chất nhầy, bệnh lý hô hấp có đờm (10 vỉ x 10 viên).jpg','PO','DVT1','NH16',NULL,'10 Vỉ x 10 Viên','NSX1',25000,484,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH353',0,'Đang bán'),('TH120394024','Siro HoAstex OPC điều trị ho, giảm ho trong viêm họng, viêm phế quản (90ml)','2024-07-12','cineol, Húng chanh','90ml','src//imgProduct//Siro HoAstex OPC điều trị ho, giảm ho trong viêm họng, viêm phế quản (90ml).jpg','PO','DVT5','NH17',NULL,'Chai x 90ml','NSX1',25000,425,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH3543',0,'Đang bán'),('TH192023902','Viên sủi Ossizan C 1000mg ','2024-06-12','Acid Ascorbic','1000mg','img.Viên sủi Ossizan C 1000mg .jpg','PO','DVT2','NH3',NULL,'Hộp 10 viên','NSX1',2500,500,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH3453',0,'Đang bán'),('TH209234909','Thuốc mỡ bôi da Agiclovir Agimexpharm','2024-06-12','Aciclovir, Excipients q.s','5g','src//imgProduct//Thuốc mỡ bôi da Agiclovir 5% Agimexpharm.jpg','AAA','DVT2','NH19',NULL,'Tuýp','NSX1',2500,500,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH243',1,'Đang bán'),('TH225484044','Sporal Janssen ','2024-08-12','Itraconazole','100mg/viên','src//imgProduct//Sporal Janssen.jpg ','PO','DVT2','NH15',NULL,'1 Vỉ x 4 Viên','NSX7',2500,965,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH867',0,'Đang bán'),('TH234757777','Escitalopram Tablets','2024-07-12','Escitalopram','10mg/viên','src//imgProduct//Escitalopram 10mg Tablets.jpg','PO','DVT1','NH11',NULL,'30 viên/hộp','NSX',3000,33,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH234',1,'Đang bán'),('TH235494500','Viên trị ho Tussiday OPC điều trị các chứng ho, đau họng, sổ mũi (10 vỉ x 10 viên)','2024-06-12','Eucalyptol, tinh dầu tần dày','10mg/viên','src//imgProduct//Viên trị ho Tussiday OPC điều trị các chứng ho, đau họng, sổ mũi (10 vỉ x 10 viên).jpg','PO','DVT1','NH18',NULL,'10 Vỉ x 10 Viên','NSX1',2000,314,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH456',0,'Đang bán'),('TH235970500','Thuốc Vitamin C 500mg Khapharco điều trị bệnh Scorbut (10 vỉ x 10 viên)','2024-08-12','Acid Ascorbic','500mg/viên','src//imgProduct//Thuốc Vitamin C 500mg Khapharco điều trị bệnh Scorbut (10 vỉ x 10 viên).jpg','PO','DVT1','NH4',NULL,'10 Vỉ x 10 Viên','NSX1',2500,55,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH867',0,'Đang bán'),('TH235984758','Pseudoephedrine 60mg','2024-06-12','Pseudoephedrine','60mg/viên','src//imgProduct//Pseudoephedrine 60mg.jpg','PO','DVT1','NH18',NULL,'24 viên/hộp','NSX1',2500,500,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH4678',0,'Đang bán'),('TH238478392','Diclofenac','2024-07-12','Diclofenac','50mg/viên','src//imgProduct//Diclofenac.jpg','PO','DVT2','NH3',NULL,'20 viên/hộp','NSX2',320000,0,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH894',0,'Hết hàng'),('TH238578848','Levocetirizine','2024-06-12','Levocetirizine','5mg/viên','src//imgProduct//Levocetirizine.jpg','PO','DVT2','NH4',NULL,'30 viên/hộp','NSX2',52000,500,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH123',0,'Đang bán'),('TH239857438','Metoprolol 25mg Tablets','2024-09-12','Metoprolol','25mg/viên','src//imgProduct//Metoprolol 25mg Tablets.jpg','PO','DVT2','NH10',NULL,'30 viên/hộp','NSX',2500,45,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH7373',0,'Đang bán'),('TH243590003','Thuốc nhỏ mắt V.Rohto Vitamin hỗ trợ cải thiện tình trạng giảm thị lực, mắt mờ (13ml)','2024-09-12','Natri chondroitin sulfat','13ml','src//imgProduct//Thuốc nhỏ mắt V.Rohto Vitamin hỗ trợ cải thiện tình trạng giảm thị lực, mắt mờ (13ml).jpg','OU','DVT5','NH11',NULL,'Chai x 13ml','NSX1',25000,33,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH123',0,'Đang bán'),('TH249533490','Kaleorid 600mg LEO phòng ngừa và điều trị giảm kali huyết','2024-09-12','Kali chlorid','600mg','src//imgProduct//Kaleorid 600mg LEO phòng ngừa và điều trị giảm kali huyết.jpg','PO','DVT1','NH6',NULL,'3 Vỉ x 10 Viên','NSX6',3000,44,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH456',0,'Đang bán'),('TH249853788','Warfarin 2mg Tablets','2024-09-12','Warfarin','2mg/viên','src//imgProduct//Warfarin 2mg Tablets.jpg','PO','DVT1','NH10',NULL,'30 viên/hộp','NSX',3000,65,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH3453',0,'Đang bán'),('TH292992902','Ibuprofen','2024-09-12','Ibuprofen','200mg/viên','src//imgProduct//Ibuprofen.jpg','PO','DVT2','NH15',NULL,'10 viên/hộp','NSX1',70000,32,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH3543',0,'Đang bán'),('TH295245892','Guaifenesin 100mg','2024-09-12','Acetaminophen','500mg/viên','imgGuaifenesin 100mg.jpg','PO','DVT1','NH16',NULL,'10 viên/hộp','NSX1',2500,46,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH3543',0,'Đang bán'),('TH323213455','HCQ 200mg Zydus Cadila','2024-09-12','Hydroxychloroquine sulfate','200mg/viên','src//imgProduct//HCQ 200mg Zydus Cadila.jpg','PO','DVT2','NH4',NULL,'10 vỉ x 10 viên','NSX5',2500,435,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH894',0,'Đang bán'),('TH324928430',' Aciclovir 800mg Meyer','2024-09-12','Acyclovir','800mg','src//imgProduct// Aciclovir 800mg Meyer.jpg','PO','DVT2','NH10',NULL,'3 Vỉ x 10 Viên','NSX1',2500,84,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','Th27272',0,'Đang bán'),('TH343904930','Bột pha uống Oresol 245 Domesco ','2024-09-12','Natri clorit, Natri citract dihydrat, Kali clorid,','4,1g','src//imgProduct//Bột pha uống Oresol 245 Domesco .jpg','PO','DVT1','NH4',NULL,'Hộp 20 gói','NSX1',3000,65,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH353',0,'Đang bán'),('TH344597893','Piroxicam','2024-09-12','Piroxicam','20mg/viên','src//imgProduct//Piroxicam.jpg','PO','DVT2','NH6',NULL,'20 viên/hộp','NSX2',85000,19,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH243',0,'Đang bán'),('TH345098436','Viên sủi Vitatrum C BRV điều trị các bệnh do thiếu vitamin C (10 viên)','2024-09-12','Vitamin C','1000mg/viên','src//imgProduct//Viên sủi Vitatrum C BRV điều trị các bệnh do thiếu vitamin C (10 viên).jpg','PO','DVT3','NH5',NULL,'Hộp 10 viên','NSX1',25000,33,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH894',0,'Đang bán'),('TH345734547','Amlodipine','2024-09-12','Amlodipine','5mg/viên','src//imgProduct//Amlodipine.jpg','PO','DVT2','NH9',NULL,'30 viên/hộp','NSX2',65000,35,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH353',0,'Đang bán'),('TH345873859','Omeprazole','2024-09-12','Omeprazole','20mg/viên','src//imgProduct//Omeprazole.jpg','PO','DVT2','NH7',NULL,'14 viên/hộp','NSX2',70000,18,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','Th27272',0,'Đang bán'),('TH345876899','Acetaminophen 500mg Caplets','2024-09-12','Acetaminophen','500mg/viên','src//imgProduct//Acetaminophen 500mg Caplets.jpg','PO','DVT2','NH4',NULL,'20 viên/hộp','NSX',2000,95,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH3543',0,'Đang bán'),('TH345893489','Thuốc nhỏ mắt, nhỏ mũi Natri Clorid 0,9% Pharmedic hỗ trợ rửa mắt, rửa mũi, phụ trị nghẹt mũi, sổ mũi (10ml)','2024-09-12','Natri clorid','10ml','src//imgProduct//Thuốc nhỏ mắt, nhỏ mũi Natri Clorid 0,9% Pharmedic hỗ trợ rửa mắt, rửa mũi, phụ trị nghẹt mũi, sổ mũi (10ml).jpg','OU','DVT5','NH13',NULL,'Chai x 10ml','NSX1',25000,467,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH243',0,'Đang bán'),('TH345984599','Thuốc nhỏ mắt Refresh Tears Allergan giảm khô mắt, mắt đỏ (15ml)','2024-09-12','Natri carboxymethylcellulose','15ml','src//imgProduct//Thuốc nhỏ mắt Refresh Tears Allergan giảm khô mắt, mắt đỏ (15ml).jpg','OU','DVT5','NH14',NULL,'Chai x 15ml','NSX1',25000,54,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','Th27272',0,'Đang bán'),('TH346846133','Xịt họng Otosan Spray Forte hỗ trợ điều trị viêm họng cấp, viêm hô hấp, giảm đau rát họng (30ml)','2024-09-12','Tinh dầu cam hữu cơ','30ml','src//imgProduct//Xịt họng Otosan Spray Forte hỗ trợ điều trị viêm họng cấp, viêm hô hấp, giảm đau rát họng (30ml).jpg','Garg','DVT2','NH3',NULL,'1chai/hộp','NSX4',2500,345,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH867',0,'Đang bán'),('TH347843878','Acetaminophen 500mg','2024-09-12','Guaifenesin','100mg/viên','src//imgProduct//Acetaminophen 500mg.jpg','PO','DVT1','NH13',NULL,'30 viên/hộp','NSX1',3000,23,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','Th27272',0,'Đang bán'),('TH34834783','Pantoprazole 40mg Tablets','2024-09-12','Pantoprazole','40mg/viên','src//imgProduct//Pantoprazole 40mg Tablets.jpg','PO','DVT1','NH1',NULL,'30 viên/hộp','NSX',4000,67,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH894',0,'Đang bán'),('TH348975878','Dextromethorphan 15mg','2024-09-12','Phenylephrine','10mg/viên','src//imgProduct//Dextromethorphan 15mg.jpg','PO','DVT1','NH14',NULL,'24 viên/hộp','NSX1',4000,41,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH3453',0,'Đang bán'),('TH349450903',' Althax 120mg Mediplantex','2024-09-12','Thymomodulin','120mg/viên',' src//imgProduct//Althax 120mg Mediplantex.jpg','PO','DVT1','NH7',NULL,'3 Vỉ x 10 Viên','NSX1',3000,67,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH4678',0,'Đang bán'),('TH349857604','Thuốc Glomoti-M Glomed điều trị triệu chứng buồn nôn, nôn, chướng bụng (10 vỉ x 10 viên)','2024-09-12','Domperidon','10mg/viên','src//imgProduct//Thuốc Glomoti-M Glomed điều trị triệu chứng buồn nôn, nôn, chướng bụng (10 vỉ x 10 viên).jpg','PO','DVT1','NH6',NULL,'Hộp 10 Vỉ x 10 Viên','NSX1',2500,767,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH123',0,'Đang bán'),('TH353474838','Loratadine 10mg Tablets','2024-09-12','Loratadine','10mg/viên','src//imgProduct//Loratadine 10mg Tablets.jpg','PO','DVT1','NH12',NULL,'30 viên/hộp','NSX',2000,39,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH243',0,'Đang bán'),('TH356985388','Aspirin 81mg Enteric Coated Tablets','2024-06-12','Aspirin','81mg/viên','src//imgProduct//Aspirin 81mg Enteric Coated Tablets.jpg','PO','DVT2','NH5',NULL,'36 viên/hộp','NSX',2000,34,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH456',0,'Đang bán'),('TH357697666','Opelomin 6 OPV ','2024-07-12','Ivermectin','6mg','src//imgProduct//Opelomin 6 OPV.jpg','PO','DVT1','NH9',NULL,' 2 vỉ x 2 viên','NSX1',3000,54,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH3453',0,'Đang bán'),('TH365795465','Nimesulide','2024-09-12','Nimesulide','100mg/viên','src//imgProduct//Nimesulide.jpg','PO','DVT1','NH10',NULL,'10 viên/hộp','NSX1',8000,0,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH234',0,'Hết hàng'),('TH365992202','Nimesulide','2024-09-12','Nimesulide','100mg/viên','src//imgProduct//Nimesulide.jpg','PO','DVT1','NH10',NULL,'10 viên/hộp','NSX1',8000,0,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH234',0,'Hết hàng'),('TH383838339','Aspirin','2024-09-12','Aspirin','100mg/viên','src//imgProduct//Aspirin.jpg','PO','DVT2','NH12',NULL,'10 viên/hộp','NSX1',40000,67,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','Th27272',0,'Đang bán'),('TH384588884','Phenylephrine 10mg','2024-09-12','Dextromethorphan','15mg/viên','src//imgProduct//Phenylephrine 10mg.jpg','PO','DVT1','NH15',NULL,'20 viên/hộp','NSX1',2500,42,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH353',0,'Đang bán'),('TH396725989','Levothyroxine 50mcg Tablets','2024-09-12','Levothyroxine','50mcg/viên','src//imgProduct//Levothyroxine 50mcg Tablets.jpg','PO','DVT2','NH7',NULL,'100 viên/hộp','NSX',2000,55,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH234',0,'Đang bán'),('TH425083650','Tinh dầu trẻ em Nasomom-4 Reliv giảm triệu chứng nghẹt mũi, sổ mũi, khò khè, cảm cúm (70ml)','2024-09-12','Natri clorid','70ml','src//imgProduct//Tinh dầu trẻ em Nasomom-4 Reliv giảm triệu chứng nghẹt mũi, sổ mũi, khò khè, cảm cúm (70ml).jpg','PO','DVT2','NH10',NULL,'Hộp 70ml','NSX1',25000,124,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH234',0,'Đang bán'),('TH425098980','Savi Tenofovir 300 ','2024-09-12','Tenofovir disoproxil fumarat','300mg','src//imgProduct//Savi Tenofovir 300 .jpg','PO','DVT2','NH18',NULL,'3 Vỉ x 10 Viên','NSX1',2500,44,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH234',0,'Đang bán'),('TH425874889','Naphazoline 0.1%','2024-09-12','Naphazoline','0.1% trong chai','src//imgProduct//Naphazoline 0.1%.jpg','IN','DVT5','NH19',NULL,'10ml/chai','NSX1',25000,52,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH4678',0,'Đang bán'),('TH425904355',' Revolade 25mg Novartis chống chảy máu do thiếu tiểu cầu trong máu','2024-09-12','Eltrombopag','25mg/viên',' src//imgProduct//Revolade 25mg Novartis chống chảy máu do thiếu tiểu cầu trong máu.jpg','PO','DVT1','NH9',NULL,' 4 Vỉ x 7 Viên','NSX8',3000,95,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH7373',0,'Đang bán'),('TH435098500','Thuốc nhỏ mắt Eyemiru 40 EX điều trị căng mắt, xung huyết kết mạc (15ml)','2024-09-12','Tetrahydrozolin hydrochloride, Neostigmin methylsulfate','15ml','src//imgProduct//Thuốc nhỏ mắt Eyemiru 40 EX điều trị căng mắt, xung huyết kết mạc (15ml).jpg','OU','DVT5','NH12',NULL,'Chai x 15ml','NSX2',25000,216,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH234',0,'Đang bán'),('TH435495888','Hỗn dịch uống Biviantac BRV điều trị triệu chứng ăn không tiêu, đầy hơi (20 gói x 10 ml)','2024-09-12',' Nhôm hydroxyd','10ml','src//imgProduct//Hỗn dịch uống Biviantac BRV điều trị triệu chứng ăn không tiêu, đầy hơi (20 gói x 10 ml).jpg','PO','DVT1','NH8',NULL,'\nHộp 20 Gói','NSX1',2500,78,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH243',0,'Đang bán'),('TH456465455','Cledomox 625 Tenamyd','2024-09-12','Amoxicilina','125mg','src//imgProduct//Cledomox 625 Tenamyd.jpg','PO','DVT2','NH5',NULL,'2 Vỉ x 7 Viên','NSX5',2500,546,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH123',0,'Đang bán'),('TH456789432','Amoxicillin ','2024-09-12','Amoxicillin','500mg/viên','src//imgProduct//Amoxicillin.jpg','PO','DVT1','NH17',NULL,'10 viên/hộp','NSX1',10000,54,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH4678',0,'Đang bán'),('TH458974599','Viên nén Nolvadex-D AstraZeneca điều trị ung thư vú','2024-08-12','Tamoxifen','20mg/viên','src//imgProduct//Viên nén Nolvadex-D AstraZeneca điều trị ung thư vú.jpg','PO','DVT1','NH8',NULL,'3 Vỉ x 10 Viên','NSX8',3000,88,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH4678',0,'Đang bán'),('TH459834598',' Femara 2.5mg Novartis','2024-06-12','Letrozole','2.5mg',' src//imgProduct//Femara 2.5mg Novartis.jpg','PO','DVT1','NH1',NULL,'3 Vỉ x 10 Viên','NSX9',3000,68,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH867',0,'Đang bán'),('TH473829292','Diphenhydramine','2024-09-12','Diphenhydramine','25mg/viên','src//imgProduct//Diphenhydramine.jpg','PO','DVT1','NH19',NULL,'30 viên/hộp','NSX2',36000,65,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH7373',0,'Đang bán'),('TH475920003','Cefixime','2024-09-12','Cefixime','200mg/viên','src//imgProduct//Cefixime.jpg','PO','DVT1','NH16',NULL,'10 viên/hộp','NSX1',12000,88,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH456',0,'Đang bán'),('TH489673132','Azoltel 400mg Stella','2024-09-12','Albendazol','400mg/viên','src//imgProduct//Azoltel 400mg Stella.jpg','PO','DVT1','NH11',NULL,'1 Vỉ x 1 Viên','NSX1',3000,567,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH456',0,'Đang bán'),('TH489749785','Fluconazole Stada 150mg','2024-07-12','Fluconazol','150mg/viên','src//imgProduct//Fluconazole Stada 150mg.jpg','PO','DVT2','NH13',NULL,'1 Vỉ x 1 Viên','NSX1',2500,232,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH456',0,'Đang bán'),('TH489764333','Fugacar Janssen không vị ','2024-09-12','Mebendazole','500mg/viên','src//imgProduct//Fugacar Janssen không vị.jpg','PO','DVT2','NH12',NULL,'1 Vỉ x 1 Viên','NSX7',2500,87,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH4678',0,'Đang bán'),('TH492857499','Metronidazole 250mg Tablets','2024-09-12','Metronidazole','250mg/viên','src//imgProduct//Metronidazole 250mg Tablets.jpg','PO','DVT1','NH12',NULL,'30 viên/hộp','NSX',4000,54,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH4678',0,'Đang bán'),('TH498024489','Bột pha uống Oresol 245 DHG Pharma ','2024-09-12','Natri clorid, Natri citrat','4,1g','src//imgProduct//Bột pha uống Oresol 245 DHG Pharma .jpg','PO','DVT1','NH5',NULL,'Hộp 20 gói','NSX1',3000,97,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH3543',0,'Đang bán'),('TH546451323','Cledomox 1000 Tenamyd','2024-09-12','Amoxicillin','875mg','src//imgProduct//Cledomox 1000 Tenamyd.jpg','PO','DVT1','NH8',NULL,'2 Vỉ x 7 Viên','NSX5',3000,88,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','Th27272',0,'Đang bán'),('TH564239874','Gliclazide ','2024-09-12','Gliclazide','80mg/viên','src//imgProduct//Gliclazide .jpg','PO','DVT1','NH1',NULL,'10 viên/hộp','NSX1',10000,34,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH123',0,'Đang bán'),('TH564646465','Lecifex 500mg Abbott ','2024-09-12','Levofloxacin','500mg/viên','src//imgProduct//Lecifex 500mg Abbott .jpg','PO','DVT2','NH6',NULL,'2 vỉ x 10 viên','NSX1',2500,665,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH234',0,'Đang bán'),('TH564897536','Domperidone','2024-07-12','Domperidone','10mg/viên','src//imgProduct//Domperidone.jpg','PO','DVT2','NH11',NULL,'10 viên/hộp','NSX1',70000,65,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH243',0,'Đang bán'),('TH576893245','Paracetamol','2024-09-12','Paracetamol','500mg/viên','src//imgProduct//Paracetamol.jpg','PO','DVT2','NH14',NULL,'10 viên/hộp','NSX1',50000,76,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH353',0,'Đang bán'),('TH653897340','Thuốc Euxamus 200mg Euvipharm tiêu chất nhầy trong bệnh nhầy nhớt (10 vỉ x 10 viên)','2024-09-12','Acetylcysteine','200mg/viên','src//imgProduct//Thuốc Euxamus 200mg Euvipharm tiêu chất nhầy trong bệnh nhầy nhớt (10 vỉ x 10 viên).jpg','PO','DVT1','NH3',NULL,'10 Vỉ x 10 Viên','NSX1',2000,235,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH7373',0,'Đang bán'),('TH654564646','Bột Auclanityl 500/62.5mg Tipharco','2024-09-12','Amoxicilina','3.8g','src//imgProduct//Bột Auclanityl 500/62.5mg Tipharco.jpg','PO','DVT2','NH7',NULL,'12 gói x 3,8g','NSX1',2500,33,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH243',0,'Đang bán'),('TH659689458','Moxifloxacin ','2024-09-12','Moxifloxacin','400mg/viên','src//imgProduct//Moxifloxacin .jpg','PO','DVT2','NH8',NULL,'10 viên/hộp','NSX2',100000,46,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH3453',0,'Đang bán'),('TH743874358','Fexofenadine','2024-09-12','Fexofenadine','120mg/viên','src//imgProduct//Fexofenadine.jpg','PO','DVT2','NH10',NULL,'20 viên/hộp','NSX2',44000,33,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH867',0,'Đang bán'),('TH758493827','Chlorpheniramine ','2024-09-12','Chlorpheniramine','4mg/viên','src//imgProduct//Chlorpheniramine .jpg','PO','DVT1','NH13',NULL,'10 viên/hộp','NSX1',6000,44,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH3453',0,'Đang bán'),('TH785932029','Ibuprofen','2024-09-12','Ibuprofen','200mg/viên','src//imgProduct//Ibuprofen.jpg','PO','DVT2','NH15',NULL,'10 viên/hộp','NSX1',70000,32,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH3543',0,'Đang bán'),('TH789313333','Fugacar Janssen hương socola','2024-09-12','Mebendazole','500mg/viên','src//imgProduct//Fugacar Janssen hương socola.jpg','PO','DVT1','NH1',NULL,'1 Vỉ x 1 Viên','NSX1',3000,55,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH353',0,'Đang bán'),('TH833993932','Gliclazide ','2024-09-12','Gliclazide','80mg/viên','src//imgProduct//Gliclazide .jpg','PO','DVT1','NH1',NULL,'10 viên/hộp','NSX1',10000,34,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH123',0,'Đang bán'),('TH834978898','Fluoxetine 20mg Capsules','2024-09-12','Prozac','20mg/viên','src//imgProduct//Fluoxetine 20mg Capsules.jpg','PO','DVT1','NH10',NULL,'28 viên/hộp','NSX',5000,100,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH123',0,'Đang bán'),('TH845493821','Simvastatin 20mg Tablets','2024-08-12','Simvastatin','20mg/viên','src//imgProduct//Simvastatin 20mg Tablets.jpg','PO','DVT2','NH6',NULL,'30 viên/hộp','NSX',2000,23,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH4678',0,'Đang bán'),('TH856984573','Ibuprofen 200mg Tablets','2024-08-12','Ibuprofen','200mg/viên','src//imgProduct//Ibuprofen 200mg Tablets.jpg','PO','DVT1','NH3',NULL,'24 viên/hộp','NSX',2000,86,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH353',0,'Đang bán'),('TH892187135','Clarithromycin ','2024-09-12','Clarithromycin','250mg/viên','src//imgProduct//Clarithromycin .jpg','PO','DVT2','NH1',NULL,'14 viên/hộp','NSX2',80000,21,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH3543',0,'Đang bán'),('TH893403400','Thuốc Medi-Ambroxol Medisun tiêu chất nhầy đường hô hấp (30 ống x 5ml)','2024-06-12','Ambroxol hydroclorid','5ml','src//imgProduct//Thuốc Medi-Ambroxol Medisun tiêu chất nhầy đường hô hấp (30 ống x 5ml).jpg','PO','DVT6','NH19',NULL,'Hộp 6 Vỉ x 5 Ống x 5ml','NSX1',25000,123,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH4678',0,'Đang bán'),('TH897458974','Ranitidine 150mg Tablets','2024-09-12','Ranitidine','150mg/viên','src//imgProduct//Ranitidine 150mg Tablets.jpg','PO','DVT1','NH14',NULL,'30 viên/hộp','NSX',3000,83,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH867',0,'Đang bán'),('TH901222222',' Griseofulvin 500mg Vidipha','2024-09-12','Griseofulvin','500mg/viên',' src//imgProduct//Griseofulvin 500mg Vidipha.jpg','PO','DVT2','NH16',NULL,'2 Vỉ x 10 Viên','NSX1',2500,45,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH894',0,'Đang bán'),('TH903454389','Citalopram 20mg Tablets','2024-09-12','Citalopram','20mg/viên','src//imgProduct//Citalopram 20mg Tablets.jpg','PO','DVT1','NH19',NULL,'30 viên/hộp','NSX',4000,55,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','Th27272',0,'Đang bán'),('TH908070654','Enrofloxacin','2024-09-12','Enrofloxacin','50mg/viên','src//imgProduct//Enrofloxacin.jpg','PO','DVT2','NH18',NULL,'10 viên/hộp','NSX1',150000,34,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH456',0,'Đang bán'),('TH919193484','Levocetirizine 5mg','2024-09-12','Levocetirizine','5mg/viên','src//imgProduct//Levocetirizine 5mg.jpg','PO','DVT1','NH17',NULL,'30 viên/hộp','NSX1',2500,44,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH456',0,'Đang bán'),('TH923402030','Thuốc nhỏ mắt V.Rohto For Kids giảm mỏi mắt, đỏ mát, ngứa mắt (13ml)','2024-07-12','Clorpheniramin maleat, L-Aspartate','13ml','src//imgProduct//Thuốc nhỏ mắt V.Rohto For Kids giảm mỏi mắt, đỏ mát, ngứa mắt (13ml).jpg','OU','DVT5','NH15',NULL,'Chai x 13ml','NSX1',2000,34,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH3453',0,'Đang bán'),('TH923478358','Metformin 500mg Tablets','2024-09-12','Metformin','500mg/viên','src//imgProduct//Metformin 500mg Tablets.jpg','PO','DVT2','NH8',NULL,'60 viên/hộp','NSX',2000,75,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH7373',0,'Đang bán'),('TH924045043','Thuốc nhỏ mắt V.Rohto Cool (12ml) điều trị mỏi mắt, đỏ mắt, ngứa mắt','2024-09-12','Naphazolin hydrochlorid','12ml','src//imgProduct//Thuốc nhỏ mắt V.Rohto Cool (12ml) điều trị mỏi mắt, đỏ mắt, ngứa mắt.jpg','OU','DVT5','NH10',NULL,'Chai x 12ml','NSX1',25000,45,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH894',0,'Đang bán'),('TH925892735','Cetirizine 10mg Tablets','2024-08-12','Cetirizine','10mg/viên','src//imgProduct//Cetirizine 10mg Tablets.jpg','PO','DVT2','NH9',NULL,'30 viên/hộp','NSX',2000,43,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH867',0,'Đang bán'),('TH929282882','Cefixime','2024-09-12','Cefixime','200mg/viên','src//imgProduct//Cefixime.jpg','PO','DVT1','NH16',NULL,'10 viên/hộp','NSX1',12000,88,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH456',0,'Đang bán'),('TH932020929','Paracetamol','2024-09-12','Paracetamol','500mg/viên','src//imgProduct//Paracetamol.jpg','PO','DVT2','NH14',NULL,'10 viên/hộp','NSX1',50000,76,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH353',0,'Đang bán'),('TH934854598','Furosemide 40mg Tablets','2024-09-12','Furosemide','40mg/viên','src//imgProduct//Furosemide 40mg Tablets.jpg','PO','DVT1','NH16',NULL,'30 viên/hộp','NSX',3000,76,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH123',0,'Đang bán'),('TH93845045','Thuốc Vomina Plus 50mg Medipharco phòng và điều trị triệu chứng buồn nôn, chóng mặt khi say tàu xe (25 vỉ x 4 viên)','2024-07-12','Dimenhydrinate','50mg/viên','src//imgProduct//Thuốc Vomina Plus 50mg Medipharco phòng và điều trị triệu chứng buồn nôn, chóng mặt khi say tàu xe (25 vỉ x 4 viên).jpg','PO','DVT1','NH7',NULL,'Hộp 25 Vỉ x 4 Viên','NSX1',2500,75,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH234',0,'Đang bán'),('TH939393933','Domperidone','2024-09-12','Domperidone','10mg/viên','src//imgProduct//Domperidone.jpg','PO','DVT2','NH11',NULL,'10 viên/hộp','NSX1',70000,65,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH243',0,'Đang bán'),('TH939834888','Diazepam 5mg Tablets','2024-09-12','Diazepam','5mg/viên','src//imgProduct//Diazepam 5mg Tablets.jpg','PO','DVT2','NH15',NULL,'30 viên/hộp','NSX',4000,64,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH894',0,'Đang bán'),('TH94854389','Amoxicillin 500mg Capsules','2024-09-12','Amoxicillin','500mg/viên','src//imgProduct//Amoxicillin 500mg Capsules.jpg','PO','DVT1','NH11',NULL,'30 viên/hộp','NSX',3000,38,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH4678',0,'Đang bán'),('TH967897535','Augtipha 625mg Tipharco ','2024-09-12','Amoxicillin','625mg','src//imgProduct//Augtipha 625mg Tipharco.jpg','PO','DVT2','NH14',NULL,'2 Vỉ x 10 Viên','NSX1',2500,55,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH7373',0,'Đang bán'),('TH983474878','Alprazolam Tablets','2024-09-12','Xanax','1mg/viên','src//imgProduct//Alprazolam 1mg Tablets.jpg','PO','DVT1','NH18',NULL,'30 viên/hộp','NSX',6000,0,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH243',1,'Ngừng bán'),('TH984354989','Tramadol 50mg Capsules','2024-09-12','Tramadol','50mg/viên','src//imgProduct//Tramadol 50mg Capsules.jpg','PO','DVT1','NH17',NULL,'30 viên/hộp','NSX',4000,43,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH234',0,'Đang bán'),('TH984598984','Atenolol 50mg Tablets','2024-09-12','Atenolol','50mg/viên','src//imgProduct//Atenolol 50mg Tablets.jpg','PO','DVT1','NH13',NULL,'30 viên/hộp','NSX',5000,39,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH7373',0,'Đang bán'),('TH986553385','Zentel Albendazole 200mg GSK ','2024-07-12','Albendazole','200mg/viên','src//imgProduct//Zentel Albendazole 200mg GSK.jpg ','PO','DVT1','NH10',NULL,' 1 Vỉ x 2 Viên','NSX1',3000,45,'Nhiệt độ dưới 30°C, tránh ánh sáng trực tiếp','TH3543',0,'Đang bán'),('TH987345788','Prednisone','2024-09-12','Prednisone','10mg/viên','src//imgProduct//Prednisone.jpg','PO','DVT1','NH10',NULL,'30 viên/hộp','NSX',3000,26,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH456',1,'Ngừng bán'),('TH987564357','Aspirin','2024-06-12','Aspirin','100mg/viên','src//imgProduct//Aspirin.jpg','PO','DVT2','NH12',NULL,'10 viên/hộp','NSX1',40000,67,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','Th27272',0,'Đang bán'),('TH990324984','Tenofovir STADA 300mg','2024-09-12','Tenofovir disoproxil fumarat','300mg','src//imgProduct//Tenofovir STADA 300mg.jpg','PO','DVT2','NH17',NULL,'3 Vỉ x 10 Viên','NSX1',2500,55,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH123',0,'Đang bán'),('TH992929283','Lansoprazole','2024-09-12','Lansoprazole','15mg/viên','src//imgProduct//Lansoprazole.jpg','PO','DVT2','NH5',NULL,'14 viên/hộp','NSX2',64000,16,'Nhiệt độ dưới 25°C, tránh ánh sáng trực tiếp','TH234',1,'Ngừng bán');
/*!40000 ALTER TABLE `thuoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thuonghieu`
--

DROP TABLE IF EXISTS `thuonghieu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thuonghieu` (
  `maThuongHieu` varchar(45) NOT NULL,
  `tenThuongHieu` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`maThuongHieu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thuonghieu`
--

LOCK TABLES `thuonghieu` WRITE;
/*!40000 ALTER TABLE `thuonghieu` DISABLE KEYS */;
INSERT INTO `thuonghieu` VALUES ('TH123','Công ty TNHH Việt Nam'),('TH234','NOVARTIS'),('TH243','Tenormin'),('Th27272','MEDOPHARM'),('TH3453','Enro'),('TH353','Coumadin'),('TH3543','Ultram'),('TH456','ABBVIE'),('TH4678','Deltasone'),('TH576',' MERCK'),('TH7373','STELLA'),('TH867','PFIZER'),('TH894','CHI NHÁNH CÔNG TY CỔ PHẦN DƯỢC PHẨM TRƯỜNG THỌ');
/*!40000 ALTER TABLE `thuonghieu` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-26 20:20:59
