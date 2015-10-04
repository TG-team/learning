package jp.co.technica.oop.encapsulation.sort;

class ShellSort extends AbsSorter {

    @Override
    public void sort(int[] args) {
        if (args == null || args.length == 0) {
            return;
        }

        int i, j;
        for (int gap = args.length / 2; gap > 0; gap /= 2) {
            for (int h = 0; h < gap; h++) {
                for (i = h + gap; i < args.length; i += gap) {
                    int tmp = args[i];
                    for (j = i - gap; j >= h; j -= gap) {
                        if (args[j] < tmp) {
                            break;
                        }
                        args[j + gap] = args[j];
                    }
                    args[j + gap] = tmp;
                }
            }
        }

        show(args);
    }
}
