package numeric.factorial;

public class FactorialRecursive implements Factorial {

    @Override
    public long calculate(long number) {
        if (number == 0 || number == 1) {
            return 1;
        }
        return number * calculate(number - 1);
    }


}
