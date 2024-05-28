package GUI;

import BUS.ChuongTrinhKhuyenMai_bus;
import DTO.ChuongTrinhKhuyenMai;
import DTO.LoaiKhuyenMai;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author 84335
 */
public class KhuyenMai_GUI extends javax.swing.JPanel {

    private final ChuongTrinhKhuyenMai_bus ctkmbus;
    private DefaultTableModel model;
    private java.sql.Date ngaybatdau;

    /**
     * Creates new form KhuyenMai_JPanel
     */
    public KhuyenMai_GUI() {
        initComponents();

         ButtonGroup rdo_group = new ButtonGroup();
         rdo_group.add(rdo_sp);
         rdo_group.add(rdo_hd);


         dateNgayBatDau.setLocale(Locale.forLanguageTag("vi-VN"));
         dateNgayKetThuc.setLocale(Locale.forLanguageTag("vi-VN"));
         setBounds(0, 0, 1186, 748);

        ImageIcon img_btnTimKiem = new ImageIcon("icon/buttonTimKiem.png");
        Image scaled_btnTimKiem = img_btnTimKiem.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnTimKiem = new ImageIcon(scaled_btnTimKiem);
        btn_TimKiem.setIcon(img_btnTimKiem);

        ImageIcon img_btnThem = new ImageIcon("icon/buttonThem.png");
        Image scaled_btnThem = img_btnThem.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnThem = new ImageIcon(scaled_btnThem);
        btn_Them.setIcon(img_btnThem);

        ImageIcon img_btnLamMoi = new ImageIcon("icon/buttonLamMoi.png");
        Image scaled_btnLamMoi = img_btnLamMoi.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnLamMoi = new ImageIcon(scaled_btnLamMoi);
        btn_LamMoi.setIcon(img_btnLamMoi);

        ImageIcon img_btnCapNhat = new ImageIcon("icon/buttonCapNhat.png");
        Image scaled_btnCapNhat = img_btnCapNhat.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnCapNhat = new ImageIcon(scaled_btnCapNhat);
        btn_CapNhat.setIcon(img_btnCapNhat);
//
//        ImageIcon img_btnXoa = new ImageIcon("src//pic//icon//buttonXoa.png");
//        Image scaled_btnXoa = img_btnXoa.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
//        img_btnXoa = new ImageIcon(scaled_btnXoa);
//        btn_Xoa.setIcon(img_btnXoa);
        ctkmbus = new ChuongTrinhKhuyenMai_bus();
    // set LoaiKM sẵn cho Hoá đơn
    txtLoaiKM.setText("GGHD");
        DocDuLieuTuSQLvaoTable();
    }

    private void DocDuLieuTuSQLvaoTable() {
          ArrayList<ChuongTrinhKhuyenMai> listCTKM = ctkmbus.getallCTKMtheoLoaiKM(txtLoaiKM.getText());
        for (ChuongTrinhKhuyenMai ctkm : listCTKM) {
            addRows(new Object[]{ctkm.getMaCTKM(),ctkm.getMaLoaiKM().getMaLoaiKM(), ctkm.getTenCTKM(), ctkm.getSoTienToiThieu(),ctkm.getSoTienToiDa(), ctkm.getGiamGia(), ctkm.getNgayBatDau(), ctkm.getNgayKetThuc(),ctkm.getTinhTrang()});
        }
    }

    public void addRows(Object[] row) {
        model = (DefaultTableModel) jTable1.getModel();
        model.addRow(row);
    }

    private void XoahetDuLieuTrenTable() {
        DefaultTableModel md = (DefaultTableModel) jTable1.getModel();
        md.getDataVector().removeAllElements();
    }

    private void LamMoi() {
        txtMaCTKM.setText("");
        txtTenCTKM.setText("");
        txtSoTienGiamTT.setText("");
        txtSoTienGiamTD.setText("");
        txtGiamGia.setText("");
        dateNgayBatDau.setDate(null);
        dateNgayKetThuc.setDate(null);
        txtTimMaCTKM.setText("");
    }

