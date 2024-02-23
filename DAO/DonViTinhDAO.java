package DAO;

import DTO.DonViTinh;
import config.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DonViTinhDAO {
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
}
