/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 *
 * @author USER
 */
public class TrangChu_GUI extends javax.swing.JFrame {
    public void resetVisible(){
            banHangGUI.setVisible(false);
            khachHangGUI.setVisible(false);
            sanPhamGUI.setVisible(false);
            nhaCungCap_GUI.setVisible(false);
            nhanVienGUI.setVisible(false);
        }
    private void resetAllPanels() {
        SanPham_Panel.setBackground(UIManager.getColor(Color.WHITE));
        HoaDon_Panel.setBackground(UIManager.getColor(Color.WHITE));
        NhaCungCapPanel.setBackground(UIManager.getColor(Color.WHITE));
        NhanVien_Panel.setBackground(UIManager.getColor(Color.WHITE));
        ThongKe_Panel.setBackground(UIManager.getColor(Color.WHITE));
        TrangChu_Panel.setBackground(UIManager.getColor(Color.WHITE));
        BanHang_Panel.setBackground(UIManager.getColor(Color.WHITE));
        KhachHang_Panel.setBackground(UIManager.getColor(Color.WHITE));
    }
    /**
     * Creates new form TrangChu_GUI
     */
    public TrangChu_GUI() {
        initComponents();
        sanPhamGUI = new SanPham_GUI();
        banHangGUI=new BanHang_GUI(); // Initialize SanPham_GUI instance
        khachHangGUI=new KhachHang_GUI();
        nhaCungCap_GUI=new NhaCungCap_GUI();
        nhanVienGUI=new NhanVien_GUI();
        Main_GUI.setLayout(new BorderLayout());
        
// Add SanPham_GUI instance to Main_GUI
        resetVisible();
        
        
        TrangChu_Panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if(selectedPanel!=TrangChu_Panel){
                    TrangChu_Panel.setBackground(new Color(235, 237, 240));
                }
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetAllPanels();
                TrangChu_Panel.setBackground(new Color(187, 222, 251));
               selectedPanel=TrangChu_Panel;
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if(selectedPanel!=TrangChu_Panel){
                    TrangChu_Panel.setBackground(UIManager.getColor(Color.WHITE));
                }
            }
        });
         SanPham_Panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if(selectedPanel!=SanPham_Panel){
                    SanPham_Panel.setBackground(new Color(235, 237, 240));
                }
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetAllPanels();
                SanPham_Panel.setBackground(new Color(187, 222, 251));
                selectedPanel=SanPham_Panel;
                Main_GUI.add(sanPhamGUI,BorderLayout.CENTER);
                resetVisible();
                sanPhamGUI.setVisible(true);
                
                
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if(selectedPanel!=SanPham_Panel){
                    SanPham_Panel.setBackground(UIManager.getColor(Color.WHITE));
                }
            }
        });
        NhaCungCapPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if(selectedPanel!=NhaCungCapPanel){
                    NhaCungCapPanel.setBackground(new Color(235, 237, 240));
                }
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetAllPanels();
                NhaCungCapPanel.setBackground(new Color(187, 222, 251));
                selectedPanel=NhaCungCapPanel;
                Main_GUI.add(nhaCungCap_GUI,BorderLayout.CENTER);
                resetVisible();
                nhaCungCap_GUI.setVisible(true);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if(selectedPanel!=NhaCungCapPanel){
                    NhaCungCapPanel.setBackground(UIManager.getColor(Color.WHITE));
                }
            }
        });
        HoaDon_Panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if(selectedPanel!=HoaDon_Panel){
                    HoaDon_Panel.setBackground(new Color(235, 237, 240));
                }
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {

                resetAllPanels();
                HoaDon_Panel.setBackground(new Color(187, 222, 251));
                selectedPanel=HoaDon_Panel;
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if(selectedPanel!=HoaDon_Panel){
                    HoaDon_Panel.setBackground(UIManager.getColor(Color.WHITE));
                }
            }
        });

        NhanVien_Panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if(selectedPanel!=NhanVien_Panel){
                    NhanVien_Panel.setBackground(new Color(235, 237, 240));
                }
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetAllPanels();
                NhanVien_Panel.setBackground(new Color(187, 222, 251));
                selectedPanel=NhanVien_Panel;
                Main_GUI.add(nhanVienGUI,BorderLayout.CENTER);
                resetVisible();
                nhanVienGUI.setVisible(true);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if(selectedPanel!=NhanVien_Panel){
                    NhanVien_Panel.setBackground(UIManager.getColor(Color.WHITE));
                }
            }
        });
        ThongKe_Panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if(selectedPanel!=ThongKe_Panel){
                    ThongKe_Panel.setBackground(new Color(235, 237, 240));
                }
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetAllPanels();
                ThongKe_Panel.setBackground(new Color(187, 222, 251));
               selectedPanel=ThongKe_Panel;
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if(selectedPanel!=ThongKe_Panel){
                    ThongKe_Panel.setBackground(UIManager.getColor(Color.WHITE));
                }
            }
        });
        ThongKe_Panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if(selectedPanel!=ThongKe_Panel){
                    ThongKe_Panel.setBackground(new Color(235, 237, 240));
                }
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetAllPanels();
                ThongKe_Panel.setBackground(new Color(187, 222, 251));
               selectedPanel=ThongKe_Panel;
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if(selectedPanel!=ThongKe_Panel){
                    ThongKe_Panel.setBackground(UIManager.getColor(Color.WHITE));
                }
            }
        });

        BanHang_Panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if(selectedPanel!=BanHang_Panel){
                    BanHang_Panel.setBackground(new Color(235, 237, 240));
                }
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {

                resetAllPanels();
                BanHang_Panel.setBackground(new Color(187, 222, 251));
                selectedPanel=BanHang_Panel;
                Main_GUI.add(banHangGUI,BorderLayout.CENTER);
                resetVisible();
                banHangGUI.setVisible(true);
                
                
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if(selectedPanel!=BanHang_Panel){
                    BanHang_Panel.setBackground(UIManager.getColor(Color.WHITE));
                }
            }
        });
        
        KhachHang_Panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if(selectedPanel!=KhachHang_Panel){
                    KhachHang_Panel.setBackground(new Color(235, 237, 240));
                }
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {

                resetAllPanels();
                KhachHang_Panel.setBackground(new Color(187, 222, 251));
                selectedPanel=KhachHang_Panel;
                Main_GUI.add(khachHangGUI,BorderLayout.CENTER);
                resetVisible();
                khachHangGUI.setVisible(true);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if(selectedPanel!=KhachHang_Panel){
                    KhachHang_Panel.setBackground(UIManager.getColor(Color.WHITE));
                }
            }
        });
        
        
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new JPanel();
        SanPham_Panel = new JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        HoaDon_Panel = new JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        NhaCungCapPanel = new JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        NhanVien_Panel = new JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        ThongKe_Panel = new JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        TrangChu_Panel = new JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        BanHang_Panel = new JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        SanPham_Panel2 = new JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        KhachHang_Panel = new JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        Main_GUI = new JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(200, 100));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(3000, 800));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\test2\\src\\icon\\man_50px.png")); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(60, 60));
        jLabel1.setPreferredSize(new java.awt.Dimension(2000, 2000));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Đặng Hoàng Phi");

        jLabel3.setBackground(new Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel3.setText("Quản lí kho");

        jSeparator1.setForeground(new Color(204, 204, 204));

        jPanel2.setBackground(new Color(255, 255, 255));

        SanPham_Panel.setBackground(new Color(255, 255, 255));
        SanPham_Panel.setPreferredSize(new java.awt.Dimension(162, 50));
        SanPham_Panel.setRequestFocusEnabled(false);

        jLabel6.setIcon(new javax.swing.ImageIcon("D:\\test2\\src\\icon\\product.png")); // NOI18N
        jLabel6.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Sản Phẩm");
        jLabel7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel7MouseMoved(evt);
            }
        });

        javax.swing.GroupLayout SanPham_PanelLayout = new javax.swing.GroupLayout(SanPham_Panel);
        SanPham_Panel.setLayout(SanPham_PanelLayout);
        SanPham_PanelLayout.setHorizontalGroup(
            SanPham_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SanPham_PanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SanPham_PanelLayout.setVerticalGroup(
            SanPham_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SanPham_PanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(SanPham_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addGroup(SanPham_PanelLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        HoaDon_Panel.setBackground(new Color(255, 255, 255));
        HoaDon_Panel.setPreferredSize(new java.awt.Dimension(162, 50));
        HoaDon_Panel.setRequestFocusEnabled(false);

        jLabel8.setIcon(new javax.swing.ImageIcon("D:\\test2\\src\\icon\\customer.png")); // NOI18N
        jLabel8.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Hóa Đơn");

        javax.swing.GroupLayout HoaDon_PanelLayout = new javax.swing.GroupLayout(HoaDon_Panel);
        HoaDon_Panel.setLayout(HoaDon_PanelLayout);
        HoaDon_PanelLayout.setHorizontalGroup(
            HoaDon_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HoaDon_PanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HoaDon_PanelLayout.setVerticalGroup(
            HoaDon_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HoaDon_PanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(HoaDon_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HoaDon_PanelLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                .addContainerGap())
        );

        NhaCungCapPanel.setBackground(new Color(255, 255, 255));
        NhaCungCapPanel.setPreferredSize(new java.awt.Dimension(162, 50));
        NhaCungCapPanel.setRequestFocusEnabled(false);

        jLabel10.setIcon(new javax.swing.ImageIcon("D:\\test2\\src\\icon\\supplier.png")); // NOI18N
        jLabel10.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel11.setBackground(new Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Nhà Cung Cấp");
        jLabel11.setPreferredSize(new java.awt.Dimension(162, 50));
        jLabel11.setRequestFocusEnabled(false);

        javax.swing.GroupLayout NhaCungCapPanelLayout = new javax.swing.GroupLayout(NhaCungCapPanel);
        NhaCungCapPanel.setLayout(NhaCungCapPanelLayout);
        NhaCungCapPanelLayout.setHorizontalGroup(
            NhaCungCapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NhaCungCapPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        NhaCungCapPanelLayout.setVerticalGroup(
            NhaCungCapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NhaCungCapPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(NhaCungCapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        NhanVien_Panel.setBackground(new Color(255, 255, 255));
        NhanVien_Panel.setPreferredSize(new java.awt.Dimension(162, 50));

        jLabel12.setIcon(new javax.swing.ImageIcon("D:\\test2\\src\\icon\\customer.png")); // NOI18N
        jLabel12.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Nhân Viên");

        javax.swing.GroupLayout NhanVien_PanelLayout = new javax.swing.GroupLayout(NhanVien_Panel);
        NhanVien_Panel.setLayout(NhanVien_PanelLayout);
        NhanVien_PanelLayout.setHorizontalGroup(
            NhanVien_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NhanVien_PanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        NhanVien_PanelLayout.setVerticalGroup(
            NhanVien_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NhanVien_PanelLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(NhanVien_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        ThongKe_Panel.setBackground(new Color(255, 255, 255));
        ThongKe_Panel.setPreferredSize(new java.awt.Dimension(162, 50));

        jLabel14.setIcon(new javax.swing.ImageIcon("D:\\test2\\src\\icon\\statistical.png")); // NOI18N
        jLabel14.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Thống Kê");

        javax.swing.GroupLayout ThongKe_PanelLayout = new javax.swing.GroupLayout(ThongKe_Panel);
        ThongKe_Panel.setLayout(ThongKe_PanelLayout);
        ThongKe_PanelLayout.setHorizontalGroup(
            ThongKe_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThongKe_PanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ThongKe_PanelLayout.setVerticalGroup(
            ThongKe_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThongKe_PanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(ThongKe_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addGroup(ThongKe_PanelLayout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        TrangChu_Panel.setBackground(new Color(255, 255, 255));
        TrangChu_Panel.setPreferredSize(new java.awt.Dimension(162, 50));
        TrangChu_Panel.setRequestFocusEnabled(false);
        TrangChu_Panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TrangChu_PanelMouseClicked(evt);
            }
        });

        jLabel16.setIcon(new javax.swing.ImageIcon("D:\\test2\\src\\icon\\home.png")); // NOI18N
        jLabel16.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Trang Chủ");
        jLabel17.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel17MouseMoved(evt);
            }
        });
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout TrangChu_PanelLayout = new javax.swing.GroupLayout(TrangChu_Panel);
        TrangChu_Panel.setLayout(TrangChu_PanelLayout);
        TrangChu_PanelLayout.setHorizontalGroup(
            TrangChu_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TrangChu_PanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TrangChu_PanelLayout.setVerticalGroup(
            TrangChu_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TrangChu_PanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(TrangChu_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addGroup(TrangChu_PanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        BanHang_Panel.setBackground(new Color(255, 255, 255));
        BanHang_Panel.setPreferredSize(new java.awt.Dimension(162, 50));
        BanHang_Panel.setRequestFocusEnabled(false);

        jLabel18.setIcon(new javax.swing.ImageIcon("D:\\test2\\src\\icon\\account.png")); // NOI18N
        jLabel18.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Bán hàng");
        jLabel19.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel19MouseMoved(evt);
            }
        });

        SanPham_Panel2.setBackground(new Color(255, 255, 255));
        SanPham_Panel2.setPreferredSize(new java.awt.Dimension(162, 50));
        SanPham_Panel2.setRequestFocusEnabled(false);

        jLabel20.setIcon(new javax.swing.ImageIcon("D:\\test2\\src\\icon\\product.png")); // NOI18N
        jLabel20.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setText("Sản Phẩm");
        jLabel21.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel21MouseMoved(evt);
            }
        });

        javax.swing.GroupLayout SanPham_Panel2Layout = new javax.swing.GroupLayout(SanPham_Panel2);
        SanPham_Panel2.setLayout(SanPham_Panel2Layout);
        SanPham_Panel2Layout.setHorizontalGroup(
            SanPham_Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SanPham_Panel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SanPham_Panel2Layout.setVerticalGroup(
            SanPham_Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SanPham_Panel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(SanPham_Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addGroup(SanPham_Panel2Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout BanHang_PanelLayout = new javax.swing.GroupLayout(BanHang_Panel);
        BanHang_Panel.setLayout(BanHang_PanelLayout);
        BanHang_PanelLayout.setHorizontalGroup(
            BanHang_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BanHang_PanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(BanHang_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SanPham_Panel2, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addContainerGap())
        );
        BanHang_PanelLayout.setVerticalGroup(
            BanHang_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BanHang_PanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(BanHang_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SanPham_Panel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        KhachHang_Panel.setBackground(new Color(255, 255, 255));
        KhachHang_Panel.setPreferredSize(new java.awt.Dimension(162, 50));
        KhachHang_Panel.setRequestFocusEnabled(false);

        jLabel22.setIcon(new javax.swing.ImageIcon("D:\\test2\\src\\icon\\customer.png")); // NOI18N
        jLabel22.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setText("Khách Hàng");

        javax.swing.GroupLayout KhachHang_PanelLayout = new javax.swing.GroupLayout(KhachHang_Panel);
        KhachHang_Panel.setLayout(KhachHang_PanelLayout);
        KhachHang_PanelLayout.setHorizontalGroup(
            KhachHang_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KhachHang_PanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        KhachHang_PanelLayout.setVerticalGroup(
            KhachHang_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KhachHang_PanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(KhachHang_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(KhachHang_PanelLayout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NhaCungCapPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(NhanVien_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(ThongKe_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(TrangChu_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(BanHang_Panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(SanPham_Panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(KhachHang_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                            .addComponent(HoaDon_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(TrangChu_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BanHang_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(SanPham_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(HoaDon_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(KhachHang_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(NhaCungCapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(NhanVien_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ThongKe_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Main_GUILayout = new javax.swing.GroupLayout(Main_GUI);
        Main_GUI.setLayout(Main_GUILayout);
        Main_GUILayout.setHorizontalGroup(
            Main_GUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1417, Short.MAX_VALUE)
        );
        Main_GUILayout.setVerticalGroup(
            Main_GUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 783, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Main_GUI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Main_GUI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1443, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jLabel7MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseMoved
                    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseMoved

    private void jLabel17MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseMoved
        
    }//GEN-LAST:event_jLabel17MouseMoved

    private void TrangChu_PanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TrangChu_PanelMouseClicked
        
        TrangChu_Panel.setBackground(Color.red);
    }//GEN-LAST:event_TrangChu_PanelMouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel19MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel19MouseMoved

    private void jLabel21MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel21MouseMoved

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
            java.util.logging.Logger.getLogger(TrangChu_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangChu_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangChu_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangChu_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrangChu_GUI().setVisible(true);
            }
        });
        
    }
    private SanPham_GUI sanPhamGUI;
    private BanHang_GUI banHangGUI;
    private KhachHang_GUI khachHangGUI;
    private NhaCungCap_GUI nhaCungCap_GUI;
    private JPanel selectedPanel = null;
    private NhanVien_GUI nhanVienGUI;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JPanel BanHang_Panel;
    private JPanel HoaDon_Panel;
    private JPanel KhachHang_Panel;
    private JPanel Main_GUI;
    private JPanel NhaCungCapPanel;
    private JPanel NhanVien_Panel;
    private JPanel SanPham_Panel;
    private JPanel SanPham_Panel2;
    private JPanel ThongKe_Panel;
    private JPanel TrangChu_Panel;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
