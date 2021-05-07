package sorting.insertion;

import util.ArrayUtil;

public class Insertion_v2 {
    public static void main(String[] args) {
        int[] data = new int[]{ 5, 4, 3, 2, 1};
        ArrayUtil arrayUtil = new ArrayUtil();
        arrayUtil.print(data);
        sort(data);
        arrayUtil.print(data);
    }

    private static void sort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int key = data[i];
            int j = i - 1;
            while (j>=0 && key<data[j]) {
                data[j+1]=data[j--];
            }
            data[j+1]=key;
        }
    }
}
