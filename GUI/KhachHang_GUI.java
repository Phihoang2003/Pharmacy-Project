/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.KhachHang_bus;
import DAO.KhachHangDAO;
import DTO.KhachHang;
import utils.SVGImage;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KhachHang_GUI extends JPanel {
    private final KhachHang_bus bus = new KhachHang_bus();
    private final KhachHangDAO nvdao = new KhachHangDAO();
    private DefaultTableModel tableModel = new DefaultTableModel();
    private JTable table_DSKH;
    private JDialog CapNhatKhachHangDialog;
    private ButtonGroup Gender;
    private JDialog ThemKhachHangDialog;
    private JButton btn_LamMoi;
    private JButton btn_TimKiem;
    private JRadioButton rad_nam;
    private JRadioButton rad_nam1;
    private JRadioButton rad_nu1;
    private JTextField txt_NhapSDT;
    private JTextField txt_ma;
    private JTextField txt_ma1;
    private JTextField txt_sdt;
    private JTextField txt_sdt1;
    private JTextField txt_ten;
    private JTextField txt_ten1;
    private JPanel iconThem;
    private JPanel iconCapNhat;

    public KhachHang_GUI() {

        initComponents();
        ImageIcon img_btnTimKiem = new ImageIcon("icon/buttonTimKiem.png");
        Image scaled_btnTimKiem = img_btnTimKiem.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnTimKiem = new ImageIcon(scaled_btnTimKiem);
        btn_TimKiem.setIcon(img_btnTimKiem);
        SVGImage img_btnLamMoi = new SVGImage();
        img_btnLamMoi.setSvgImage("icon/update.svg", 15, 15);
        btn_LamMoi.setIcon(img_btnLamMoi.getIcon());

        iconThem.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                ThemKhachHangDialog.setVisible(true);
            }
        });

        iconCapNhat.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                int selectedRow = table_DSKH.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Bạn chưa chọn khách hàng cần cập nhật");
                    return;
                }
                CapNhatKhachHangDialog.setVisible(true);
            }
        });

        tableModel = (DefaultTableModel) table_DSKH.getModel();
        table_DSKH.setModel(tableModel);
        loadData();

        refresh();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        CapNhatKhachHangDialog = new JDialog();
        ThemKhachHangDialog = new JDialog();
        table_DSKH = new JTable();
        JButton btnCapNhat = new JButton();
        JButton btnHuyCapNhat = new JButton();
        iconThem = new JPanel();
        iconCapNhat = new JPanel();

        rad_nam1 = new JRadioButton();
        rad_nu1 = new JRadioButton();
        txt_ten1 = new JTextField();
        txt_ma1 = new JTextField();
        txt_sdt1 = new JTextField();
        txt_NhapSDT = new JTextField();
        txt_sdt = new JTextField();
        txt_ten = new JTextField();

        SVGImage jLabel2 = new SVGImage();
        JPanel jPanel6 = new JPanel();
        JPanel jPanel9 = new JPanel();
        JLabel jLabel8 = new JLabel();
        JLabel lblHoTen = new JLabel();
        JLabel lblGioiTinh = new JLabel();
        JLabel lblGioiTinh1 = new JLabel();
        JLabel lblHoTen1 = new JLabel();
        JLabel lblMa1 = new JLabel();
        JLabel lblSDT1 = new JLabel();

        rad_nam = new JRadioButton();
        JRadioButton rad_nu = new JRadioButton();
        JLabel lblSDT = new JLabel();
        txt_ma = new JTextField();
        JLabel lblMa = new JLabel();
        JButton btnHuyThem = new JButton();
        JLabel jLabel14 = new JLabel();
        JButton btnThem = new JButton();
        JPanel jPanel1 = new JPanel();
        JLabel jLabel1 = new JLabel();
        SVGImage jLabel5 = new SVGImage();
        JLabel jLabel3 = new JLabel();
        JPanel jPanel5 = new JPanel();
        JPanel jPanel10 = new JPanel();
        JPanel jPanel11 = new JPanel();

        JLabel jLabel4 = new JLabel();
        SVGImage jLabel11 = new SVGImage();
        JPanel jPanel7 = new JPanel();
        SVGImage jLabel9 = new SVGImage();
        JLabel jLabel10 = new JLabel();
        JTextField jTextField1 = new JTextField();
        btn_LamMoi = new JButton();
        btn_TimKiem = new JButton();
        JPanel jPanel8 = new JPanel();
        JScrollPane jScrollPane1 = new JScrollPane();
        Gender = new ButtonGroup();

        ThemKhachHangDialog.setTitle("Thêm Khách Hàng");
        ThemKhachHangDialog.setAlwaysOnTop(true);
        ThemKhachHangDialog.setBackground(new Color(255, 255, 255));
        ThemKhachHangDialog.setLocation(new Point(500, 200));
        ThemKhachHangDialog.setSize(new Dimension(490, 545));
        ThemKhachHangDialog.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                ThemKhachHangDialogMouseClicked();
            }
        });
        jPanel6.setBackground(new Color(255, 255, 255));

        jPanel9.setBackground(new Color(37, 51, 49));

        jLabel8.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 14));
        jLabel8.setForeground(new Color(255, 255, 255));
        jLabel8.setText("THÊM KHÁCH HÀNG");
        jLabel8.setHorizontalAlignment(JLabel.CENTER);

        GroupLayout jPanel9Layout = new GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
                jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addContainerGap(168, Short.MAX_VALUE)
                                .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(168, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
                jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addContainerGap(24, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addGap(21, 21, 21))
        );

        lblHoTen.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
        lblHoTen.setText("Tên Khách Hàng");

        lblGioiTinh.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
        lblGioiTinh.setText("Giới Tính");

        Gender.add(rad_nam);
        rad_nam.setSelected(true);
        rad_nam.setText("Nam");

        Gender.add(rad_nu);
        rad_nu.setText("Nữ");

        lblSDT.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
        lblSDT.setText("Số Điện Thoại");

        lblMa.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
        lblMa.setText("Mã khách hàng");
        txt_ma.setEditable(false);
        txt_ma.setBackground(new Color(204, 204, 204));

        btnThem.setBackground(new Color(22, 97, 86));
        btnThem.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 13));
        btnThem.setForeground(new Color(255, 255, 255));
        btnThem.setText("Thêm Khách Hàng");
        btnThem.addActionListener(this::btnThemActionPerformed);

        btnHuyThem.setBackground(new Color(173, 79, 40));
        btnHuyThem.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 13));
        btnHuyThem.setForeground(new Color(255, 255, 255));
        btnHuyThem.setText("Hủy Bỏ");
        // Đặt kích thước cho btnHuyThem bằng với btnThem
        btnHuyThem.setPreferredSize(btnThem.getPreferredSize());

        btnHuyThem.addActionListener(e -> {
            // Tìm cửa sổ chứa btnHuyThem và đóng nó
            Window window = SwingUtilities.getWindowAncestor(btnHuyThem);
            if (window != null) {
                window.dispose();
            }
        });

        GroupLayout jPanel6Layout = new GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);

        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(40)
                                        .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(lblMa, GroupLayout.PREFERRED_SIZE, 390, Short.MAX_VALUE)
                                                .addComponent(txt_ma, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblHoTen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txt_ten, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblSDT, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txt_sdt, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel6Layout.createSequentialGroup()
                                                        .addComponent(lblGioiTinh, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(rad_nam)
                                                        .addGap(30)
                                                        .addComponent(rad_nu))
                                                .addGroup(jPanel6Layout.createSequentialGroup()
                                                        .addGap(30)
                                                        .addComponent(btnThem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addGap(40)
                                                        .addComponent(btnHuyThem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        )
                                )
                        )
        );

        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jPanel9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(lblMa, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_ma, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblHoTen, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_ten, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblSDT, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_sdt, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblGioiTinh)
                                        .addComponent(rad_nam)
                                        .addComponent(rad_nu))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnHuyThem, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                                .addGap(50)
                        )
        );

        GroupLayout ThemKhachHangDialogLayout = new GroupLayout(ThemKhachHangDialog.getContentPane());
        ThemKhachHangDialog.getContentPane().setLayout(ThemKhachHangDialogLayout);
        ThemKhachHangDialogLayout.setHorizontalGroup(
                ThemKhachHangDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ThemKhachHangDialogLayout.setVerticalGroup(
                ThemKhachHangDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        CapNhatKhachHangDialog.setTitle("CẬP NHẬT KHÁCH HÀNG");
        CapNhatKhachHangDialog.setAlwaysOnTop(true);
        CapNhatKhachHangDialog.setBackground(new Color(255, 255, 255));
        CapNhatKhachHangDialog.setLocation(new Point(500, 50));
        CapNhatKhachHangDialog.setSize(new Dimension(630, 740));

        jPanel10.setBackground(new Color(255, 255, 255));
        jPanel11.setBackground(new Color(22, 97, 86));

        jLabel14.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 14));
        jLabel14.setForeground(new Color(255, 255, 255));
        jLabel14.setText("CẬP NHẬT KHÁCH HÀNG");

        GroupLayout jPanel11Layout = new GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
                jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel14)
                                .addGap(206, 206, 206))
        );
        jPanel11Layout.setVerticalGroup(
                jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel14)
                                .addContainerGap(26, Short.MAX_VALUE))
        );

        lblSDT1.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
        lblSDT1.setText("Số Điện Thoại");

        lblHoTen1.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
        lblHoTen1.setText("Họ Tên");

        lblMa1.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
        lblMa1.setText("Mã Khách Hàng");

        txt_ma1.setEditable(false);
        txt_ma1.setBackground(new Color(204, 204, 204));

        lblGioiTinh1.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
        lblGioiTinh1.setText("Giới Tính");

        Gender.add(rad_nam1);
        rad_nam1.setText("Nam");

        Gender.add(rad_nu1);
        rad_nu1.setText("Nữ");

        btnCapNhat.setBackground(new Color(22, 97, 86));
        btnCapNhat.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 13));
        btnCapNhat.setForeground(new Color(255, 255, 255));
        btnCapNhat.setText("Cập Nhật Khách Hàng");
        btnCapNhat.addActionListener(this::btnCapNhatActionPerformed);

        btnHuyCapNhat.setBackground(new Color(204, 0, 51));
        btnHuyCapNhat.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 13));
        btnHuyCapNhat.setForeground(new Color(255, 255, 255));
        btnHuyCapNhat.setText("Hủy Bỏ");
        btnHuyCapNhat.addActionListener(this::btnHuyCapNhatActionPerformed);

        GroupLayout jPanel10Layout = new GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);

        jPanel10Layout.setHorizontalGroup(
                jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel11, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGap(40)
                                        .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(lblMa1, GroupLayout.PREFERRED_SIZE, 390, Short.MAX_VALUE)
                                                .addComponent(txt_ma1, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblHoTen1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txt_ten1, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblSDT1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txt_sdt1, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel10Layout.createSequentialGroup()
                                                        .addComponent(lblGioiTinh1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(rad_nam1)
                                                        .addGap(30)
                                                        .addComponent(rad_nu1))
                                                .addGroup(jPanel10Layout.createSequentialGroup()
                                                        .addGap(30)
                                                        .addComponent(btnCapNhat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addGap(40)
                                                        .addComponent(btnHuyCapNhat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        )
                                )
                        )
        );

        jPanel10Layout.setVerticalGroup(
                jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jPanel11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(lblMa1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_ma1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblHoTen1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_ten1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblSDT1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_sdt1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblGioiTinh1)
                                        .addComponent(rad_nam1)
                                        .addComponent(rad_nu1))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnCapNhat, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnHuyCapNhat, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                                .addGap(50)
                        )
        );

        GroupLayout CapNhatKhachHangDialogLayout = new GroupLayout(CapNhatKhachHangDialog.getContentPane());
        CapNhatKhachHangDialog.getContentPane().setLayout(CapNhatKhachHangDialogLayout);
        CapNhatKhachHangDialogLayout.setHorizontalGroup(
                CapNhatKhachHangDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(CapNhatKhachHangDialogLayout.createSequentialGroup()
                                .addComponent(jPanel10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        CapNhatKhachHangDialogLayout.setVerticalGroup(
                CapNhatKhachHangDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(CapNhatKhachHangDialogLayout.createSequentialGroup()
                                .addComponent(jPanel10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        setBackground(new Color(255, 255, 255));

        jPanel1.setBackground(new Color(255, 255, 255));

        iconThem.setBackground(new Color(255, 255, 255));
        jLabel2.setSvgImage("icon/person-fill-add.svg", 70, 70);
        jLabel1.setBackground(new Color(255, 255, 255));
        jLabel1.setFont(new Font("Bahnschrift", Font.BOLD, 16));
        jLabel1.setForeground(new Color(102, 102, 255));
        jLabel1.setText("THÊM");
        jLabel1.setHorizontalAlignment(JLabel.CENTER);

        GroupLayout iconThemLayout = new GroupLayout(iconThem);
        iconThem.setLayout(iconThemLayout);

        iconThemLayout.setHorizontalGroup(
                iconThemLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
        );
        iconThemLayout.setVerticalGroup(
                iconThemLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        iconCapNhat.setBackground(new Color(255, 255, 255));

        jLabel5.setSvgImage("icon/edit.svg", 70, 70);

        jLabel3.setFont(new Font("Bahnschrift", Font.BOLD, 16));
        jLabel3.setForeground(new Color(102, 102, 255));
        jLabel3.setText("CẬP NHẬT");
        jLabel3.setHorizontalAlignment(JLabel.CENTER);

        GroupLayout iconCapNhatLayout = new GroupLayout(iconCapNhat);
        iconCapNhat.setLayout(iconCapNhatLayout);
        iconCapNhatLayout.setHorizontalGroup(
                iconCapNhatLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel5)
                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
        );
        iconCapNhatLayout.setVerticalGroup(
                iconCapNhatLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new Color(255, 255, 255));

        jLabel4.setFont(new Font("Bahnschrift", Font.BOLD, 16));
        jLabel4.setForeground(new Color(102, 102, 255));
        jLabel4.setText("CHI TIẾT");
        jLabel4.setHorizontalAlignment(JLabel.CENTER);

        jLabel11.setSvgImage("icon/detail.svg", 70, 70);

        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel11)
                        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
        );

        jPanel7.setBackground(new Color(255, 255, 255));

        jLabel9.setSvgImage("icon/excel.svg", 70, 70);

        jLabel10.setFont(new Font("Bahnschrift", Font.BOLD, 16));
        jLabel10.setForeground(new Color(102, 102, 255));
        jLabel10.setText("XUẤT EXCEL");
        jLabel10.setHorizontalAlignment(JLabel.CENTER);

        GroupLayout jPanel7Layout = new GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
                jPanel7Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel9)
                        .addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
        );
        jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        jTextField1.setText("Nhập nội dung tìm kiếm");
        jTextField1.addActionListener(this::jTextField1ActionPerformed);

        btn_LamMoi.setBackground(new Color(32, 131, 116));
        btn_LamMoi.setFont(new Font("Bahnschrift", Font.BOLD, 15));
        btn_LamMoi.setForeground(Color.white);
        btn_LamMoi.setText("Làm mới");
        btn_LamMoi.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_LamMoi.setHorizontalAlignment(SwingConstants.LEADING);
        btn_LamMoi.setPreferredSize(new Dimension(90, 31));

        btn_TimKiem.setBackground(new Color(32, 131, 116));
        btn_TimKiem.setFont(new Font("Bahnschrift", Font.BOLD, 15));
        btn_TimKiem.setForeground(new Color(255, 255, 255));
        btn_TimKiem.setText("Tìm");
        btn_TimKiem.addActionListener(this::btn_TimKiemActionPerformed);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(iconThem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(iconCapNhat)
//                                .addComponent(jPanel5)
//                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
//                                .addComponent(jPanel7)
                                .addGap(50, 50, 50)
                                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 50)
                                .addComponent(btn_TimKiem, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 50)
                                .addComponent(btn_LamMoi, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(iconThem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                                                        .addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(iconCapNhat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
//                                                        .addComponent(jPanel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                )))
                                .addGap(476, 476, 476))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_LamMoi, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_TimKiem, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)), "Danh Sách Khách Hàng", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Bahnschrift", Font.BOLD, 12)));

        table_DSKH.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                        "Mã Khách Hàng", "Tên Khách Hàng", "Giới Tính", "Số Điện Thoai", "Ngày Tham Gia"
                }
        ) {
            final Class[] types = new Class[]{
                    String.class, String.class, String.class, String.class, String.class, String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        table_DSKH.setGridColor(new Color(255, 255, 255));
        table_DSKH.setInheritsPopupMenu(true);
        table_DSKH.setSelectionBackground(new Color(153, 153, 153));
        table_DSKH.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                table_DSKHMouseClicked();
            }
        });
        jScrollPane1.setViewportView(table_DSKH);
        if (table_DSKH.getColumnModel().getColumnCount() > 0) {
            table_DSKH.getColumnModel().getColumn(2).setMinWidth(12);
        }

        GroupLayout jPanel8Layout = new GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
                jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 1140, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
                jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 588, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(14, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(80, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnHuyCapNhatActionPerformed(ActionEvent evt) {
        CapNhatKhachHangDialog.dispose();
    }

    private void ThemKhachHangDialogMouseClicked() {
        // TODO add your handling code here:
    }

    private void table_DSKHMouseClicked() {
        // TODO add your handling code here:
        try {
            int rowSelected = table_DSKH.getSelectedRow();
            txt_ma1.setText(tableModel.getValueAt(rowSelected, 0).toString());
            txt_ten1.setText(tableModel.getValueAt(rowSelected, 1).toString());
            if (tableModel.getValueAt(rowSelected, 2).toString().equals("Nam")) {
                rad_nam1.setSelected(true);
            } else {
                rad_nu1.setSelected(true);
            }
            txt_sdt1.setText(tableModel.getValueAt(rowSelected, 3).toString());
        } catch (Exception ex) {
            Logger.getLogger(KhachHang_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btn_TimKiemActionPerformed(ActionEvent evt) {
        String id = txt_NhapSDT.getText();
        if (id.isBlank()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập số điện thoại của khách hàng");
            return;
        }
        KhachHang nv = bus.timKiemTheoSDT(id);
        if (nv == null) {
            JOptionPane.showMessageDialog(this, "Nhân viên không tồn tại");
        } else {
            tableModel.setRowCount(0);
            tableModel.addRow(new Object[]{nv.getMaKhachHang(), nv.getHoTen(), nv.getGioiIinh()== 1 ? "Nam" : "Nữ", nv.getSdt(), nv.getNgayThamGia()});
        }
    }

    private boolean checkRangBuoc() {
        if (txt_ten.getText().isEmpty() || txt_sdt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(ThemKhachHangDialog, "Các trường không được để trống");
            return false;
        }
        if (!txt_sdt.getText().matches("0\\d{9}")) {
            JOptionPane.showMessageDialog(ThemKhachHangDialog, "Số điện thoại phải bắt đầu bằng số 0 và có 10 chữ số");
            return false;
        }

        String[] words = txt_ten.getText().split("\\s+");
        if (words.length < 2) {
            JOptionPane.showMessageDialog(ThemKhachHangDialog, "Họ tên phải từ 2 từ trở lên");
            return false;
        }
        for (String word : words) {
            if (!Character.isUpperCase(word.charAt(0))) {
                JOptionPane.showMessageDialog(ThemKhachHangDialog, "Họ tên phải in hoa chữ cái đầu");
                return false;
            }
        }
        return true;
    }

    private boolean checkRangBuocCapNhat() {
        if (txt_ten1.getText().isEmpty() || txt_sdt1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(CapNhatKhachHangDialog, "Các trường không được để trống");
            return false;
        }
        if (!txt_sdt1.getText().matches("0\\d{9}")) {
            JOptionPane.showMessageDialog(CapNhatKhachHangDialog, "Số điện thoại phải bắt đầu bằng số 0 và có 10 chữ số");
            return false;
        }

        String[] words = txt_ten1.getText().split("\\s+");
        if (words.length < 2) {
            JOptionPane.showMessageDialog(CapNhatKhachHangDialog, "Họ tên phải từ 2 từ trở lên");
            return false;
        }
        for (String word : words) {
            if (!Character.isUpperCase(word.charAt(0))) {
                JOptionPane.showMessageDialog(CapNhatKhachHangDialog, "Họ tên phải in hoa chữ cái đầu");
                return false;
            }
        }
        return true;
    }

    private KhachHang getNVien() {
        int gioitinh;
        KhachHang nv = new KhachHang();
        nv.setHoTen(txt_ten.getText());

        if (rad_nam.isSelected()) {
            gioitinh = 1;
        } else {
            gioitinh = 0;
        }

        nv.setGioiTinh(gioitinh);
        nv.setSdt(txt_sdt.getText());
        return nv;
    }

    private void btnThemActionPerformed(ActionEvent evt) {
        try {
            KhachHang nv = getNVien();
            nv.setMaKhachHang(nvdao.getAutoIncrement());

            if (!checkRangBuoc()) {
                return;
            }

            // Kiểm tra xem thông tin của khách hàng đã tồn tại trong cơ sở dữ liệu hay chưa
            KhachHang existingNV = nvdao.kiemTraLapThongTin(nv);
            if (existingNV != null) {
                JOptionPane.showMessageDialog(ThemKhachHangDialog, "Thông tin đã được nhập trùng với thông tin đã có trong cơ sở dữ liệu");
                return;
            }
            if (bus.insert(nv)) {
                tableModel.addRow(new Object[]{nv.getMaKhachHang(), nv.getHoTen(), nv.getGioiIinh() == 1 ? "Nam" : "Nữ", nv.getSdt(), nv.getNgayThamGia().toString()});
                ThemKhachHangDialog.dispose();
                refresh();
                JOptionPane.showMessageDialog(ThemKhachHangDialog, "Thêm khách hàng thành công!");
            } else {
                JOptionPane.showMessageDialog(ThemKhachHangDialog, "Thêm khách hàng thất bại!");
            }
        } catch (Exception ex) {
            Logger.getLogger(KhachHang_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btnCapNhatActionPerformed(ActionEvent evt) {
        int selectedRow = table_DSKH.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn khách hàng cần cập nhật");
            return;
        }
        try {
            KhachHang nv = new KhachHang();
            KhachHangDAO nvdao = new KhachHangDAO();
            int gioiTinh;

            if (rad_nam1.isSelected()) {
                gioiTinh = 1;
            } else {
                gioiTinh = 0;
            }
            nv.setMaKhachHang(txt_ma1.getText());
            nv.setHoTen(txt_ten1.getText());
            nv.setGioiTinh(gioiTinh);
            nv.setSdt(txt_sdt1.getText());

            // Kiểm tra xem thông tin của khách hàng đã tồn tại trong cơ sở dữ liệu hay chưa
            if (!checkRangBuocCapNhat()) {
                return;
            }

            KhachHang existingNV;
            existingNV = nvdao.kiemTraLapThongTin(nv);

            if (existingNV != null && !Objects.equals(existingNV.getMaKhachHang(), nv.getMaKhachHang())) {
                JOptionPane.showMessageDialog(CapNhatKhachHangDialog, "Thông tin đã được nhập trùng với thông tin đã có trong cơ sở dữ liệu");
                return;
            }

            if (bus.update(nv)) {
                refresh();
                CapNhatKhachHangDialog.dispose();
                JOptionPane.showMessageDialog(CapNhatKhachHangDialog, "Cập nhật khách hàng thành công!");
            } else {
                JOptionPane.showMessageDialog(CapNhatKhachHangDialog, "Hệ thống không thể cập nhật dữ liệu do số điện thoại khách hàng đã tồn tại!");
            }
        } catch (Exception ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadData() {
        ArrayList<KhachHang> listNV;
        listNV = bus.selectAll();
        for (KhachHang nv : listNV) {
            tableModel.addRow(new Object[]{nv.getMaKhachHang(), nv.getHoTen(), nv.getGioiIinh() == 1 ? "Nam" : "Nữ", nv.getSdt(), nv.getNgayThamGia().toString()});
        }
    }

    public void refresh() {
        txt_ma.setText("");
        txt_ten.setText("");
        txt_sdt.setText("");
        txt_NhapSDT.setText("");
        Gender.clearSelection();
        tableModel.setRowCount(0);
        loadData();
    }
}
