package DAO;

import DTO.KhuVucKhoDTO;
import DTO.NhaCungCapDTO;
import DTO.NhomThuocDTO;
import DTO.ThuocDTO;
import config.JDBCUtil;

import java.sql.*;
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
            pst.setInt(6, thuocDTO.getNhaCungCap().getMaNhaCungCap());
            pst.setInt(7, thuocDTO.getNhomThuoc().getMaNhomThuoc());
            pst.setString(8, thuocDTO.getDieuKienBaoQuan());
            pst.setInt(9, thuocDTO.getKhuVucKho().getMaKhuVucKho());
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
    ThuocDTO thuocDTO = null;
    try {
        Connection con = JDBCUtil.getConnection();
        String sql = "SELECT * FROM thuoc WHERE maThuoc = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, t);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            thuocDTO = new ThuocDTO();
            thuocDTO.setMaThuoc(rs.getString("maThuoc"));
            thuocDTO.setTenThuoc(rs.getString("tenThuoc"));
            thuocDTO.setHanSuDung(rs.getDate("hanSuDung"));
            thuocDTO.setGhiChu(rs.getString("ghiChu"));
            thuocDTO.setHoatChatChinh(rs.getString("hoatChatChinh"));
            thuocDTO.setNhaCungCap(new NhaCungCapDTO(rs.getInt("nhaCungCap")));
            thuocDTO.setNhomThuoc(new NhomThuocDTO(rs.getInt("nhomThuoc")));
            thuocDTO.setDieuKienBaoQuan(rs.getString("dieuKienBaoQuan"));
            thuocDTO.setKhuVucKho(new KhuVucKhoDTO(rs.getInt("khuVucKho")));
            thuocDTO.setSoLuongTon(rs.getInt("soLuongTon"));
            thuocDTO.setTrangThai(rs.getString("trangThai"));
        }
        JDBCUtil.closeConnection(con);
    } catch (SQLException ex) {
        Logger.getLogger(ThuocDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return thuocDTO;
}

    @Override
    public String getAutoIncrement() {
        Random random = new Random();
        int number = random.nextInt(900000000) + 100000000; // This will always generate 6-digit numbers
        return "TH" + number;
    }
}
