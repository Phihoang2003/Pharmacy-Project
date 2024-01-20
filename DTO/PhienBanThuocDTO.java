package DTO;

import java.util.Objects;

public class PhienBanThuocDTO {
    private String maPhienBanThuoc;
    private String maThuoc;
    private String donViTinh;
    private String khoiLuong;
    private String imgUrl;
    private String duongDung;
    private String quyCachDongGoi;
    private double giaBan;
    private double giaNhap;
    private int soLuongTon;
    private String nuocSanXuat;

    public PhienBanThuocDTO() {
    }

    public PhienBanThuocDTO(String maPhienBanThuoc, String maThuoc, String donViTinh, String khoiLuong, String imgUrl, String duongDung, String quyCachDongGoi, double giaBan, double giaNhap, int soLuongTon, String nuocSanXuat){
        this.maPhienBanThuoc = maPhienBanThuoc;
        this.maThuoc = maThuoc;
        this.donViTinh = donViTinh;
        this.khoiLuong = khoiLuong;
        this.imgUrl = imgUrl;
        this.duongDung = duongDung;
        this.quyCachDongGoi = quyCachDongGoi;
        this.giaBan = giaBan;
        this.giaNhap = giaNhap;
        this.soLuongTon = soLuongTon;
        this.nuocSanXuat = nuocSanXuat;
    }

    public String getMaPhienBanThuoc() {
        return maPhienBanThuoc;
    }

    public void setMaPhienBanThuoc(String maPhienBanThuoc) {
        this.maPhienBanThuoc = maPhienBanThuoc;
    }

    public String getMaThuoc() {
        return maThuoc;
    }

    public void setMaThuoc(String maThuoc) {
        this.maThuoc = maThuoc;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public String getKhoiLuong() {
        return khoiLuong;
    }

    public void setKhoiLuong(String khoiLuong) {
        this.khoiLuong = khoiLuong;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
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

    public String getNuocSanXuat() {
        return nuocSanXuat;
    }

    public void setNuocSanXuat(String nuocSanXuat) {
        this.nuocSanXuat = nuocSanXuat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhienBanThuocDTO that = (PhienBanThuocDTO) o;
        return maPhienBanThuoc.equals(that.maPhienBanThuoc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maPhienBanThuoc);
    }

    @Override
    public String toString() {
        return "PhienBanThuocDTO{" +
                "maPhienBanThuoc=" + maPhienBanThuoc +
                ", maThuoc=" + maThuoc +
                ", donViTinh='" + donViTinh + '\'' +
                ", khoiLuong='" + khoiLuong + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", duongDung='" + duongDung + '\'' +
                ", quyCachDongGoi='" + quyCachDongGoi + '\'' +
                ", giaBan=" + giaBan +
                ", giaNhap=" + giaNhap +
                ", soLuongTon=" + soLuongTon +
                ", nuocSanXuat='" + nuocSanXuat + '\'' +
                '}';
    }
}
