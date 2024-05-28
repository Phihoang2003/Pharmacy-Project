/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;


import java.awt.Color;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.logging.*;
import DTO.ChiTietHoaDon;
import DTO.HoaDon;
import utils.ConvertDoubleToMoney;
import utils.ExportToPDF;
//import utils.ExportToPDF;

/**
 *
 * @author Admin
 */
public class ThongTinHoaDon_GUI extends javax.swing.JFrame {

    private HoaDon hoaDon;
    private ArrayList<ChiTietHoaDon> cthdList;
    private double tienNhan, tienTraLai;
    private ConvertDoubleToMoney convert = new ConvertDoubleToMoney();
    private DefaultTableModel tableModel;
            
    public ThongTinHoaDon_GUI(HoaDon hoaDon, ArrayList<ChiTietHoaDon> cthdList, double tienNhan, double tienTraLai) {
        this.hoaDon = hoaDon;
        this.cthdList = cthdList;
        this.tienNhan = tienNhan;
        this.tienTraLai = tienTraLai;
        initComponents();
        setLocationRelativeTo(null);
        
        lbl_MaHoaDon.setText(hoaDon.getMaHD());
        lbl_MaNhanVien.setText(hoaDon.getNhanVien().getMaNhanVien());
        lbl_TenKhachHang.setText(hoaDon.getKhachHang().getHoTen());
        lbl_SoDienThoai.setText(hoaDon.getKhachHang().getSdt());
        lbl_NgayLap.setText(hoaDon.getNgayLapHD().toString());
        
        lbl_TongTien.setText(convert.toMoney(hoaDon.getTongTien()));
        if(hoaDon.getChuongTrinhKM() != null) {
            lbl_KhuyenMai.setText(hoaDon.getChuongTrinhKM().getGiamGia()+"");    
        } else {
            lbl_KhuyenMai.setText("0");
        }
        lbl_TienThanhToan.setText(convert.toMoney(hoaDon.getTienThanhToan()));
        lbl_TienNhan.setText(convert.toMoney(tienNhan));
        lbl_TienTraLai.setText(convert.toMoney(tienTraLai));
        
        String[] cols = {"Tên sản phẩm", "Đơn vị tính", "Số lượng", "Đơn giá", "Thành tiền"};
        tableModel = new DefaultTableModel(cols, 0);
        table.setModel(tableModel);
        
        for (ChiTietHoaDon cthd : cthdList) {
            String[] data = {cthd.getThuoc().getTenThuoc(), cthd.getThuoc().getDonViTinh().getTenDonViTinh(), cthd.getSoLuong()+"", convert.toMoney(cthd.getGiaBan()), convert.toMoney(cthd.getThanhTien())};
            tableModel.addRow(data);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_MaHoaDon = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_TenKhachHang = new javax.swing.JLabel();
        lbl_NgayLap = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_SoDienThoai = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbl_MaNhanVien = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn_close = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lbl_TienNhan = new javax.swing.JLabel();
        lbl_TienTraLai = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lbl_TienThanhToan = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        btn_XuatHoaDon = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        lbl_KhuyenMai = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbl_TongTien = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel1.setText("THÔNG TIN HOÁ ĐƠN");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(317, 40, -1, 40));

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 1, 16)); // NOI18N
        jLabel2.setText("Mã hoá đơn");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 98, 90, -1));

        lbl_MaHoaDon.setFont(new java.awt.Font("Bahnschrift", 2, 16)); // NOI18N
        getContentPane().add(lbl_MaHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 120, 20));

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 1, 16)); // NOI18N
        jLabel4.setText("Tên khách hàng");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        lbl_TenKhachHang.setFont(new java.awt.Font("Bahnschrift", 2, 16)); // NOI18N
        getContentPane().add(lbl_TenKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 200, 20));

        lbl_NgayLap.setFont(new java.awt.Font("Bahnschrift", 2, 16)); // NOI18N
        getContentPane().add(lbl_NgayLap, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 100, 120, 20));

        jLabel8.setFont(new java.awt.Font("Bahnschrift", 1, 16)); // NOI18N
        jLabel8.setText("Số điện thoại");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(587, 130, 110, 30));

        lbl_SoDienThoai.setFont(new java.awt.Font("Bahnschrift", 2, 16)); // NOI18N
        getContentPane().add(lbl_SoDienThoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 130, 120, 30));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tên thuốc", "Đơn vị tính", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setEnabled(false);
        table.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(30);
            table.getColumnModel().getColumn(2).setPreferredWidth(20);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 174, 811, 300));

        jLabel10.setFont(new java.awt.Font("Bahnschrift", 1, 16)); // NOI18N
        jLabel10.setText("Tổng tiền");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 492, 109, 30));

        jLabel18.setFont(new java.awt.Font("Bahnschrift", 1, 16)); // NOI18N
        jLabel18.setText("Tiền nhận");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(498, 524, 150, 30));

        jLabel14.setFont(new java.awt.Font("Bahnschrift", 1, 16)); // NOI18N
        jLabel14.setText("Mã nhân viên");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 100, -1));

        lbl_MaNhanVien.setFont(new java.awt.Font("Bahnschrift", 2, 16)); // NOI18N
        getContentPane().add(lbl_MaNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, 120, 20));

        jLabel24.setFont(new java.awt.Font("Bahnschrift", 2, 16)); // NOI18N
        jLabel24.setText("VND");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(811, 524, 40, 30));

        jPanel1.setBackground(new java.awt.Color(187, 205, 197));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_close.setText("X");
        btn_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_closeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_closeMouseExited(evt);
            }
        });
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 822, Short.MAX_VALUE)
                .addComponent(btn_close, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_close, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 30));

        jPanel3.setBackground(new java.awt.Color(187, 205, 197));
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

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 740, 890, 20));

        jLabel6.setFont(new java.awt.Font("Bahnschrift", 1, 16)); // NOI18N
        jLabel6.setText("Ngày lập");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(587, 98, 130, -1));

        lbl_TienNhan.setFont(new java.awt.Font("Bahnschrift", 2, 16)); // NOI18N
        getContentPane().add(lbl_TienNhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 520, 120, 30));

        lbl_TienTraLai.setFont(new java.awt.Font("Bahnschrift", 2, 16)); // NOI18N
        getContentPane().add(lbl_TienTraLai, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 560, 120, 20));

        jLabel16.setFont(new java.awt.Font("Bahnschrift", 1, 16)); // NOI18N
        jLabel16.setText("Tiền phải thanh toán");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(498, 492, -1, 30));

        jLabel13.setFont(new java.awt.Font("Bahnschrift", 2, 16)); // NOI18N
        jLabel13.setText("VND");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(811, 492, 40, 30));

        jLabel20.setFont(new java.awt.Font("Bahnschrift", 1, 16)); // NOI18N
        jLabel20.setText("Tiền trả lại");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(498, 556, 150, 30));

        jLabel25.setFont(new java.awt.Font("Bahnschrift", 2, 16)); // NOI18N
        jLabel25.setText("VND");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(811, 556, 40, 30));

        lbl_TienThanhToan.setBackground(new java.awt.Color(255, 255, 255));
        lbl_TienThanhToan.setFont(new java.awt.Font("Bahnschrift", 2, 16)); // NOI18N
        getContentPane().add(lbl_TienThanhToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 490, 120, 20));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel22.setFont(new java.awt.Font("Bahnschrift", 1, 22)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Hẹn gặp lại quý khách lần sau!");

        jLabel23.setBackground(new java.awt.Color(102, 0, 255));
        jLabel23.setFont(new java.awt.Font("Bahnschrift", 1, 22)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Cảm ơn quý khách đã mua hàng tại cửa hàng của chúng tôi!");

        btn_XuatHoaDon.setBackground(new java.awt.Color(0, 51, 51));
        btn_XuatHoaDon.setFont(new java.awt.Font("Bahnschrift", 1, 15)); // NOI18N
        btn_XuatHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btn_XuatHoaDon.setText("Xuất hoá đơn");
        btn_XuatHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XuatHoaDonActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Bahnschrift", 1, 16)); // NOI18N
        jLabel12.setText("Khuyến mãi");

        lbl_KhuyenMai.setFont(new java.awt.Font("Bahnschrift", 2, 16)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Bahnschrift", 2, 16)); // NOI18N
        jLabel15.setText("%");

        lbl_TongTien.setFont(new java.awt.Font("Bahnschrift", 2, 16)); // NOI18N

        jLabel26.setFont(new java.awt.Font("Bahnschrift", 2, 16)); // NOI18N
        jLabel26.setText("VND");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(374, 374, 374)
                                .addComponent(btn_XuatHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(lbl_KhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(lbl_TongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(469, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_TongTien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(lbl_KhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addComponent(btn_XuatHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 890, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_XuatHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XuatHoaDonActionPerformed
        btn_XuatHoaDon.setVisible(false);
        jPanel1.setBackground(Color.white);
        jPanel2.setBackground(Color.white);
        jPanel3.setBackground(Color.white);
        
        String maHD = lbl_MaHoaDon.getText().trim();
        ExportToPDF.exportToPDF(this, "src//pdf//thongtinhoadon"+maHD+".pdf");
        dispose();
    }//GEN-LAST:event_btn_XuatHoaDonActionPerformed

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_closeActionPerformed

    private void btn_closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_closeMouseEntered
        btn_close.setBackground(Color.red);
    }//GEN-LAST:event_btn_closeMouseEntered

    private void btn_closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_closeMouseExited
        btn_close.setBackground(Color.white);
    }//GEN-LAST:event_btn_closeMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_XuatHoaDon;
    private javax.swing.JButton btn_close;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_KhuyenMai;
    private javax.swing.JLabel lbl_MaHoaDon;
    private javax.swing.JLabel lbl_MaNhanVien;
    private javax.swing.JLabel lbl_NgayLap;
    private javax.swing.JLabel lbl_SoDienThoai;
    private javax.swing.JLabel lbl_TenKhachHang;
    private javax.swing.JLabel lbl_TienNhan;
    private javax.swing.JLabel lbl_TienThanhToan;
    private javax.swing.JLabel lbl_TienTraLai;
    private javax.swing.JLabel lbl_TongTien;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
