package DTO;

import java.sql.Date;
import java.util.Objects;

public class HoaDonDTO {
    private int maHD;
    private Date ngayLapHD;
    private int maKhachHang;
    private int maNhanVien;
    private int maChuongTrinhKM;

    private double tienKhuyenMai;
    private double tongTien;
    private double tienThanhToan;
    private TinhTrangHoaDonEnum tinhTrang;

    public HoaDonDTO() {
    }

    public HoaDonDTO(int maHD, Date ngayLapHD, int maKhachHang, int maNhanVien, int maChuongTrinhKM, double tienKhuyenMai, double tongTien, double tienThanhToan, TinhTrangHoaDonEnum tinhTrang) {
        this.maHD = maHD;
        this.ngayLapHD = ngayLapHD;
        this.maKhachHang = maKhachHang;
        this.maNhanVien = maNhanVien;
        this.maChuongTrinhKM = maChuongTrinhKM;
        this.tienKhuyenMai = tienKhuyenMai;
        this.tongTien = tongTien;
        this.tienThanhToan = tienThanhToan;
        this.tinhTrang = tinhTrang;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public Date getNgayLapHD() {
        return ngayLapHD;
    }

    public void setNgayLapHD(Date ngayLapHD) {
        this.ngayLapHD = ngayLapHD;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public int getMaChuongTrinhKM() {
        return maChuongTrinhKM;
    }

    public void setMaChuongTrinhKM(int maChuongTrinhKM) {
        this.maChuongTrinhKM = maChuongTrinhKM;
    }

    public double getTienKhuyenMai() {
        return tienKhuyenMai;
    }

    public void setTienKhuyenMai(double tienKhuyenMai) {
        this.tienKhuyenMai = tienKhuyenMai;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public double getTienThanhToan() {
        return tienThanhToan;
    }

    public void setTienThanhToan(double tienThanhToan) {
        this.tienThanhToan = tienThanhToan;
    }

    public TinhTrangHoaDonEnum getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(TinhTrangHoaDonEnum tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HoaDonDTO hoaDonDTO = (HoaDonDTO) o;
        return maHD == hoaDonDTO.maHD;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maHD);
    }

    @Override
    public String toString() {
        return "HoaDonDTO{" +
                "maHD=" + maHD +
                ", ngayLapHD=" + ngayLapHD +
                ", maKhachHang=" + maKhachHang +
                ", maNhanVien=" + maNhanVien +
                ", maChuongTrinhKM=" + maChuongTrinhKM +
                ", tienKhuyenMai=" + tienKhuyenMai +
                ", tongTien=" + tongTien +
                ", tienThanhToan=" + tienThanhToan +
                ", tinhTrang=" + tinhTrang +
                '}';
    }
}
