package jp.co.technica.oop.encapsulation.sort;

class BubbleSort extends AbsSorter {

    @Override
    public void sort(int[] args) {
        if (args == null || args.length == 0) {
            return;
        }

        for (int i = args.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (args[j] > args[j + 1]) {
                    int tmp = args[j];
                    args[j] = args[j + 1];
                    args[j + 1] = tmp;
                }
            }
        }

        show(args);
    }
}