    private void Tim() {
        try {
            String maTim = txtTimMaCTKM.getText();
            if (maTim.equals("")) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập vào ô tìm kiếm");

            } else {
                ArrayList<ChuongTrinhKhuyenMai> listCTKM = null;
                listCTKM = ctkmbus.getCTKMTheoMaCTKM(maTim,txtLoaiKM.getText());
                if (!listCTKM.isEmpty()) {
                    XoahetDuLieuTrenTable();
                    for (ChuongTrinhKhuyenMai ctkm : listCTKM) {
                       addRows(new Object[]{ctkm.getMaCTKM(),ctkm.getMaLoaiKM().getMaLoaiKM(), ctkm.getTenCTKM(),ctkm.getSoTienToiDa(), ctkm.getSoTienToiThieu(), ctkm.getGiamGia(), ctkm.getNgayBatDau(), ctkm.getNgayKetThuc(),ctkm.getTinhTrang()});
                    }
                }
                else JOptionPane.showMessageDialog(null, "Không tìm thấy !");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void DocDuLieuTrenTable() {
        LamMoi();
        int row = jTable1.getSelectedRow();
        txtMaCTKM.setText(jTable1.getValueAt(row, 0).toString());
//        txtLoaiKM.setText(jTable1.getValueAt(row, 1).toString());
        txtTenCTKM.setText(jTable1.getValueAt(row, 2).toString());
        if(txtLoaiKM.getText().equals("GGHD")){
            txtSoTienGiamTT.setText(jTable1.getValueAt(row, 3).toString());
            txtSoTienGiamTD.setText(jTable1.getValueAt(row, 4).toString());
        }
        txtGiamGia.setText(jTable1.getValueAt(row, 5).toString());
        try {
            dateNgayBatDau.setDate((Date) jTable1.getValueAt(row, 6));
            dateNgayKetThuc.setDate((Date) jTable1.getValueAt(row, 7));

        } catch (Exception e) {
            String dateStringBD = jTable1.getValueAt(row, 6).toString();
            String dateStringKT = jTable1.getValueAt(row, 7).toString();
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-đd");
            try {
                Date utilDateBD = outputFormat.parse(dateStringBD);
                Date utilDateKT = outputFormat.parse(dateStringKT);
                java.sql.Date sqlDateBD = new java.sql.Date(utilDateBD.getTime());
                java.sql.Date sqlDateKT = new java.sql.Date(utilDateKT.getTime());
                dateNgayBatDau.setDate(sqlDateBD);
                dateNgayKetThuc.setDate(sqlDateKT);
            } catch (ParseException e1) {
                e1.printStackTrace();

            }
        }
    }

    private void ThemMoi() {
        if(CheckValid()){
        String ma = ctkmbus.getAutoIncrement();
        String ten = txtTenCTKM.getText();
        String maLoai = txtLoaiKM.getText();
        LoaiKhuyenMai lkm = new LoaiKhuyenMai(maLoai);
        double sotienTT;
        double sotienTD;
        if(txtLoaiKM.getText().equals("GGSP")){
            sotienTT = 0;
            sotienTD =0;
        }
        else{
             sotienTT = Double.parseDouble(txtSoTienGiamTT.getText());
             sotienTD = Double.parseDouble(txtSoTienGiamTD.getText());
        }

        int giamgia = Integer.parseInt(txtGiamGia.getText());
        java.sql.Date ngayBD = new java.sql.Date(dateNgayBatDau.getDate().getTime());
        java.sql.Date ngayKT = new java.sql.Date(dateNgayKetThuc.getDate().getTime());
        int tinhtrang = SetTinhTrang(ngayKT);

        ChuongTrinhKhuyenMai ctkm = new ChuongTrinhKhuyenMai(ma, lkm, ten, sotienTT, sotienTD, giamgia, ngayBD, ngayKT, tinhtrang);
        try {
            ctkmbus.insert(ctkm);

            JOptionPane.showMessageDialog(null, "Thêm thành công !");
            LamMoi();
            addRows(new Object[]{ctkm.getMaCTKM(),ctkm.getMaLoaiKM().getMaLoaiKM(), ctkm.getTenCTKM(), ctkm.getSoTienToiThieu(),ctkm.getSoTienToiDa(), ctkm.getGiamGia(), ctkm.getNgayBatDau(), ctkm.getNgayKetThuc(),ctkm.getTinhTrang()});

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Trùng mã");
            e.printStackTrace();
        }
        }
    }

    private void XoaRows(int row) {
        model.removeRow(row);

    }

    private void Xoa(){
        try {
        int row = jTable1.getSelectedRow();
        String ma = jTable1.getValueAt(row, 0).toString();
        ArrayList<ChuongTrinhKhuyenMai> ctkm = new ArrayList<ChuongTrinhKhuyenMai>();
        ctkm = ctkmbus.getCTKMTheoMaCTKM(ma,txtLoaiKM.getText());
        for(ChuongTrinhKhuyenMai km: ctkm){
            if(ctkmbus.delete(km)){
            JOptionPane.showMessageDialog(null, "Xoá thành công !");
            XoaRows(row);
        }
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Chưa chọn dữ liệu cần xoá !");
        }

    }


    private void CapNhat() {
        try {
            String ma = txtMaCTKM.getText();
            String ten = txtTenCTKM.getText();
            String maLoai = txtLoaiKM.getText();
            LoaiKhuyenMai lkm = new LoaiKhuyenMai(maLoai);
        double sotienTT;
        double sotienTD;
        if(txtLoaiKM.getText().equals("GGSP")){
            sotienTT = 0;
            sotienTD =0;
        }
        else{
             sotienTT = Double.parseDouble(txtSoTienGiamTT.getText());
             sotienTD = Double.parseDouble(txtSoTienGiamTD.getText());
        }
            int giam = Integer.parseInt(txtGiamGia.getText());
            java.sql.Date ngayBD = new java.sql.Date(dateNgayBatDau.getDate().getTime());
            java.sql.Date ngayKT = new java.sql.Date(dateNgayKetThuc.getDate().getTime());
            int tinhtrang = SetTinhTrang(ngayKT);
            ChuongTrinhKhuyenMai ctkm = new ChuongTrinhKhuyenMai(ma, lkm, ten, sotienTT, sotienTD, giam, ngayBD, ngayKT, tinhtrang);
            if (ctkmbus.update(ctkm)) {
                JOptionPane.showMessageDialog(null, "Cập nhật thành công" );
                XoahetDuLieuTrenTable();
                DocDuLieuTuSQLvaoTable();
                LamMoi();
                dateNgayBatDau.setSelectableDateRange(new Date(), null);
                dateNgayKetThuc.setSelectableDateRange(new Date(), null);

            } else {
                JOptionPane.showMessageDialog(null, "Cập nhật thất bại !");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int SetTinhTrang(Date dateKT){
//        Date datenow = new Date();
//        if(datenow.after(dateKT)){
//            return "Đã hết";
//        }
//
//        return "Còn";
    Date datenow = new Date(); // Lấy ngày hiện tại

    Calendar calendarNow = Calendar.getInstance();
    calendarNow.setTime(datenow);

    Calendar calendarKT = Calendar.getInstance();
    calendarKT.setTime(dateKT);

    // Kiểm tra ngày
    if (calendarNow.get(Calendar.YEAR) > calendarKT.get(Calendar.YEAR) ||
        (calendarNow.get(Calendar.YEAR) == calendarKT.get(Calendar.YEAR) &&
         calendarNow.get(Calendar.DAY_OF_YEAR) > calendarKT.get(Calendar.DAY_OF_YEAR))) {
        return 0;
    }

    return 1;
    }

    private boolean CheckValid(){
        String ten = txtTenCTKM.getText();
        String sotienTT = txtSoTienGiamTT.getText().trim();
        String sotienTD = txtSoTienGiamTD.getText().trim();
        String giamgia  = txtGiamGia.getText().trim();

        if(ten.equals("")){
            JOptionPane.showMessageDialog(null, "Không để trống tên Chương trình ");
            return false;
        }
        if(!(ten.length() >0 && ten.matches("^[\\p{L}'\\s\\p{N}\\p{P}]+$"))){
            JOptionPane.showMessageDialog(null, "Tên Chương trình không chứa ký tự đặc biệt");
            txtTenCTKM.selectAll();
            txtTenCTKM.requestFocus();
            return false;
        }
        if(txtLoaiKM.getText().equals("GGHD")){
            if(sotienTT.length() > 0){
            try {
                double stTT = Double.parseDouble(sotienTT);
                if(stTT  <=0){
                JOptionPane.showMessageDialog(null, "Số tiền tối thiểu phải lớn hơn 0");
                return false;
            }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Nhập số tiền không hợp lệ !");
                return false;
            }
        }else {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập số tiền tối thiểu !");
            return false;
        }
        if(sotienTD.length() > 0){
            try {
                double stTD = Double.parseDouble(sotienTD);
                if(stTD  <=0){
                JOptionPane.showMessageDialog(null, "Số tiền tối đa phải lớn hơn 0");
                return false;
            }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Nhập số tiền không hợp lệ !");
                return false;
            }
        }else {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập số tiền tối đa !");
            return false;
        }
        }

        if(giamgia.length() > 0){
            try {
                double gg = Double.parseDouble(giamgia);
                if(gg  <0 && gg >100){
                JOptionPane.showMessageDialog(null, "Số % giảm giá khoảng 0-100%");
                return false;
            }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Nhập số giảm giá không hợp lệ !");
                return false;
            }
        }else {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập số % giảm giá !");
            return false;
        }
        try {
             ngaybatdau = new java.sql.Date(dateNgayBatDau.getDate().getTime());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không để trống ngày bắt đầu !");
            return false;
        }

        try {
            java.sql.Date ngayketthuc = new java.sql.Date(dateNgayKetThuc.getDate().getTime());
            LocalDate ngaybd = dateNgayBatDau.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate ngaykt = dateNgayKetThuc.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            long khoangcach = ChronoUnit.DAYS.between(ngaybd, ngaykt);
            System.out.println(khoangcach);
            if(!ngaybd.isBefore(ngaykt)){
                JOptionPane.showMessageDialog(null, "Ngày bắt đầu phải đứng trước ngày kết thúc");
                return false;
            }
            if (khoangcach < 2) {
                 JOptionPane.showMessageDialog(null, "Ngày kết thúc với ngày bắt đầu cách it nhất 2 ngày !");
                return false;

            }


        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Không để trống ngày kết thúc !");
            return false;
        }


        return true;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        JPanel_ThongTinCTKM = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTenCTKM = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtGiamGia = new javax.swing.JTextField();
        txtMaCTKM = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        dateNgayKetThuc = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        txtSoTienGiamTD = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        dateNgayBatDau = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtSoTienGiamTT = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        rdo_sp = new javax.swing.JRadioButton();
        rdo_hd = new javax.swing.JRadioButton();
        txtLoaiKM = new javax.swing.JTextField();
        btn_Xuat = new java.awt.Button();
        btn_Them = new javax.swing.JButton();
        btn_CapNhat = new javax.swing.JButton();
        JPanel_Table = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtTimMaCTKM = new javax.swing.JTextField();
        btn_TimKiem = new javax.swing.JButton();
        btn_LamMoi = new javax.swing.JButton();

        setBackground(new java.awt.Color(22, 97, 86));
        setPreferredSize(new java.awt.Dimension(1186, 748));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(0, 102, 0));
        jLabel2.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("QUẢN LÝ CHƯƠNG TRÌNH KHUYẾN MÃI");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1250, 38));

        JPanel_ThongTinCTKM.setBackground(new java.awt.Color(22, 97, 86));
        JPanel_ThongTinCTKM.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Thông tin chương trình khuyến mãi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bahnschrift", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        JPanel_ThongTinCTKM.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tên Chương Trình");
        JPanel_ThongTinCTKM.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 130, 30));

        txtTenCTKM.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        txtTenCTKM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTenCTKM.setBorder(null);
        JPanel_ThongTinCTKM.add(txtTenCTKM, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 170, 30));

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ngày Kết Thúc");
        jLabel3.setPreferredSize(new java.awt.Dimension(109, 30));
        JPanel_ThongTinCTKM.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 60, 110, 30));

        txtGiamGia.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        txtGiamGia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGiamGia.setBorder(null);
        txtGiamGia.setFocusCycleRoot(true);
        JPanel_ThongTinCTKM.add(txtGiamGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 170, 30));

        txtMaCTKM.setEditable(false);
        txtMaCTKM.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        txtMaCTKM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMaCTKM.setBackground(new java.awt.Color(244, 244, 244));
        txtMaCTKM.setBorder(null);
        JPanel_ThongTinCTKM.add(txtMaCTKM, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 170, 30));

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Giảm Giá (%)");
        jLabel5.setPreferredSize(new java.awt.Dimension(109, 30));
        JPanel_ThongTinCTKM.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 110, 30));

        dateNgayKetThuc.setSelectableDateRange(new Date(), null);
        JPanel_ThongTinCTKM.add(dateNgayKetThuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 60, 180, 30));

        jLabel6.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Loại Khuyến Mãi");
        jLabel6.setPreferredSize(new java.awt.Dimension(109, 30));
        JPanel_ThongTinCTKM.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, 160, 30));

        txtSoTienGiamTD.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        txtSoTienGiamTD.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSoTienGiamTD.setBorder(null);
        JPanel_ThongTinCTKM.add(txtSoTienGiamTD, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, 170, 30));

        jLabel7.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ngày Bắt Đầu");
        jLabel7.setPreferredSize(new java.awt.Dimension(109, 30));
        JPanel_ThongTinCTKM.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, 100, 30));

        dateNgayBatDau.setSelectableDateRange(new Date(), null);
        JPanel_ThongTinCTKM.add(dateNgayBatDau, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 20, 180, 30));

        jLabel8.setBackground(new java.awt.Color(0, 102, 0));
        jLabel8.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Mã Chương Trình");
        jLabel8.setPreferredSize(new java.awt.Dimension(109, 30));
        JPanel_ThongTinCTKM.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 130, 30));

        jLabel9.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Tiền  Tối Thiểu Để Giảm");
        jLabel9.setPreferredSize(new java.awt.Dimension(109, 30));
        JPanel_ThongTinCTKM.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 180, 30));

        txtSoTienGiamTT.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        txtSoTienGiamTT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSoTienGiamTT.setBorder(null);
        JPanel_ThongTinCTKM.add(txtSoTienGiamTT, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 170, 30));

        jLabel10.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Tiền Tối Đa Được Giảm");
        jLabel10.setPreferredSize(new java.awt.Dimension(109, 30));
        JPanel_ThongTinCTKM.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 170, 30));

        rdo_sp.setForeground(new java.awt.Color(255, 255, 255));
        rdo_sp.setFont(new java.awt.Font("Bahnschrift", 3, 12)); // NOI18N
        rdo_sp.setText("Áp dụng cho sản phẩm");
        rdo_sp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdo_spActionPerformed(evt);
            }
        });
        JPanel_ThongTinCTKM.add(rdo_sp, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 100, 160, 30));

        rdo_hd.setForeground(new java.awt.Color(255, 255, 255));
        rdo_hd.setFont(new java.awt.Font("Bahnschrift", 3, 12)); // NOI18N
        rdo_hd.setSelected(true);
        rdo_hd.setText("Áp dụng cho hoá đơn");
        rdo_hd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdo_hdActionPerformed(evt);
            }
        });
        JPanel_ThongTinCTKM.add(rdo_hd, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 100, 150, 30));

        txtLoaiKM.setEditable(false);
        txtLoaiKM.setBackground(new java.awt.Color(244, 244, 244));
        txtLoaiKM.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        txtLoaiKM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JPanel_ThongTinCTKM.add(txtLoaiKM, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, 170, 30));

        btn_Xuat.setBackground(new java.awt.Color(255, 255, 255));
        btn_Xuat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Xuat.setFont(new java.awt.Font("Bahnschrift", 1, 15)); // NOI18N
        btn_Xuat.setLabel("Xuất file");
        btn_Xuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_XuatMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_XuatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_XuatMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_XuatMouseReleased(evt);
            }
        });
        btn_Xuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XuatActionPerformed(evt);
            }
        });
        JPanel_ThongTinCTKM.add(btn_Xuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 100, 130, 30));

        btn_Them.setBackground(new java.awt.Color(153, 0, 0));
        btn_Them.setFont(new java.awt.Font("Bahnschrift", 1, 15)); // NOI18N
        btn_Them.setForeground(new java.awt.Color(255, 255, 255));
        btn_Them.setText("Thêm");
        btn_Them.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Them.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ThemMouseClicked(evt);
            }
        });
        JPanel_ThongTinCTKM.add(btn_Them, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 20, 130, 30));

        btn_CapNhat.setBackground(new java.awt.Color(0, 153, 204));
        btn_CapNhat.setFont(new java.awt.Font("Bahnschrift", 1, 15)); // NOI18N
        btn_CapNhat.setForeground(new java.awt.Color(255, 255, 255));
        btn_CapNhat.setText("Cập Nhật");
        btn_CapNhat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_CapNhat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_CapNhatMouseClicked(evt);
            }
        });
        btn_CapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CapNhatActionPerformed(evt);
            }
        });
        JPanel_ThongTinCTKM.add(btn_CapNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 60, 130, 30));

        add(JPanel_ThongTinCTKM, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 1240, 150));

        JPanel_Table.setBackground(new java.awt.Color(255, 255, 255));
        JPanel_Table.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Danh sách bảng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bahnschrift", 0, 12))); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Chương Trình", "Loại Khuyến Mãi", "Tên Chương Trình", "Tiền tối thiểu để giảm", "Tiền tối đa được giảm", "Giảm Giá", "Ngày Bắt Đầu", "Ngày Kết Thúc", "Tình Trạng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setFocusable(false);
        jTable1.setRequestFocusEnabled(false);
        jTable1.setModel(jTable1.getModel());
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(8).setCellRenderer(new CenterRenderer());
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout JPanel_TableLayout = new javax.swing.GroupLayout(JPanel_Table);
        JPanel_Table.setLayout(JPanel_TableLayout);
        JPanel_TableLayout.setHorizontalGroup(
            JPanel_TableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel_TableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1218, Short.MAX_VALUE)
                .addContainerGap())
        );
        JPanel_TableLayout.setVerticalGroup(
            JPanel_TableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel_TableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(JPanel_Table, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 265, 1240, 490));

        txtTimMaCTKM.setForeground(new java.awt.Color(153, 153, 153));
        txtTimMaCTKM.setText("Nhập mã chương trình cần tìm");
        add(txtTimMaCTKM, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 200, 30));

        btn_TimKiem.setBackground(new java.awt.Color(255, 255, 204));
        btn_TimKiem.setFont(new java.awt.Font("Bahnschrift", 1, 15)); // NOI18N
        btn_TimKiem.setText("Tìm Kiếm");
        btn_TimKiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_TimKiem.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btn_TimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_TimKiemMouseClicked(evt);
            }
        });
        add(btn_TimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 120, 30));

        btn_LamMoi.setBackground(new java.awt.Color(255, 204, 204));
        btn_LamMoi.setFont(new java.awt.Font("Bahnschrift", 1, 15)); // NOI18N
        btn_LamMoi.setText("Làm Mới");
        btn_LamMoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_LamMoi.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btn_LamMoi.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_LamMoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_LamMoiMouseClicked(evt);
            }
        });
        btn_LamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LamMoiActionPerformed(evt);
            }
        });
        add(btn_LamMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 120, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_LamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LamMoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_LamMoiActionPerformed

    private void btn_TimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TimKiemMouseClicked
        // TODO add your handling code here:
        Tim();
    }//GEN-LAST:event_btn_TimKiemMouseClicked

    private void btn_LamMoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_LamMoiMouseClicked
        // TODO add your handling code here:
        LamMoi();
        XoahetDuLieuTrenTable();
        DocDuLieuTuSQLvaoTable();

    }//GEN-LAST:event_btn_LamMoiMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DocDuLieuTrenTable();
        dateNgayBatDau.setSelectableDateRange(null, null);
        dateNgayKetThuc.setSelectableDateRange(null, null);
    }//GEN-LAST:event_jTable1MouseClicked

    private void btn_ThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ThemMouseClicked
        // TODO add your handling code here:
        ThemMoi();
    }//GEN-LAST:event_btn_ThemMouseClicked

    private void btn_CapNhatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_CapNhatMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_CapNhatMouseClicked

    private void btn_CapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CapNhatActionPerformed
        CapNhat();
    }//GEN-LAST:event_btn_CapNhatActionPerformed

    private void rdo_spActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdo_spActionPerformed
        txtSoTienGiamTD.setEditable(false);
        txtSoTienGiamTD.setBackground(new Color(244, 244, 244));
        txtSoTienGiamTT.setEditable(false);
        txtSoTienGiamTT.setBackground(new Color(244, 244, 244));

        TableColumnModel models = jTable1.getColumnModel();
        if(rdo_sp.isSelected()){
            models.getColumn(3).setWidth(0);
        models.getColumn(3).setMaxWidth(0);
        models.getColumn(3).setMinWidth(0);
        models.getColumn(4).setWidth(0);
        models.getColumn(4).setMaxWidth(0);
        models.getColumn(4).setMinWidth(0);
        models.getColumn(3).setWidth(0);
        models.getColumn(3).setMaxWidth(0);
        models.getColumn(3).setMinWidth(0);
        models.getColumn(4).setWidth(0);
        models.getColumn(4).setMaxWidth(0);
        models.getColumn(4).setMinWidth(0);
        }
       txtLoaiKM.setText("");
       txtLoaiKM.setText("GGSP");
       LamMoi();
       XoahetDuLieuTrenTable();
        DocDuLieuTuSQLvaoTable();
    }//GEN-LAST:event_rdo_spActionPerformed

    private void rdo_hdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdo_hdActionPerformed
        txtSoTienGiamTD.setEditable(true);
        txtSoTienGiamTD.setBackground(new Color(255, 255, 255));
        txtSoTienGiamTT.setEditable(true);
        txtSoTienGiamTT.setBackground(new Color(255, 255, 255));
        TableColumnModel models = jTable1.getColumnModel();
       if(rdo_hd.isSelected()){
            models.getColumn(3).setWidth(100);
        models.getColumn(3).setMaxWidth(100);
        models.getColumn(3).setMinWidth(100);
        models.getColumn(4).setWidth(100);
        models.getColumn(4).setMaxWidth(100);
        models.getColumn(4).setMinWidth(100);
       }
       txtLoaiKM.setText("");
       txtLoaiKM.setText("GGHD");
       LamMoi();
       XoahetDuLieuTrenTable();
        DocDuLieuTuSQLvaoTable();
    }//GEN-LAST:event_rdo_hdActionPerformed

    private void dateNgayBatDauPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateNgayBatDauPropertyChange
        // TODO add your handling code here:

        if(dateNgayKetThuc.getDate() !=null && dateNgayBatDau.getDate() !=null){
//            Date datenow = new Date();
//            if(!datenow.before(dateNgayBatDau.getDate())){
//                JOptionPane.showMessageDialog(null, "Ngày bắt đầu phải bắt đầu từ ngày hiện tại");
//                dateNgayBatDau.setDate(null);
//            }
            if(!dateNgayBatDau.getDate().before(dateNgayKetThuc.getDate())){
                JOptionPane.showMessageDialog(null, "Ngày bắt đầu phải đứng trước ngày kết thúc");
                dateNgayBatDau.setDate(null);
            }
        }
    }//GEN-LAST:event_dateNgayBatDauPropertyChange

    private void dateNgayKetThucPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateNgayKetThucPropertyChange
         if(dateNgayBatDau.getDate() !=null && dateNgayKetThuc.getDate() !=null){
            if(!dateNgayBatDau.getDate().before(dateNgayKetThuc.getDate())){
                JOptionPane.showMessageDialog(null, "Ngày kết thúc phải đứng sau ngày bắt đầu");
                dateNgayKetThuc.setDate(null);
            }
        }
    }//GEN-LAST:event_dateNgayKetThucPropertyChange

    private void btn_XuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_XuatMouseClicked
        btn_Xuat.setBackground(Color.CYAN);
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
        XSSFSheet sheet = workbook.createSheet("Khuyến Mãi");
        XSSFRow row= null;
        Cell cell = null;
        row = sheet.createRow(3);

        row.createCell(0).setCellValue("Mã Chương Trình");
