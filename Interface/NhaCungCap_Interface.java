package Interface;

import DTO.NhaCungCap;

import java.util.ArrayList;

public interface NhaCungCap_Interface {
    public ArrayList<NhaCungCap> selectAll();
    public boolean insert(NhaCungCap ncc);
    public ArrayList<NhaCungCap> timKiemNCC(String ma);
    public boolean update(NhaCungCap maNCC);
    public ArrayList<NhaCungCap> layDSNCCDangNhap();
    public String layTenNhaCungCapTheoMa(String maNhaCungCap);
    public String layMaNhaCungCapTheoTen(String tenNhaCungCap);
    public NhaCungCap timKiemTheoSDT(String sdt);
    public NhaCungCap selectById(String id);
    public String getAutoIncrement();
}
