package jp.co.technica.imple.make_clazz.type;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utils {

    private Utils() {
    }

    public static void output(Process p) throws IOException {
        InputStreamReader isr = new InputStreamReader(p.getInputStream(),
                Consts.Shift_JIS);
        BufferedReader br = new BufferedReader(isr);

        String result;
        while ((result = br.readLine()) != null) {
            System.out.println(result);
        }
    }
}
