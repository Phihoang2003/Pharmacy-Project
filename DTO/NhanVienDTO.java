package DTO;

import java.util.Date;
import java.util.Objects;

public class NhanVienDTO {
    private String maNhanVien;
    private String hoTen;
    private int gioiTinh;
    private String diaChi;
    private String sdt;
    private Date ngaySinh;
    private TinhTrangNVEnum trangThai;
    private ChucVuEnum chucVu;
    private String email;
    private Date ngayVaoLam;
    private CaLamViecEnum caLamViec;

    public NhanVienDTO() {
    }
    public NhanVienDTO(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public ChucVuEnum getChucVu() {
        return chucVu;
    }

    public void setChucVu(ChucVuEnum chucVu) {
        this.chucVu = chucVu;
    }

    public NhanVienDTO(String maNhanVien, String hoTen, String diaChi, int gioiTinh, String sdt, Date ngaySinh, TinhTrangNVEnum trangThai, ChucVuEnum chucVu, String email, Date ngayVaoLam, CaLamViecEnum caLamViec) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.ngaySinh = ngaySinh;
        this.trangThai = trangThai;
        this.email = email;
        this.ngayVaoLam = ngayVaoLam;
        this.caLamViec = caLamViec;
        this.diaChi = diaChi;
        this.chucVu = chucVu;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public TinhTrangNVEnum getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(TinhTrangNVEnum trangThai) {
        this.trangThai = trangThai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(Date ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public CaLamViecEnum getCaLamViec() {
        return caLamViec;
    }

    public void setCaLamViec(CaLamViecEnum caLamViec) {
        this.caLamViec = caLamViec;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NhanVienDTO that = (NhanVienDTO) o;
        return maNhanVien.equals(that.maNhanVien) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maNhanVien);
    }

    @Override
    public String toString() {
        return "NhanVienDTO{" +
                "maNhanVien=" + maNhanVien +
                ", hoTen='" + hoTen + '\'' +
                ", gioiTinh=" + gioiTinh +
                ", sdt='" + sdt + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", trangThai=" + trangThai +
                ", email='" + email + '\'' +
                ", diaChi='" + diaChi +
                ", ngayVaoLam=" + ngayVaoLam +
                ", caLamViec='" + caLamViec + '\'' +
                ", chucVu='" + chucVu +
                '}';
    }
}
