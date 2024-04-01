package BUS;

import DAO.KhachHangDAO;
import DTO.KhachHang;
import Interface.KhachHang_Interface;

import java.util.ArrayList;

public class KhachHang_bus implements KhachHang_Interface {
    KhachHangDAO kh_dao = new KhachHangDAO();
    @Override
    public KhachHang selectById(String id) {
        return kh_dao.selectById(id);
    }

    @Override
    public boolean update(KhachHang updateKH) {
        return kh_dao.update(updateKH);
    }

    @Override
    public boolean insert(KhachHang insertKH) {
        return kh_dao.insert(insertKH);
    }

    @Override
    public ArrayList<KhachHang> selectAll() {
        return kh_dao.selectAll();
    }

    @Override
    public String getAutoIncrement() {
        return kh_dao.getAutoIncrement();
    }

    @Override
    public KhachHang timKiemTheoSDT(String sdt) {
        return kh_dao.timKiemTheoSDT(sdt);
    }


}
