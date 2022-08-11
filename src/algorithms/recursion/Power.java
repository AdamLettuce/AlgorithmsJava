package algorithms.recursion;

public class Power {
    public static void main(String[] args) {
        int x = new Power().calculate(5,3);
        System.out.println(x);
    }

    private int calculate(int n, int k) {
        if(k==0) {
            return 1;
        }
        return n * calculate(n,k-1);
    }
}
