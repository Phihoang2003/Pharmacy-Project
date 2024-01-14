package DTO;

import java.util.Objects;

public class ChiTietKiemKeThuocDTO {
    private int maDangKyLuuHanh;
    private int maPhienBan;
    private int maKiemKe;
    private int trangThai;

    public ChiTietKiemKeThuocDTO() {
    }

    public ChiTietKiemKeThuocDTO(int maDangKyLuuHanh, int maPhienBan, int maKiemKe, int trangThai) {
        this.maDangKyLuuHanh = maDangKyLuuHanh;
        this.maPhienBan = maPhienBan;
        this.maKiemKe = maKiemKe;
        this.trangThai = trangThai;
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

    public int getMaKiemKe() {
        return maKiemKe;
    }

    public void setMaKiemKe(int maKiemKe) {
        this.maKiemKe = maKiemKe;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChiTietKiemKeThuocDTO that = (ChiTietKiemKeThuocDTO) o;
        return maDangKyLuuHanh == that.maDangKyLuuHanh && maPhienBan == that.maPhienBan && maKiemKe == that.maKiemKe;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maDangKyLuuHanh, maPhienBan, maKiemKe);
    }

    @Override
    public String toString() {
        return "ChiTietKiemKeThuoc{" +
                "maDangKyLuuHanh=" + maDangKyLuuHanh +
                ", maPhienBan=" + maPhienBan +
                ", maKiemKe=" + maKiemKe +
                ", trangThai=" + trangThai +
                '}';
    }
}
