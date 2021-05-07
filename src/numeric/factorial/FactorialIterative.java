package numeric.factorial;

public class FactorialIterative implements Factorial {

    @Override
    public long calculate(long number) {
        long result = 1;
        for (long i = 2; i <= number; i++) {
            result*=i;
        }
        return result;
    }

}