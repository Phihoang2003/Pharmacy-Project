package GUI;

import BUS.DoiTra_bus;
import DTO.DoiTra;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class QuanLyDoiTra_JPanel extends JPanel {
    
    private DefaultTableModel tableModel;
    private DoiTra_bus dt_bus = new DoiTra_bus();
    
    public QuanLyDoiTra_JPanel() {
        initComponents();
        setBounds(0, 0, 1173, 699);
        
        ImageIcon img_btnTimKiem = new ImageIcon("icon/buttonTimKiem.png");
        Image scaled_btnTimKiem = img_btnTimKiem.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnTimKiem = new ImageIcon(scaled_btnTimKiem);
        btn_TimKiem.setIcon(img_btnTimKiem);
        
        ImageIcon img_btnXemChiTiet = new ImageIcon("icon/buttonXemChiTiet.png");
        Image scaled_btnXemChiTiet = img_btnXemChiTiet.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnXemChiTiet = new ImageIcon(scaled_btnXemChiTiet);
        btn_XemChiTiet.setIcon(img_btnXemChiTiet);
        
        ImageIcon img_btnLamMoi = new ImageIcon("icon/buttonLamMoi.png");
        Image scaled_btnLamMoi = img_btnLamMoi.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnLamMoi = new ImageIcon(scaled_btnLamMoi);
        btn_LamMoi.setIcon(img_btnLamMoi);
        
        // Table
        String[] cols = {"Mã đơn đổi trả", "Mã hoá đơn", "Mã nhân viên", "Ngày lập", "Hình thức đổi trả", "Tiền trả lại"};
        tableModel = new DefaultTableModel(cols, 0);
        table_DanhSachDoiTra.setModel(tableModel);
//        table_DanhSachDoiTra.setEdi;
        importDoiTra();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Jpanel_ThaoTac = new JPanel();
        lbl_MaHoaDon = new JLabel();
        jLabel1 = new JLabel();
        txt_MaDonDoiTra = new JTextField();
        jdc_NgayLap = new com.toedter.calendar.JDateChooser();
        btn_TimKiem = new JButton();
        btn_LamMoi = new JButton();
        btn_XemChiTiet = new JButton();
        Jpanel_Table = new JPanel();
        jScrollPane1 = new JScrollPane();
        table_DanhSachDoiTra = new JTable();

        setBackground(new Color(22, 97, 86));
        setMinimumSize(new Dimension(1020, 700));
        setPreferredSize(new Dimension(1000, 640));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Jpanel_ThaoTac.setBackground(new Color(22, 97, 86));
        Jpanel_ThaoTac.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)), "Các thao tác", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new Font("Bahnschrift", 1, 14), new Color(255, 255, 255))); // NOI18N
        Jpanel_ThaoTac.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_MaHoaDon.setBackground(new Color(255, 255, 255));
        lbl_MaHoaDon.setFont(new Font("Bahnschrift", 1, 16)); // NOI18N
        lbl_MaHoaDon.setForeground(new Color(255, 255, 255));
        lbl_MaHoaDon.setText("Mã đơn đổi trả");
        Jpanel_ThaoTac.add(lbl_MaHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 120, 20));

        jLabel1.setFont(new Font("Bahnschrift", 1, 16)); // NOI18N
        jLabel1.setForeground(new Color(255, 255, 255));
        jLabel1.setText("Ngày Lập");
        Jpanel_ThaoTac.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 60, 150, 20));

        txt_MaDonDoiTra.setFont(new Font("Bahnschrift", 0, 16)); // NOI18N
        txt_MaDonDoiTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_MaDonDoiTraActionPerformed(evt);
            }
        });
        Jpanel_ThaoTac.add(txt_MaDonDoiTra, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 200, 30));
        Jpanel_ThaoTac.add(jdc_NgayLap, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 200, 30));

        btn_TimKiem.setBackground(new Color(0, 51, 51));
        btn_TimKiem.setFont(new Font("Bahnschrift", 1, 15)); // NOI18N
        btn_TimKiem.setForeground(new Color(255, 255, 255));
        btn_TimKiem.setText("Tìm kiếm");
        btn_TimKiem.setHorizontalTextPosition(SwingConstants.RIGHT);
        btn_TimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TimKiemActionPerformed(evt);
            }
        });
        Jpanel_ThaoTac.add(btn_TimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 120, 30));

        btn_LamMoi.setBackground(new Color(0, 51, 51));
        btn_LamMoi.setFont(new Font("Bahnschrift", 1, 15)); // NOI18N
        btn_LamMoi.setForeground(new Color(255, 255, 255));
        btn_LamMoi.setText("Làm mới");
        btn_LamMoi.setHorizontalTextPosition(SwingConstants.RIGHT);
        btn_LamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LamMoiActionPerformed(evt);
            }
        });
        Jpanel_ThaoTac.add(btn_LamMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 20, 120, 30));

        btn_XemChiTiet.setBackground(new Color(0, 51, 51));
        btn_XemChiTiet.setFont(new Font("Bahnschrift", 1, 15)); // NOI18N
        btn_XemChiTiet.setForeground(Color.white);
        btn_XemChiTiet.setText("Xem chi tiết");
        btn_XemChiTiet.setHorizontalTextPosition(SwingConstants.RIGHT);
        btn_XemChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XemChiTietActionPerformed(evt);
            }
        });
        Jpanel_ThaoTac.add(btn_XemChiTiet, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 140, 30));

        add(Jpanel_ThaoTac, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1260, 100));

        Jpanel_Table.setBackground(new Color(22, 97, 86));
        Jpanel_Table.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)), "Danh sách đơn đổi trả", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new Font("Bahnschrift", 1, 14), new Color(255, 255, 255))); // NOI18N
        Jpanel_Table.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        Jpanel_Table.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_DanhSachDoiTra.setFocusable(false);
        jScrollPane1.setViewportView(table_DanhSachDoiTra);

        Jpanel_Table.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 1240, 550));

        add(Jpanel_Table, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1260, 580));
    }// </editor-fold>//GEN-END:initComponents

    private void txt_MaDonDoiTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_MaDonDoiTraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MaDonDoiTraActionPerformed

    private void btn_LamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LamMoiActionPerformed
        txt_MaDonDoiTra.setText("");
        jdc_NgayLap.setDate(null);
        importDoiTra();
    }//GEN-LAST:event_btn_LamMoiActionPerformed

    private void btn_XemChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XemChiTietActionPerformed
        xemChiTiet();

    }//GEN-LAST:event_btn_XemChiTietActionPerformed

    private void btn_TimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TimKiemActionPerformed
        timKiemDoiTra();
    }//GEN-LAST:event_btn_TimKiemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JPanel Jpanel_Table;
    private JPanel Jpanel_ThaoTac;
    private JButton btn_LamMoi;
    private JButton btn_TimKiem;
    private JButton btn_XemChiTiet;
    private JLabel jLabel1;
    private JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdc_NgayLap;
    private JLabel lbl_MaHoaDon;
    private JTable table_DanhSachDoiTra;
    private JTextField txt_MaDonDoiTra;
    // End of variables declaration//GEN-END:variables
    
    public void importDoiTra() {
        tableModel.setRowCount(0);
        ArrayList<DoiTra> dtList = dt_bus.getAllDoiTra();
        if(dtList != null) {
            for (DoiTra dt : dtList) {
                String[] data = {dt.getMaDT(), dt.getHoaDon().getMaHD(), dt.getNhanVien().getMaNhanVien(), dt.getThoiGianDoiTra().toString(), dt.getHinhThucDoiTra().toString(), dt.getTongTien()+""};
                tableModel.addRow(data);
            }
        }
    }
    
    public void timKiemDoiTra() {
        String ma = txt_MaDonDoiTra.getText().trim();
        Date ngayLap = jdc_NgayLap.getDate();
        if(ma.equals("") && ngayLap == null) {
            JOptionPane.showMessageDialog(this, "Mã đơn đổi trả hoặc ngày lập chưa được nhập!");
            return;
        }
        ArrayList<DoiTra> dtList = new ArrayList<>();
        if(ma.length() > 0 && ngayLap == null) {
            DoiTra dt = dt_bus.getDoiTraTheoMa(ma);
            if(dt != null) { 
                dtList.add(dt);
            }
        } else if(ma.equals("") && ngayLap != null) {
            dtList = dt_bus.getDoiTraTheoNgayLap(new java.sql.Date(ngayLap.getTime()));
        } else {
            DoiTra dt = dt_bus.getDoiTraTheoDieuKien(ma, new java.sql.Date(ngayLap.getTime()));
            if(dt != null) { 
                dtList.add(dt);
            }
        }

        if(!dtList.isEmpty()) {
            tableModel.setRowCount(0);
            for (DoiTra dt : dtList) {
                String[] data = {dt.getMaDT(), dt.getHoaDon().getMaHD(), dt.getNhanVien().getMaNhanVien(), dt.getThoiGianDoiTra().toString(), dt.getHinhThucDoiTra().toString(), dt.getTongTien()+""};
                tableModel.addRow(data);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Đơn đổi trả không tồn tại!");
        }
    }
    
    public void xemChiTiet() {
        int row = table_DanhSachDoiTra.getSelectedRow();
        if(row < 0) {
            JOptionPane.showMessageDialog(this, "Đơn đổi trả chưa được chọn!");
            return;
        }
        
        String ma = tableModel.getValueAt(row, 0).toString();
        new ChiTietDoiTra_GUI(ma).setVisible(true);
    }
}
