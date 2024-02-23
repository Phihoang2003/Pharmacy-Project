package DAO;

import DTO.QuyCachDongGoi;
import config.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class QuyCachDongGoiDAO {
    public static QuyCachDongGoiDAO getInstance() {
        return new QuyCachDongGoiDAO();
    }
    public QuyCachDongGoi selectQuyCachDongGoi(String maQuyCach) {
        QuyCachDongGoi quyCachDongGoi = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM quycachdonggoi WHERE maQuyCachDongGoi = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, maQuyCach);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                quyCachDongGoi = new QuyCachDongGoi();
                quyCachDongGoi.setMaQuyCachDongGoi(rs.getString("maQuyCachDongGoi"));
                quyCachDongGoi.setTenQuyCachDongGoi(rs.getString("tenQuyCachDongGoi"));
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(QuyCachDongGoiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return quyCachDongGoi;
    }
}
