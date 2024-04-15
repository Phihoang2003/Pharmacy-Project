package Interface;

import DTO.ChuongTrinhKhuyenMai;
import DTO.LoaiKhuyenMai;

import java.util.ArrayList;

public interface ChuongTrinhKhuyenMai_Interface {
    public ArrayList<ChuongTrinhKhuyenMai> selectAll();
    public ArrayList<ChuongTrinhKhuyenMai> getCTKMTheoMaCTKM(String maCTKM, String maLoai);
    public boolean insert (ChuongTrinhKhuyenMai ctkm);
    public boolean delete (ChuongTrinhKhuyenMai ctkm);
    public boolean update (ChuongTrinhKhuyenMai ctkm);
    public ArrayList<LoaiKhuyenMai> getallLoaiCTKM() ;
    public ArrayList<ChuongTrinhKhuyenMai> getallCTKMtheoLoaiKM(String ma);
    public ChuongTrinhKhuyenMai selectById(String ma);

    public String getAutoIncrement();
    public ChuongTrinhKhuyenMai getKMTheomaHD(String maHD);

    // Nguyen Huy Hoang
    public ChuongTrinhKhuyenMai kiemTraKhuyenMai(double tongTien);
    public String layTenKhuyenMaiTheoMa(String maKhuyenMai);
    public String layMaKhuyenMaiTheoTen(String tenKhuyenMai);

    public ArrayList<ChuongTrinhKhuyenMai> getAllCTKMTheoLoaiKMVaTinhTrang(String loaiKM, int tinhTrang);
}
