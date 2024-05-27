package DAO;

import DTO.*;
import Interface.HoaDon_Interface;

import java.sql.*;
import java.util.ArrayList;
import config.JDBCUtil;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
public class HoaDonDAO implements HoaDon_Interface {
    public static HoaDonDAO getInstance() {
        return new HoaDonDAO();
    }
    @Override
    public boolean themHoaDon(HoaDon hoaDon, ArrayList<ChiTietHoaDon> danhSachCTHD) {

        int result = 0;
        try{
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO `hoadon`(`maHD`, `nhanVien`, `chuongTrinhKM`, `tongTien`, `tienKhuyenMai`, `tienThanhToan`, `ngayLapHoaDon`,`khachHang`, `tinhTrang` ) VALUES (?,?,?,?,?,?,?,?,1)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, hoaDon.getMaHD());
            pst.setString(2, hoaDon.getNhanVien().getMaNhanVien());
            pst.setString(3, hoaDon.getChuongTrinhKM().getMaCTKM());
            pst.setDouble(4, hoaDon.getTongTien());
            pst.setDouble(5, hoaDon.getTienKhuyenMai());
            pst.setDouble(6, hoaDon.getTienThanhToan());
            pst.setDate(7, hoaDon.getNgayLapHD());
            pst.setString(8, hoaDon.getKhachHang().getMaKhachHang());
            result = pst.executeUpdate();
            if(result<0){
                return false;
            }
            ChiTietHoaDonDAO cthd_dao = new ChiTietHoaDonDAO();
            for(ChiTietHoaDon cthd:danhSachCTHD){
                if(cthd_dao.themChiTietHoaDon(cthd)){
                    return false;
                }
            }

        }catch (SQLException ex){
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result > 0;
    }

    @Override
    public HoaDon selectByMaHD(String maHD) {
        HoaDon hoaDon=null;
        try {
            Connection con=JDBCUtil.getConnection();
            String sql = "SELECT * FROM hoadon WHERE maHD = ? AND tinhTrang=1";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, maHD);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                hoaDon = new HoaDon();
                hoaDon.setMaHD(rs.getString("maHD"));
                hoaDon.setNhanVien(new NhanVien(rs.getString("nhanVien")));
                hoaDon.setChuongTrinhKM(new ChuongTrinhKhuyenMai(rs.getString("chuongTrinhKM")));
                hoaDon.setTongTien(rs.getDouble("tongTien"));
                hoaDon.setTienKhuyenMai();
                hoaDon.setTienThanhToan(false);
                hoaDon.setNgayLapHD(rs.getDate("ngayLapHoaDon"));
                hoaDon.setTinhTrang(rs.getInt("tinhTrang"));
                hoaDon.setKhachHang(new KhachHang(rs.getString("khachHang")));
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hoaDon;
    }
    public String getAutoIncrement() {
        Random random = new Random();
        int number = random.nextInt(900000000) + 100000000; // This will always generate 6-digit numbers
        return "HD" + number;
    }

    @Override
    public boolean luuTamHoaDon(HoaDon hoaDon, ArrayList<ChiTietHoaDon> danhSachCTHD) {
        int result = 0;
        try{
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO `hoadon`(`maHD`, `nhanVien`, `chuongTrinhKM`, `tongTien`, `tienKhuyenMai`, `tienThanhToan`, `ngayLapHoaDon`,`khachHang`, `tinhTrang` ) VALUES (?,?,?,?,?,?,?,?,0)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, hoaDon.getMaHD());
            pst.setString(2, hoaDon.getNhanVien().getMaNhanVien());
            pst.setString(3, hoaDon.getChuongTrinhKM().getMaCTKM());
            pst.setDouble(4, hoaDon.getTongTien());
            pst.setDouble(5, hoaDon.getTienKhuyenMai());
            pst.setDouble(6, hoaDon.getTienThanhToan());
            pst.setDate(7, hoaDon.getNgayLapHD());
            pst.setString(8, hoaDon.getKhachHang().getMaKhachHang());
            result = pst.executeUpdate();
            if(result<0){
                return false;
            }
            ChiTietHoaDonDAO cthd_dao = new ChiTietHoaDonDAO();
            for(ChiTietHoaDon cthd:danhSachCTHD){
                if(cthd_dao.themChiTietHoaDon(cthd)){
                    return false;
                }
            }

        }catch (SQLException ex){
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result > 0;
    }

