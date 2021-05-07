package algo.triangle;

public class RectangularAsteriksTriangle {
    public static void main(String[] args) {
        int width = 10;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
