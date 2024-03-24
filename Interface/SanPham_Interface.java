package Interface;

import DTO.Thuoc;
import DTO.TinhTrangSPEnum;

import java.util.ArrayList;

public interface SanPham_Interface {
    public ArrayList<Thuoc> selectAll();

    public boolean insert(Thuoc sp);

    public Thuoc timSanPham(String ma);

    public boolean update(Thuoc sp);

    public ArrayList<Thuoc> kiemTraTonKho();

    public int laySoLuongTonKhoTheoMaSP(String maSP);

    public boolean capNhatSoLuong(String maSP, int soLuongNhap);

    public boolean kiemTraMaSanPhamTonTai(String maSP);

    public void capNhatKhuyenMai();

    public void capNhatTinhTrang(String maSP, TinhTrangSPEnum tinhTrangDangBan);

    public Thuoc selectById(String ma);
    public boolean capNhatSoLuongTonSauKhiTaoHD(String maSP, int soLuong);
    public String getAutoIncrement();
}
