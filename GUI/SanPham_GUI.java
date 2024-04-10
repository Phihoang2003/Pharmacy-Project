
package GUI;
import BUS.*;
import DTO.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.io.*;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author USER
 */
public class SanPham_GUI extends JPanel {
    private String duongDanAnhMacDinh = "src//icon//labelAnh.png";
    private String duongDanAnh = null;
    private SanPham_bus sp_bus;
    private ThuongHieu_bus th_bus;
    private NuocSanXuat_bus nsx_bus;
    private DonViTinh_bus dvt_bus;
    private NhomHangHoa_bus nhh_bus;
    private ChuongTrinhKhuyenMai_bus ctkm_bus;
    private DefaultTableModel model;


    /**
     * Creates new form SanPham_GUI
     */
    public SanPham_GUI() {

        sp_bus = new SanPham_bus();
        th_bus = new ThuongHieu_bus();
        nsx_bus = new NuocSanXuat_bus();
        dvt_bus = new DonViTinh_bus();
        nhh_bus = new NhomHangHoa_bus();
        ctkm_bus = new ChuongTrinhKhuyenMai_bus();
        initComponents();
        ImageIcon img_btnTimKiem1 = new ImageIcon("D:\\TrenLop\\PTUD\\Phamarcy_Project\\src\\icon\\buttonTimKiem.png");
        Image scaled_btnTimKiem1 = img_btnTimKiem1.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnTimKiem1 = new ImageIcon(scaled_btnTimKiem1);
        btn_TimKiem.setIcon(img_btnTimKiem1);
        ImageIcon img_lblAnh = new ImageIcon("src//icon//labelAnh.png");
        Image scaled_lblAnh = img_lblAnh.getImage().getScaledInstance(150, 140, Image.SCALE_SMOOTH);
        img_lblAnh = new ImageIcon(scaled_lblAnh);
        lbl_anhSanPham.setIcon(img_lblAnh);
        ImageIcon img_btnTimKiem = new ImageIcon("D:\\TrenLop\\PTUD\\Phamarcy_Project\\src\\icon\\buttonChonAnh.png");
        Image scaled_btnTimKiem = img_btnTimKiem.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnTimKiem = new ImageIcon(scaled_btnTimKiem);
        btn_chonAnh.setIcon(img_btnTimKiem);
        Object[][] data={};
        String[] columnNames={"Mã Thuốc", "Tên Thuốc","Nước sản xuất", "Số Lượng Tồn","Đơn giá", "Nhóm Thuốc","Đơn vị tính", "Hạn sử dụng", "Hoạt chất chính", "Thương hiệu","Khuyến mãi","Tình trạng","Khối lượng","Đường dùng","Quy cách đóng gói","Điều kiện bảo quản","Thuốc kê đơn","Ảnh"};
        model=new DefaultTableModel(data, columnNames){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ThemSanPhamDialog.setVisible(true);
            }
        });
        model=(DefaultTableModel) table_thuoc.getModel();
        table_thuoc.setModel(model);
        loadDuLieuTuDataLenTable();
        duaDuLieuVaoComboBox(cbo_thuongHieu, th_bus.getAllTH(), "TenThuongHieu");
        duaDuLieuVaoComboBox(cbo_NSX, nsx_bus.getAllNSX(), "TenNuoc");
        duaDuLieuVaoComboBox(cbo_DVT, dvt_bus.getAllDVT(), "TenDonViTinh");
        duaDuLieuVaoComboBox(cbo_nhomThuoc, nhh_bus.getAllNT(), "TenNhomHang");
        duaDuLieuVaoComboBox(cbo_ctkm, ctkm_bus.getAllCTKMTheoLoaiKMVaTinhTrang("GGSP", 1), "TenCTKM");

        duaDuLieuVaoComboBox(cbo_thuongHieu1, th_bus.getAllTH(), "TenThuongHieu");
        duaDuLieuVaoComboBox(cbo_NSX1, nsx_bus.getAllNSX(), "TenNuoc");
        duaDuLieuVaoComboBox(cbo_DVT1, dvt_bus.getAllDVT(), "TenDonViTinh");
        duaDuLieuVaoComboBox(cbo_nhomThuoc1, nhh_bus.getAllNT(), "TenNhomHang");
        duaDuLieuVaoComboBox(cbo_ctkm1, ctkm_bus.getAllCTKMTheoLoaiKMVaTinhTrang("GGSP", 1), "TenCTKM");
        cbo_ctkm.addItem("Không giảm giá");
        cbo_ctkm.setSelectedItem("Không giảm giá");


    }
    private ImageIcon ResizeImageIcon(String ImagePath) {
        ImageIcon myIcon = new ImageIcon(ImagePath);
        Image img = myIcon.getImage().getScaledInstance(lbl_anhSanPham.getWidth(), lbl_anhSanPham.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img);
        return image;
    }
    private ImageIcon ResizeImageIcon1(String ImagePath) {
        ImageIcon myIcon = new ImageIcon(ImagePath);
        Image img = myIcon.getImage().getScaledInstance(lbl_anhSanPham1.getWidth(), lbl_anhSanPham1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img);
        return image;
    }
    private void themSanPham(){

        if(validata()){
            String maThuoc=sp_bus.getAutoIncrement();
            String tenThuoc=txt_ten.getText();
            double donGia=Double.parseDouble(txt_donGia.getText());
            int soLuong=Integer.parseInt(txt_soLuong.getText());
            String hoatChat=txt_hoatChat.getText();
            boolean thuocKeDon= cbo_thuocKeDon.getSelectedItem().equals("Có Kê Đơn");
            String quyCachDongGoi=txt_quyCachDongGoi.getText();
            double khoiLuong=Double.parseDouble(txt_khoiLuong.getText());
            String dieuKienBaoQuan=txt_dieuKienBaoQuan.getText();
            String duongDung=txt_duongDung.getText();
            Date hanSuDung=jdc_NgayNhap.getDate();
            TinhTrangSPEnum tinhTrang = null;
            if (cbo_tinhTrang.getSelectedItem().equals("Đang bán")) {
                tinhTrang = TinhTrangSPEnum.DANGBAN;
            } else if (cbo_tinhTrang.getSelectedItem().equals("Ngừng bán")) {
                tinhTrang = TinhTrangSPEnum.NGUNGBAN;
            } else if (cbo_tinhTrang.getSelectedItem().equals("Hết hàng")) {
                tinhTrang = TinhTrangSPEnum.HETHANG;
            }
            if (soLuong > 0) {
                tinhTrang = TinhTrangSPEnum.DANGBAN;
            } else {
                tinhTrang = TinhTrangSPEnum.HETHANG;
            }
            String tenNSX=cbo_NSX.getSelectedItem().toString();
            String tenDVT=cbo_DVT.getSelectedItem().toString();
            String tenNhomThuoc=cbo_nhomThuoc.getSelectedItem().toString();
            String tenTH=cbo_thuongHieu.getSelectedItem().toString();
            String tenCTKM=cbo_ctkm.getSelectedItem().toString();

            String maNSX=nsx_bus.layMaNSXTheoTen(tenNSX);
            NuocSanXuat nsx=new NuocSanXuat(maNSX);
            String maDVT=dvt_bus.layMaDVTTheoTen(tenDVT);
            DonViTinh dvt=new DonViTinh(maDVT);
            String maNhomThuoc=nhh_bus.layMaNhomThuocTheoTen(tenNhomThuoc);
            NhomHangHoa nhh=new NhomHangHoa(maNhomThuoc);
            String maTH=th_bus.layMaThuongHieuTheoTen(tenTH);
            ThuongHieu th=new ThuongHieu(maTH);
            String maCTKM=ctkm_bus.layMaKhuyenMaiTheoTen(tenCTKM);
            ChuongTrinhKhuyenMai ctkm=new ChuongTrinhKhuyenMai(maCTKM);
            String anh = duongDanAnh;
            if (anh == null || anh.equals(duongDanAnhMacDinh)) {
                JOptionPane.showMessageDialog(ThemSanPhamDialog, "Vui lòng chọn ảnh");
            } else {
                Thuoc thuoc=new Thuoc(maThuoc, tenThuoc, thuocKeDon, th,hanSuDung,hoatChat,khoiLuong,anh,duongDung,dvt,nhh,ctkm,quyCachDongGoi,nsx,donGia,soLuong,dieuKienBaoQuan,tinhTrang);
                boolean kiemtra=sp_bus.insert(thuoc);
                if(kiemtra){
                    DecimalFormat decimalFormat = new DecimalFormat();
                    String formattedDonGia = decimalFormat.format(thuoc.getDonGia()) + " VNĐ";
                    String Nsx = nsx_bus.layTenNSXTheoMa(thuoc.getNuocSanXuat().getMaNuoc());
                    String Th = th_bus.layTenThuongHieuTheoMa(thuoc.getThuongHieu().getMaThuongHieu());
                    String Nhh = nhh_bus.layTenNhomThuocTheoMa(thuoc.getNhomHangHoa().getMaNhomHang());
                    String Dvt = dvt_bus.layTenDVTTheoMa(thuoc.getDonViTinh().getMaDonViTinh());
                    String km = ctkm_bus.layTenKhuyenMaiTheoMa(thuoc.getChuongTrinhKhuyenMaiEntity().getMaCTKM());
                    String hienThiKM = null;
                    if (km != null) {
                        hienThiKM = km;
                    } else {
                        hienThiKM = "Không giảm giá";
                    }
                    model.addRow(new Object[]{thuoc.getMaThuoc(), thuoc.getTenThuoc(), Nsx,
                            thuoc.getSoLuongTon(), formattedDonGia, Nhh,
                            Dvt, thuoc.getHanSuDung(), thuoc.getHoatChatChinh(), Th,
                            hienThiKM, thuoc.getTrangThai(),thuoc.getKhoiLuong(),thuoc.getDuongDung(),thuoc.getQuyCachDongGoi(),thuoc.getDieuKienBaoQuan(),thuoc.isThuocKeDon(),thuoc.getImgUrl()});
                    JOptionPane.showMessageDialog(ThemSanPhamDialog, "Thêm thành công");
                    ThemSanPhamDialog.dispose();
                    lamMoi();

                }else{
                    JOptionPane.showMessageDialog(ThemSanPhamDialog, "Thêm thất bại");
                }
            }
        }
    }

    private void capNhatSanPham() {
        if (validata1()) {

                String maSP = txt_ma1.getText();
                String tenThuoc = txt_ten1.getText();
                double donGia = Double.parseDouble(txt_donGia1.getText());
                int soLuong = Integer.parseInt(txt_soLuong1.getText());
                String hoatChat = txt_hoatChat1.getText();
                boolean thuocKeDon = cbo_thuocKeDon1.getSelectedItem().equals("Có Kê Đơn");
                String quyCachDongGoi = txt_quyCachDongGoi1.getText();
                double khoiLuong = Double.parseDouble(txt_khoiLuong1.getText());
                String dieuKienBaoQuan = txt_dieuKienBaoQuan1.getText();
                String duongDung = txt_duongDung1.getText();
                Date hanSuDung = jdc_NgayNhap1.getDate();
                TinhTrangSPEnum tinhTrang = null;
                if (cbo_tinhTrang1.getSelectedItem().equals("Đang bán")) {
                    tinhTrang = TinhTrangSPEnum.DANGBAN;
                } else if (cbo_tinhTrang1.getSelectedItem().equals("Ngừng bán")) {
                    tinhTrang = TinhTrangSPEnum.NGUNGBAN;
                } else if (cbo_tinhTrang1.getSelectedItem().equals("Hết hàng")) {
                    tinhTrang = TinhTrangSPEnum.HETHANG;
                }
                if (soLuong > 0) {
                    tinhTrang = TinhTrangSPEnum.DANGBAN;
                } else {
                    tinhTrang = TinhTrangSPEnum.HETHANG;
                }
                String tenNSX = cbo_NSX1.getSelectedItem().toString();
                String tenDVT = cbo_DVT1.getSelectedItem().toString();
                String tenNhomThuoc = cbo_nhomThuoc1.getSelectedItem().toString();
                String tenTH = cbo_thuongHieu1.getSelectedItem().toString();
                String tenCTKM = cbo_ctkm1.getSelectedItem().toString();

                String maNSX = nsx_bus.layMaNSXTheoTen(tenNSX);
                NuocSanXuat nsx = new NuocSanXuat(maNSX);
                String maDVT = dvt_bus.layMaDVTTheoTen(tenDVT);
                DonViTinh dvt = new DonViTinh(maDVT);
                String maNhomThuoc = nhh_bus.layMaNhomThuocTheoTen(tenNhomThuoc);
                NhomHangHoa nhh = new NhomHangHoa(maNhomThuoc);
                String maTH = th_bus.layMaThuongHieuTheoTen(tenTH);
                ThuongHieu th = new ThuongHieu(maTH);
                String maCTKM = ctkm_bus.layMaKhuyenMaiTheoTen(tenCTKM);
                ChuongTrinhKhuyenMai ctkm = new ChuongTrinhKhuyenMai(maCTKM);
                String anh = lbl_anhSanPham1.getText();
//                        System.out.println(anh);
                Thuoc thuoc = new Thuoc(maSP, tenThuoc, thuocKeDon, th, hanSuDung, hoatChat, khoiLuong, anh, duongDung, dvt, nhh, ctkm, quyCachDongGoi, nsx, donGia, soLuong, dieuKienBaoQuan, tinhTrang);
                boolean kq = sp_bus.update(thuoc);
                if (kq) {
                    JOptionPane.showMessageDialog(CapNhatSanPhamDialog, "Cập nhật thành công");
                    CapNhatSanPhamDialog.dispose();
                    lamMoi();
                } else {
                    JOptionPane.showMessageDialog(CapNhatSanPhamDialog, "Cập nhật không thành công");
                    CapNhatSanPhamDialog.dispose();
                }
        }
    }




    private void loadDuLieuTuDataLenTable() {
        sp_bus.capNhatKhuyenMai();
        ArrayList<Thuoc> dsSanPham = sp_bus.selectAll();
        DecimalFormat decimalFormat = new DecimalFormat();
        for (Thuoc th : dsSanPham) {

            String formattedDonGia = decimalFormat.format(th.getDonGia()) + " VNĐ";
            String tenDVT = dvt_bus.layTenDVTTheoMa(th.getDonViTinh().getMaDonViTinh());
            String tenThuongHieu = th_bus.layTenThuongHieuTheoMa(th.getThuongHieu().getMaThuongHieu());
            String tenNSX = nsx_bus.layTenNSXTheoMa(th.getNuocSanXuat().getMaNuoc());
            String tenNhomThuoc=nhh_bus.layTenNhomThuocTheoMa(th.getNhomHangHoa().getMaNhomHang());
            String tenCTKM = ctkm_bus.layTenKhuyenMaiTheoMa(th.getChuongTrinhKhuyenMaiEntity().getMaCTKM());
            String hienThiKM = null;
            if (tenCTKM != null) {
                hienThiKM = tenCTKM;
            } else {
                hienThiKM = "Không giảm giá";
            }

            model.addRow(new Object[]{th.getMaThuoc(), th.getTenThuoc(), tenNSX,
                    th.getSoLuongTon(), formattedDonGia,tenNhomThuoc,
                    tenDVT, th.getHanSuDung(), th.getHoatChatChinh(), tenThuongHieu,
                    hienThiKM, th.getTrangThai(),th.getKhoiLuong(),th.getDuongDung(),th.getQuyCachDongGoi(),th.getDieuKienBaoQuan(),th.isThuocKeDon(),th.getImgUrl()});


        }
    }
    public void lamMoi() {
        txt_ma.setText("");
        txt_ten.setText("");
        cbo_DVT.setSelectedIndex(0);
        txt_donGia.setText("");
        txt_soLuong.setText("0");
        cbo_NSX.setSelectedIndex(0);
        cbo_nhomThuoc.setSelectedIndex(0);
        cbo_thuongHieu.setSelectedIndex(0);
        cbo_thuocKeDon.setSelectedIndex(0);
        cbo_tinhTrang.setSelectedItem("Hết hàng");
        txt_hoatChat.setText("");
        txt_quyCachDongGoi.setText("");
        txt_khoiLuong.setText("");
        txt_dieuKienBaoQuan.setText("");
        txt_duongDung.setText("");
        jdc_NgayNhap.setDate(new Date());

        txt_tim.setText("");
        cbo_ctkm.removeAllItems();
        duaDuLieuVaoComboBox(cbo_ctkm, ctkm_bus.getAllCTKMTheoLoaiKMVaTinhTrang("GGSP", 1), "TenCTKM");
        cbo_ctkm.addItem("Không giảm giá");
        cbo_ctkm.setSelectedItem("Không giảm giá");
        model.setRowCount(0);
        if(lbl_anhSanPham.getWidth()>0 && lbl_anhSanPham.getHeight()>0){
            ImageIcon anhMacDinh = new ImageIcon(duongDanAnhMacDinh);
            ImageIcon imageIcon = new ImageIcon(anhMacDinh.getImage().getScaledInstance(lbl_anhSanPham.getWidth(), lbl_anhSanPham.getHeight(), Image.SCALE_SMOOTH));
            lbl_anhSanPham.setIcon(imageIcon);
            duongDanAnh = null;
            lbl_anhSanPham.setText("");
        }

        ArrayList<Thuoc> dsSP = sp_bus.selectAll();
        for (Thuoc sp : dsSP) {
            if (sp.getSoLuongTon() > 0 && sp.getTrangThai() == TinhTrangSPEnum.HETHANG) {
                sp_bus.capNhatTinhTrang(sp.getMaThuoc(), TinhTrangSPEnum.DANGBAN);
            }
            if (sp.getSoLuongTon() == 0 && sp.getTrangThai() == TinhTrangSPEnum.DANGBAN) {
                {
                    sp_bus.capNhatTinhTrang(sp.getMaThuoc(), TinhTrangSPEnum.HETHANG);
                }
            }
        }
        loadDuLieuTuDataLenTable();
    }
    private void duaDuLieuVaoComboBox(JComboBox comboBox, ArrayList<?> data, String thuocTinh) {
        DefaultComboBoxModel<Object> model = new DefaultComboBoxModel<>();
        for (Object item : data) {
            try {
                Object propertyValue = item.getClass().getMethod("get" + thuocTinh).invoke(item);
                model.addElement(propertyValue);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        comboBox.setModel(model);
    }
    private boolean validata() {
        String tenSP = txt_ten.getText().trim();
        String donGia = txt_donGia.getText().trim();
        if (tenSP.isBlank() || donGia.isBlank()) {

            JOptionPane.showMessageDialog(ThemSanPhamDialog, "Không được để trống");
            return false;
        }
        if(!tenSP.matches("^(\\p{L}{1}\\p{L}*\\s)*(\\p{L}{1}\\p{L}*)$")){
            JOptionPane.showMessageDialog(ThemSanPhamDialog, "Tên sản phẩm không được nhập số");
            txt_ten.requestFocus();
            txt_ten.selectAll();
            return false;
        }
        if (!donGia.matches("^[1-9]\\d*")) {
            JOptionPane.showMessageDialog(ThemSanPhamDialog, "Đơn giá phải lớn hơn 0, không được nhập chữ");
            txt_donGia.requestFocus();
            txt_donGia.selectAll();
            return false;
        }
        double dg = Double.parseDouble(donGia);
        if (dg < 0) {
            JOptionPane.showMessageDialog(ThemSanPhamDialog, "Đơn giá phải lớn hơn 0");
            txt_donGia.requestFocus();
            txt_donGia.selectAll();
            return false;
        }
        return true;

    }
    private boolean validata1() {
        String tenSP = txt_ten1.getText().trim();
        String donGia = txt_donGia1.getText().trim();
        if (tenSP.isBlank() || donGia.isBlank()) {

            JOptionPane.showMessageDialog(CapNhatSanPhamDialog, "Không được để trống");
            return false;
        }
        if(!tenSP.matches("^(\\p{L}{1}\\p{L}*\\s)*(\\p{L}{1}\\p{L}*)$")){
            JOptionPane.showMessageDialog(CapNhatSanPhamDialog, "Tên sản phẩm không được nhập số");
            txt_ten1.requestFocus();
            txt_ten1.selectAll();
            return false;
        }
        if (!donGia.matches("^[1-9]\\d*")) {
            JOptionPane.showMessageDialog(CapNhatSanPhamDialog, "Đơn giá phải lớn hơn 0, không được nhập chữ");
            txt_donGia1.requestFocus();
            txt_donGia1.selectAll();
            return false;
        }
        double dg = Double.parseDouble(donGia);
        if (dg < 0) {
            JOptionPane.showMessageDialog(CapNhatSanPhamDialog, "Đơn giá phải lớn hơn 0");
            txt_donGia1.requestFocus();
            txt_donGia1.selectAll();
            return false;
        }
        return true;

    }
    private void timKiem(String dieuKien){
        String timKiem=txt_tim.getText().trim();
        if(timKiem.isBlank()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập từ khóa cần tìm");
        }else{
            model.setRowCount(0);
            ArrayList<Thuoc> dsSP=sp_bus.selectAll();
            DecimalFormat decimalFormat = new DecimalFormat();
            boolean kt = false;
            for(Thuoc th:dsSP){
                    String formattedDonGia = decimalFormat.format(th.getDonGia()) + " VNĐ";
                    String tenDVT = dvt_bus.layTenDVTTheoMa(th.getDonViTinh().getMaDonViTinh());
                    String tenThuongHieu = th_bus.layTenThuongHieuTheoMa(th.getThuongHieu().getMaThuongHieu());
                    String tenNSX = nsx_bus.layTenNSXTheoMa(th.getNuocSanXuat().getMaNuoc());
                    String tenNhomThuoc=nhh_bus.layTenNhomThuocTheoMa(th.getNhomHangHoa().getMaNhomHang());
                    String tenCTKM = ctkm_bus.layTenKhuyenMaiTheoMa(th.getChuongTrinhKhuyenMaiEntity().getMaCTKM());
                    String hienThiKM = null;
                    if (tenCTKM != null) {
                        hienThiKM = tenCTKM;
                    } else {
                        hienThiKM = "Không giảm giá";
                    }
                    if(matchesSearchTerm(th,dieuKien)){
                        model.addRow(new Object[]{th.getMaThuoc(), th.getTenThuoc(), tenNSX,
                                th.getSoLuongTon(), formattedDonGia,tenNhomThuoc,
                                tenDVT, th.getHanSuDung(), th.getHoatChatChinh(), tenThuongHieu,
                                hienThiKM, th.getTrangThai(),th.getKhoiLuong(),th.getDuongDung(),th.getQuyCachDongGoi(),th.getDieuKienBaoQuan(),th.isThuocKeDon(),th.getImgUrl()});
                        kt = true;
                    }
            }
            if (!kt) {
                JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm");
                lamMoi();
            }

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ThemSanPhamDialog = new JDialog();
        jPanel9 = new JPanel();
        jPanel10 = new JPanel();
        jLabel14 = new JLabel();
        jLabel15 = new JLabel();
        txt_hoatChat = new JTextField();
        jLabel16 = new JLabel();
        jLabel17 = new JLabel();
        txt_quyCachDongGoi = new JTextField();
        jLabel20 = new JLabel();
        jLabel21 = new JLabel();
        txt_ten = new JTextField();
        txt_donGia = new JTextField();
        jLabel24 = new JLabel();
        cbo_NSX = new JComboBox<>();
        jLabel25 = new JLabel();
        cbo_tinhTrang = new JComboBox<>();
        jLabel30 = new JLabel();
        txt_khoiLuong = new JTextField();
        jLabel23 = new JLabel();
        txt_ma = new JTextField();
        jLabel31 = new JLabel();
        txt_duongDung = new JTextField();
        jLabel32 = new JLabel();
        cbo_DVT = new JComboBox<>();
        jLabel33 = new JLabel();
        txt_soLuong = new JTextField();
        jLabel34 = new JLabel();
        jLabel36 = new JLabel();
        jLabel37 = new JLabel();
        txt_dieuKienBaoQuan = new JTextField();
        jLabel6 = new JLabel();
        btn_chonAnh = new JButton();
        btn_them = new JButton();
        btn_huy = new JButton();
        cbo_thuocKeDon = new JComboBox<>();
        jLabel26 = new JLabel();
        cbo_thuongHieu = new JComboBox<>();
        cbo_nhomThuoc = new JComboBox<>();
        jLabel39 = new JLabel();
        cbo_ctkm = new JComboBox<>();
        jdc_NgayNhap = new com.toedter.calendar.JDateChooser();
        lbl_anhSanPham = new JLabel();
        CapNhatSanPhamDialog = new JDialog();
        jPanel11 = new JPanel();
        jPanel12 = new JPanel();
        jLabel18 = new JLabel();
        jLabel19 = new JLabel();
        txt_hoatChat1 = new JTextField();
        jLabel22 = new JLabel();
        jLabel35 = new JLabel();
        txt_quyCachDongGoi1 = new JTextField();
        jLabel38 = new JLabel();
        jLabel40 = new JLabel();
        txt_ten1 = new JTextField();
        txt_donGia1 = new JTextField();
        jLabel41 = new JLabel();
        cbo_NSX1 = new JComboBox<>();
        jLabel42 = new JLabel();
        cbo_tinhTrang1 = new JComboBox<>();
        jLabel43 = new JLabel();
        txt_khoiLuong1 = new JTextField();
        jLabel44 = new JLabel();
        txt_ma1 = new JTextField();
        jLabel45 = new JLabel();
        txt_duongDung1 = new JTextField();
        jLabel46 = new JLabel();
        cbo_DVT1 = new JComboBox<>();
        jLabel47 = new JLabel();
        txt_soLuong1 = new JTextField();
        jLabel48 = new JLabel();
        jLabel49 = new JLabel();
        jLabel50 = new JLabel();
        txt_dieuKienBaoQuan1 = new JTextField();
        jLabel51 = new JLabel();
        btn_chonAnh1 = new JButton();
        btn_them1 = new JButton();
        btn_huy1 = new JButton();
        cbo_thuocKeDon1 = new JComboBox<>();
        jLabel52 = new JLabel();
        cbo_thuongHieu1 = new JComboBox<>();
        cbo_nhomThuoc1 = new JComboBox<>();
        jLabel53 = new JLabel();
        cbo_ctkm1 = new JComboBox<>();
        jdc_NgayNhap1 = new com.toedter.calendar.JDateChooser();
        lbl_anhSanPham1 = new JLabel();
        jPanel1 = new JPanel();
        btnThem = new JPanel();
        jLabel2 = new JLabel();
        jLabel1 = new JLabel();
        btn_sua = new JPanel();
        jLabel5 = new JLabel();
        jLabel3 = new JLabel();
        btn_hetHan = new JPanel();
        jPanel6 = new JPanel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        btn_xuat = new JPanel();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        txt_tim = new JTextField();
        btn_tonKho = new JPanel();
        jLabel11 = new JLabel();
        jLabel12 = new JLabel();
        btn_nhap = new JPanel();
        jLabel28 = new JLabel();
        jLabel29 = new JLabel();
        jLabel4 = new JLabel();
        jLabel27 = new JLabel();
        btn_TimKiem = new JButton();
        jPanel2 = new JPanel();
        jScrollPane1 = new JScrollPane();
        table_thuoc = new JTable();

        ThemSanPhamDialog.setTitle("Thêm Sản Phẩm");
        ThemSanPhamDialog.setAlwaysOnTop(true);
        ThemSanPhamDialog.setBackground(new Color(255, 255, 255));
        ThemSanPhamDialog.setLocation(new Point(200, 50));
        ThemSanPhamDialog.setSize(new Dimension(1266, 710));
        ThemSanPhamDialog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ThemSanPhamDialogMouseClicked(evt);
            }
        });

        jPanel9.setBackground(new Color(255, 255, 255));

        jPanel10.setBackground(new Color(0, 102, 0));

        jLabel14.setFont(new Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel14.setForeground(new Color(255, 255, 255));
        jLabel14.setText("THÊM SẢN PHẨM");

        GroupLayout jPanel10Layout = new GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
                .addGap(513, 513, 513))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel14)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel15.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        jLabel15.setText("Đơn  Giá");

        txt_hoatChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hoatChatActionPerformed(evt);
            }
        });

        jLabel16.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        jLabel16.setText("Quy Cách Đóng Gói");

        jLabel17.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        jLabel17.setText("Thuốc Kê Đơn");

        txt_quyCachDongGoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_quyCachDongGoiActionPerformed(evt);
            }
        });

        jLabel20.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        jLabel20.setText("Hoạt Chất Chính");

        jLabel21.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        jLabel21.setText("Tên Thuốc");

        txt_ten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tenActionPerformed(evt);
            }
        });

        txt_donGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_donGiaActionPerformed(evt);
            }
        });

        jLabel24.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        jLabel24.setText("Nước Sản Xuất");

        cbo_NSX.setBorder(null);

        jLabel25.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        jLabel25.setText("Tình Trạng");

        cbo_tinhTrang.setModel(new DefaultComboBoxModel<>(new String[] { "Đang Bán", "Hết Hạn", "Ngừng Bán" }));
        cbo_tinhTrang.setBorder(null);
        cbo_tinhTrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_tinhTrangActionPerformed(evt);
            }
        });

        jLabel30.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        jLabel30.setText("Khối lượng");

        txt_khoiLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_khoiLuongActionPerformed(evt);
            }
        });

        jLabel23.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        jLabel23.setText("Mã Thuốc");

        txt_ma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_maActionPerformed(evt);
            }
        });

        jLabel31.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        jLabel31.setText("Đường dùng");

        txt_duongDung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_duongDungActionPerformed(evt);
            }
        });

        jLabel32.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        jLabel32.setText("Đơn Vị Tính");

        cbo_DVT.setBorder(null);
        cbo_DVT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_DVTActionPerformed(evt);
            }
        });

        jLabel33.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        jLabel33.setText("Số lượng tồn kho");

        txt_soLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_soLuongActionPerformed(evt);
            }
        });

        jLabel34.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        jLabel34.setText("Điều kiện bảo quản");

        jLabel36.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        jLabel36.setText("Chương Trình Khuyến Mãi");

        jLabel37.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        jLabel37.setText("Hạn Sử Dụng");

        txt_dieuKienBaoQuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dieuKienBaoQuanActionPerformed(evt);
            }
        });

        jLabel6.setFont(new Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Hình Minh Họa");

        btn_chonAnh.setFont(new Font("Times New Roman", 0, 14)); // NOI18N
        btn_chonAnh.setText("Chọn Ảnh");
        btn_chonAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chonAnhActionPerformed(evt);
            }
        });

        btn_them.setBackground(new Color(0, 102, 0));
        btn_them.setFont(new Font("Segoe UI Black", 1, 13)); // NOI18N
        btn_them.setForeground(new Color(255, 255, 255));
        btn_them.setText("Thêm Sản Phẩm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_huy.setBackground(new Color(204, 0, 0));
        btn_huy.setFont(new Font("Segoe UI Black", 1, 13)); // NOI18N
        btn_huy.setForeground(new Color(255, 255, 255));
        btn_huy.setText("Hủy Bỏ");
        btn_huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_huyActionPerformed(evt);
            }
        });

        cbo_thuocKeDon.setModel(new DefaultComboBoxModel<>(new String[] { "Có Kê Đơn", "Không Kê Đơn" }));
        cbo_thuocKeDon.setBorder(null);

        jLabel26.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        jLabel26.setText("Thương Hiệu");

        cbo_thuongHieu.setBorder(null);

        cbo_nhomThuoc.setBorder(null);

        jLabel39.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        jLabel39.setText("Nhóm Thuốc");

        cbo_ctkm.setBorder(null);

        jdc_NgayNhap.setDate(new Date());
        jdc_NgayNhap.setLocale(new Locale("vi","VN"));
        //jdc_NgayNhap.setSelectableDateRange(new Date(), null);
        //jdc_NgayNhap.setMinSelectableDate(new Date());
        jdc_NgayNhap.setMaxSelectableDate(new Date());
        jdc_NgayNhap.setFont(new Font("Times New Roman", 0, 14)); // NOI18N

        GroupLayout jPanel9Layout = new GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(lbl_anhSanPham, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(btn_chonAnh)))
                .addGap(81, 81, 81)
                .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jdc_NgayNhap, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel23, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                        .addGap(149, 149, 149))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel31, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_duongDung, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel32, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbo_DVT, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel33, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_soLuong, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel37, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_ten, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_quyCachDongGoi, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel25, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_dieuKienBaoQuan, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel34, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbo_tinhTrang, GroupLayout.Alignment.LEADING, 0, 131, Short.MAX_VALUE)))
                                .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGap(72, 72, 72)
                                        .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_hoatChat, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel20, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel17, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbo_NSX, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel24, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbo_nhomThuoc, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel39, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGap(64, 64, 64)
                                        .addComponent(cbo_thuocKeDon, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))))
                            .addComponent(txt_ma, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(239, 239, 239)
                                .addComponent(btn_them, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(btn_huy, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 88, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(txt_khoiLuong, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_donGia, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_thuongHieu, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_ctkm, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jLabel6)
                .addGap(2, 2, 2)
                .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_hoatChat, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_ten, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_khoiLuong, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_ma, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel15, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_quyCachDongGoi, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_donGia, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_duongDung, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbo_thuocKeDon, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel25, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel32, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel26, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(lbl_anhSanPham, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(cbo_tinhTrang, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbo_DVT, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_chonAnh))
                            .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(cbo_NSX, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbo_thuongHieu, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(cbo_nhomThuoc, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_ctkm, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel33, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_soLuong, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_dieuKienBaoQuan, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel37, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jdc_NgayNhap, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_them, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_huy, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                .addGap(0, 21, Short.MAX_VALUE))
        );

        GroupLayout ThemSanPhamDialogLayout = new GroupLayout(ThemSanPhamDialog.getContentPane());
        ThemSanPhamDialog.getContentPane().setLayout(ThemSanPhamDialogLayout);
        ThemSanPhamDialogLayout.setHorizontalGroup(
            ThemSanPhamDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(ThemSanPhamDialogLayout.createSequentialGroup()
                .addComponent(jPanel9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        ThemSanPhamDialogLayout.setVerticalGroup(
            ThemSanPhamDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(ThemSanPhamDialogLayout.createSequentialGroup()
                .addComponent(jPanel9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        CapNhatSanPhamDialog.setTitle("Thêm Sản Phẩm");
        CapNhatSanPhamDialog.setAlwaysOnTop(true);
        CapNhatSanPhamDialog.setBackground(new Color(255, 255, 255));
        CapNhatSanPhamDialog.setLocation(new Point(200, 50));
        CapNhatSanPhamDialog.setSize(new Dimension(1266, 710));
        CapNhatSanPhamDialog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CapNhatSanPhamDialogMouseClicked(evt);
            }
        });

        jPanel11.setBackground(new Color(255, 255, 255));

        jPanel12.setBackground(new Color(0, 102, 0));

        jLabel18.setFont(new Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel18.setForeground(new Color(255, 255, 255));
        jLabel18.setText("CẬP NHẬT SẢN PHẨM");

        GroupLayout jPanel12Layout = new GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
                .addGap(513, 513, 513))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel18)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel19.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        jLabel19.setText("Đơn  Giá");

        txt_hoatChat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hoatChat1ActionPerformed(evt);
            }
        });

        jLabel22.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        jLabel22.setText("Quy Cách Đóng Gói");

        jLabel35.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        jLabel35.setText("Thuốc Kê Đơn");

        txt_quyCachDongGoi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_quyCachDongGoi1ActionPerformed(evt);
            }
        });

        jLabel38.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        jLabel38.setText("Hoạt Chất Chính");

        jLabel40.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        jLabel40.setText("Tên Thuốc");

        txt_ten1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ten1ActionPerformed(evt);
            }
        });

        txt_donGia1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_donGia1ActionPerformed(evt);
            }
        });

        jLabel41.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        jLabel41.setText("Nước Sản Xuất");

        cbo_NSX1.setBorder(null);

        jLabel42.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        jLabel42.setText("Tình Trạng");

        cbo_tinhTrang1.setModel(new DefaultComboBoxModel<>(new String[] { "Đang Bán", "Hết Hạn", "Ngừng Bán" }));
        cbo_tinhTrang1.setBorder(null);
        cbo_tinhTrang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_tinhTrang1ActionPerformed(evt);
            }
        });

        jLabel43.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        jLabel43.setText("Khối lượng");

        txt_khoiLuong1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_khoiLuong1ActionPerformed(evt);
            }
        });

        jLabel44.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        jLabel44.setText("Mã Thuốc");

        txt_ma1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ma1ActionPerformed(evt);
            }
        });

        jLabel45.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        jLabel45.setText("Đường dùng");

        txt_duongDung1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_duongDung1ActionPerformed(evt);
            }
        });

        jLabel46.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        jLabel46.setText("Đơn Vị Tính");

        cbo_DVT1.setBorder(null);
        cbo_DVT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_DVT1ActionPerformed(evt);
            }
        });

        jLabel47.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        jLabel47.setText("Số lượng tồn kho");

        txt_soLuong1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_soLuong1ActionPerformed(evt);
            }
        });

        jLabel48.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        jLabel48.setText("Điều kiện bảo quản");

        jLabel49.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        jLabel49.setText("Chương Trình Khuyến Mãi");

        jLabel50.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        jLabel50.setText("Hạn Sử Dụng");

        txt_dieuKienBaoQuan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dieuKienBaoQuan1ActionPerformed(evt);
            }
        });

        jLabel51.setFont(new Font("Times New Roman", 0, 14)); // NOI18N
        jLabel51.setText("Hình Minh Họa");

        btn_chonAnh1.setFont(new Font("Times New Roman", 0, 14)); // NOI18N
        btn_chonAnh1.setText("Chọn Ảnh");
        btn_chonAnh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chonAnh1ActionPerformed(evt);
            }
        });

        btn_them1.setBackground(new Color(0, 102, 0));
        btn_them1.setFont(new Font("Segoe UI Black", 1, 13)); // NOI18N
        btn_them1.setForeground(new Color(255, 255, 255));
        btn_them1.setText("Cập Nhật Sản Phẩm");
        btn_them1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_them1ActionPerformed(evt);
            }
        });

        btn_huy1.setBackground(new Color(204, 0, 0));
        btn_huy1.setFont(new Font("Segoe UI Black", 1, 13)); // NOI18N
        btn_huy1.setForeground(new Color(255, 255, 255));
        btn_huy1.setText("Hủy Bỏ");
        btn_huy1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_huy1ActionPerformed(evt);
            }
        });

        cbo_thuocKeDon1.setModel(new DefaultComboBoxModel<>(new String[] { "Có Kê Đơn", "Không Kê Đơn" }));
        cbo_thuocKeDon1.setBorder(null);

        jLabel52.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        jLabel52.setText("Thương Hiệu");

        cbo_thuongHieu1.setBorder(null);

        cbo_nhomThuoc1.setBorder(null);

        jLabel53.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        jLabel53.setText("Nhóm Thuốc");

        cbo_ctkm1.setBorder(null);

        jdc_NgayNhap.setDate(new Date());
        jdc_NgayNhap.setLocale(new Locale("vi","VN"));
        //jdc_NgayNhap.setSelectableDateRange(new Date(), null);
        //jdc_NgayNhap.setMinSelectableDate(new Date());
        jdc_NgayNhap.setMaxSelectableDate(new Date());
        jdc_NgayNhap1.setFont(new Font("Times New Roman", 0, 14)); // NOI18N

        GroupLayout jPanel11Layout = new GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(lbl_anhSanPham1, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(btn_chonAnh1)))
                .addGap(81, 81, 81)
                .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jdc_NgayNhap1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel44, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                        .addGap(149, 149, 149))
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel45, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_duongDung1, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel46, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbo_DVT1, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel47, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_soLuong1, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel50, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_ten1, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel40, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_quyCachDongGoi1, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel42, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_dieuKienBaoQuan1, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel48, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbo_tinhTrang1, GroupLayout.Alignment.LEADING, 0, 131, Short.MAX_VALUE)))
                                .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGap(72, 72, 72)
                                        .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_hoatChat1, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel38, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel35, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbo_NSX1, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel41, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbo_nhomThuoc1, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel53, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGap(64, 64, 64)
                                        .addComponent(cbo_thuocKeDon1, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))))
                            .addComponent(txt_ma1, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(239, 239, 239)
                                .addComponent(btn_them1, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(btn_huy1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 88, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(txt_khoiLuong1, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_donGia1, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel52, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_thuongHieu1, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel49, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_ctkm1, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel51, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jLabel51)
                .addGap(2, 2, 2)
                .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_hoatChat1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_ten1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_khoiLuong1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_ma1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35)
                            .addComponent(jLabel19, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel45, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_quyCachDongGoi1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_donGia1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_duongDung1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbo_thuocKeDon1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel42, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel41, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel46, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel52, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(lbl_anhSanPham1, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(cbo_tinhTrang1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbo_DVT1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_chonAnh1))
                            .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(cbo_NSX1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbo_thuongHieu1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel48, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel49, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel53, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(cbo_nhomThuoc1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_ctkm1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel47, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_soLuong1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_dieuKienBaoQuan1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel50, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jdc_NgayNhap1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_them1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_huy1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                .addGap(0, 21, Short.MAX_VALUE))
        );

        GroupLayout CapNhatSanPhamDialogLayout = new GroupLayout(CapNhatSanPhamDialog.getContentPane());
        CapNhatSanPhamDialog.getContentPane().setLayout(CapNhatSanPhamDialogLayout);
        CapNhatSanPhamDialogLayout.setHorizontalGroup(
            CapNhatSanPhamDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(CapNhatSanPhamDialogLayout.createSequentialGroup()
                .addComponent(jPanel11, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        CapNhatSanPhamDialogLayout.setVerticalGroup(
            CapNhatSanPhamDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(CapNhatSanPhamDialogLayout.createSequentialGroup()
                .addComponent(jPanel11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setBackground(new Color(255, 255, 255));

        jPanel1.setBackground(new Color(255, 255, 255));

        btnThem.setBackground(new Color(255, 255, 255));

        jLabel2.setIcon(new ImageIcon("D:\\test2\\src\\icon\\add.png")); // NOI18N

        jLabel1.setBackground(new Color(255, 255, 255));
        jLabel1.setFont(new Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new Color(102, 102, 255));
        jLabel1.setText("THÊM");

        GroupLayout btnThemLayout = new GroupLayout(btnThem);
        btnThem.setLayout(btnThemLayout);
        btnThemLayout.setHorizontalGroup(
            btnThemLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(btnThemLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(btnThemLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)))
        );
        btnThemLayout.setVerticalGroup(
            btnThemLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(btnThemLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel2)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        btn_sua.setBackground(new Color(255, 255, 255));
        btn_sua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_suaMouseClicked(evt);
            }
        });

        jLabel5.setIcon(new ImageIcon("D:\\test2\\src\\icon\\edit.png")); // NOI18N

        jLabel3.setFont(new Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setForeground(new Color(102, 102, 255));
        jLabel3.setText("SỬA");

        GroupLayout btn_suaLayout = new GroupLayout(btn_sua);
        btn_sua.setLayout(btn_suaLayout);
        btn_suaLayout.setHorizontalGroup(
            btn_suaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(btn_suaLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(btn_suaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, btn_suaLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(23, 23, 23))
                    .addGroup(GroupLayout.Alignment.TRAILING, btn_suaLayout.createSequentialGroup()
                        .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        btn_suaLayout.setVerticalGroup(
            btn_suaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(btn_suaLayout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3))
        );

        btn_hetHan.setBackground(new Color(255, 255, 255));
        btn_hetHan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_hetHanMouseClicked(evt);
            }
        });

        jPanel6.setBackground(new Color(255, 255, 255));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });

        jLabel7.setIcon(new ImageIcon("D:\\test2\\src\\icon\\delete.png")); // NOI18N

        jLabel8.setFont(new Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setForeground(new Color(102, 102, 255));
        jLabel8.setText("CHECK HẾT HẠN");

        GroupLayout jPanel6Layout = new GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel8)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(45, 45, 45))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout btn_hetHanLayout = new GroupLayout(btn_hetHan);
        btn_hetHan.setLayout(btn_hetHanLayout);
        btn_hetHanLayout.setHorizontalGroup(
            btn_hetHanLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, btn_hetHanLayout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jPanel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        btn_hetHanLayout.setVerticalGroup(
            btn_hetHanLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(btn_hetHanLayout.createSequentialGroup()
                .addComponent(jPanel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        btn_xuat.setBackground(new Color(255, 255, 255));
        btn_xuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_xuatMouseClicked(evt);
            }
        });

        jLabel9.setIcon(new ImageIcon("D:\\test2\\src\\icon\\export_excel.png")); // NOI18N

        jLabel10.setFont(new Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setForeground(new Color(102, 102, 255));
        jLabel10.setText("XUẤT EXCEL");

        GroupLayout btn_xuatLayout = new GroupLayout(btn_xuat);
        btn_xuat.setLayout(btn_xuatLayout);
        btn_xuatLayout.setHorizontalGroup(
            btn_xuatLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(btn_xuatLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel10))
            .addGroup(btn_xuatLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel9))
        );
        btn_xuatLayout.setVerticalGroup(
            btn_xuatLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(btn_xuatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        txt_tim.setText("Nhập nội dung tìm kiếm");
        txt_tim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_timActionPerformed(evt);
            }
        });

        btn_tonKho.setBackground(new Color(255, 255, 255));
        btn_tonKho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tonKhoMouseClicked(evt);
            }
        });

        jLabel11.setIcon(new ImageIcon("D:\\helloimg.jpg")); // NOI18N

        jLabel12.setFont(new Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setForeground(new Color(102, 102, 255));
        jLabel12.setText("CHECK TỒN KHO");

        GroupLayout btn_tonKhoLayout = new GroupLayout(btn_tonKho);
        btn_tonKho.setLayout(btn_tonKhoLayout);
        btn_tonKhoLayout.setHorizontalGroup(
            btn_tonKhoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(btn_tonKhoLayout.createSequentialGroup()
                .addGroup(btn_tonKhoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(btn_tonKhoLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel12))
                    .addGroup(btn_tonKhoLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel11)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btn_tonKhoLayout.setVerticalGroup(
            btn_tonKhoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(btn_tonKhoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_nhap.setBackground(new Color(255, 255, 255));
        btn_nhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_nhapMouseClicked(evt);
            }
        });

        jLabel28.setIcon(new ImageIcon("D:\\test2\\src\\icon\\export_excel.png")); // NOI18N

        jLabel29.setFont(new Font("Segoe UI", 1, 16)); // NOI18N
        jLabel29.setForeground(new Color(102, 102, 255));
        jLabel29.setText("NHẬP EXCEL");

        GroupLayout btn_nhapLayout = new GroupLayout(btn_nhap);
        btn_nhap.setLayout(btn_nhapLayout);
        btn_nhapLayout.setHorizontalGroup(
            btn_nhapLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(btn_nhapLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel29))
            .addGroup(btn_nhapLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel28))
        );
        btn_nhapLayout.setVerticalGroup(
            btn_nhapLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(btn_nhapLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new Color(102, 102, 255));
        jLabel4.setText("CHI TIẾT");

        jLabel27.setIcon(new ImageIcon("D:\\test2\\src\\icon\\detail.png")); // NOI18N

        btn_TimKiem.setBackground(new Color(0, 102, 0));
        btn_TimKiem.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        btn_TimKiem.setForeground(new Color(255, 255, 255));
        btn_TimKiem.setText("Tìm");
        btn_TimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TimKiemActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_sua, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel27)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_hetHan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_tonKho, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_nhap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_xuat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(txt_tim, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btn_TimKiem, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(294, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(btn_nhap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_tonKho, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_hetHan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel27, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel4))
                        .addComponent(btn_sua, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_tim, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_TimKiem, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                            .addGap(24, 24, 24))
                        .addComponent(btn_xuat, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addGap(476, 476, 476))
        );

        jPanel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)), "Danh Sách Thuốc", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new Font("Times New Roman", 0, 12))); // NOI18N

        table_thuoc.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                    "Mã Thuốc", "Tên Thuốc","Nước sản xuất", "Số Lượng Tồn","Đơn giá", "Nhóm Thuốc","Đơn vị tính", "Hạn sử dụng", "Hoạt chất chính", "Thương hiệu","Khuyến mãi","Tình trạng","Khối lượng","Đường dùng","Quy cách đóng gói","Điều kiện bảo quản","Thuốc kê đơn","Ảnh"
            }
        ) {
            Class[] types = new Class [] {
                String.class, String.class, Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table_thuoc.setGridColor(new Color(255, 255, 255));
        table_thuoc.setInheritsPopupMenu(true);
        table_thuoc.setSelectionBackground(new Color(153, 153, 153));
        table_thuoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    table_thuocMouseClicked(evt);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        jScrollPane1.setViewportView(table_thuoc);
        if (table_thuoc.getColumnModel().getColumnCount() > 0) {
            table_thuoc.getColumnModel().getColumn(2).setMinWidth(12);
        }

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 1194, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 1182, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 578, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 566, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_timActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_timActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_timActionPerformed

    private void txt_hoatChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hoatChatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hoatChatActionPerformed

    private void txt_quyCachDongGoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_quyCachDongGoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_quyCachDongGoiActionPerformed

    private void txt_tenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tenActionPerformed

    private void txt_donGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_donGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_donGiaActionPerformed

    private void ThemSanPhamDialogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThemSanPhamDialogMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ThemSanPhamDialogMouseClicked

    private void txt_khoiLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_khoiLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_khoiLuongActionPerformed

    private void cbo_tinhTrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_tinhTrangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_tinhTrangActionPerformed

    private void txt_maActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_maActionPerformed

    private void txt_duongDungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_duongDungActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_duongDungActionPerformed

    private void cbo_DVTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_DVTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_DVTActionPerformed

    private void txt_soLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_soLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_soLuongActionPerformed

    private void txt_dieuKienBaoQuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dieuKienBaoQuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dieuKienBaoQuanActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:
        themSanPham();
    }//GEN-LAST:event_btn_themActionPerformed


    private void btn_chonAnhActionPerformed(java.awt.event.ActionEvent evt) {
//GEN-FIRST:event_btn_chonAnhActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser("src//imgProduct");
        FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif");
        fileChooser.setFileFilter(imageFilter);

        fileChooser.setDialogTitle("Mở file");
        Window parentWindow = SwingUtilities.getWindowAncestor((Component)evt.getSource());
        int kq = fileChooser.showOpenDialog(parentWindow);


        if (kq == JFileChooser.APPROVE_OPTION) {
            File tenAnh = fileChooser.getSelectedFile();
            String tenTepAnh = tenAnh.getName();
            duongDanAnh = "src//imgProduct//" + tenTepAnh;
            lbl_anhSanPham.setIcon(ResizeImageIcon(duongDanAnh));
            lbl_anhSanPham.setText(duongDanAnh);
        } else if (kq == JFileChooser.CANCEL_OPTION) {

        } else {
            JOptionPane.showMessageDialog(null, "Lỗi chọn ảnh");
        }
    }//GEN-LAST:event_btn_chonAnhActionPerformed

    private boolean matchesSearchTerm(Thuoc sanPham, String search) {
        String lowercaseSearch = search.toLowerCase(); // Chuyển chuỗi tìm kiếm về chữ thường

        if (sanPham.getMaThuoc().toLowerCase().contains(lowercaseSearch)
                || sanPham.getTenThuoc().toLowerCase().contains(lowercaseSearch)
                || (sanPham.getDieuKienBaoQuan() != null && sanPham.getDieuKienBaoQuan().toLowerCase().contains(lowercaseSearch))
                || (sanPham.getHoatChatChinh() != null && sanPham.getHoatChatChinh().toLowerCase().contains(lowercaseSearch))
                ||(sanPham.getDuongDung() != null && sanPham.getDuongDung().toLowerCase().contains(lowercaseSearch))
                || (sanPham.getQuyCachDongGoi() != null && sanPham.getQuyCachDongGoi().toLowerCase().contains(lowercaseSearch))
                || (sanPham.isThuocKeDon()?"Có Kê Đơn":"Không Kê Đơn").toLowerCase().contains(lowercaseSearch)
                || Double.toString(sanPham.getDonGia()).toLowerCase().contains(lowercaseSearch)
                || sanPham.getTrangThai().toString().toLowerCase().contains(lowercaseSearch)
                || Integer.toString(sanPham.getSoLuongTon()).toLowerCase().contains(lowercaseSearch))

        {
            return true;
        }
        if (sanPham.getNhomHangHoa() != null && sanPham.getNhomHangHoa().getMaNhomHang() != null) {
            String tenNhomHang = nhh_bus.layTenNhomThuocTheoMa(sanPham.getNhomHangHoa().getMaNhomHang()).toLowerCase();
            if (tenNhomHang.contains(lowercaseSearch)) {
                return true;
            }
        }
        if (sanPham.getThuongHieu() != null && sanPham.getThuongHieu().getMaThuongHieu() != null) {
            String tenThuongHieu = th_bus.layTenThuongHieuTheoMa(sanPham.getThuongHieu().getMaThuongHieu()).toLowerCase();
            if (tenThuongHieu.contains(lowercaseSearch)) {
                return true;
            }
        }
        if (sanPham.getNuocSanXuat() != null && sanPham.getNuocSanXuat().getMaNuoc() != null) {
            String tenDanhMuc = nsx_bus.layTenNSXTheoMa(sanPham.getNuocSanXuat().getMaNuoc()).toLowerCase();
            if (tenDanhMuc.contains(lowercaseSearch)) {
                return true;
            }
        }
        if (sanPham.getDonViTinh() != null && sanPham.getDonViTinh().getMaDonViTinh() != null) {
            String tenDonViTinh = dvt_bus.layTenDVTTheoMa(sanPham.getDonViTinh().getMaDonViTinh()).toLowerCase();
            if (tenDonViTinh.contains(lowercaseSearch)) {
                return true;
            }
        }
        if (sanPham.getChuongTrinhKhuyenMaiEntity() != null && sanPham.getChuongTrinhKhuyenMaiEntity().getMaCTKM() != null) {
            String tenCTKM = ctkm_bus.layTenKhuyenMaiTheoMa(sanPham.getChuongTrinhKhuyenMaiEntity().getMaCTKM()).toLowerCase();
            if (tenCTKM.contains(lowercaseSearch)) {
                return true;
            }
        }
        if (sanPham.getChuongTrinhKhuyenMaiEntity() == null || sanPham.getChuongTrinhKhuyenMaiEntity().getMaCTKM() == null) {
            String km = "Không giảm giá".toLowerCase();
            if (km.contains(lowercaseSearch)) {
                return true;
            }
        }

        return false;
    }
    private void kiemTraTonKho(){
        ArrayList<Thuoc> listThuoc = sp_bus.kiemTraTonKho();
        model.setRowCount(0);
        DecimalFormat decimalFormat = new DecimalFormat();
        for(Thuoc th:listThuoc){
            String formattedDonGia = decimalFormat.format(th.getDonGia()) + " VNĐ";
            String tenThuongHieu=th_bus.layTenThuongHieuTheoMa(th.getThuongHieu().getMaThuongHieu());
            String tenNhomHang=nhh_bus.layTenNhomThuocTheoMa(th.getNhomHangHoa().getMaNhomHang());
            String tenNSX=nsx_bus.layTenNSXTheoMa(th.getNuocSanXuat().getMaNuoc());
            String tenDVT=dvt_bus.layTenDVTTheoMa(th.getDonViTinh().getMaDonViTinh());
            String tenCTKM=ctkm_bus.layTenKhuyenMaiTheoMa(th.getChuongTrinhKhuyenMaiEntity().getMaCTKM());
            String hienThiKM = null;
            if (tenCTKM != null) {
                hienThiKM = tenCTKM;
            } else {
                hienThiKM = "Không giảm giá";
            }
            model.addRow(new Object[]{th.getMaThuoc(), th.getTenThuoc(), tenNSX, th.getSoLuongTon(), formattedDonGia, tenNhomHang, tenDVT, th.getHanSuDung(), th.getHoatChatChinh(), tenThuongHieu, hienThiKM, th.getTrangThai(), th.getKhoiLuong(), th.getDuongDung(), th.getQuyCachDongGoi(), th.getDieuKienBaoQuan(), th.isThuocKeDon() ? "Có Kê Đơn" : "Không Kê Đơn", th.getImgUrl()});

        }

    }
    private void kiemTraHetHan(){
        ArrayList<Thuoc> listThuoc = sp_bus.kiemTraHetHan();
        model.setRowCount(0);
        DecimalFormat decimalFormat = new DecimalFormat();
        for(Thuoc th:listThuoc){
            String formattedDonGia = decimalFormat.format(th.getDonGia()) + " VNĐ";
            String tenThuongHieu=th_bus.layTenThuongHieuTheoMa(th.getThuongHieu().getMaThuongHieu());
            String tenNhomHang=nhh_bus.layTenNhomThuocTheoMa(th.getNhomHangHoa().getMaNhomHang());
            String tenNSX=nsx_bus.layTenNSXTheoMa(th.getNuocSanXuat().getMaNuoc());
            String tenDVT=dvt_bus.layTenDVTTheoMa(th.getDonViTinh().getMaDonViTinh());
            String tenCTKM=ctkm_bus.layTenKhuyenMaiTheoMa(th.getChuongTrinhKhuyenMaiEntity().getMaCTKM());
            String hienThiKM = null;
            if (tenCTKM != null) {
                hienThiKM = tenCTKM;
            } else {
                hienThiKM = "Không giảm giá";
            }
            model.addRow(new Object[]{th.getMaThuoc(), th.getTenThuoc(), tenNSX, th.getSoLuongTon(), formattedDonGia, tenNhomHang, tenDVT, th.getHanSuDung(), th.getHoatChatChinh(), tenThuongHieu, hienThiKM, th.getTrangThai(), th.getKhoiLuong(), th.getDuongDung(), th.getQuyCachDongGoi(), th.getDieuKienBaoQuan(), th.isThuocKeDon() ? "Có Kê Đơn" : "Không Kê Đơn", th.getImgUrl()});

        }

    }
    private void xuatExcel() {
        try {
            JFileChooser fileChooser = new JFileChooser("D:\\TrenLop\\PTUD\\Phamarcy_Project\\src\\fileExcel");
            fileChooser.setDialogTitle("Chọn nơi lưu file");
            int chon = fileChooser.showSaveDialog(null);
            if (chon == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                String filePath = selectedFile.getAbsolutePath();
                if (!filePath.toLowerCase().endsWith(".xlsx")) {
                    filePath += ".xlsx";
                }
                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet("Danh sách sản phẩm");
                XSSFRow row = null;
                Cell cell = null;
                row = sheet.createRow(0);
                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue("Mã sản phẩm");
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue("Tên sản phẩm");
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue("Nước sản xuất");
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue("Số lượng tồn");
                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue("Đơn giá");
                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue("Nhóm thuốc");
                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue("Đơn vị tính");
                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue("Hạn sử dụng");
                cell = row.createCell(8, CellType.STRING);
                cell.setCellValue("Hoạt chất chính");
                cell = row.createCell(9, CellType.STRING);
                cell.setCellValue("Thương hiệu");
                cell = row.createCell(10, CellType.STRING);
                cell.setCellValue("Khuyến mãi");
                cell = row.createCell(11, CellType.STRING);
                cell.setCellValue("Tình trạng");
                cell = row.createCell(12, CellType.STRING);
                cell.setCellValue("Khối lượng");
                cell = row.createCell(13, CellType.STRING);
                cell.setCellValue("Đường dùng");
                cell = row.createCell(14, CellType.STRING);
                cell.setCellValue("Quy cách đóng gói");
                cell = row.createCell(15, CellType.STRING);
                cell.setCellValue("Điều kiện bảo quản");
                cell = row.createCell(16, CellType.STRING);
                cell.setCellValue("Thuốc kê đơn");
                cell = row.createCell(17, CellType.STRING);
                cell.setCellValue("Ảnh");


                ArrayList<Thuoc> listItem = sp_bus.selectAll();
                for (int i = 0; i < listItem.size(); i++) {
                    Thuoc sp = listItem.get(i);
                    String tenNSX = nsx_bus.layTenNSXTheoMa(sp.getNuocSanXuat().getMaNuoc());
                    String tenThuongHieu = th_bus.layTenThuongHieuTheoMa(sp.getThuongHieu().getMaThuongHieu());
                    String tenDVT = dvt_bus.layTenDVTTheoMa(sp.getDonViTinh().getMaDonViTinh());
                    String tenNhomHang = nhh_bus.layTenNhomThuocTheoMa(sp.getNhomHangHoa().getMaNhomHang());
                    String tenCTKM = ctkm_bus.layTenKhuyenMaiTheoMa(sp.getChuongTrinhKhuyenMaiEntity().getMaCTKM());
                    row = sheet.createRow(1 + i);
                    row.createCell(0).setCellValue(sp.getMaThuoc());
                    row.createCell(1).setCellValue(sp.getTenThuoc());
                    row.createCell(2).setCellValue(tenNSX);
                    row.createCell(3).setCellValue(sp.getSoLuongTon());
                    row.createCell(4).setCellValue(sp.getDonGia());
                    row.createCell(5).setCellValue(tenNhomHang);
                    row.createCell(6).setCellValue(tenDVT);
                    row.createCell(7).setCellValue(sp.getHanSuDung());
                    row.createCell(8).setCellValue(sp.getHoatChatChinh());
                    row.createCell(9).setCellValue(tenThuongHieu);
                    row.createCell(10).setCellValue(tenCTKM);
                    row.createCell(11).setCellValue(sp.getTrangThai().toString());
                    row.createCell(12).setCellValue(sp.getKhoiLuong());
                    row.createCell(13).setCellValue(sp.getDuongDung());
                    row.createCell(14).setCellValue(sp.getQuyCachDongGoi());
                    row.createCell(15).setCellValue(sp.getDieuKienBaoQuan());
                    row.createCell(16).setCellValue(sp.isThuocKeDon() ? "Có Kê Đơn" : "Không Kê Đơn");
                    row.createCell(17).setCellValue(sp.getImgUrl());

                }
                File f = new File(filePath);
                try (FileOutputStream fos = new FileOutputStream(f)) {
                    workbook.write(fos);
                    JOptionPane.showMessageDialog(null, "Xuất file thành công");
                    openExcelFile(f);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private void nhapExcel(){
        File excelFile;
        FileInputStream excelFIS = null;
        BufferedInputStream excelBIS = null;
        XSSFWorkbook excelImportToJTable = null;
        String defaultCurrentDirectoryPath = "D:\\TrenLop\\PTUD\\Phamarcy_Project\\src\\fileExcel";
        JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
        excelFileChooser.setDialogTitle("Chọn file excel");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        excelFileChooser.setFileFilter(fnef);
        int excelChooser = excelFileChooser.showOpenDialog(null);
        if (excelChooser == JFileChooser.APPROVE_OPTION) {
            Set<Object> maSanPhamSet = new HashSet<>();
            try {
                excelFile = excelFileChooser.getSelectedFile();
                excelFIS = new FileInputStream(excelFile);
                excelBIS = new BufferedInputStream(excelFIS);
                excelImportToJTable = new XSSFWorkbook(excelBIS);
                XSSFSheet excelSheet = excelImportToJTable.getSheetAt(0);
                for (int row = 1; row <= excelSheet.getLastRowNum(); row++) {
                    XSSFRow excelRow = excelSheet.getRow(row);
                    XSSFCell excelMaSP = excelRow.getCell(0);
                    // Kiểm tra xem mã sản phẩm đã tồn tại trong tập hợp chưa
                    String maSanPham = excelMaSP.getStringCellValue().trim();
                    int existingRow = -1;
                    // Kiểm tra xem mã sản phẩm nhập đã tồn tại trong bảng chưa
                    for (int i = 0; i < model.getRowCount(); i++) {
                        if (maSanPham.equals(model.getValueAt(i, 0).toString())) {
                            existingRow = i;
                            break;
                        }
                    }
                    XSSFCell excelTenSP = excelRow.getCell(1);
                    XSSFCell excelNuocSX = excelRow.getCell(2);
                    XSSFCell excelSoLuongTon = excelRow.getCell(3);
                    XSSFCell excelDonGia = excelRow.getCell(4);
                    XSSFCell excelNhomhang= excelRow.getCell(5);
                    XSSFCell excelDVT= excelRow.getCell(6);
                    XSSFCell excelHSD = excelRow.getCell(7);
                    XSSFCell excelHoatChat = excelRow.getCell(8);
                    XSSFCell excelTH = excelRow.getCell(9);
                    XSSFCell excelKhuyenMai = excelRow.getCell(10);
                    XSSFCell excelTinhTrang = excelRow.getCell(11);
                    XSSFCell excelKhoiLuong = excelRow.getCell(12);
                    XSSFCell excelDuongDung = excelRow.getCell(13);
                    XSSFCell excelQuyCach = excelRow.getCell(14);
                    XSSFCell excelDKBQ = excelRow.getCell(15);
                    XSSFCell excelThuocKeDon = excelRow.getCell(16);
                    XSSFCell excelDuongDanAnh = excelRow.getCell(17);

                    String khuyenMai = "";
                    if (excelKhuyenMai != null) {
                        khuyenMai = excelKhuyenMai.getStringCellValue().trim();
                    } else {
                        khuyenMai = "Không giảm giá";
                    }
                    int soLuongTonKho = (int) excelSoLuongTon.getNumericCellValue();
                    double donGia = excelDonGia.getNumericCellValue();
                    DecimalFormat decimalFormat = new DecimalFormat();
                    String formattedDonGia = decimalFormat.format(donGia) + " VNĐ";
                    String tinhTrang = excelTinhTrang.getStringCellValue().trim();
                    if (soLuongTonKho == 0 && "Đang bán".equals(tinhTrang)) {
                        tinhTrang = "Hết hàng";
                    }
                    if (existingRow != -1) {
                        model.setValueAt(excelTenSP.getStringCellValue(), existingRow, 1);
                        model.setValueAt(excelNuocSX.getStringCellValue(), existingRow, 2);
                        model.setValueAt(excelSoLuongTon.getNumericCellValue(), existingRow, 3);
                        model.setValueAt(formattedDonGia, existingRow, 4);
                        model.setValueAt(excelNhomhang, existingRow, 5);
                        model.setValueAt(excelDVT, existingRow, 6);
                        model.setValueAt(excelHSD, existingRow, 7);
                        model.setValueAt(excelHoatChat, existingRow, 8);
                        model.setValueAt(excelTH, existingRow, 9);

                        model.setValueAt(khuyenMai, existingRow, 10);
                        model.setValueAt(excelTinhTrang, existingRow, 11);
                        model.setValueAt(excelKhoiLuong, existingRow, 12);
                        model.setValueAt(excelDuongDung, existingRow, 13);
                        model.setValueAt(excelQuyCach, existingRow, 14);
                        model.setValueAt(excelDKBQ, existingRow, 15);
                        model.setValueAt(excelThuocKeDon, existingRow, 16);
                        model.setValueAt(excelDuongDanAnh, existingRow, 17);

                    } else {
                        maSanPhamSet.add(maSanPham);
                        model.addRow(new Object[]{maSanPham, excelTenSP.getStringCellValue(), excelNuocSX.getStringCellValue(), soLuongTonKho, formattedDonGia, excelNhomhang, excelDVT, excelHSD, excelHoatChat, excelTH, khuyenMai, tinhTrang, excelKhoiLuong, excelDuongDung, excelQuyCach, excelDKBQ, excelThuocKeDon, excelDuongDanAnh});
                    }
                }
                JOptionPane.showMessageDialog(null, "Nhập thành công");
            } catch (IOException iOException) {
                JOptionPane.showMessageDialog(null, iOException.getMessage());
            } finally {
                try {
                    if (excelFIS != null) {
                        excelFIS.close();
                    }
                    if (excelBIS != null) {
                        excelBIS.close();
                    }
                    if (excelImportToJTable != null) {
                        excelImportToJTable.close();
                    }
                } catch (IOException iOException) {
                    JOptionPane.showMessageDialog(null, iOException.getMessage());
                }
            }
        }
    }

    //Hàm tự dộng mở file excel sau khi xuất
    private static void openExcelFile(File file) throws IOException {
        Desktop desktop = Desktop.getDesktop();
        if (desktop.isSupported(Desktop.Action.OPEN)) {
            desktop.open(file);
        } else {
            System.out.println("Không thể mở file.");
        }
    }


    private void table_thuocMouseClicked(java.awt.event.MouseEvent evt) throws ParseException {//GEN-FIRST:event_table_thuocMouseClicked
        // TODO add your handling code here:
        int row = table_thuoc.getSelectedRow();
        txt_ma1.setText(model.getValueAt(row, 0).toString());
        txt_ten1.setText(model.getValueAt(row, 1).toString());
        cbo_NSX1.setSelectedItem(model.getValueAt(row, 2).toString());
        txt_soLuong1.setText(model.getValueAt(row, 3).toString());
        txt_soLuong1.setEditable(false);
        txt_donGia1.setText(model.getValueAt(row, 4).toString().replace(" VNĐ", "").replace(".", ""));
        cbo_nhomThuoc1.setSelectedItem(model.getValueAt(row, 5).toString());

        cbo_DVT1.setSelectedItem(model.getValueAt(row, 6).toString());
        jdc_NgayNhap1.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(table_thuoc.getValueAt(row, 7).toString()));
        txt_hoatChat1.setText(model.getValueAt(row, 8).toString());
        cbo_thuongHieu1.setSelectedItem(model.getValueAt(row, 9).toString());
        cbo_ctkm1.setSelectedItem(model.getValueAt(row, 10).toString());
        cbo_tinhTrang1.setSelectedItem(model.getValueAt(row, 11).toString());
        txt_khoiLuong1.setText(model.getValueAt(row, 12).toString());
        txt_duongDung1.setText(model.getValueAt(row, 13).toString());
        txt_quyCachDongGoi1.setText(model.getValueAt(row, 14).toString());
        txt_dieuKienBaoQuan1.setText(model.getValueAt(row, 15).toString());
        cbo_thuocKeDon1.setSelectedItem(model.getValueAt(row, 16).toString());
        String img = model.getValueAt(row, 17).toString();
        ImageIcon imageIcon = new ImageIcon(img);
        Image image = imageIcon.getImage();
        int width = Math.max(lbl_anhSanPham1.getWidth(), 1);
        int height = Math.max(lbl_anhSanPham1.getHeight(), 1);
        Image newImg = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon finalImageIcon = new ImageIcon(newImg);
        lbl_anhSanPham1.setIcon(finalImageIcon);
        lbl_anhSanPham1.setText(model.getValueAt(row, 17).toString());


    }//GEN-LAST:event_table_thuocMouseClicked

    private void btn_huyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_huyActionPerformed
        // TODO add your handling code here:
        ThemSanPhamDialog.dispose();
    }//GEN-LAST:event_btn_huyActionPerformed

    private void txt_hoatChat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hoatChat1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hoatChat1ActionPerformed

    private void txt_quyCachDongGoi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_quyCachDongGoi1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_quyCachDongGoi1ActionPerformed

    private void txt_ten1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ten1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ten1ActionPerformed

    private void txt_donGia1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_donGia1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_donGia1ActionPerformed

    private void cbo_tinhTrang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_tinhTrang1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_tinhTrang1ActionPerformed

    private void txt_khoiLuong1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_khoiLuong1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_khoiLuong1ActionPerformed

    private void txt_ma1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ma1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ma1ActionPerformed

    private void txt_duongDung1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_duongDung1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_duongDung1ActionPerformed

    private void cbo_DVT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_DVT1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_DVT1ActionPerformed

    private void txt_soLuong1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_soLuong1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_soLuong1ActionPerformed

    private void txt_dieuKienBaoQuan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dieuKienBaoQuan1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dieuKienBaoQuan1ActionPerformed

    private void btn_chonAnh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chonAnh1ActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser("src//imgProduct");
        FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif");
        fileChooser.setFileFilter(imageFilter);

        fileChooser.setDialogTitle("Mở file");
        Window parentWindow = SwingUtilities.getWindowAncestor((Component)evt.getSource());
        int kq = fileChooser.showOpenDialog(parentWindow);


        if (kq == JFileChooser.APPROVE_OPTION) {
            File tenAnh = fileChooser.getSelectedFile();
            String tenTepAnh = tenAnh.getName();
            duongDanAnh = "src//imgProduct//" + tenTepAnh;
            lbl_anhSanPham1.setIcon(ResizeImageIcon1(duongDanAnh));
            lbl_anhSanPham1.setText(duongDanAnh);
        } else if (kq == JFileChooser.CANCEL_OPTION) {

        } else {
            JOptionPane.showMessageDialog(null, "Lỗi chọn ảnh");
        }
    }//GEN-LAST:event_btn_chonAnh1ActionPerformed

    private void btn_them1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_them1ActionPerformed
        // TODO add your handling code here:
        capNhatSanPham();
    }//GEN-LAST:event_btn_them1ActionPerformed

    private void btn_huy1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_huy1ActionPerformed
        // TODO add your handling code here:
        CapNhatSanPhamDialog.dispose();
    }//GEN-LAST:event_btn_huy1ActionPerformed

    private void CapNhatSanPhamDialogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CapNhatSanPhamDialogMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_CapNhatSanPhamDialogMouseClicked

    private void btn_suaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_suaMouseClicked
        // TODO add your handling code here:
        int selectTedRow=table_thuoc.getSelectedRow();
        if(selectTedRow==-1){
            JOptionPane.showMessageDialog(null,"Bạn chưa chọn nhân viên cần cập nhật");
            return;
        }
        CapNhatSanPhamDialog.setVisible(true);
    }//GEN-LAST:event_btn_suaMouseClicked

    private void btn_TimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TimKiemActionPerformed
        // TODO add your handling code here:
        String dieuKien = txt_tim.getText().trim();
        timKiem(dieuKien);

    }//GEN-LAST:event_btn_TimKiemActionPerformed

    private void btn_tonKhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tonKhoMouseClicked
        // TODO add your handling code here:

        kiemTraTonKho();
    }//GEN-LAST:event_btn_tonKhoMouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        // TODO add your handling code here:
        kiemTraHetHan();
    }//GEN-LAST:event_jPanel6MouseClicked

    private void btn_nhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nhapMouseClicked
        // TODO add your handling code here:
        nhapExcel();

    }//GEN-LAST:event_btn_nhapMouseClicked

    private void btn_xuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_xuatMouseClicked
        // TODO add your handling code here:
        xuatExcel();
    }//GEN-LAST:event_btn_xuatMouseClicked

    private void btn_hetHanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hetHanMouseClicked
        // TODO add your handling code here:

        kiemTraHetHan();
    }//GEN-LAST:event_btn_hetHanMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JDialog CapNhatSanPhamDialog;
    private JDialog ThemSanPhamDialog;
    private JPanel btnThem;
    private JButton btn_TimKiem;
    private JButton btn_chonAnh;
    private JButton btn_chonAnh1;
    private JPanel btn_hetHan;
    private JButton btn_huy;
    private JButton btn_huy1;
    private JPanel btn_nhap;
    private JPanel btn_sua;
    private JButton btn_them;
    private JButton btn_them1;
    private JPanel btn_tonKho;
    private JPanel btn_xuat;
    private JComboBox<String> cbo_DVT;
    private JComboBox<String> cbo_DVT1;
    private JComboBox<String> cbo_NSX;
    private JComboBox<String> cbo_NSX1;
    private JComboBox<String> cbo_ctkm;
    private JComboBox<String> cbo_ctkm1;
    private JComboBox<String> cbo_nhomThuoc;
    private JComboBox<String> cbo_nhomThuoc1;
    private JComboBox<String> cbo_thuocKeDon;
    private JComboBox<String> cbo_thuocKeDon1;
    private JComboBox<String> cbo_thuongHieu;
    private JComboBox<String> cbo_thuongHieu1;
    private JComboBox<String> cbo_tinhTrang;
    private JComboBox<String> cbo_tinhTrang1;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel18;
    private JLabel jLabel19;
    private JLabel jLabel2;
    private JLabel jLabel20;
    private JLabel jLabel21;
    private JLabel jLabel22;
    private JLabel jLabel23;
    private JLabel jLabel24;
    private JLabel jLabel25;
    private JLabel jLabel26;
    private JLabel jLabel27;
    private JLabel jLabel28;
    private JLabel jLabel29;
    private JLabel jLabel3;
    private JLabel jLabel30;
    private JLabel jLabel31;
    private JLabel jLabel32;
    private JLabel jLabel33;
    private JLabel jLabel34;
    private JLabel jLabel35;
    private JLabel jLabel36;
    private JLabel jLabel37;
    private JLabel jLabel38;
    private JLabel jLabel39;
    private JLabel jLabel4;
    private JLabel jLabel40;
    private JLabel jLabel41;
    private JLabel jLabel42;
    private JLabel jLabel43;
    private JLabel jLabel44;
    private JLabel jLabel45;
    private JLabel jLabel46;
    private JLabel jLabel47;
    private JLabel jLabel48;
    private JLabel jLabel49;
    private JLabel jLabel5;
    private JLabel jLabel50;
    private JLabel jLabel51;
    private JLabel jLabel52;
    private JLabel jLabel53;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel10;
    private JPanel jPanel11;
    private JPanel jPanel12;
    private JPanel jPanel2;
    private JPanel jPanel6;
    private JPanel jPanel9;
    private JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdc_NgayNhap;
    private com.toedter.calendar.JDateChooser jdc_NgayNhap1;
    private JLabel lbl_anhSanPham;
    private JLabel lbl_anhSanPham1;
    private JTable table_thuoc;
    private JTextField txt_dieuKienBaoQuan;
    private JTextField txt_dieuKienBaoQuan1;
    private JTextField txt_donGia;
    private JTextField txt_donGia1;
    private JTextField txt_duongDung;
    private JTextField txt_duongDung1;
    private JTextField txt_hoatChat;
    private JTextField txt_hoatChat1;
    private JTextField txt_khoiLuong;
    private JTextField txt_khoiLuong1;
    private JTextField txt_ma;
    private JTextField txt_ma1;
    private JTextField txt_quyCachDongGoi;
    private JTextField txt_quyCachDongGoi1;
    private JTextField txt_soLuong;
    private JTextField txt_soLuong1;
    private JTextField txt_ten;
    private JTextField txt_ten1;
    private JTextField txt_tim;
    // End of variables declaration//GEN-END:variables
}
