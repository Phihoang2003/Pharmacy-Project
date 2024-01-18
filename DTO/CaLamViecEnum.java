package DTO;

public enum CaLamViecEnum {
    CA1, CA2;

    @Override
    public String toString() {
        return switch (this) {
            case CA1 -> "Ca 1";
            default -> "Ca 2";
        };
    }
}
