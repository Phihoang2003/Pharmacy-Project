package GUI;


import java.awt.Image;
import javax.swing.ImageIcon;

import javax.swing.table.DefaultTableModel;

public class QuanLyDoiTra_JPanel extends javax.swing.JPanel {
    
    private DefaultTableModel tableModel;
    
    
    public QuanLyDoiTra_JPanel() {
        initComponents();
        setBounds(0, 0, 1173, 699);
        
        ImageIcon img_btnTimKiem = new ImageIcon("D:\\TrenLop\\PTUD\\Phamarcy_Project\\src\\icon\\buttonTimKiem.png");
        Image scaled_btnTimKiem = img_btnTimKiem.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnTimKiem = new ImageIcon(scaled_btnTimKiem);
        btn_TimKiem.setIcon(img_btnTimKiem);
        
        ImageIcon img_btnXemChiTiet = new ImageIcon("D:\\TrenLop\\PTUD\\Phamarcy_Project\\src\\icon\\buttonXemChiTiet.png");
        Image scaled_btnXemChiTiet = img_btnXemChiTiet.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnXemChiTiet = new ImageIcon(scaled_btnXemChiTiet);
        btn_XemChiTiet.setIcon(img_btnXemChiTiet);
        
        ImageIcon img_btnLamMoi = new ImageIcon("D:\\TrenLop\\PTUD\\Phamarcy_Project\\src\\icon\\buttonLamMoi.png");
        Image scaled_btnLamMoi = img_btnLamMoi.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnLamMoi = new ImageIcon(scaled_btnLamMoi);
        btn_LamMoi.setIcon(img_btnLamMoi);
        
        // Table
        String[] cols = {"Mã đơn đổi trả", "Mã hoá đơn", "Mã nhân viên", "Ngày lập", "Hình thức đổi trả", "Tiền trả lại"};
        tableModel = new DefaultTableModel(cols, 0);
        table_DanhSachDoiTra.setModel(tableModel);
//        table_DanhSachDoiTra.setEdi;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Jpanel_ThaoTac = new javax.swing.JPanel();
        lbl_MaHoaDon = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_MaDonDoiTra = new javax.swing.JTextField();
        jdc_NgayLap = new com.toedter.calendar.JDateChooser();
        btn_TimKiem = new javax.swing.JButton();
        btn_LamMoi = new javax.swing.JButton();
        btn_XemChiTiet = new javax.swing.JButton();
        Jpanel_Table = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_DanhSachDoiTra = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1020, 700));
        setPreferredSize(new java.awt.Dimension(1000, 640));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Jpanel_ThaoTac.setBackground(new java.awt.Color(255, 255, 255));
        Jpanel_ThaoTac.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Các thao tác", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        Jpanel_ThaoTac.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_MaHoaDon.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbl_MaHoaDon.setText("Mã đơn đổi trả");
        Jpanel_ThaoTac.add(lbl_MaHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 120, 20));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel1.setText("Ngày Lập");
        Jpanel_ThaoTac.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 60, 150, 20));

        txt_MaDonDoiTra.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txt_MaDonDoiTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_MaDonDoiTraActionPerformed(evt);
            }
        });
        Jpanel_ThaoTac.add(txt_MaDonDoiTra, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 200, 30));
        Jpanel_ThaoTac.add(jdc_NgayLap, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 200, 30));

        btn_TimKiem.setBackground(new java.awt.Color(0, 51, 51));
        btn_TimKiem.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btn_TimKiem.setForeground(new java.awt.Color(255, 255, 255));
        btn_TimKiem.setText("Tìm kiếm");
        btn_TimKiem.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_TimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TimKiemActionPerformed(evt);
            }
        });
        Jpanel_ThaoTac.add(btn_TimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 120, 30));

        btn_LamMoi.setBackground(new java.awt.Color(0, 51, 51));
        btn_LamMoi.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btn_LamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btn_LamMoi.setText("Làm mới");
        btn_LamMoi.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_LamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LamMoiActionPerformed(evt);
            }
        });
        Jpanel_ThaoTac.add(btn_LamMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 20, 120, 30));

        btn_XemChiTiet.setBackground(new java.awt.Color(0, 51, 51));
        btn_XemChiTiet.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btn_XemChiTiet.setForeground(java.awt.Color.white);
        btn_XemChiTiet.setText("Xem chi tiết");
        btn_XemChiTiet.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_XemChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XemChiTietActionPerformed(evt);
            }
        });
        Jpanel_ThaoTac.add(btn_XemChiTiet, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 140, 30));

        add(Jpanel_ThaoTac, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 100));

        Jpanel_Table.setBackground(new java.awt.Color(255, 255, 255));
        Jpanel_Table.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Danh sách đơn đổi trả", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        Jpanel_Table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Jpanel_Table.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_DanhSachDoiTra.setFocusable(false);
        jScrollPane1.setViewportView(table_DanhSachDoiTra);

        Jpanel_Table.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 1180, 590));

        add(Jpanel_Table, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1210, 620));
    }// </editor-fold>//GEN-END:initComponents

    private void txt_MaDonDoiTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_MaDonDoiTraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MaDonDoiTraActionPerformed

    private void btn_LamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LamMoiActionPerformed
        txt_MaDonDoiTra.setText("");
        jdc_NgayLap.setDate(null);
        
    }//GEN-LAST:event_btn_LamMoiActionPerformed

    private void btn_XemChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XemChiTietActionPerformed
        

    }//GEN-LAST:event_btn_XemChiTietActionPerformed

    private void btn_TimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TimKiemActionPerformed
        
    }//GEN-LAST:event_btn_TimKiemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Jpanel_Table;
    private javax.swing.JPanel Jpanel_ThaoTac;
    private javax.swing.JButton btn_LamMoi;
    private javax.swing.JButton btn_TimKiem;
    private javax.swing.JButton btn_XemChiTiet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdc_NgayLap;
    private javax.swing.JLabel lbl_MaHoaDon;
    private javax.swing.JTable table_DanhSachDoiTra;
    private javax.swing.JTextField txt_MaDonDoiTra;
    // End of variables declaration//GEN-END:variables
    
    
}
