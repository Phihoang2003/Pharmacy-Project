package Interface;

import DTO.ChiTietHoaDon;
import DTO.Thuoc;


import java.util.ArrayList;

public interface ChiTietHoaDon_Interface {
    public boolean themChiTietHoaDon(ChiTietHoaDon cthd);
    public boolean xoaChiTietHoaDon(String maHD);
    public ArrayList<ChiTietHoaDon> getAllCTHDTheoMaHD(String maHD);
    public ArrayList<ChiTietHoaDon> getallCTHD();
    public ArrayList<Thuoc> getSanPhamTheoMaSP(String maSP);
    public ArrayList<Thuoc> getSanPhamTheoMaHD(String maHD);
    public int soluongSP(String maHD,String maSP);
    public int getSoLuongCTHD(String maSP);
    public ArrayList<ChiTietHoaDon> getCTHDTheoMaHDvaMaSP(String maHD,String maSP);

}
