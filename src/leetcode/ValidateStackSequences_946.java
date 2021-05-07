package leetcode;

import java.util.Stack;

public class ValidateStackSequences_946 {

    public static void main(String[] args) {
//        int [] pushed = new int[]{1,2,3,4,5};
//        int [] poped = new int[]{4,5,3,2,1};
        int [] pushed = new int[]{2,1,0};
        int [] poped = new int[]{1,2,0};
        System.out.println(new ValidateStackSequences_946().validateStackSequences(pushed,poped));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> tmp = new Stack<>();

        int i=0,j=0;
        while(i<pushed.length) {
            if(!tmp.isEmpty() && tmp.peek()==popped[j]) {
                tmp.pop();
                j++;
            } else {
                tmp.push(pushed[i++]);
            }
        }

        while(j<popped.length) {
            if(tmp.peek()==popped[j]) {
                tmp.pop();
                ++j;
            } else {
                break;
            }
        }

        return tmp.isEmpty();
    }
}
