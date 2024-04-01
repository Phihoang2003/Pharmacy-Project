package BUS;

import DAO.ChiTietHoaDonDAO;
import DTO.ChiTietHoaDon;
import DTO.Thuoc;
import Interface.ChiTietHoaDon_Interface;
import java.util.ArrayList;

public class ChiTietHoaDon_bus implements ChiTietHoaDon_Interface {
    ChiTietHoaDonDAO cthd_dao = new ChiTietHoaDonDAO();
    @Override
    public boolean themChiTietHoaDon(ChiTietHoaDon cthd) {
        return cthd_dao.themChiTietHoaDon(cthd);
    }

    @Override
    public boolean xoaChiTietHoaDon(String maHD) {
        return cthd_dao.xoaChiTietHoaDon(maHD);
    }

    @Override
    public ArrayList<ChiTietHoaDon> getAllCTHDTheoMaHD(String maHD) {
        return cthd_dao.getAllCTHDTheoMaHD(maHD);
    }

    @Override
    public ArrayList<ChiTietHoaDon> getallCTHD() {
        return cthd_dao.getallCTHD();
    }

    @Override
    public ArrayList<Thuoc> getSanPhamTheoMaSP(String maSP) {
        return cthd_dao.getSanPhamTheoMaSP(maSP);
    }

    @Override
    public ArrayList<Thuoc> getSanPhamTheoMaHD(String maHD) {
        return cthd_dao.getSanPhamTheoMaHD(maHD);
    }

    @Override
    public int soluongSP(String maHD, String maSP) {
        return cthd_dao.soluongSP(maHD, maSP);
    }

    @Override
    public int getSoLuongCTHD(String maSP) {
        return cthd_dao.getSoLuongCTHD(maSP);
    }

    @Override
    public ArrayList<ChiTietHoaDon> getCTHDTheoMaHDvaMaSP(String maHD, String maSP) {
        return cthd_dao.getCTHDTheoMaHDvaMaSP(maHD, maSP);
    }
}
