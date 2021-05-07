package sorting;

import util.ArrayUtil;

public class ShellByMyself {
    public static void main(String[] args) {
        //length = 9
        //                     0  1  2  3  4  5  6  7  8
        int[] data = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        ArrayUtil arrayUtil = new ArrayUtil();
        System.out.println("Before sort: ");
        arrayUtil.print(data);
        sort(data);
        System.out.println("After sort: ");
        arrayUtil.print(data);
    }

    private static void sort(int[] data) {
        int initialIntervalsCount = 1;
        int h = data.length/initialIntervalsCount;
        while(h>=1) {
            System.out.println("h= " +h);
            for (int i = h; i < data.length; i+=1) {
                int j = i - h ;
                int key = data[i];
                while (j>=0 && key<data[j]) {
                    data[j+h] = data[j];
                    j-=h;
                }
                data[j+h]=key;
            }
            h=h/3;
            new ArrayUtil().print(data);
        }


    }

    private static void swap(int[] data, int h, int i) {
        int tmp = data[i];
        data[i] = data[i+h];
        data[i+h] = tmp;
    }
}
