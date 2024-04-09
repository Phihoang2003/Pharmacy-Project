package Interface;

import DTO.NuocSanXuat;


import java.util.ArrayList;

public interface NuocSanXuat_Interface {
    public ArrayList<NuocSanXuat> getAllNSX();
    public String layTenNSXTheoMa(String maNSX);
    public String layMaNSXTheoTen(String tenNSX);
}
