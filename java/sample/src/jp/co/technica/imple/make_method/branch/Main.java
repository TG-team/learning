package jp.co.technica.imple.make_method.branch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {

        instanceSpeed();

        stringConcatenation();

        autoboxing();

    }

    private static void instanceSpeed() {
        System.out.println("===========instanceSpeed===========");

        long time = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("StringBuilder#append : ").append(i);
        }
        System.out.println("Time(In Loop) : "
                + (System.currentTimeMillis() - time));

        time = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            sb.append("StringBuilder#append : ").append(i);
            sb.setLength(0);
        }
        System.out.println("Time(Out Loop) : "
                + (System.currentTimeMillis() - time));

        time = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            try {
                FileInputStream fis = new FileInputStream("c:\\sample.sample");
            } catch (FileNotFoundException e) {
            }
        }
        System.out.println("Time(In Try-catch) : "
                + (System.currentTimeMillis() - time));

        time = System.currentTimeMillis();
        try {
            for (int i = 0; i < 10000; i++) {
                FileInputStream fis = new FileInputStream("c:\\sample.sample");
            }
        } catch (FileNotFoundException e) {
        }
        System.out.println("Time(Out Try-catch) : "
                + (System.currentTimeMillis() - time));
    }

    private static void stringConcatenation() {
        System.out.println("===========stringConcatenation===========");

        long time = System.currentTimeMillis();
        String result = "";
        for (int i = 0; i < 10000; i++) {
            result += Integer.toString(i);
        }
        System.out.println("Time(+=) : " + (System.currentTimeMillis() - time));

        time = System.currentTimeMillis();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            builder.append(Integer.toString(i));
        }
        System.out.println("Time(StringBuilder#append) : "
                + (System.currentTimeMillis() - time));

    }

    private static void autoboxing() {
        System.out.println("===========autoboxing===========");

        long time = System.currentTimeMillis();
        long sum1 = 0;
        for (int i = 0; i < 100000000; i++) {
            sum1 += i;
        }
        System.out.println("Time(primitive) : "
                + (System.currentTimeMillis() - time));

        time = System.currentTimeMillis();
        Long sum2 = 0L;
        for (int i = 0; i < 100000000; i++) {
            sum2 += i;
        }
        System.out.println("Time(wrapper) : "
                + (System.currentTimeMillis() - time));
    }
}
