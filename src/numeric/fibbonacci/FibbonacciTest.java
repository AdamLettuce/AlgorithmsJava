package numeric.fibbonacci;

public class FibbonacciTest {
    public static void main(String[] args) {
        int max = 45;
        test(new FibbonacciIterative(),max);
        test(new FibbonacciRecursive(),max);
    }

    private static void test(Fibbonacci fibbonacci, int max) {
        System.out.println(fibbonacci.calculate(max));
    }

}
