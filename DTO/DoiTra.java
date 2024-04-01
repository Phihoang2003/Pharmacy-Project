package DTO;

import java.sql.Date;
import java.util.Objects;

public class DoiTra {
    private String maDT;
    private HoaDon hoaDon;
    private NhanVien nhanVien;
    private HinhThucDoiTraEnum hinhThucDoiTra;

    private String lyDoDoiTra;
    private Date thoiGianDoiTra;
    private double tongTien;

    public String getLyDoDoiTra() {
        return lyDoDoiTra;
    }

    public void setLyDoDoiTra(String lyDoDoiTra) {
        this.lyDoDoiTra = lyDoDoiTra;
    }

    public DoiTra(String maDT, HoaDon hoaDon, NhanVien nhanVien, HinhThucDoiTraEnum hinhThucDoiTra, String lyDoDoiTra, Date thoiGianDoiTra, double tongTien) {
        this.maDT = maDT;
        this.hoaDon = hoaDon;
        this.nhanVien = nhanVien;
        this.hinhThucDoiTra = hinhThucDoiTra;
        this.thoiGianDoiTra = thoiGianDoiTra;
        this.tongTien = tongTien;
        this.lyDoDoiTra = lyDoDoiTra;
    }

    public DoiTra() {
    }

    public DoiTra(String maDT) {
        this.maDT = maDT;
    }

    public String getMaDT() {
        return maDT;
    }

    public void setMaDT(String maDT) {
        this.maDT = maDT;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public HinhThucDoiTraEnum getHinhThucDoiTra() {
        return hinhThucDoiTra;
    }

    public void setHinhThucDoiTra(HinhThucDoiTraEnum hinhThucDoiTra) {
        this.hinhThucDoiTra = hinhThucDoiTra;
    }

    public Date getThoiGianDoiTra() {
        return thoiGianDoiTra;
    }

    public void setThoiGianDoiTra(Date thoiGianDoiTra) {
        this.thoiGianDoiTra = thoiGianDoiTra;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoiTra doiTra = (DoiTra) o;
        return Objects.equals(maDT, doiTra.maDT);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maDT);
    }

    @Override
    public String toString() {
        return "DoiTra{" +
                "maDT='" + maDT + '\'' +
                ", hoaDon=" + hoaDon +
                ", nhanVien=" + nhanVien +
                ", hinhThucDoiTra=" + hinhThucDoiTra +
                ", thoiGianDoiTra=" + thoiGianDoiTra +
                ", lyDoDoiTra='" + lyDoDoiTra + '\'' +
                ", tongTien=" + tongTien +
                '}';
    }
}
