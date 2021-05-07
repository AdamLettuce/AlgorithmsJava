package string;

public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("abcba"));
        System.out.println(isPalindrome("abca"));
    }

    private static boolean isPalindrome(String word) {
        char[] letters = word.toCharArray();
        for (int i = 0; i < word.length() / 2; i++) {
            if(letters[i]!=letters[word.length()-1-i]) {
                return false;
            }
        }
        return true;
    }
}
