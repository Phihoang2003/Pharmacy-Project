/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import config.JDBCUtil;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import utils.Global;
import utils.SVGImage;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

/**
 * @author USER
 */
public class TrangChu_GUI extends JFrame {
    private static final Logger LOGGER = Logger.getLogger(TrangChu_GUI.class.getName());
    private static Stage trangChuStage;
    private static Stage thongKeStage;
    private static double x = 0;
    private static double y = 0;

    public void resetVisible() {
        banHangGUI.setVisible(false);
        khachHangGUI.setVisible(false);
        sanPhamGUI.setVisible(false);
        nhaCungCap_GUI.setVisible(false);
        nhanVienGUI.setVisible(false);
        hoaDonGUI.setVisible(false);
        phieuNhapGUI.setVisible(false);
        doiTraGUI.setVisible(false);
        khuyenMai_GUI.setVisible(false);
        taiKhoan_GUI.setVisible(false);
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
        PhieuNhap_Panel.setBackground(UIManager.getColor(Color.WHITE));
        DoiTra_Panel.setBackground(UIManager.getColor(Color.WHITE));
        KhuyenMai_Panel.setBackground(UIManager.getColor(Color.WHITE));
        TaiKhoan_Panel.setBackground(UIManager.getColor(Color.WHITE));
        DoiTra_Panel.setBackground(UIManager.getColor(Color.WHITE));
    }

    /**
     * Creates new form TrangChu_GUI
     */
    public TrangChu_GUI() throws SQLException {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        checkMedicineExpiry();

        sanPhamGUI = new SanPham_GUI();
        banHangGUI = new BanHang_GUI();
        khachHangGUI = new KhachHang_GUI();
        nhaCungCap_GUI = new NhaCungCap_GUI();
        nhanVienGUI = new NhanVien_GUI();
        hoaDonGUI = new HoaDon_GUI();
        phieuNhapGUI = new PhieuNhap_GUI();
        doiTraGUI = new DoiTra_GUI();
        khuyenMai_GUI = new KhuyenMai_GUI();
        taiKhoan_GUI = new TaiKhoan_GUI();
        Main_GUI.setLayout(new BorderLayout());

        if (Global.getChucvu().equals("Nhân viên")) {
            SanPham_Panel.setVisible(false);
            NhaCungCapPanel.setVisible(false);
            KhuyenMai_Panel.setVisible(false);
            TaiKhoan_Panel.setVisible(false);
            PhieuNhap_Panel.setVisible(false);
            NhanVien_Panel.setVisible(false);
            ThongKe_Panel.setVisible(false);
        }

        if (Global.getChucvu().equals("Quản lý")) {
            // Initialize thongKeStage here
            javafx.application.Platform.runLater(() -> {
                try {
                    Parent root = FXMLLoader.load(Objects.requireNonNull(TrangChu_GUI.class.getResource("ThongKe.fxml")));
                    thongKeStage = new Stage();
                    Scene scene = new Scene(root);
                    root.translateXProperty().set(-scene.getWidth());

                    thongKeStage.setX(273); // Change this to the desired x position
                    thongKeStage.setY(20);

                    root.setOnMousePressed((MouseEvent event) -> {
                        x = event.getSceneX();
                        y = event.getSceneY();
                    });

                    thongKeStage.initStyle(StageStyle.TRANSPARENT);
                    thongKeStage.setScene(scene);
                    thongKeStage.hide(); // Hide the stage initially
                } catch (IOException e) {
                    LOGGER.log(Level.SEVERE, "An error occurred while initializing thongKeStage", e);
                }
            });
        }

        javafx.application.Platform.runLater(() -> {
            try {
                Parent root = FXMLLoader.load(Objects.requireNonNull(TrangChu_GUI.class.getResource("TrangChu.fxml")));
                trangChuStage = new Stage();
                Scene scene = new Scene(root);
                root.translateXProperty().set(-scene.getWidth());

                trangChuStage.setX(273); // Change this to the desired x position
                trangChuStage.setY(20);

                root.setOnMousePressed((MouseEvent event) -> {
                    x = event.getSceneX();
                    y = event.getSceneY();
                });

                root.setOnMouseDragged((MouseEvent event) -> {
                    trangChuStage.setX(event.getSceneX() - x);
                    trangChuStage.setY(event.getSceneY() - y);
                });

                trangChuStage.initStyle(StageStyle.TRANSPARENT);
                trangChuStage.setScene(scene);
                trangChuStage.show();
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "An error occurred while initializing thongKeStage", e);
            }
        });

