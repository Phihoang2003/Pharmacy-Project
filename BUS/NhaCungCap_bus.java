package BUS;

import DAO.NhaCungCapDAO;
import DTO.NhaCungCap;
import Interface.NhaCungCap_Interface;

import java.util.ArrayList;

public class NhaCungCap_bus implements NhaCungCap_Interface {
    NhaCungCapDAO ncc_dao=new NhaCungCapDAO();
    @Override
    public ArrayList<NhaCungCap> selectAll() {
        return ncc_dao.selectAll();
    }

    @Override
    public boolean insert(NhaCungCap ncc) {
        return ncc_dao.insert(ncc);
    }

    @Override
    public ArrayList<NhaCungCap> timKiemNCC(String ma) {
        return ncc_dao.timKiemNCC(ma);
    }

    @Override
    public boolean update(NhaCungCap maNCC) {
        return ncc_dao.update(maNCC);
    }

    @Override
    public ArrayList<NhaCungCap> layDSNCCDangNhap() {
        return ncc_dao.layDSNCCDangNhap();
    }

    @Override
    public String layTenNhaCungCapTheoMa(String maNhaCungCap) {
        return ncc_dao.layTenNhaCungCapTheoMa(maNhaCungCap);
    }

    @Override
    public String layMaNhaCungCapTheoTen(String tenNhaCungCap) {
        return ncc_dao.layMaNhaCungCapTheoTen(tenNhaCungCap);
    }

    @Override
    public NhaCungCap selectById(String id) {
        return ncc_dao.selectById(id);
    }

    @Override
    public String getAutoIncrement() {
        return ncc_dao.getAutoIncrement();
    }
}
