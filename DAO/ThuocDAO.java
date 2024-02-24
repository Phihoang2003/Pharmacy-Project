package DAO;

import DTO.*;
import Interface.DaoInterface;
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
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO thuoc(maThuoc, tenThuoc, hanSuDung, khoiLuong,donViTinh, hoatChatChinh,duongDung, imgUrl, nhomHangHoa, dieuKienBaoQuan, chuongTrinhKhuyenMai, soLuongTon,quyCachDongGoi,nuocSanXuat,donGia, trangThai) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, thuocDTO.getMaThuoc());
            pst.setString(2, thuocDTO.getTenThuoc());
            pst.setDate(3, (Date) thuocDTO.getHanSuDung());
            pst.setDouble(4, thuocDTO.getKhoiLuong());
            pst.setString(5, thuocDTO.getDonViTinh().getMaDonViTinh());
            pst.setString(6, thuocDTO.getHoatChatChinh());
            pst.setString(7, thuocDTO.getDuongDung());
            pst.setString(8, thuocDTO.getImgUrl());
            pst.setString(9, thuocDTO.getNhomHangHoa().getMaNhomHang());
            pst.setString(10, thuocDTO.getDieuKienBaoQuan());
            pst.setString(11, thuocDTO.getChuongTrinhKhuyenMaiEntity().getMaCTKM());
            pst.setInt(12, thuocDTO.getSoLuongTon());
            pst.setString(13, thuocDTO.getQuyCachDongGoi().getMaQuyCachDongGoi());
            pst.setString(14, thuocDTO.getNuocSanXuat().getMaNuoc());
            pst.setDouble(15, thuocDTO.getDonGia());
            pst.setString(16, TinhTrangSPEnum.DANGBAN.toString());
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(ThuocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    @Override
    public int update(ThuocDTO t) {
        return 0;
    }



    @Override
    public ArrayList<ThuocDTO> selectAll() {
        return null;
    }


@Override
public ThuocDTO selectById(String id) {
    ThuocDTO thuocDTO = null;
    try {
        Connection con = JDBCUtil.getConnection();
        String sql = "SELECT * FROM thuoc WHERE maThuoc = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            thuocDTO = new ThuocDTO();
            thuocDTO.setMaThuoc(rs.getString("maThuoc"));
            thuocDTO.setTenThuoc(rs.getString("tenThuoc"));
            thuocDTO.setHanSuDung(rs.getDate("hanSuDung"));
            thuocDTO.setKhoiLuong(rs.getDouble("khoiLuong"));
            thuocDTO.setHoatChatChinh(rs.getString("hoatChatChinh"));
            thuocDTO.setDuongDung(rs.getString("duongDung"));
            thuocDTO.setImgUrl(rs.getString("imgUrl"));
            thuocDTO.setDieuKienBaoQuan(rs.getString("dieuKienBaoQuan"));
            thuocDTO.setDonGia(rs.getDouble("donGia"));
            thuocDTO.setSoLuongTon(rs.getInt("soLuongTon"));
            thuocDTO.setDonViTinh(new DonViTinh(rs.getString("donViTinh")));
            thuocDTO.setNhomHangHoa(new NhomHangHoa(rs.getString("nhomHangHoa")));
            thuocDTO.setChuongTrinhKhuyenMaiEntity(new ChuongTrinhKhuyenMai(rs.getString("chuongTrinhKhuyenMai")));
            thuocDTO.setQuyCachDongGoi(new QuyCachDongGoi(rs.getString("quyCachDongGoi")));
            thuocDTO.setNuocSanXuat(new NuocSanXuat(rs.getString("nuocSanXuat")));
            TinhTrangSPEnum tinhTrangSPEnum=null;
            if(rs.getString("trangThai").equals("Đang bán")) {
                tinhTrangSPEnum = TinhTrangSPEnum.DANGBAN;
            }else if(rs.getString("trangThai").equals("Ngừng bán")){
                tinhTrangSPEnum = TinhTrangSPEnum.NGUNGBAN;
            }
            else{
                tinhTrangSPEnum = TinhTrangSPEnum.HETHANG;
            }
            thuocDTO.setTrangThai(tinhTrangSPEnum);


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
