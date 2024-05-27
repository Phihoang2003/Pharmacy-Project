package DAO;
import DTO.HoaDon;
import GUI.TrangChu_GUI;
import config.JDBCUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThongKeDAO implements Initializable {
    @FXML
    private DatePicker date_end;

    @FXML
    private DatePicker date_start;

    @FXML
    private BarChart<?, ?> doanhThu_chart;

    @FXML
    private AnchorPane doanhThu_form;

    @FXML
    private PieChart doanhThu_piechart;

    @FXML
    private TableColumn<HoaDon, String> doanhthu_col;

    @FXML
    private TableColumn<HoaDon, String> doanhthu_ngay_col;

    @FXML
    private TableView<HoaDon> doanhthu_table;

    @FXML
    private TableView<HoaDon> loiNhuan_table;

    @FXML
    private AnchorPane home_form11;

    @FXML
    private AnchorPane home_form121;

    @FXML
    private AnchorPane home_form1211;

    @FXML
    private AnchorPane home_form12111;

    @FXML
    private BarChart<?, ?> loiNhuan_chart;

    @FXML
    private TableColumn<HoaDon, String> loiNhuan_col;

    @FXML
    private AnchorPane loiNhuan_form;

    @FXML
    private TableColumn<HoaDon, String> loiNhuan_ngay_col;

    @FXML
    private PieChart loiNhuan_piechart;

    @FXML
    private Button nav_doanhThu;

    @FXML
    private Button nav_loiNhuan;

    @FXML
    private Button nav_tienVon;

    @FXML
    private BarChart<Number, String> bestSeller_chart;

    @FXML
    private TableColumn<?, ?> tienVon_col;

    @FXML
    private AnchorPane tienVon_form;

    @FXML
    private TableColumn<?, ?> tienVon_ngay_col;

    @FXML
    private PieChart tienVon_piechart;

    @FXML
    private TableView<?> tienVon_table;

    @FXML
    void switchForm(ActionEvent event) {
        if (event.getSource() == nav_doanhThu){
            doanhThu_form.setVisible(true);
            loiNhuan_form.setVisible(false);
            tienVon_form.setVisible(false);

            nav_doanhThu.setStyle("-fx-background-color: #E0E0E0;");
            nav_loiNhuan.setStyle("-fx-background-color: #ffffff;");
            nav_tienVon.setStyle("-fx-background-color: #ffffff;");

            doanhThuChart();
            loiNhuanChart();
            top5MedicineBarChart();
        } else if (event.getSource() == nav_loiNhuan) {
            loiNhuan_form.setVisible(true);
            doanhThu_form.setVisible(false);
            tienVon_form.setVisible(false);

            nav_loiNhuan.setStyle("-fx-background-color: #E0E0E0;");
            nav_doanhThu.setStyle("-fx-background-color: #ffffff;");
            nav_tienVon.setStyle("-fx-background-color: #ffffff;");

            doanhThuChart();
            loiNhuanChart();
            top5MedicineBarChart();
        } else if (event.getSource() == nav_tienVon) {
            tienVon_form.setVisible(true);
            doanhThu_form.setVisible(false);
            loiNhuan_form.setVisible(false);

            nav_tienVon.setStyle("-fx-background-color: #E0E0E0;");
            nav_doanhThu.setStyle("-fx-background-color: #ffffff;");
            nav_loiNhuan.setStyle("-fx-background-color: #ffffff;");

            doanhThuChart();
            loiNhuanChart();
            top5MedicineBarChart();
        }
    }
    private static final Logger LOGGER = Logger.getLogger(TrangChu_GUI.class.getName());

    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;

    private LocalDate localDate_start;
    private LocalDate localDate_end;

    private java.sql.Date sqlDate_start;
    private java.sql.Date sqlDate_end;

    public void doanhThuChart() {
        try {
            doanhThu_chart.getData().clear();
            doanhThu_chart.setLegendVisible(false);
            String sql = "SELECT DATE(ngayLapHoaDon), SUM(tienThanhToan) AS totalIncome FROM hoadon WHERE ngayLapHoaDon BETWEEN ? AND ? GROUP BY ngayLapHoaDon ORDER BY ngayLapHoaDon ASC;";
            connect = JDBCUtil.getConnection();
            Series chart = new Series();
            prepare = connect.prepareStatement(sql);
            prepare.setDate(1, sqlDate_start);
            prepare.setDate(2, sqlDate_end);
            result = prepare.executeQuery();

            while (result.next()) {
                chart.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
            }

            doanhThu_chart.getData().add(chart);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loiNhuanChart() {
        try {
            loiNhuan_chart.getData().clear();
            loiNhuan_chart.setLegendVisible(false);
            String sql = "SELECT DATE(ngayLapHoaDon), SUM(hd.tienThanhToan - ct.soLuong * t.donGia * 1.4) AS loiNhuan\n" +
                    "FROM hoadon hd\n" +
                    "JOIN chitiethoadon ct ON hd.maHD = ct.maHD\n" +
                    "JOIN thuoc t ON ct.maSP = t.maThuoc WHERE ngayLapHoaDon BETWEEN ? AND ? GROUP BY ngayLapHoaDon ORDER BY ngayLapHoaDon ASC;";
            connect = JDBCUtil.getConnection();
            Series chart = new Series();
            prepare = connect.prepareStatement(sql);
            prepare.setDate(1, sqlDate_start);
            prepare.setDate(2, sqlDate_end);
            result = prepare.executeQuery();
            int count = 0;
            while (result.next()) {
                chart.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
                count++;
            }
            System.out.println("Number of data points: " + count);


            loiNhuan_chart.getData().add(chart);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void top5MedicineBarChart() {
        String sql = "SELECT tenThuoc, SUM(soLuong) as totalSold " +
                "FROM chitiethoadon JOIN thuoc ON chitiethoadon.maSP = thuoc.maThuoc " +
                "GROUP BY maSP ORDER BY totalSold DESC LIMIT 5";
        XYChart.Series<Number, String> series = new XYChart.Series<>();

        try {
            Connection connect = JDBCUtil.getConnection();
            PreparedStatement prepare = connect.prepareStatement(sql);
            ResultSet result = prepare.executeQuery();

            while (result.next()) {
                String medicineName = result.getString("tenThuoc");
                int totalSold = result.getInt("totalSold");
                series.getData().add(new XYChart.Data<>(totalSold, medicineName));
                System.out.println("Adding to chart: " + medicineName + " - " + totalSold);  // Logging

            }

            bestSeller_chart.getData().clear();
            bestSeller_chart.getData().add(series);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "An error occurred while creating the bar chart for top 5 medicines", e);
        }
    }

    public ObservableList<HoaDon> doanhThuList() {
        String sql = "SELECT ngayLapHoaDon, SUM(tienThanhToan) AS totalIncome FROM hoadon WHERE ngayLapHoaDon BETWEEN ? AND ? GROUP BY ngayLapHoaDon ORDER BY ngayLapHoaDon ASC;";
        ObservableList<HoaDon> data = FXCollections.observableArrayList();

        try {

            connect = JDBCUtil.getConnection();
            prepare = connect.prepareStatement(sql);
            prepare.setDate(1, sqlDate_start);
            prepare.setDate(2, sqlDate_end);
            result = prepare.executeQuery();

            while (result.next()) {

                data.add(new HoaDon(result.getDate("ngayLapHoaDon"), result.getDouble("totalIncome")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    private ObservableList<HoaDon> doanhthuList;
    public void displayIncome() {
        doanhthuList = doanhThuList();
        doanhthu_col.setCellValueFactory(new PropertyValueFactory<>("tienThanhToan"));
        doanhthu_ngay_col.setCellValueFactory(new PropertyValueFactory<>("ngayLapHD"));
        doanhthu_table.setItems(doanhthuList);
        doanhthu_table.refresh();
    }

    public ObservableList<HoaDon> loiNhuanList() {
        String sql = "SELECT DATE(ngayLapHoaDon), SUM(hd.tienThanhToan - ct.soLuong * t.donGia * 1.4) AS loiNhuan\n" +
        "FROM hoadon hd\n" +
                "JOIN chitiethoadon ct ON hd.maHD = ct.maHD\n" +
                "JOIN thuoc t ON ct.maSP = t.maThuoc WHERE ngayLapHoaDon BETWEEN ? AND ? GROUP BY ngayLapHoaDon ORDER BY ngayLapHoaDon ASC;";
        ObservableList<HoaDon> data = FXCollections.observableArrayList();

        try {
            connect = JDBCUtil.getConnection();
            prepare = connect.prepareStatement(sql);
            prepare.setDate(1, sqlDate_start);
            prepare.setDate(2, sqlDate_end);
            result = prepare.executeQuery();

            while (result.next()) {
                System.out.println("ngayLapHoaDon: " + result.getDate("DATE(ngayLapHoaDon)") + ", loiNhuan: " + result.getDouble("loiNhuan"));
                data.add(new HoaDon(result.getDouble("loiNhuan"), result.getDate("DATE(ngayLapHoaDon)")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    private ObservableList<HoaDon> loinhuanList;
    public void displayRevenue() {
        loinhuanList = loiNhuanList();
        loiNhuan_col.setCellValueFactory(new PropertyValueFactory<>("loiNhuan"));
        loiNhuan_ngay_col.setCellValueFactory(new PropertyValueFactory<>("ngayLapHD"));
        loiNhuan_table.setItems(loinhuanList);
        loiNhuan_table.refresh();
    }

    public void displayPromotionOrders() {
        String sqlWithPromotion = "SELECT COUNT(*) FROM hoadon WHERE chuongTrinhKM IS NOT NULL;";
        String sqlWithoutPromotion = "SELECT COUNT(*) FROM hoadon WHERE chuongTrinhKM IS NULL;";

        try {
            connect = JDBCUtil.getConnection();

            // Get the number of orders with promotion
            prepare = connect.prepareStatement(sqlWithPromotion);
            result = prepare.executeQuery();
            int countWithPromotion = 0;
            if (result.next()) {
                countWithPromotion = result.getInt(1);
            }

            // Get the number of orders without promotion
            prepare = connect.prepareStatement(sqlWithoutPromotion);
            result = prepare.executeQuery();
            int countWithoutPromotion = 0;
            if (result.next()) {
                countWithoutPromotion = result.getInt(1);
            }

            // Create PieChart.Data for orders with and without promotion
            PieChart.Data slice1 = new PieChart.Data("Có khuyến mãi", countWithPromotion);
            PieChart.Data slice2 = new PieChart.Data("Không khuyến mãi", countWithoutPromotion);

            // Add the slices to the PieChart
            doanhThu_piechart.getData().clear();
            doanhThu_piechart.getData().add(slice1);
            doanhThu_piechart.getData().add(slice2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (date_end.getValue() == null) {
            date_end.setValue(LocalDate.now());
        }
        if (date_start.getValue() == null) {
            date_start.setValue(LocalDate.now());
        }
        localDate_start = date_start.getValue();
        localDate_end = date_end.getValue();

        if(localDate_start != null && localDate_end != null) {
            sqlDate_start = java.sql.Date.valueOf(localDate_start);
            sqlDate_end = java.sql.Date.valueOf(localDate_end);
        }

        doanhThuChart();
        loiNhuanChart();
        top5MedicineBarChart();

        date_start.setOnAction(event -> {
            localDate_start = date_start.getValue();
            if(localDate_start != null) {
                sqlDate_start = java.sql.Date.valueOf(localDate_start);
            }
            loiNhuanChart();
            doanhThuChart();
            top5MedicineBarChart();
        });

        date_end.setOnAction(event -> {
            localDate_end = date_end.getValue();
            if(localDate_end != null) {
                sqlDate_end = java.sql.Date.valueOf(localDate_end);
            }
            loiNhuanChart();
            doanhThuChart();
            top5MedicineBarChart();
        });
        displayRevenue();
        displayIncome();
        displayPromotionOrders();
    }
}
