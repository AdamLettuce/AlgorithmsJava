package algorithms.recursion;

public class SumFirstN {
    public static void main(String[] args) {
        int x = new SumFirstN().calculate2(10);
        System.out.println(x);
    }

    private int calculate(int i) {
        if(i==1) {
            return 1;
        }
        return i + calculate(i-1);
    }

    private int calculate2(int i) {
        if(i>0) {
            return i + calculate(i-1);
        }
        return 1;
    }
}