        resetVisible();

        TrangChu_Panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (selectedPanel != TrangChu_Panel) {
                    TrangChu_Panel.setBackground(new Color(235, 237, 240));
                }
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (selectedPanel != null && selectedPanel != TrangChu_Panel) {
                    javafx.application.Platform.runLater(() -> {
                        trangChuStage.getScene().getWindow().hide(); // Close the stage
                    });
                }
                resetAllPanels();
                TrangChu_Panel.setBackground(new Color(187, 222, 251));
                selectedPanel = TrangChu_Panel;

                javafx.application.Platform.runLater(() -> trangChuStage.show());
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (selectedPanel != TrangChu_Panel) {
                    TrangChu_Panel.setBackground(UIManager.getColor(Color.WHITE));

                }
            }
        });
        ThongKe_Panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (selectedPanel != ThongKe_Panel) {
                    ThongKe_Panel.setBackground(new Color(235, 237, 240));
                }
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (selectedPanel != null && selectedPanel != ThongKe_Panel) {
                    javafx.application.Platform.runLater(() -> {
                        thongKeStage.getScene().getWindow().hide(); // Close the stage
                    });
                }
                resetAllPanels();
                ThongKe_Panel.setBackground(new Color(187, 222, 251));
                selectedPanel = ThongKe_Panel;

                javafx.application.Platform.runLater(() -> {
                    try {
                        Parent root = FXMLLoader.load(Objects.requireNonNull(TrangChu_GUI.class.getResource("ThongKe.fxml")));
                        thongKeStage = new Stage();
                        Scene scene = new Scene(root);
                        root.translateXProperty().set(-scene.getWidth());

                        thongKeStage.setX(273); // Change this to the desired x position
                        thongKeStage.setY(20);

                        root.setOnMousePressed((MouseEvent event) -> {
                            x = event.getSceneX();
                            y = event.getSceneY();
                        });

                        thongKeStage.initStyle(StageStyle.TRANSPARENT);
                        thongKeStage.setScene(scene);
                        thongKeStage.show();
                    } catch (IOException e) {
                        LOGGER.log(Level.SEVERE, "An error occurred while initializing thongKeStage", e);
                    }
                });
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (selectedPanel != ThongKe_Panel) {
                    ThongKe_Panel.setBackground(UIManager.getColor(Color.WHITE));
                }
            }
        });
        SanPham_Panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (selectedPanel != SanPham_Panel) {
                    SanPham_Panel.setBackground(new Color(235, 237, 240));
                }
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetAllPanels();
                SanPham_Panel.setBackground(new Color(187, 222, 251));
                selectedPanel = SanPham_Panel;
                Main_GUI.add(sanPhamGUI, BorderLayout.CENTER);
                resetVisible();
                sanPhamGUI.setVisible(true);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (selectedPanel != SanPham_Panel) {
                    SanPham_Panel.setBackground(UIManager.getColor(Color.WHITE));
                }
            }
        });
        NhaCungCapPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (selectedPanel != NhaCungCapPanel) {
                    NhaCungCapPanel.setBackground(new Color(235, 237, 240));
                }
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetAllPanels();
                NhaCungCapPanel.setBackground(new Color(187, 222, 251));
                selectedPanel = NhaCungCapPanel;
                Main_GUI.add(nhaCungCap_GUI, BorderLayout.CENTER);
                resetVisible();
                nhaCungCap_GUI.setVisible(true);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (selectedPanel != NhaCungCapPanel) {
                    NhaCungCapPanel.setBackground(UIManager.getColor(Color.WHITE));
                }
            }
        });
        HoaDon_Panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (selectedPanel != HoaDon_Panel) {
                    HoaDon_Panel.setBackground(new Color(235, 237, 240));
                }
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetAllPanels();
                HoaDon_Panel.setBackground(new Color(187, 222, 251));
                selectedPanel = HoaDon_Panel;
                Main_GUI.add(hoaDonGUI, BorderLayout.CENTER);
                resetVisible();
                hoaDonGUI.setVisible(true);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (selectedPanel != HoaDon_Panel) {
                    HoaDon_Panel.setBackground(UIManager.getColor(Color.WHITE));
                }
            }
        });

        NhanVien_Panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (selectedPanel != NhanVien_Panel) {
                    NhanVien_Panel.setBackground(new Color(235, 237, 240));
                }
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetAllPanels();
                NhanVien_Panel.setBackground(new Color(187, 222, 251));
                selectedPanel = NhanVien_Panel;
                Main_GUI.add(nhanVienGUI, BorderLayout.CENTER);
                resetVisible();
                nhanVienGUI.setVisible(true);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (selectedPanel != NhanVien_Panel) {
                    NhanVien_Panel.setBackground(UIManager.getColor(Color.WHITE));
                }
            }
        });

        BanHang_Panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (selectedPanel != BanHang_Panel) {
                    BanHang_Panel.setBackground(new Color(235, 237, 240));
                }
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {

                resetAllPanels();
                BanHang_Panel.setBackground(new Color(187, 222, 251));
                selectedPanel = BanHang_Panel;
                Main_GUI.add(banHangGUI, BorderLayout.CENTER);
                resetVisible();
                banHangGUI.setVisible(true);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (selectedPanel != BanHang_Panel) {
                    BanHang_Panel.setBackground(UIManager.getColor(Color.WHITE));
                }
            }
        });

        KhachHang_Panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (selectedPanel != KhachHang_Panel) {
                    KhachHang_Panel.setBackground(new Color(235, 237, 240));
                }
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {

                resetAllPanels();
                KhachHang_Panel.setBackground(new Color(187, 222, 251));
                selectedPanel = KhachHang_Panel;
                Main_GUI.add(khachHangGUI, BorderLayout.CENTER);
                resetVisible();
                khachHangGUI.setVisible(true);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (selectedPanel != KhachHang_Panel) {
                    KhachHang_Panel.setBackground(UIManager.getColor(Color.WHITE));
                }
            }
        });
        PhieuNhap_Panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (selectedPanel != PhieuNhap_Panel) {
                    PhieuNhap_Panel.setBackground(new Color(235, 237, 240));
                }
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {

                resetAllPanels();
                PhieuNhap_Panel.setBackground(new Color(187, 222, 251));
                selectedPanel = PhieuNhap_Panel;
                Main_GUI.add(phieuNhapGUI, BorderLayout.CENTER);
                resetVisible();
                phieuNhapGUI.setVisible(true);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (selectedPanel != PhieuNhap_Panel) {
                    PhieuNhap_Panel.setBackground(UIManager.getColor(Color.WHITE));
                }
            }
        });
        KhuyenMai_Panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (selectedPanel != KhuyenMai_Panel) {
                    KhuyenMai_Panel.setBackground(new Color(235, 237, 240));
                }
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {

                resetAllPanels();
                KhuyenMai_Panel.setBackground(new Color(187, 222, 251));
                selectedPanel = KhuyenMai_Panel;
                Main_GUI.add(khuyenMai_GUI, BorderLayout.CENTER);
                resetVisible();
                khuyenMai_GUI.setVisible(true);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (selectedPanel != KhuyenMai_Panel) {
                    KhuyenMai_Panel.setBackground(UIManager.getColor(Color.WHITE));
                }
            }
        });

        TaiKhoan_Panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (selectedPanel != TaiKhoan_Panel) {
                    TaiKhoan_Panel.setBackground(new Color(235, 237, 240));
                }
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {

                resetAllPanels();
                TaiKhoan_Panel.setBackground(new Color(187, 222, 251));
                selectedPanel = TaiKhoan_Panel;
                Main_GUI.add(taiKhoan_GUI, BorderLayout.CENTER);
                resetVisible();
                taiKhoan_GUI.setVisible(true);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (selectedPanel != TaiKhoan_Panel) {
                    TaiKhoan_Panel.setBackground(UIManager.getColor(Color.WHITE));
                }
            }
        });

        DoiTra_Panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (selectedPanel != DoiTra_Panel) {
                    DoiTra_Panel.setBackground(new Color(235, 237, 240));
                }
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {

                resetAllPanels();
                DoiTra_Panel.setBackground(new Color(187, 222, 251));
                selectedPanel = DoiTra_Panel;
                Main_GUI.add(doiTraGUI, BorderLayout.CENTER);
                resetVisible();
                doiTraGUI.setVisible(true);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (selectedPanel != DoiTra_Panel) {
                    DoiTra_Panel.setBackground(UIManager.getColor(Color.WHITE));
                }
            }
        });


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        setTitle("Phần mềm quản lý nhà thuốc Chevalier");
        JPanel jPanel1 = new JPanel();
        SVGImage jLabel1 = new SVGImage();
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();
        JSeparator jSeparator1 = new JSeparator();
        JPanel jPanel2 = new JPanel();
        SanPham_Panel = new JPanel();
        SVGImage jLabel6 = new SVGImage();
        JLabel jLabel7 = new JLabel();
        HoaDon_Panel = new JPanel();
        SVGImage jLabel8 = new SVGImage();
        JLabel jLabel9 = new JLabel();
        NhaCungCapPanel = new JPanel();
        SVGImage jLabel10 = new SVGImage();
        JLabel jLabel11 = new JLabel();
        NhanVien_Panel = new JPanel();
        SVGImage jLabel12 = new SVGImage();
        JLabel jLabel13 = new JLabel();
        ThongKe_Panel = new JPanel();
        SVGImage jLabel14 = new SVGImage();
        JLabel jLabel15 = new JLabel();
        BanHang_Panel = new JPanel();
        SVGImage jLabel18 = new SVGImage();
        JLabel jLabel19 = new JLabel();
        SVGImage jLabel20 = new SVGImage();
        JLabel jLabel21 = new JLabel();
        KhachHang_Panel = new JPanel();
        SVGImage jLabel22 = new SVGImage();
        JLabel jLabel23 = new JLabel();
        PhieuNhap_Panel = new JPanel();
        SVGImage jLabel24 = new SVGImage();
        JLabel jLabel25 = new JLabel();
        DoiTra_Panel = new JPanel();
        SVGImage jLabel26 = new SVGImage();
        JLabel jLabel27 = new JLabel();
        TrangChu_Panel = new JPanel();
        SVGImage jLabel16 = new SVGImage();
        JLabel jLabel17 = new JLabel();
        KhuyenMai_Panel = new JPanel();
        SVGImage jLabel28 = new SVGImage();
        JLabel jlabel = new JLabel();
        TaiKhoan_Panel = new JPanel();
        SVGImage jLabel30 = new SVGImage();
        JLabel jLabel31 = new JLabel();
        Main_GUI = new JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(200, 100));
        jPanel1.setName("");
        jPanel1.setPreferredSize(new java.awt.Dimension(3000, 600));

        jLabel1.setFont(new Font("Ban", Font.PLAIN, 14));
        jLabel1.setSvgImage("icon/logout.svg", 60, 60);
        jLabel1.setMaximumSize(new java.awt.Dimension(60, 60));
        jLabel1.setPreferredSize(new java.awt.Dimension(2000, 2000));

        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                // Close the current TrangChu_GUI
                dispose();
                javafx.application.Platform.runLater(() -> {
                    trangChuStage.close();
                    thongKeStage.close();
                });

                // Create a new instance of DangNhap_GUI and make it visible
                java.awt.EventQueue.invokeLater(() -> {
                    try {
                        new DangNhap_GUI().setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
        });

        jLabel2.setFont(new Font("Bahnschrift", Font.BOLD, 18));
        jLabel2.setText(Global.getName());

        jLabel3.setBackground(new Color(204, 204, 204));
        jLabel3.setFont(new Font("Bahnschrift Light", Font.PLAIN, 14));
        jLabel3.setText(Global.getChucvu());

        jSeparator1.setForeground(new Color(204, 204, 204));

        jPanel2.setBackground(new Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(313, 600));

        SanPham_Panel.setBackground(new Color(255, 255, 255));
        SanPham_Panel.setPreferredSize(new java.awt.Dimension(162, 50));
        SanPham_Panel.setRequestFocusEnabled(false);

        jLabel6.setSvgImage("icon/product.svg", 35, 35);
        jLabel6.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel7.setFont(new Font("Bahnschrift", Font.BOLD, 13));
        jLabel7.setText("Sản Phẩm");

        GroupLayout SanPham_PanelLayout = new GroupLayout(SanPham_Panel);
        SanPham_Panel.setLayout(SanPham_PanelLayout);
        SanPham_PanelLayout.setHorizontalGroup(
                SanPham_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(SanPham_PanelLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SanPham_PanelLayout.setVerticalGroup(
                SanPham_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        HoaDon_Panel.setBackground(new Color(255, 255, 255));
        HoaDon_Panel.setPreferredSize(new java.awt.Dimension(162, 50));

        jLabel8.setSvgImage("icon/bill.svg", 35, 35);
        jLabel8.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel9.setFont(new Font("Bahnschrift", Font.BOLD, 13));
        jLabel9.setText("Hóa Đơn");

        GroupLayout HoaDon_PanelLayout = new GroupLayout(HoaDon_Panel);
        HoaDon_Panel.setLayout(HoaDon_PanelLayout);
        HoaDon_PanelLayout.setHorizontalGroup(
                HoaDon_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(HoaDon_PanelLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HoaDon_PanelLayout.setVerticalGroup(
                HoaDon_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        NhaCungCapPanel.setBackground(new Color(255, 255, 255));
        NhaCungCapPanel.setPreferredSize(new java.awt.Dimension(162, 50));

        jLabel10.setSvgImage("icon/supplier.svg", 35, 35);
        jLabel10.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel11.setFont(new Font("Bahnschrift", Font.BOLD, 13));
        jLabel11.setText("Nhà Cung Cấp");

        javax.swing.GroupLayout NhaCungCapPanelLayout = new javax.swing.GroupLayout(NhaCungCapPanel);
        NhaCungCapPanel.setLayout(NhaCungCapPanelLayout);
        NhaCungCapPanelLayout.setHorizontalGroup(
                NhaCungCapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(NhaCungCapPanelLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        NhaCungCapPanelLayout.setVerticalGroup(
                NhaCungCapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        NhanVien_Panel.setBackground(new Color(255, 255, 255));
        NhanVien_Panel.setPreferredSize(new java.awt.Dimension(162, 50));

        jLabel12.setSvgImage("icon/employee.svg", 35, 35);
        jLabel12.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel13.setFont(new Font("Bahnschrift", Font.BOLD, 13));
        jLabel13.setText("Nhân Viên");

        javax.swing.GroupLayout NhanVien_PanelLayout = new javax.swing.GroupLayout(NhanVien_Panel);
        NhanVien_Panel.setLayout(NhanVien_PanelLayout);
        NhanVien_PanelLayout.setHorizontalGroup(
                NhanVien_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(NhanVien_PanelLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        NhanVien_PanelLayout.setVerticalGroup(
                NhanVien_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        ThongKe_Panel.setBackground(new Color(255, 255, 255));
        ThongKe_Panel.setPreferredSize(new java.awt.Dimension(162, 50));

        jLabel14.setSvgImage("icon/statistic.svg", 35, 35);
        jLabel14.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel15.setFont(new Font("Bahnschrift", Font.BOLD, 13));
        jLabel15.setText("Thống Kê");

        javax.swing.GroupLayout ThongKe_PanelLayout = new javax.swing.GroupLayout(ThongKe_Panel);
        ThongKe_Panel.setLayout(ThongKe_PanelLayout);
        ThongKe_PanelLayout.setHorizontalGroup(
                ThongKe_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ThongKe_PanelLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ThongKe_PanelLayout.setVerticalGroup(
                ThongKe_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 42, Short.MAX_VALUE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        BanHang_Panel.setBackground(new Color(255, 255, 255));
        BanHang_Panel.setPreferredSize(new java.awt.Dimension(162, 50));
        BanHang_Panel.setRequestFocusEnabled(false);

        jLabel18.setSvgImage("icon/sell.svg", 35, 35);
        jLabel18.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel19.setFont(new Font("Bahnschrift", Font.BOLD, 13));
        jLabel19.setText("Bán hàng");

        jLabel20.setSvgImage("icon/product.svg", 35, 35);
        jLabel20.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel21.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        jLabel21.setText("Sản Phẩm");

        javax.swing.GroupLayout BanHang_PanelLayout = new javax.swing.GroupLayout(BanHang_Panel);
        BanHang_Panel.setLayout(BanHang_PanelLayout);
        BanHang_PanelLayout.setHorizontalGroup(
                BanHang_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(BanHang_PanelLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel18, GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel19, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BanHang_PanelLayout.setVerticalGroup(
                BanHang_PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        KhachHang_Panel.setBackground(new Color(255, 255, 255));
        KhachHang_Panel.setPreferredSize(new java.awt.Dimension(162, 50));
        KhachHang_Panel.setRequestFocusEnabled(false);

        jLabel22.setSvgImage("icon/customer.svg", 35, 35);
        jLabel22.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel23.setFont(new Font("Bahnschrift", Font.BOLD, 13));
        jLabel23.setText("Khách Hàng");

        javax.swing.GroupLayout KhachHang_PanelLayout = new javax.swing.GroupLayout(KhachHang_Panel);
        KhachHang_Panel.setLayout(KhachHang_PanelLayout);
        KhachHang_PanelLayout.setHorizontalGroup(
                KhachHang_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(KhachHang_PanelLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        KhachHang_PanelLayout.setVerticalGroup(
                KhachHang_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        PhieuNhap_Panel.setBackground(new Color(255, 255, 255));
        PhieuNhap_Panel.setPreferredSize(new java.awt.Dimension(162, 50));
        PhieuNhap_Panel.setRequestFocusEnabled(false);

        jLabel24.setSvgImage("icon/document.svg", 35, 35);
        jLabel24.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel25.setFont(new Font("Bahnschrift", Font.BOLD, 13));
        jLabel25.setText("Phiếu Nhập");

        javax.swing.GroupLayout PhieuNhap_PanelLayout = new javax.swing.GroupLayout(PhieuNhap_Panel);
        PhieuNhap_Panel.setLayout(PhieuNhap_PanelLayout);
        PhieuNhap_PanelLayout.setHorizontalGroup(
                PhieuNhap_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PhieuNhap_PanelLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PhieuNhap_PanelLayout.setVerticalGroup(
                PhieuNhap_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        DoiTra_Panel.setBackground(new Color(255, 255, 255));
        DoiTra_Panel.setPreferredSize(new java.awt.Dimension(162, 50));
        DoiTra_Panel.setRequestFocusEnabled(false);

        jLabel26.setSvgImage("icon/return.svg", 35, 35);
        jLabel26.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel27.setFont(new Font("Bahnschrift", Font.BOLD, 13));
        jLabel27.setText("Đổi Trả");

        javax.swing.GroupLayout DoiTra_PanelLayout = new javax.swing.GroupLayout(DoiTra_Panel);
        DoiTra_Panel.setLayout(DoiTra_PanelLayout);
        DoiTra_PanelLayout.setHorizontalGroup(
                DoiTra_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(DoiTra_PanelLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DoiTra_PanelLayout.setVerticalGroup(
                DoiTra_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        TrangChu_Panel.setBackground(new Color(255, 255, 255));
        TrangChu_Panel.setPreferredSize(new java.awt.Dimension(162, 50));
        TrangChu_Panel.setRequestFocusEnabled(false);


        jLabel16.setSvgImage("icon/home.svg", 35, 35);
        jLabel16.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel17.setFont(new Font("Bahnschrift", Font.BOLD, 13));
        jLabel17.setText("Trang Chủ");

        javax.swing.GroupLayout TrangChu_PanelLayout = new javax.swing.GroupLayout(TrangChu_Panel);
        TrangChu_Panel.setLayout(TrangChu_PanelLayout);
        TrangChu_PanelLayout.setHorizontalGroup(
                TrangChu_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(TrangChu_PanelLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TrangChu_PanelLayout.setVerticalGroup(
                TrangChu_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        KhuyenMai_Panel.setBackground(new Color(255, 255, 255));
        KhuyenMai_Panel.setPreferredSize(new java.awt.Dimension(162, 50));

        jLabel28.setSvgImage("icon/coupon.svg", 35, 35);
        jLabel28.setPreferredSize(new java.awt.Dimension(40, 40));

        jlabel.setFont(new Font("Bahnschrift", Font.BOLD, 13));
        jlabel.setText("Khuyến Mãi");

        javax.swing.GroupLayout KhuyenMai_PanelLayout = new javax.swing.GroupLayout(KhuyenMai_Panel);
        KhuyenMai_Panel.setLayout(KhuyenMai_PanelLayout);
        KhuyenMai_PanelLayout.setHorizontalGroup(
                KhuyenMai_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(KhuyenMai_PanelLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        KhuyenMai_PanelLayout.setVerticalGroup(
                KhuyenMai_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        TaiKhoan_Panel.setBackground(new Color(255, 255, 255));
        TaiKhoan_Panel.setPreferredSize(new java.awt.Dimension(162, 50));

        jLabel30.setSvgImage("icon/account.svg", 35, 35);
        jLabel30.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel31.setFont(new Font("Bahnschrift", Font.BOLD, 13));
        jLabel31.setText("Tài Khoản");

        javax.swing.GroupLayout TaiKhoan_PanelLayout = new javax.swing.GroupLayout(TaiKhoan_Panel);
        TaiKhoan_Panel.setLayout(TaiKhoan_PanelLayout);
        TaiKhoan_PanelLayout.setHorizontalGroup(
                TaiKhoan_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(TaiKhoan_PanelLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TaiKhoan_PanelLayout.setVerticalGroup(
                TaiKhoan_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(TaiKhoan_Panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                        .addComponent(KhuyenMai_Panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                        .addComponent(KhachHang_Panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                        .addComponent(SanPham_Panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                        .addComponent(BanHang_Panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                        .addComponent(NhaCungCapPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                        .addComponent(NhanVien_Panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                        .addComponent(TrangChu_Panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                        .addComponent(HoaDon_Panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                        .addComponent(DoiTra_Panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                        .addComponent(PhieuNhap_Panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                        .addComponent(ThongKe_Panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(TrangChu_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(BanHang_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(SanPham_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(HoaDon_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(DoiTra_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(PhieuNhap_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(KhachHang_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(NhaCungCapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(NhanVien_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(ThongKe_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(KhuyenMai_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(TaiKhoan_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15))
        );

        Main_GUI.setPreferredSize(new java.awt.Dimension(1500, 800));

        javax.swing.GroupLayout Main_GUILayout = new javax.swing.GroupLayout(Main_GUI);
        Main_GUI.setLayout(Main_GUILayout);
        Main_GUILayout.setHorizontalGroup(
                Main_GUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1684, Short.MAX_VALUE)
        );
        Main_GUILayout.setVerticalGroup(
                Main_GUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 795, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(16, 16, 16)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGap(14, 14, 14)
                                                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(24, 24, 24)
                                .addComponent(Main_GUI, javax.swing.GroupLayout.DEFAULT_SIZE, 1684, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(15, 15, 15)
                                                                .addComponent(jLabel2)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel3)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(1, 1, 1))
                                        .addComponent(Main_GUI, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1958, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 828, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        public boolean isExpiringSoon(Date expiryDate) {
        LocalDate today = LocalDate.now();
        // Convert java.sql.Date to java.time.LocalDate
        LocalDate expiryLocalDate = expiryDate.toLocalDate();
        return expiryLocalDate.isBefore(today.plusMonths(1)) && !expiryLocalDate.isBefore(today);
    }

    public void checkMedicineExpiry() {
        String sql = "SELECT * FROM thuoc";
        StringBuilder warningMessage = new StringBuilder();

        try {
            Connection connect = JDBCUtil.getConnection();
            PreparedStatement prepare = connect.prepareStatement(sql);
            ResultSet result = prepare.executeQuery();

            while (result.next()) {
                Date expiryDate = result.getDate("hanSuDung");
                if (isExpiringSoon(expiryDate)) {
                    String medicineName = result.getString("tenThuoc");
                    // Convert expiryDate to String
                    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    String strExpiryDate = dateFormat.format(expiryDate);
                    // Append the warning message for this medicine to the overall warning message
                    // Append the warning message for this medicine to the overall warning message
                    warningMessage.append("Thuốc ").append(medicineName).append(" sắp hết hạn trong vòng 1 tháng. Ngày hết hạn: ").append(strExpiryDate).append("\n");
                }
            }

            // If there are any medicines expiring soon, display the warning message
            if (warningMessage.length() > 0) {
                JOptionPane.showMessageDialog(null, warningMessage.toString(), "Cảnh báo thuốc sắp hết hạn", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "An error occurred while checking medicine expiry dates", e);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    /* Set the Nimbus look and feel */
    // Existing look and feel setting code...

    /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                TrangChu_GUI trangChuGui = new TrangChu_GUI();
                trangChuGui.setVisible(true);
                new JFXPanel();

                // Load TrangChu.fxml
                javafx.application.Platform.runLater(() -> {
                    try {
                        Parent root = FXMLLoader.load(Objects.requireNonNull(TrangChu_GUI.class.getResource("TrangChu.fxml")));
                        trangChuStage = new Stage();
                        Scene scene = new Scene(root);
                        root.translateXProperty().set(-scene.getWidth());

                        trangChuStage.setX(290); // Change this to the desired x position
                        trangChuStage.setY(20);

                        root.setOnMousePressed((MouseEvent event) -> {
                            x = event.getSceneX();
                            y = event.getSceneY();
                        });

                        trangChuStage.initStyle(StageStyle.TRANSPARENT);
                        trangChuStage.setScene(scene);
                        trangChuStage.hide(); // Hide the stage initially
                    } catch (IOException e) {
                        LOGGER.log(Level.SEVERE, "An error occurred while initializing trangChuStage", e);
                    }
                });
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }
    private final SanPham_GUI sanPhamGUI;
    private final BanHang_GUI banHangGUI;
    private final KhachHang_GUI khachHangGUI;
    private final NhaCungCap_GUI nhaCungCap_GUI;
    private JPanel selectedPanel = null;
    private final NhanVien_GUI nhanVienGUI;
    private final HoaDon_GUI hoaDonGUI;
    private final PhieuNhap_GUI phieuNhapGUI;
    private final DoiTra_GUI doiTraGUI;
    private final KhuyenMai_GUI khuyenMai_GUI;
    private final TaiKhoan_GUI taiKhoan_GUI;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JPanel BanHang_Panel;
    private JPanel DoiTra_Panel;
    private JPanel HoaDon_Panel;
    private JPanel KhachHang_Panel;
    private JPanel KhuyenMai_Panel;
    private JPanel Main_GUI;
    private JPanel NhaCungCapPanel;
    private JPanel NhanVien_Panel;
    private JPanel PhieuNhap_Panel;
    private JPanel SanPham_Panel;
    private JPanel TaiKhoan_Panel;
    private JPanel ThongKe_Panel;
    private JPanel TrangChu_Panel;
}
