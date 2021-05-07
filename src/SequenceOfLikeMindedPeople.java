import java.util.ArrayList;
import java.util.List;



/**
 * Created by adam on 27/04/2018.
 */
public class SequenceOfLikeMindedPeople {
    public static void main(String[] args) {
//        find(new Direction[]{Left,Left,Right,Right,Right,Left,Right,Right,Right,Left,Left,Right,Left,None});
//        find1(new Direction[]{Left,Left,Right,Right,Right,Left,Right,Right,Right,Left,Left,Right,Left,None});
        findWithBareheaded(new Direction[]{Direction.Left, Direction.Left, Direction.Right, Direction.Bare, Direction.Right, Direction.Left, Direction.Right, Direction.Right, Direction.Right, Direction.Left, Direction.Bare, Direction.Left, Direction.Left,Direction.None});
    }

    private static void findWithBareheaded(Direction[] A) {

        if(A==null || A.length==0) {
            return;
        }

        int leftCount = 0;
        int rightCount = 0;

        List<Interval> intervals = new ArrayList<>();
        int intervalBegin = 0;

        for (int i = 1; i < A.length; i++) {
            if(A[i-1]!=A[i]) {
                intervals.add(new Interval(intervalBegin,i-1,A[i-1]));
                intervalBegin = i;
                if(A[i-1]== Direction.Left) {
                    leftCount++;
                }
                if(A[i-1]== Direction.Right) {
                    rightCount++;
                }
            }
        }

        System.out.println(Math.min(leftCount,rightCount));
        final Direction finalDirection;
        if(leftCount<rightCount) {
            finalDirection= Direction.Left;
        } else {
            finalDirection= Direction.Right;
        }

        intervals.stream().filter(i->i.getDirection()==finalDirection).forEach(i-> System.out.println(i));
    }

    //Here the idea is based that there is always less intervals with which we don't start
    private static void find1(Direction[] A) {

        if(A==null || A.length==0) {
            return;
        }

        int count = 0;

        int intervalBegin = 0;

        Direction startInterval = null;
        if(A[0]==Direction.Left) {
            startInterval=Direction.Right;
        } else {
            startInterval=Direction.Left;
        }

        for (int i = 1; i < A.length; i++) {
            if(A[i-1]!=A[i]) {
                if(A[i-1]==startInterval) {
                    System.out.println(new Interval(intervalBegin,i-1,A[i-1]));
                    count++;
                }
                intervalBegin = i;
            }
        }

        System.out.println(count);


    }

    private static void find(Direction[] A) {

        if(A==null || A.length==0) {
            return;
        }

        int leftCount = 0;
        int rightCount = 0;

        List<Interval> intervals = new ArrayList<>();
        int intervalBegin = 0;

        for (int i = 1; i < A.length; i++) {
            if(A[i-1]!=A[i]) {
                intervals.add(new Interval(intervalBegin,i-1,A[i-1]));
                intervalBegin = i;
                if(A[i-1]==Direction.Left) {
                    leftCount++;
                }
                if(A[i-1]==Direction.Right) {
                    rightCount++;
                }
            }
        }

        System.out.println(Math.min(leftCount,rightCount));

        intervals.stream().forEach(i-> System.out.println(i));
    }
}

enum Direction {
    Left,Right,Bare,None;
}


class Interval {
    private int beginIndex;
    private int endIndex;
    private Direction direction;

    public Interval(int beginIndex, int endIndex, Direction direction) {
        this.beginIndex = beginIndex;
        this.endIndex = endIndex;
        this.direction = direction;
    }


    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        if(beginIndex==endIndex) {
            return "Interval{" +
                    "beginIndex=" + beginIndex +
                    ", direction=" + direction +
                    '}';
        }
        return "Interval{" +
                "beginIndex=" + beginIndex +
                ", endIndex=" + endIndex +
                ", direction=" + direction +
                '}';
    }
}