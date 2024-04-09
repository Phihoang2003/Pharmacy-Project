package BUS;

import DAO.ThuongHieuDAO;
import DTO.ThuongHieu;
import Interface.ThuongHieu_Interface;
import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;

public class ThuongHieu_bus implements ThuongHieu_Interface {
    ThuongHieuDAO th_dao=new ThuongHieuDAO();
    @Override
    public ArrayList<ThuongHieu> getAllTH() {
        return th_dao.getAllTH();
    }

    @Override
    public String layTenThuongHieuTheoMa(String maThuongHieu) {
        return th_dao.layTenThuongHieuTheoMa(maThuongHieu);
    }

    @Override
    public String layMaThuongHieuTheoTen(String tenThuongHieu) {
        return th_dao.layMaThuongHieuTheoTen(tenThuongHieu);
    }
}
