package Interface;



import DTO.ThuongHieu;

import java.util.ArrayList;

public interface ThuongHieu_Interface {
    public ArrayList<ThuongHieu> getAllTH();
    public String layTenThuongHieuTheoMa(String maThuongHieu);
    public String layMaThuongHieuTheoTen(String tenThuongHieu);
}
