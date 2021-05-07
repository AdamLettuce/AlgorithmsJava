package searching;

public class BinarySearchIterative_v2 {
    public static void main(String[] args) {
        for (int i = 0; i <= 11; i++) {
            System.out.println(find(new int[]{1,2,3,4,5,6,7,8,9,10},i));
        }
    }

    private static int find(int[] a, int item) {
        int left = 0;
        int right = a.length-1;
        while(left<=right) {
            int middle = (left+right)/2;
            if(a[middle]==item) {
                return middle;
            }
            if(item<a[middle]) {
                right = middle-1;
            }
            if(item>a[middle]) {
                left  = middle+1;
            }
        }
        return -1;
    }
}
