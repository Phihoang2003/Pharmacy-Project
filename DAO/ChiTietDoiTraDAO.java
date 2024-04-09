package DAO;

import DTO.ChiTietDoiTra;
import DTO.DoiTra;
import DTO.NhomHangHoa;
import DTO.Thuoc;
import Interface.ChiTietDoiTra_Interface;
import config.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
        ArrayList<ChiTietDoiTra> list=new ArrayList<>();
        try{
            Connection con=JDBCUtil.getConnection();
            String sql="Select ctdt.*,th.maThuoc,th.tenThuoc,th.nhomHangHoa,th.hanSuDung from chitietdoitra as ctdt join thuoc as th on ctdt.maSP=th.maThuoc where maDT=? ";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,ma);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                DoiTra dt=new DoiTra(rs.getString("maDT"));
                Thuoc th=new Thuoc(rs.getString("maThuoc"));
                Date hanSuDung=rs.getDate("hanSuDung");
                String nhomThuoc=rs.getString("nhomHangHoa");
                String tenNhom=NhomHangHoaDAO.getInstance().layTenNhomThuocTheoMa(nhomThuoc);
                String tenThuoc=rs.getString("tenThuoc");
                th.setTenThuoc(tenThuoc);
                th.setHanSuDung(hanSuDung);
                th.setNhomHangHoa(new NhomHangHoa(nhomThuoc,tenNhom));
                int soLuong=rs.getInt("soLuong");
                double giaBan=rs.getDouble("giaBan");
                double thanhTien=rs.getDouble("thanhTien");

                ChiTietDoiTra ctdt=new ChiTietDoiTra(th,dt,soLuong,giaBan,thanhTien);
                list.add(ctdt);

            }
            JDBCUtil.closeConnection(con);


        }catch(SQLException ex){
            Logger.getLogger(ChiTietDoiTraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
