package DTO;


import java.sql.Timestamp;
import java.util.Objects;

public class PhieuKiemKe {
    private int maPhieu;
    private Timestamp thoigian;
    private int nguoiTaoPhieu;

    public PhieuKiemKe() {
    }

    public PhieuKiemKe(int maPhieu, Timestamp thoigian, int nguoiTaoPhieu) {
        this.maPhieu = maPhieu;
        this.thoigian = thoigian;
        this.nguoiTaoPhieu = nguoiTaoPhieu;
    }

    public int getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(int maPhieu) {
        this.maPhieu = maPhieu;
    }

    public Timestamp getThoigian() {
        return thoigian;
    }

    public void setThoigian(Timestamp thoigian) {
        this.thoigian = thoigian;
    }

    public int getNguoiTaoPhieu() {
        return nguoiTaoPhieu;
    }

    public void setNguoiTaoPhieu(int nguoiTaoPhieu) {
        this.nguoiTaoPhieu = nguoiTaoPhieu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhieuKiemKe that = (PhieuKiemKe) o;
        return maPhieu == that.maPhieu;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maPhieu);
    }

    @Override
    public String toString() {
        return "PhieuKiemKe{" +
                "maPhieu=" + maPhieu +
                ", thoigian=" + thoigian +
                ", nguoiTaoPhieu=" + nguoiTaoPhieu +
                '}';
    }
}
