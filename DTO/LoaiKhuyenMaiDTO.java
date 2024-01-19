package DTO;

import java.util.Objects;

public class LoaiKhuyenMaiDTO {
    private String maLoaiKM, moTa;

    public LoaiKhuyenMaiDTO() {
    }

    public LoaiKhuyenMaiDTO(String maLoaiKM, String moTa) {
        this.maLoaiKM = maLoaiKM;
        this.moTa = moTa;
    }

    public String getMaLoaiKM() {
        return maLoaiKM;
    }

    public void setMaLoaiKM(String maLoaiKM) {
        this.maLoaiKM = maLoaiKM;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoaiKhuyenMaiDTO that = (LoaiKhuyenMaiDTO) o;
        return Objects.equals(maLoaiKM, that.maLoaiKM);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maLoaiKM);
    }

    @Override
    public String toString() {
        return "LoaiKhuyenMaiDTO{" +
                "maLoaiKM='" + maLoaiKM + '\'' +
                ", moTa='" + moTa + '\'' +
                '}';
    }
}
