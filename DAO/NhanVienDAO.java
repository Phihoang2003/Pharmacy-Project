package DAO;

import DTO.NhanVienDTO;
import config.JDBCUtil;
import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NhanVienDAO implements DaoInterface<NhanVienDTO> {
    public static NhanVienDAO getInstance(){
        return new NhanVienDAO();
    }

    @Override
    public int insert(NhanVienDTO t) {
        int result=0;
        try{
            Connection con=(Connection) JDBCUtil.getConnection();
            String sql="INSERT INTO `nhanvien`(`maNhanVien`,`hoTen`,`gioiTinh`,`sdt`,`ngaySinh`,`trangThai`,`email`,`ngayVaoLam`,`caLamViec`) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1,t.getMaNhanVien());
            pst.setString(2,t.getHoTen());
            pst.setInt(3,t.getGioiTinh());
            pst.setString(4,t.getSdt());
            pst.setDate(5,(Date)t.getNgaySinh());
            pst.setString(6,t.getTrangThai().toString());
            pst.setString(7,t.getEmail());
            pst.setDate(8,(Date)t.getNgayVaoLam());
            pst.setString(9,t.getCaLamViec().toString());
            result=pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        }
        catch(SQLException ex){
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int update(NhanVienDTO t) {

        int result=0;
        try{
            Connection con=(Connection) JDBCUtil.getConnection();
            String sql="UPDATE `nhanvien`SET `hoTen`=?,`gioiTinh`=?,`ngaySinh`=?,`sdt`=?, `trangThai`=?, `email`=?,`ngayVaoLam`=?,`caLamViec`=?  WHERE `maNhanVien`=?";
            PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
            pst.setString(1,t.getHoTen());
            pst.setInt(2,t.getGioiTinh());
            pst.setDate(3,(Date)t.getNgaySinh());
            pst.setString(4,t.getSdt());
            pst.setString(5,t.getTrangThai().toString());
            pst.setString(6,t.getEmail());
            pst.setDate(7,(Date)t.getNgayVaoLam());
            pst.setString(8,t.getCaLamViec().toString());
            pst.setInt(9,t.getMaNhanVien());
            result=pst.executeUpdate();
            JDBCUtil.closeConnection(con);

        }catch(SQLException ex){
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int delete(String t) {
        return 0;
    }

    @Override
    public ArrayList<NhanVienDTO> selectAll() {
        return null;
    }

    @Override
    public NhanVienDTO selectById(String t) {
        return null;
    }

    @Override
    public int getAutoIncrement() {
        return 0;
    }
}
