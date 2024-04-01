package DTO;

public enum HinhThucDoiTraEnum {
    HOANTRA, DOIMOI;

    @Override
    public String toString() {
        switch(this) {
            case HOANTRA: return "Hoàn trả";
            case DOIMOI: return "Đổi mới";
            default: return "Hoàn trả";
        }
    }
}
