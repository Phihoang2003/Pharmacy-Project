package DTO;

import java.util.Objects;

public class ChiTietQuyenDTO {
    private int maNhomQuyen;
    private String maChucNang;
    private String hanhDong;

    public ChiTietQuyenDTO() {
    }

    public ChiTietQuyenDTO(int maNhomQuyen, String maChucNang, String hanhDong) {
        this.maNhomQuyen = maNhomQuyen;
        this.maChucNang = maChucNang;
        this.hanhDong = hanhDong;
    }

    public int getMaNhomQuyen() {
        return maNhomQuyen;
    }

    public void setMaNhomQuyen(int maNhomQuyen) {
        this.maNhomQuyen = maNhomQuyen;
    }

    public String getMaChucNang() {
        return maChucNang;
    }

    public void setMaChucNang(String maChucNang) {
        this.maChucNang = maChucNang;
    }

    public String getHanhDong() {
        return hanhDong;
    }

    public void setHanhDong(String hanhDong) {
        this.hanhDong = hanhDong;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChiTietQuyenDTO that = (ChiTietQuyenDTO) o;
        return maNhomQuyen == that.maNhomQuyen;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maNhomQuyen);
    }

    @Override
    public String toString() {
        return "ChiTietQuyenDTO{" +
                "maNhomQuyen=" + maNhomQuyen +
                ", maChucNang='" + maChucNang + '\'' +
                ", hanhDong='" + hanhDong + '\'' +
                '}';
    }
}
