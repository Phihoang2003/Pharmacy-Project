package DAO;
import DTO.PhienBanThuocDTO;
import DTO.ThuocDTO;
import config.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PhienBanThuocDAO implements DaoInterface<PhienBanThuocDTO>{
    public static PhienBanThuocDAO getInstance() {
        return new PhienBanThuocDAO();
    }
    @Override
    public int insert(PhienBanThuocDTO phienBanThuocDTO) {
        int result=0;
        try{
            Connection con= (Connection) JDBCUtil.getConnection();
            String sql="INSERT INTO phienbanthuoc(`maPhienBanThuoc`,`maThuoc`,`donViTinh`,`khoiLuong`,`imgUrl`,`duongDung`,`quyCachDongGoi`,`giaBan`,`giaNhap`,`soLuongTon`,`nuocSanXuat`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, phienBanThuocDTO.getMaPhienBanThuoc());
            pst.setString(2, phienBanThuocDTO.getThuoc().getMaThuoc());
            pst.setString(3, phienBanThuocDTO.getDonViTinh());
            pst.setString(4, phienBanThuocDTO.getKhoiLuong());
            pst.setString(5, phienBanThuocDTO.getImgUrl());
            pst.setString(6, phienBanThuocDTO.getDuongDung());
            pst.setString(7, phienBanThuocDTO.getQuyCachDongGoi());
            pst.setDouble(8, phienBanThuocDTO.getGiaBan());
            pst.setDouble(9, phienBanThuocDTO.getGiaNhap());
            pst.setInt(10, phienBanThuocDTO.getSoLuongTon());
            pst.setString(11, phienBanThuocDTO.getNuocSanXuat());
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        }
        catch(SQLException ex){
            Logger.getLogger(PhienBanThuocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int update(PhienBanThuocDTO phienBanThuocDTO) {
        int result=0;
        try{
            Connection con=(Connection) JDBCUtil.getConnection();
            String sql="UPDATE phienbanthuoc SET donViTinh=?, khoiLuong=?, imgUrl=?, duongDung=?, quyCachDongGoi=?, giaBan=?, giaNhap=?, soLuongTon=?, nuocSanXuat=? WHERE maPhienBanThuoc=?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, phienBanThuocDTO.getDonViTinh());
            pst.setString(2, phienBanThuocDTO.getKhoiLuong());

            pst.setString(3, phienBanThuocDTO.getImgUrl());
            pst.setString(4, phienBanThuocDTO.getDuongDung());
            pst.setString(5, phienBanThuocDTO.getQuyCachDongGoi());
            pst.setDouble(6, phienBanThuocDTO.getGiaBan());
            pst.setDouble(7, phienBanThuocDTO.getGiaNhap());
            pst.setInt(8, phienBanThuocDTO.getSoLuongTon());
            pst.setString(9, phienBanThuocDTO.getNuocSanXuat());
            pst.setString(10, phienBanThuocDTO.getMaPhienBanThuoc());
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);

        }catch(SQLException ex){
            Logger.getLogger(PhienBanThuocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int delete(String t) {
        return 0;
    }

    @Override
    public ArrayList<PhienBanThuocDTO> selectAll() {
        return null;
    }


    public ArrayList<PhienBanThuocDTO> selectAllPhienBan(String t) {
    ArrayList<PhienBanThuocDTO> list = new ArrayList<>();
    try {
        Connection con = JDBCUtil.getConnection();
        // Modify the SQL query to include a JOIN clause
        String sql = "SELECT * FROM phienbanthuoc pb JOIN thuoc t ON pb.maThuoc = t.maThuoc WHERE pb.maThuoc = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, t);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            PhienBanThuocDTO phienBanThuocDTO = new PhienBanThuocDTO();
            phienBanThuocDTO.setMaPhienBanThuoc(rs.getString("maPhienBanThuoc"));

            // Create a new ThuocDTO object and set its properties
            ThuocDTO thuoc = new ThuocDTO();
            thuoc.setMaThuoc(rs.getString("t.maThuoc"));
            thuoc.setTenThuoc(rs.getString("t.tenThuoc"));
            thuoc.setHanSuDung(rs.getDate("t.hanSuDung"));
            thuoc.setGhiChu(rs.getString("t.ghiChu"));
            thuoc.setHoatChatChinh(rs.getString("t.hoatChatChinh"));
            // ... set other fields ...

            phienBanThuocDTO.setThuoc(thuoc);

            // ... rest of the code ...
            list.add(phienBanThuocDTO);
        }
        JDBCUtil.closeConnection(con);
    } catch (SQLException ex) {
        Logger.getLogger(PhienBanThuocDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
}

    @Override
public PhienBanThuocDTO selectById(String t) {
    PhienBanThuocDTO phienBanThuocDTO = null;
    try {
        Connection con = JDBCUtil.getConnection();
        String sql = "SELECT * FROM phienbanthuoc WHERE maPhienBanThuoc = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, t);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            phienBanThuocDTO = new PhienBanThuocDTO();
            phienBanThuocDTO.setMaPhienBanThuoc(rs.getString("maPhienBanThuoc"));
            phienBanThuocDTO.setThuoc(new ThuocDTO(rs.getString("maThuoc")));
            phienBanThuocDTO.setDonViTinh(rs.getString("donViTinh"));
            phienBanThuocDTO.setKhoiLuong(rs.getString("khoiLuong"));
            phienBanThuocDTO.setImgUrl(rs.getString("imgUrl"));
            phienBanThuocDTO.setDuongDung(rs.getString("duongDung"));
            phienBanThuocDTO.setQuyCachDongGoi(rs.getString("quyCachDongGoi"));
            phienBanThuocDTO.setGiaBan(rs.getDouble("giaBan"));
            phienBanThuocDTO.setGiaNhap(rs.getDouble("giaNhap"));
            phienBanThuocDTO.setSoLuongTon(rs.getInt("soLuongTon"));
            phienBanThuocDTO.setNuocSanXuat(rs.getString("nuocSanXuat"));
        }
        JDBCUtil.closeConnection(con);
    } catch (SQLException ex) {
        Logger.getLogger(PhienBanThuocDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return phienBanThuocDTO;
}

    @Override
    public String getAutoIncrement() {
        Random random = new Random();
        int number = random.nextInt(900000000) + 100000000; // This will always generate 6-digit numbers
        return "PTH" + number;
    }
}
