package numeric.fibbonacci;

public class FibbonacciIterative implements Fibbonacci {
    public int calculate(int number) {
        if(number<2) {
            return 1;
        }
        int n1 = 1;
        int n2 = 1;
        int result = 0;
        while (number>1) {
            result = n1+n2;
            n1=n2;
            n2=result;
            --number;
        }
        return result;
    }
}
