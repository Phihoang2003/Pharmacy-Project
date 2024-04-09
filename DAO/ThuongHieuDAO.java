package DAO;

import DTO.ThuongHieu;
import Interface.ThuongHieu_Interface;
import config.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThuongHieuDAO implements ThuongHieu_Interface {
    public static ThuongHieuDAO getInstance() {
        return new ThuongHieuDAO();
    }

   @Override
public ArrayList<ThuongHieu> getAllTH() {
    ArrayList<ThuongHieu> list = new ArrayList<>();
    try {
        Connection con = JDBCUtil.getConnection();
        String sql = "SELECT * FROM thuonghieu";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            ThuongHieu thuongHieu = new ThuongHieu();
            thuongHieu.setMaThuongHieu(rs.getString("maThuongHieu"));
            thuongHieu.setTenThuongHieu(rs.getString("tenThuongHieu"));
            list.add(thuongHieu);
        }
        config.JDBCUtil.closeConnection(con);
    } catch (SQLException ex) {
        Logger.getLogger(NhomHangHoaDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
}

   @Override
public String layTenThuongHieuTheoMa(String maThuongHieu) {
    String tenThuongHieu = null;
    try {
        Connection con = JDBCUtil.getConnection();
        String sql = "SELECT tenThuongHieu FROM thuonghieu WHERE maThuongHieu = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, maThuongHieu);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            tenThuongHieu = rs.getString("tenThuongHieu");
        }
        JDBCUtil.closeConnection(con);
    } catch (SQLException ex) {
        Logger.getLogger(ThuongHieuDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return tenThuongHieu;
}

    @Override
public String layMaThuongHieuTheoTen(String tenThuongHieu) {
    String maThuongHieu = null;
    try {
        Connection con = JDBCUtil.getConnection();
        String sql = "SELECT maThuongHieu FROM thuonghieu WHERE tenThuongHieu = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, tenThuongHieu);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            maThuongHieu = rs.getString("maThuongHieu");
        }
        JDBCUtil.closeConnection(con);
    } catch (SQLException ex) {
        Logger.getLogger(ThuongHieuDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return maThuongHieu;
}
}
