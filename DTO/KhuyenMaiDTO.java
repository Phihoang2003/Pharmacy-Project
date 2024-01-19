package DTO;

import java.util.Date;
import java.util.Objects;

public class KhuyenMaiDTO {
    private String maKM,tenKM;
    private String chietKhau;
    private String loaiKhuyenMai;
    private Date ngayBatDau;
    private Date ngayHetHan;
    private String trangThai;
    private double soTienToiThieu;

    private double soTienToiDa;
    public KhuyenMaiDTO() {
    }

    public KhuyenMaiDTO(String maKM, String tenKM, String chietKhau, String loaiKhuyenMai, Date ngayBatDau, Date ngayHetHan, String trangThai, double soTienToiThieu, double soTienToiDa) {
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.chietKhau = chietKhau;
        this.loaiKhuyenMai = loaiKhuyenMai;
        this.ngayBatDau = ngayBatDau;
        this.ngayHetHan = ngayHetHan;
        this.trangThai = trangThai;
        this.soTienToiThieu = soTienToiThieu;
        this.soTienToiDa = soTienToiDa;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getTenKM() {
        return tenKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }

    public String getChietKhau() {
        return chietKhau;
    }

    public void setChietKhau(String chietKhau) {
        this.chietKhau = chietKhau;
    }

    public String getLoaiKhuyenMai() {
        return loaiKhuyenMai;
    }

    public void setLoaiKhuyenMai(String loaiKhuyenMai) {
        this.loaiKhuyenMai = loaiKhuyenMai;
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

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public double getSoTienToiThieu() {
        return soTienToiThieu;
    }

    public void setSoTienToiThieu(double soTienToiThieu) {
        this.soTienToiThieu = soTienToiThieu;
    }

    public double getSoTienToiDa() {
        return soTienToiDa;
    }

    public void setSoTienToiDa(double soTienToiDa) {
        this.soTienToiDa = soTienToiDa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KhuyenMaiDTO that = (KhuyenMaiDTO) o;
        return Objects.equals(maKM, that.maKM);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maKM);
    }

    @Override
    public String toString() {
        return "KhuyenMaiDTO{" +
                "maKM='" + maKM + '\'' +
                ", tenKM='" + tenKM + '\'' +
                ", chietKhau='" + chietKhau + '\'' +
                ", loaiKhuyenMai='" + loaiKhuyenMai + '\'' +
                ", ngayBatDau=" + ngayBatDau +
                ", ngayHetHan=" + ngayHetHan +
                ", trangThai=" + trangThai +
                ", soTienToiThieu=" + soTienToiThieu +
                ", soTienToiDa=" + soTienToiDa +
                '}';
    }
}

