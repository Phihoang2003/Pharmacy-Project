package DTO;

import java.util.Objects;

public class ChiTietThuocDTO {
    private int maDangKyLuuHanh;
    private int maPhienBan;
    private int maPhieuNhap;
    private int maPhieuXuat;
    private int tinhtTrang;

    public ChiTietThuocDTO() {
    }

    public ChiTietThuocDTO(int maDangKyLuuHanh, int maPhienBan, int maPhieuNhap, int maPhieuXuat, int tinhtTrang) {
        this.maDangKyLuuHanh = maDangKyLuuHanh;
        this.maPhienBan = maPhienBan;
        this.maPhieuNhap = maPhieuNhap;
        this.maPhieuXuat = maPhieuXuat;
        this.tinhtTrang = tinhtTrang;
    }

    public int getMaDangKyLuuHanh() {
        return maDangKyLuuHanh;
    }

    public void setMaDangKyLuuHanh(int maDangKyLuuHanh) {
        this.maDangKyLuuHanh = maDangKyLuuHanh;
    }

    public int getMaPhienBan() {
        return maPhienBan;
    }

    public void setMaPhienBan(int maPhienBan) {
        this.maPhienBan = maPhienBan;
    }

    public int getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(int maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public int getMaPhieuXuat() {
        return maPhieuXuat;
    }

    public void setMaPhieuXuat(int maPhieuXuat) {
        this.maPhieuXuat = maPhieuXuat;
    }

    public int getTinhtTrang() {
        return tinhtTrang;
    }

    public void setTinhtTrang(int tinhtTrang) {
        this.tinhtTrang = tinhtTrang;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChiTietThuocDTO that = (ChiTietThuocDTO) o;
        return maDangKyLuuHanh == that.maDangKyLuuHanh && maPhienBan == that.maPhienBan && maPhieuNhap == that.maPhieuNhap && maPhieuXuat == that.maPhieuXuat && tinhtTrang == that.tinhtTrang;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maDangKyLuuHanh, maPhienBan, maPhieuNhap, maPhieuXuat, tinhtTrang);
    }

    @Override
    public String toString() {
        return "ChiTietThuocDTO{" +
                "maDangKyLuuHanh=" + maDangKyLuuHanh +
                ", maPhienBan=" + maPhienBan +
                ", maPhieuNhap=" + maPhieuNhap +
                ", maPhieuXuat=" + maPhieuXuat +
                ", tinhtTrang=" + tinhtTrang +
                '}';
    }
}
