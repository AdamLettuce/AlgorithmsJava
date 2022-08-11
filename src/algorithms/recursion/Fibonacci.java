package algorithms.recursion;

public class Fibonacci {
    public static void main(String[] args) {
        int n = new Fibonacci().calculate(7);
        System.out.println(n);
    }

    private int calculate(int i) {
        if(i==1||i==2) {
            return 1;
        }
        return calculate(i-1)+calculate(i-2);
    }


}
