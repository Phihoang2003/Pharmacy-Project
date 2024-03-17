package utils;

import DTO.TinhTrangHoaDonEnum;
import DTO.TinhTrangNVEnum;
import DTO.TinhTrangSPEnum;

public class ConvertStringToEnum {
    public ConvertStringToEnum() {
    }
    public TinhTrangNVEnum tinhTrangNVEnum(String tinhTrang) {
        if(tinhTrang.equals("Đang làm việc")) {
            return TinhTrangNVEnum.DANGLAMVIEC;
        }
        if(tinhTrang.equals("Nghỉ việc")) {
            return TinhTrangNVEnum.NGHIVIEC;
        }
        return TinhTrangNVEnum.NGHIPHEP;
    }
    public TinhTrangSPEnum tinhTrangSPEnum(String tinhTrang) {
        if(tinhTrang.equals("Đang bán")) {
            return TinhTrangSPEnum.DANGBAN;
        }
        if(tinhTrang.equals("Hết hàng")) {
            return TinhTrangSPEnum.HETHANG;
        }
        return TinhTrangSPEnum.NGUNGBAN;
    }
    public TinhTrangHoaDonEnum tinhTrangHoaDonEnum(String tinhTrang) {
        if(tinhTrang.equals("Đã thanh toán")) {
            return TinhTrangHoaDonEnum.DATHANHTOAN;
        }
        return TinhTrangHoaDonEnum.CHUATHANHTOAN;
    }

}
