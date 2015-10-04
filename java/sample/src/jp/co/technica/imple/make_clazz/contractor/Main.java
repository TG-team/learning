package jp.co.technica.imple.make_clazz.contractor;

import java.util.Calendar;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance(Locale.JAPAN);

        calendar.set(1950, 0, 1);
        User user = new User(1, "Yamada", "Taro", calendar.getTimeInMillis(),
                "Japan", true);

        calendar.set(1980, 11, 1);
        Vendor.Builder builder = new Vendor.Builder(1, "Tanaka", "Ichiro");
        builder.setBirth(calendar.getTimeInMillis());
        builder.setAddress("Japan");
        builder.setMale(true);
        Vendor vendor = builder.build();
    }
}
