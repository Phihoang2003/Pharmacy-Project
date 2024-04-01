package Interface;


import DTO.ChiTietDoiTra;
import DTO.DoiTra;

import java.sql.Date;
import java.util.ArrayList;

public interface DoiTra_Interface {
    public boolean taoDoiTra(DoiTra dt, ArrayList<ChiTietDoiTra> ctdtList);
    public ArrayList<DoiTra> getAllDoiTra();
    public DoiTra getDoiTraTheoMa(String ma);
    public ArrayList<DoiTra> getDoiTraTheoNgayLap(Date ngayLap);
    public DoiTra getDoiTraTheoDieuKien(String ma, Date ngayLap);
    public int getTongSoLuongSPDoiTra(String maHD, String maSP);
    public boolean kiemTraThoiHanDoiTra(String maHD);

    public String getAutoIncrement();
}
