package Interface;

import DTO.ChiTietHoaDon;
import DTO.HoaDon;

import java.util.ArrayList;

public interface HoaDon_Interface {
    public boolean themHoaDon(HoaDon hoaDon, ArrayList<ChiTietHoaDon> danhSachCTHD);
    public HoaDon selectByMaHD(String maHD);
    public String getAutoIncrement();
    public boolean luuTamHoaDon(HoaDon hoaDon, ArrayList<ChiTietHoaDon> danhSachCTHD);
    public boolean themHoaDonLuuTam(HoaDon hoaDon, ArrayList<ChiTietHoaDon> danhSachCTHD);
    public HoaDon getHoaDonTheoMaHD(String maHD);
}
