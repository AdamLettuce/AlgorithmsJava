package algo.triangle;

public class EquilateralAstriksTriangle {
    public static void main(String[] args) {
        int width = 10;
        for (int i = width; i > 0; i--) {
            for (int j = width - i; j > 0; j--) {
                System.out.print("  ");
            }
            for (int j = 2 * i - 1; j > 0; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
