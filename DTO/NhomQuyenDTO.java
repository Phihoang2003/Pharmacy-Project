package DTO;

import java.util.Objects;

public class NhomQuyenDTO {
    private int maNhomQuyen;
    private String tenNhomQuyen;

    public NhomQuyenDTO() {
    }

    public NhomQuyenDTO(int maNhomQuyen, String tenNhomQuyen) {
        this.maNhomQuyen = maNhomQuyen;
        this.tenNhomQuyen = tenNhomQuyen;
    }

    public int getMaNhomQuyen() {
        return maNhomQuyen;
    }

    public void setMaNhomQuyen(int maNhomQuyen) {
        this.maNhomQuyen = maNhomQuyen;
    }

    public String getTenNhomQuyen() {
        return tenNhomQuyen;
    }

    public void setTenNhomQuyen(String tenNhomQuyen) {
        this.tenNhomQuyen = tenNhomQuyen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NhomQuyenDTO that = (NhomQuyenDTO) o;
        return maNhomQuyen == that.maNhomQuyen;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maNhomQuyen);
    }

    @Override
    public String toString() {
        return "NhomQuyenDTO{" +
                "maNhomQuyen=" + maNhomQuyen +
                ", tenNhomQuyen='" + tenNhomQuyen + '\'' +
                '}';
    }
}
