package DTO;

import java.util.Objects;

public class PhienBanThuocDTO {
    private int maPhienBanThuoc;
    private int maThuoc;

    private String khoiLuong;

    private String duongDung;
    private String quyCachDongGoi;
    private double giaBanLe;
    private double giaBanBuon;
    private double giaNhap;
    private int soLuongTon;
    public PhienBanThuocDTO() {
    }

    public PhienBanThuocDTO(int maPhienBanThuoc, int maThuoc, String khoiLuong, String duongDung, String quyCachDongGoi, double giaBanLe, double giaBanBuon, double giaNhap, int soLuongTon) {
        this.maPhienBanThuoc = maPhienBanThuoc;
        this.maThuoc = maThuoc;
        this.khoiLuong = khoiLuong;
        this.duongDung = duongDung;
        this.quyCachDongGoi = quyCachDongGoi;
        this.giaBanLe = giaBanLe;
        this.giaBanBuon = giaBanBuon;
        this.giaNhap = giaNhap;
        this.soLuongTon = soLuongTon;


    }

    public int getMaPhienBanThuoc() {
        return maPhienBanThuoc;
    }

    public void setMaPhienBanThuoc(int maPhienBanThuoc) {
        this.maPhienBanThuoc = maPhienBanThuoc;
    }

    public int getMaThuoc() {
        return maThuoc;
    }

    public void setMaThuoc(int maThuoc) {
        this.maThuoc = maThuoc;
    }

    public String getKhoiLuong() {
        return khoiLuong;
    }

    public void setKhoiLuong(String khoiLuong) {
        this.khoiLuong = khoiLuong;
    }

    public String getDuongDung() {
        return duongDung;
    }

    public void setDuongDung(String duongDung) {
        this.duongDung = duongDung;
    }

    public String getQuyCachDongGoi() {
        return quyCachDongGoi;
    }

    public void setQuyCachDongGoi(String quyCachDongGoi) {
        this.quyCachDongGoi = quyCachDongGoi;
    }

    public double getGiaBanLe() {
        return giaBanLe;
    }

    public void setGiaBanLe(double giaBanLe) {
        this.giaBanLe = giaBanLe;
    }

    public double getGiaBanBuon() {
        return giaBanBuon;
    }

    public void setGiaBanBuon(double giaBanBuon) {
        this.giaBanBuon = giaBanBuon;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhienBanThuocDTO that = (PhienBanThuocDTO) o;
        return maPhienBanThuoc == that.maPhienBanThuoc && maThuoc == that.maThuoc;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maPhienBanThuoc, maThuoc);
    }

    @Override
    public String toString() {
        return "PhienBanThuocDTO{" +
                "maPhienBanThuoc=" + maPhienBanThuoc +
                ", maThuoc=" + maThuoc +
                ", khoiLuong='" + khoiLuong + '\'' +
                ", duongDung='" + duongDung + '\'' +
                ", quyCachDongGoi='" + quyCachDongGoi + '\'' +
                ", giaBanLe=" + giaBanLe +
                ", giaBanBuon=" + giaBanBuon +
                ", giaNhap=" + giaNhap +
                ", soLuongTon=" + soLuongTon +
                '}';
    }
}
