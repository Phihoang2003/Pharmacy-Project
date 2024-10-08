package DTO;

import java.util.Date;
import java.util.Objects;

public class ChuongTrinhKhuyenMai {
    private String maCTKM, tenCTKM;
    private LoaiKhuyenMai maLoaiKM;
    private double soTienToiThieu;
    private double soTienToiDa;
    private int giamGia;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private int tinhTrang;


    public LoaiKhuyenMai getMaLoaiKM() {
        return maLoaiKM;
    }

    public void setMaLoaiKM(LoaiKhuyenMai maLoaiKM) {
        this.maLoaiKM = maLoaiKM;
    }

    public ChuongTrinhKhuyenMai(String maCTKM, int giamGia) {
        this.maCTKM = maCTKM;
        this.giamGia = giamGia;
    }

    public ChuongTrinhKhuyenMai(String maCTKM, LoaiKhuyenMai maLoaiKM, String tenCTKM, double soTienToiThieu, double soTienToiDa, int giamGia, Date ngayBatDau, Date ngayKetThuc, int tinhTrang) {
        this.maCTKM = maCTKM;
        this.maLoaiKM= maLoaiKM;
        this.tenCTKM = tenCTKM;
        this.soTienToiThieu = soTienToiThieu;
        this.soTienToiDa = soTienToiDa;
        this.giamGia = giamGia;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.tinhTrang = tinhTrang;
    }




    public double getSoTienToiDa() {
        return soTienToiDa;
    }

    public void setSoTienToiDa(double soTienToiDa) {
        this.soTienToiDa = soTienToiDa;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public ChuongTrinhKhuyenMai(String maCTKM) {
        super();
        this.maCTKM = maCTKM;
    }
    public ChuongTrinhKhuyenMai() {
        super();
    }
    public String getMaCTKM() {
        return maCTKM;
    }
    public void setMaCTKM(String maCTKM) {
        this.maCTKM = maCTKM;
    }
    public String getTenCTKM() {
        return tenCTKM;
    }
    public void setTenCTKM(String tenCTKM) {
        this.tenCTKM = tenCTKM;
    }
    public double getSoTienToiThieu() {
        return soTienToiThieu;
    }
    public void setSoTienToiThieu(double soTienToiThieu) {
        this.soTienToiThieu = soTienToiThieu;
    }
    public int getGiamGia() {
        return giamGia;
    }
    public void setGiamGia(int giamGia) {
        this.giamGia = giamGia;
    }
    public Date getNgayBatDau() {
        return ngayBatDau;
    }
    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }
    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }
    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    @Override
    public String toString() {
        return "ChuongTrinhKhuyenMai{" +
                "maCTKM='" + maCTKM + '\'' +
                ", tenCTKM='" + tenCTKM + '\'' +
                ", maLoaiKM=" + maLoaiKM +
                ", soTienToiThieu=" + soTienToiThieu +
                ", soTienToiDa=" + soTienToiDa +
                ", giamGia=" + giamGia +
                ", ngayBatDau=" + ngayBatDau +
                ", ngayKetThuc=" + ngayKetThuc +
                ", tinhTrang=" + tinhTrang +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(maCTKM);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ChuongTrinhKhuyenMai other = (ChuongTrinhKhuyenMai) obj;
        return Objects.equals(maCTKM, other.maCTKM);
    }


}
