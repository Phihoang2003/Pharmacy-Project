package DTO;

import java.util.Objects;

public class ChiTietPhieuNhapDTO extends ChiTietPhieuDTO {
    private int phuongThucNhap;

    public ChiTietPhieuNhapDTO(int phuongThucNhap) {
        this.phuongThucNhap = phuongThucNhap;
    }

    public ChiTietPhieuNhapDTO(int maPhieu, int maPhienBanThuoc, int soLuong, int donGia, int phuongThucNhap) {
        super(maPhieu, maPhienBanThuoc, soLuong, donGia);
        this.phuongThucNhap = phuongThucNhap;
    }

    public int getPhuongThucNhap() {
        return phuongThucNhap;
    }

    public void setPhuongThucNhap(int phuongThucNhap) {
        this.phuongThucNhap = phuongThucNhap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ChiTietPhieuNhapDTO that = (ChiTietPhieuNhapDTO) o;
        return phuongThucNhap == that.phuongThucNhap;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), phuongThucNhap);
    }

    @Override
    public String toString() {
        return "ChiTietPhieuNhapDTO{" +
                "phuongThucNhap=" + phuongThucNhap +
                '}'+super.toString();
    }
}
