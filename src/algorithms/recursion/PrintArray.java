package algorithms.recursion;

public class PrintArray {
    public static void main(String[] args) {
        int [] a = new int[]{1,2,3};
        System.out.println("Print from begin to ene: ");
        new PrintArray().print(a, 0);
        System.out.println("Reverse order: ");
        new PrintArray().printReverse(a, 0);
    }

    private void print(int[] a, int i) {
        if(i>=a.length) {
            return;
        }
        System.out.println(a[i]);
        print(a,i+1);
    }

    private void printReverse(int[] a, int i) {
        if(i>=a.length) {
            return;
        }
        printReverse(a,i+1);
        System.out.println(a[i]);
    }
}
