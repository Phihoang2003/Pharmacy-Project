package Interface;

import DTO.NhanVien;

import java.sql.SQLException;
import java.util.ArrayList;

public interface NhanVien_Interface{
    public Boolean checkNV(String email, String sdt);
    public NhanVien selectById(String id);
    NhanVien findBySDT(String sdt);
    boolean update(NhanVien updateNV);
    boolean insert(NhanVien insertNV);
    ArrayList<NhanVien> selectAll();
    String getAutoIncrement();
}
