package DAO;

import Interface.DaoInterface;
import config.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KhuyenMaiDAO implements DaoInterface<KhuyenMaiDTO> {
    public static KhuyenMaiDAO getInstance() {
        return new KhuyenMaiDAO();
    }

    @Override
    public int insert(KhuyenMaiDTO t) {
        int result = 0;
        try {
            Connection con = (Connection) JDBCUtil.getConnection();
            String sql = "INSERT INTO chuongtrinhkhuyenmai(`maKM`,`tenKM`,`chiecKhau`,`loaiKhuyenMai`,`ngayBatDau`,`ngayHetHan`,`trangThai`,`soTienToiThieu`,`soTienToiDa`) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, t.getMaKM());
            pst.setString(2, t.getTenKM());
            pst.setString(3, t.getChietKhau());
            pst.setString(4, t.getLoaiKhuyenMai());
            pst.setDate(5, (java.sql.Date) t.getNgayBatDau());
            pst.setDate(6, (java.sql.Date) t.getNgayHetHan());
            pst.setString(7, t.getTrangThai());
            pst.setDouble(8, t.getSoTienToiThieu());
            pst.setDouble(9, t.getSoTienToiDa());
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);

        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
public int update(KhuyenMaiDTO t) {
    int result = 0;
    try {
        Connection con = (Connection) JDBCUtil.getConnection();
        String sql = "UPDATE chuongtrinhkhuyenmai SET tenKM=?, chiecKhau=?, loaiKhuyenMai=?, ngayBatDau=?, ngayHetHan=?, trangThai=?, soTienToiThieu=?, soTienToiDa=? WHERE maKM=?";
        PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
        pst.setString(1, t.getTenKM());
        pst.setString(2, t.getChietKhau());
        pst.setString(3, t.getLoaiKhuyenMai());
        pst.setDate(4, (java.sql.Date) t.getNgayBatDau());
        pst.setDate(5, (java.sql.Date) t.getNgayHetHan());
        pst.setString(6, t.getTrangThai());
        pst.setDouble(7, t.getSoTienToiThieu());
        pst.setDouble(8, t.getSoTienToiDa());
        pst.setString(9, t.getMaKM());
        result = pst.executeUpdate();
        JDBCUtil.closeConnection(con);
    } catch (SQLException ex) {
        Logger.getLogger(KhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return result;
}


public int delete(String maKM) {
    int result = 0;
    try {
        Connection con = (Connection) JDBCUtil.getConnection();
        String sql = "DELETE FROM chuongtrinhkhuyenmai WHERE maKM=?";
        PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
        pst.setString(1, maKM);
        result = pst.executeUpdate();
        JDBCUtil.closeConnection(con);
    } catch (SQLException ex) {
        Logger.getLogger(KhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return result;
}

    @Override
public ArrayList<KhuyenMaiDTO> selectAll() {
    ArrayList<KhuyenMaiDTO> list = new ArrayList<>();
    try {
        Connection con = (Connection) JDBCUtil.getConnection();
        String sql = "SELECT * FROM chuongtrinhkhuyenmai";
        PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            KhuyenMaiDTO km = new KhuyenMaiDTO();
            km.setMaKM(rs.getString("maKM"));
            km.setTenKM(rs.getString("tenKM"));
            km.setChietKhau(rs.getString("chiecKhau"));
            km.setLoaiKhuyenMai(rs.getString("loaiKhuyenMai"));
            km.setNgayBatDau(rs.getDate("ngayBatDau"));
            km.setNgayHetHan(rs.getDate("ngayHetHan"));
            km.setTrangThai(rs.getString("trangThai"));
            km.setSoTienToiThieu(rs.getDouble("soTienToiThieu"));
            km.setSoTienToiDa(rs.getDouble("soTienToiDa"));
            list.add(km);
        }
        JDBCUtil.closeConnection(con);
    } catch (SQLException ex) {
        Logger.getLogger(KhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
}

    @Override
    public KhuyenMaiDTO selectById(String t) {
        KhuyenMaiDTO km=null;
        try{
            Connection con=(Connection) JDBCUtil.getConnection();
            String sql="SELECT * FROM `chuongtrinhkhuyenmai` WHERE `maKM`=?";
            PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
            pst.setString(1,t);
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
                km=new KhuyenMaiDTO();
                km.setMaKM(rs.getString("maKM"));
                km.setTenKM(rs.getString("tenKM"));
                km.setChietKhau(rs.getString("chiecKhau"));
                km.setLoaiKhuyenMai(rs.getString("loaiKhuyenMai"));
                km.setNgayBatDau(rs.getDate("ngayBatDau"));
                km.setNgayHetHan(rs.getDate("ngayHetHan"));
                km.setTrangThai(rs.getString("trangThai"));
                km.setSoTienToiThieu(rs.getDouble("soTienToiThieu"));
                km.setSoTienToiDa(rs.getDouble("soTienToiDa"));
                JDBCUtil.closeConnection(con);

            }
        }catch(SQLException ex){
            Logger.getLogger(KhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return km;
    }


    @Override
    public String getAutoIncrement() {
        Random random = new Random();
        int number = random.nextInt(900000000) + 100000000; // This will always generate 6-digit numbers
        return "KM" + number;
    }
}