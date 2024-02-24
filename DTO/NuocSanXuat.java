package DTO;

import java.util.Objects;

public class NuocSanXuat {
    private String maNuoc;
    private String tenNuoc;

    public NuocSanXuat() {
    }
    public NuocSanXuat(String maNuoc) {
        this.maNuoc = maNuoc;
    }
    public NuocSanXuat(String maNuoc, String tenNuoc) {
        this.maNuoc = maNuoc;
        this.tenNuoc = tenNuoc;
    }

    public String getMaNuoc() {
        return maNuoc;
    }

    public void setMaNuoc(String maNuoc) {
        this.maNuoc = maNuoc;
    }

    public String getTenNuoc() {
        return tenNuoc;
    }

    public void setTenNuoc(String tenNuoc) {
        this.tenNuoc = tenNuoc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NuocSanXuat that = (NuocSanXuat) o;
        return Objects.equals(maNuoc, that.maNuoc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maNuoc);
    }

    @Override
    public String toString() {
        return "NuocSanXuatEntity{" +
                "maNuoc=" + maNuoc +
                ", tenNuoc='" + tenNuoc + '\'' +
                '}';
    }
}
