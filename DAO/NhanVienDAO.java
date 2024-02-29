package DAO;

import DTO.CaLamViecEnum;
import DTO.ChucVuEnum;
import DTO.NhanVienDTO;
import DTO.TinhTrangNVEnum;
import Interface.NhanVien_Interface;
import config.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NhanVienDAO implements NhanVien_Interface {
    public static NhanVienDAO getInstance(){
        return new NhanVienDAO();
    }

    @Override
    public boolean insert(NhanVienDTO t) {
        int result=0;
        try{
            Connection con=(Connection) JDBCUtil.getConnection();
            String sql="INSERT INTO `nhanvien`(`maNhanVien`,`hoTen`,`gioiTinh`,`sdt`,`ngaySinh`,`trangThai`,`email`,`ngayVaoLam`,`caLamViec`,`diaChi`,`chucVu`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
            pst.setString(1,t.getMaNhanVien());
            pst.setString(2,t.getHoTen());
            pst.setInt(3,t.getGioiTinh());
            pst.setString(4,t.getSdt());
            pst.setDate(5,(Date)t.getNgaySinh());
            pst.setString(6,t.getTrangThai().toString());
            pst.setString(7,t.getEmail());
            pst.setDate(8,(Date)t.getNgayVaoLam());
            pst.setString(9,t.getCaLamViec().toString());
            pst.setString(10,t.getDiaChi());
            pst.setString(11,t.getChucVu().toString());
            result=pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        }
        catch(SQLException ex){
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result >0;
    }

    @Override
    public boolean update(NhanVienDTO t) {

        int result=0;
        try{
            Connection con=(Connection) JDBCUtil.getConnection();
            String sql="UPDATE `nhanvien` SET `hoTen`=?,`gioiTinh`=?,`ngaySinh`=?,`sdt`=?, `trangThai`=?, `email`=?,`ngayVaoLam`=?,`caLamViec`=?,`diaChi`=?,`chucVu`=?  WHERE `maNhanVien`=?";
            PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
            pst.setString(1,t.getHoTen());
            pst.setInt(2,t.getGioiTinh());
            pst.setDate(3,(Date)t.getNgaySinh());
            pst.setString(4,t.getSdt());
            pst.setString(5,t.getTrangThai().toString());
            pst.setString(6,t.getEmail());
            pst.setDate(7,(Date)t.getNgayVaoLam());
            pst.setString(8,t.getCaLamViec().toString());
            pst.setString(9,t.getDiaChi());
            pst.setString(10,t.getChucVu().toString());
            pst.setString(11,t.getMaNhanVien());
            result=pst.executeUpdate();
            JDBCUtil.closeConnection(con);

        }catch(SQLException ex){
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result >0;
    }
    //help me write delete function



    @Override
    public ArrayList<NhanVienDTO> selectAll() {
        ArrayList<NhanVienDTO> result = new ArrayList<NhanVienDTO>();
        try{
            Connection con=(Connection) JDBCUtil.getConnection();
            String  sql="SELECT * FROM `nhanvien`";
            PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
            ResultSet rs =pst.executeQuery(sql);
            while (rs.next()){
                NhanVienDTO nv= new NhanVienDTO();
                nv.setMaNhanVien(rs.getString("maNhanVien"));
                nv.setHoTen(rs.getString("hoTen"));
                nv.setGioiTinh(rs.getInt("gioiTinh"));
                nv.setSdt(rs.getString("sdt"));
                nv.setDiaChi(rs.getString("diaChi"));
                nv.setNgaySinh(rs.getDate("ngaySinh"));
                String trangThai=rs.getString("trangThai");
                if(trangThai.equals("Nghỉ việc")){
                    nv.setTrangThai(TinhTrangNVEnum.NGHIVIEC);
                }
                else if(trangThai.equals("Đang làm việc")){
                    nv.setTrangThai(TinhTrangNVEnum.DANGLAMVIEC);
                }
                else{
                    nv.setTrangThai(TinhTrangNVEnum.NGHIPHEP);
                }
                nv.setEmail(rs.getString("email"));
                nv.setNgayVaoLam(rs.getDate("ngayVaoLam"));
                nv.setCaLamViec(CaLamViecEnum.valueOf(rs.getString("caLamViec").equals("Ca 2")?"CA2":"CA1"));
                nv.setChucVu(ChucVuEnum.valueOf(rs.getString("chucVu").equals("Quản lý")?"QUANLY":"NHANVIEN"));
                result.add(nv);
            }
            JDBCUtil.closeConnection(con);
        }catch(SQLException ex){
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Boolean checkNV(String email, String sdt) throws SQLException {
        return null;
    }

    @Override
    public NhanVienDTO getNV(String sdt) throws SQLException {
        return null;
    }
    @Override
    public NhanVienDTO findBySDT(String sdt) {
        NhanVienDTO nv = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM `nhanvien` WHERE `sdt` = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, sdt);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                nv = new NhanVienDTO();
                nv.setMaNhanVien(rs.getString("maNhanVien"));
                nv.setHoTen(rs.getString("hoTen"));
                nv.setGioiTinh(rs.getInt("gioiTinh"));
                nv.setSdt(rs.getString("sdt"));
                nv.setDiaChi(rs.getString("diaChi"));
                nv.setNgaySinh(rs.getDate("ngaySinh"));
                String trangThai = rs.getString("trangThai");
                if (trangThai.equals("Nghỉ việc")) {
                    nv.setTrangThai(TinhTrangNVEnum.NGHIVIEC);
                } else if (trangThai.equals("Nghỉ phép")) {
                    nv.setTrangThai(TinhTrangNVEnum.NGHIPHEP);
                } else {
                    nv.setTrangThai(TinhTrangNVEnum.DANGLAMVIEC);
                }
                nv.setEmail(rs.getString("email"));
                nv.setNgayVaoLam(rs.getDate("ngayVaoLam"));
                nv.setCaLamViec(CaLamViecEnum.valueOf(rs.getString("caLamViec").equals("Ca 2") ? "CA2" : "CA1"));
                nv.setChucVu(ChucVuEnum.valueOf(rs.getString("chucVu").equals("Quản lý") ? "QUANLY" : "NHANVIEN"));
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nv;
    }
    @Override
    public NhanVienDTO selectById(String t) {
        NhanVienDTO nv = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM `nhanvien` WHERE `maNhanVien` = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                nv = new NhanVienDTO();
                nv.setMaNhanVien(rs.getString("maNhanVien"));
                nv.setHoTen(rs.getString("hoTen"));
                nv.setGioiTinh(rs.getInt("gioiTinh"));
                nv.setSdt(rs.getString("sdt"));
                nv.setDiaChi(rs.getString("diaChi"));
                nv.setNgaySinh(rs.getDate("ngaySinh"));
                String trangThai = rs.getString("trangThai");
                if (trangThai.equals("Nghỉ việc")) {
                    nv.setTrangThai(TinhTrangNVEnum.NGHIVIEC);
                } else if (trangThai.equals("Nghỉ phép")) {
                    nv.setTrangThai(TinhTrangNVEnum.NGHIPHEP);
                } else {
                    nv.setTrangThai(TinhTrangNVEnum.DANGLAMVIEC);
                }
                nv.setEmail(rs.getString("email"));
                nv.setNgayVaoLam(rs.getDate("ngayVaoLam"));
                nv.setCaLamViec(CaLamViecEnum.valueOf(rs.getString("caLamViec").equals("Ca 2") ? "CA2" : "CA1"));
                nv.setChucVu(ChucVuEnum.valueOf(rs.getString("chucVu").equals("Quản lý") ? "QUANLY" : "NHANVIEN"));
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nv;
    }

    @Override
    public String getAutoIncrement() {
        Random random = new Random();
        int number = random.nextInt(900000000) + 100000000; // This will always generate 6-digit numbers
        return "NV" + number;
    }
}
