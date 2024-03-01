package BUS;

import DAO.NhanVienDAO;
import DAO.ThuocDAO;
import DTO.ThuocDTO;
import DTO.TinhTrangSPEnum;
import Interface.SanPham_Interface;

import java.util.ArrayList;

public class SanPham_bus implements SanPham_Interface {
    ThuocDAO thuocDAO = new ThuocDAO();

    @Override
    public ArrayList<ThuocDTO> selectAll() {
        return null;
    }

    @Override
    public boolean insert(ThuocDTO sp) {
        return thuocDAO.insert(sp);
    }

    @Override
    public ArrayList<ThuocDTO> timSanPham(String ma) {
        return null;
    }

    @Override
    public boolean update(ThuocDTO sp) {
        return false;
    }

    @Override
    public ArrayList<ThuocDTO> kiemTraTonKho() {
        return null;
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
        return false;
    }

    @Override
    public void capNhatKhuyenMai() {

    }

    @Override
    public void capNhatTinhTrang(String maSP, TinhTrangSPEnum tinhTrangDangBan) {

    }

    @Override
    public ThuocDTO selectById(String ma) {
        return thuocDAO.selectById(ma);
    }

    @Override
    public boolean capNhatSoLuongTonSauKhiTaoHD(String maSP, int soLuong) {
        return false;
    }

    @Override
    public String getAutoIncrement() {
        return thuocDAO.getAutoIncrement();
    }
}
