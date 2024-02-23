
import DAO.*;
import DTO.*;
import config.JDBCUtil;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;


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
        //test selectById KhachHang
//        KhachHangDAO kh_dao= KhachHangDAO.getInstance();
//        KhachHangDTO kh= kh_dao.selectById("NV229401687");
//        System.out.println(kh);
//        test insert NhanVien
//        NhanVienDAO nv_dao= NhanVienDAO.getInstance();
//        NhanVienDTO nv= new NhanVienDTO(nv_dao.getAutoIncrement(),"PhiUpdate6",1,"0967312797", new Date(2023,Calendar.APRIL,12), TinhTrangNVEnum.NGHIPHEP,"hoansdfđs842@gmail.com",new Date(2023,Calendar.APRIL,3), CaLamViecEnum.CA2);
//        nv_dao.insert(nv);
        //test update NhanVien
//       NhanVienDAO nv_dao= NhanVienDAO.getInstance();
//        NhanVienDTO nv= new NhanVienDTO(3,"PhiUpdate3",1,"0967312797", new Date(2023,Calendar.APRIL,12), TinhTrangNVEnum.NGHIVIEC,"hoanngphi123@gmail.com",new Date(2023,Calendar.APRIL,3), CaLamViecEnum.CA2);
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
//        NhanVienDTO nv= nv_dao.selectById(Integer.toString(3));
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
//        NhaCungCapDTO ncc= new NhaCungCapDTO(ncc_dao.getAutoIncrement(),"Nha cung cap 8","75478","98424",0);
//        ncc_dao.insert(ncc);
        //Test update NhaCungCap
//        NhaCungCapDAO ncc_dao= NhaCungCapDAO.getInstance();
//        NhaCungCapDTO ncc= new NhaCungCapDTO("NCC201197835","Nha cung cap Update 1","1234","1234",1);
//        ncc_dao.update(ncc);

        //Test selectById NhaCungCap
//        NhaCungCapDAO ncc_dao= NhaCungCapDAO.getInstance();
//        NhaCungCapDTO ncc= ncc_dao.selectById("NCC201197835");
//        System.out.println(ncc);

    //Test getDSNhaCungCapDangNhap
//        NhaCungCapDAO ncc_dao= NhaCungCapDAO.getInstance();
//        ArrayList<NhaCungCapDTO> list= ncc_dao.getDSNCCDangNhap();
//        System.out.println(list);
    //Test insert Thuoc

        ThuocDAO thuoc_dao= ThuocDAO.getInstance();
        ThuocDTO thuoc= new ThuocDTO(thuoc_dao.getAutoIncrement(),"Thuoc 1",new Date(2023,Calendar.APRIL,12),"100",200,"imgUrl","200mg","imgUrl","NH1","Bảo quản nơi khô ráo, thoáng mát","KM996922589",100,"QCDG1","NSX1",100000,"Con");

    }
}