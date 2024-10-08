package DAO;

import DTO.ChuongTrinhKhuyenMai;
import DTO.LoaiKhuyenMai;
import Interface.ChuongTrinhKhuyenMai_Interface;
import Interface.DaoInterface;
import config.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChuongTrinhKhuyenMaiDAO implements ChuongTrinhKhuyenMai_Interface {
public static ChuongTrinhKhuyenMaiDAO getInstance() {
        return new ChuongTrinhKhuyenMaiDAO();
    }
    @Override
    public boolean insert(ChuongTrinhKhuyenMai t) {
        int result=0;
        try {
            Connection con = (Connection) JDBCUtil.getConnection();
            String sql="INSERT INTO `chuongtrinhkhuyenmai`(`maCTKM`, `tenCTKM`, `ngayBatDau`, `ngayKetThuc`,`soTienToiThieu`,`soTienToiDa`,`giamGia`, `trangThai`,`maLoaiKM`) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
            pst.setString(1,t.getMaCTKM());
            pst.setString(2,t.getTenCTKM());
            pst.setDate(3, (java.sql.Date) t.getNgayBatDau());
            pst.setDate(4, (java.sql.Date) t.getNgayKetThuc());
            pst.setDouble(5,t.getSoTienToiThieu());
            pst.setDouble(6,t.getSoTienToiDa());
            pst.setInt(7,t.getGiamGia());
            pst.setInt(8,t.getTinhTrang());
            pst.setString(9,t.getMaLoaiKM().getMaLoaiKM());
            result=pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        }catch(SQLException ex){
            Logger.getLogger(ChuongTrinhKhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result>0 ;
    }

    @Override
    public boolean delete(ChuongTrinhKhuyenMai ctkm) {
        return false;
    }

    @Override
public boolean update(ChuongTrinhKhuyenMai t) {
    int result = 0;
    try {
        Connection con = JDBCUtil.getConnection();
        String sql = "UPDATE chuongtrinhkhuyenmai SET tenCTKM = ?, ngayBatDau = ?, ngayKetThuc = ?, soTienToiThieu = ?, soTienToiDa = ?, giamGia = ?, trangThai = ?, maLoaiKM = ? WHERE maCTKM = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, t.getTenCTKM());
        pst.setDate(2, new java.sql.Date(t.getNgayBatDau().getTime()));
        pst.setDate(3, new java.sql.Date(t.getNgayKetThuc().getTime()));
        pst.setDouble(4, t.getSoTienToiThieu());
        pst.setDouble(5, t.getSoTienToiDa());
        pst.setInt(6, t.getGiamGia());
        pst.setInt(7, t.getTinhTrang());
        pst.setString(8, t.getMaLoaiKM().getMaLoaiKM());
        pst.setString(9, t.getMaCTKM());
        result = pst.executeUpdate();
        JDBCUtil.closeConnection(con);
    } catch (SQLException ex) {
        Logger.getLogger(ChuongTrinhKhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return result > 0;
}

    @Override
    public ArrayList<LoaiKhuyenMai> getallLoaiCTKM() {
        return null;
    }

    @Override
    public ArrayList<ChuongTrinhKhuyenMai> getallCTKMtheoLoaiKM(String ma) {
    ArrayList<ChuongTrinhKhuyenMai> list = new ArrayList<>();
    try{
        Connection con=JDBCUtil.getConnection();
        String sql="Select * from chuongtrinhkhuyenmai where maLoaiKM=?";
        PreparedStatement pst=con.prepareStatement(sql);
        pst.setString(1,ma);
        ResultSet rs=pst.executeQuery();
        while(rs.next()){
            ChuongTrinhKhuyenMai ctkm=new ChuongTrinhKhuyenMai();
            ctkm.setMaCTKM(rs.getString("maCTKM"));
            ctkm.setTenCTKM(rs.getString("tenCTKM"));
            ctkm.setMaLoaiKM(new LoaiKhuyenMai(rs.getString("maLoaiKM")));
            ctkm.setNgayBatDau(rs.getDate("ngayBatDau"));
            ctkm.setNgayKetThuc(rs.getDate("ngayKetThuc"));
            ctkm.setSoTienToiThieu(rs.getDouble("soTienToiThieu"));
            ctkm.setSoTienToiDa(rs.getDouble("soTienToiDa"));
            ctkm.setGiamGia(rs.getInt("giamGia"));
            ctkm.setTinhTrang(rs.getInt("trangThai"));
            list.add(ctkm);
        }
        JDBCUtil.closeConnection(con);

    }catch(SQLException ex){
            Logger.getLogger(ChuongTrinhKhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    @Override
    public ArrayList<ChuongTrinhKhuyenMai> selectAll() {
        return null;
    }

    @Override
    public ArrayList<ChuongTrinhKhuyenMai> getCTKMTheoMaCTKM(String maCTKM, String maLoai) {
    ArrayList<ChuongTrinhKhuyenMai> list = new ArrayList<>();
    try{
        Connection con=JDBCUtil.getConnection();
        String sql="Select * from chuongtrinhkhuyenmai where maCTKM=? and maLoaiKM=?";
        PreparedStatement pst=con.prepareStatement(sql);
        pst.setString(1,maCTKM);
        pst.setString(2,maLoai);
        ResultSet rs=pst.executeQuery();
        while(rs.next()){
            ChuongTrinhKhuyenMai ctkm=new ChuongTrinhKhuyenMai();
            ctkm.setMaCTKM(rs.getString("maCTKM"));
            ctkm.setTenCTKM(rs.getString("tenCTKM"));
            ctkm.setMaLoaiKM(new LoaiKhuyenMai(rs.getString("maLoaiKM")));
            ctkm.setNgayBatDau(rs.getDate("ngayBatDau"));
            ctkm.setNgayKetThuc(rs.getDate("ngayKetThuc"));
            ctkm.setSoTienToiThieu(rs.getDouble("soTienToiThieu"));
            ctkm.setSoTienToiDa(rs.getDouble("soTienToiDa"));
            ctkm.setGiamGia(rs.getInt("giamGia"));
            ctkm.setTinhTrang(rs.getInt("trangThai"));
            list.add(ctkm);
        }
        JDBCUtil.closeConnection(con);

    }catch(SQLException ex){
        Logger.getLogger(ChuongTrinhKhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
        return list;
    }

    @Override
    public ChuongTrinhKhuyenMai selectById(String t) {
        ChuongTrinhKhuyenMai ctkm= new ChuongTrinhKhuyenMai();
        try {
            Connection con = (Connection) JDBCUtil.getConnection();
            String sql="SELECT * FROM `chuongtrinhkhuyenmai` WHERE maCTKM=?";
            PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
            pst.setString(1,t);
            ResultSet result=pst.executeQuery();
            while(result.next()){
                ctkm.setMaCTKM(result.getString("maCTKM"));
                ctkm.setMaLoaiKM(new LoaiKhuyenMai(result.getString("maLoaiKM")));
                ctkm.setTenCTKM(result.getString("tenCTKM"));
                ctkm.setNgayBatDau(result.getDate("ngayBatDau"));
                ctkm.setNgayKetThuc(result.getDate("ngayKetThuc"));
                ctkm.setSoTienToiThieu(result.getDouble("soTienToiThieu"));
                ctkm.setSoTienToiDa(result.getDouble("soTienToiDa"));
                ctkm.setGiamGia(result.getInt("giamGia"));
                ctkm.setTinhTrang(result.getInt("trangThai"));
            }
            JDBCUtil.closeConnection(con);
        }catch(SQLException ex){
            Logger.getLogger(ChuongTrinhKhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ctkm;
    }

    @Override
    public String getAutoIncrement() {
        Random random = new Random();
        int number = random.nextInt(900000000) + 100000000; // This will always generate 6-digit numbers
        return "KM" + number;
    }

    @Override
public ChuongTrinhKhuyenMai getKMTheomaHD(String maHD) {
    ChuongTrinhKhuyenMai ctkm = null;
    try {
        Connection con = JDBCUtil.getConnection();
        String sql = "select * from chuongtrinhkhuyenmai where maCTKM in(select maCTKM from hoadon where maHD = ?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, maHD);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            ctkm = new ChuongTrinhKhuyenMai();
            ctkm.setMaCTKM(rs.getString("maCTKM"));
            ctkm.setTenCTKM(rs.getString("tenCTKM"));
            ctkm.setMaLoaiKM(new LoaiKhuyenMai(rs.getString("maLoaiKM")));
            ctkm.setNgayBatDau(rs.getDate("ngayBatDau"));
            ctkm.setNgayKetThuc(rs.getDate("ngayKetThuc"));
            ctkm.setSoTienToiThieu(rs.getDouble("soTienToiThieu"));
            ctkm.setSoTienToiDa(rs.getDouble("soTienToiDa"));
            ctkm.setGiamGia(rs.getInt("giamGia"));
            ctkm.setTinhTrang(rs.getInt("trangThai"));
        }
        JDBCUtil.closeConnection(con);
    } catch (SQLException ex) {
        Logger.getLogger(ChuongTrinhKhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return ctkm;
}

    @Override
    public ChuongTrinhKhuyenMai kiemTraKhuyenMai(double tongTien) {
        ChuongTrinhKhuyenMai ctkm=new ChuongTrinhKhuyenMai();
        try{
            Connection con=(Connection) JDBCUtil.getConnection();
            String sql="Select * from ChuongTrinhKhuyenMai where CURDATE() between ngayBatDau and ngayKetThuc and soTienToiThieu <= ? and maLoaiKM='GGHD' order by giamGia desc LIMIT 1";
            PreparedStatement pst= (PreparedStatement) con.prepareStatement(sql);
            pst.setDouble(1,tongTien);
            ResultSet result=pst.executeQuery();

            if(result.next()){
                ctkm.setMaCTKM(result.getString("maCTKM"));
                ctkm.setTenCTKM(result.getString("tenCTKM"));
                ctkm.setMaLoaiKM(new LoaiKhuyenMai(result.getString("maLoaiKM")));
                ctkm.setNgayBatDau(result.getDate("ngayBatDau"));
                ctkm.setNgayKetThuc(result.getDate("ngayKetThuc"));
                ctkm.setSoTienToiThieu(result.getDouble("soTienToiThieu"));
                ctkm.setSoTienToiDa(result.getDouble("soTienToiDa"));
                ctkm.setGiamGia(result.getInt("giamGia"));
                ctkm.setTinhTrang(result.getInt("trangThai"));
            }

        }catch(SQLException ex){
            Logger.getLogger(ChuongTrinhKhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ctkm;
    }

    @Override
    public String layTenKhuyenMaiTheoMa(String maCTKM) {
    String tenCTKM = null;
    try {
        Connection con = JDBCUtil.getConnection();
        String sql = "SELECT tenCTKM FROM chuongtrinhkhuyenmai WHERE maCTKM = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, maCTKM);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            tenCTKM = rs.getString("tenCTKM");
        }
        JDBCUtil.closeConnection(con);
    } catch (SQLException ex) {
        Logger.getLogger(ChuongTrinhKhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return tenCTKM;
}

    @Override
    public String layMaKhuyenMaiTheoTen(String tenKhuyenMai) {
        return null;
    }

    @Override
public ArrayList<ChuongTrinhKhuyenMai> getAllCTKMTheoLoaiKMVaTinhTrang(String loaiKM, int tinhTrang) {
    ArrayList<ChuongTrinhKhuyenMai> list = new ArrayList<>();
    try {
        Connection con = config.JDBCUtil.getConnection();
        String sql = "SELECT * FROM chuongtrinhkhuyenmai WHERE maLoaiKM = ? AND trangThai = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, loaiKM);
        pst.setInt(2, tinhTrang);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            ChuongTrinhKhuyenMai ctkm = new ChuongTrinhKhuyenMai();
            ctkm.setMaCTKM(rs.getString("maCTKM"));
            ctkm.setTenCTKM(rs.getString("tenCTKM"));
            ctkm.setMaLoaiKM(new LoaiKhuyenMai(rs.getString("maLoaiKM")));
            ctkm.setNgayBatDau(rs.getDate("ngayBatDau"));
            ctkm.setNgayKetThuc(rs.getDate("ngayKetThuc"));
            ctkm.setSoTienToiThieu(rs.getDouble("soTienToiThieu"));
            ctkm.setSoTienToiDa(rs.getDouble("soTienToiDa"));
            ctkm.setGiamGia(rs.getInt("giamGia"));
            ctkm.setTinhTrang(rs.getInt("trangThai"));
            list.add(ctkm);
        }
        config.JDBCUtil.closeConnection(con);
    } catch (SQLException ex) {
        java.util.logging.Logger.getLogger(ChuongTrinhKhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
}


}
