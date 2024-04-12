
import DAO.*;
import DTO.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {


    public static void main(String[] args) {
//        try {
//            Connection con = (Connection) JDBCUtil.getConnection();
//            System.out.println("Kết nối thành công");
//            JDBCUtil.closeConnection(con);
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Kết nối thất bại");
//        }

        //Test selectById NhomKhachHang
//        NhomKhachHangDAO nhom_dao= NhomKhachHangDAO.getInstance();
//        NhomKhachHangDTO nhom1= nhom_dao.selectById("1");
//        System.out.println(nhom);
        //Test selectAll NhomKhachHang
//        Test create KhachHang
//        KhachHangDAO kh_dao= KhachHangDAO.getInstance();
//        KhachHangDTO kh= new KhachHangDTO(kh_dao.getAutoIncrement(),"Phi","1234","1234",nhom1);
//        kh_dao.insert(kh);

        //Test update KhachHang
//        KhachHangDAO kh_dao= KhachHangDAO.getInstance();
//        KhachHangDTO kh= new KhachHangDTO("NV229401687","PhiUpdate","1234","1234",nhom1);
//        kh_dao.update(kh);
        //Test delete KhachHang
//        kh_dao= KhachHangDAO.getInstance();
//        kh_dao.delete(Integer.toString(1));
        //Test selectALl KhachHang
//       KhachHangDAO kh_dao= KhachHangDAO.getInstance();
//         ArrayList<KhachHangDTO> list= kh_dao.selectAll();
//         System.out.println(list);

        //Test timKiemTheo Sdt
//        KhachHangDAO kh_dao= KhachHangDAO.getInstance();
//        KhachHang kh= kh_dao.timKiemTheoSDT("1234");
//        System.out.println(kh);
//        test selectById KhachHang
//        KhachHangDAO kh_dao= KhachHangDAO.getInstance();
//        KhachHangDTO kh= kh_dao.selectById("NV839306001");
//        System.out.println(kh);
//        test insert NhanVien
//        NhanVienDAO nv_dao= NhanVienDAO.getInstance();
//        NhanVienDTO nv= new NhanVienDTO(nv_dao.getAutoIncrement(),"PhiUpdate6",1,"0967312797", new Date(2023,Calendar.APRIL,12), TinhTrangNVEnum.NGHIPHEP,"hoansdfđs842@gmail.com",new Date(2023,Calendar.APRIL,3), CaLamViecEnum.CA2);
//        nv_dao.insert(nv);
        //test update NhanVien
//       NhanVienDAO nv_dao= NhanVienDAO.getInstance();
//        NhanVienDTO nv= new NhanVienDTO("NV628212743","PhiUpdate","tphcm",1,"0967312797", new Date(2023,Calendar.APRIL,12), TinhTrangNVEnum.NGHIPHEP,ChucVuEnum.QUANLY,"hoansdfđ",new Date(2023,Calendar.APRIL,3), CaLamViecEnum.CA2);
//        nv_dao.update(nv);
        //test delete NhanVien
//        NhanVienDAO nv_dao= NhanVienDAO.getInstance();
//        nv_dao.delete(Integer.toString(2));
        //test selectAll NhanVien
//        NhanVienDAO nv_dao= NhanVienDAO.getInstance();
//        ArrayList<NhanVienDTO> list= nv_dao.selectAll();
//        System.out.println(list);
        //test selectById NhanVien
//       NhanVienDAO nv_dao= NhanVienDAO.getInstance();
//        NhanVienDTO nv= nv_dao.findBySDT("0967312797");
//        System.out.println(nv);
    //test insert KhuyenMai
//        KhuyenMaiDAO km_dao= KhuyenMaiDAO.getInstance();
//        KhuyenMaiDTO km= new KhuyenMaiDTO(km_dao.getAutoIncrement(),"Mung tet truyen thong","10","GGDC",new Date(2023,Calendar.APRIL,12),new Date(2023,Calendar.APRIL,12),"Con",100000,1000000);
//        km_dao.insert(km);
        //test selectById KhuyenMai
//        KhuyenMaiDAO km_dao= KhuyenMaiDAO.getInstance();
//        KhuyenMaiDTO km= km_dao.selectById("KM996922589");
//        System.out.println(km);

//

//        Test add NhaCungCap
//        NhaCungCapDAO ncc_dao= NhaCungCapDAO.getInstance();
//        NhaCungCap ncc= new NhaCungCap(ncc_dao.getAutoIncrement(),"Nha cung cap 8","75478","98424",0);
//        ncc_dao.insert(ncc);
        //Test update NhaCungCap
//        NhaCungCapDAO ncc_dao= NhaCungCapDAO.getInstance();
//        NhaCungCapDTO ncc= new NhaCungCapDTO("NCC201197835","Nha cung cap Update 1","1234","1234",1);
//        ncc_dao.update(ncc);

        //Test selectById NhaCungCap
//        NhaCungCapDAO ncc_dao= NhaCungCapDAO.getInstance();
//        NhaCungCap ncc= ncc_dao.selectById("NCC626751936");
//        System.out.println(ncc);

    //Test getDSNhaCungCapDangNhap
//        NhaCungCapDAO ncc_dao= NhaCungCapDAO.getInstance();
//        ArrayList<NhaCungCapDTO> list= ncc_dao.getDSNCCDangNhap();
//        System.out.println(list);
    //Test insert Thuoc
//        DonViTinhDAO donvitinh_dao= DonViTinhDAO.getInstance();
//        DonViTinh donvitinh1= donvitinh_dao.selectDonViTinh("DVT1");
//        System.out.println(donvitinh1);

//        NhomHangHoaDAO nhomhanghoa_dao= NhomHangHoaDAO.getInstance();
//        NhomHangHoa nhomhanghoa1= nhomhanghoa_dao.selectNhomHangHoa("NH1");
//        System.out.println(nhomhanghoa1);

//        QuyCachDongGoiDAO quycachdonggoi_dao= QuyCachDongGoiDAO.getInstance();
//        QuyCachDongGoi quycachdonggoi1= quycachdonggoi_dao.selectQuyCachDongGoi("QCDG1");
//        System.out.println(quycachdonggoi1);

//        NuocSanXuatDAO nuocsanxuat_dao= NuocSanXuatDAO.getInstance();
//        NuocSanXuat nuocsanxuat1= nuocsanxuat_dao.selectNuocSanXuat("NSX1");
//        System.out.println(nuocsanxuat1);
//        ChuongTrinhKhuyenMaiDAO ctkm_dao= ChuongTrinhKhuyenMaiDAO.getInstance();
//        ChuongTrinhKhuyenMai ctkm= ctkm_dao.selectById("KM750234717");
//
//        ThuocDAO thuoc_dao= ThuocDAO.getInstance();
//        ThuocDTO thuoc= new ThuocDTO(thuoc_dao.getAutoIncrement(),"Thuoc cam",new Date(2023,Calendar.APRIL,12),"Paracetamol",100,"imgUrl","Uong",donvitinh1,nhomhanghoa1,ctkm,quycachdonggoi1,nuocsanxuat1,100000,100,"Bao quan o noi kho rao mat", TinhTrangSPEnum.DANGBAN);
//        thuoc_dao.insert(thuoc);

        //test selectById Thuoc
//        ThuocDAO thuoc_dao= ThuocDAO.getInstance();
//        Thuoc thuoc= thuoc_dao.timSanPham("TH623623627");
//        System.out.println(thuoc);

        //Test insert ChuongTrinhKhuyenMai
//        ChuongTrinhKhuyenMaiDAO ctkm_dao= ChuongTrinhKhuyenMaiDAO.getInstance();
//        Calendar ngayBatDauCalendar = Calendar.getInstance();
//        ngayBatDauCalendar.set(2022, Calendar.APRIL, 12);
//
//        Calendar ngayKetThucCalendar = Calendar.getInstance();
//        ngayKetThucCalendar.set(2023, Calendar.APRIL, 12);

        //test kiemTraKhuyenMai
//        ChuongTrinhKhuyenMaiDAO ctkm_dao= ChuongTrinhKhuyenMaiDAO.getInstance();
//        ChuongTrinhKhuyenMai ctkm=ctkm_dao.kiemTraKhuyenMai(120000);
//        System.out.println(ctkm);


        // Chuyển đối tượng Calendar sang java.sql.Date
//        Date ngayBatDau = new Date(ngayBatDauCalendar.getTimeInMillis());
//        Date ngayKetThuc = new Date(ngayKetThucCalendar.getTimeInMillis());
//        ChuongTrinhKhuyenMai ctkm= new ChuongTrinhKhuyenMai(ctkm_dao.getAutoIncrement(),new LoaiKhuyenMai("GGHD"),"Mung Le Nha Giao",100000,1000000,10,ngayBatDau,ngayKetThuc,1);
//        ctkm_dao.insert(ctkm);

//        test selectById ChuongTrinhKhuyenMai
//        ChuongTrinhKhuyenMaiDAO ctkm_dao= ChuongTrinhKhuyenMaiDAO.getInstance();
//        ChuongTrinhKhuyenMai ctkm= ctkm_dao.selectById("KM165214484");

    // Test insert hoaDon,luutamhoadon
//       NhanVienDAO nv_dao= NhanVienDAO.getInstance();
//         NhanVienDTO nv= nv_dao.selectById("NV628212743");
//        KhachHangDAO kh_dao= KhachHangDAO.getInstance();
//        KhachHangDTO kh= kh_dao.selectById("NV839306001");
//        HoaDonDAO hd_dao= HoaDonDAO.getInstance();
//        HoaDon hd= new HoaDon(hd_dao.getAutoIncrement(),new Date(2023,Calendar.APRIL,12),kh,nv,ctkm,100000,1000000,1000000,1);
//        ArrayList<ChiTietHoaDon> danhSachCTHD= new ArrayList<>();
//        //select thuoc
//        ThuocDAO thuoc_dao= ThuocDAO.getInstance();
//        Thuoc thuoc= thuoc_dao.selectById("TH623623627");
//Test themHoaDonLuuTam
//        HoaDonDAO hd_dao= HoaDonDAO.getInstance();
//        HoaDon hd= hd_dao.getHoaDonTheoMaHD("HD466187718");
//
//        ChiTietHoaDon cthd1= new ChiTietHoaDon(thuoc,hd,5,200000,400000,800000);
//        danhSachCTHD.add(cthd1);
//        hd_dao.luuTamHoaDon(hd,danhSachCTHD);
//        hd_dao.themHoaDonLuuTam(hd,danhSachCTHD);

        //Test insert PhieuNhap
//        PhieuNhapDAO pn_dao= PhieuNhapDAO.getInstance();
//        Calendar ngayNhapCalendar = Calendar.getInstance();
//        ngayNhapCalendar.set(2025, Calendar.APRIL, 18);
//        Date ngayNhap = new Date(ngayNhapCalendar.getTimeInMillis());
//        PhieuNhap pn= new PhieuNhap(pn_dao.getAutoIncrement(),ncc,thuoc,100,ngayNhap);
//        pn_dao.insert(pn);

        //selectAll PhieuNhap
//        PhieuNhapDAO pn_dao= PhieuNhapDAO.getInstance();
//        ArrayList<PhieuNhap> list= pn_dao.selectAll();
//        System.out.println(list);

        //TimKiem PhieuNhap
//        PhieuNhapDAO pn_dao= PhieuNhapDAO.getInstance();
//        Calendar ngayNhapCalendar = Calendar.getInstance();
//        ngayNhapCalendar.set(2025, Calendar.APRIL, 18);
//        Date ngayNhap = new Date(ngayNhapCalendar.getTimeInMillis());
//        ArrayList<PhieuNhap> list= pn_dao.timKiemMHN(ngayNhap);
//        System.out.println(list);

        //Test capNhatsoluong thuoc
//        ThuocDAO thuoc_dao= ThuocDAO.getInstance();
//        thuoc_dao.capNhatSoLuong("TH623623627",100);

        //get so luong ton
//       ThuocDAO thuoc_dao= ThuocDAO.getInstance();
//        int soLuong= thuoc_dao.laySoLuongTonKhoTheoMaSP("TH623623627");
//        System.out.println(soLuong);

        //getTK
//        TaiKhoanDAO tk_dao= TaiKhoanDAO.getInstance();
//        TaiKhoan tk= tk_dao.getTK("012345","123");
//        System.out.println(tk);

        //getAllHoaDonChuaThanhToan
//        HoaDonDAO hd_dao= HoaDonDAO.getInstance();
//        ArrayList<HoaDon> list= hd_dao.getAllHDChuaThanhToan();
//        System.out.println(list);
        //TimKiemHoaDonChuaThanhToan
//       HoaDonDAO hd_dao= HoaDonDAO.getInstance();
//        ArrayList<HoaDon> list= hd_dao.timKiemHoaDonChuaThanhToan("12344");
//        System.out.println(list);


    //getAllCTHDTheoMaHD
//        ChiTietHoaDonDAO cthd_dao= ChiTietHoaDonDAO.getInstance();
//        ArrayList<ChiTietHoaDon> list= cthd_dao.getAllCTHDTheoMaHD("HD320441756");
//        System.out.println(list);

        //TaoDoiTra
//        DoiTraDAO dt_dao= DoiTraDAO.getInstance();
//        HoaDonDAO hd_dao= HoaDonDAO.getInstance();
//        HoaDon hd= hd_dao.getHoaDonTheoMaHD("HD575625097");
//        NhanVienDAO nv_dao= NhanVienDAO.getInstance();
//        NhanVien nv= nv_dao.selectById("NV2345");
//        DoiTra dt= new DoiTra(dt_dao.getAutoIncrement(),hd,nv,HinhThucDoiTraEnum.DOIMOI,"Khong hop",new Date(2023,Calendar.APRIL,12),100000);
//        ArrayList<ChiTietDoiTra> danhSachCTDT= new ArrayList<>();
////select thuoc
//        ThuocDAO thuoc_dao= ThuocDAO.getInstance();
//        Thuoc thuoc= thuoc_dao.selectById("TH623623627");
//        ChiTietDoiTra ctdt1= new ChiTietDoiTra(thuoc,dt,5,200000,400000);
//        danhSachCTDT.add(ctdt1);
//        dt_dao.taoDoiTra(dt,danhSachCTDT);

        //getAllDoiTra

        //KiemTraHanDoiTra
//       DoiTraDAO dt_dao= DoiTraDAO.getInstance();
//        boolean kq=dt_dao.kiemTraThoiHanDoiTra("HD575625097");
//        System.out.println(kq);


        //getDoiTraTheoMa
//     DoiTraDAO dt_dao= DoiTraDAO.getInstance();
//     DoiTra dt= dt_dao.getDoiTraTheoMa("DT833810271");
//        System.out.println(dt);

        //getAllCTDTTheoMaDT
//        ChiTietDoiTraDAO ctdt_dao=new ChiTietDoiTraDAO();
//        ArrayList<ChiTietDoiTra> list=ctdt_dao.getAllCTDTTheoMaDT("DT448382357");
//        System.out.println(list);

        //findOneTK
//        TaiKhoanDAO tk_dao= TaiKhoanDAO.getInstance();
//        TaiKhoan tk= tk_dao.findOne("012345");
//        System.out.println(tk);

        //TimThuoc
       ThuocDAO thuoc_dao= ThuocDAO.getInstance();
        Thuoc list= thuoc_dao.timSanPham("TH1223208187");
        System.out.println(list);
    }
}