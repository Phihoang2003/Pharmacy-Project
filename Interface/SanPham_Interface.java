package Interface;

import DTO.ThuocDTO;
import DTO.TinhTrangSPEnum;

import java.util.ArrayList;

public interface SanPham_Interface {
    public ArrayList<ThuocDTO> selectAll();

    public boolean insert(ThuocDTO sp);

    public ArrayList<ThuocDTO> timSanPham(String ma);

    public boolean update(ThuocDTO sp);

    public ArrayList<ThuocDTO> kiemTraTonKho();

    public int laySoLuongTonKhoTheoMaSP(String maSP);

    public boolean capNhatSoLuong(String maSP, int soLuongNhap);

    public boolean kiemTraMaSanPhamTonTai(String maSP);

    public void capNhatKhuyenMai();

    public void capNhatTinhTrang(String maSP, TinhTrangSPEnum tinhTrangDangBan);

    public ThuocDTO selectById(String ma);
    public boolean capNhatSoLuongTonSauKhiTaoHD(String maSP, int soLuong);
    public String getAutoIncrement();
}
