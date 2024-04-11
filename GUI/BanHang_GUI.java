/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.*;
import DTO.*;

import java.awt.Image;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



import utils.ConvertDoubleToMoney;
import utils.Global;

/**
 *
 * @author USER
 */
public class BanHang_GUI extends javax.swing.JPanel {
    private DefaultTableModel tableModel_GioHang;
    private DefaultTableModel tableModel_HoaDon;
    private SpinnerNumberModel spinnerModel;
     private ArrayList<ChiTietHoaDon> cthdList = new ArrayList<ChiTietHoaDon>();
    private SanPham_bus sp_bus = new SanPham_bus();
    private ArrayList<HoaDon> hdList = new ArrayList<HoaDon>();
    private ChuongTrinhKhuyenMai_bus ctkm_bus=new ChuongTrinhKhuyenMai_bus();
    private ConvertDoubleToMoney convert = new ConvertDoubleToMoney();
     private HoaDon hoaDon = new HoaDon();
     private KhachHang_bus kh_bus=new KhachHang_bus();
     private HoaDon_bus hd_bus=new HoaDon_bus();
     private ChiTietHoaDon_bus cthd_bus=new ChiTietHoaDon_bus();
    private KhachHang khachHang = new KhachHang();


    
    
    /**
     * Creates new form BanHang_GUI
     */
    public BanHang_GUI() {
        
        initComponents();
        ImageIcon img_btnTimKiemSanPham = new ImageIcon("D:\\TrenLop\\PTUD\\Phamarcy_Project\\src\\icon\\buttonTimKiem.png");
        Image scaled_btnTimKiemSanPham = img_btnTimKiemSanPham.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnTimKiemSanPham = new ImageIcon(scaled_btnTimKiemSanPham);
         btnTimKiemHoaDonChuaThanhToan.setIcon(img_btnTimKiemSanPham);
         btnTimKiemSanPham.setIcon(img_btnTimKiemSanPham);
         btnTimKiemHoaDon.setIcon(img_btnTimKiemSanPham);
         
         ImageIcon img_btnThanhToan = new ImageIcon("D:\\TrenLop\\PTUD\\Phamarcy_Project\\src\\icon\\buttonThem.png");
        Image scaled_btnThanhToan = img_btnThanhToan.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnThanhToan = new ImageIcon(scaled_btnThanhToan);
         btnThanhToan.setIcon(img_btnThanhToan);
         btnThemVaoGio.setIcon(img_btnThanhToan);
         btnTaoHoaDon.setIcon(img_btnThanhToan);
         btnLuuTamHoaDon.setIcon(img_btnThanhToan);
         btnTinhHoaDon.setIcon(img_btnThanhToan);
         ImageIcon img_btnCapNhatSoLuong = new ImageIcon("D:\\TrenLop\\PTUD\\Phamarcy_Project\\src\\icon\\buttonCapNhat.png");
        Image scaled_btnCapNhatSoLuong = img_btnCapNhatSoLuong.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnCapNhatSoLuong = new ImageIcon(scaled_btnCapNhatSoLuong);
         btnCapNhatSoLuong.setIcon(img_btnCapNhatSoLuong);
        
         
         ImageIcon img_btnXoa = new ImageIcon("D:\\TrenLop\\PTUD\\Phamarcy_Project\\src\\icon\\buttonXoa.png");
        Image scaled_btnXoa = img_btnXoa.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnXoa = new ImageIcon(scaled_btnXoa);
         btnXoaKhoiGio.setIcon(img_btnXoa);
         
         ImageIcon img_btnLamMoi = new ImageIcon("D:\\TrenLop\\PTUD\\Phamarcy_Project\\src\\icon\\buttonLamMoi.png");
        Image scaled_btnLamMoi = img_btnLamMoi.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnLamMoi = new ImageIcon(scaled_btnLamMoi);
         btnLamMoiHoaDon.setIcon(img_btnLamMoi);
         
         spinnerModel = new SpinnerNumberModel(0, 0, 100, 1);
        jSpinner1.setModel(spinnerModel);
        jSpinner1.setEnabled(true);

        String[] cols_HoaDon = {"Mã hoá đơn", "Mã khách hàng", "Mã nhân viên", "Mã khuyến mãi", "Ngày lập", "Tiền khuyến mãi", "Tổng tiền", "Tiền thanh toán", "Tình trạng"};
        tableModel_HoaDon = new DefaultTableModel(cols_HoaDon, 0);
        table_HoaDon.setModel(tableModel_HoaDon);
        table_HoaDon.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        table_HoaDon.setInheritsPopupMenu(true);
        jScrollPane1.setViewportView(table_HoaDon);


        String[] cols_GioHang = { "Mã Thuốc", "Tên Thuốc", "Hoạt chất chính", "Nhóm thuốc", "Số lượng", "Giá gốc", "Giá bán", "Thành Tiền"};
        tableModel_GioHang = new DefaultTableModel(cols_GioHang, 0);
        table_gioHang.setModel(tableModel_GioHang);

        JComponent editor = jSpinner1.getEditor();
        if(editor instanceof JSpinner.DefaultEditor) {
            JTextField textField = ((JSpinner.DefaultEditor)editor).getTextField();
            textField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char typedChar=e.getKeyChar();
                    if(!Character.isDigit(typedChar)){
                        e.consume();
                    }

                }
                @Override
                public void keyReleased(KeyEvent e) {
                    try{
                        int val = Integer.parseInt(textField.getText());
                        spinnerModel.setValue(val);
                    }catch(NumberFormatException et){
                        JOptionPane.showMessageDialog(null, "Số lượng nhập phải là chữ số!");
                    }

                }
            });
            textField.addFocusListener(new FocusAdapter() {
                @Override
                public void focusLost(FocusEvent e) {
                    kiemTraSoLuongNhap();
                }
            });
        }
        importHoaDon();
         
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_SoDienThoaiKH = new JTextField();
        btnTimKiemHoaDonChuaThanhToan = new javax.swing.JButton();
        btnThanhToan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_HoaDon = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_MaSanPham = new JTextField();
        btnTimKiemSanPham = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jSpinner1 = new JSpinner();
        btnXoaKhoiGio = new javax.swing.JButton();
        btnThemVaoGio = new javax.swing.JButton();
        btnCapNhatSoLuong = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        lbl_tenThuoc = new javax.swing.JLabel();
        lbl_quyCach = new javax.swing.JLabel();
        lbl_donVi = new javax.swing.JLabel();
        lbl_hoatChat = new javax.swing.JLabel();
        lbl_nhomThuoc = new javax.swing.JLabel();
        lbl_nuoc = new javax.swing.JLabel();
        lbl_khuyenMai = new javax.swing.JLabel();
        lbl_donGia = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_gioHang = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txt_SoDienThoaiKH1 = new JTextField();
        btnTimKiemHoaDon = new javax.swing.JButton();
        btnLamMoiHoaDon = new javax.swing.JButton();
        btnLuuTamHoaDon = new javax.swing.JButton();
        btnTaoHoaDon = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbl_tienNhan = new JTextField();
        btnTinhHoaDon = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbl_MaKH = new javax.swing.JLabel();
        lbl_tongTien = new javax.swing.JLabel();
        lbl_tenKH = new javax.swing.JLabel();
        lbl_gioiTinh = new javax.swing.JLabel();
        lbl_diaChi = new javax.swing.JLabel();
        lbl_khuyenMaiHoaDon = new javax.swing.JLabel();
        lbl_tienThanhToan = new javax.swing.JLabel();
        lbl_tienTraLai = new javax.swing.JLabel();
        ck_tichLuy = new javax.swing.JCheckBox();
        jInternalFrame1 = new javax.swing.JInternalFrame();

        setBackground(new java.awt.Color(0, 102, 0));
        setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("QUẢN LÍ BÁN HÀNG");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Hóa Đơn Chưa Thanh Toán", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(15, 15));
        jPanel1.setRequestFocusEnabled(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Số Điện Thoại");

        txt_SoDienThoaiKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_SoDienThoaiKHActionPerformed(evt);
            }
        });

        btnTimKiemHoaDonChuaThanhToan.setBackground(new java.awt.Color(0, 102, 0));
        btnTimKiemHoaDonChuaThanhToan.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnTimKiemHoaDonChuaThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiemHoaDonChuaThanhToan.setText("Tìm Kiếm");
        btnTimKiemHoaDonChuaThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemHoaDonChuaThanhToanActionPerformed(evt);
            }
        });

        btnThanhToan.setBackground(new java.awt.Color(0, 102, 0));
        btnThanhToan.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        table_HoaDon.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Hóa Đơn", "Mã Khách Hàng", "Mã Nhân Viên", "Mã Khuyến Mãi", "Ngày Lập", "Tiền Khuyến Mãi", "Tổng Tiền", "Tiền Thanh Toán", "Tình Trạng"
            }
        ) {
            Class[] types = new Class [] {
                String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table_HoaDon.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        table_HoaDon.setInheritsPopupMenu(true);
        jScrollPane1.setViewportView(table_HoaDon);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txt_SoDienThoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnTimKiemHoaDonChuaThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_SoDienThoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiemHoaDonChuaThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Thông Tin Sản Phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã Sản Phẩm");

        btnTimKiemSanPham.setBackground(new java.awt.Color(0, 102, 0));
        btnTimKiemSanPham.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnTimKiemSanPham.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiemSanPham.setText("Tìm Kiếm");
        btnTimKiemSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemSanPhamActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Số lượng");

        jSpinner1.setToolTipText("");
        jSpinner1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnXoaKhoiGio.setBackground(new java.awt.Color(204, 0, 51));
        btnXoaKhoiGio.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnXoaKhoiGio.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaKhoiGio.setText(" Xóa khỏi giỏ");
        btnXoaKhoiGio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaKhoiGioActionPerformed(evt);
            }
        });

        btnThemVaoGio.setBackground(new java.awt.Color(0, 102, 0));
        btnThemVaoGio.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnThemVaoGio.setForeground(new java.awt.Color(255, 255, 255));
        btnThemVaoGio.setText("Thêm vào giỏ");
        btnThemVaoGio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemVaoGioActionPerformed(evt);
            }
        });

        btnCapNhatSoLuong.setBackground(new java.awt.Color(0, 102, 0));
        btnCapNhatSoLuong.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnCapNhatSoLuong.setForeground(new java.awt.Color(255, 255, 255));
        btnCapNhatSoLuong.setText("Cập nhật số lượng");
        btnCapNhatSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatSoLuongActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel19.setText("Tên Thuốc");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel20.setText("Hoạt Chất Chính");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel21.setText("Đơn Vị Tính");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel22.setText("Quy Cách Đóng Gói");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel23.setText("Nước Sản Xuất");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel24.setText("Nhóm Thuốc");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel25.setText("Khuyến Mãi");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel26.setText("Đơn Giá");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel27.setText("%");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel28.setText("VND");

        lbl_tenThuoc.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        lbl_quyCach.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        lbl_donVi.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        lbl_hoatChat.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        lbl_nhomThuoc.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        lbl_nuoc.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        lbl_khuyenMai.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        lbl_donGia.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_hoatChat, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_tenThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_quyCach, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_nuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_donGia, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txt_MaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnTimKiemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnThemVaoGio, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCapNhatSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnXoaKhoiGio, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(lbl_donVi, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(159, 159, 159)
                                .addComponent(lbl_nhomThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_khuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_MaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemVaoGio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhatSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaKhoiGio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addComponent(jLabel21)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(19, 19, 19)
                                    .addComponent(jLabel22))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel23))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lbl_quyCach, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(lbl_nuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_donVi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_khuyenMai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_tenThuoc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_nhomThuoc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_hoatChat, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel20))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lbl_donGia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel26)
                                                .addComponent(jLabel28)))))
                                .addGap(3, 3, 3)))))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Giỏ Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        table_gioHang.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Thuốc", "Tên Thuốc", "Hoạt chất chính", "Nhóm thuốc", "Số lượng", "Giá gốc", "Giá bán", "Thành Tiền"
            }
        ) {
            Class[] types = new Class [] {
                String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table_gioHang);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Hóa Đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Số Điện Thoại");

        btnTimKiemHoaDon.setBackground(new java.awt.Color(0, 102, 0));
        btnTimKiemHoaDon.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnTimKiemHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiemHoaDon.setText("Tìm Kiếm");
        btnTimKiemHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemHoaDonActionPerformed(evt);
            }
        });

        btnLamMoiHoaDon.setBackground(new java.awt.Color(0, 102, 0));
        btnLamMoiHoaDon.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnLamMoiHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoiHoaDon.setText("Làm Mới");
        btnLamMoiHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiHoaDonActionPerformed(evt);
            }
        });

        btnLuuTamHoaDon.setBackground(new java.awt.Color(0, 102, 0));
        btnLuuTamHoaDon.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnLuuTamHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnLuuTamHoaDon.setText("Lưu Tạm");
        btnLuuTamHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuTamHoaDonActionPerformed(evt);
            }
        });

        btnTaoHoaDon.setBackground(new java.awt.Color(0, 102, 0));
        btnTaoHoaDon.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnTaoHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnTaoHoaDon.setText("Tạo Hóa Đơn");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setText("Mã Khách Hàng");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel7.setText("Tên Khách Hàng");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel8.setText("Giới Tính");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel9.setText("Điểm Tích Lũy");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel10.setText("Tổng Tiền");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel11.setText("VND");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel12.setText("Khuyến Mãi");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel13.setText("%");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel14.setText("Tiền Thanh Toán");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel15.setText("VND");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel16.setText("Tiền Nhận");

        btnTinhHoaDon.setBackground(new java.awt.Color(0, 102, 0));
        btnTinhHoaDon.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnTinhHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnTinhHoaDon.setText("Tính");
        btnTinhHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTinhHoaDonActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel17.setText("Tiền Trả Lại");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel18.setText("VND");

        ck_tichLuy.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ck_tichLuy.setText("Sử dụng Điểm Tích Lũy");
        ck_tichLuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ck_tichLuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_MaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_tenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_SoDienThoaiKH1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(btnTimKiemHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(lbl_gioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_diaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(ck_tichLuy)
                                .addGap(42, 42, 42)
                                .addComponent(btnLamMoiHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLuuTamHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(lbl_tongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11)
                                .addGap(149, 149, 149)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_khuyenMaiHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel13))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(26, 26, 26)
                                .addComponent(lbl_tienNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(btnTinhHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_tienThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_tienTraLai, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel18))
                        .addGap(73, 73, 73))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_SoDienThoaiKH1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiemHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoiHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLuuTamHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ck_tichLuy))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_MaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7))
                    .addComponent(lbl_tenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_gioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_diaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(lbl_tongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(lbl_khuyenMaiHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(lbl_tienThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_tienNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(btnTinhHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel15))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_tienTraLai, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))))
                .addGap(5, 5, 5))
        );

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1259, Short.MAX_VALUE))
                        .addGap(83, 83, 83)
                        .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(532, 532, 532)
                        .addComponent(jLabel1)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(133, 133, 133))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(445, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_SoDienThoaiKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_SoDienThoaiKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SoDienThoaiKHActionPerformed

    private void btnTimKiemHoaDonChuaThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemHoaDonChuaThanhToanActionPerformed
        // TODO add your handling code here:
        timKiemHoaDon();
    }//GEN-LAST:event_btnTimKiemHoaDonChuaThanhToanActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        thanhToan();
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnTimKiemSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemSanPhamActionPerformed
        // TODO add your handling code here:
        String maSP=txt_MaSanPham.getText();
        if(maSP.isEmpty()){
            JOptionPane.showMessageDialog(this, "Mã sản phẩm không được để trống");
            return;
        }
        Thuoc thuocDTO=sp_bus.timSanPham(maSP);
        if(thuocDTO!=null){
            if(thuocDTO.getTrangThai().equals(TinhTrangSPEnum.HETHANG)){
                JOptionPane.showMessageDialog(this,"Sản phẩm đã hết hàng!");
            }
            if(thuocDTO.getTrangThai().equals(TinhTrangSPEnum.NGUNGBAN)){
                JOptionPane.showMessageDialog(this,"Sản phẩm đã ngừng bán!");
            }
            lbl_tenThuoc.setText(thuocDTO.getTenThuoc());
            lbl_hoatChat.setText(thuocDTO.getHoatChatChinh());
            lbl_donVi.setText(thuocDTO.getDonViTinh().getTenDonViTinh());
            lbl_quyCach.setText(thuocDTO.getQuyCachDongGoi());
            lbl_nhomThuoc.setText(thuocDTO.getNhomHangHoa().getTenNhomHang());
            lbl_nuoc.setText(thuocDTO.isThuocKeDon()?"Có":"Không");
            lbl_donGia.setText(convert.toMoney(thuocDTO.getDonGia()));
            if(thuocDTO.getChuongTrinhKhuyenMaiEntity()!=null){
                lbl_khuyenMai.setText(thuocDTO.getChuongTrinhKhuyenMaiEntity().getGiamGia()+"");
            }else{
                lbl_khuyenMai.setText("0");
            }
            jSpinner1.setEnabled(true);
            spinnerModel.setMinimum(0);
            spinnerModel.setMaximum(thuocDTO.getSoLuongTon());

        }
        else{
            JOptionPane.showMessageDialog(this,"Mã sản phẩm không tồn tại!");
        }
    }//GEN-LAST:event_btnTimKiemSanPhamActionPerformed

    private void btnXoaKhoiGioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaKhoiGioActionPerformed
        // TODO add your handling code here:
        xoaKhoiGioHang();
    }//GEN-LAST:event_btnXoaKhoiGioActionPerformed

    private void btnThemVaoGioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemVaoGioActionPerformed
        // TODO add your handling code here:
            // TODO add your handling code here:
        String maSP=txt_MaSanPham.getText();
        String tenSP=lbl_tenThuoc.getText();
        String hoatChat=lbl_hoatChat.getText();
        String donVi=lbl_donVi.getText();
        String quyCach=lbl_quyCach.getText();
        String nhomThuoc=lbl_nhomThuoc.getText();
        String nuoc=lbl_nuoc.getText();
        int soLuong=(int)jSpinner1.getValue();
        String donGia=lbl_donGia.getText();
        String khuyenMai=lbl_khuyenMai.getText();
        if(maSP.equals("")||tenSP.equals("")||hoatChat.equals("")||donVi.equals("")||quyCach.equals("")||nhomThuoc.equals("")||nuoc.equals("")||donGia.equals("")||khuyenMai.equals("")){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin sản phẩm");
            return;
        }
        if(!kiemTraSoLuongNhap()){
            return;
        }
        for (ChiTietHoaDon cthd:cthdList){
            if(cthd.getThuoc().getMaThuoc().equals(maSP)){
                JOptionPane.showMessageDialog(this, "Sản phẩm đã có trong giỏ hàng");
                return;
            }
        }
        Thuoc thuocDTO=new Thuoc();
        thuocDTO.setMaThuoc(maSP);
        thuocDTO.setTenThuoc(tenSP);
        thuocDTO.setHoatChatChinh(hoatChat);
        thuocDTO.setDonViTinh(new DonViTinh(sp_bus.timSanPham(maSP).getDonViTinh().getMaDonViTinh(),donVi));
        thuocDTO.setQuyCachDongGoi(sp_bus.timSanPham(maSP).getQuyCachDongGoi());
        thuocDTO.setNhomHangHoa(new NhomHangHoa(sp_bus.timSanPham(maSP).getNhomHangHoa().getMaNhomHang(),nhomThuoc));
        thuocDTO.setThuocKeDon(sp_bus.timSanPham(maSP).isThuocKeDon());
        thuocDTO.setDonGia(convert.toDouble(donGia));
        ChuongTrinhKhuyenMai ctkm=new ChuongTrinhKhuyenMai();
        ctkm.setGiamGia(Integer.parseInt(khuyenMai));
        thuocDTO.setChuongTrinhKhuyenMaiEntity(ctkm);
        ChiTietHoaDon cthd=new ChiTietHoaDon();
        cthd.setThuoc(thuocDTO);
        cthd.setSoLuong(soLuong);
        cthd.setGiaGoc();
        cthd.setGiaBan();
        cthd.setThanhTien();

        cthdList.add(cthd);
        importGioHang();
        txt_MaSanPham.setText("");
        spinnerModel.setValue(0);
        tinhTienGioHang();
        lbl_tenThuoc.setText("");
        lbl_hoatChat.setText("");
        lbl_donVi.setText("");
        lbl_quyCach.setText("");
        lbl_nhomThuoc.setText("");
        lbl_nuoc.setText("");
        lbl_donGia.setText("");
        lbl_khuyenMai.setText("");
    }//GEN-LAST:event_btnThemVaoGioActionPerformed
    private void importGioHang(){
        tableModel_GioHang.setRowCount(0);
        for(ChiTietHoaDon cthd:cthdList){
            tableModel_GioHang.addRow(new Object[]{
                cthd.getThuoc().getMaThuoc(),
                cthd.getThuoc().getTenThuoc(),
                cthd.getThuoc().getHoatChatChinh(),
                cthd.getThuoc().getNhomHangHoa().getTenNhomHang(),
                cthd.getSoLuong(),
                convert.toMoney(cthd.getGiaGoc()),
                convert.toMoney(cthd.getGiaBan()),
                convert.toMoney(cthd.getThanhTien())
            });
        }
    }
    
    public void capNhatSoLuong(){
        int row=table_gioHang.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần cập nhật số lượng");
            return;
        }
        if(!kiemTraSoLuongNhap()){
            return;
        }
        int soLuong=(int)jSpinner1.getValue();
        String maSP=table_gioHang.getValueAt(row, 0).toString();
        for(ChiTietHoaDon cthd:cthdList){
            if(cthd.getThuoc().getMaThuoc().equals(maSP)){
                cthd.setSoLuong(soLuong);
                cthd.setThanhTien();
                tableModel_GioHang.setValueAt(soLuong, row, 4);
                tableModel_GioHang.setValueAt(convert.toMoney(cthd.getThanhTien()), row, 7);
                break;
            }
        }
        tinhTienGioHang();
        table_gioHang.clearSelection();
        spinnerModel.setValue(1);
        jSpinner1.setEnabled(false);

    }
    public void tinhTienGioHang(){
        double tongTien=0;
        for(int i=0;i<table_gioHang.getRowCount();i++){
            double thanhTien=convert.toDouble(table_gioHang.getValueAt(i, 7).toString());
            tongTien+=thanhTien;
        }
        lbl_tongTien.setText(convert.toMoney(tongTien));
        ChuongTrinhKhuyenMai ctkm=ctkm_bus.kiemTraKhuyenMai(tongTien);
        if(ctkm!=null){
            lbl_khuyenMaiHoaDon.setText(ctkm.getGiamGia()+"");

            hoaDon.setChuongTrinhKM(ctkm);
        }
        else{
            lbl_khuyenMaiHoaDon.setText("0");
            hoaDon.setChuongTrinhKM(new ChuongTrinhKhuyenMai());
        }
        hoaDon.setTongTien(tongTien);
        hoaDon.setTienKhuyenMai();
        hoaDon.setTienThanhToan(false);


        double tienThanhToan= hoaDon.getTienThanhToan();
        lbl_tienThanhToan.setText(convert.toMoney(tienThanhToan));
    }
    public void tinhTien(){
        if(lbl_tienThanhToan.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this, "Tiền Thanh Toán chưa được tính");
            return;
        }
        String tienNhan=lbl_tienNhan.getText().trim();
        if(tienNhan.equals("")){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số tiền khách hàng trả");
            return;
        }
        try{
            Double tienNhanKH=Double.parseDouble(tienNhan);
            if(tienNhanKH>1000000000){
                JOptionPane.showMessageDialog(this, "Số tiền nhận tối đa là 1000000000");
                return;
            }
            double tienThanhToan=convert.toDouble(lbl_tienThanhToan.getText());
            if(tienNhanKH<tienThanhToan){
                JOptionPane.showMessageDialog(this, "Số tiền nhận phải lớn hơn hoặc bằng số tiền thanh toán");
                return;
            }
            double tienTraLai=tienNhanKH-tienThanhToan;
            lbl_tienTraLai.setText(convert.toMoney(tienTraLai));

        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Số tiền nhận phải là chữ số");
        }

    }
    public void xoaKhoiGioHang(){
        int row=table_gioHang.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(this,"Vui lòng chọn sản phẩm cần xóa");
            return;
        }
        String maSP=table_gioHang.getValueAt(row, 0).toString();
        ChiTietHoaDon chiTietHoaDon=new ChiTietHoaDon();
        for(ChiTietHoaDon cthd:cthdList){
            if(cthd.getThuoc().getMaThuoc().equals(maSP)){
                chiTietHoaDon=cthd;
                break;
            }
        }
        cthdList.remove(chiTietHoaDon);
        tableModel_GioHang.removeRow(row);
        spinnerModel.setValue(0);
        jSpinner1.setEnabled(false);
        lbl_tienNhan.setText("");
        lbl_tienTraLai.setText("");
        tinhTienGioHang();

    }
    public void timKiemKhachHang(){
        String soDienThoai = txt_SoDienThoaiKH1.getText().trim();
        if(soDienThoai.equals("")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại chưa nhập !");
            return;
        }
         khachHang = kh_bus.timKiemTheoSDT(soDienThoai);
        if(khachHang != null) {
            lbl_MaKH.setText(khachHang.getMaKhachHang());
            lbl_tenKH.setText(khachHang.getHoTen());
            lbl_gioiTinh.setText(khachHang.getGioiIinh()==1?"Nam":"Nữ");

            lbl_diaChi.setText(khachHang.getDiemTichLuy()+"");

            hoaDon.setKhachHang(khachHang);
        } else {
            JOptionPane.showMessageDialog(this, "Khách hàng không tồn tại !");
        }
    }
    private void btnCapNhatSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatSoLuongActionPerformed
        // TODO add your handling code here:
        capNhatSoLuong();
    }//GEN-LAST:event_btnCapNhatSoLuongActionPerformed

    private void btnTimKiemHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemHoaDonActionPerformed
        // TODO add your handling code here:
        timKiemKhachHang();
    }//GEN-LAST:event_btnTimKiemHoaDonActionPerformed
