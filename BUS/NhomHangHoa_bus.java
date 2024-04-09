package BUS;

import DAO.NhomHangHoaDAO;
import DTO.NhomHangHoa;
import Interface.NhomThuoc_Interface;

import java.util.ArrayList;

public class NhomHangHoa_bus implements NhomThuoc_Interface {
    NhomHangHoaDAO nh_dao=new NhomHangHoaDAO();
    @Override
    public ArrayList<NhomHangHoa> getAllNT() {
        return nh_dao.getAllNT();
    }

    @Override
    public String layTenNhomThuocTheoMa(String maNhomThuoc) {
        return nh_dao.layTenNhomThuocTheoMa(maNhomThuoc);
    }

    @Override
    public String layMaNhomThuocTheoTen(String tenNhomThuoc) {
        return nh_dao.layMaNhomThuocTheoTen(tenNhomThuoc);
    }
}
