package sorting.selection;

import util.ArrayUtil;

public class SelectiomMaximumSimple {
    public static void main(String[] args) {
        int[] data = new int[]{ 5, 4, 3, 2, 1};
        ArrayUtil arrayUtil = new ArrayUtil();
        arrayUtil.print(data);
        sort(data);
        arrayUtil.print(data);
    }

    private static void sort(int data[]) {
        for (int i = data.length-1; i > 0; i--) {
            int maxIndex = i;
            for (int j = 0; j < i; j++) {
                if(data[j]>data[maxIndex]) {
                    maxIndex = j;
                }
            }
            int tmp = data[maxIndex];
            data[maxIndex]=data[i];
            data[i]=tmp;
        }
    }
}
