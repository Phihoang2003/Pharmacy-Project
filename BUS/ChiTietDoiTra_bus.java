package BUS;

import DAO.ChiTietDoiTraDAO;
import DTO.ChiTietDoiTra;
import Interface.ChiTietDoiTra_Interface;

import java.util.ArrayList;

public class ChiTietDoiTra_bus implements ChiTietDoiTra_Interface {
    ChiTietDoiTraDAO ct_dao= new ChiTietDoiTraDAO();
    @Override
    public boolean themChiTietDoiTra(ChiTietDoiTra ctdt) {
        return ct_dao.themChiTietDoiTra(ctdt);
    }

    @Override
    public ArrayList<ChiTietDoiTra> getAllCTDTTheoMaDT(String ma) {
        return ct_dao.getAllCTDTTheoMaDT(ma);
    }
}
