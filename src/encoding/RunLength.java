package encoding;

/**
 * Created by adam on 30/04/2018.
 */
public class RunLength {
    public static void main(String[] args) {
        String text =     "AAABBBACCDDDFFFFFGGGGKKOMM";
        String expected = "3A3B1A2C3D5F4G2K1O2M";
        String encoded = encode(text);
        System.out.println(expected.equals(encoded));

        String decoded = decode(encoded);
        System.out.println(text.equals(decoded));
    }

    public static String encode(String input) {
        String tmp = input + " ";
        StringBuffer sb = new StringBuffer();

        char[] chars = tmp.toCharArray();

        int length = 1;
        for (int i = 1; i < chars.length; i++) {
            if(chars[i-1]!=chars[i]) {
                char ch = chars[i-1];
                sb.append(length);
                sb.append(ch);
                length=0;
            }
            ++length;
        }

        return sb.toString();
    }

    public static String decode(String input) {
        StringBuffer sb = new StringBuffer();
        StringBuffer tmp = new StringBuffer();
        String input1 = input + " ";
        for (int i = 1; i < input1.length(); i++) {
            boolean isPreviousCharDigit = Character.isDigit(input.charAt(i-1));
            if(isPreviousCharDigit) {
                tmp.append(input.charAt(i-1));
            }
            if(!isPreviousCharDigit) {
                char ch = input1.charAt(i-1);
                int count = Integer.valueOf(tmp.toString());
                for (int j = 0; j < count; j++) {
                    sb.append(ch);
                }
                tmp = new StringBuffer();
            }
        }
        return sb.toString();
    }
}
