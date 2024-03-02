package DAO;

import DTO.ChuongTrinhKhuyenMai;
import DTO.LoaiKhuyenMai;
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

public class ChuongTrinhKhuyenMaiDAO implements DaoInterface<ChuongTrinhKhuyenMai> {
public static ChuongTrinhKhuyenMaiDAO getInstance() {
        return new ChuongTrinhKhuyenMaiDAO();
    }
    @Override
    public int insert(ChuongTrinhKhuyenMai t) {
        int result=0;
        try {
            Connection con = (Connection) JDBCUtil.getConnection();
            String sql="INSERT INTO `chuongtrinhkhuyenmai`(`maCTKM`, `tenCTKM`, `ngayBatDau`, `ngayKetThuc`,`soTienToiThieu`,`soTienToiDa`,`giamGia`, `trangThai`,`maLoaiKM`) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
            pst.setString(1,t.getMaCTKM());
            pst.setString(2,t.getTenCTKM());
            pst.setDate(3, (java.sql.Date) t.getNgayBatDau());
            pst.setDate(4, (java.sql.Date) t.getNgayKetThuc());
            pst.setDouble(5,t.getSoTienToiThieu());
            pst.setDouble(6,t.getSoTienToiDa());
            pst.setInt(7,t.getGiamGia());
            pst.setInt(8,t.getTinhTrang());
            pst.setString(9,t.getMaLoaiKM().getMaLoaiKM());
            result=pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        }catch(SQLException ex){
            Logger.getLogger(ChuongTrinhKhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int update(ChuongTrinhKhuyenMai t) {
        return 0;
    }

    @Override
    public ArrayList<ChuongTrinhKhuyenMai> selectAll() {
        return null;
    }

    @Override
    public ChuongTrinhKhuyenMai selectById(String t) {
        ChuongTrinhKhuyenMai ctkm= new ChuongTrinhKhuyenMai();
        try {
            Connection con = (Connection) JDBCUtil.getConnection();
            String sql="SELECT * FROM `chuongtrinhkhuyenmai` WHERE maCTKM=?";
            PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
            pst.setString(1,t);
            ResultSet result=pst.executeQuery();
            while(result.next()){
                ctkm.setMaCTKM(result.getString("maCTKM"));
                ctkm.setMaLoaiKM(new LoaiKhuyenMai(result.getString("maLoaiKM")));
                ctkm.setTenCTKM(result.getString("tenCTKM"));
                ctkm.setNgayBatDau(result.getDate("ngayBatDau"));
                ctkm.setNgayKetThuc(result.getDate("ngayKetThuc"));
                ctkm.setSoTienToiThieu(result.getDouble("soTienToiThieu"));
                ctkm.setSoTienToiDa(result.getDouble("soTienToiDa"));
                ctkm.setGiamGia(result.getInt("giamGia"));
                ctkm.setTinhTrang(result.getInt("trangThai"));
            }
            JDBCUtil.closeConnection(con);
        }catch(SQLException ex){
            Logger.getLogger(ChuongTrinhKhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ctkm;
    }

    @Override
    public String getAutoIncrement() {
        Random random = new Random();
        int number = random.nextInt(900000000) + 100000000; // This will always generate 6-digit numbers
        return "KM" + number;
    }


}
