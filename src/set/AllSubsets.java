package set;

public class AllSubsets {
    public static void main(String[] args) {
        char[] set = {'a','b','c'};
        for (int i = 0; i < Math.pow(2,set.length); i++) {
            String binaryString = Integer.toBinaryString(i);
            char[] bits =      String.format("%1$"+(set.length)+"s", binaryString).replace(' ','0').toCharArray();
            for (int j = 0; j < bits.length; j++) {
                if(bits[j]!='0') {
                    System.out.print(set[j]);
                }
            }
            System.out.println();
        }
    }
}
