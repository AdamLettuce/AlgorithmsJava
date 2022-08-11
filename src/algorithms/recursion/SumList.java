package algorithms.recursion;

import java.util.ArrayList;
import java.util.List;

public class SumList {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        int x1 = new SumList().calculate(a, a.size()-1);
        System.out.println(x1);

        int x2 = new SumList().calculate(a, a.size()-1);
        System.out.println(x2);
    }

    private int calculate(List<Integer> a, int i) {
        if(i<0) {
            return 0;
        }
        return a.get(i) + calculate(a.subList(0,i),i-1);
    }

    private int calculate_(List<Integer> a, int i) {
        if(i>=a.size()) {
            return 0;
        }
        return a.get(i) + calculate(a.subList(i,a.size()),i+1);
    }
}
