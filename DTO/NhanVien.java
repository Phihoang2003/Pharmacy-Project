package DTO;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class NhanVien {
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

    public NhanVien() {
    }
    public NhanVien(String maNhanVien) {
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

    public NhanVien(String maNhanVien, String hoTen, String diaChi, int gioiTinh, String sdt, Date ngaySinh, TinhTrangNVEnum trangThai, ChucVuEnum chucVu, String email, Date ngayVaoLam, CaLamViecEnum caLamViec) {
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
        NhanVien that = (NhanVien) o;
        return maNhanVien.equals(that.maNhanVien) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maNhanVien);
    }

    public static int getAge(Date currentDate, Date birthDate) {
        Calendar calendarCurrent = Calendar.getInstance();
        calendarCurrent.setTime(currentDate);

        Calendar calendarBirth = Calendar.getInstance();
        calendarBirth.setTime(birthDate);

        int years = calendarCurrent.get(Calendar.YEAR) - calendarBirth.get(Calendar.YEAR);

        // Check if the birthdate has occurred this year
        if (calendarBirth.get(Calendar.MONTH) > calendarCurrent.get(Calendar.MONTH)
                || (calendarBirth.get(Calendar.MONTH) == calendarCurrent.get(Calendar.MONTH)
                && calendarBirth.get(Calendar.DAY_OF_MONTH) > calendarCurrent.get(Calendar.DAY_OF_MONTH))) {
            years--;
        }

        return years;}

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
