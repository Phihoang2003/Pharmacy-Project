package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
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
    public NhanVienDTO getNV(String sdt) throws SQLException {
        return NVdao.getNV(sdt);
    }

    @Override
    public NhanVienDTO selectById(String id) {
        return NVdao.selectById(id);
    }

    @Override
    public boolean update(NhanVienDTO updateNV) {
        return NVdao.update(updateNV);
    }

    @Override
    public boolean insert(NhanVienDTO insertNV) {
        return NVdao.insert(insertNV);
    }

    @Override
    public ArrayList<NhanVienDTO> selectAll() {
        return NVdao.selectAll();
    }

    @Override
    public String getAutoIncrement() {
        return NVdao.getAutoIncrement();
    }
}
