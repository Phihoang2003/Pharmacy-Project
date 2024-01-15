package DAO;

import DTO.KhachHangDTO;
import config.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
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
            String sql="INSERT INTO `khachhang`(`maKhachHang`, `tenKhachHang`, `diaChi`,`soDienThoai`,`nhomKhachHang`,`trangThai`) VALUES (?,?,?,?,?,1)";
            PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1,t.getMaKhachHang());
            pst.setString(2,t.getHoTen());
            pst.setString(3,t.getDiaChi());
            pst.setString(4,t.getSdt());
            pst.setInt(5,t.getNhomKhachHang());
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
            pst.setInt(1,t.getMaKhachHang());
            pst.setString(2,t.getHoTen());
            pst.setString(3,t.getDiaChi());
            pst.setString(4,t.getSdt());
            pst.setInt(5,t.getNhomKhachHang());
            pst.setInt(6,t.getMaKhachHang());
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
        ArrayList<KhachHangDTO> result=new ArrayList<KhachHangDTO>();
        try{
            Connection con=(Connection) JDBCUtil.getConnection();
            String sql="SELECT * FROM khachhang WHERE trangThai=1";
            PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
            ResultSet rs=(ResultSet) pst.executeQuery();
            while (rs.next()){
                int maKhachHang=rs.getInt("maKhachHang");
                String hoTen=rs.getString("tenKhachHang");
                String diaChi=rs.getString("diaChi");
                String sdt=rs.getString("soDienThoai");
                int nhomKhachHang=rs.getInt("nhomKhachHang");
                Date ngayThamGia=rs.getDate("ngayThamGia");
                KhachHangDTO kh=new KhachHangDTO(maKhachHang,hoTen,diaChi,sdt,ngayThamGia,nhomKhachHang);
                result.add(kh);

            }
            JDBCUtil.closeConnection(con);
        }catch(SQLException ex){
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    @Override
    public KhachHangDTO selectById(String t) {
        return null;
    }

    @Override
    public int getAutoIncrement() {
        return 0;
    }
}
