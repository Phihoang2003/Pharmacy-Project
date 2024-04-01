package DAO;
import DTO.NhomHangHoa;
import config.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class NhomHangHoaDAO {
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
    public String getTenNhomHangHoa(String maNhom) {
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
}
