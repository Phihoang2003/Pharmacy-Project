package DTO;

import java.util.Date;
import java.util.Objects;

public class KhachHang {
    private String maKhachHang;
    private String hoTen;
    private String diaChi;
    private String sdt;
    private Date ngayThamGia;
    private int gioiTinh;
    public KhachHang() {
    }
    public KhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public KhachHang(String maKhachHang, String hoten, String sdt, String diaChi, int gioiTinh) {
        this.maKhachHang = maKhachHang;
        this.hoTen = hoten;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.gioiTinh=gioiTinh;
    }
    public int getGioiIinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public KhachHang(String maKhachHang, String hoTen, String diaChi, String sdt, Date ngayThamGia, int gioiTinh) {
        this.maKhachHang = maKhachHang;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.ngayThamGia = ngayThamGia;
        this.gioiTinh= gioiTinh;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
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
        KhachHang that = (KhachHang) o;
        return maKhachHang.equals(that.maKhachHang) ;
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
                ", gioiTinh=" + gioiTinh +
                '}';
    }
}
