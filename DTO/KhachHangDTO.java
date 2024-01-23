package DTO;

import java.util.Date;
import java.util.Objects;

public class KhachHangDTO {
    private int maKhachHang;
    private String hoTen;
    private String diaChi;
    private String sdt;
    private Date ngayThamGia;
    private NhomKhachHangDTO nhomKhachHang;
    public KhachHangDTO() {
    }

    public KhachHangDTO(int maKhachHang, String hoten, String sdt, String diaChi,NhomKhachHangDTO nhomKhachHang) {
        this.maKhachHang = maKhachHang;
        this.hoTen = hoten;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.nhomKhachHang=nhomKhachHang;
    }
    public NhomKhachHangDTO getNhomKhachHang() {
        return nhomKhachHang;
    }

    public void setNhomKhachHang(NhomKhachHangDTO nhomKhachHang) {
        this.nhomKhachHang = nhomKhachHang;
    }

    public KhachHangDTO(int maKhachHang, String hoTen, String diaChi, String sdt, Date ngayThamGia, NhomKhachHangDTO nhomKhachHang) {
        this.maKhachHang = maKhachHang;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.ngayThamGia = ngayThamGia;
        this.nhomKhachHang= nhomKhachHang;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Date getNgayThamGia() {
        return ngayThamGia;
    }

    public void setNgayThamGia(Date ngayThamGia) {
        this.ngayThamGia = ngayThamGia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KhachHangDTO that = (KhachHangDTO) o;
        return maKhachHang == that.maKhachHang;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maKhachHang);
    }

    @Override
    public String toString() {
        return "KhachHangDTO{" +
                "maKhachHang=" + maKhachHang +
                ", hoTen='" + hoTen + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", sdt='" + sdt + '\'' +
                ", ngayThamGia=" + ngayThamGia +
                ", nhomKhachHang=" + nhomKhachHang +
                '}';
    }
}
