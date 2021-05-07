package sorting.merge;

import util.ArrayUtil;

public class MergeSort {
    public static void main(String[] args) {
        int[] data = new int[]{7, 6, 5, 4, 3, 2, 1, 0};
        ArrayUtil arrayUtil = new ArrayUtil();
        System.out.println("Before sort: ");
        arrayUtil.print(data);
        sort(data);
        System.out.println("After sort: ");
        arrayUtil.print(data);
    }

    private static void sort(int[] data) {
        sort(data, 0, data.length - 1);
    }

    private static void sort(int[] data, int left, int right) {
        int middle = ((left + right) / 2);
        if (right - left > 1) {
            sort(data, left, middle);
            sort(data, middle + 1, right);
        }
        merge(data, left, middle, right);
    }

    private static void merge(int[] data, int left, int middle, int right) {
        int[] leftData = new int[middle - left + 1];
        int j = 0;
        for (int i = left; i <= middle; i++) {
            leftData[j++] = data[i];
        }

        int[] rightData = new int[right - middle];
        j = 0;
        for (int i = middle + 1; i <= right; i++) {
            rightData[j++] = data[i];
        }

        int leftCounter = 0;
        int rightCounter = 0;
        j = left;
        while (leftCounter < leftData.length && rightCounter < rightData.length) {
            if (leftData[leftCounter] <= rightData[rightCounter]) {
                data[j++] = leftData[leftCounter++];
            } else {
                data[j++] = rightData[rightCounter++];
            }
        }
        while (leftCounter < leftData.length) {
            data[j++] = leftData[leftCounter++];
        }
        while (rightCounter < rightData.length) {
            data[j++] = rightData[rightCounter++];
        }

    }

}