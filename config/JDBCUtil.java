package config;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class JDBCUtil {
    public static Connection getConnection() {
        Connection result = null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url="jdbc:mysql://localhost:3306/quanlihieuthuoc";
            String userName="root";
            String password="hadoop";
            result=DriverManager.getConnection(url,userName,password);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thể kết nối đến cơ sở dữ liệu !", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        return result;
    }

    public static void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}