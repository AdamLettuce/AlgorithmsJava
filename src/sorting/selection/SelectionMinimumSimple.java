package sorting.selection;

import util.ArrayUtil;

public class SelectionMinimumSimple {
    public static void main(String[] args) {
        int[] data = new int[]{10, 5, 4, 9, 3, 2, 1};
        ArrayUtil arrayUtil = new ArrayUtil();
        arrayUtil.print(data);
        sort(data);
        arrayUtil.print(data);
    }

    private static void sort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = tmp;
        }
    }
}
