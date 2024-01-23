package DTO;

import java.util.Date;
import java.util.Objects;

public class ThuocDTO {
    private String maThuoc;
    private String tenThuoc;
    private Date hanSuDung;
    private String ghiChu;
    private String hoatChatChinh;
    private NhaCungCapDTO nhaCungCap;
    private NhomThuocDTO nhomThuoc;
    private String dieuKienBaoQuan;
    private KhuVucKhoDTO khuVucKho;
    private int soLuongTon;
    private String trangThai;

    public ThuocDTO(String maThuoc) {
        this.maThuoc = maThuoc;
    }

    public ThuocDTO() {
    }

    public ThuocDTO(String maThuoc, String tenThuoc, Date hanSuDung, String ghiChu, String hoatChatChinh, NhaCungCapDTO nhaCungCap, NhomThuocDTO nhomThuoc, String dieuKienBaoQuan, KhuVucKhoDTO khuVucKho, int soLuongTon, String trangThai) {
        this.maThuoc = maThuoc;
        this.tenThuoc = tenThuoc;
        this.hanSuDung = hanSuDung;
        this.ghiChu = ghiChu;
        this.hoatChatChinh = hoatChatChinh;
        this.nhaCungCap = nhaCungCap;
        this.nhomThuoc = nhomThuoc;
        this.dieuKienBaoQuan = dieuKienBaoQuan;
        this.khuVucKho = khuVucKho;
        this.soLuongTon = soLuongTon;
        this.trangThai = trangThai;
    }

    public String getMaThuoc() {
        return maThuoc;
    }

    public void setMaThuoc(String maThuoc) {
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

    public NhaCungCapDTO getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(NhaCungCapDTO nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public NhomThuocDTO getNhomThuoc() {
        return nhomThuoc;
    }

    public void setNhomThuoc(NhomThuocDTO nhomThuoc) {
        this.nhomThuoc = nhomThuoc;
    }

    public String getDieuKienBaoQuan() {
        return dieuKienBaoQuan;
    }

    public void setDieuKienBaoQuan(String dieuKienBaoQuan) {
        this.dieuKienBaoQuan = dieuKienBaoQuan;
    }

    public KhuVucKhoDTO getKhuVucKho() {
        return khuVucKho;
    }

    public void setKhuVucKho(KhuVucKhoDTO khuVucKho) {
        this.khuVucKho = khuVucKho;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThuocDTO thuocDTO = (ThuocDTO) o;
        return Objects.equals(maThuoc, thuocDTO.maThuoc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maThuoc);
    }

    @Override
    public String toString() {
        return "ThuocDTO{" +
                "maThuoc='" + maThuoc + '\'' +
                ", tenThuoc='" + tenThuoc + '\'' +
                ", hanSuDung=" + hanSuDung +
                ", ghiChu='" + ghiChu + '\'' +
                ", hoatChatChinh='" + hoatChatChinh + '\'' +
                ", nhaCungCap=" + nhaCungCap +
                ", nhomThuoc=" + nhomThuoc +
                ", dieuKienBaoQuan='" + dieuKienBaoQuan + '\'' +
                ", khuVucKho=" + khuVucKho +
                ", soLuongTon=" + soLuongTon +
                ", trangThai='" + trangThai + '\'' +
                '}';
    }
}