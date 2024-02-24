package DTO;

import java.util.Objects;

public class DonViTinh {
    private String maDonViTinh;
    private String tenDonViTinh;

    public DonViTinh() {
    }

    public DonViTinh(String maDonViTinh, String tenDonViTinh) {
        this.maDonViTinh = maDonViTinh;
        this.tenDonViTinh = tenDonViTinh;
    }
    public DonViTinh(String maDonViTinh) {
        this.maDonViTinh = maDonViTinh;
    }

    public String getMaDonViTinh() {
        return maDonViTinh;
    }

    public void setMaDonViTinh(String maDonViTinh) {
        this.maDonViTinh = maDonViTinh;
    }

    public String getTenDonViTinh() {
        return tenDonViTinh;
    }

    public void setTenDonViTinh(String tenDonViTinh) {
        this.tenDonViTinh = tenDonViTinh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DonViTinh that = (DonViTinh) o;
        return Objects.equals(maDonViTinh, that.maDonViTinh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maDonViTinh);
    }

    @Override
    public String toString() {
        return "DonViTinhEntity{" +
                "maDonViTinh='" + maDonViTinh + '\'' +
                ", tenDonViTinh='" + tenDonViTinh + '\'' +
                '}';
    }
}
