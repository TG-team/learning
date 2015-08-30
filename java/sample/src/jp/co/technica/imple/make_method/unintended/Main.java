package jp.co.technica.imple.make_method.unintended;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;

public class Main {

    public static void main(String[] args) {

        calculationError();

        outPutHTML();

        comparativeMethod();
    }

    private static void calculationError() {
        System.out.println("============calculationError============");
        System.out.println(1.03 - 0.42);

        BigDecimal bd = new BigDecimal("1.03");
        bd = bd.subtract(new BigDecimal("0.42"));
        System.out.println(bd);
    }

    private static void outPutHTML() {
        System.out.println("============outPutHTML============");

        InputStream in = null;

        try {
            URL url = new URL("http://www.yahoo.co.jp/");
            in = url.openStream();

            int c;
            while ((c = in.read()) != -1) {
                System.out.write(c);
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            silentClose(in);
        }
    }

    public static void silentClose(Closeable c) {
        if (c == null)
            return;
        try {
            c.close();
        } catch (IOException e) {
        }
    }

    private static void comparativeMethod() {
        System.out.println("============comparativeMethod============");

        if (Integer.valueOf(-128) == Integer.valueOf(-128)) {
            System.out
                    .println("Integer.valueOf(-128) == Integer.valueOf(-128)");
        } else {
            System.out
                    .println("Integer.valueOf(-128) != Integer.valueOf(-128)");
        }

        if (Integer.valueOf(127) == Integer.valueOf(127)) {
            System.out.println("Integer.valueOf(127) == Integer.valueOf(127)");
        } else {
            System.out.println("Integer.valueOf(127) != Integer.valueOf(127)");
        }

        if (Integer.valueOf(-129) == Integer.valueOf(-129)) {
            System.out
                    .println("Integer.valueOf(-129) == Integer.valueOf(-129)");
        } else {
            System.out
                    .println("Integer.valueOf(-129) != Integer.valueOf(-129)");
        }

        if (Integer.valueOf(128) == Integer.valueOf(128)) {
            System.out.println("Integer.valueOf(128) == Integer.valueOf(128)");
        } else {
            System.out.println("Integer.valueOf(128) != Integer.valueOf(128)");
        }
    }
}
