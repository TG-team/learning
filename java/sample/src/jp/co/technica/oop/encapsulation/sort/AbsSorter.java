package jp.co.technica.oop.encapsulation.sort;

import java.util.Arrays;

abstract class AbsSorter implements Sorter {

    protected void show(int[] result) {
        System.out.println(Arrays.toString(result));
    }

}
