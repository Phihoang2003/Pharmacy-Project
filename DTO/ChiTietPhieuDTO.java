package DTO;

import java.util.Objects;

public class ChiTietPhieuDTO {
    private int maPhieu;
    private int maPhienBanThuoc;

    private int soLuong;
    private int donGia;

    public ChiTietPhieuDTO() {
    }

    public ChiTietPhieuDTO(int maPhieu, int maPhienBanThuoc, int soLuong, int donGia) {
        this.maPhieu = maPhieu;
        this.maPhienBanThuoc = maPhienBanThuoc;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public int getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(int maPhieu) {
        this.maPhieu = maPhieu;
    }

    public int getMaPhienBanThuoc() {
        return maPhienBanThuoc;
    }

    public void setMaPhienBanThuoc(int maPhienBanThuoc) {
        this.maPhienBanThuoc = maPhienBanThuoc;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChiTietPhieuDTO that = (ChiTietPhieuDTO) o;
        return maPhieu == that.maPhieu && maPhienBanThuoc == that.maPhienBanThuoc;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maPhieu, maPhienBanThuoc);
    }

    @Override
    public String toString() {
        return "ChiTietPhieuDTO{" +
                "maPhieu=" + maPhieu +
                ", maPhienBanThuoc=" + maPhienBanThuoc +
                ", soLuong=" + soLuong +
                ", donGia=" + donGia +
                '}';
    }
}
