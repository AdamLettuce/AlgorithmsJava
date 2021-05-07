package Java8.java8inaction;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PythagoreanTriples {
    public static void main(String[] args) {
        Stream<int[]> pythagoreanTriples =
                IntStream.rangeClosed(1,100).boxed()
                .flatMap(a->
                        IntStream.rangeClosed(a,100)
                            .filter(b->Math.sqrt(a*a+b*b)%1==0)
                            .mapToObj(b->new int[]{a,b,(int)Math.sqrt(a*a+b*b)})

                );


        Stream<String[]> a =
                IntStream.rangeClosed(1,10)
                .boxed()
                .flatMap(c->Stream.of(""+c)
                        .map(d->new String[]{d}));
        a.map(Arrays::asList).forEach(System.out::println);

        Stream.iterate(new int[]{0,1},t->new int[]{t[1],t[0]+t[1]})
                .limit(10)
                .forEach(t->
                        System.out.println(Arrays.toString(t)));
    }
}