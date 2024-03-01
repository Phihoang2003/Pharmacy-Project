package utils;

import java.text.DecimalFormat;
import java.text.ParseException;

public class ConvertDoubleToMoney {
    private DecimalFormat formatter = new DecimalFormat("###,###,###");

    public ConvertDoubleToMoney() {

    }

    public String toMoney(double num) {
        return formatter.format(num);
    }

    public String toStringMoney(String num) {
        double amount = Double.parseDouble(num);
        return formatter.format(amount);
    }

    public double toDouble(String money) {
        double parsedValue = 0;
        try {
            Number parsedNumber = formatter.parse(money);
            parsedValue = parsedNumber.doubleValue();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return parsedValue;
    }
}
