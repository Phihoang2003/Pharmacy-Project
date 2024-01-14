package DTO;

import java.util.Objects;

public class ChiTietKiemKeDTO {
    private int maChiTietKiemKe;
    private int maPhienBan;
    private int soLuong;
    private int chenhLech;
    private String ghiChu;

    public ChiTietKiemKeDTO() {
    }

    public ChiTietKiemKeDTO(int maChiTietKiemKe, int maPhienBan, int soLuong, int chenhLech, String ghiChu) {
        this.maChiTietKiemKe = maChiTietKiemKe;
        this.maPhienBan = maPhienBan;
        this.soLuong = soLuong;
        this.chenhLech = chenhLech;
        this.ghiChu = ghiChu;
    }

    public int getMaChiTietKiemKe() {
        return maChiTietKiemKe;
    }

    public void setMaChiTietKiemKe(int maChiTietKiemKe) {
        this.maChiTietKiemKe = maChiTietKiemKe;
    }

    public int getMaPhienBan() {
        return maPhienBan;
    }

    public void setMaPhienBan(int maPhienBan) {
        this.maPhienBan = maPhienBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getChenhLech() {
        return chenhLech;
    }

    public void setChenhLech(int chenhLech) {
        this.chenhLech = chenhLech;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChiTietKiemKeDTO that = (ChiTietKiemKeDTO) o;
        return maChiTietKiemKe == that.maChiTietKiemKe && maPhienBan == that.maPhienBan;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maChiTietKiemKe, maPhienBan);
    }

    @Override
    public String toString() {
        return "ChiTietKiemKe{" +
                "maChiTietKiemKe=" + maChiTietKiemKe +
                ", maPhienBan=" + maPhienBan +
                ", soLuong=" + soLuong +
                ", chenhLech=" + chenhLech +
                ", ghiChu='" + ghiChu + '\'' +
                '}';
    }
}
