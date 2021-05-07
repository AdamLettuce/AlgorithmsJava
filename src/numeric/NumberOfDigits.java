package algo.numberofdigits;

public class NumberOfDigits {
    public static void main(String[] args) {
        System.out.println(new NumberOfDigits().calculate(1));
        System.out.println(new NumberOfDigits().calculate(10));
        System.out.println(new NumberOfDigits().calculate(100));
        System.out.println(new NumberOfDigits().calculate(1000));

    }

    private int calculate(int x) {
        int result = 0;
        while (x > 0) {
            x /= 10;
            result++;
        }
        return result;
    }
}
