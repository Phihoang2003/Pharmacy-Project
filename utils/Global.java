package utils;


public class Global {
    private static String ma = "";
    private static String name = "";
    private static String gioitinh ="";
    private static String chucvu ="";
    private static String sdt = "";

    public  Global(){

    }

    public   static String getSdt() {
        return sdt;
    }

    public  static void setSdt(String sdt) {
        Global.sdt = sdt;
    }

    public static String getName() {
        return name;
    }
    public static void setName(String aName) {
        name = aName;
    }

    public static String getMa() {
        return ma;
    }

    public static void setMa(String ma) {
        Global.ma = ma;
    }

    public static String getGioitinh() {
        return gioitinh;
    }

    public static void setGioitinh(String gioitinh) {
        Global.gioitinh = gioitinh;
    }

    public static String getChucvu() {
        return chucvu;
    }

    public static void setChucvu(String chucvu) {
        Global.chucvu = chucvu;
    }
}
