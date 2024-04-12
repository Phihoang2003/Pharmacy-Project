package DAO;
import DTO.NuocSanXuat;
import Interface.NuocSanXuat_Interface;
import config.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class NuocSanXuatDAO implements NuocSanXuat_Interface {
    public static NuocSanXuatDAO getInstance() {
        return new NuocSanXuatDAO();
    }
    public NuocSanXuat selectNuocSanXuat(String maNuoc) {
        NuocSanXuat nuocSanXuat = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM nuocsanxuat WHERE maNuoc = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, maNuoc);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                nuocSanXuat = new NuocSanXuat();
                nuocSanXuat.setMaNuoc(rs.getString("maNuoc"));
                nuocSanXuat.setTenNuoc(rs.getString("tenNuoc"));
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NuocSanXuatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nuocSanXuat;
    }

    @Override
public ArrayList<NuocSanXuat> getAllNSX() {
    ArrayList<NuocSanXuat> list = new ArrayList<>();
    try {
        Connection con = JDBCUtil.getConnection();
        String sql = "SELECT * FROM nuocsanxuat";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            NuocSanXuat nuocSanXuat = new NuocSanXuat();
            nuocSanXuat.setMaNuoc(rs.getString("maNuoc"));
            nuocSanXuat.setTenNuoc(rs.getString("tenNuoc"));
            list.add(nuocSanXuat);
        }
        JDBCUtil.closeConnection(con);
    } catch (SQLException ex) {
        Logger.getLogger(NuocSanXuatDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
}

@Override
public String layTenNSXTheoMa(String maNSX) {
    String tenNuoc = null;
    try {
        Connection con = JDBCUtil.getConnection();
        String sql = "SELECT tenNuoc FROM nuocsanxuat WHERE maNuoc = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, maNSX);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            tenNuoc = rs.getString("tenNuoc");
        }
        JDBCUtil.closeConnection(con);
    } catch (SQLException ex) {
        Logger.getLogger(NuocSanXuatDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return tenNuoc;
}

@Override
public String layMaNSXTheoTen(String tenNSX) {
    String maNuoc = null;
    try {
        Connection con = JDBCUtil.getConnection();
        String sql = "SELECT maNuoc FROM nuocsanxuat WHERE tenNuoc = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, tenNSX);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            maNuoc = rs.getString("maNuoc");
        }
        JDBCUtil.closeConnection(con);
    } catch (SQLException ex) {
        Logger.getLogger(NuocSanXuatDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return maNuoc;
}
}
