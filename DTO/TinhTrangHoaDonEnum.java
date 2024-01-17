package DTO;

public enum TinhTrangHoaDonEnum {
DATHANHTOAN, CHUATHANHTOAN;

    @Override
    public String toString() {
        switch (this) {
            case DATHANHTOAN:
                return "Đã thanh toán";
            case CHUATHANHTOAN:
                return "Chưa thanh toán";
            default:
                return "Chưa thanh toán";
        }
    }
}
