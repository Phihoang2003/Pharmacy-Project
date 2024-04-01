package BUS;

import DAO.DoiTraDAO;
import DTO.ChiTietDoiTra;
import DTO.DoiTra;
import Interface.DoiTra_Interface;

import java.sql.Date;
import java.util.ArrayList;

public class DoiTra_bus implements DoiTra_Interface {
    DoiTraDAO dt_dao=new DoiTraDAO();
    @Override
    public boolean taoDoiTra(DoiTra dt, ArrayList<ChiTietDoiTra> ctdtList) {
        return dt_dao.taoDoiTra(dt, ctdtList);
    }

    @Override
    public ArrayList<DoiTra> getAllDoiTra() {
        return dt_dao.getAllDoiTra();
    }

    @Override
    public DoiTra getDoiTraTheoMa(String ma) {
        return dt_dao.getDoiTraTheoMa(ma);
    }

    @Override
    public ArrayList<DoiTra> getDoiTraTheoNgayLap(Date ngayLap) {
        return dt_dao.getDoiTraTheoNgayLap(ngayLap);
    }

    @Override
    public DoiTra getDoiTraTheoDieuKien(String ma, Date ngayLap) {
        return dt_dao.getDoiTraTheoDieuKien(ma, ngayLap);
    }

    @Override
    public int getTongSoLuongSPDoiTra(String maHD, String maSP) {
        return dt_dao.getTongSoLuongSPDoiTra(maHD, maSP);
    }

    @Override
    public boolean kiemTraThoiHanDoiTra(String maHD) {
        return dt_dao.kiemTraThoiHanDoiTra(maHD);
    }

    @Override
    public String getAutoIncrement() {
        return dt_dao.getAutoIncrement();
    }
}