    @Override
    public boolean themHoaDonLuuTam(HoaDon hoaDon, ArrayList<ChiTietHoaDon> danhSachCTHD) {
        int result = 0;
        try{
            Connection con = JDBCUtil.getConnection();
            String sql = "Update hoadon set nhanVien=?, chuongTrinhKM=?, ngayLapHoaDon=?, tienKhuyenMai=?, tongTien=?, tienThanhToan=?, tinhTrang=? where maHD=? and khachHang=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, hoaDon.getNhanVien().getMaNhanVien());
            pst.setString(2, hoaDon.getChuongTrinhKM().getMaCTKM());
            pst.setDate(3, hoaDon.getNgayLapHD());
            pst.setDouble(4, hoaDon.getTienKhuyenMai());
            pst.setDouble(5, hoaDon.getTongTien());
            pst.setDouble(6, hoaDon.getTienThanhToan());
            pst.setInt(7, 1);
            pst.setString(8, hoaDon.getMaHD());
            pst.setString(9, hoaDon.getKhachHang().getMaKhachHang());
            result = pst.executeUpdate();
            if(result<0){
                return false;
            }
            ChiTietHoaDonDAO cthd_dao = new ChiTietHoaDonDAO();
            boolean kq=cthd_dao.xoaChiTietHoaDon(hoaDon.getMaHD());
            if(kq){
                for(ChiTietHoaDon cthd:danhSachCTHD){
                    if(cthd_dao.themChiTietHoaDon(cthd)){
                        return false;
                    }
                }
            }
            else{
                return false;
            }

        }catch (SQLException ex){
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result > 0;

    }

    @Override
    public HoaDon getHoaDonTheoMaHD(String maHD) {
        HoaDon hoadon=null;
        try{
            Connection con=JDBCUtil.getConnection();
            String sql = "SELECT hd.*,kh.tenKhachHang, kh.soDienThoai,kh.ngayThamGia,kh.gioiTinh,kh.diemTichLuy FROM hoadon as hd join khachhang as kh on hd.khachHang=kh.maKhachHang where maHD = ? AND tinhTrang=1";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, maHD);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maHoaDon= rs.getString("maHD");
                String maKH= rs.getString("khachHang");
                String hoTen= rs.getString("tenKhachHang");
                String sdt= rs.getString("soDienThoai");
                int diemTichLuy= rs.getInt("diemTichLuy");
                int gioiTinh= rs.getInt("gioiTinh");
                KhachHang kh= new KhachHang(maKH, hoTen, sdt,diemTichLuy, gioiTinh);
                NhanVien nv= new NhanVien(rs.getString("nhanVien"));
                ChuongTrinhKhuyenMai ctkm= new ChuongTrinhKhuyenMai(rs.getString("chuongTrinhKM"));
                double tongTien= rs.getDouble("tongTien");
                double tienKhuyenMai= rs.getDouble("tienKhuyenMai");
                double tienThanhToan= rs.getDouble("tienThanhToan");
                Date ngayLap= rs.getDate("ngayLapHoaDon");
                int tinhTrang= rs.getInt("tinhTrang");
                hoadon= new HoaDon(maHoaDon, ngayLap, kh, nv, ctkm, tienKhuyenMai, tongTien, tienThanhToan, tinhTrang);

            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hoadon;
    }

    @Override
    public ArrayList<HoaDon> timKiemHoaDonChuaThanhToan(String sdt) {
        ArrayList<HoaDon> list = new ArrayList<>();
        try{
            Connection con=JDBCUtil.getConnection();
            String sql = "SELECT hd.*,kh.tenKhachHang, kh.gioiTinh, kh.soDienThoai,kh.ngayThamGia FROM hoadon as hd join khachhang as kh on hd.khachHang=kh.maKhachHang where tinhTrang=0 and kh.soDienThoai=?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, sdt);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                String maHD= rs.getString("maHD");
                String maKH= rs.getString("khachHang");
                String hoTen= rs.getString("tenKhachHang");
                String sdt1= rs.getString("soDienThoai");
                int diemTichLuy= rs.getInt("diemTichLuy");
                int gioiTinh= rs.getInt("gioiTinh");
                Date ngayThamGia= rs.getDate("ngayThamGia");
                KhachHang kh= new KhachHang(maKH, hoTen, diemTichLuy, sdt1, ngayThamGia, gioiTinh);
                NhanVien nv= new NhanVien(rs.getString("nhanVien"));
                ChuongTrinhKhuyenMai ctkm= new ChuongTrinhKhuyenMai(rs.getString("chuongTrinhKM"));
                double tongTien= rs.getDouble("tongTien");
                double tienKhuyenMai= rs.getDouble("tienKhuyenMai");
                double tienThanhToan= rs.getDouble("tienThanhToan");
                Date ngayLap= rs.getDate("ngayLapHoaDon");
                int tinhTrang= rs.getInt("tinhTrang");
                HoaDon hd= new HoaDon(maHD, ngayLap, kh, nv, ctkm, tienKhuyenMai, tongTien, tienThanhToan, tinhTrang);

                list.add(hd);
            }
        }catch(SQLException ex){
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public int getSoLuongTonTheoMa(String maSP) {
        return 0;
    }

    @Override
    public ArrayList<HoaDon> getAllHDChuaThanhToan() {
        PreparedStatement pst=null;
        ArrayList<HoaDon> list = new ArrayList<>();
        try{
            Connection con=JDBCUtil.getConnection();
            String sqldel = "Delete from hoadon where year(ngayLapHoaDon)=year(now()) and month(ngayLapHoaDon)=month(now()) and day(ngayLapHoaDon)<day(now()) and tinhTrang=0";
            pst= (PreparedStatement) con.prepareStatement(sqldel);
            pst.executeUpdate();
            String sql = "SELECT hd.*,kh.tenKhachHang, kh.gioiTinh, kh.soDienThoai,kh.ngayThamGia, kh.diemTichLuy FROM hoadon as hd join khachhang as kh on hd.khachHang=kh.maKhachHang where tinhTrang=0";
            pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                String maHD= rs.getString("maHD");
                String maKH= rs.getString("khachHang");
                String hoTen= rs.getString("tenKhachHang");
                String sdt= rs.getString("soDienThoai");
                int diemTichLuy= rs.getInt("diemTichLuy");
                int gioiTinh= rs.getInt("gioiTinh");
                Date ngayThamGia= rs.getDate("ngayThamGia");
                KhachHang kh= new KhachHang(maKH, hoTen, diemTichLuy, sdt, ngayThamGia, gioiTinh);
                NhanVien nv= new NhanVien(rs.getString("nhanVien"));
                ChuongTrinhKhuyenMai ctkm= new ChuongTrinhKhuyenMai(rs.getString("chuongTrinhKM"));
                double tongTien= rs.getDouble("tongTien");
                double tienKhuyenMai= rs.getDouble("tienKhuyenMai");
                double tienThanhToan= rs.getDouble("tienThanhToan");
                Date ngayLap= rs.getDate("ngayLapHoaDon");
                int tinhTrang= rs.getInt("tinhTrang");
                HoaDon hd= new HoaDon(maHD, ngayLap, kh, nv, ctkm, tienKhuyenMai, tongTien, tienThanhToan, tinhTrang);

                list.add(hd);
            }

        }
        catch(SQLException ex){
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return list;
    }

    @Override
    public double getTongTien(String maHD) {
        return 0;
    }

    @Override
    public ArrayList<HoaDon> getHoaDonTheoNgayLap(Date ngayLapHoaDon) {
        ArrayList<HoaDon> list = new ArrayList<>();
        KhachHangDAO kh_dao=new KhachHangDAO();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM hoadon WHERE ngayLapHoaDon = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setDate(1, new java.sql.Date(ngayLapHoaDon.getTime()));
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maHD= rs.getString("maHD");
                String maKH= rs.getString("khachHang");

                KhachHang kh=null;
                if(maKH!=null){
                    KhachHang kh1=kh_dao.selectById(maKH);
                    String hoTen= kh1.getHoTen();
                    String sdt= kh1.getSdt();
                    int diemTichLuy= kh1.getDiemTichLuy();
                    int gioiTinh= kh1.getGioiIinh();
                    Date ngayThamGia= new java.sql.Date(kh1.getNgayThamGia().getTime());
                    kh= new KhachHang(maKH, hoTen, diemTichLuy, sdt, ngayThamGia, gioiTinh);
                }
                NhanVien nv= new NhanVien(rs.getString("nhanVien"));
                ChuongTrinhKhuyenMai ctkm= new ChuongTrinhKhuyenMai(rs.getString("chuongTrinhKM"));
                double tongTien= rs.getDouble("tongTien");
                double tienKhuyenMai= rs.getDouble("tienKhuyenMai");
                double tienThanhToan= rs.getDouble("tienThanhToan");
                Date ngayLap= rs.getDate("ngayLapHoaDon");
                int tinhTrang= rs.getInt("tinhTrang");
                HoaDon hd= new HoaDon(maHD, ngayLap, kh, nv, ctkm, tienKhuyenMai, tongTien, tienThanhToan, tinhTrang);

                list.add(hd);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public ArrayList<HoaDon> getHoaDonTheoMaHDvaNgayLap(String maHD, java.util.Date ngayLap) {
        return null;
    }

    @Override
    public boolean capNhatHoaDonLuuTam(HoaDon hoaDon, ArrayList<ChiTietHoaDon> danhSachCTHD) {
        try{
            Connection con = JDBCUtil.getConnection();
            String sql = "Update hoadon set nhanVien=?, chuongTrinhKM=?, ngayLapHoaDon=?, tienKhuyenMai=?, tongTien=?, tienThanhToan=?, tinhTrang=? where maHD=? and khachHang=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, hoaDon.getNhanVien().getMaNhanVien());
            pst.setString(2, hoaDon.getChuongTrinhKM().getMaCTKM());
            pst.setDate(3, hoaDon.getNgayLapHD());
            pst.setDouble(4, hoaDon.getTienKhuyenMai());
            pst.setDouble(5, hoaDon.getTongTien());
            pst.setDouble(6, hoaDon.getTienThanhToan());
            pst.setInt(7, 0);
            pst.setString(8, hoaDon.getMaHD());
            pst.setString(9, hoaDon.getKhachHang().getMaKhachHang());
            int result = pst.executeUpdate();
            if(result<1){
                System.out.println("false -1");
                return false;
            }
            ChiTietHoaDonDAO cthd_dao = new ChiTietHoaDonDAO();
            boolean kq=cthd_dao.xoaChiTietHoaDon(hoaDon.getMaHD());
            System.out.println("kq: "+kq);
            if(kq){
                for(ChiTietHoaDon cthd:danhSachCTHD){
                    if(cthd_dao.themChiTietHoaDon(cthd)){
                        System.out.println("false 0");
                        return false;
                    }
                }
            }
            else {
                System.out.println("false 1");
                return false;
            }
            JDBCUtil.closeConnection(con);
            return true;
        }

        catch(SQLException ex){
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public ArrayList<HoaDon> selectAll() {
        ArrayList<HoaDon> list = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM hoadon";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maHD= rs.getString("maHD");
                String maKH= rs.getString("khachHang");
                KhachHang kh= new KhachHang(maKH);
                NhanVien nv= new NhanVien(rs.getString("nhanVien"));
                ChuongTrinhKhuyenMai ctkm= new ChuongTrinhKhuyenMai(rs.getString("chuongTrinhKM"));
                double tongTien= rs.getDouble("tongTien");
                double tienKhuyenMai= rs.getDouble("tienKhuyenMai");
                double tienThanhToan= rs.getDouble("tienThanhToan");
                Date ngayLap= rs.getDate("ngayLapHoaDon");
                int tinhTrang= rs.getInt("tinhTrang");
                HoaDon hd= new HoaDon(maHD, ngayLap, kh, nv, ctkm, tienKhuyenMai, tongTien, tienThanhToan, tinhTrang);
                list.add(hd);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}