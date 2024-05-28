package Interface;

import DTO.NhanVien;

import java.util.ArrayList;

public interface NhanVien_Interface{
    Boolean checkNV(String email, String sdt);
    NhanVien selectById(String id);
    NhanVien findBySDT(String sdt);
    NhanVien findByMa(String ma);
    boolean update(NhanVien updateNV);
    boolean insert(NhanVien insertNV);
    ArrayList<NhanVien> selectAll();
    String getAutoIncrement();
}
