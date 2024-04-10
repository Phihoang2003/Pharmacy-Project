package BUS;

import DAO.ThuocDAO;
import DTO.Thuoc;
import DTO.TinhTrangSPEnum;
import Interface.SanPham_Interface;

import java.util.ArrayList;

public class SanPham_bus implements SanPham_Interface {
    ThuocDAO thuocDAO = new ThuocDAO();

    @Override
    public ArrayList<Thuoc> selectAll() {
        return thuocDAO.selectAll();
    }

    @Override
    public boolean insert(Thuoc sp) {
        return thuocDAO.insert(sp);
    }

    @Override
    public Thuoc timSanPham(String ma) {
        return thuocDAO.timSanPham(ma);
    }

    @Override
    public boolean update(Thuoc sp) {
        return thuocDAO.update(sp);
    }

    @Override
    public ArrayList<Thuoc> kiemTraTonKho() {
         return thuocDAO.kiemTraTonKho();
    }

    @Override
    public ArrayList<Thuoc> kiemTraHetHan() {
        return thuocDAO.kiemTraHetHan();
    }

    @Override
    public int laySoLuongTonKhoTheoMaSP(String maSP) {
        return 0;
    }

    @Override
    public boolean capNhatSoLuong(String maSP, int soLuongNhap) {
        return false;
    }

    @Override
    public boolean kiemTraMaSanPhamTonTai(String maSP) {
        return thuocDAO.kiemTraMaSanPhamTonTai(maSP);
    }

    @Override
    public void capNhatKhuyenMai() {

    }

    @Override
    public void capNhatTinhTrang(String maSP, TinhTrangSPEnum tinhTrangDangBan) {
        thuocDAO.capNhatTinhTrang(maSP, tinhTrangDangBan);
    }

    @Override
    public Thuoc selectById(String ma) {
        return thuocDAO.selectById(ma);
    }

    @Override
    public boolean capNhatSoLuongTonSauKhiTaoHD(String maSP, int soLuong) {
        return thuocDAO.capNhatSoLuongTonSauKhiTaoHD(maSP, soLuong);
    }

    @Override
    public String getAutoIncrement() {
        return thuocDAO.getAutoIncrement();
    }
}
