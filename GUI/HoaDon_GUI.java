package GUI;


import BUS.HoaDon_bus;
import DTO.HoaDon;
import utils.HoaDon_Global;

import java.awt.*;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class HoaDon_GUI extends javax.swing.JPanel {

    private HoaDon_bus hdbus;
    private DefaultTableModel model;
    
    /**
     * Creates new form HoaDon_JPanel
     */
    public HoaDon_GUI() {

        initComponents();
        dateNgayLap.setLocale(new Locale("vi", "VN"));
        setBounds(0, 0, 1186, 748);
//          Jpanel_ThaoTac.setBorder(BorderFactory.createTitledBorder("Thao tác"));
//        Jpanel_Table.setBorder(BorderFactory.createTitledBorder("Bảng danh sách"));
        ImageIcon img_btnTimKiem = new ImageIcon("icon/buttonTimKiem.png");
        Image scaled_btnTimKiem = img_btnTimKiem.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnTimKiem = new ImageIcon(scaled_btnTimKiem);
        btn_TimKiem.setIcon(img_btnTimKiem);
        ImageIcon img_btnXemChiTiet = new ImageIcon("icon/buttonXemChiTiet.png");
        Image scaled_btnXemChiTiet = img_btnXemChiTiet.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnXemChiTiet = new ImageIcon(scaled_btnXemChiTiet);
        btn_XemChiTiet.setIcon(img_btnXemChiTiet);
        ImageIcon img_btnXoa = new ImageIcon("icon/buttonXoa.png");
        Image scaled_btnXoa = img_btnXoa.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnXoa = new ImageIcon(scaled_btnXoa);
        btn_LamMoi.setIcon(img_btnXoa);

        // KHởi tạo kết nối database
//        try {
//            ConnectDB.getInstance().connect();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        
         hdbus = new HoaDon_bus();
         
//           Object [][] data ={};
//           String [] columnNames = { "Mã Hóa Đơn", "Mã Khách Hàng", "Mã Nhân Viên", "Mã CTKM", "Ngày Lập Hóa Đơn", "Tiền Khuyến Mãi", "Tổng Tiền", "Tiền Thanh Toán", "Tình Trạng" };
//         model=new DefaultTableModel(data, columnNames){
//            @Override
//            public boolean isCellEditable(int row, int column){
//                return false;
//                }
//            };
         DocDuLieuTuSQLvaoTable();
    }
    

    private void DocDuLieuTuSQLvaoTable() {
        ArrayList<HoaDon> listHD = hdbus.selectAll();
        for (HoaDon hd : listHD) {

            addRows(new Object[]{hd.getMaHD(), hd.getKhachHang().getMaKhachHang(), hd.getNhanVien().getMaNhanVien(), hd.getChuongTrinhKM().getMaCTKM(), hd.getNgayLapHD(), hd.getTienKhuyenMai(), hd.getTongTien(), hd.getTienThanhToan(), hd.getTinhTrang()==1? "Đã Thanh Toán" : "Chưa Thanh Toán"});
        }
    }

    public void addRows(Object[] row) {
        DefaultTableModel model;
        model = (DefaultTableModel) jTable1.getModel();
        model.addRow(row);
    }

    public String getMaHDInHD() {
        int row = jTable1.getSelectedRow();
        String ma = jTable1.getValueAt(row, 0).toString();
        return ma;
    }

    private void XoahetDuLieuTrenTable() {
        DefaultTableModel md = (DefaultTableModel) jTable1.getModel();
        md.getDataVector().removeAllElements();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Jpanel_TieuDeHoaDon = new javax.swing.JPanel();
        lbl_TieuDeHoaDon = new javax.swing.JLabel();
        Jpanel_ThaoTac = new javax.swing.JPanel();
        lbl_MaHoaDon = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_MaHoaDon = new javax.swing.JTextField();
        dateNgayLap = new com.toedter.calendar.JDateChooser();
        btn_TimKiem = new javax.swing.JButton();
        btn_LamMoi = new javax.swing.JButton();
        btn_XemChiTiet = new javax.swing.JButton();
        Jpanel_Table = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(22, 97, 86));
        setMinimumSize(new java.awt.Dimension(1020, 700));
        setPreferredSize(new java.awt.Dimension(1020, 700));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Jpanel_TieuDeHoaDon.setBackground(new java.awt.Color(22, 97, 86));
        Jpanel_TieuDeHoaDon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_TieuDeHoaDon.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        lbl_TieuDeHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_TieuDeHoaDon.setText("QUẢN LÝ HÓA ĐƠN");
        lbl_TieuDeHoaDon.setForeground(Color.WHITE);
        Jpanel_TieuDeHoaDon.add(lbl_TieuDeHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 10, 330, 30));

        add(Jpanel_TieuDeHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1186, 50));

        Jpanel_ThaoTac.setBackground(new java.awt.Color(22, 97, 86));
        Jpanel_ThaoTac.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Thao tác", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bahnschrift", 0, 12))); // NOI18N
        Jpanel_ThaoTac.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Jpanel_ThaoTac.setBackground(Color.WHITE);

        lbl_MaHoaDon.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        lbl_MaHoaDon.setText("Mã Hóa Đơn");
        Jpanel_ThaoTac.add(lbl_MaHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 120, 20));


        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel1.setText("Ngày Lập Hóa Đơn");

        Jpanel_ThaoTac.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 60, 150, 20));

        txt_MaHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_MaHoaDonActionPerformed(evt);
            }
        });
        Jpanel_ThaoTac.add(txt_MaHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 200, 25));

        dateNgayLap.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateNgayLapPropertyChange(evt);
            }
        });
        Jpanel_ThaoTac.add(dateNgayLap, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 200, 25));

        btn_TimKiem.setBackground(new java.awt.Color(0, 51, 51));
        btn_TimKiem.setFont(new java.awt.Font("Bahnschrift", 1, 15)); // NOI18N
        btn_TimKiem.setForeground(new java.awt.Color(255, 255, 255));
        btn_TimKiem.setText("Tìm kiếm");
        btn_TimKiem.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_TimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TimKiemActionPerformed(evt);
            }
        });
        Jpanel_ThaoTac.add(btn_TimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 120, 30));

        btn_LamMoi.setBackground(new java.awt.Color(0, 51, 51));
        btn_LamMoi.setFont(new java.awt.Font("Bahnschrift", 1, 15)); // NOI18N
        btn_LamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btn_LamMoi.setText("Làm mới");
        btn_LamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LamMoiActionPerformed(evt);
            }
        });
        Jpanel_ThaoTac.add(btn_LamMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 20, 120, 30));

        btn_XemChiTiet.setBackground(new java.awt.Color(0, 51, 51));
        btn_XemChiTiet.setFont(new java.awt.Font("Bahnschrift", 1, 15)); // NOI18N
        btn_XemChiTiet.setForeground(java.awt.Color.white);
        btn_XemChiTiet.setText("Xem chi tiết");
        btn_XemChiTiet.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_XemChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XemChiTietActionPerformed(evt);
            }
        });
        Jpanel_ThaoTac.add(btn_XemChiTiet, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 135, 30));

        add(Jpanel_ThaoTac, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1170, 100));

        Jpanel_Table.setBackground(Color.WHITE);
        Jpanel_Table.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Danh sách hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bahnschrift", 0, 12))); // NOI18N
        Jpanel_Table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Jpanel_Table.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Hóa Đơn", "Mã Khách Hàng", "Mã Nhân Viên", "Mã CTKM", "Ngày Lập Hóa Đơn", "Tiền Khuyến Mãi", "Tổng Tiền", "Tiền Thanh Toán", "Tình Trạng"
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
        jScrollPane1.setViewportView(jTable1);


    Jpanel_Table.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 1150, 550));

    add(Jpanel_Table, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 155, 1170, 580));
    }// </editor-fold>//GEN-END:initComponents

    private void txt_MaHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_MaHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MaHoaDonActionPerformed

    private void btn_LamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LamMoiActionPerformed
        // TODO add your handling code here:
        XoahetDuLieuTrenTable();
        DocDuLieuTuSQLvaoTable();
        txt_MaHoaDon.setText("");
        dateNgayLap.setDate(null);
    }//GEN-LAST:event_btn_LamMoiActionPerformed

    private void btn_XemChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XemChiTietActionPerformed
        try {
            int row = jTable1.getSelectedRow();
            String maHD = jTable1.getValueAt(row, 0).toString();
            String maKH = "";
            if (jTable1.getValueAt(row, 1) != null) {
                maKH = jTable1.getValueAt(row, 1).toString();
            }
            String maNV = jTable1.getValueAt(row, 2).toString();
            String ngayLap = jTable1.getValueAt(row, 4).toString();

            String maKM = "";
            if (jTable1.getValueAt(row, 3) != null) {
                maKM = jTable1.getValueAt(row, 3).toString();
            }
            System.out.println(maHD + " " + maKH + " " + maNV + " " + ngayLap);

            HoaDon_Global.setMaHD(maHD);
            HoaDon_Global.setMaKH(maKH);
            HoaDon_Global.setMaNV(maNV);
            HoaDon_Global.setNgayLap(ngayLap);
            HoaDon_Global.setMaKM(maKM);
            ChiTietHoaDon_GUI cthd = new ChiTietHoaDon_GUI();
            cthd.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn hoá đơn cần xem !");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_XemChiTietActionPerformed

    private void btn_TimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TimKiemActionPerformed

        XoahetDuLieuTrenTable();
        DocDuLieuTuSQLvaoTable();
        if (!txt_MaHoaDon.getText().equals("") && dateNgayLap.getDate() == null) {
            HoaDon hd = new HoaDon();
            try {
                hd = hdbus.getHoaDonTheoMaHD(txt_MaHoaDon.getText());
                XoahetDuLieuTrenTable();
                addRows(new Object[]{hd.getMaHD(), hd.getKhachHang().getMaKhachHang(), hd.getNhanVien().getMaNhanVien(), hd.getChuongTrinhKM().getMaCTKM(), hd.getNgayLapHD(), hd.getTienKhuyenMai(), hd.getTongTien(), hd.getTienThanhToan()});
            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, "Không tìm thấy hoá đơn này !");
            }
        } else if (txt_MaHoaDon.getText().equals("") && dateNgayLap.getDate() != null) {
            ArrayList<HoaDon> ds = new ArrayList<HoaDon>();
            try {
                java.sql.Date ngaylap = new java.sql.Date(dateNgayLap.getDate().getTime());
                System.out.println("ngay lập " + ngaylap);
                ds = hdbus.getHoaDonTheoNgayLap(ngaylap);
                XoahetDuLieuTrenTable();
                for (HoaDon hd : ds) {
                    addRows(new Object[]{hd.getMaHD(), hd.getKhachHang().getMaKhachHang(), hd.getNhanVien().getMaNhanVien(), hd.getChuongTrinhKM().getMaCTKM(), hd.getNgayLapHD(), hd.getTienKhuyenMai(), hd.getTongTien(), hd.getTienThanhToan()});
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Không tìm thấy hoá đơn này !");
                 XoahetDuLieuTrenTable();
                DocDuLieuTuSQLvaoTable();
                e.printStackTrace();
            }
        } else if (txt_MaHoaDon.getText().equals("") && dateNgayLap.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập dữ liệu Hoá đơn cần tìm !");
        }
        else if(!txt_MaHoaDon.getText().equals("") && dateNgayLap.getDate() != null){
            ArrayList<HoaDon> ds = new ArrayList<HoaDon>();
            try {
                java.sql.Date ngaylap = new java.sql.Date(dateNgayLap.getDate().getTime());
//                System.out.println("ngay lập " +ngaylap);
                ds = hdbus.getHoaDonTheoMaHDvaNgayLap(txt_MaHoaDon.getText(),ngaylap);
                XoahetDuLieuTrenTable();
                for (HoaDon hd : ds) {
                    addRows(new Object[]{hd.getMaHD(),hd.getKhachHang().getMaKhachHang(),hd.getNhanVien().getMaNhanVien(),hd.getChuongTrinhKM().getMaCTKM(),hd.getNgayLapHD(),hd.getTienKhuyenMai(), hd.getTongTien(), hd.getTienThanhToan()});
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Không tìm thấy hoá đơn này !");
                XoahetDuLieuTrenTable();
                DocDuLieuTuSQLvaoTable();
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_btn_TimKiemActionPerformed

    private void dateNgayLapPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateNgayLapPropertyChange
        // TODO add your handling code here:
        XoahetDuLieuTrenTable();
//        DocDuLieuTuSQLvaoTable();
        ArrayList<HoaDon> ds = new ArrayList<HoaDon>();
        try {
            if (dateNgayLap.getDate() != null) {
                java.sql.Date ngaylap = new java.sql.Date(dateNgayLap.getDate().getTime());
                System.out.println("ngay lập " + ngaylap);
                ds = hdbus.getHoaDonTheoNgayLap(ngaylap);
                        if(ds.isEmpty())  {
                            JOptionPane.showMessageDialog(null, "Không tìm thấy hoá đơn này !");
                            XoahetDuLieuTrenTable();
                            DocDuLieuTuSQLvaoTable();
                        }
                        else {
                            XoahetDuLieuTrenTable();
                        for (HoaDon hd : ds) {
                            addRows(new Object[]{hd.getMaHD(),hd.getKhachHang().getMaKhachHang(),hd.getNhanVien().getMaNhanVien(),hd.getChuongTrinhKM().getMaCTKM(),hd.getNgayLapHD(),hd.getTienKhuyenMai(), hd.getTongTien(), hd.getTienThanhToan(),hd.getTinhTrang()});
                        }
                        }
                        }
             else {
                hdbus = new HoaDon_bus();
                DocDuLieuTuSQLvaoTable();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy hoá đơn này !");
            e.printStackTrace();
        }
    }//GEN-LAST:event_dateNgayLapPropertyChange
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Jpanel_Table;
    private javax.swing.JPanel Jpanel_ThaoTac;
    private javax.swing.JPanel Jpanel_TieuDeHoaDon;
    private javax.swing.JButton btn_LamMoi;
    private javax.swing.JButton btn_TimKiem;
    private javax.swing.JButton btn_XemChiTiet;
    private com.toedter.calendar.JDateChooser dateNgayLap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl_MaHoaDon;
    private javax.swing.JLabel lbl_TieuDeHoaDon;
    private javax.swing.JTextField txt_MaHoaDon;
    // End of variables declaration//GEN-END:variables
}
