package DAO;
import DTO.PhienBanThuocDTO;
import config.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
            pst.setString(2, phienBanThuocDTO.getMaThuoc());
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
            Logger.getLogger(ThuocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int update(PhienBanThuocDTO phienBanThuocDTO) {
        return 0;
    }

    @Override
    public int delete(String t) {
        return 0;
    }

    @Override
    public ArrayList<PhienBanThuocDTO> selectAll() {
        return null;
    }

    @Override
    public PhienBanThuocDTO selectById(String t) {
        return null;
    }

    @Override
    public String getAutoIncrement() {
        Random random = new Random();
        int number = random.nextInt(900000000) + 100000000; // This will always generate 6-digit numbers
        return "PTH" + number;
    }
}
