package DAO;

import DTO.ThuocDTO;
import config.JDBCUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThuocDAO implements DaoInterface<ThuocDTO> {
    public static ThuocDAO getInstance() {
        return new ThuocDAO();
    }

    @Override
    public int insert(ThuocDTO thuocDTO) {
        int result = 0;
        try{
            Connection con= (Connection) JDBCUtil.getConnection();
            String sql = "INSERT INTO thuoc(`maThuoc`,`tenThuoc`,`hanSuDung`,`ghiChu`,`hoatChatChinh`,`nhaCungCap`,`nhomThuoc`,`dieuKienBaoQuan`,`khuVucKho`,`soLuongTon`,`trangThai`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, thuocDTO.getMaThuoc());
            pst.setString(2, thuocDTO.getTenThuoc());
            pst.setDate(3, (Date) thuocDTO.getHanSuDung());
            pst.setString(4, thuocDTO.getGhiChu());
            pst.setString(5, thuocDTO.getHoatChatChinh());
            pst.setInt(6, thuocDTO.getNhaCungCap());
            pst.setInt(7, thuocDTO.getNhomThuoc());
            pst.setString(8, thuocDTO.getDieuKienBaoQuan());
            pst.setInt(9, thuocDTO.getKhuVucKho());
            pst.setInt(10, thuocDTO.getSoLuongTon());
            pst.setString(11, thuocDTO.getTrangThai());
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        }catch(SQLException ex){
            Logger.getLogger(ThuocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int update(ThuocDTO thuocDTO) {
        return 0;
    }

    @Override
    public int delete(String t) {
        return 0;
    }

    @Override
    public ArrayList<ThuocDTO> selectAll() {
        return null;
    }

    @Override
    public ThuocDTO selectById(String t) {
        return null;
    }

    @Override
    public String getAutoIncrement() {
        Random random = new Random();
        int number = random.nextInt(900000000) + 100000000; // This will always generate 6-digit numbers
        return "TH" + number;
    }
}
