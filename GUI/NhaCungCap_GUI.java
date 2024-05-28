package GUI;

import BUS.NhaCungCap_bus;
import DAO.NhaCungCapDAO;
import DTO.NhaCungCap;
import DTO.NhanVien;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utils.SVGImage;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import static GUI.SanPham_GUI.openExcelFile;

public class NhaCungCap_GUI extends JPanel {
    private final NhaCungCap_bus bus = new NhaCungCap_bus();
    private DefaultTableModel tableModel = new DefaultTableModel();
    private JTable table_DSNCC;

    private JPanel iconThem;
    private JPanel iconCapNhat;

    private JDialog ThemNCCDialog;
    private JDialog CapNhatNCCDialog;
    private JButton btn_LamMoi;
    private JButton btn_TimKiem;
    private JTextField txt_NhapSDT;
    private JTextField txt_ma;
    private JTextField txt_ma1;
    private JTextField txt_sdt;
    private JTextField txt_sdt1;
    private JTextField txt_ten;
    private JTextField txt_ten1;
    private JTextField txt_diachi;
    private JTextField txt_diachi1;

    public NhaCungCap_GUI() {
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
                ThemNCCDialog.setVisible(true);
            }
        });

        iconCapNhat.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                int selectedRow = table_DSNCC.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Bạn chưa chọn khách hàng cần cập nhật");
                    return;
                }
                CapNhatNCCDialog.setVisible(true);
            }
        });

        tableModel = (DefaultTableModel) table_DSNCC.getModel();
        table_DSNCC.setModel(tableModel);
        loadData();

        refresh();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        CapNhatNCCDialog = new JDialog();
        ThemNCCDialog = new JDialog();
        table_DSNCC = new JTable();
        JButton btnCapNhat = new JButton();
        JButton btnHuyCapNhat = new JButton();
        txt_ten1 = new JTextField();
        txt_ma = new JTextField();
        txt_ma1 = new JTextField();
        txt_sdt1 = new JTextField();
        iconThem = new JPanel();
        txt_NhapSDT = new JTextField();
        txt_sdt = new JTextField();
        txt_ten = new JTextField();
        txt_diachi = new JTextField();
        txt_diachi1 = new JTextField();
        SVGImage jLabel2 = new SVGImage();
        JPanel jPanel6 = new JPanel();
        JPanel jPanel9 = new JPanel();
        JLabel jLabel8 = new JLabel();
        JLabel lblTen = new JLabel();
        JLabel lblTen1 = new JLabel();
        JLabel lblMa1 = new JLabel();
        JLabel lblSDT1 = new JLabel();
        JLabel lblDiaChi = new JLabel();
        JLabel lblDiaChi1 = new JLabel();
        JComboBox cboTinhTrang = new JComboBox();
        JLabel lblSDT = new JLabel();
        JLabel lblMa = new JLabel();
        JButton btnHuyThem = new JButton();
        JLabel lblTinhTrang = new JLabel();
        JLabel lblTinhTrang1 = new JLabel();
        JButton btnThem = new JButton();
        JPanel jPanel1 = new JPanel();
        JLabel jLabel1 = new JLabel();
        iconCapNhat = new JPanel();
        SVGImage jLabel5 = new SVGImage();
        JLabel jLabel3 = new JLabel();
        JPanel jPanel5 = new JPanel();
        JPanel jPanel10 = new JPanel();
        JPanel jPanel11 = new JPanel();
        JLabel jLabel14 = new JLabel();
        JLabel jLabel4 = new JLabel();
        SVGImage jLabel11 = new SVGImage();
        JPanel btn_xuat = new JPanel();
        SVGImage jLabel9 = new SVGImage();
        JLabel jLabel10 = new JLabel();
        jTextField1 = new JTextField();
        btn_LamMoi = new JButton();
        btn_TimKiem = new JButton();
        JPanel jPanel8 = new JPanel();
        JScrollPane jScrollPane1 = new JScrollPane();

        ThemNCCDialog.setTitle("Thêm Nhà Cung Cấp");
        ThemNCCDialog.setAlwaysOnTop(true);
        ThemNCCDialog.setBackground(new Color(255, 255, 255));
        ThemNCCDialog.setLocation(new Point(500, 100));
        ThemNCCDialog.setSize(new Dimension(490, 690));
        ThemNCCDialog.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                ThemNCCDialogMouseClicked();
            }
        });

        jPanel6.setBackground(new Color(255, 255, 255));

        jPanel9.setBackground(new Color(37, 51, 49));

        jLabel8.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 14));
        jLabel8.setForeground(new Color(255, 255, 255));
        jLabel8.setText("THÊM NHÀ CUNG CẤP");
        jLabel8.setHorizontalAlignment(JLabel.CENTER);

        GroupLayout jPanel9Layout = new GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
                jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
                jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(24, 24, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addGap(24, 24, Short.MAX_VALUE))
        );

        lblMa.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
        lblMa.setText("Mã Nhà Cung Cấp");

        lblSDT.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
        lblSDT.setText("Số Điện Thoại");

        lblDiaChi.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
        lblDiaChi.setText("Địa Chỉ");

        lblTen.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
        lblTen.setText("Tên Nhà Cung Cấp");

        lblTinhTrang.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
        lblTinhTrang.setText("Tình Trạng");

        txt_ma.setEditable(false);
        txt_ma.setBackground(new Color(204, 204, 204));

        cboTinhTrang.setModel(new DefaultComboBoxModel<>(new String[] { "Đang Nhập", "Ngừng Nhập" }));
        cboTinhTrang.setBorder(null);
        cboTinhTrang.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        btnThem.setBackground(new Color(22, 97, 86));
        btnThem.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 13));
        btnThem.setForeground(new Color(255, 255, 255));
        btnThem.setText("Thêm Nhà Cung Cấp");
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
                jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                                .addGap(0, 50, Short.MAX_VALUE)
                                                .addComponent(btnThem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(29, 29, 29)
                                                .addComponent(btnHuyThem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(72, 72, 72))
                                        .addComponent(jPanel9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_diachi)
                                        .addComponent(txt_sdt)
                                        .addComponent(txt_ten)
                                        .addComponent(txt_ma)
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblDiaChi, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblSDT, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblTen, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblMa, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                                .addComponent(lblTinhTrang, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(63, 63, 63)
                                                                .addComponent(cboTinhTrang, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );

        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jPanel9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(lblMa, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_ma, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblTen, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_ten, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblSDT)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(txt_sdt, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lblDiaChi, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txt_diachi, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblTinhTrang)
                                                        .addComponent(cboTinhTrang, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                                .addComponent(btnHuyThem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGap(0, 30, Short.MAX_VALUE)
                                                .addComponent(btnThem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addGap(34, 34, 34))
        );

        GroupLayout ThemNCCDialogLayout = new GroupLayout(ThemNCCDialog.getContentPane());
        ThemNCCDialog.getContentPane().setLayout(ThemNCCDialogLayout);
        ThemNCCDialogLayout.setHorizontalGroup(
                ThemNCCDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        ThemNCCDialogLayout.setVerticalGroup(
                ThemNCCDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(ThemNCCDialogLayout.createSequentialGroup()
                                .addComponent(jPanel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        CapNhatNCCDialog.setTitle("CẬP NHẬT NHÀ CUNG CẤP");
        CapNhatNCCDialog.setAlwaysOnTop(true);
        CapNhatNCCDialog.setBackground(new Color(255, 255, 255));
        CapNhatNCCDialog.setLocation(new Point(500, 100));
        CapNhatNCCDialog.setSize(new Dimension(490, 700));

        jPanel10.setBackground(new Color(255, 255, 255));
        jPanel11.setBackground(new Color(22, 97, 86));

        jLabel14.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 14));
        jLabel14.setForeground(new Color(255, 255, 255));
        jLabel14.setText("CẬP NHẬT NHÀ CUNG CẤP");

        GroupLayout jPanel11Layout = new GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
                jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel14)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
                jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(24, 24, Short.MAX_VALUE)
                                .addComponent(jLabel14)
                                .addGap(24, 24, Short.MAX_VALUE))
        );

        lblMa1.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
        lblMa1.setText("Mã nhà Cung Cấp");

        lblSDT1.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
        lblSDT1.setText("Số Điện Thoại");

        lblDiaChi1.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
        lblDiaChi1.setText("Địa Chỉ");

        lblTen1.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
        lblTen1.setText("Tên Nhà Cung Cấp");

        lblTinhTrang1.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
        lblTinhTrang1.setText("Tình Trạng");

        txt_ma1.setEditable(false);
        txt_ma1.setBackground(new Color(204, 204, 204));

        cboTinhTrang.setModel(new DefaultComboBoxModel<>(new String[] { "Đang Nhập", "Ngừng Nhập" }));
        cboTinhTrang.setBorder(null);
        cboTinhTrang.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        btnCapNhat.setBackground(new Color(22, 97, 86));
        btnCapNhat.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 13));
        btnCapNhat.setForeground(new Color(255, 255, 255));
        btnCapNhat.setText("Cập Nhật Nhà Cung Cấp");
        btnCapNhat.addActionListener(this::btnCapNhatActionPerformed);

        btnHuyCapNhat.setBackground(new Color(204, 0, 51));
        btnHuyCapNhat.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 13));
        btnHuyCapNhat.setForeground(new Color(255, 255, 255));
        btnHuyCapNhat.setText("Hủy Bỏ");
        btnHuyCapNhat.addActionListener(this::btnHuyCapNhatActionPerformed);

        GroupLayout jPanel10Layout = new GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
                jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                                .addGap(0, 50, Short.MAX_VALUE)
                                                .addComponent(btnCapNhat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(29, 29, 29)
                                                .addComponent(btnHuyCapNhat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(72, 72, 72))
                                        .addComponent(jPanel11, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_diachi1)
                                        .addComponent(txt_sdt1)
                                        .addComponent(txt_ten1)
                                        .addComponent(txt_ma1)
                                        .addGroup(jPanel10Layout.createSequentialGroup()
                                                .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblDiaChi1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblSDT1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblTen1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblMa1)
                                                        .addGroup(jPanel10Layout.createSequentialGroup()
                                                                .addComponent(lblTinhTrang, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(63, 63, 63)
                                                                .addComponent(cboTinhTrang, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );

        jPanel10Layout.setVerticalGroup(
                jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jPanel11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(lblMa1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_ma1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblTen1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_ten1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblSDT1)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel10Layout.createSequentialGroup()
                                                .addComponent(txt_sdt1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lblDiaChi1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txt_diachi1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblTinhTrang)
                                                        .addComponent(cboTinhTrang, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                                .addComponent(btnHuyCapNhat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel10Layout.createSequentialGroup()
                                                .addGap(0, 30, Short.MAX_VALUE)
                                                .addComponent(btnCapNhat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addGap(34, 34, 34))
        );

        GroupLayout CapNhatNCCDialogLayout = new GroupLayout(CapNhatNCCDialog.getContentPane());
        CapNhatNCCDialog.getContentPane().setLayout(CapNhatNCCDialogLayout);
        CapNhatNCCDialogLayout.setHorizontalGroup(
                CapNhatNCCDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(CapNhatNCCDialogLayout.createSequentialGroup()
                                .addComponent(jPanel10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        CapNhatNCCDialogLayout.setVerticalGroup(
                CapNhatNCCDialogLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(CapNhatNCCDialogLayout.createSequentialGroup()
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
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
        );

        btn_xuat.setBackground(new Color(255, 255, 255));
        btn_xuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_xuatMouseClicked(evt);
            }
        });

        jLabel9.setSvgImage("icon/excel.svg", 70, 70);

        jLabel10.setFont(new Font("Bahnschrift", Font.BOLD, 16));
        jLabel10.setForeground(new Color(102, 102, 255));
        jLabel10.setText("XUẤT EXCEL");
        jLabel10.setHorizontalAlignment(JLabel.CENTER);

        GroupLayout btn_xuatLayout = new GroupLayout(btn_xuat);
        btn_xuat.setLayout(btn_xuatLayout);
        btn_xuatLayout.setHorizontalGroup(
                btn_xuatLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel9)
                        .addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
        );
        btn_xuatLayout.setVerticalGroup(
                btn_xuatLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        jTextField1.setText("Nhập mã hoặc sdt nhà cung cấp");
        jTextField1.addActionListener(this::jTextField1ActionPerformed);
        jTextField1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jTextField1.setText("");
            }
        });
        if (jTextField1.getText().isEmpty())
            jTextField1.setText("Nhập mã hoặc sdt nhà cung cấp");

        btn_LamMoi.setBackground(new Color(32, 131, 116));
        btn_LamMoi.setFont(new Font("Bahnschrift", Font.BOLD, 15));
        btn_LamMoi.setForeground(Color.white);
        btn_LamMoi.setText("Làm mới");
        btn_LamMoi.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_LamMoi.setHorizontalAlignment(SwingConstants.LEADING);
        btn_LamMoi.setPreferredSize(new Dimension(90, 31));
        btn_LamMoi.addActionListener(this::btn_LamMoiActionPerformed);

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
                                .addComponent(btn_xuat)
//                                .addComponent(cboTinhTrang)
                                .addGap(10, 30, 50)
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
                                                        .addComponent(btn_xuat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                )))
                                .addGap(476, 476, 476))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(41, 41, 41)

                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                                        .addComponent(cboTinhTrang)
                                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_LamMoi, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_TimKiem, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)), "Danh Sách Nhà Cung Cấp", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Bahnschrift", Font.BOLD, 12)));

        table_DSNCC.setModel(new DefaultTableModel(
                new Object [][] {},
                new String [] {
                        "Mã Nhà Cung Cấp", "Tên Nhà Cung Cấp",  "Số Điện Thoai","Địa Chỉ", "Tình trạng"
                }
        ) {
            final Class[] types = new Class [] {
                    String.class, String.class, String.class, String.class, String.class, String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table_DSNCC.setGridColor(new Color(255, 255, 255));
        table_DSNCC.setInheritsPopupMenu(true);
        table_DSNCC.setSelectionBackground(new Color(153, 153, 153));
        jScrollPane1.setViewportView(table_DSNCC);
        if (table_DSNCC.getColumnModel().getColumnCount() > 0) {
            table_DSNCC.getColumnModel().getColumn(2).setMinWidth(12);
        }
        table_DSNCC.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                table_DSNCCMouseClicked();
            }
        });

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
    }

    private void jTextField1ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void ThemNCCDialogMouseClicked() {
        // TODO add your handling code here:
    }

    private void btnHuyCapNhatActionPerformed(ActionEvent evt) {
        CapNhatNCCDialog.dispose();
    }

    private void table_DSNCCMouseClicked() {
        // TODO add your handling code here:
        try {
            int rowSelected = table_DSNCC.getSelectedRow();
            txt_ma1.setText(tableModel.getValueAt(rowSelected, 0).toString());
            txt_ten1.setText(tableModel.getValueAt(rowSelected, 1).toString());
            txt_sdt1.setText(tableModel.getValueAt(rowSelected, 2).toString());
            txt_diachi1.setText(tableModel.getValueAt(rowSelected, 3).toString());
        } catch (Exception ex) {
            Logger.getLogger(NhaCungCap_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void xuatExcel() {
        try {
            String defaultCurrentDirectoryPath = "src/fileExcel";
            JFileChooser fileChooser = new JFileChooser(defaultCurrentDirectoryPath);
            fileChooser.setDialogTitle("Chọn nơi lưu file");
            int chon = fileChooser.showSaveDialog(null);
            if (chon == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                String filePath = selectedFile.getAbsolutePath();
                if (!filePath.toLowerCase().endsWith(".xlsx")) {
                    filePath += ".xlsx";
                }
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet("Danh sách nhân viên");
                XSSFRow row;
                row = sheet.createRow(0);
                Cell cell = row.createCell(0, CellType.STRING);
                cell.setCellValue("Mã nhà cung cấp");
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue("Tên nhà cung cấp");
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue("Số điện thoại");
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue("Địa chỉ");
                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue("Tình trạng");

                ArrayList<NhaCungCap> listItem = bus.selectAll();
                for (int i = 0; i < listItem.size(); i++) {
                    NhaCungCap sp = listItem.get(i);
                    row = sheet.createRow(1 + i);
                    row.createCell(0).setCellValue(sp.getMaNhaCungCap());
                    row.createCell(1).setCellValue(sp.getTenNhaCungCap());
                    row.createCell(2).setCellValue(sp.getSoDienThoai());
                    row.createCell(3).setCellValue(sp.getDiaChi());
                    row.createCell(4).setCellValue(sp.getTrangThai()== 1 ? "Đang nhập" : "Ngừng nhập");
                }
                File f = new File(filePath);
                try (FileOutputStream fos = new FileOutputStream(f)) {
                    workbook.write(fos);
                    JOptionPane.showMessageDialog(null, "Xuất file thành công");
                    openExcelFile(f);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void btn_xuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_xuatMouseClicked
        xuatExcel();
    }

    private void btn_LamMoiActionPerformed(ActionEvent evt) {
        refresh();
    }

    private void btn_TimKiemActionPerformed(ActionEvent evt) {
        String timKiem = jTextField1.getText();
        if (timKiem.isBlank()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập số điện thoại hoặc mã nhà cung cấp");
            return;
        }
        NhaCungCap nv;
        if (timKiem.matches("\\d+")) { // Check if the search string is a number
            nv = bus.timKiemTheoSDT(timKiem);
        } else {
            nv = bus.timKiemNCC(timKiem);
        }
        if (nv == null) {
            JOptionPane.showMessageDialog(this, "Nhà cung cấp không tồn tại");
        } else {
            tableModel.setRowCount(0);
            tableModel.addRow(new Object[]{nv.getMaNhaCungCap(), nv.getTenNhaCungCap(), nv.getSoDienThoai(), nv.getDiaChi()});
        }
    }

    private final NhaCungCapDAO nvdao = new NhaCungCapDAO();

    private boolean checkRangBuoc() {
        if (txt_ten.getText().isEmpty() || txt_sdt.getText().isEmpty() || txt_diachi.getText().isEmpty()) {
            JOptionPane.showMessageDialog(ThemNCCDialog, "Các trường không được để trống");
            return false;
        }
        if (!txt_sdt.getText().matches("0\\d{9}")) {
            JOptionPane.showMessageDialog(ThemNCCDialog, "Số điện thoại phải bắt đầu bằng số 0 và có 10 chữ số");
            return false;
        }

        String[] words = txt_ten.getText().split("\\s+");
        for (String word : words) {
            if (!Character.isUpperCase(word.charAt(0))) {
                JOptionPane.showMessageDialog(ThemNCCDialog, "Họ tên phải in hoa chữ cái đầu");
                return false;
            }
        }
        return true;
    }

    private boolean checkRangBuocCapNhat() {
        if (txt_ten1.getText().isEmpty() || txt_sdt1.getText().isEmpty() || txt_diachi1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(CapNhatNCCDialog, "Các trường không được để trống");
            return false;
        }
        if (!txt_sdt1.getText().matches("0\\d{9}")) {
            JOptionPane.showMessageDialog(CapNhatNCCDialog, "Số điện thoại phải bắt đầu bằng số 0 và có 10 chữ số");
            return false;
        }

        String[] words = txt_ten1.getText().split("\\s+");
        for (String word : words) {
            if (!Character.isUpperCase(word.charAt(0))) {
                JOptionPane.showMessageDialog(CapNhatNCCDialog, "Họ tên phải in hoa chữ cái đầu");
                return false;
            }
        }
        return true;
    }

    private NhaCungCap getNVien() {
        NhaCungCap nv = new NhaCungCap();
        nv.setTenNhaCungCap(txt_ten.getText());
        nv.setSoDienThoai(txt_sdt.getText());
        nv.setDiaChi(txt_diachi.getText());
        return nv;
    }

    private void btnThemActionPerformed(ActionEvent evt) {
        try {
            NhaCungCap nv = getNVien();
            nv.setMaNhaCungCap(nvdao.getAutoIncrement());

            if (!checkRangBuoc()) {
                return;
            }

            // Kiểm tra xem thông tin của khách hàng đã tồn tại trong cơ sở dữ liệu hay chưa
            NhaCungCap existingNV = nvdao.kiemTraLapThongTin(nv);
            if (existingNV != null) {
                JOptionPane.showMessageDialog(ThemNCCDialog, "Thông tin đã được nhập trùng với thông tin đã có trong cơ sở dữ liệu");
                return;
            }

            if (bus.insert(nv)) {
                tableModel.addRow(new Object[]{nv.getMaNhaCungCap(), nv.getTenNhaCungCap(), nv.getSoDienThoai(), nv.getDiaChi(), nv.getTrangThai()});
                ThemNCCDialog.dispose();
                refresh();
                JOptionPane.showMessageDialog(ThemNCCDialog, "Thêm nhà cung cấp thành công!");
            } else {
                JOptionPane.showMessageDialog(ThemNCCDialog, "Thêm nhà cung cấp thất bại!");
            }

        } catch (Exception ex) {
            Logger.getLogger(NhaCungCap_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btnCapNhatActionPerformed(ActionEvent evt) {
        int selectedRow = table_DSNCC.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn nhà cung cấp cần cập nhật");
            return;
        }
        try {
            NhaCungCap nv = new NhaCungCap();
            NhaCungCapDAO nvdao = new NhaCungCapDAO();

            nv.setMaNhaCungCap(txt_ma1.getText());
            nv.setTenNhaCungCap(txt_ten1.getText());
            nv.setSoDienThoai(txt_sdt1.getText());
            nv.setDiaChi(txt_diachi1.getText());

            // Kiểm tra xem thông tin của khách hàng đã tồn tại trong cơ sở dữ liệu hay chưa
            if (!checkRangBuocCapNhat()) {
                return;
            }

            NhaCungCap existingNV;
            existingNV = nvdao.kiemTraLapThongTin(nv);

            if (existingNV != null && !Objects.equals(existingNV.getMaNhaCungCap(), nv.getMaNhaCungCap())) {
                JOptionPane.showMessageDialog(CapNhatNCCDialog, "Thông tin đã được nhập trùng với thông tin đã có trong cơ sở dữ liệu");
                return;
            }

            if (bus.update(nv)) {
                refresh();
                CapNhatNCCDialog.dispose();
                JOptionPane.showMessageDialog(CapNhatNCCDialog, "Cập nhật nhà cung cấp thành công!");
            } else {
                JOptionPane.showMessageDialog(CapNhatNCCDialog, "Cập nhật nhà cung cấp thất bại!");
            }
        } catch (Exception ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadData() {
        ArrayList<NhaCungCap> listNV;
        listNV = bus.selectAll();
        for (NhaCungCap nv : listNV) {
            tableModel.addRow(new Object[]{nv.getMaNhaCungCap(), nv.getTenNhaCungCap(), nv.getSoDienThoai(), nv.getDiaChi(), nv.getTrangThai()==1?"Đang nhập":"Ngừng nhập"});
        }
    }

    public void refresh() {
        txt_ma.setText("");
        txt_ten.setText("");
        txt_sdt.setText("");
        txt_NhapSDT.setText("");
        tableModel.setRowCount(0);
        loadData();
    }

    private JTextField jTextField1;
}
