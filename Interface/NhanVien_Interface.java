package Interface;

import DTO.NhanVienDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface NhanVien_Interface{
    public Boolean checkNV(String email, String sdt) throws SQLException;
    public NhanVienDTO getNV(String sdt) throws SQLException ;
    NhanVienDTO selectById(String id);
    boolean update(NhanVienDTO updateNV);
    boolean insert(NhanVienDTO insertNV);
    ArrayList<NhanVienDTO> selectAll();
    String getAutoIncrement();
}
