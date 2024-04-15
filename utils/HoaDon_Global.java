package utils;


public class HoaDon_Global {
    private static String maHD = "";
    private static String maKH = "";
    private static String maNV = "";
    private static String maKM = "";
    private static String NgayLap = "";

    public  HoaDon_Global() {
    }

    public static String getMaKM() {
        return maKM;
    }

    public static void setMaKM(String maKM) {
        HoaDon_Global.maKM = maKM;
    }

    public static String getMaHD() {
        return maHD;
    }

    public static void setMaHD(String maHD) {
        HoaDon_Global.maHD = maHD;
    }

    public static String getMaKH() {
        return maKH;
    }

    public static void setMaKH(String maKH) {
        HoaDon_Global.maKH = maKH;
    }

    public static String getMaNV() {
        return maNV;
    }

    public static void setMaNV(String maNV) {
        HoaDon_Global.maNV = maNV;
    }

    public static String getNgayLap() {
        return NgayLap;
    }

    public static void setNgayLap(String NgayLap) {
        HoaDon_Global.NgayLap = NgayLap;
    }

}
