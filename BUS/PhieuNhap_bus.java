package BUS;

import DAO.PhieuNhapDAO;
import DTO.PhieuNhap;
import Interface.PhieuNhap_Interface;

import java.util.ArrayList;
import java.util.Date;

public class PhieuNhap_bus implements PhieuNhap_Interface {
    PhieuNhapDAO ph_dao= new PhieuNhapDAO();
    @Override
    public ArrayList<PhieuNhap> selectAll() {
        return ph_dao.selectAll();
    }

    @Override
    public boolean insert(PhieuNhap mhn) {
        return ph_dao.insert(mhn);
    }

    @Override
    public ArrayList<PhieuNhap> timKiemMHN(Date ngayNhap) {
        return ph_dao.timKiemMHN(ngayNhap);
    }

    @Override
    public boolean update(PhieuNhap mhn) {
        return ph_dao.update(mhn);
    }

    @Override
    public boolean kiemTraMaMatHangNhapTonTai(String maMHN) {
        return ph_dao.kiemTraMaMatHangNhapTonTai(maMHN);
    }

    @Override
    public String getAutoIncrement() {
        return ph_dao.getAutoIncrement();
    }
}
