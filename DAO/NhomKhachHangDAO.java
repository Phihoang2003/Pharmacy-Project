package DAO;

import DTO.NhomKhachHangDTO;
import config.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class NhomKhachHangDAO implements DaoInterface<NhomKhachHangDTO>{
    public static NhomKhachHangDAO getInstance() {
        return new NhomKhachHangDAO();
    }
    @Override
    public int insert(NhomKhachHangDTO nhomKhachHangDTO) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO `nhomkhachhang`(`maNhomKhachHang`, `tenNhomKhachHang`) VALUES (?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, nhomKhachHangDTO.getMaNhom());
            pst.setString(2, nhomKhachHangDTO.getTenNhom());
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhomKhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int update(NhomKhachHangDTO nhomKhachHangDTO) {
        return 0;
    }

    @Override
    public int delete(String t) {
        return 0;
    }

    @Override
    public ArrayList<NhomKhachHangDTO> selectAll() {
        return null;
    }

    @Override
    public NhomKhachHangDTO selectById(String id) {
        NhomKhachHangDTO nhomKhachHangDTO = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM nhomkhachhang WHERE maNhom = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String maNhom = rs.getString("maNhom");
                String tenNhom = rs.getString("tenNhom");
                String ghiChu = rs.getString("ghiChu");
                nhomKhachHangDTO = new NhomKhachHangDTO(maNhom, tenNhom, ghiChu);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhomKhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nhomKhachHangDTO;
    }

    @Override
    public String getAutoIncrement() {
        return null;
    }
}


