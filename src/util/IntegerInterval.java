package util;

/**
 * Created by adam on 02/05/2018.
 */
public class IntegerInterval extends Interval<Integer> {

    public IntegerInterval(Integer begin, Integer end) {
        super(begin, end);
    }

    @Override
    public boolean intersects(Interval<Integer> other) {
        return this.getBegin() < other.getEnd() && other.getBegin() < this.getEnd();
    }

    public boolean contains(Integer value) {
        return this.getBegin()<=value && value<this.getEnd();
    }

    public int length() {
        return Math.abs(getEnd()-getBegin());
    }
}
