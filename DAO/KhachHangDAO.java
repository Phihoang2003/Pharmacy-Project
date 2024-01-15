package DAO;

import DTO.KhachHangDTO;
import config.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    public int update(KhachHangDTO khachHangDTO) {
        return 0;
    }

    @Override
    public int delete(String t) {
        return 0;
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
    public int getAutoIncrement() {
        return 0;
    }
}
