package jp.co.technica.imple.make_clazz.immutable;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        immutableCheck();

        mutableCheck1();
        mutableCheck2();
    }

    private static void immutableCheck() {
        System.out.println("============immutableCheck");
        Map<ImmutablePoint, String> immutablePoints = new HashMap<ImmutablePoint, String>();

        ImmutablePoint immutablePoint = ImmutablePoint.valueOf(123, 456);
        immutablePoints.put(immutablePoint, "123, 456");

        System.out
                .println(immutablePoints.get(ImmutablePoint.valueOf(123, 456)));
    }

    private static void mutableCheck1() {
        System.out.println("============mutableCheck1");
        Map<MutablePoint, String> mutablePoints = new HashMap<MutablePoint, String>();

        MutablePoint mutablePoint = new MutablePoint(654, 321);
        mutablePoints.put(mutablePoint, "654, 321");

        System.out.println(mutablePoints.get(mutablePoint));

        mutablePoint.setX(321);
        System.out.println(mutablePoints.get(mutablePoint));
    }

    private static void mutableCheck2() {
        System.out.println("============mutableCheck2");
        Map<MutablePoint, String> mutablePoints = new HashMap<MutablePoint, String>();

        MutablePoint mutablePoint = new MutablePoint(654, 321);
        mutablePoints.put(mutablePoint, "654, 321");
        mutablePoint.setX(321);

        System.out.println(mutablePoints.get(mutablePoint));
    }

}
