package DTO;

import java.sql.Timestamp;
import java.util.Objects;

public class PhieuNhapDTO extends PhieuDTO {
    private int maNhaCungCap;

    public PhieuNhapDTO(int maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }

    public PhieuNhapDTO(int maPhieu, int maNguoiTao, Timestamp thoiGianTao, long tongTien, int trangThai, int maNhaCungCap) {
        super(maPhieu, maNguoiTao, thoiGianTao, tongTien, trangThai);
        this.maNhaCungCap = maNhaCungCap;
    }

    public int getMaNhaCungCap() {
        return maNhaCungCap;
    }

    public void setMaNhaCungCap(int maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PhieuNhapDTO that = (PhieuNhapDTO) o;
        return maNhaCungCap == that.maNhaCungCap;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), maNhaCungCap);
    }

    @Override
    public String toString() {
        return "PhieuNhapDTO{" +
                "maNhaCungCap=" + maNhaCungCap +
                '}'+super.toString();
    }
}
