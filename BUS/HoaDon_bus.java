package BUS;

import DAO.HoaDonDAO;
import DTO.ChiTietHoaDon;
import DTO.HoaDon;
import Interface.HoaDon_Interface;

import java.sql.Date;
import java.util.ArrayList;

public class HoaDon_bus implements HoaDon_Interface{
    HoaDonDAO hd_dao=new HoaDonDAO();
    @Override
    public boolean themHoaDon(HoaDon hoaDon, ArrayList<ChiTietHoaDon> danhSachCTHD) {
        return hd_dao.themHoaDon(hoaDon,danhSachCTHD);
    }

    @Override
    public HoaDon selectByMaHD(String maHD) {
        return hd_dao.selectByMaHD(maHD);
    }

    @Override
    public String getAutoIncrement() {
        return hd_dao.getAutoIncrement();
    }

    @Override
    public boolean luuTamHoaDon(HoaDon hoaDon, ArrayList<ChiTietHoaDon> danhSachCTHD) {
        return hd_dao.luuTamHoaDon(hoaDon,danhSachCTHD);
    }

    @Override
    public boolean themHoaDonLuuTam(HoaDon hoaDon, ArrayList<ChiTietHoaDon> danhSachCTHD) {
        return hd_dao.themHoaDonLuuTam(hoaDon,danhSachCTHD);
    }

    @Override
    public HoaDon getHoaDonTheoMaHD(String maHD) {
        return hd_dao.getHoaDonTheoMaHD(maHD);
    }

    @Override
    public ArrayList<HoaDon> timKiemHoaDonChuaThanhToan(String sdt) {
        return hd_dao.timKiemHoaDonChuaThanhToan(sdt);
    }

    @Override
    public int getSoLuongTonTheoMa(String maSP) {
        return hd_dao.getSoLuongTonTheoMa(maSP);
    }

    @Override
    public ArrayList<HoaDon> getAllHDChuaThanhToan() {
        return hd_dao.getAllHDChuaThanhToan();
    }

    @Override
    public double getTongTien(String maHD) {
        return hd_dao.getTongTien(maHD);
    }

    @Override
    public ArrayList<HoaDon> getHoaDonTheoNgayLap(Date ngayLap) {
        return hd_dao.getHoaDonTheoNgayLap(ngayLap);
    }

    @Override
    public ArrayList<HoaDon> getHoaDonTheoMaHDvaNgayLap(String maHD, java.util.Date ngayLap) {
        return hd_dao.getHoaDonTheoMaHDvaNgayLap(maHD,ngayLap);
    }

    @Override
    public boolean capNhatHoaDonLuuTam(HoaDon hoaDon, ArrayList<ChiTietHoaDon> danhSachCTHD) {
        return hd_dao.capNhatHoaDonLuuTam(hoaDon,danhSachCTHD);
    }
}
