package jp.co.technica.oop.encapsulation.sort;

public class SortManager {

    private SortManager() {
    }

    public static Sorter creater(Type type) {
        if (type == null) {
            throw new IllegalArgumentException("Illegal sort type.");
        }

        Sorter sorter;
        if (type == Type.BUBBLE) {
            sorter = new BubbleSort();
        } else if (type == Type.QUICK) {
            sorter = new QuickSort();
        } else if (type == Type.SHELL) {
            sorter = new ShellSort();
        } else {
            throw new IllegalStateException("Unknown sort type.");
        }

        return sorter;
    }

}
