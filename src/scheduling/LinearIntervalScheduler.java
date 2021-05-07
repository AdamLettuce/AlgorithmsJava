package scheduling;

import util.IntegerInterval;
import util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by adam on 02/05/2018.
 */
public class LinearIntervalScheduler {

    public static void main(String[] args) {
        Pair<Integer, Integer> result = findSolution();
        System.out.println(String.format("Maximum selfies with %d celebrity(ies) from %d", result.getFirst(), result.getSecond()));
    }

    private static Pair<Integer, Integer> findSolution() {
        return simulateRuler(retrieveSortedIntervals());
    }

    private static List<Pair<Integer, PointIntervalType>> retrieveSortedIntervals() {
        List<CelebritySchedule> schedules = CelebritySchedule.retrieve();
        List<Pair<Integer, PointIntervalType>> intervals = getIntervals(schedules);
        sortByBeginTime(intervals);
        return intervals;
    }

    private static Pair<Integer, Integer> simulateRuler(List<Pair<Integer, PointIntervalType>> intervals) {
        int hour = 0;
        int max = 0;
        int count = 0;
        for (Pair<Integer, PointIntervalType> time : intervals) {
            if (time.getSecond() == PointIntervalType.BEGIN) {
                ++count;
            }
            if (time.getSecond() == PointIntervalType.END) {
                --count;
            }
            if (count > max) {
                hour = time.getFirst();
                max = count;
            }
        }

        return new Pair<>(max, hour);
    }

    private static void sortByBeginTime(List<Pair<Integer, PointIntervalType>> intervals) {
        Collections.sort(intervals, ((o1, o2) -> {
            if (o1.getFirst() < o2.getFirst()) {
                return -1;
            }
            if (o1.getFirst() > o2.getFirst()) {
                return 1;
            }
            return 0;
        }));
    }


    private static List<Pair<Integer, PointIntervalType>> getIntervals(List<CelebritySchedule> schedules) {
        List<Pair<Integer, PointIntervalType>> result = new ArrayList<>();
        for (CelebritySchedule schedule : schedules) {
            result.add(new Pair<>(schedule.getHourFrom(), PointIntervalType.BEGIN));
            result.add(new Pair<>(schedule.getHourTo(), PointIntervalType.END));
        }
        return result;
    }



}
