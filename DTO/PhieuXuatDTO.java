package DTO;

import java.util.Objects;

public class PhieuXuatDTO extends PhieuDTO {
    private int maKH;
    private int maKhuyenMai;

    public PhieuXuatDTO() {
    }
    public PhieuXuatDTO(int maKH, int maKhuyenMai) {
        this.maKH = maKH;
        this.maKhuyenMai = maKhuyenMai;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public int getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public void setMaKhuyenMai(int maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PhieuXuatDTO that = (PhieuXuatDTO) o;
        return maKH == that.maKH;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), maKH);
    }

    @Override
    public String toString() {
        return "PhieuXuatDTO{" +
                "maKH=" + maKH +
                ", maKhuyenMai=" + maKhuyenMai +
                '}';
    }
}
