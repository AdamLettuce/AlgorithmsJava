package leetcode;

/* LeetCode solution */
public class BinarySum_67 {

    public static void main(String[] args) {
        System.out.println(new BinarySum_67().addBinary("1010","1011"));
        System.out.println(new BinarySum_67().addBinary("11","1"));
        System.out.println(new BinarySum_67().addBinary("0","0"));
        System.out.println(new BinarySum_67().addBinary("0","1"));
    }

    public String addBinary(String a, String b) {

        int n = a.length(), m = b.length();
        if (n < m) return addBinary(b, a);
        int L = Math.max(n, m);

        StringBuilder sb = new StringBuilder();
        int carry = 0, j = m - 1;
        for(int i = L - 1; i > -1; --i) {
            if (a.charAt(i) == '1') ++carry;
            if (j > -1 && b.charAt(j--) == '1') ++carry;

            if (carry % 2 == 1) sb.append('1');
            else sb.append('0');

            carry /= 2;
        }
        if (carry == 1) sb.append('1');
        sb.reverse();

        return sb.toString();

    }

}
