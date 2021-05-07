package Java8.functions;

import java.util.function.Function;

/**
 * Created by adam on 05/09/2018.
 */
public class HelloFunctions {
    public static void main(String[] args) {
        Function<Integer,String> f = Object::toString;
        PrintMe(Object::toString,10);
        System.out.println(PrintMe2(a->a*2,10));
        System.out.println(PrintMe2(a->a*3,10));
        System.out.println(PrintMe2(Integer::bitCount,100));
    }

    static void PrintMe(Function<Integer, String> f, Integer i) {
        System.out.println(f.apply(i));
    }

    static Integer PrintMe2(Function<Integer, Integer> f, Integer b) {
        return f.apply(b);
    }

}