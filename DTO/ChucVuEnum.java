package DTO;

public enum ChucVuEnum {
    NHANVIEN, QUANLY;

    @Override
    public String toString() {
        return switch (this) {
            case NHANVIEN -> "Nhân viên";
            default -> "Quản lý";
        };
    }
}
