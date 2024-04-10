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
            String sql = "INSERT INTO thuoc(maThuoc, tenThuoc, hanSuDung, khoiLuong,donViTinh, hoatChatChinh,duongDung, imgUrl, nhomHangHoa, dieuKienBaoQuan, chuongTrinhKhuyenMai, soLuongTon,quyCachDongGoi,nuocSanXuat,donGia, trangThai,thuocKeDon,thuongHieu) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, thuocDTO.getMaThuoc());
            pst.setString(2, thuocDTO.getTenThuoc());
            pst.setDate(3, new java.sql.Date(thuocDTO.getHanSuDung().getTime()));
            pst.setDouble(4, thuocDTO.getKhoiLuong());
            pst.setString(5, thuocDTO.getDonViTinh().getMaDonViTinh());
            pst.setString(6, thuocDTO.getHoatChatChinh());
            pst.setString(7, thuocDTO.getDuongDung());
            pst.setString(8, thuocDTO.getImgUrl());
            pst.setString(9, thuocDTO.getNhomHangHoa().getMaNhomHang());
            pst.setString(10, thuocDTO.getDieuKienBaoQuan());
            pst.setString(11, thuocDTO.getChuongTrinhKhuyenMaiEntity().getMaCTKM());
            pst.setInt(12, thuocDTO.getSoLuongTon());
            pst.setString(13, thuocDTO.getQuyCachDongGoi());
            pst.setString(14, thuocDTO.getNuocSanXuat().getMaNuoc());
            pst.setDouble(15, thuocDTO.getDonGia());
            pst.setString(16, TinhTrangSPEnum.DANGBAN.toString());
            pst.setBoolean(17, thuocDTO.isThuocKeDon());
            pst.setString(18, thuocDTO.getThuongHieu().getMaThuongHieu());
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
            String sql="SELECT sp.*,dvt.tenDonViTinh,nhh.tenNhom,ctkm.giamGia,nsx.tenNuoc,th.tenThuongHieu FROM thuoc sp JOIN donvitinh dvt ON sp.donViTinh=dvt.maDonViTinh JOIN nhomhanghoa nhh ON sp.nhomHangHoa=nhh.maNhom JOIN thuonghieu th ON sp.thuongHieu=th.maThuongHieu JOIN chuongtrinhkhuyenmai ctkm ON sp.chuongTrinhKhuyenMai=ctkm.maCTKM  JOIN nuocsanxuat nsx ON sp.nuocSanXuat=nsx.maNuoc WHERE maThuoc=?";
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
                thuocDTO.setQuyCachDongGoi(rs.getString("quyCachDongGoi"));
                thuocDTO.setNuocSanXuat(new NuocSanXuat(rs.getString("nuocSanXuat"),rs.getString("tenNuoc")));
                thuocDTO.setThuongHieu(new ThuongHieu(rs.getString("thuongHieu"),rs.getString("tenThuongHieu")));
                thuocDTO.setThuocKeDon(rs.getBoolean("thuocKeDon"));

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
    int result = 0;
    try {
        Connection con = JDBCUtil.getConnection();
        String sql = "UPDATE thuoc SET tenThuoc = ?, hanSuDung = ?, khoiLuong = ?, hoatChatChinh = ?, duongDung = ?, imgUrl = ?, dieuKienBaoQuan = ?, donGia = ?, soLuongTon = ?, donViTinh = ?, nhomHangHoa = ?, chuongTrinhKhuyenMai = ?, quyCachDongGoi = ?, thuongHieu = ?, thuocKeDon = ?, nuocSanXuat = ?, trangThai = ? WHERE maThuoc = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, t.getTenThuoc());
        pst.setDate(2, new java.sql.Date(t.getHanSuDung().getTime()));
        pst.setDouble(3, t.getKhoiLuong());
        pst.setString(4, t.getHoatChatChinh());
        pst.setString(5, t.getDuongDung());
        pst.setString(6, t.getImgUrl());
        pst.setString(7, t.getDieuKienBaoQuan());
        pst.setDouble(8, t.getDonGia());
        pst.setInt(9, t.getSoLuongTon());
        pst.setString(10, t.getDonViTinh().getMaDonViTinh());
        pst.setString(11, t.getNhomHangHoa().getMaNhomHang());
        pst.setString(12, t.getChuongTrinhKhuyenMaiEntity().getMaCTKM());
        pst.setString(13, t.getQuyCachDongGoi());
        pst.setString(14, t.getThuongHieu().getMaThuongHieu());
        pst.setBoolean(15, t.isThuocKeDon());
        pst.setString(16, t.getNuocSanXuat().getMaNuoc());
        pst.setString(17, t.getTrangThai().toString());
        pst.setString(18, t.getMaThuoc());
        result = pst.executeUpdate();
        JDBCUtil.closeConnection(con);
    } catch (SQLException ex) {
        Logger.getLogger(ThuocDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return result > 0;
}

    @Override
    public ArrayList<Thuoc> kiemTraTonKho() {
        ArrayList<Thuoc> list = new ArrayList<>();
        try{
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM thuoc ORDER BY soLuongTon ASC";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Thuoc thuoc = new Thuoc();
                thuoc.setMaThuoc(rs.getString("maThuoc"));
                thuoc.setTenThuoc(rs.getString("tenThuoc"));
                thuoc.setHanSuDung(rs.getDate("hanSuDung"));
                thuoc.setKhoiLuong(rs.getDouble("khoiLuong"));
                thuoc.setHoatChatChinh(rs.getString("hoatChatChinh"));
                thuoc.setDuongDung(rs.getString("duongDung"));
                thuoc.setImgUrl(rs.getString("imgUrl"));
                thuoc.setDieuKienBaoQuan(rs.getString("dieuKienBaoQuan"));
                thuoc.setDonGia(rs.getDouble("donGia"));
                thuoc.setSoLuongTon(rs.getInt("soLuongTon"));
                thuoc.setDonViTinh(new DonViTinh(rs.getString("donViTinh")));
                thuoc.setNhomHangHoa(new NhomHangHoa(rs.getString("nhomHangHoa")));
                thuoc.setChuongTrinhKhuyenMaiEntity(new ChuongTrinhKhuyenMai(rs.getString("chuongTrinhKhuyenMai")));
                thuoc.setQuyCachDongGoi(rs.getString("quyCachDongGoi"));
                thuoc.setThuongHieu(new ThuongHieu(rs.getString("thuongHieu")));
                thuoc.setThuocKeDon(rs.getBoolean("thuocKeDon"));
                thuoc.setNuocSanXuat(new NuocSanXuat(rs.getString("nuocSanXuat")));
                TinhTrangSPEnum tinhTrangSPEnum = null;
                if (rs.getString("trangThai").equals("Đang bán")) {
                    tinhTrangSPEnum = TinhTrangSPEnum.DANGBAN;
                } else if (rs.getString("trangThai").equals("Ngừng bán")) {
                    tinhTrangSPEnum = TinhTrangSPEnum.NGUNGBAN;
                } else {
                    tinhTrangSPEnum = TinhTrangSPEnum.HETHANG;
                }
                thuoc.setTrangThai(tinhTrangSPEnum);
                list.add(thuoc);
            }
            JDBCUtil.closeConnection(con);

        }catch(SQLException ex){
            Logger.getLogger(ThuocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    @Override
    public ArrayList<Thuoc> kiemTraHetHan() {
        ArrayList<Thuoc> list = new ArrayList<>();
        try{
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM thuoc ORDER BY hanSuDung ASC";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Thuoc thuoc = new Thuoc();
                thuoc.setMaThuoc(rs.getString("maThuoc"));
                thuoc.setTenThuoc(rs.getString("tenThuoc"));
                thuoc.setHanSuDung(rs.getDate("hanSuDung"));
                thuoc.setKhoiLuong(rs.getDouble("khoiLuong"));
                thuoc.setHoatChatChinh(rs.getString("hoatChatChinh"));
                thuoc.setDuongDung(rs.getString("duongDung"));
                thuoc.setImgUrl(rs.getString("imgUrl"));
                thuoc.setDieuKienBaoQuan(rs.getString("dieuKienBaoQuan"));
                thuoc.setDonGia(rs.getDouble("donGia"));
                thuoc.setSoLuongTon(rs.getInt("soLuongTon"));
                thuoc.setDonViTinh(new DonViTinh(rs.getString("donViTinh")));
                thuoc.setNhomHangHoa(new NhomHangHoa(rs.getString("nhomHangHoa")));
                thuoc.setChuongTrinhKhuyenMaiEntity(new ChuongTrinhKhuyenMai(rs.getString("chuongTrinhKhuyenMai")));
                thuoc.setQuyCachDongGoi(rs.getString("quyCachDongGoi"));
                thuoc.setThuongHieu(new ThuongHieu(rs.getString("thuongHieu")));
                thuoc.setThuocKeDon(rs.getBoolean("thuocKeDon"));
                thuoc.setNuocSanXuat(new NuocSanXuat(rs.getString("nuocSanXuat")));
                TinhTrangSPEnum tinhTrangSPEnum = null;
                if (rs.getString("trangThai").equals("Đang bán")) {
                    tinhTrangSPEnum = TinhTrangSPEnum.DANGBAN;
                } else if (rs.getString("trangThai").equals("Ngừng bán")) {
                    tinhTrangSPEnum = TinhTrangSPEnum.NGUNGBAN;
                } else {
                    tinhTrangSPEnum = TinhTrangSPEnum.HETHANG;
                }
                thuoc.setTrangThai(tinhTrangSPEnum);
                list.add(thuoc);
            }
            JDBCUtil.closeConnection(con);

        }catch(SQLException ex){
            Logger.getLogger(ThuocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
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
        try{
            Connection con=(Connection) JDBCUtil.getConnection();
            String sql="UPDATE thuoc SET trangThai=? WHERE maThuoc=?";
            PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
            pst.setString(1,tinhTrangDangBan.toString());
            pst.setString(2,maSP);
            pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        }
        catch(SQLException ex){
            Logger.getLogger(ThuocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
public ArrayList<Thuoc> selectAll() {
    ArrayList<Thuoc> list = new ArrayList<>();
    try {
        Connection con = JDBCUtil.getConnection();
        String sql = "SELECT * FROM thuoc";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Thuoc thuoc = new Thuoc();
            thuoc.setMaThuoc(rs.getString("maThuoc"));
            thuoc.setTenThuoc(rs.getString("tenThuoc"));
            thuoc.setHanSuDung(rs.getDate("hanSuDung"));
            thuoc.setKhoiLuong(rs.getDouble("khoiLuong"));
            thuoc.setHoatChatChinh(rs.getString("hoatChatChinh"));
            thuoc.setDuongDung(rs.getString("duongDung"));
            thuoc.setImgUrl(rs.getString("imgUrl"));
            thuoc.setDieuKienBaoQuan(rs.getString("dieuKienBaoQuan"));
            thuoc.setDonGia(rs.getDouble("donGia"));
            thuoc.setSoLuongTon(rs.getInt("soLuongTon"));
            thuoc.setDonViTinh(new DonViTinh(rs.getString("donViTinh")));
            thuoc.setNhomHangHoa(new NhomHangHoa(rs.getString("nhomHangHoa")));
            thuoc.setChuongTrinhKhuyenMaiEntity(new ChuongTrinhKhuyenMai(rs.getString("chuongTrinhKhuyenMai")));
            thuoc.setQuyCachDongGoi(rs.getString("quyCachDongGoi"));
            thuoc.setThuongHieu(new ThuongHieu(rs.getString("thuongHieu")));
            thuoc.setThuocKeDon(rs.getBoolean("thuocKeDon"));
            thuoc.setNuocSanXuat(new NuocSanXuat(rs.getString("nuocSanXuat")));
            TinhTrangSPEnum tinhTrangSPEnum=null;
            if(rs.getString("trangThai").equals("Đang bán")) {
                tinhTrangSPEnum = TinhTrangSPEnum.DANGBAN;
            }else if(rs.getString("trangThai").equals("Ngừng bán")){
                tinhTrangSPEnum = TinhTrangSPEnum.NGUNGBAN;
            }
            else{
                tinhTrangSPEnum = TinhTrangSPEnum.HETHANG;
            }
            thuoc.setTrangThai(tinhTrangSPEnum);
            list.add(thuoc);
        }
        JDBCUtil.closeConnection(con);
    } catch (SQLException ex) {
        Logger.getLogger(ThuocDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
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
            thuocDTO.setQuyCachDongGoi(rs.getString("quyCachDongGoi"));
            thuocDTO.setThuongHieu(new ThuongHieu(rs.getString("thuongHieu")));
            thuocDTO.setThuocKeDon(rs.getBoolean("thuocKeDon"));
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
    public boolean updateQuantity(String maThuoc, int quantity) {
        int result = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE thuoc SET soLuongTon = soLuongTon + ? WHERE maThuoc = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, quantity);
            pst.setString(2, maThuoc);
            result = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(ThuocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result > 0;
    }
    @Override
    public String getAutoIncrement() {
        Random random = new Random();
        int number = random.nextInt(900000000) + 100000000; // This will always generate 6-digit numbers
        return "TH" + number;
    }
}
