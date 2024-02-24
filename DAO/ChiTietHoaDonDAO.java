package DAO;

import DTO.ChiTietHoaDon;
import Interface.ChiTietHoaDon_Interface;
import config.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ChiTietHoaDonDAO implements ChiTietHoaDon_Interface {
    public static ChiTietHoaDonDAO getInstance() {
        return new ChiTietHoaDonDAO();
    }
    @Override
    public boolean themChiTietHoaDon(ChiTietHoaDon cthd) {
        int result = 0;
        try {
            Connection con = (Connection) JDBCUtil.getConnection();
            String sql = "INSERT INTO `chitiethoadon`(`maHD`, `maSP`, `soLuong`, `giaGoc`,`giaBan`, `thanhTien`) VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, cthd.getHoaDon().getMaHD());
            pst.setString(2, cthd.getThuoc().getMaThuoc());
            pst.setInt(3, cthd.getSoLuong());
            pst.setDouble(4, cthd.getGiaGoc());
            pst.setDouble(5, cthd.getGiaBan());
            pst.setDouble(6, cthd.getThanhTien());
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result > 0;
    }
}
