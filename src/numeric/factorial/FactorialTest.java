package numeric.factorial;

public class FactorialTest {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            test( new FactorialRecursive(),i);
            test( new FactorialIterative(),i);
        }
    }

    private static void test(Factorial factorialAlgorithm, int number) {
        long t0 = System.currentTimeMillis();
        long result = factorialAlgorithm.calculate(number);
        long dt = System.currentTimeMillis() - t0;
        System.out.println(String.format("%d, time = %d [ms]", result, dt));
    }
}
