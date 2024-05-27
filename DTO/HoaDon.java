package DTO;

import java.sql.Date;
import java.util.Objects;

public class HoaDon {
    private String maHD;
    private Date ngayLapHD;
    private KhachHang khachHang;
    private NhanVien nhanVien;
    private ChuongTrinhKhuyenMai chuongTrinhKM;
    private double tienKhuyenMai;
    private double tongTien;
    private double tienThanhToan;
    private int tinhTrang;

    public HoaDon(String maHD, Date ngayLapHD, KhachHang khachHang, NhanVien nhanVien,
                  ChuongTrinhKhuyenMai chuongTrinhKM) {
        super();
        this.maHD = maHD;
        this.ngayLapHD = ngayLapHD;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.chuongTrinhKM = chuongTrinhKM;
    }

    public HoaDon(String maHD) {
        this.maHD = maHD;
    }

    public HoaDon(Date ngayLapHD, double tienThanhToan) {
        this.ngayLapHD = ngayLapHD;
        this.tienThanhToan = tienThanhToan;
    }

    public HoaDon(String maHD, Date ngayLapHD, KhachHang khachHang, NhanVien nhanVien,
                  ChuongTrinhKhuyenMai chuongTrinhKM, double tienKhuyenMai, double tongTien, double tienThanhToan, int tinhTrang) {
        this.maHD = maHD;
        this.ngayLapHD = ngayLapHD;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.chuongTrinhKM = chuongTrinhKM;
        this.tienKhuyenMai = tienKhuyenMai;
        this.tongTien = tongTien;
        this.tienThanhToan = tienThanhToan;
        this.tinhTrang = tinhTrang;
    }

    public HoaDon() {
        super();

    }
    public String getMaHD() {
        return maHD;
    }
    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }
    public Date getNgayLapHD() {
        return ngayLapHD;
    }
    public void setNgayLapHD(Date ngayLapHD) {
        this.ngayLapHD = ngayLapHD;
    }
    public KhachHang getKhachHang() {
        return khachHang;
    }
    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }
    public NhanVien getNhanVien() {
        return nhanVien;
    }
    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }
    public ChuongTrinhKhuyenMai getChuongTrinhKM() {
        return chuongTrinhKM;
    }
    public void setChuongTrinhKM(ChuongTrinhKhuyenMai chuongTrinhKM) {
        this.chuongTrinhKM = chuongTrinhKM;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTienKhuyenMai() {
        if(this.getChuongTrinhKM() != null) {
            double tienKM = tongTien * (chuongTrinhKM.getGiamGia()*0.01);
            if(tienKM > chuongTrinhKM.getSoTienToiDa()) {
                this.tienKhuyenMai = chuongTrinhKM.getSoTienToiDa();
            } else {
                this.tienKhuyenMai = tienKM;
            }
        } else {
            this.tienKhuyenMai = 0;
        }
    }

    public void setTienThanhToan(boolean diemTichLuy) {

        if(!diemTichLuy){
            this.tienThanhToan = tongTien - tienKhuyenMai;
        }
        else{
            this.tienThanhToan = tongTien - tienKhuyenMai - khachHang.getDiemTichLuy();
        }
    }

    public double getTienKhuyenMai() {
        return tienKhuyenMai;
    }

    public double getTienThanhToan() {
        return tienThanhToan;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public String toString() {
        return "HoaDonEntity{" + "maHD=" + maHD + ", ngayLapHD=" + ngayLapHD + ", khachHang=" + khachHang + ", nhanVien=" + nhanVien + ", chuongTrinhKM=" + chuongTrinhKM + ", tienKhuyenMai=" + tienKhuyenMai + ", tongTien=" + tongTien + ", tienThanhToan=" + tienThanhToan + ", tinhTrang=" + tinhTrang + '}';
    }


    @Override
    public int hashCode() {
        return Objects.hash(maHD);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        HoaDon other = (HoaDon) obj;
        return Objects.equals(maHD, other.maHD);
    }
    private double loiNhuan;

    // existing constructors...

    public HoaDon(double loiNhuan, Date ngayLapHD) {
        this.ngayLapHD = ngayLapHD;
        this.loiNhuan = loiNhuan;
    }

    // existing methods...

    public double getLoiNhuan() {
        return loiNhuan;
    }

    public void setLoiNhuan(double loiNhuan) {
        this.loiNhuan = loiNhuan;
    }
}
