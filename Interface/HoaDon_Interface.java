package Interface;

import DTO.ChiTietHoaDon;
import DTO.HoaDon;

import java.util.ArrayList;
import java.util.Date;

public interface HoaDon_Interface {
    public boolean themHoaDon(HoaDon hoaDon, ArrayList<ChiTietHoaDon> danhSachCTHD);
    public HoaDon selectByMaHD(String maHD);
    public String getAutoIncrement();
    public boolean luuTamHoaDon(HoaDon hoaDon, ArrayList<ChiTietHoaDon> danhSachCTHD);
    public boolean themHoaDonLuuTam(HoaDon hoaDon, ArrayList<ChiTietHoaDon> danhSachCTHD);
    public HoaDon getHoaDonTheoMaHD(String maHD);
    public ArrayList<HoaDon> timKiemHoaDonChuaThanhToan(String sdt);
    public int getSoLuongTonTheoMa(String maSP);
    public ArrayList<HoaDon> getAllHDChuaThanhToan();
    public double getTongTien(String maHD);
    public ArrayList<HoaDon> getHoaDonTheoNgayLap(java.sql.Date ngayLap);
    public ArrayList<HoaDon> getHoaDonTheoMaHDvaNgayLap(String maHD, Date ngayLap);
    public boolean capNhatHoaDonLuuTam(HoaDon hoaDon, ArrayList<ChiTietHoaDon> danhSachCTHD);

}
