package sorting.selection;


import util.ArrayUtil;

public class Selection {
    public static void main(String[] args) {
        int[] data = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        ArrayUtil arrayUtil = new ArrayUtil();
        System.out.println("Before sort: ");
        arrayUtil.print(data);
        sort(data);
        System.out.println("After sort: ");
        arrayUtil.print(data);
    }

    private static void sort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            swapMinimum(data, i, findMinimum(data, i));
        }
    }

    private static void swapMinimum(int[] data, int i, Minimum minimum) {
        if (data[i] != minimum.value) {
            int tmp = data[i - 1];
            data[i - 1] = minimum.value;
            data[minimum.index] = tmp;
        }
    }

    private static Minimum findMinimum(int[] data, int beginIndex) {
        int minimum = data[beginIndex - 1];
        int minimumIndex = beginIndex - 1;
        for (int subArrayIndex = beginIndex; subArrayIndex < data.length; subArrayIndex++) {
            if (data[subArrayIndex] < minimum) {
                minimum = data[subArrayIndex];
                minimumIndex = subArrayIndex;
            }
        }
        return new Minimum(minimum, minimumIndex);
    }

    private static class Minimum {
        private int value;
        private int index;

        private Minimum(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
