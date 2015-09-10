package jp.co.technica.oop.encapsulation.sort;

class QuickSort extends AbsSorter {

    @Override
    public void sort(int[] args) {
        if (args == null || args.length == 0) {
            return;
        }

        quickSort(args, 0, args.length - 1);

        show(args);
    }

    protected static void quickSort(int[] args, int low, int high) {
        if (args == null || args.length == 0) {
            return;
        }
        if (low >= high) {
            return;
        }

        int middle = low + (high - low) / 2;
        int pivot = args[middle];

        int i = low, j = high;
        while (i <= j) {
            while (args[i] < pivot) {
                i++;
            }

            while (args[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = args[i];
                args[i] = args[j];
                args[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j) {
            quickSort(args, low, j);
        }
        if (high > i) {
            quickSort(args, i, high);
        }
    }
}
