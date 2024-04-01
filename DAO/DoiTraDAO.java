package DAO;

import DTO.*;
import Interface.DoiTra_Interface;
import config.JDBCUtil;

import utils.ConvertStringToEnum;

import java.sql.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DoiTraDAO implements DoiTra_Interface {
    private ChiTietDoiTraDAO ctdt_dao = new ChiTietDoiTraDAO();
    ConvertStringToEnum toEnum= new ConvertStringToEnum();
    public static DoiTraDAO getInstance(){
        return new DoiTraDAO();
    }

    @Override
    public boolean taoDoiTra(DoiTra dt, ArrayList<ChiTietDoiTra> ctdtList) {
        int result=0;
        try{
            Connection con= JDBCUtil.getConnection();
            String sql="INSERT INTO doitra(maDT,maHD,maNV,thoiGianDoiTra,lyDoDoiTra,hinhThucDoiTra,tongTien) values(?,?,?,?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,dt.getMaDT());
            pst.setString(2,dt.getHoaDon().getMaHD());
            pst.setString(3,dt.getNhanVien().getMaNhanVien());
            pst.setDate(4,dt.getThoiGianDoiTra());
            pst.setString(5,dt.getLyDoDoiTra());
            pst.setString(6,dt.getHinhThucDoiTra().toString());
            pst.setDouble(7,dt.getTongTien());
            result=pst.executeUpdate();
            if(result<1){
                return false;
            }
            for(ChiTietDoiTra ctdt:ctdtList){
                if(!ctdt_dao.themChiTietDoiTra(ctdt)){
                    return false;
                }
            }
            JDBCUtil.closeConnection(con);
            return true;
        }
        catch(SQLException ex){
            Logger.getLogger(DoiTraDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return true;
    }

    @Override
    public ArrayList<DoiTra> getAllDoiTra() {
        return null;
    }

    @Override
    public DoiTra getDoiTraTheoMa(String ma) {
    DoiTra dt = null;
    PreparedStatement pst = null;
    try {
        Connection con = JDBCUtil.getConnection();
        String sql = "SELECT dt.*, hd.khachHang from doitra as dt  join HoaDon as hd on dt.maHD=hd.maHD where maDT=?";
         pst= con.prepareStatement(sql);
        pst.setString(1, ma);
        ResultSet rs = pst.executeQuery();
        if(rs.next()) {
            String maDT = rs.getString("maDT");
            String maHD = rs.getString("maHD");
            HoaDon hd = new HoaDon(maHD);

            String maKH = rs.getString("khachHang");
            KhachHang kh = new KhachHang();

            String maNV = rs.getString("maNV");
            NhanVien nv = new NhanVien(maNV);
            Date thoiGian = rs.getDate("thoiGianDoiTra");
            String hinhThuc = rs.getString("hinhThucDoiTra");
            String lyDo = rs.getString("lyDoDoiTra");
            double tongTien = rs.getDouble("tongTien");
            if(maKH != null) {
                kh.setMaKhachHang(maKH);
                String sql_kh = "Select tenKhachHang, soDienThoai from khachhang where maKhachHang=?";
                pst = con.prepareStatement(sql_kh);
                pst.setString(1, maKH);

                rs = pst.executeQuery();
                if(rs.next()) {

                    kh.setHoTen(rs.getString("tenKhachHang"));
                    kh.setSdt(rs.getString("soDienThoai"));
                }

            }
            hd.setKhachHang(kh);

            dt = new DoiTra(maDT, hd, nv, toEnum.HinhThucDTToEnum(hinhThuc),lyDo, thoiGian, tongTien);
        }
    } catch (SQLException ex) {
        Logger.getLogger(DoiTraDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return dt;
}

    @Override
    public ArrayList<DoiTra> getDoiTraTheoNgayLap(Date ngayLap) {
        return null;
    }

    @Override
    public DoiTra getDoiTraTheoDieuKien(String ma, Date ngayLap) {
        return null;
    }

    @Override
    public int getTongSoLuongSPDoiTra(String maHD, String maSP) {
        int tongSoLuong=0;
        try{
            Connection con=JDBCUtil.getConnection();
            String sql="SELECT sum(ctdt.soLuong) as tongSoLuong from doitra as dt join chitietdoitra as ctdt on dt.maDT=ctdt.maDT where dt.maHD=? and ctdt.maSP=? and dt.hinhThucDoiTra=N'Hoàn trả' group by ctdt.maSP";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,maHD);
            pst.setString(2,maSP);
            ResultSet rs=pst.executeQuery();
            if(rs.next()) {
                tongSoLuong = rs.getInt("tongSoLuong");
            }

            JDBCUtil.closeConnection(con);
        }
        catch(SQLException ex){
            Logger.getLogger(DoiTraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tongSoLuong;
    }

    @Override
    public boolean kiemTraThoiHanDoiTra(String maHD) {
        boolean flag = false;
        try{
            Connection con=JDBCUtil.getConnection();
            String sql="SELECT count(*) as thoiHan FROM hoadon WHERE year(ngayLapHoaDon)=year(now()) AND month(ngayLapHoaDon)=month(now()) AND day(ngayLapHoaDon)+7>= day(now()) AND maHD=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,maHD);
            ResultSet rs = pst.executeQuery();

            if(rs.next()){
                if(rs.getInt("thoiHan")==1){
                    flag=true;
                }
            }
            JDBCUtil.closeConnection(con);

        }catch(SQLException ex){
            Logger.getLogger(DoiTraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    @Override
    public String getAutoIncrement() {
        Random random = new Random();
        int number = random.nextInt(900000000) + 100000000; // This will always generate 6-digit numbers
        return "DT" + number;
    }
}
