package expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BalancedExpression {

    private static final List<Character> opening = new ArrayList<>();
    {
        opening.add('(');
        opening.add('<');
        opening.add('[');
        opening.add('{');
    }

    private static final List<Character> closing = new ArrayList<>();
    {
        closing.add(')');
        closing.add('>');
        closing.add(']');
        closing.add('}');
    }

    public static void main(String[] args) {
        String str = "(([1] + <2>))[a]";
        String str1 = "((<1] + <2>))[a]";
        String str2 = "()]";
        String str3 = "]";
        String str4 = "[";
        String str5 = "][";

        BalancedExpression be = new BalancedExpression();
        System.out.println(be.isBalanced(str));
        System.out.println(be.isBalanced(str1));
        System.out.println(be.isBalanced(str2));
        System.out.println(be.isBalanced(str3));
        System.out.println(be.isBalanced(str4));
        System.out.println(be.isBalanced(str5));
    }

    public boolean isBalanced(String expression) {
        Stack<Character> openingBrackets = new Stack<>();
        for (char token : expression.toCharArray()) {
            if (opening.contains(token)) {
                openingBrackets.push(token);
            }
            if (closing.contains(token)) {
                if (openingBrackets.isEmpty() || !bracketsMatch(openingBrackets.peek(),token)) {
                    return false;
                }
                if (openingBrackets.contains(openingBrackets.peek())) {
                    openingBrackets.pop();
                }
            }
        }
        return openingBrackets.isEmpty();
    }

    private boolean bracketsMatch(Character left, Character right) {
        return opening.indexOf(left) == closing.indexOf(right);
    }

}
