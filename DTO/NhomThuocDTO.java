package DTO;

import java.util.Objects;

public class NhomThuocDTO {
    private int maNhomThuoc;
    private String tenNhomThuoc;

    public NhomThuocDTO(int maNhomThuoc) {
        this.maNhomThuoc = maNhomThuoc;
    }

    public NhomThuocDTO() {
    }

    public NhomThuocDTO(int maNhomThuoc, String tenNhomThuoc) {
        this.maNhomThuoc = maNhomThuoc;
        this.tenNhomThuoc = tenNhomThuoc;
    }

    public int getMaNhomThuoc() {
        return maNhomThuoc;
    }

    public void setMaNhomThuoc(int maNhomThuoc) {
        this.maNhomThuoc = maNhomThuoc;
    }

    public String getTenNhomThuoc() {
        return tenNhomThuoc;
    }

    public void setTenNhomThuoc(String tenNhomThuoc) {
        this.tenNhomThuoc = tenNhomThuoc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NhomThuocDTO nhomThuoc)) return false;
        return getMaNhomThuoc() == nhomThuoc.getMaNhomThuoc();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaNhomThuoc());
    }

    @Override
    public String toString() {
        return "NhomThuoc{" +
                "maNhomThuoc=" + maNhomThuoc +
                ", tenNhomThuoc='" + tenNhomThuoc + '\'' +
                '}';
    }
}
