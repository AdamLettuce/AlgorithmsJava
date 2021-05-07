package util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adam on 11/03/2018.
 */
public class ArrayUtil {

    public int sliceSum(int[] A, int begin, int end) {
        int [] B = prefixSum(A);
        if(begin>=1) {
            return B[end] - B[begin - 1];
        }
        return B[end];
    }

    public int[] prefixSum(int[] A) {

        if (A == null) {
            return null;
        }

        if (A.length == 1) {
            return new int[]{A[0]};
        }

        int[] result = new int[A.length];

        result[0] = A[0];

        for (int i = 1; i < A.length; i++) {
            result[i] = result[i - 1] + A[i];
        }
        return result;
    }

    public int[] postfixSum(int[] A) {

        if (A == null) {
            return null;
        }

        if (A.length == 1) {
            return new int[]{A[0]};
        }

        int[] result = new int[A.length];


        result[A.length - 1] = A[A.length - 1];


        for (int i = A.length - 2; i > 0; i--) {
            result[i] = A[i] + result[i + 1];
        }

        return result;
    }

    public int[] toArray(List<Integer> left) {
        int[] l = new int[left.size()];
        for (int i = 0; i < left.size(); i++) {
            l[i] = left.get(i);
        }


        return l;
    }

    public List<Integer> toList(int[] a) {
        List<Integer> l = new ArrayList<>();
        for (int j : a) {
            l.add(j);
        }
        return l;
    }

    public void print(int[] data) {
        if(data.length==0) {
            System.out.println();
            return;
        }
        for (int i = 0; i < data.length - 1; i++) {
            System.out.print(data[i] + ",");
        }
        System.out.println(data[data.length - 1]);
    }
}
