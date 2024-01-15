package DTO;

import java.sql.Timestamp;
import java.util.Objects;

public class PhieuDTO {
    private int maPhieu;
    private int maNguoiTao;
    private Timestamp thoiGianTao;
    private long tongTien;

    public PhieuDTO() {
    }

    public PhieuDTO(int maPhieu, int maNguoiTao, Timestamp thoiGianTao, long tongTien, int trangThai) {
        this.maPhieu = maPhieu;
        this.maNguoiTao = maNguoiTao;
        this.thoiGianTao = thoiGianTao;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    public int getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(int maPhieu) {
        this.maPhieu = maPhieu;
    }

    public int getMaNguoiTao() {
        return maNguoiTao;
    }

    public void setMaNguoiTao(int maNguoiTao) {
        this.maNguoiTao = maNguoiTao;
    }

    public Timestamp getThoiGianTao() {
        return thoiGianTao;
    }

    public void setThoiGianTao(Timestamp thoiGianTao) {
        this.thoiGianTao = thoiGianTao;
    }

    public long getTongTien() {
        return tongTien;
    }

    public void setTongTien(long tongTien) {
        this.tongTien = tongTien;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    private int trangThai;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhieuDTO phieuDTO = (PhieuDTO) o;
        return maPhieu == phieuDTO.maPhieu && maNguoiTao == phieuDTO.maNguoiTao;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maPhieu, maNguoiTao);
    }

    @Override
    public String toString() {
        return "PhieuDTO{" +
                "maPhieu=" + maPhieu +
                ", maNguoiTao=" + maNguoiTao +
                ", thoiGianTao=" + thoiGianTao +
                ", tongTien=" + tongTien +
                ", trangThai=" + trangThai +
                '}';
    }
}
