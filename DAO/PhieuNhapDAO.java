package DAO;

import DTO.NhaCungCap;
import DTO.PhieuNhap;
import DTO.Thuoc;
import Interface.PhieuNhap_Interface;
import config.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PhieuNhapDAO implements PhieuNhap_Interface {
    public static PhieuNhapDAO getInstance() {
        return new PhieuNhapDAO();
    }
    @Override
    public ArrayList<PhieuNhap> selectAll() {
        ArrayList<PhieuNhap> list=new ArrayList<PhieuNhap>();
        try {
            Connection con=(Connection) JDBCUtil.getConnection();
            String sql="SELECT * FROM `phieunhap`";
            PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                String maPN=rs.getString("maPN");
                NhaCungCap maNCC=new NhaCungCap(rs.getString("maNCC"));
                Thuoc maThuoc=new Thuoc(rs.getString("maThuoc"));
                int soLuongNhap=rs.getInt("soLuongNhap");
                Date ngayNhap=rs.getDate("ngayNhap");
                PhieuNhap mhn=new PhieuNhap(maPN,maNCC,maThuoc,soLuongNhap,ngayNhap);
                list.add(mhn);
            }

            JDBCUtil.closeConnection(con);

        }catch(SQLException ex){
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public boolean insert(PhieuNhap mhn) {
        int result=0;
        try{
            Connection con= JDBCUtil.getConnection();
            String sql="INSERT INTO `phieunhap`(`maPN`, `maNCC`, `maThuoc`, `soLuongNhap`,`ngayNhap`) VALUES (?,?,?,?,?)";
            PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
            pst.setString(1,mhn.getMaPN());
            pst.setString(2,mhn.getNhaCungCap().getMaNhaCungCap());
            pst.setString(3,mhn.getThuoc().getMaThuoc());
            pst.setInt(4,mhn.getSoLuongNhap());
            pst.setDate(5,  (Date) mhn.getNgayNhap());
            result=pst.executeUpdate();
            JDBCUtil.closeConnection(con);

        }catch(SQLException ex){
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result>0;
    }

    @Override
    public ArrayList<PhieuNhap> timKiemMHN(java.util.Date ngayNhap) {
        ArrayList<PhieuNhap> list=new ArrayList<PhieuNhap>();
        try{
            Connection con=JDBCUtil.getConnection();
            String sql="SELECT * FROM `phieunhap` WHERE `ngayNhap`=?";
            PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
            pst.setDate(1, (Date) ngayNhap);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                String maPN=rs.getString("maPN");
                NhaCungCap maNCC=new NhaCungCap(rs.getString("maNCC"));
                Thuoc maThuoc=new Thuoc(rs.getString("maThuoc"));
                int soLuongNhap=rs.getInt("soLuongNhap");
                Date ngayNhap1=rs.getDate("ngayNhap");
                PhieuNhap mhn=new PhieuNhap(maPN,maNCC,maThuoc,soLuongNhap,ngayNhap1);
                list.add(mhn);
            }
        }catch(SQLException ex){
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }



    @Override
public boolean update(PhieuNhap mhn) {
    int result = 0;
    try {
        Connection con = JDBCUtil.getConnection();
        String sql = "UPDATE `phieunhap` SET `maNCC`=?, `maThuoc`=?, `soLuongNhap`=?, `ngayNhap`=? WHERE `maPN`=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, mhn.getNhaCungCap().getMaNhaCungCap());
        pst.setString(2, mhn.getThuoc().getMaThuoc());
        pst.setInt(3, mhn.getSoLuongNhap());
        pst.setDate(4, new java.sql.Date(mhn.getNgayNhap().getTime()));
        pst.setString(5, mhn.getMaPN());
        result = pst.executeUpdate();
        JDBCUtil.closeConnection(con);
    } catch (SQLException ex) {
        Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return result > 0;
}

    @Override
    public boolean kiemTraMaMatHangNhapTonTai(String maMHN) {
        return false;
    }
    @Override
    public String getAutoIncrement() {
        Random random = new Random();
        int number = random.nextInt(900000000) + 100000000; // This will always generate 6-digit numbers
        return "PN" + number;
    }
}
