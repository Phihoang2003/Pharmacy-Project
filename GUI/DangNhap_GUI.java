
package GUI;


import BUS.NhanVien_bus;
import DAO.NhanVienDAO;
import DAO.TaiKhoanDAO;
import DTO.NhanVien;
import DTO.TaiKhoan;
import config.JDBCUtil;

import utils.Global;


import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class DangNhap_GUI extends JFrame {

    /**
     * Creates new form DangNhap_GUI
     */
    private NhanVien_bus nv_bus;
    public DangNhap_GUI() {
        initComponents();
        String b = "<HTML><u>Quên mật khẩu?</u></HTML>";
//        jlb_QuanMatKhau.setText(b);
//        ImageIcon img_btnTimKiem = new ImageIcon("D:\\TrenLop\\PTUD\\Phamarcy_Project\\src\\icon\\stores.png");
//        Image scaled_btnTimKiem = img_btnTimKiem.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
//        img_btnTimKiem = new ImageIcon(scaled_btnTimKiem);
//        jLabel1.setIcon(img_btnTimKiem);
        setLocationRelativeTo(null);

        // Create a KeyStroke for Enter
        KeyStroke enterKey = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);

        // Add KeyStroke binding to the button's input map
        btn_DangNhap4.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(enterKey, "enterPressed");
        btn_DangNhap4.getActionMap().put("enterPressed", danhNhapAction);
    }
    // Tạo AcTion để xử lý sự kiện cho phím O
    Action danhNhapAction = new AbstractAction("Đăng Nhập") {
        @Override
        public void actionPerformed(ActionEvent e) {

//            try{
//                String tfTK= jtf_TenTaiKhoan.getText();
//                char[] pass= jpf_MatKhau.getPassword();
//                String tfMK= String.valueOf(pass);
//                NhanVienDAO nv_dao= new NhanVienDAO();
//                TaiKhoanDAO tk_dao=new TaiKhoanDAO();
//                nv_bus= new NhanVien_bus();
//                TaiKhoan tk=new TaiKhoan();
//                try{
//                    tk=tk_dao.getTK(tfTK, tfMK);
//
//
//                }catch(Exception ex){
//                    Logger.getLogger(DangNhap_GUI.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                if(tk==null){
//                    JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không đúng!");
//                }
//                else{
//                    tk_dao.setThoiGianDN(tk);
//                    NhanVien nv=nv_bus.findBySDT(tfTK);
//
//                    Global.setName(nv.getHoTen());
//                    Global.setMa(nv.getMaNhanVien());
//                    Global.setChucvu(nv.getChucVu().toString());
//                    Global.setGioitinh(nv.getGioiTinh()==1?"Nam":"Nữ");
//                    Global.setSdt(nv.getSdt());
//                    dispose();
//                    TrangChu_GUI trangChu_GUI = new TrangChu_GUI();
//                    trangChu_GUI.setVisible(true);
//
//
//                }
//
//            }catch(Exception ex){
//                Logger.getLogger(DangNhap_GUI.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
    };

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new JPanel();
        jButton1 = new JButton();
        jPanel2 = new JPanel();
        jLabel1 = new JLabel();
        jPanel3 = new JPanel();
        jlb_TenTaiKhoan = new JLabel();
        jlb_MatKhau = new JLabel();
        jlb_QuanMatKhau = new JLabel();
        btn_HuyBo = new JButton();
        jlb_DangNhap = new JLabel();
        btn_DangNhap4 = new JButton();
        jtf_TenTaiKhoan = new JTextField();
        jpf_MatKhau = new JPasswordField();
        btn_DangNhap1 = new JButton();

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jButton1.setText("jButton1");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 153));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(187, 205, 197));
        jLabel1.setIcon(new ImageIcon("D:\\TrenLop\\PTUD\\Phamarcy_Project\\src\\img\\svgtopng\\login-image.png")); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 500, 400));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 440));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlb_TenTaiKhoan.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jlb_TenTaiKhoan.setText("Tên tài khoản");
        jPanel3.add(jlb_TenTaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 180, -1, -1));

        jlb_MatKhau.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jlb_MatKhau.setText("Mật khẩu");
        jPanel3.add(jlb_MatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 240, -1, -1));

        jlb_QuanMatKhau.setDisplayedMnemonic('\u0001');
        jlb_QuanMatKhau.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jlb_QuanMatKhau.setForeground(new java.awt.Color(51, 153, 255));
        jlb_QuanMatKhau.setText("Quên mật khẩu?");
        jlb_QuanMatKhau.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlb_QuanMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlb_QuanMatKhauMouseClicked(evt);
            }
        });
        jPanel3.add(jlb_QuanMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 390, 190, 30));

        btn_HuyBo.setBackground(new java.awt.Color(0, 51, 51));
        btn_HuyBo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_HuyBo.setForeground(new java.awt.Color(255, 255, 255));
        btn_HuyBo.setText("Hủy bỏ");
        btn_HuyBo.setBorder(null);
        btn_HuyBo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_HuyBo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_HuyBoMouseClicked(evt);
            }
        });
        btn_HuyBo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_HuyBoActionPerformed(evt);
            }
        });
        jPanel3.add(btn_HuyBo, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 320, 120, 40));

        jlb_DangNhap.setFont(new java.awt.Font("Times New Roman", 1, 44)); // NOI18N
        jlb_DangNhap.setHorizontalAlignment(SwingConstants.CENTER);
        jlb_DangNhap.setText("Đăng Nhập");
        jlb_DangNhap.setToolTipText("");
        jlb_DangNhap.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlb_DangNhap.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
        jlb_DangNhap.setHorizontalTextPosition(SwingConstants.LEADING);
        jPanel3.add(jlb_DangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 400, 160));
        jlb_DangNhap.getAccessibleContext().setAccessibleParent(jlb_DangNhap);

        btn_DangNhap4.setBackground(new java.awt.Color(0, 51, 51));
        btn_DangNhap4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_DangNhap4.setForeground(new java.awt.Color(255, 255, 255));
        btn_DangNhap4.setText("Đăng nhập");
        btn_DangNhap4.setBorder(null);
        btn_DangNhap4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_DangNhap4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_DangNhap4MouseClicked(evt);
            }
        });
        btn_DangNhap4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_DangNhap4ActionPerformed(evt);
            }
        });
        jPanel3.add(btn_DangNhap4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 320, 120, 40));

        jtf_TenTaiKhoan.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jtf_TenTaiKhoan.setText("0976474170");
        jtf_TenTaiKhoan.setToolTipText("");
        jtf_TenTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jtf_TenTaiKhoanActionPerformed(evt);
            }
        });
        jPanel3.add(jtf_TenTaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 180, 227, 30));

        jpf_MatKhau.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jpf_MatKhau.setText("1111");
        jpf_MatKhau.setToolTipText("");
        jPanel3.add(jpf_MatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 240, 227, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 0, 930, 440));

        btn_DangNhap1.setBackground(new java.awt.Color(0, 51, 51));
        btn_DangNhap1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_DangNhap1.setForeground(new java.awt.Color(255, 255, 255));
        btn_DangNhap1.setText("Đăng nhập");
        btn_DangNhap1.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_DangNhap1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_DangNhap1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_DangNhap1MouseClicked(evt);
            }
        });
        btn_DangNhap1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_DangNhap1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_DangNhap1, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 320, 120, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtf_TenTaiKhoanActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jtf_TenTaiKhoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_TenTaiKhoanActionPerformed

    private void jlb_QuanMatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlb_QuanMatKhauMouseClicked

        

        // TODO add your handling code here:
    }//GEN-LAST:event_jlb_QuanMatKhauMouseClicked


    private void btn_DangNhap1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DangNhap1MouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_btn_DangNhap1MouseClicked

    private void btn_DangNhap1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btn_DangNhap1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btn_DangNhap1ActionPerformed

    private void btn_HuyBoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_HuyBoMouseClicked
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_HuyBoMouseClicked

    private void btn_HuyBoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btn_HuyBoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_HuyBoActionPerformed

    private void btn_DangNhap4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DangNhap4MouseClicked

        
    }//GEN-LAST:event_btn_DangNhap4MouseClicked

    private void btn_DangNhap4ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btn_DangNhap4ActionPerformed
        // TODO add your handling code here:
        try{
            String tfTK= jtf_TenTaiKhoan.getText();
            char[] pass= jpf_MatKhau.getPassword();
            String tfMK= String.valueOf(pass);
            NhanVienDAO nv_dao= new NhanVienDAO();
            TaiKhoanDAO tk_dao=new TaiKhoanDAO();
            nv_bus= new NhanVien_bus();
            TaiKhoan tk=new TaiKhoan();
            try{
                tk=tk_dao.getTK(tfTK, tfMK);


            }catch(Exception ex){
                Logger.getLogger(DangNhap_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(tk==null){
                JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không đúng!");
            }
            else{
                tk_dao.setThoiGianDN(tk);
                NhanVien nv=nv_bus.findBySDT(tfTK);

                Global.setName(nv.getHoTen());
                Global.setMa(nv.getMaNhanVien());
                Global.setChucvu(nv.getChucVu().toString());
                Global.setGioitinh(nv.getGioiTinh()==1?"Nam":"Nữ");
                Global.setSdt(nv.getSdt());
                dispose();
                TrangChu_GUI trangChu_GUI = new TrangChu_GUI();
                trangChu_GUI.setVisible(true);

            }

        }catch(Exception ex){
            Logger.getLogger(DangNhap_GUI.class.getName()).log(Level.SEVERE, null, ex);}


    }//GEN-LAST:event_btn_DangNhap4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DangNhap_GUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(DangNhap_GUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DangNhap_GUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(DangNhap_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JDBCUtil.getConnection();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                new DangNhap_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btn_DangNhap1;
    private JButton btn_DangNhap4;
    private JButton btn_HuyBo;
    private JButton jButton1;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JLabel jlb_DangNhap;
    private JLabel jlb_MatKhau;
    private JLabel jlb_QuanMatKhau;
    private JLabel jlb_TenTaiKhoan;
    private JPasswordField jpf_MatKhau;
    private JTextField jtf_TenTaiKhoan;
    // End of variables declaration//GEN-END:variables
}
