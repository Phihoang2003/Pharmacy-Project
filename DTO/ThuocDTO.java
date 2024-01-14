package DTO;

import java.util.Date;
import java.util.Objects;

public class ThuocDTO {
    private int maThuoc;
    private String tenThuoc;

    private Date hanSuDung;
    private String ghiChu;
    private String hoatChatChinh;
    private int nhaCungCap;
    private String nuocSanXuat;
    private int nhomThuoc;
    private String dieuKienBaoQuan;
    private int khuVucKho;
    private int soLuongTon;
    private int trangThai;

    public ThuocDTO() {
    }

    public ThuocDTO(int maThuoc, String tenThuoc, Date hanSuDung, String ghiChu, String hoatChatChinh, int nhaCungCap, String nuocSanXuat, int nhomThuoc, String dieuKienBaoQuan, int khuVucKho, int soLuongTon, int trangThai) {
        this.maThuoc = maThuoc;
        this.tenThuoc = tenThuoc;

        this.hanSuDung = hanSuDung;
        this.ghiChu = ghiChu;

        this.hoatChatChinh = hoatChatChinh;
        this.nhaCungCap = nhaCungCap;
        this.nuocSanXuat = nuocSanXuat;
        this.nhomThuoc = nhomThuoc;
        this.dieuKienBaoQuan = dieuKienBaoQuan;
        this.khuVucKho = khuVucKho;
        this.soLuongTon = soLuongTon;
        this.trangThai = trangThai;
    }
    public int getMaThuoc() {
        return maThuoc;
    }

    public void setMaThuoc(int maThuoc) {
        this.maThuoc = maThuoc;
    }

    public String getTenThuoc() {
        return tenThuoc;
    }

    public void setTenThuoc(String tenThuoc) {
        this.tenThuoc = tenThuoc;
    }



    public Date getHanSuDung() {
        return hanSuDung;
    }

    public void setHanSuDung(Date hanSuDung) {
        this.hanSuDung = hanSuDung;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }



    public String getHoatChatChinh() {
        return hoatChatChinh;
    }

    public void setHoatChatChinh(String hoatChatChinh) {
        this.hoatChatChinh = hoatChatChinh;
    }





    public int getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(int nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public String getNuocSanXuat() {
        return nuocSanXuat;
    }

    public void setNuocSanXuat(String nuocSanXuat) {
        this.nuocSanXuat = nuocSanXuat;
    }

    public int getNhomThuoc() {
        return nhomThuoc;
    }

    public void setNhomThuoc(int nhomThuoc) {
        this.nhomThuoc = nhomThuoc;
    }

    public String getDieuKienBaoQuan() {
        return dieuKienBaoQuan;
    }

    public void setDieuKienBaoQuan(String dieuKienBaoQuan) {
        this.dieuKienBaoQuan = dieuKienBaoQuan;
    }

    public int getKhuVucKho() {
        return khuVucKho;
    }

    public void setKhuVucKho(int khuVucKho) {
        this.khuVucKho = khuVucKho;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
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
        ThuocDTO thuocDTO = (ThuocDTO) o;
        return maThuoc == thuocDTO.maThuoc;
    }



    @Override
    public int hashCode() {
        return Objects.hash(maThuoc);
    }

    @Override
    public String toString() {
        return "ThuocDTO{" +
                "maThuoc=" + maThuoc +
                ", tenThuoc='" + tenThuoc + '\'' +
                ", hanSuDung=" + hanSuDung +
                ", ghiChu='" + ghiChu + '\'' +

                ", hoatChatChinh='" + hoatChatChinh + '\'' +

                ", nhaCungCap=" + nhaCungCap +
                ", nuocSanXuat='" + nuocSanXuat + '\'' +
                ", nhomThuoc=" + nhomThuoc +
                ", dieuKienBaoQuan='" + dieuKienBaoQuan + '\'' +
                ", khuVucKho=" + khuVucKho +
                ", soLuongTon=" + soLuongTon +
                ", trangThai=" + trangThai +
                '}';
    }
}
