package DAO;

import DTO.KhachHang;
import Interface.KhachHang_Interface;
import config.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KhachHangDAO implements KhachHang_Interface {
    public static KhachHangDAO getInstance() {
        return new KhachHangDAO();
    }
    @Override
    public boolean insert(KhachHang t) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO `khachhang`(`maKhachHang`, `tenKhachHang`,`soDienThoai`, `gioiTinh`, `ngayThamGia`) VALUES (?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);

            java.util.Date utilDate = t.getNgayThamGia();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            pst.setString(1, t.getMaKhachHang());
            pst.setString(2, t.getHoTen());
            pst.setString(3, t.getSdt());
            pst.setInt(4, t.getGioiIinh());
            pst.setDate(5, sqlDate);

            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result > 0;
    }

    @Override
    public boolean update(KhachHang t) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE `khachhang` SET `tenKhachHang`=?,`soDienThoai`=?,`gioiTinh`=? WHERE maKhachHang=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getHoTen());
            pst.setString(2, t.getSdt());
            pst.setInt(3, t.getGioiIinh());
            pst.setString(4, t.getMaKhachHang());
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return result > 0;
    }




    @Override
    public ArrayList<KhachHang> selectAll() {
        ArrayList<KhachHang> list = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM `khachhang`";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                KhachHang khachHangDTO = new KhachHang();
                khachHangDTO.setMaKhachHang(rs.getString("maKhachHang"));
                khachHangDTO.setHoTen(rs.getString("tenKhachHang"));
                khachHangDTO.setDiemTichLuy(rs.getInt("diemTichLuy"));
                khachHangDTO.setSdt(rs.getString("soDienThoai"));
                khachHangDTO.setGioiTinh(rs.getInt("gioiTinh"));

                list.add(khachHangDTO);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
public boolean capNhatDiemTichLuy(String maKH, int diemTichLuy) {
    int result = 0;
    try {
        Connection con = JDBCUtil.getConnection();
        String sql = "UPDATE `khachhang` SET `diemTichLuy` = ? WHERE `maKhachHang` = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, diemTichLuy);
        pst.setString(2, maKH);
        result = pst.executeUpdate();
        JDBCUtil.closeConnection(con);
    } catch (SQLException ex) {
        Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return result > 0;
}

    @Override
    public KhachHang selectById(String t) {
        KhachHang khachHangDTO=null;
        try{
            Connection con=JDBCUtil.getConnection();
            String sql="SELECT * FROM `khachhang` WHERE `maKhachHang`=?";
            PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
            pst.setString(1,t);
            ResultSet rs= pst.executeQuery();
            while (rs.next()){
                khachHangDTO=new KhachHang();
                khachHangDTO.setMaKhachHang(rs.getString("maKhachHang"));
                khachHangDTO.setHoTen(rs.getString("tenKhachHang"));
                khachHangDTO.setDiemTichLuy(rs.getInt("diemTichLuy"));
                khachHangDTO.setSdt(rs.getString("soDienThoai"));
                khachHangDTO.setGioiTinh(rs.getInt("gioiTinh"));

            }
            JDBCUtil.closeConnection(con);
        }catch(SQLException ex){

            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return khachHangDTO;
    }

    public KhachHang kiemTraLapThongTin(KhachHang khMoi) {
        KhachHang kh = null;
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        try {
            connection = JDBCUtil.getConnection();
            String sql = "SELECT * FROM khachhang WHERE tenKhachHang = ? AND gioiTinh = ? AND soDienThoai = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, khMoi.getHoTen());
            statement.setInt(2, khMoi.getGioiIinh());
            statement.setString(3, khMoi.getSdt());

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                kh = new KhachHang();
                kh.setHoTen(resultSet.getString("hoTen"));
                kh.setGioiTinh(resultSet.getInt("gioiTinh"));
                kh.setSdt(resultSet.getString("sdt"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return kh;
    }



    @Override
    public String getAutoIncrement() {
        Random random = new Random();
        int number = random.nextInt(900000000) + 100000000; // This will always generate 6-digit numbers
        return "KH" + number;
    }

    @Override
    public KhachHang timKiemTheoSDT(String sdt) {
        KhachHang khachHangDTO=null;
        try{
            Connection con=JDBCUtil.getConnection();
            String sql="SELECT * FROM `khachhang` WHERE `soDienThoai`=?";
            PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
            pst.setString(1,sdt);
            ResultSet rs= pst.executeQuery();
            while (rs.next()){
                khachHangDTO=new KhachHang();
                khachHangDTO.setMaKhachHang(rs.getString("maKhachHang"));
                khachHangDTO.setHoTen(rs.getString("tenKhachHang"));
                khachHangDTO.setDiemTichLuy(rs.getInt("diemTichLuy"));
                khachHangDTO.setSdt(rs.getString("soDienThoai"));
                khachHangDTO.setGioiTinh(rs.getInt("gioiTinh"));
            }
            JDBCUtil.closeConnection(con);
        }catch(SQLException ex){

            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return khachHangDTO;
    }


}
