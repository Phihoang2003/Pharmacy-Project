package DAO;

import DTO.TaiKhoan;
import Interface.TaiKhoan_Interface;
import config.JDBCUtil;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TaiKhoanDAO implements TaiKhoan_Interface {
    public static TaiKhoanDAO getInstance() {
        return new TaiKhoanDAO();
    }
    @Override
    public boolean insert(TaiKhoan tk) {
        return false;
    }

    @Override
    public ArrayList<TaiKhoan> findAll() {
        return null;
    }

    @Override
    public TaiKhoan getTK(String taiKhoan, String matKhau) {

        TaiKhoan taiKhoanDTO=null;
        try{
            Connection con=(Connection) JDBCUtil.getConnection();
            String sql="SELECT * FROM taikhoan WHERE tenTK = ? AND matKhau = ?";
            PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
            pst.setString(1,taiKhoan);
            pst.setString(2,matKhau);
            ResultSet rs=pst.executeQuery();

            while(rs.next()){
                taiKhoanDTO=new TaiKhoan();
                taiKhoanDTO.setTenTK(rs.getString("tenTK"));
                taiKhoanDTO.setMatKhau(rs.getString("matKhau"));
                taiKhoanDTO.setTrangThai(rs.getInt("trangThai"));
            }

        }catch(SQLException ex){
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return taiKhoanDTO;
    }

    public boolean setThoiGianDN(TaiKhoan tk) {
        Timestamp currentTime = Timestamp.valueOf(LocalDateTime.now());
        int n = 0;
        try {
            Connection con = (Connection) JDBCUtil.getConnection();
            String sql = "UPDATE taikhoan SET thoiGianDN = ? WHERE tenTK = ?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setTimestamp(1, currentTime);
            pst.setString(2, tk.getTenTK());
            n = pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n > 0;
    }
}
