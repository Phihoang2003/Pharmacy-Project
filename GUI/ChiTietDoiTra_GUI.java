/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import javax.swing.table.DefaultTableModel;

import BUS.ChiTietDoiTra_bus;
import BUS.DoiTra_bus;
import DTO.ChiTietDoiTra;
import DTO.DoiTra;
import utils.ConvertDoubleToMoney;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ChiTietDoiTra_GUI extends javax.swing.JFrame {

    private String maDT;
    private DefaultTableModel tableModel;
    private DoiTra_bus dt_bus=new DoiTra_bus();
    private ChiTietDoiTra_bus ctdt_bus=new ChiTietDoiTra_bus();
    private ConvertDoubleToMoney convert = new ConvertDoubleToMoney();
    
    public ChiTietDoiTra_GUI(String maDT) {
        this.maDT = maDT;
        initComponents();
        setLocationRelativeTo(null);
        
        // import data
        String[] cols = {"Mã", "Tên sản phẩm", "Nhóm thuốc", "Hạn sử dụng", "Số lượng", "Giá bán", "Thành tiền"};
        tableModel = new DefaultTableModel(cols, 0);
        table_DoiTra.setModel(tableModel);
        table_DoiTra.setEnabled(false);

        DoiTra dt = dt_bus.getDoiTraTheoMa(maDT);
        if(dt != null) {
            lbl_MaDoiTra.setText(dt.getMaDT());
            lbl_MaNhanVien.setText(dt.getNhanVien().getMaNhanVien());
            if(dt.getHoaDon().getKhachHang() != null) {
                lbl_TenKhachHang.setText(dt.getHoaDon().getKhachHang().getHoTen());
                lbl_SoDienThoai.setText(dt.getHoaDon().getKhachHang().getSdt());
            } else {
                lbl_TenKhachHang.setText("");
                lbl_SoDienThoai.setText("");
            }
            lbl_NgayLap.setText(dt.getThoiGianDoiTra().toString());
            lbl_HinhThuc.setText(dt.getHinhThucDoiTra().toString());
            lbl_TienHoanTra.setText(convert.toMoney(dt.getTongTien()));

            ArrayList<ChiTietDoiTra> ctdtList = ctdt_bus.getAllCTDTTheoMaDT(maDT);
            for (ChiTietDoiTra ctdt : ctdtList) {
                String[] data = {ctdt.getSanPham().getMaThuoc(), ctdt.getSanPham().getTenThuoc(), ctdt.getSanPham().getNhomHangHoa().getTenNhomHang(), ctdt.getSanPham().getHanSuDung().toString(), ctdt.getSoLuong()+"", convert.toMoney(ctdt.getGiaBan()), convert.toMoney(ctdt.getThanhTien())};
                tableModel.addRow(data);
            }
        }
        
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table_DoiTra = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        lbl_TienHoanTra = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lbl_HinhThuc = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_MaDoiTra = new javax.swing.JLabel();
        lbl_TenKhachHang = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_MaNhanVien = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_NgayLap = new javax.swing.JLabel();
        lbl_SoDienThoai = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_DoiTra.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Tên sản phẩm", "Hoạt chất chính", "Đơn vị tính", "Số lượng", "Giá bán", "Thành tiền"
            }
        ) {
            Class[] types = new Class [] {
                String.class, String.class, String.class, String.class, Integer.class, Double.class, Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table_DoiTra);
        if (table_DoiTra.getColumnModel().getColumnCount() > 0) {
            table_DoiTra.getColumnModel().getColumn(1).setPreferredWidth(200);
            table_DoiTra.getColumnModel().getColumn(2).setPreferredWidth(20);
            table_DoiTra.getColumnModel().getColumn(3).setPreferredWidth(50);
            table_DoiTra.getColumnModel().getColumn(4).setPreferredWidth(20);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 811, 280));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setText("Tiền hoàn trả");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 503, 114, -1));

        lbl_TienHoanTra.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        getContentPane().add(lbl_TienHoanTra, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 503, 120, 20));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        jLabel13.setText("VND");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, 503, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel20.setText("Hình thức đổi trả");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 468, -1, -1));

        lbl_HinhThuc.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        getContentPane().add(lbl_HinhThuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 468, 120, 20));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 888, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 20));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("Tên khách hàng");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Mã đổi trả");

        lbl_MaDoiTra.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        lbl_MaDoiTra.setText(" ");

        lbl_TenKhachHang.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Mã nhân viên");

        lbl_MaNhanVien.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setText("Ngày lập");

        lbl_NgayLap.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N

        lbl_SoDienThoai.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Số điện thoại");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("THÔNG TIN CHI TIẾT ĐỔI TRẢ");

        jButton1.setBackground(new java.awt.Color(0, 51, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Xác nhận");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_MaDoiTra, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_MaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_NgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_TenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(258, 258, 258)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_SoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(370, 370, 370)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(lbl_MaDoiTra)
                    .addComponent(jLabel3)
                    .addComponent(lbl_MaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(lbl_NgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(lbl_TenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(lbl_SoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 449, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 890, 640));

        jPanel3.setBackground(new java.awt.Color(255,255,255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 888, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 660, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_HinhThuc;
    private javax.swing.JLabel lbl_MaDoiTra;
    private javax.swing.JLabel lbl_MaNhanVien;
    private javax.swing.JLabel lbl_NgayLap;
    private javax.swing.JLabel lbl_SoDienThoai;
    private javax.swing.JLabel lbl_TenKhachHang;
    private javax.swing.JLabel lbl_TienHoanTra;
    private javax.swing.JTable table_DoiTra;
    // End of variables declaration//GEN-END:variables
}
