package sorting.bubble;

import java.util.Arrays;

public class BubbleFromEnd {
    public static void main(String[] args) {
        int [] a = new int[]{10,5,4,3,54,2,1};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));

    }

    private static void sort(int[] a) {
        for(int i=0;i<a.length;++i) {
            for(int j=a.length-1;j>i;--j) {
                if(a[j]<a[j-1]) {
                    int tmp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = tmp;
                }
            }
        }
    }
}
