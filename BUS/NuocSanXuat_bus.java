package BUS;

import DAO.NuocSanXuatDAO;
import DTO.NuocSanXuat;
import Interface.NuocSanXuat_Interface;

import java.util.ArrayList;

public class NuocSanXuat_bus implements NuocSanXuat_Interface {
    NuocSanXuatDAO nsx_dao=new NuocSanXuatDAO();
    @Override
    public ArrayList<NuocSanXuat> getAllNSX() {
        return nsx_dao.getAllNSX();
    }

    @Override
    public String layTenNSXTheoMa(String maNSX) {
        return nsx_dao.layTenNSXTheoMa(maNSX);
    }

    @Override
    public String layMaNSXTheoTen(String tenNSX) {
        return nsx_dao.layMaNSXTheoTen(tenNSX);
    }
}
