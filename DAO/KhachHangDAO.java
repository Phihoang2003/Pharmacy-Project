package DAO;

import DTO.KhachHangDTO;
import config.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KhachHangDAO implements DaoInterface<KhachHangDTO> {
    public static KhachHangDAO getInstance() {
        return new KhachHangDAO();
    }
    @Override
    public int insert(KhachHangDTO t) {
        int result=0;
        try {
            Connection con = (Connection) JDBCUtil.getConnection();
            String sql="INSERT INTO `khachhang`(`maKhachHang`, `tenKhachHang`,`soDienThoai`, `diaChi`,`nhomKhachHang`,`trangThai`) VALUES (?,?,?,?,?,1)";
            PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
            pst.setString(1,t.getMaKhachHang());
            pst.setString(2,t.getHoTen());
            pst.setString(3,t.getSdt());
            pst.setString(4,t.getDiaChi());
            pst.setString(5,t.getNhomKhachHang().getMaNhom());
            result=pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        }catch(SQLException ex){
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int update(KhachHangDTO t) {
        int result=0;
        try{
            Connection con=(Connection) JDBCUtil.getConnection();
            String sql="UPDATE `khachhang` SET `maKhachHang`=?,`tenKhachHang`=?,`diaChi`=?,`soDienThoai`=?,`nhomKhachHang`=? WHERE maKhachHang=?";
            PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
            pst.setString(1,t.getMaKhachHang());
            pst.setString(2,t.getHoTen());
            pst.setString(3,t.getDiaChi());
            pst.setString(4,t.getSdt());
            pst.setString(5,t.getNhomKhachHang().toString());
            pst.setString(6,t.getMaKhachHang());
            result=pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        }catch (SQLException ex){
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return result;
    }

    @Override
    public int delete(String t) {
        int result=0;
        try{
            Connection con=(Connection) JDBCUtil.getConnection();
            String sql="UPDATE `khachhang`SET `trangThai`=0 WHERE `maKhachHang`=?";
            PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
            pst.setString(1,t);
            result=pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        }catch(SQLException ex){
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public ArrayList<KhachHangDTO> selectAll() {
        return null;
    }

    @Override
    public KhachHangDTO selectById(String t) {
        return null;
    }



    @Override
    public String getAutoIncrement() {
        Random random = new Random();
        int number = random.nextInt(900000000) + 100000000; // This will always generate 6-digit numbers
        return "NV" + number;
    }
}
