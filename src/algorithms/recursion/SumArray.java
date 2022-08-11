package algorithms.recursion;

public class SumArray {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4};
        int sum = new SumArray().sum(a,0);
        System.out.println(sum);
        int sum2 = new SumArray().sumbackwards(a,a.length-1);
        System.out.println(sum2);
    }

    private int sum(int[] a, int startIndex) {
        if(startIndex>=a.length) {
            return 0;
        }
        return a[startIndex]+sum(a,startIndex+1);
    }

    private int sumbackwards(int[] a, int i) {
        if(i<0) {
            return 0;
        }
        return a[i] + sumbackwards(a, i-1);
    }
}
