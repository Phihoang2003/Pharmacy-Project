package DAO;

import DTO.*;
import Interface.SanPham_Interface;
import config.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThuocDAO implements SanPham_Interface {
    public static ThuocDAO getInstance() {
        return new ThuocDAO();
    }

    @Override
    public boolean insert(Thuoc thuocDTO) {
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
        return result>0 ;
    }

    @Override
    public Thuoc timSanPham(String ma) {
        Thuoc thuocDTO=null;
        try {
            Connection con=JDBCUtil.getConnection();
            String sql="SELECT sp.*,dvt.tenDonViTinh,nhh.tenNhom,ctkm.giamGia,qcdg.tenQuyCachDongGoi,nsx.tenNuoc FROM thuoc sp JOIN donvitinh dvt ON sp.donViTinh=dvt.maDonViTinh JOIN nhomhanghoa nhh ON sp.nhomHangHoa=nhh.maNhom JOIN chuongtrinhkhuyenmai ctkm ON sp.chuongTrinhKhuyenMai=ctkm.maCTKM JOIN quycachdonggoi qcdg ON sp.quyCachDongGoi=qcdg.maQuyCachDongGoi JOIN nuocsanxuat nsx ON sp.nuocSanXuat=nsx.maNuoc WHERE maThuoc=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,ma);
            ResultSet rs=pst.executeQuery();
            while (rs.next()){
                thuocDTO=new Thuoc();
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
                thuocDTO.setDonViTinh(new DonViTinh(rs.getString("donViTinh"),rs.getString("tenDonViTinh")));
                thuocDTO.setNhomHangHoa(new NhomHangHoa(rs.getString("nhomHangHoa"),rs.getString("tenNhom")));
                thuocDTO.setChuongTrinhKhuyenMaiEntity(new ChuongTrinhKhuyenMai(rs.getString("chuongTrinhKhuyenMai"),rs.getInt("giamGia")));
                thuocDTO.setQuyCachDongGoi(new QuyCachDongGoi(rs.getString("quyCachDongGoi"),rs.getString("tenQuyCachDongGoi")));
                thuocDTO.setNuocSanXuat(new NuocSanXuat(rs.getString("nuocSanXuat"),rs.getString("tenNuoc")));
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

        }
        catch(SQLException ex){
            Logger.getLogger(ThuocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return thuocDTO;
    }

    @Override
    public boolean update(Thuoc t) {
        return true;
    }

    @Override
    public ArrayList<Thuoc> kiemTraTonKho() {
        return null;
    }

    @Override
    public int laySoLuongTonKhoTheoMaSP(String maSP) {
        int result=0;
        try{
            Connection con=(Connection) JDBCUtil.getConnection();
            String sql="SELECT soLuongTon FROM thuoc WHERE maThuoc=?";
            PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
            pst.setString(1,maSP);
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
                result=rs.getInt("soLuongTon");
            }
            JDBCUtil.closeConnection(con);
        }
        catch(SQLException ex){
            Logger.getLogger(ThuocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public boolean capNhatSoLuong(String maSP, int soLuongNhap) {
        int result=0;
        try{
            Connection con=(Connection) JDBCUtil.getConnection();
            String sql="UPDATE thuoc SET soLuongTon=? WHERE maThuoc=?";
            PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1,soLuongNhap);
            pst.setString(2,maSP);
            result=pst.executeUpdate();
            JDBCUtil.closeConnection(con);

        }
        catch(SQLException ex){
            Logger.getLogger(ThuocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result>0;
    }

    @Override
    public boolean kiemTraMaSanPhamTonTai(String maSP) {
        return false;
    }

    @Override
    public void capNhatKhuyenMai() {

    }

    @Override
    public void capNhatTinhTrang(String maSP, TinhTrangSPEnum tinhTrangDangBan) {

    }


    @Override
    public ArrayList<Thuoc> selectAll() {
        return null;
    }


@Override
public Thuoc selectById(String id) {
    Thuoc thuocDTO = null;
    try {
        Connection con = JDBCUtil.getConnection();
        String sql = "SELECT * FROM thuoc WHERE maThuoc = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            thuocDTO = new Thuoc();
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
    public boolean capNhatSoLuongTonSauKhiTaoHD(String maSP, int soLuong) {
        try {
            Connection con=JDBCUtil.getConnection();
            String sql="UPDATE thuoc SET soLuongTon=soLuongTon-? WHERE maThuoc=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1,soLuong);
            pst.setString(2,maSP);
            int result=pst.executeUpdate();

            if(result<1){
                return false;
            }
            JDBCUtil.closeConnection(con);
            return true;

        }catch(SQLException ex){
            Logger.getLogger(ThuocDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public String getAutoIncrement() {
        Random random = new Random();
        int number = random.nextInt(900000000) + 100000000; // This will always generate 6-digit numbers
        return "TH" + number;
    }
}
