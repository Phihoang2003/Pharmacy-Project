package DAO;

import DTO.KhachHangDTO;
import DTO.NhomKhachHangDTO;
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
            pst.setString(5,t.getNhomKhachHang().getMaNhom());
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
    ArrayList<KhachHangDTO> list = new ArrayList<>();
    try {
        Connection con = JDBCUtil.getConnection();
        String sql = "SELECT * FROM `khachhang` k JOIN nhomkhachhang nk ON k.nhomKhachHang=nk.maNhom WHERE `trangThai`=1";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            KhachHangDTO khachHangDTO = new KhachHangDTO();
            khachHangDTO.setMaKhachHang(rs.getString("maKhachHang"));
            khachHangDTO.setHoTen(rs.getString("tenKhachHang"));
            khachHangDTO.setDiaChi(rs.getString("diaChi"));
            khachHangDTO.setSdt(rs.getString("soDienThoai"));
            NhomKhachHangDTO nhomKhachHangDTO = new NhomKhachHangDTO();
            nhomKhachHangDTO.setMaNhom(rs.getString("maNhom"));
            nhomKhachHangDTO.setTenNhom(rs.getString("tenNhom"));
            nhomKhachHangDTO.setGhiChu(rs.getString("ghiChu"));
            khachHangDTO.setNhomKhachHang(nhomKhachHangDTO);


            list.add(khachHangDTO);
        }
        JDBCUtil.closeConnection(con);
    } catch (SQLException ex) {
        Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
}

    @Override
    public KhachHangDTO selectById(String t) {
        KhachHangDTO khachHangDTO=null;
        try{
            Connection con=JDBCUtil.getConnection();
            String sql="SELECT * FROM `khachhang` WHERE `maKhachHang`=?";
            PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
            pst.setString(1,t);
            ResultSet rs= pst.executeQuery();
            while (rs.next()){
                khachHangDTO=new KhachHangDTO();
                khachHangDTO.setMaKhachHang(rs.getString("maKhachHang"));
                khachHangDTO.setHoTen(rs.getString("tenKhachHang"));
                khachHangDTO.setDiaChi(rs.getString("diaChi"));
                khachHangDTO.setSdt(rs.getString("soDienThoai"));
                khachHangDTO.setNhomKhachHang(new NhomKhachHangDTO(rs.getString("nhomKhachHang")));

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
        return "NV" + number;
    }
}
