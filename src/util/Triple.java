package util;

/**
 * Created by adam on 04/05/2018.
 */
public class Triple<T,U,V> {
    private final Pair<T,U> pair;
    private final V third;


    public Triple(T first, U second, V third) {
        this.pair = new Pair<T, U>(first,second);
        this.third = third;
    }

    public T getFirst() {
        return pair.getFirst();
    }

    public U getSecond() {
        return pair.getSecond();
    }

    public V getThird() {
        return third;
    }

    @Override
    public String toString() {
        return "["
                 + pair.getFirst() +
                ", " + pair.getSecond() +
                ", " + getThird() + "]";
    }
}
