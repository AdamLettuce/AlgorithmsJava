package algorithms.recursion;

public class Factorial {
    public static void main(String[] args) {
        int x = new Factorial().calculate(5);
        System.out.println(x);
    }

    private int calculate(int i) {
        if(i==0) {
            return 1;
        }
        return i*calculate(i-1);
    }
}
