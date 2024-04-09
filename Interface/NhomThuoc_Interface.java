package Interface;


import DTO.NhomHangHoa;

import java.util.ArrayList;

public interface NhomThuoc_Interface {
    public ArrayList<NhomHangHoa> getAllNT();
    public String layTenNhomThuocTheoMa(String maNhomThuoc);
    public String layMaNhomThuocTheoTen(String tenNhomThuoc);
}
