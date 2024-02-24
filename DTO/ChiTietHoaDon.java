package DTO;

public class ChiTietHoaDon {
    private ThuocDTO thuoc;
    private HoaDon hoaDon;
    private int soLuong;
    private double giaGoc;
    private double giaBan;
    private double thanhTien;

    public ChiTietHoaDon(ThuocDTO thuoc, HoaDon hoaDon, int soLuong, double giaGoc, double giaBan, double thanhTien) {
        this.thuoc = thuoc;
        this.hoaDon = hoaDon;
        this.soLuong = soLuong;
        this.giaGoc = giaGoc;
        this.giaBan = giaBan;
        this.thanhTien = thanhTien;
    }

    public ChiTietHoaDon() {
    }

    public ThuocDTO getThuoc() {
        return thuoc;
    }

    public void setThuoc(ThuocDTO thuoc) {
        this.thuoc = thuoc;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaGoc() {
        return giaGoc;
    }

    public void setGiaGoc(double giaGoc) {
        this.giaGoc = thuoc.getDonGia() * 1.4;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        if(thuoc.getChuongTrinhKhuyenMaiEntity()!=null){
            this.giaBan=this.giaGoc*(1-(thuoc.getChuongTrinhKhuyenMaiEntity().getGiamGia()*0.01));
        }
        else{
            this.giaBan=this.giaGoc;
        }
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = giaBan*soLuong;
    }

    @Override
    public String toString() {
        return "ChiTietHoaDon{" +
                "thuoc=" + thuoc +
                ", hoaDon=" + hoaDon +
                ", soLuong=" + soLuong +
                ", giaGoc=" + giaGoc +
                ", giaBan=" + giaBan +
                ", thanhTien=" + thanhTien +
                '}';
    }
}
