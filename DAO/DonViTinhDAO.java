package DAO;

import DTO.DonViTinh;
import Interface.DonViTinh_Interface;
import config.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DonViTinhDAO implements DonViTinh_Interface {
    public static DonViTinhDAO getInstance() {
        return new DonViTinhDAO();
    }
    public DonViTinh selectDonViTinh(String maDVT) {
    DonViTinh donViTinh = null;
    try {
        Connection con = JDBCUtil.getConnection();
        String sql = "SELECT * FROM donvitinh WHERE maDonViTinh = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, maDVT);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            donViTinh = new DonViTinh();
            donViTinh.setMaDonViTinh(rs.getString("maDonViTinh"));
            donViTinh.setTenDonViTinh(rs.getString("tenDonViTinh"));
        }
        JDBCUtil.closeConnection(con);
    } catch (SQLException ex) {
        Logger.getLogger(DonViTinhDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return donViTinh;
    }

   @Override
public ArrayList<DonViTinh> getAllDVT() {
    ArrayList<DonViTinh> list = new ArrayList<>();
    try {
        Connection con = JDBCUtil.getConnection();
        String sql = "SELECT * FROM donvitinh";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            DonViTinh donViTinh = new DonViTinh();
            donViTinh.setMaDonViTinh(rs.getString("maDonViTinh"));
            donViTinh.setTenDonViTinh(rs.getString("tenDonViTinh"));
            list.add(donViTinh);
        }
        JDBCUtil.closeConnection(con);
    } catch (SQLException ex) {
        Logger.getLogger(DonViTinhDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
}

    @Override
public String layTenDVTTheoMa(String maDVT) {
    String tenDonViTinh = null;
    try {
        Connection con = JDBCUtil.getConnection();
        String sql = "SELECT tenDonViTinh FROM donvitinh WHERE maDonViTinh = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, maDVT);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            tenDonViTinh = rs.getString("tenDonViTinh");
        }
        JDBCUtil.closeConnection(con);
    } catch (SQLException ex) {
        Logger.getLogger(DonViTinhDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return tenDonViTinh;
}

    @Override
public String layMaDVTTheoTen(String tenDVT) {
    String maDonViTinh = null;
    try {
        Connection con = JDBCUtil.getConnection();
        String sql = "SELECT maDonViTinh FROM donvitinh WHERE tenDonViTinh = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, tenDVT);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            maDonViTinh = rs.getString("maDonViTinh");
        }
        JDBCUtil.closeConnection(con);
    } catch (SQLException ex) {
        Logger.getLogger(DonViTinhDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return maDonViTinh;
}
}
