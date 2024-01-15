package DTO;

import java.util.Objects;

public class NhomKhachHangDTO {
    private int maNhom;
    private String tenNhom;
    private String ghiChu;

    public NhomKhachHangDTO() {
    }

    public NhomKhachHangDTO(int maNhom, String tenNhom, String ghiChu) {
        this.maNhom = maNhom;
        this.tenNhom = tenNhom;
        this.ghiChu = ghiChu;
    }

    public int getMaNhom() {
        return maNhom;
    }

    public void setMaNhom(int maNhom) {
        this.maNhom = maNhom;
    }

    public String getTenNhom() {
        return tenNhom;
    }

    public void setTenNhom(String tenNhom) {
        this.tenNhom = tenNhom;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NhomKhachHangDTO that = (NhomKhachHangDTO) o;
        return maNhom == that.maNhom;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maNhom);
    }

    @Override
    public String toString() {
        return "NhomKhachHangDTO{" +
                "maNhom=" + maNhom +
                ", tenNhom='" + tenNhom + '\'' +
                ", ghiChu='" + ghiChu + '\'' +
                '}';
    }
}
