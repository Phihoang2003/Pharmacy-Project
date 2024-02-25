package DAO;

import DTO.*;
import Interface.HoaDon_Interface;

import java.sql.ResultSet;
import java.util.ArrayList;
import config.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
public class HoaDonDAO implements HoaDon_Interface {
    public static HoaDonDAO getInstance() {
        return new HoaDonDAO();
    }
    @Override
    public boolean themHoaDon(HoaDon hoaDon, ArrayList<ChiTietHoaDon> danhSachCTHD) {

        int result = 0;
        try{
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO `hoadon`(`maHD`, `nhanVien`, `chuongTrinhKM`, `tongTien`, `tienKhuyenMai`, `tienThanhToan`, `ngayLapHoaDon`,`khachHang`, `tinhTrang` ) VALUES (?,?,?,?,?,?,?,?,1)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, hoaDon.getMaHD());
            pst.setString(2, hoaDon.getNhanVien().getMaNhanVien());
            pst.setString(3, hoaDon.getChuongTrinhKM().getMaCTKM());
            pst.setDouble(4, hoaDon.getTongTien());
            pst.setDouble(5, hoaDon.getTienKhuyenMai());
            pst.setDouble(6, hoaDon.getTienThanhToan());
            pst.setDate(7, hoaDon.getNgayLapHD());
            pst.setString(8, hoaDon.getKhachHang().getMaKhachHang());
            result = pst.executeUpdate();
            if(result<0){
                return false;
            }
            ChiTietHoaDonDAO cthd_dao = new ChiTietHoaDonDAO();
            for(ChiTietHoaDon cthd:danhSachCTHD){
                if(!cthd_dao.themChiTietHoaDon(cthd)){
                    return false;
                }
            }

        }catch (SQLException ex){
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result > 0;
    }

    @Override
    public HoaDon selectByMaHD(String maHD) {
        HoaDon hoaDon=null;
        try {
            Connection con=JDBCUtil.getConnection();
            String sql = "SELECT * FROM hoadon WHERE maHD = ?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, maHD);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                hoaDon = new HoaDon();
                hoaDon.setMaHD(rs.getString("maHD"));
                hoaDon.setNhanVien(new NhanVienDTO(rs.getString("nhanVien")));
                hoaDon.setChuongTrinhKM(new ChuongTrinhKhuyenMai(rs.getString("chuongTrinhKM")));
                hoaDon.setTongTien(rs.getDouble("tongTien"));
                hoaDon.setTienKhuyenMai();
                hoaDon.setTienThanhToan();
                hoaDon.setNgayLapHD(rs.getDate("ngayLap"));
                hoaDon.setTinhTrang(rs.getInt("tinhTrang"));
                hoaDon.setKhachHang(new KhachHangDTO(rs.getString("khachHang")));
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hoaDon;
    }
    public String getAutoIncrement() {
        Random random = new Random();
        int number = random.nextInt(900000000) + 100000000; // This will always generate 6-digit numbers
        return "HD" + number;
    }

    @Override
    public boolean luuTamHoaDon(HoaDon hoaDon, ArrayList<ChiTietHoaDon> danhSachCTHD) {
        int result = 0;
        try{
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO `hoadon`(`maHD`, `nhanVien`, `chuongTrinhKM`, `tongTien`, `tienKhuyenMai`, `tienThanhToan`, `ngayLapHoaDon`,`khachHang`, `tinhTrang` ) VALUES (?,?,?,?,?,?,?,?,0)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, hoaDon.getMaHD());
            pst.setString(2, hoaDon.getNhanVien().getMaNhanVien());
            pst.setString(3, hoaDon.getChuongTrinhKM().getMaCTKM());
            pst.setDouble(4, hoaDon.getTongTien());
            pst.setDouble(5, hoaDon.getTienKhuyenMai());
            pst.setDouble(6, hoaDon.getTienThanhToan());
            pst.setDate(7, hoaDon.getNgayLapHD());
            pst.setString(8, hoaDon.getKhachHang().getMaKhachHang());
            result = pst.executeUpdate();
            if(result<0){
                return false;
            }
            ChiTietHoaDonDAO cthd_dao = new ChiTietHoaDonDAO();
            for(ChiTietHoaDon cthd:danhSachCTHD){
                if(!cthd_dao.themChiTietHoaDon(cthd)){
                    return false;
                }
            }

        }catch (SQLException ex){
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result > 0;
    }

    @Override
    public boolean themHoaDonLuuTam(HoaDon hoaDon, ArrayList<ChiTietHoaDon> danhSachCTHD) {
        int result = 0;
        try{
            Connection con = JDBCUtil.getConnection();
            String sql = "Update hoadon set nhanVien=?, chuongTrinhKM=?, ngayLapHoaDon=?, tienKhuyenMai=?, tongTien=?, tienThanhToan=?, tinhTrang=? where maHD=? and khachHang=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, hoaDon.getNhanVien().getMaNhanVien());
            pst.setString(2, hoaDon.getChuongTrinhKM().getMaCTKM());
            pst.setDate(3, hoaDon.getNgayLapHD());
            pst.setDouble(4, hoaDon.getTienKhuyenMai());
            pst.setDouble(5, hoaDon.getTongTien());
            pst.setDouble(6, hoaDon.getTienThanhToan());
            pst.setInt(7, 1);
            pst.setString(8, hoaDon.getMaHD());
            pst.setString(9, hoaDon.getKhachHang().getMaKhachHang());
            result = pst.executeUpdate();
            if(result<0){
                return false;
            }
            ChiTietHoaDonDAO cthd_dao = new ChiTietHoaDonDAO();
            boolean kq=cthd_dao.xoaChiTietHoaDon(hoaDon.getMaHD());
            if(kq){
                for(ChiTietHoaDon cthd:danhSachCTHD){
                    if(!cthd_dao.themChiTietHoaDon(cthd)){
                        return false;
                    }
                }
            }
            else{
                return false;
            }

        }catch (SQLException ex){
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result > 0;

    }

    @Override
    public HoaDon getHoaDonTheoMaHD(String maHD) {
        HoaDon hoadon=null;
        try{
            Connection con=JDBCUtil.getConnection();
            String sql = "SELECT * FROM hoadon WHERE maHD = ?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, maHD);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                hoadon = new HoaDon();
                hoadon.setMaHD(rs.getString("maHD"));
                hoadon.setNhanVien(new NhanVienDTO(rs.getString("nhanVien")));
                hoadon.setChuongTrinhKM(new ChuongTrinhKhuyenMai(rs.getString("chuongTrinhKM")));
                hoadon.setTongTien(rs.getDouble("tongTien"));
                hoadon.setTienKhuyenMai();
                hoadon.setTienThanhToan();
                hoadon.setNgayLapHD(rs.getDate("ngayLapHoaDon"));
                hoadon.setTinhTrang(rs.getInt("tinhTrang"));
                hoadon.setKhachHang(new KhachHangDTO(rs.getString("khachHang")));
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hoadon;
    }
}
