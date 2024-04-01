package Interface;



import DTO.ChiTietDoiTra;

import java.util.ArrayList;

public interface ChiTietDoiTra_Interface {
    public boolean themChiTietDoiTra(ChiTietDoiTra ctdt);
    public ArrayList<ChiTietDoiTra> getAllCTDTTheoMaDT(String ma);

}
