package DAO;

import DTO.*;
import Interface.ChiTietHoaDon_Interface;
import config.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
        return result <= 0;
    }

    @Override
    public boolean xoaChiTietHoaDon(String maHD) {
        int result = 0;
        try {
            Connection con = (Connection) JDBCUtil.getConnection();
            String sql = "DELETE FROM `chitiethoadon` WHERE maHD=?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, maHD);
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result > 0;
    }

    @Override
    public ArrayList<ChiTietHoaDon> getAllCTHDTheoMaHD(String maHD) {
        ArrayList<ChiTietHoaDon> list=new ArrayList<>();
        try{
            Connection con=JDBCUtil.getConnection();
            String sql="SELECT cthd.*,th.tenThuoc,th.nhomHangHoa,th.hanSuDung,th.hoatChatChinh,th.quyCachDongGoi,th.nuocSanXuat FROM chitiethoadon as cthd join thuoc as th on cthd.maSP=th.maThuoc WHERE maHD=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, maHD);
            ResultSet rs=pst.executeQuery();

            while(rs.next()){
                String maHd=rs.getString("maHD");
                HoaDon hd=new HoaDon(maHd);
                NhomHangHoaDAO nh_dao=new NhomHangHoaDAO();
                String maSP=rs.getString("maSP");
                String nhomHangHoa=rs.getString("nhomHangHoa");
                Date hanSuDung=rs.getDate("hanSuDung");

                String tenThuoc=rs.getString("tenThuoc");
                String hoatChatChinh=rs.getString("hoatChatChinh");
                String quyCachDongGoi=rs.getString("quyCachDongGoi");
                String nuocSanXuat=rs.getString("nuocSanXuat");
                Thuoc sp=new Thuoc(maSP);
                sp.setTenThuoc(tenThuoc);
                sp.setHanSuDung(hanSuDung);
                sp.setNhomHangHoa(new NhomHangHoa(nhomHangHoa, nh_dao.getTenNhomHangHoa(nhomHangHoa)));
                sp.setHoatChatChinh(hoatChatChinh);
                sp.setQuyCachDongGoi(quyCachDongGoi);
                sp.setNuocSanXuat(new NuocSanXuat(nuocSanXuat));
                int soLuong=rs.getInt("soLuong");
                double giaGoc=rs.getDouble("giaGoc");
                double giaBan=rs.getDouble("giaBan");
                double thanhTien=rs.getDouble("thanhTien");
                ChiTietHoaDon cthd=new ChiTietHoaDon(sp,hd,soLuong,giaGoc,giaBan,thanhTien);
                list.add(cthd);

            }
            JDBCUtil.closeConnection(con);
        }catch(SQLException ex){
            Logger.getLogger(ChiTietHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public ArrayList<ChiTietHoaDon> getallCTHD() {
        return null;
    }

    @Override
    public ArrayList<Thuoc> getSanPhamTheoMaSP(String maSP) {
        return null;
    }

    @Override
    public ArrayList<Thuoc> getSanPhamTheoMaHD(String maHD) {
        return null;
    }

    @Override
    public int soluongSP(String maHD, String maSP) {
        return 0;
    }

    @Override
    public int getSoLuongCTHD(String maSP) {
        return 0;
    }

    @Override
    public ArrayList<ChiTietHoaDon> getCTHDTheoMaHDvaMaSP(String maHD, String maSP) {
        return null;
    }
}
