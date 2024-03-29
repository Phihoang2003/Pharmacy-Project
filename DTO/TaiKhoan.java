package DTO;

import java.util.Date;
import java.util.Objects;

public class TaiKhoan {

    private String tenTK;
    private String matKhau;
    private Date thoiGianDN;
    private NhanVien nhanVien;
    private int trangThai;

    public TaiKhoan() {
    }

    public TaiKhoan(String tenTK, String matKhau, Date thoiGianDN, NhanVien nhanVien, int trangThai) {
        this.tenTK = tenTK;
        this.matKhau = matKhau;
        this.thoiGianDN = thoiGianDN;
        this.nhanVien = nhanVien;
        this.trangThai = trangThai;
    }

    public String getTenTK() {
        return tenTK;
    }

    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public Date getThoiGianDN() {
        return thoiGianDN;
    }

    public void setThoiGianDN(Date thoiGianDN) {
        this.thoiGianDN = thoiGianDN;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
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
        TaiKhoan taiKhoan = (TaiKhoan) o;
        return Objects.equals(nhanVien, taiKhoan.nhanVien);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nhanVien);
    }

    @Override
    public String toString() {
        return "TaiKhoan{" +
                "tenTK='" + tenTK + '\'' +
                ", matKhau='" + matKhau + '\'' +
                ", thoiGianDN=" + thoiGianDN +
                ", nhanVien=" + nhanVien +
                ", trangThai=" + trangThai +
                '}';
    }
}
