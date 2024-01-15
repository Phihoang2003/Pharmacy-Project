package DTO;

import java.util.Objects;

public class TaiKhoanDTO {
    private int manv;
    private String username;
    private String password;
    private int maNhomQuyen;
    private int trangThai;

    public TaiKhoanDTO() {
    }

    public TaiKhoanDTO(int manv, String username, String password, int maNhomQuyen, int trangThai) {
        this.manv = manv;
        this.username = username;
        this.password = password;
        this.maNhomQuyen = maNhomQuyen;
        this.trangThai = trangThai;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaiKhoanDTO that = (TaiKhoanDTO) o;
        return manv == that.manv && maNhomQuyen == that.maNhomQuyen && trangThai == that.trangThai && Objects.equals(username, that.username) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manv, username, password, maNhomQuyen, trangThai);
    }

    @Override
    public String toString() {
        return "TaiKhoanDTO{" +
                "manv=" + manv +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", maNhomQuyen=" + maNhomQuyen +
                ", trangThai=" + trangThai +
                '}';
    }
}
