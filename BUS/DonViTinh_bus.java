package BUS;

import DAO.DonViTinhDAO;
import DTO.DonViTinh;
import Interface.DonViTinh_Interface;

import java.util.ArrayList;

public class DonViTinh_bus implements DonViTinh_Interface {
    DonViTinhDAO dvtDao=new DonViTinhDAO();
    @Override
    public ArrayList<DonViTinh> getAllDVT() {
        return dvtDao.getAllDVT();
    }

    @Override
    public String layTenDVTTheoMa(String maDVT) {
        return dvtDao.layTenDVTTheoMa(maDVT);
    }

    @Override
    public String layMaDVTTheoTen(String tenDVT) {
        return dvtDao.layMaDVTTheoTen(tenDVT);
    }
}
