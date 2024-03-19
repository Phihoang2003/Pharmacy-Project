package BUS;

import DAO.ChuongTrinhKhuyenMaiDAO;
import DTO.ChuongTrinhKhuyenMai;
import DTO.LoaiKhuyenMai;
import Interface.ChuongTrinhKhuyenMai_Interface;

import java.util.ArrayList;

public class ChuongTrinhKhuyenMai_bus implements ChuongTrinhKhuyenMai_Interface {
     ChuongTrinhKhuyenMaiDAO ctkm_dao=new ChuongTrinhKhuyenMaiDAO();

    @Override
    public ArrayList<ChuongTrinhKhuyenMai> selectAll() {
        return ctkm_dao.selectAll();
    }

    @Override
    public ArrayList<ChuongTrinhKhuyenMai> getCTKMTheoMaCTKM(String maCTKM, String maLoai) {
        return null;
    }

    @Override
    public boolean insert(ChuongTrinhKhuyenMai ctkm) {
        return ctkm_dao.insert(ctkm);
    }

    @Override
    public boolean delete(ChuongTrinhKhuyenMai ctkm) {
        return false;
    }

    @Override
    public boolean update(ChuongTrinhKhuyenMai ctkm) {
        return ctkm_dao.update(ctkm);
    }

    @Override
    public ArrayList<LoaiKhuyenMai> getallLoaiCTKM() {
        return null;
    }

    @Override
    public ArrayList<ChuongTrinhKhuyenMai> getallCTKMtheoLoaiKM(String ma) {
        return null;
    }

    @Override
    public ChuongTrinhKhuyenMai selectById(String ma) {
        return ctkm_dao.selectById(ma);
    }

    @Override
    public String getAutoIncrement() {
        return ctkm_dao.getAutoIncrement();
    }

    @Override
    public ChuongTrinhKhuyenMai getKMTheomaHD(String maHD) {
        return null;
    }

    @Override
    public ChuongTrinhKhuyenMai kiemTraKhuyenMai(double tongTien) {
        return ctkm_dao.kiemTraKhuyenMai(tongTien);
    }

    @Override
    public String layTenKhuyenMaiTheoMa(String maKhuyenMai) {
        return null;
    }

    @Override
    public String layMaKhuyenMaiTheoTen(String tenKhuyenMai) {
        return null;
    }

    @Override
    public ArrayList<ChuongTrinhKhuyenMai> getAllCTKMTheoLoaiKMVaTinhTrang(String loaiKM, String tinhTrang) {
        return null;
    }
}
