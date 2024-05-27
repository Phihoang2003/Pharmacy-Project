package DAO;
import config.JDBCUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import utils.Global;

import java.net.URL;
import java.sql.*;
import java.util.Date;
import java.util.ResourceBundle;

public class TrangChuDAO implements Initializable {
    @FXML
    private AreaChart<?, ?> home_incomeChart;

    @FXML
    private Label home_numberOrder;

    @FXML
    private BarChart<?, ?> home_orderChart;

    @FXML
    private Label home_totalIncome;

    @FXML
    private Label home_availableProducts;


    @FXML
    private AnchorPane chart;

    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;

    public void homeDisplayTotalOrders() throws SQLException {
        String sql = "SELECT COUNT(*) AS ordersCount FROM hoadon WHERE ngayLapHoaDon = CURDATE()";
        connect = JDBCUtil.getConnection();

        int countOrders = 0;
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            while (result.next()) {
                countOrders = result.getInt("ordersCount");
            }
            home_numberOrder.setText((String.valueOf(countOrders)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void homeTotalIncome() {
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        String sql = "SELECT SUM(tongTien) AS totalIncome FROM hoadon WHERE tinhTrang = 1 AND ngayLapHoaDon = CURDATE()" ;
        connect = JDBCUtil.getConnection();
        double totalIncome = 0;
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            while (result.next()) {
                totalIncome = result.getDouble("totalIncome");
            }
            home_totalIncome.setText(String.valueOf(totalIncome) + " VND");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void homeAvailableProducts() {
        String sql = "SELECT COUNT(maThuoc) AS productCount FROM thuoc WHERE trangThai = 'Đang bán'";
        connect = JDBCUtil.getConnection();

        int countAP = 0;
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            while (result.next()) {
                countAP = result.getInt("productCount");
            }
            home_availableProducts.setText((String.valueOf(countAP)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void homeIncomeChart() {
        home_incomeChart.getData().clear();
        home_incomeChart.setLegendVisible(false);
        String sql = "SELECT DATE(ngayLapHoaDon), SUM(tongTien) AS totalIncome FROM hoadon GROUP BY ngayLapHoaDon ORDER BY ngayLapHoaDon ASC LIMIT 6;";
        connect = JDBCUtil.getConnection();
        try {
            Series chart = new Series();
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                chart.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
            }

            home_incomeChart.getData().add(chart);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void homeOrdersChart() throws SQLException {
        home_orderChart.getData().clear();
        home_orderChart.setLegendVisible(false);
        String sql = "SELECT DATE(ngayLapHoaDon), COUNT(*) AS totalOrders FROM hoadon GROUP BY ngayLapHoaDon ORDER BY ngayLapHoaDon ASC LIMIT 5;";
        connect = JDBCUtil.getConnection();
        try {
            Series chart = new Series();
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                chart.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
            }

            home_orderChart.getData().add(chart);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(Global.getChucvu().equals("Nhân viên")){
            chart.setVisible(false);
        }
        try {
            homeTotalIncome();
            homeDisplayTotalOrders();
            homeOrdersChart();
            homeIncomeChart();
            homeAvailableProducts();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
