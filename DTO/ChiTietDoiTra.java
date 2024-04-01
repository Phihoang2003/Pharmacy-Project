package DTO;

public class ChiTietDoiTra {
    private Thuoc sanPham;
    private DoiTra doiTra;
    private int soLuong;
    private double giaBan;
    private double thanhTien;

    public ChiTietDoiTra() {
    }

    public ChiTietDoiTra(Thuoc sanPham, DoiTra doiTra, int soLuong, double giaBan, double thanhTien) {
        this.sanPham = sanPham;
        this.doiTra = doiTra;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.thanhTien = thanhTien;
    }

    public Thuoc getSanPham() {
        return sanPham;
    }

    public void setSanPham(Thuoc sanPham) {
        this.sanPham = sanPham;
    }

    public DoiTra getDoiTra() {
        return doiTra;
    }

    public void setDoiTra(DoiTra doiTra) {
        this.doiTra = doiTra;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    @Override
    public String toString() {
        return "ChiTietDoiTra{" +
                "sanPham=" + sanPham +
                ", doiTra=" + doiTra +
                ", soLuong=" + soLuong +
                ", giaBan=" + giaBan +
                ", thanhTien=" + thanhTien +
                '}';
    }
}
