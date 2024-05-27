
package GUI;

import BUS.*;
import DTO.ChiTietHoaDon;
import DTO.ChuongTrinhKhuyenMai;
import DTO.KhachHang;
import DTO.Thuoc;
import config.JDBCUtil;
import utils.HoaDon_Global;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author 84335
 */
public class ChiTietHoaDon_GUI extends javax.swing.JFrame {
    
     public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            private ChiTietHoaDon_GUI frame;
            public void run() {
                try {
                    frame = new ChiTietHoaDon_GUI();
//                     frame.setUndecorated(true);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
            }
        });
    }
    private final ChiTietHoaDon_bus cthdbus;
    private DefaultTableModel model;
    private SanPham_bus spbus;
    private HoaDon_GUI HDPanel;
    private KhachHang_bus khbus;
    private ChuongTrinhKhuyenMai_bus kmbus;
    private HoaDon_bus hdbus;
       // Định dạng số tiền sang VND
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

    /**
     * Creates new form ChiTietHoaDon_GUI
     */
    public ChiTietHoaDon_GUI() {
           try {
               JDBCUtil.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
        setLocationRelativeTo(null);
        cthdbus = new ChiTietHoaDon_bus();
        HoaDon_Global hdtc = new HoaDon_Global();
        System.out.println(" Mã hoá đơn" + HoaDon_Global.getMaHD());
        lbl_MaHoaDon.setText(HoaDon_Global.getMaHD());
//        lbl_MaKhachHang.setText(hdtc.getMaKH());
        // Lấy thôn tin khách hàng
        khbus = new KhachHang_bus();
        KhachHang kh  = new KhachHang();
        if(!HoaDon_Global.getMaKH().isEmpty()) {
            kh = khbus.selectById(HoaDon_Global.getMaKH());
             lbl_MaKhachHang.setText(kh.getHoTen());
               lbl_SDT.setText(kh.getSdt());
        }

        lbl_MaNhanVien.setText(HoaDon_Global.getMaNV());
        lbl_NgayLapHoaDon.setText(HoaDon_Global.getNgayLap());
        // Lấy Khuyến Mãi
        kmbus = new ChuongTrinhKhuyenMai_bus();
        if(!HoaDon_Global.getMaKM().equals("")){

              ChuongTrinhKhuyenMai ctkm = kmbus.getKMTheomaHD(lbl_MaHoaDon.getText());

                   lbl_KhuyenMaiHD.setText(ctkm.getGiamGia()+"%");


        }
        lbl_IConExit.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                System.exit(0);
            }
        });
        
          DocDuLieuSQLvaoTable();

    }

    private void DocDuLieuSQLvaoTable() {

    ArrayList<ChiTietHoaDon> listCTHD =cthdbus.getallCTHD();
    int sl = 0;
        try {
            String maHD = lbl_MaHoaDon.getText();
            ArrayList<Thuoc> allSP = new ArrayList<>(); // Danh sách tất cả sản phẩm
             allSP = cthdbus.getSanPhamTheoMaHD(maHD);
             String giagoc  = "";
            for(Thuoc sp: allSP){
                listCTHD = cthdbus.getCTHDTheoMaHDvaMaSP(maHD, sp.getMaThuoc());
                for(ChiTietHoaDon ct: listCTHD){
                    System.out.println("Chi tiet"+ct);
                    
                    if(sp.getChuongTrinhKhuyenMaiEntity().getMaCTKM()!= null){
                        ChuongTrinhKhuyenMai ctkm = kmbus.selectById(sp.getChuongTrinhKhuyenMaiEntity().getMaCTKM());
                         giagoc = "<html><strike>"+ct.getGiaGoc()+"</strike><sub>"+"-"+ctkm.getGiamGia()+"%"+"</sub></html>" ;
                    }
                    else {
                        giagoc = ct.getGiaGoc() +"";
                    }
                addRows(new Object[]{sp.getMaThuoc(),sp.getTenThuoc(),sp.getHoatChatChinh(),sp.getDonViTinh().getMaDonViTinh(),ct.getSoLuong(),giagoc ,ct.getGiaBan(),ct.getThanhTien()});
                }
            }
//           lblTongTien.setText(TongTien(5));
           lbl_TienThanhToan.setText(TongTien(7));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn hoá đơn cần xem !");
            e.printStackTrace();
        }
   

}

       public void addRows (Object[] row){
        model = (DefaultTableModel) table.getModel();
        model.addRow(row);
   } 
    public boolean getHD(String maHD,String maKH,String maNV,String ngayLap ){

        return false;
    }
    public String TongTien(int col){
        double tt =0;
        try {
            int row = table.getRowCount();
            for (int i = 0; i < row ; i++) {
                tt += Double.parseDouble(table.getValueAt(i, col).toString());
            }
//            lblTongTien.setText(tt+" đ");
        String giamKMHD = lbl_KhuyenMaiHD.getText().replace("%", "");
        double stg = tt * (Double.parseDouble(giamKMHD))/100;
          ChuongTrinhKhuyenMai ctkm = kmbus.getKMTheomaHD(lbl_MaHoaDon.getText());
          if(ctkm != null){
              if(ctkm.getSoTienToiDa() < stg) stg = ctkm.getSoTienToiDa();
          }
          
        tt = tt - stg;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return currencyFormatter.format(tt) + "";
    }
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_IConExit = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_MaKhachHang = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_MaHoaDon = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_MaNhanVien = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_NgayLapHoaDon = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btn_XacNhan = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lbl_SDT = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_TienThanhToan = new javax.swing.JLabel();
        lbl_TextKM1 = new javax.swing.JLabel();
        lbl_KhuyenMaiHD = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(22, 97, 86));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_IConExit.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                lbl_IConExitMouseClicked(evt);
            }
        });
        jPanel1.add(lbl_IConExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 20, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 20));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÔNG TIN CHI TIẾT HÓA ĐƠN");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 70));

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 1, 10)); // NOI18N
        jLabel2.setText("Tên Khách Hàng");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 90, 30));

        lbl_MaKhachHang.setFont(new java.awt.Font("Bahnschrift", 0, 10)); // NOI18N
        jPanel2.add(lbl_MaKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 110, 30));

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        jLabel4.setText("Mã Hóa Đơn");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 90, 30));

        lbl_MaHoaDon.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        lbl_MaHoaDon.setText("HD120923091230");
        jPanel2.add(lbl_MaHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 110, 30));

        jLabel6.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        jLabel6.setText("Mã Nhân Viên");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 110, 30));

        lbl_MaNhanVien.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        lbl_MaNhanVien.setText("NV29097654");
        jPanel2.add(lbl_MaNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, 110, 30));

        jLabel8.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        jLabel8.setText("Ngày Lập Hóa Đơn");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, 110, 30));

        lbl_NgayLapHoaDon.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        lbl_NgayLapHoaDon.setText("21/10/2023");
        jPanel2.add(lbl_NgayLapHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 110, 110, 30));

        table.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Hoạt chất chính", "Đơn vị tính", "Số Lượng", "Giá Gốc", "Giá bán", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setRowHeight(30);
        table.getColumnModel().getColumn(0).setPreferredWidth(200);
        jScrollPane1.setViewportView(table);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 760, 240));

        btn_XacNhan.setBackground(new java.awt.Color(0, 51, 51));
        btn_XacNhan.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        btn_XacNhan.setForeground(new java.awt.Color(255, 255, 255));
        btn_XacNhan.setText("Xác Nhận");
        btn_XacNhan.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btn_XacNhanMouseClicked(evt);
            }
        });
        jPanel2.add(btn_XacNhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 620, 100, 30));

        jLabel9.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        jLabel9.setText("Số Điện Thoại");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, -1, -1));

        lbl_SDT.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jPanel2.add(lbl_SDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, 90, 30));

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        jLabel5.setText("Tiền phải  thanh toán:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 480, 130, 30));

        lbl_TienThanhToan.setText("0");
        jPanel2.add(lbl_TienThanhToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 480, 140, 30));

        lbl_TextKM1.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        lbl_TextKM1.setText("Khuyến Mãi Hóa Đơn");
        jPanel2.add(lbl_TextKM1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 490, 120, 30));

        lbl_KhuyenMaiHD.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        lbl_KhuyenMaiHD.setText("0");
        jPanel2.add(lbl_KhuyenMaiHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 490, 100, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 800, 680));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 798, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 700, 800, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_IConExitMouseClicked(MouseEvent evt) {//GEN-FIRST:event_lbl_IConExitMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_IConExitMouseClicked

    private void btn_XacNhanMouseClicked(MouseEvent evt) {//GEN-FIRST:event_btn_XacNhanMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btn_XacNhanMouseClicked

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_XacNhan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_IConExit;
    private javax.swing.JLabel lbl_KhuyenMaiHD;
    private javax.swing.JLabel lbl_MaHoaDon;
    private javax.swing.JLabel lbl_MaKhachHang;
    private javax.swing.JLabel lbl_MaNhanVien;
    private javax.swing.JLabel lbl_NgayLapHoaDon;
    private javax.swing.JLabel lbl_SDT;
    private javax.swing.JLabel lbl_TextKM1;
    private javax.swing.JLabel lbl_TienThanhToan;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
