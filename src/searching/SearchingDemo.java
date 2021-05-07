package searching;

/**
 * Created by adam on 11/02/2018.
 */
public class SearchingDemo {
    public static void main(String[] args) {
        int[] data =  {1,4,5,2,7,8,9,10};
        SearchingAlgorithm linear = new LinearRecursive();

        System.out.println(linear.find(data,1));
        System.out.println(linear.find(data,8));
        System.out.println(linear.find(data,10));
        System.out.println(linear.find(data,20));
    }
}
