package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVien;
import Interface.NhanVien_Interface;

import java.sql.SQLException;
import java.util.ArrayList;

public class NhanVien_bus implements NhanVien_Interface {
    NhanVienDAO NVdao = new NhanVienDAO();

    @Override
    public Boolean checkNV(String email, String sdt) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public NhanVien getNV(String sdt) throws SQLException {
        return NVdao.getNV(sdt);
    }

    @Override
    public NhanVien selectById(String id) {
        return NVdao.selectById(id);
    }

    @Override
    public NhanVien findBySDT(String sdt) {
        return NVdao.findBySDT(sdt);
    }


    @Override
    public boolean update(NhanVien updateNV) {
        return NVdao.update(updateNV);
    }

    @Override
    public boolean insert(NhanVien insertNV) {
        return NVdao.insert(insertNV);
    }

    @Override
    public ArrayList<NhanVien> selectAll() {
        return NVdao.selectAll();
    }

    @Override
    public String getAutoIncrement() {
        return NVdao.getAutoIncrement();
    }
}
