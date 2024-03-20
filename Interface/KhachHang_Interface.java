
package Interface;

import DTO.KhachHang;

import java.util.ArrayList;


public interface KhachHang_Interface {
    public KhachHang selectById(String id  );
    public boolean update(KhachHang updateKH);
    public boolean insert(KhachHang insertKH);
    public ArrayList<KhachHang> selectAll();

    public String getAutoIncrement();
    public KhachHang timKiemTheoSDT(String sdt);

    public KhachHang getKHTheoMa(String ma);
}
