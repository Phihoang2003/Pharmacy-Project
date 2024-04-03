package DTO;

import java.util.Objects;

public class ThuongHieu {
    private String maThuongHieu;
    private String tenThuongHieu;

    public ThuongHieu(String maThuongHieu) {
        this.maThuongHieu = maThuongHieu;
    }

    public ThuongHieu() {
    }

    public ThuongHieu(String maThuongHieu, String tenThuongHieu) {
        this.maThuongHieu = maThuongHieu;
        this.tenThuongHieu = tenThuongHieu;
    }

    public String getMaThuongHieu() {
        return maThuongHieu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThuongHieu that = (ThuongHieu) o;
        return Objects.equals(maThuongHieu, that.maThuongHieu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maThuongHieu);
    }

    public void setMaThuongHieu(String maThuongHieu) {
        this.maThuongHieu = maThuongHieu;
    }

    public String getTenThuongHieu() {
        return tenThuongHieu;
    }

    public void setTenThuongHieu(String tenThuongHieu) {
        this.tenThuongHieu = tenThuongHieu;
    }
}
