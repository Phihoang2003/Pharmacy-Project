
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
        NhomKhachHangDAO nhom_dao= NhomKhachHangDAO.getInstance();
        NhomKhachHangDTO nhom1= nhom_dao.selectById("1");
//        System.out.println(nhom);
        //Test selectAll NhomKhachHang
//        Test create KhachHang
        KhachHangDAO kh_dao= KhachHangDAO.getInstance();
        KhachHangDTO kh= new KhachHangDTO(kh_dao.getAutoIncrement(),"Phi","1234","1234",nhom1);
        kh_dao.insert(kh);

        //Test update KhachHang
//        kh_dao= KhachHangDAO.getInstance();
//        KhachHangDTO kh= new KhachHangDTO(1,"PhiUpdate","1234","1234",1);
//        kh_dao.update(kh);
        //Test delete KhachHang
//        kh_dao= KhachHangDAO.getInstance();
//        kh_dao.delete(Integer.toString(1));
        //Test selectALl KhachHang
//       kh_dao= KhachHangDAO.getInstance();
//         ArrayList<KhachHangDTO> list= kh_dao.selectAll();
//         System.out.println(list);
        //test selectById KhachHang
//        kh_dao= KhachHangDAO.getInstance();
//        KhachHangDTO kh= kh_dao.selectById(Integer.toString(3));
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
        //test insert Thuoc
//        ThuocDAO t_dao= ThuocDAO.getInstance();
//        ThuocDTO t= new ThuocDTO(t_dao.getAutoIncrement(),"Thuoc 2",new Date(2023,Calendar.APRIL,12),"Ghi chu 2","Hoat chat chinh 2",2,2,"Dieu kien bao quan",2,2,"Con");
//        t_dao.insert(t);

//        test selectById Thuoc
//       ThuocDAO t_dao= ThuocDAO.getInstance();
//        ThuocDTO t= t_dao.selectById("TH686738384");
//        System.out.println(t);
//        test insert PhienBanTHuoc
//       PhienBanThuocDAO pbt_dao= PhienBanThuocDAO.getInstance();
//       PhienBanThuocDTO pbt= new PhienBanThuocDTO(pbt_dao.getAutoIncrement(),t,"Bot", "700ml","imgUrl","Pha","Quy cach dong goi",500000,500000,200,"Canada");
//       pbt_dao.insert(pbt);
//    select all PhienBanThuoc
//       PhienBanThuocDAO pbt_dao= PhienBanThuocDAO.getInstance();
//         ArrayList<PhienBanThuocDTO> list= pbt_dao.selectAllPhienBan("TH686738384");
//         System.out.println(list);
    }
}