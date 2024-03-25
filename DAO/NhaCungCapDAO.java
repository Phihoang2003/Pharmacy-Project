package DAO;


import DTO.NhaCungCap;
import Interface.NhaCungCap_Interface;
import config.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NhaCungCapDAO implements NhaCungCap_Interface {
    public static NhaCungCapDAO getInstance() {
        return new NhaCungCapDAO();
    }
    @Override
    public boolean insert(NhaCungCap nhaCungCapDTO) {
        int result=0;
        try{
            Connection con=(Connection) JDBCUtil.getConnection();
            String sql="INSERT INTO `nhacungcap`(`maNhaCungCap`, `tenNhaCungCap`, `soDienThoai`, `diaChi`, `trangThai`) VALUES (?,?,?,?,?)";
            PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
            pst.setString(1,nhaCungCapDTO.getMaNhaCungCap());
            pst.setString(2,nhaCungCapDTO.getTenNhaCungCap());
            pst.setString(3,nhaCungCapDTO.getSoDienThoai());
            pst.setString(4,nhaCungCapDTO.getDiaChi());
            pst.setInt(5,nhaCungCapDTO.getTrangThai());

            result=pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        }
        catch(SQLException ex){
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result>0;
    }

    @Override
    public ArrayList<NhaCungCap> timKiemNCC(String ma) {
        return null;
    }

    @Override
    public boolean update(NhaCungCap nhaCungCapDTO) {
        int result=0;
        try{
            Connection con=(Connection) JDBCUtil.getConnection();
            String sql="UPDATE `nhacungcap` SET `tenNhaCungCap`=?,`soDienThoai`=?,`diaChi`=?,`trangThai`=? WHERE maNhaCungCap=?";
            PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);

            pst.setString(1,nhaCungCapDTO.getTenNhaCungCap());
            pst.setString(2,nhaCungCapDTO.getSoDienThoai());
            pst.setString(3,nhaCungCapDTO.getDiaChi());
            pst.setInt(4,nhaCungCapDTO.getTrangThai());
            pst.setString(5,nhaCungCapDTO.getMaNhaCungCap());
            result=pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        }catch (SQLException ex){
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result>0;
    }

   @Override
public ArrayList<NhaCungCap> selectAll() {
    ArrayList<NhaCungCap> list = new ArrayList<>();
    try {
        Connection con = JDBCUtil.getConnection();
        String sql = "SELECT * FROM `nhacungcap`";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            NhaCungCap nhaCungCapDTO = new NhaCungCap();
            nhaCungCapDTO.setMaNhaCungCap(rs.getString("maNhaCungCap"));
            nhaCungCapDTO.setTenNhaCungCap(rs.getString("tenNhaCungCap"));
            nhaCungCapDTO.setSoDienThoai(rs.getString("soDienThoai"));
            nhaCungCapDTO.setDiaChi(rs.getString("diaChi"));
            nhaCungCapDTO.setTrangThai(rs.getInt("trangThai"));
            list.add(nhaCungCapDTO);
        }
        JDBCUtil.closeConnection(con);
    } catch (SQLException ex) {
        Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
}

    @Override
    public ArrayList<NhaCungCap> layDSNCCDangNhap() {
        ArrayList<NhaCungCap> list = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM `nhacungcap` WHERE `trangThai` = 1";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                NhaCungCap nhaCungCapDTO = new NhaCungCap();
                nhaCungCapDTO.setMaNhaCungCap(rs.getString("maNhaCungCap"));
                nhaCungCapDTO.setTenNhaCungCap(rs.getString("tenNhaCungCap"));
                nhaCungCapDTO.setSoDienThoai(rs.getString("soDienThoai"));
                nhaCungCapDTO.setDiaChi(rs.getString("diaChi"));
                nhaCungCapDTO.setTrangThai(rs.getInt("trangThai"));
                list.add(nhaCungCapDTO);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public String layTenNhaCungCapTheoMa(String maNhaCungCap) {
        return null;
    }

    @Override
    public String layMaNhaCungCapTheoTen(String tenNhaCungCap) {
        return null;
    }

    @Override
public NhaCungCap selectById(String id) {
    NhaCungCap nhaCungCapDTO = null;
    try {
        Connection con = JDBCUtil.getConnection();
        String sql = "SELECT * FROM `nhacungcap` WHERE `maNhaCungCap` = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            nhaCungCapDTO = new NhaCungCap();
            nhaCungCapDTO.setMaNhaCungCap(rs.getString("maNhaCungCap"));
            nhaCungCapDTO.setTenNhaCungCap(rs.getString("tenNhaCungCap"));
            nhaCungCapDTO.setSoDienThoai(rs.getString("soDienThoai"));
            nhaCungCapDTO.setDiaChi(rs.getString("diaChi"));
            nhaCungCapDTO.setTrangThai(rs.getInt("trangThai"));
        }
        JDBCUtil.closeConnection(con);
    } catch (SQLException ex) {
        Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return nhaCungCapDTO;
}

    @Override
    public String getAutoIncrement() {
        Random random = new Random();
        int number = random.nextInt(900000000) + 100000000; // This will always generate 6-digit numbers
        return "NCC" + number;
    }


}
