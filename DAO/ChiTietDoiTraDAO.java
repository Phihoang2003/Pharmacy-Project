package DAO;

import DTO.ChiTietDoiTra;
import Interface.ChiTietDoiTra_Interface;
import config.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChiTietDoiTraDAO implements ChiTietDoiTra_Interface{
    public static ChiTietDoiTraDAO getInstance(){
        return new ChiTietDoiTraDAO();
    }

    @Override
    public boolean themChiTietDoiTra(ChiTietDoiTra ctdt) {
        int result=0;
        try{
            Connection con= JDBCUtil.getConnection();
            String sql="INSERT INTO chitietdoitra(maSP,maDT,soLuong,giaBan,thanhTien) values(?,?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,ctdt.getSanPham().getMaThuoc());
            pst.setString(2,ctdt.getDoiTra().getMaDT());
            pst.setInt(3,ctdt.getSoLuong());
            pst.setDouble(4,ctdt.getGiaBan());
            pst.setDouble(5,ctdt.getThanhTien());
            result=pst.executeUpdate();
            if(result<1){
                return false;
            }

        }catch(SQLException ex){
            Logger.getLogger(ChiTietDoiTraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result>0;
    }

    @Override
    public ArrayList<ChiTietDoiTra> getAllCTDTTheoMaDT(String ma) {
        return null;
    }
}
