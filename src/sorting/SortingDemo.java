package sorting;

import sorting.bubble.Bubble;
import sorting.insertion.Insertion;
import sorting.merge.MergeSortWithSentinels;
import sorting.quick.Quick_v1;

import java.util.Random;

/**
 * Created by adam on 11/02/2018.
 */
public class SortingDemo {
    public static void main(String[] args) {
        for (int i = 10; i <= 100000; i*=10) {
            test(i);
        }

    }

    private static void test(int size) {
        System.out.printf("util.Input size = %d%n",size);
        int[] dataToSort = generatreRandomArray(size);
        sort(dataToSort, new MergeSortWithSentinels());
        sort(dataToSort, new Insertion());
        sort(dataToSort, new Bubble());
        sort(dataToSort, new Quick_v1());

        System.out.println("---------------------------------------------------");
    }

    private static int[] generatreRandomArray(int size) {
        int[] data = new int[size];
        Random random = new Random(47);
        for (int i = 0; i < data.length; i++) {
            data[i]=random.nextInt()%size;
        }
        return data;
    }

    private static void sort(int[] data, SortingAlgorithm algorithm) {
        long d = System.currentTimeMillis();
        long dt = System.currentTimeMillis() - d;
        System.out.printf("%s-sort algorithm time = %d[ms]%n", algorithm.getClass().getSimpleName(), dt);
    }

}