private void lamMoi(){
        txt_SoDienThoaiKH.setText("");
        txt_MaSanPham.setText("");
        lbl_tenThuoc.setText("");
        tableModel_HoaDon.setRowCount(0);
        lbl_hoatChat.setText("");
        lbl_donVi.setText("");
        lbl_quyCach.setText("");
        lbl_nhomThuoc.setText("");
        lbl_nuoc.setText("");
        lbl_donGia.setText("");
        lbl_khuyenMai.setText("");
        spinnerModel.setValue(0);
        ck_tichLuy.setSelected(false);
        jSpinner1.setEnabled(false);
        tableModel_GioHang.setRowCount(0);
        importHoaDon();
        hoaDon = new HoaDon();
        cthdList = new ArrayList<ChiTietHoaDon>();
        lbl_MaKH.setText("");
        txt_SoDienThoaiKH1.setText("");
        lbl_tenKH.setText("");
        lbl_gioiTinh.setText("");
        lbl_diaChi.setText("");
        lbl_tienNhan.setText("");
        lbl_tienTraLai.setText("");
        lbl_tongTien.setText("");
        lbl_khuyenMaiHoaDon.setText("");
        lbl_tienThanhToan.setText("");

}

    private void btnLamMoiHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiHoaDonActionPerformed
        // TODO add your handling code here:
        lamMoi();

    }//GEN-LAST:event_btnLamMoiHoaDonActionPerformed

    private void btnLuuTamHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuTamHoaDonActionPerformed
        // TODO add your handling code here:
        luuTam();
    }//GEN-LAST:event_btnLuuTamHoaDonActionPerformed

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        // TODO add your handling code here:
        int rowcount=table_gioHang.getRowCount();
        if(rowcount==0){
            JOptionPane.showMessageDialog(this, "Giỏ hàng trống");
            return;
        }
        if(lbl_tienTraLai.getText().equals("")||lbl_tienNhan.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Vui lòng tính tiền trước khi tạo hóa đơn");
            return;
        }
        if(hoaDon.getKhachHang()==null){
            hoaDon.setKhachHang(new KhachHang());
        }
        NhanVien nv=new NhanVien(Global.getMa());
        hoaDon.setNhanVien(nv);
        Date ngayLap=new Date();
        hoaDon.setNgayLapHD(new java.sql.Date(ngayLap.getTime()));
        for(ChiTietHoaDon cthd:cthdList){
            cthd.setHoaDon(hoaDon);
        }
        boolean kq=false;
        if(table_HoaDon.getSelectedRow()<0){
            hoaDon.setMaHD(hd_bus.getAutoIncrement());
            kq=hd_bus.themHoaDon(hoaDon,cthdList);

        }
        else{
            kq=hd_bus.themHoaDonLuuTam(hoaDon,cthdList);
            tableModel_HoaDon.removeRow(table_HoaDon.getSelectedRow());

        }
        if(kq){
            for(ChiTietHoaDon cthd:cthdList){
                boolean ketqua=sp_bus.capNhatSoLuongTonSauKhiTaoHD(cthd.getThuoc().getMaThuoc(),cthd.getSoLuong());
                if(!ketqua){
                    JOptionPane.showMessageDialog(this, "Cập nhật số lượng tồn thất bại");
                    return;
                }
            }
            double tienNhan=Double.parseDouble(lbl_tienNhan.getText().trim());
            double tienTraLai=convert.toDouble(lbl_tienTraLai.getText().trim());
            if(!ck_tichLuy.isSelected()){
                int newAccumulate=hoaDon.getKhachHang().getDiemTichLuy()+(int)(hoaDon.getTienThanhToan()*0.01);
                kh_bus.capNhatDiemTichLuy(hoaDon.getKhachHang().getMaKhachHang(), newAccumulate);
            }
            else{
                kh_bus.capNhatDiemTichLuy(hoaDon.getKhachHang().getMaKhachHang(), 0);
            }
            new ThongTinHoaDon_GUI(hoaDon,cthdList,tienNhan,tienTraLai).setVisible(true);
            lamMoi();
        }
        else{
            JOptionPane.showMessageDialog(this, "Tạo hóa đơn thất bại");
        }


    }//GEN-LAST:event_btnTaoHoaDonActionPerformed
    private void luuTam(){
        int rowcount=table_gioHang.getRowCount();
        if(rowcount==0){
            JOptionPane.showMessageDialog(this, "Giỏ hàng không được trống");
            return;
        }
        String soDienThoai=txt_SoDienThoaiKH1.getText().trim();
        String maKH=lbl_MaKH.getText().trim();
        if(soDienThoai.equals("")||maKH.equals("")){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại khách hàng");
            return;
        }

        NhanVien nv=new NhanVien(Global.getMa());
        hoaDon.setNhanVien(nv);
        Date ngayLap=new Date();
        hoaDon.setNgayLapHD(new java.sql.Date(ngayLap.getTime()));
        for(ChiTietHoaDon cthd:cthdList){
            cthd.setHoaDon(hoaDon);
        }

        int rowHD=table_HoaDon.getSelectedRow();
        if(rowHD>0){

            String maHD=table_HoaDon.getValueAt(rowHD, 0).toString();
            ArrayList<HoaDon> luutamList=hd_bus.timKiemHoaDonChuaThanhToan(soDienThoai);

            for(HoaDon hd:luutamList){
                if(hd.getMaHD().equals(maHD)){

                    boolean kq=hd_bus.capNhatHoaDonLuuTam(hoaDon,cthdList);

                    if(kq) {
                        JOptionPane.showMessageDialog(this, "Cập nhật hoá đơn lưu tạm thành công!");
                        lamMoi();
                    } else {
                        JOptionPane.showMessageDialog(this, "Cập nhật hoá đơn lưu tạm thất bại!");
                    }
                    return;

                }
            }
        }

    hoaDon.setMaHD(hd_bus.getAutoIncrement());

    boolean kq=hd_bus.luuTamHoaDon(hoaDon,cthdList);
    if(kq){
        JOptionPane.showMessageDialog(this, "Lưu tạm hóa đơn thành công");
        lamMoi();
    }
    else{
        JOptionPane.showMessageDialog(this, "Lưu tạm hóa đơn thất bại");
    }


    }
    private void timKiemHoaDon(){
        String sdt=txt_SoDienThoaiKH.getText();
        if(sdt.equals("")){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại khách hàng");
            return;
        }
        hdList=hd_bus.timKiemHoaDonChuaThanhToan(sdt);
        if(hdList!=null&& !hdList.isEmpty()){
            tableModel_HoaDon.setRowCount(0);
            for (HoaDon hd : hdList) {
                String[] data = {hd.getMaHD(), hd.getKhachHang().getMaKhachHang(), hd.getNhanVien().getMaNhanVien(), hd.getChuongTrinhKM().getMaCTKM(), hd.getNgayLapHD().toString(), convert.toMoney(hd.getTienKhuyenMai()), convert.toMoney(hd.getTongTien()), convert.toMoney(hd.getTienThanhToan()), hd.getTinhTrang()==1?"Đã thanh toán":"Chưa thanh toán"};
                tableModel_HoaDon.addRow(data);
            }

        }
        else{
            JOptionPane.showMessageDialog(this, "Số điện thoại không có hoá đơn nào chưa thanh toán!");
        }

    }
    private void thanhToan(){
        int row=table_HoaDon.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn cần thanh toán");
            return;
        }
        String maHD=table_HoaDon.getValueAt(row, 0).toString();
        for(HoaDon hd:hdList){
            if(hd.getMaHD().equals(maHD)){
                hoaDon=hd;
                break;
            }
        }
        txt_SoDienThoaiKH1.setText(hoaDon.getKhachHang().getSdt());
        lbl_MaKH.setText(hoaDon.getKhachHang().getMaKhachHang());
        lbl_tenKH.setText(hoaDon.getKhachHang().getHoTen());
        lbl_gioiTinh.setText(hoaDon.getKhachHang().getGioiIinh()==1?"Nam":"Nữ");
        lbl_diaChi.setText(hoaDon.getKhachHang().getDiemTichLuy()+"");
        cthdList=cthd_bus.getAllCTHDTheoMaHD(hoaDon.getMaHD());
        importGioHang();
        tinhTienGioHang();

    }

    private void btnTinhHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTinhHoaDonActionPerformed
        // TODO add your handling code here:
        tinhTien();
    }//GEN-LAST:event_btnTinhHoaDonActionPerformed

    private void ck_tichLuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ck_tichLuyActionPerformed
        // TODO add your handling code here:
        if(hoaDon.getKhachHang()!=null){
            if(ck_tichLuy.isSelected()){
                lbl_diaChi.setText("0");
                if(hoaDon.getKhachHang()!=null){
                    if(hoaDon.getKhachHang().getDiemTichLuy()>=100){
                        hoaDon.setTienKhuyenMai();
                        hoaDon.setTienThanhToan(true);
                        double tienThanhToan= hoaDon.getTienThanhToan();
                        lbl_tienThanhToan.setText(convert.toMoney(tienThanhToan));
                    }
                }
            }
            else{
                lbl_diaChi.setText(hoaDon.getKhachHang().getDiemTichLuy()+"");
                hoaDon.setTienKhuyenMai();
                hoaDon.setTienThanhToan(false);
                double tienThanhToan= hoaDon.getTienThanhToan();
                lbl_tienThanhToan.setText(convert.toMoney(tienThanhToan));
            }
        }
    }//GEN-LAST:event_ck_tichLuyActionPerformed

    private boolean kiemTraSoLuongNhap(){
        Object val=jSpinner1.getValue();
        if(val instanceof Number){
            int soLuong=((Number) val).intValue();
            Object slMax=spinnerModel.getMaximum();
            if(soLuong<=0){
                JOptionPane.showMessageDialog(this, "Số lượng nhập phải lớn hơn 0");
                return false;
            }else if(soLuong>(int)slMax){
                JOptionPane.showMessageDialog(this, "Số lượng nhập phải nhỏ hơn hoặc bằng "+slMax);
                return false;
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Số lượng nhập phải là chữ số");
            return false;
        }
        return true;
    }
    private void importHoaDon(){
        tableModel_HoaDon.setRowCount(0);
        hdList=hd_bus.getAllHDChuaThanhToan();
        for(HoaDon hd:hdList){
            String[] data = {hd.getMaHD(), hd.getKhachHang().getMaKhachHang(), hd.getNhanVien().getMaNhanVien(), hd.getChuongTrinhKM().getMaCTKM(), hd.getNgayLapHD().toString(), convert.toMoney(hd.getTienKhuyenMai()), convert.toMoney(hd.getTongTien()), convert.toMoney(hd.getTienThanhToan()), hd.getTinhTrang()==1?"Đã thanh toán":"Chưa thanh toán"};
            tableModel_HoaDon.addRow(data);
        }



    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhatSoLuong;
    private javax.swing.JButton btnLamMoiHoaDon;
    private javax.swing.JButton btnLuuTamHoaDon;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThemVaoGio;
    private javax.swing.JButton btnTimKiemHoaDon;
    private javax.swing.JButton btnTimKiemHoaDonChuaThanhToan;
    private javax.swing.JButton btnTimKiemSanPham;
    private javax.swing.JButton btnTinhHoaDon;
    private javax.swing.JButton btnXoaKhoiGio;
    private javax.swing.JCheckBox ck_tichLuy;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private JSpinner jSpinner1;
    private javax.swing.JLabel lbl_MaKH;
    private javax.swing.JLabel lbl_diaChi;
    private javax.swing.JLabel lbl_donGia;
    private javax.swing.JLabel lbl_donVi;
    private javax.swing.JLabel lbl_gioiTinh;
    private javax.swing.JLabel lbl_hoatChat;
    private javax.swing.JLabel lbl_khuyenMai;
    private javax.swing.JLabel lbl_khuyenMaiHoaDon;
    private javax.swing.JLabel lbl_nhomThuoc;
    private javax.swing.JLabel lbl_nuoc;
    private javax.swing.JLabel lbl_quyCach;
    private javax.swing.JLabel lbl_tenKH;
    private javax.swing.JLabel lbl_tenThuoc;
    private JTextField lbl_tienNhan;
    private javax.swing.JLabel lbl_tienThanhToan;
    private javax.swing.JLabel lbl_tienTraLai;
    private javax.swing.JLabel lbl_tongTien;
    private javax.swing.JTable table_HoaDon;
    private javax.swing.JTable table_gioHang;
    private JTextField txt_MaSanPham;
    private JTextField txt_SoDienThoaiKH;
    private JTextField txt_SoDienThoaiKH1;
    // End of variables declaration//GEN-END:variables
}

