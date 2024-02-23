package DAO;
import DTO.NuocSanXuat;
import config.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class NuocSanXuatDAO {
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
}
