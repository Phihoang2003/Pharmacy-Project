package Interface;

import DTO.PhieuNhap;

import java.util.ArrayList;
import java.util.Date;

public interface PhieuNhap_Interface {
    public ArrayList<PhieuNhap> selectAll();

    public boolean insert(PhieuNhap mhn);

    public ArrayList<PhieuNhap> timKiemMHN(Date ngayNhap);

    public boolean update(PhieuNhap mhn);

    public boolean kiemTraMaMatHangNhapTonTai(String maMHN);
    public String getAutoIncrement();

}
