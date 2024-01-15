package DTO;

import java.util.Date;
import java.util.Objects;

public class KhuyenMai {
    private int maKM;
    private int chietKhau;
    private int daSuDung;
    private String moTa;
    private Date ngayBatDau;
    private Date ngayHetHan;
    private int tongSoLuong;
    private int trangThai;

    public KhuyenMai() {
    }

    public KhuyenMai(int maKM, int chietKhau, int daSuDung, String moTa, Date ngayBatDau, Date ngayHetHan, int tongSoLuong, int trangThai) {
        this.maKM = maKM;
        this.chietKhau = chietKhau;
        this.daSuDung = daSuDung;
        this.moTa = moTa;
        this.ngayBatDau = ngayBatDau;
        this.ngayHetHan = ngayHetHan;
        this.tongSoLuong = tongSoLuong;
        this.trangThai = trangThai;
    }

    public int getMaKM() {
        return maKM;
    }

    public void setMaKM(int maKM) {
        this.maKM = maKM;
    }

    public int getChietKhau() {
        return chietKhau;
    }

    public void setChietKhau(int chietKhau) {
        this.chietKhau = chietKhau;
    }

    public int getDaSuDung() {
        return daSuDung;
    }

    public void setDaSuDung(int daSuDung) {
        this.daSuDung = daSuDung;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(Date ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    public int getTongSoLuong() {
        return tongSoLuong;
    }

    public void setTongSoLuong(int tongSoLuong) {
        this.tongSoLuong = tongSoLuong;
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
        KhuyenMai khuyenMai = (KhuyenMai) o;
        return maKM == khuyenMai.maKM;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maKM);
    }

    @Override
    public String toString() {
        return "KhuyenMai{" +
                "maKM=" + maKM +
                ", chietKhau=" + chietKhau +
                ", daSuDung=" + daSuDung +
                ", moTa='" + moTa + '\'' +
                ", ngayBatDau=" + ngayBatDau +
                ", ngayHetHan=" + ngayHetHan +
                ", tongSoLuong=" + tongSoLuong +
                ", trangThai=" + trangThai +
                '}';
    }
}
