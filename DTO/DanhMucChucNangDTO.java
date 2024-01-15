package DTO;

import java.util.Objects;

public class DanhMucChucNangDTO {
    private int maChucNang;
    private String tecChucNang;
    private int trangThai;

    public DanhMucChucNangDTO() {
    }

    public DanhMucChucNangDTO(int maChucNang, String tecChucNang, int trangThai) {
        this.maChucNang = maChucNang;
        this.tecChucNang = tecChucNang;
        this.trangThai = trangThai;
    }

    public int getMaChucNang() {
        return maChucNang;
    }

    public void setMaChucNang(int maChucNang) {
        this.maChucNang = maChucNang;
    }

    public String getTecChucNang() {
        return tecChucNang;
    }

    public void setTecChucNang(String tecChucNang) {
        this.tecChucNang = tecChucNang;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DanhMucChucNangDTO that = (DanhMucChucNangDTO) o;
        return maChucNang == that.maChucNang;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maChucNang);
    }

    @Override
    public String toString() {
        return "DanhMucChucNangDTO{" +
                "maChucNang=" + maChucNang +
                ", tecChucNang='" + tecChucNang + '\'' +
                ", trangThai=" + trangThai +
                '}';
    }
}
