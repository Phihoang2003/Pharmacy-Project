package DTO;

import java.util.Objects;

public class NhomKhachHangDTO {
    private String maNhom;
    private String tenNhom;
    private String ghiChu;

    public NhomKhachHangDTO() {
    }

    public NhomKhachHangDTO(String maNhom, String tenNhom, String ghiChu) {
        this.maNhom = maNhom;
        this.tenNhom = tenNhom;
        this.ghiChu = ghiChu;
    }

    public String getMaNhom() {
        return maNhom;
    }

    public void setMaNhom(String maNhom) {
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
        return maNhom.equals(that.maNhom) ;
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
