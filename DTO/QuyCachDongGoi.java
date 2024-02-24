package DTO;

import java.util.Objects;

public class QuyCachDongGoi {
    private String maQuyCachDongGoi;
    private String tenQuyCachDongGoi;
    public QuyCachDongGoi() {
    }
    public QuyCachDongGoi(String maQuyCachDongGoi, String tenQuyCachDongGoi) {
        this.maQuyCachDongGoi = maQuyCachDongGoi;
        this.tenQuyCachDongGoi = tenQuyCachDongGoi;
    }
    public QuyCachDongGoi(String maQuyCachDongGoi) {
        this.maQuyCachDongGoi = maQuyCachDongGoi;
    }
    public String getMaQuyCachDongGoi() {
        return maQuyCachDongGoi;
    }

    public void setMaQuyCachDongGoi(String maQuyCachDongGoi) {
        this.maQuyCachDongGoi = maQuyCachDongGoi;
    }

    public String getTenQuyCachDongGoi() {
        return tenQuyCachDongGoi;
    }

    public void setTenQuyCachDongGoi(String tenQuyCachDongGoi) {
        this.tenQuyCachDongGoi = tenQuyCachDongGoi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuyCachDongGoi that = (QuyCachDongGoi) o;
        return Objects.equals(maQuyCachDongGoi, that.maQuyCachDongGoi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maQuyCachDongGoi);
    }

    @Override
    public String toString() {
        return "QuyCachDongGoiEntity{" +
                "maQuyCachDongGoi='" + maQuyCachDongGoi + '\'' +
                ", tenQuyCachDongGoi='" + tenQuyCachDongGoi + '\'' +
                '}';
    }
}
