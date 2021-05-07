package searching;

public class BinarySearchRecursive_v2 {
    public static void main(String[] args) {
        for (int i = 0; i <= 11; i++) {
            System.out.println(find(new int[]{1,2,3,4,5,6,7,8,9,10},i));
        }
    }

    private static int find(int[] a, int item) {
        return find(a,item,0,a.length-1);
    }

    private static int find(int[] a, int item, int begin, int end) {

        if(begin>end) {
            return -1;
        }

        int middle = (begin+end)/2;

        if(item<a[middle]) {
            return find(a,item,begin,middle-1);
        }
        if(item==a[middle]) {
            return middle;
        }
        if(item>a[middle]){
            return find(a,item,middle+1,end);
        }
        return -1;
    }
}
