package DTO;

import java.util.Objects;

public class KhuVucKhoDTO {
    private int maKhuVucKho;
    private String tenKhuVucKho;
    private String ghiChu;

    public KhuVucKhoDTO() {
    }

    public KhuVucKhoDTO(int maKhuVucKho, String tenKhuVucKho, String ghiChu) {
        this.maKhuVucKho = maKhuVucKho;
        this.tenKhuVucKho = tenKhuVucKho;
        this.ghiChu = ghiChu;
    }

    public int getMaKhuVucKho() {
        return maKhuVucKho;
    }

    public void setMaKhuVucKho(int maKhuVucKho) {
        this.maKhuVucKho = maKhuVucKho;
    }

    public String getTenKhuVucKho() {
        return tenKhuVucKho;
    }

    public void setTenKhuVucKho(String tenKhuVucKho) {
        this.tenKhuVucKho = tenKhuVucKho;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public KhuVucKhoDTO(int maKhuVucKho) {
        this.maKhuVucKho = maKhuVucKho;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KhuVucKhoDTO khuVucKho = (KhuVucKhoDTO) o;
        return maKhuVucKho == khuVucKho.maKhuVucKho;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maKhuVucKho);
    }
}
