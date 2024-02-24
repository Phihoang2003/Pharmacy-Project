package DTO;

public enum TinhTrangSPEnum {
    DANGBAN, HETHANG,NGUNGBAN;

    @Override
    public String toString() {
        switch(this) {
            case DANGBAN: return "Đang bán";
            case HETHANG: return "Hết hàng";
            case NGUNGBAN: return "Ngừng bán";
        }
        return null;
    }
}