row.createCell(1).setCellValue("Loại Khuyến Mãi");
row.createCell(2).setCellValue("Tên Chương Trình");

if(txtLoaiKM.getText().equals("GGHD")){
    row.createCell(3).setCellValue("Số tiền tối thiểu");
    row.createCell(4).setCellValue("Số tiền tối đa");
    row.createCell(5).setCellValue("Giảm giá");
    row.createCell(6).setCellValue("Ngày bắt đầu ");
    row.createCell(7).setCellValue("Ngày Kết Thúc");
    row.createCell(8).setCellValue("Tình Trạng");
}else{
    row.createCell(3).setCellValue("Giảm giá");
    row.createCell(4).setCellValue("Ngày bắt đầu ");
    row.createCell(5).setCellValue("Ngày Kết Thúc");
    row.createCell(6).setCellValue("Tình Trạng");
}

        ArrayList<ChuongTrinhKhuyenMai> dsCTKMHD = null;
        if(txtLoaiKM.getText().equals("GGHD"))dsCTKMHD = ctkmbus.getallCTKMtheoLoaiKM("GGHD");
        else dsCTKMHD = ctkmbus.getallCTKMtheoLoaiKM("GGSP");

        int i =0;
        if(dsCTKMHD != null ){
    for (ChuongTrinhKhuyenMai kmhd: dsCTKMHD){
        i++;
        row = sheet.createRow(3+i);

        cell = row.createCell(0);
        cell.setCellType(CellType.STRING);
        cell.setCellValue(kmhd.getMaCTKM());

        cell = row.createCell(1);
        cell.setCellType(CellType.STRING);
        cell.setCellValue(kmhd.getMaLoaiKM().getMaLoaiKM());

        cell = row.createCell(2);
        cell.setCellType(CellType.STRING);
        cell.setCellValue(kmhd.getTenCTKM());

        if(txtLoaiKM.getText().equals("GGHD")){
            cell = row.createCell(3);
            cell.setCellType(CellType.NUMERIC);
            cell.setCellValue(kmhd.getSoTienToiThieu());

            cell = row.createCell(4);
            cell.setCellType(CellType.NUMERIC);
            cell.setCellValue(kmhd.getSoTienToiDa());

            cell = row.createCell(5);
            cell.setCellType(CellType.NUMERIC);
            cell.setCellValue(kmhd.getGiamGia());

            cell = row.createCell(6);
            cell.setCellType(CellType.STRING);
            cell.setCellValue(kmhd.getNgayBatDau().toString());

            cell = row.createCell(7);
            cell.setCellType(CellType.STRING);
            cell.setCellValue(kmhd.getNgayKetThuc().toString());

            cell = row.createCell(8);
            cell.setCellType(CellType.STRING);
            cell.setCellValue(kmhd.getTinhTrang());
        }else{
            cell = row.createCell(3);
            cell.setCellType(CellType.NUMERIC);
            cell.setCellValue(kmhd.getGiamGia());

            cell = row.createCell(4);
            cell.setCellType(CellType.STRING);
            cell.setCellValue(kmhd.getNgayBatDau().toString());

            cell = row.createCell(5);
            cell.setCellType(CellType.STRING);
            cell.setCellValue(kmhd.getNgayKetThuc().toString());

            cell = row.createCell(6);
            cell.setCellType(CellType.STRING);
            cell.setCellValue(kmhd.getTinhTrang());
        }

        // Save file
        File fis = new File(filePath);
        try {
            FileOutputStream fisO = new FileOutputStream(fis);
            workbook.write(fisO);
            openExcelFile(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
            }
    }//GEN-LAST:event_btn_XuatMouseClicked
    // Mở file

     private static void openExcelFile(File file) throws IOException {
         Desktop desktop = Desktop.getDesktop();
        if (desktop.isSupported(Desktop.Action.OPEN)) {
            desktop.open(file);
        } else {
            // Xử lý nếu không thể mở file
            System.out.println("Không thể mở file.");
        }
    }

    private void btn_XuatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_XuatMouseEntered
        // TODO add your handling code here:
        btn_Xuat.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_XuatMouseEntered

    private void btn_XuatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_XuatMouseExited
        // TODO add your handling code here:
        btn_Xuat.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_XuatMouseExited

    private void btn_XuatMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_XuatMouseReleased
        // TODO add your handling code here:
        btn_Xuat.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_XuatMouseReleased

    private void btn_XuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XuatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_XuatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanel_Table;
    private javax.swing.JPanel JPanel_ThongTinCTKM;
    private javax.swing.JButton btn_CapNhat;
    private javax.swing.JButton btn_LamMoi;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_TimKiem;
    private java.awt.Button btn_Xuat;
    private com.toedter.calendar.JDateChooser dateNgayBatDau;
    private com.toedter.calendar.JDateChooser dateNgayKetThuc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton rdo_hd;
    private javax.swing.JRadioButton rdo_sp;
    private javax.swing.JTextField txtGiamGia;
    private javax.swing.JTextField txtLoaiKM;
    private javax.swing.JTextField txtMaCTKM;
    private javax.swing.JTextField txtSoTienGiamTD;
    private javax.swing.JTextField txtSoTienGiamTT;
    private javax.swing.JTextField txtTenCTKM;
    private javax.swing.JTextField txtTimMaCTKM;
    // End of variables declaration//GEN-END:variables
    class CenterRenderer extends DefaultTableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        ((JLabel) c).setHorizontalAlignment(SwingConstants.CENTER); // Căn giữa nội dung của cột
        return c;
    }
    }

}
