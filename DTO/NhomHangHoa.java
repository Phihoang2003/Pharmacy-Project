package DTO;

import java.util.Objects;

public class NhomHangHoa {
    private String maNhomHang;
    private String tenNhomHang;

    public NhomHangHoa() {
    }

    public NhomHangHoa(String maNhomHang, String tenNhomHang) {
        this.maNhomHang = maNhomHang;
        this.tenNhomHang = tenNhomHang;
    }
    public NhomHangHoa(String maNhomHang) {
        this.maNhomHang = maNhomHang;
    }
    public String getMaNhomHang() {
        return maNhomHang;
    }

    public void setMaNhomHang(String maNhomHang) {
        this.maNhomHang = maNhomHang;
    }

    public String getTenNhomHang() {
        return tenNhomHang;
    }

    public void setTenNhomHang(String tenNhomHang) {
        this.tenNhomHang = tenNhomHang;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NhomHangHoa that = (NhomHangHoa) o;
        return Objects.equals(maNhomHang, that.maNhomHang);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maNhomHang);
    }

    @Override
    public String toString() {
        return "NhomHangHoa{" +
                "maNhomHang='" + maNhomHang + '\'' +
                ", tenNhomHang='" + tenNhomHang + '\'' +
                '}';
    }
}
