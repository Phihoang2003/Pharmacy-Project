package DAO;
import DTO.NhomHangHoa;
import Interface.NhomThuoc_Interface;
import config.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class NhomHangHoaDAO implements NhomThuoc_Interface {
    public static NhomHangHoaDAO getInstance() {
        return new NhomHangHoaDAO();
    }
    public NhomHangHoa selectNhomHangHoa(String maNhom) {
        NhomHangHoa nhomHangHoa = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM nhomhanghoa WHERE maNhom = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, maNhom);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                nhomHangHoa = new NhomHangHoa();
                nhomHangHoa.setMaNhomHang(rs.getString("maNhom"));
                nhomHangHoa.setTenNhomHang(rs.getString("tenNhom"));
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhomHangHoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nhomHangHoa;
    }

    @Override
    public String layTenNhomThuocTheoMa(String maNhom) {
        String tenNhom = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT tenNhom FROM nhomhanghoa WHERE maNhom = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, maNhom);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                tenNhom = rs.getString("tenNhom");
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhomHangHoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tenNhom;
    }

    @Override
public ArrayList<NhomHangHoa> getAllNT() {
    ArrayList<NhomHangHoa> list = new ArrayList<>();
    try {
        Connection con = JDBCUtil.getConnection();
        String sql = "SELECT * FROM nhomhanghoa";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            NhomHangHoa nhomHangHoa = new NhomHangHoa();
            nhomHangHoa.setMaNhomHang(rs.getString("maNhom"));
            nhomHangHoa.setTenNhomHang(rs.getString("tenNhom"));
            list.add(nhomHangHoa);
        }
        JDBCUtil.closeConnection(con);
    } catch (SQLException ex) {
        Logger.getLogger(NhomHangHoaDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
}

  @Override
public String layMaNhomThuocTheoTen(String tenNhomHang) {
    String maNhomHang = null;
    try {
        Connection con = JDBCUtil.getConnection();
        String sql = "SELECT maNhom FROM nhomhanghoa WHERE tenNhom = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, tenNhomHang);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            maNhomHang = rs.getString("maNhom");
        }
        JDBCUtil.closeConnection(con);
    } catch (SQLException ex) {
        Logger.getLogger(NhomHangHoaDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return maNhomHang;
}
}
