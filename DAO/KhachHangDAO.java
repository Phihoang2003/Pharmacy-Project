package DAO;

import DTO.KhachHang;
import DTO.NhomKhachHang;
import Interface.DaoInterface;
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
        int result=0;
        try {
            Connection con = (Connection) JDBCUtil.getConnection();
            String sql="INSERT INTO `khachhang`(`maKhachHang`, `tenKhachHang`,`soDienThoai`, `diaChi`,`nhomKhachHang`,`trangThai`) VALUES (?,?,?,?,?,1)";
            PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
            pst.setString(1,t.getMaKhachHang());
            pst.setString(2,t.getHoTen());
            pst.setString(3,t.getSdt());
            pst.setString(4,t.getDiaChi());
            pst.setInt(5,t.getGioiIinh());
            result=pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        }catch(SQLException ex){
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result>0;
    }

    @Override
    public boolean update(KhachHang t) {
        int result=0;
        try{
            Connection con=(Connection) JDBCUtil.getConnection();
            String sql="UPDATE `khachhang` SET `maKhachHang`=?,`tenKhachHang`=?,`diaChi`=?,`soDienThoai`=?,`nhomKhachHang`=? WHERE maKhachHang=?";
            PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
            pst.setString(1,t.getMaKhachHang());
            pst.setString(2,t.getHoTen());
            pst.setString(3,t.getDiaChi());
            pst.setString(4,t.getSdt());
            pst.setInt(5,t.getGioiIinh());
            pst.setString(6,t.getMaKhachHang());
            result=pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        }catch (SQLException ex){
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return result>0;
    }




    @Override

public ArrayList<KhachHang> selectAll() {
    ArrayList<KhachHang> list = new ArrayList<>();
    try {
        Connection con = JDBCUtil.getConnection();
        String sql = "SELECT * FROM `khachhang` k JOIN nhomkhachhang nk ON k.nhomKhachHang=nk.maNhom WHERE `trangThai`=1";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            KhachHang khachHangDTO = new KhachHang();
            khachHangDTO.setMaKhachHang(rs.getString("maKhachHang"));
            khachHangDTO.setHoTen(rs.getString("tenKhachHang"));
            khachHangDTO.setDiaChi(rs.getString("diaChi"));
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
                khachHangDTO.setDiaChi(rs.getString("diaChi"));
                khachHangDTO.setSdt(rs.getString("soDienThoai"));
                khachHangDTO.setGioiTinh(rs.getInt("gioiTinh"));

            }
            JDBCUtil.closeConnection(con);
        }catch(SQLException ex){

            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return khachHangDTO;
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
                khachHangDTO.setDiaChi(rs.getString("diaChi"));
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
