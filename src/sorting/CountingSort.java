package sorting;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{100, 4, 7, 8, 30, 9, 12, 11})));
    }

    private static int[] sort(int[] data) {
        int max = findMax(data);
        int helper[] = new int[max+1];
        for (int i = 0; i < data.length; i++) {
            helper[data[i]]++;
        }
        int idx = 0;
        for (int i = 0; i < helper.length; i++) {
            if(helper[i]>0) {
                for (int j = 0; j < helper[i]; j++) {
                    data[idx++] = i;
                }
            }
        }
        return data;
    }

    private static int findMax(int[] data) {
        int max = data[0];
        for (int i = 1; i < data.length; i++) {
            if(data[i]>max) {
                max = data[i];
            }
        }
        return max;
    }
}
