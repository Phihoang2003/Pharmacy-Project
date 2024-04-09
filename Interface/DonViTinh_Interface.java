package Interface;

import DTO.DonViTinh;

import java.util.ArrayList;

public interface DonViTinh_Interface {
    public ArrayList<DonViTinh> getAllDVT();
    public String layTenDVTTheoMa(String maDVT);
    public String layMaDVTTheoTen(String tenDVT);
}
