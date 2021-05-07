package sorting.quick;

import java.util.Arrays;

public class Quick {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{100, 4, 7, 8, 30, 9, 12, 11})));
    }

    private static int[] sort(int[] data) {
        sort(data, 0, data.length - 1);
        return data;
    }

    private static void sort(int[] A, int begin, int end) {
        if(begin<end) {
            int pivot = partition(A,begin,end);
            sort(A,begin,pivot-1);
            sort(A,pivot+1,end);
        }
    }

    private static int partition(int[] A, int begin, int end) {
        int leftEnd = begin-1;
        int pivotValue = A[end];
        for (int i = begin; i < end; i++) {
            if(A[i]<pivotValue) {
                swap(A,++leftEnd,i);
            }
        }
        swap(A,++leftEnd,end);
        return leftEnd;
    }

    private static void swap(int[] data, int firstIndex, int secondIndex) {
        int tmp = data[secondIndex];
        data[secondIndex] = data[firstIndex];
        data[firstIndex] = tmp;
    }
}
