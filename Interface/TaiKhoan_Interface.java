package Interface;

import DTO.TaiKhoan;



import java.util.ArrayList;

public interface TaiKhoan_Interface {
    public boolean insert(TaiKhoan tk);

    public ArrayList<TaiKhoan> findAll();
   public TaiKhoan getTK(String taiKhoan,String matKhau);
    public boolean update(TaiKhoan tk);
    public boolean thoiGianDNGN(TaiKhoan tk);
    public TaiKhoan findOne(String id);
}
