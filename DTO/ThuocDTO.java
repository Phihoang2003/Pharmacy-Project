package DTO;

import java.util.Date;
import java.util.Objects;

public class ThuocDTO {
    private String maThuoc;
    private String tenThuoc;
    private Date hanSuDung;
    private String hoatChatChinh;
    private double khoiLuong;
    private String imgUrl;
    private String duongDung;
    private DonViTinh donViTinh;
    private NhomHangHoa nhomHangHoa;
    private ChuongTrinhKhuyenMai chuongTrinhKhuyenMaiEntity;
    private QuyCachDongGoi quyCachDongGoi;
    private NuocSanXuat nuocSanXuat;
    private double donGia;
    private int soLuongTon;
    private String dieuKienBaoQuan;
    private TinhTrangSPEnum trangThai;

    public ThuocDTO(String maThuoc) {
        this.maThuoc = maThuoc;
    }

    public ThuocDTO() {
    }

    public ThuocDTO(String maThuoc, String tenThuoc, Date hanSuDung,  String hoatChatChinh, double khoiLuong, String imgUrl, String duongDung, DonViTinh donViTinh, NhomHangHoa nhomHangHoa, ChuongTrinhKhuyenMai chuongTrinhKhuyenMaiEntity, QuyCachDongGoi quyCachDongGoi, NuocSanXuat nuocSanXuat, double donGia, int soLuongTon, String dieuKienBaoQuan, TinhTrangSPEnum trangThai) {
        this.maThuoc = maThuoc;
        this.tenThuoc = tenThuoc;
        this.hanSuDung = hanSuDung;
        this.hoatChatChinh = hoatChatChinh;
        this.khoiLuong = khoiLuong;
        this.imgUrl = imgUrl;
        this.duongDung = duongDung;
        this.donViTinh = donViTinh;
        this.nhomHangHoa = nhomHangHoa;
        this.chuongTrinhKhuyenMaiEntity = chuongTrinhKhuyenMaiEntity;
        this.quyCachDongGoi = quyCachDongGoi;
        this.nuocSanXuat = nuocSanXuat;
        this.donGia = donGia;
        this.soLuongTon = soLuongTon;
        this.dieuKienBaoQuan = dieuKienBaoQuan;
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

    public String getHoatChatChinh() {
        return hoatChatChinh;
    }

    public void setHoatChatChinh(String hoatChatChinh) {
        this.hoatChatChinh = hoatChatChinh;
    }

    public double getKhoiLuong() {
        return khoiLuong;
    }

    public void setKhoiLuong(double khoiLuong) {
        this.khoiLuong = khoiLuong;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDuongDung() {
        return duongDung;
    }

    public void setDuongDung(String duongDung) {
        this.duongDung = duongDung;
    }

    public DonViTinh getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(DonViTinh donViTinh) {
        this.donViTinh = donViTinh;
    }

    public NhomHangHoa getNhomHangHoa() {
        return nhomHangHoa;
    }

    public void setNhomHangHoa(NhomHangHoa nhomHangHoa) {
        this.nhomHangHoa = nhomHangHoa;
    }

    public ChuongTrinhKhuyenMai getChuongTrinhKhuyenMaiEntity() {
        return chuongTrinhKhuyenMaiEntity;
    }

    public void setChuongTrinhKhuyenMaiEntity(ChuongTrinhKhuyenMai chuongTrinhKhuyenMaiEntity) {
        this.chuongTrinhKhuyenMaiEntity = chuongTrinhKhuyenMaiEntity;
    }

    public QuyCachDongGoi getQuyCachDongGoi() {
        return quyCachDongGoi;
    }

    public void setQuyCachDongGoi(QuyCachDongGoi quyCachDongGoi) {
        this.quyCachDongGoi = quyCachDongGoi;
    }

    public NuocSanXuat getNuocSanXuat() {
        return nuocSanXuat;
    }

    public void setNuocSanXuat(NuocSanXuat nuocSanXuat) {
        this.nuocSanXuat = nuocSanXuat;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public String getDieuKienBaoQuan() {
        return dieuKienBaoQuan;
    }

    public void setDieuKienBaoQuan(String dieuKienBaoQuan) {
        this.dieuKienBaoQuan = dieuKienBaoQuan;
    }

    public TinhTrangSPEnum getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(TinhTrangSPEnum trangThai) {
        this.trangThai = trangThai;
    }
    public double tinhGiaBan() {
        return this.donGia * 1.4;
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
                ", hoatChatChinh='" + hoatChatChinh + '\'' +
                ", khoiLuong=" + khoiLuong +
                ", imgUrl='" + imgUrl + '\'' +
                ", duongDung='" + duongDung + '\'' +
                ", donViTinh=" + donViTinh +
                ", nhomHangHoa=" + nhomHangHoa +
                ", chuongTrinhKhuyenMaiEntity=" + chuongTrinhKhuyenMaiEntity +
                ", quyCachDongGoi=" + quyCachDongGoi +
                ", nuocSanXuat=" + nuocSanXuat +
                ", donGia=" + donGia +
                ", soLuongTon=" + soLuongTon +
                ", dieuKienBaoQuan='" + dieuKienBaoQuan + '\'' +
                ", trangThai='" + trangThai + '\'' +
                '}';
    }
}