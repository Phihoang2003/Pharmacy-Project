package DTO;


import java.util.Date;

public class PhieuNhap {
    private String maPN;
    private NhaCungCap nhaCungCap;
    private Thuoc thuoc;
    private int soLuongNhap;
    private Date ngayNhap;

    public PhieuNhap() {
    }

    public PhieuNhap(String maPN, NhaCungCap nhaCungCap, Thuoc thuoc, int soLuongNhap, Date ngayNhap) {
        this.maPN = maPN;
        this.nhaCungCap = nhaCungCap;
        this.thuoc = thuoc;
        this.soLuongNhap = soLuongNhap;
        this.ngayNhap = ngayNhap;
    }

    public String getMaPN() {
        return maPN;
    }

    public void setMaPN(String maPN) {
        this.maPN = maPN;
    }

    public NhaCungCap getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(NhaCungCap nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public Thuoc getThuoc() {
        return thuoc;
    }

    public void setThuoc(Thuoc thuoc) {
        this.thuoc = thuoc;
    }

    public int getSoLuongNhap() {
        return soLuongNhap;
    }

    public void setSoLuongNhap(int soLuongNhap) {
        this.soLuongNhap = soLuongNhap;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }
}
