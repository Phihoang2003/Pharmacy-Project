package BUS;

import DAO.HoaDonDAO;
import DTO.ChiTietHoaDon;
import DTO.HoaDon;
import Interface.HoaDon_Interface;

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
        return null;
    }

    @Override
    public int getSoLuongTonTheoMa(String maSP) {
        return 0;
    }

    @Override
    public ArrayList<HoaDon> getAllHDChuaThanhToan() {
        return hd_dao.getAllHDChuaThanhToan();
    }
}
