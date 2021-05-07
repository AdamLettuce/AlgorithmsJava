package numeric.fibbonacci;

public class FibbonacciRecursive implements Fibbonacci {
    public int calculate(int number) {
        if(number < 2) {
            return 1;
        }
        return calculate(number-2)+calculate(number-1);
    }
}
