package util;

import java.util.Objects;

/**
 * Created by adam on 02/05/2018.
 */
public class Interval<T extends Comparable> {
    private final T begin;
    private final T end;

    public Interval(T begin, T end) {
        this.begin = begin;
        this.end = end;
    }

    public T getBegin() {
        return begin;
    }

    public T getEnd() {
        return end;
    }

    public boolean intersects(Interval<T> other) {
        return false;
    }

    public boolean contains(T value) { return false;}

    @Override
    public String toString() {
        return "[" + begin + ", " + end + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Interval<?> interval = (Interval<?>) o;

        if (!Objects.equals(begin, interval.begin)) return false;
        return Objects.equals(end, interval.end);
    }

    @Override
    public int hashCode() {
        int result = begin != null ? begin.hashCode() : 0;
        result = 31 * result + (end != null ? end.hashCode() : 0);
        return result;
    }
}
