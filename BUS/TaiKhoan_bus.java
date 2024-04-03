package BUS;

import DAO.TaiKhoanDAO;
import DTO.TaiKhoan;
import Interface.TaiKhoan_Interface;

import java.util.ArrayList;

public class TaiKhoan_bus implements TaiKhoan_Interface {
    TaiKhoanDAO tk_dao=new TaiKhoanDAO();
    @Override
    public boolean insert(TaiKhoan tk) {
        return tk_dao.insert(tk);
    }

    @Override
    public ArrayList<TaiKhoan> findAll() {
        return tk_dao.findAll();
    }

    @Override
    public TaiKhoan getTK(String taiKhoan, String matKhau) {
        return tk_dao.getTK(taiKhoan, matKhau);
    }

    @Override
    public boolean update(TaiKhoan tk) {
        return tk_dao.update(tk);
    }

    @Override
    public boolean thoiGianDNGN(TaiKhoan tk) {
        return tk_dao.thoiGianDNGN(tk);
    }

    @Override
    public TaiKhoan findOne(String id) {
        return tk_dao.findOne(id);
    }
}
