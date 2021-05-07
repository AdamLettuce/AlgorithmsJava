package scheduling;

import util.IntegerInterval;
import util.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by adam on 04/05/2018.
 */
public class LinearIntervalSchedulerLimited {
    public static void main(String[] args) {
//        int beginTime = 6;
//        int endTime = 8;
//        int result = findSolution(beginTime, endTime);//5
        int beginTime = 10;
        int endTime = 12;
        int result = findSolution(beginTime, endTime);//5
        System.out.printf("Maximum selfies with %d celebrity(ies) from %d to %d%n", result, beginTime, endTime);
    }

    private static Integer findSolution(int beginTime, int endTime) {
        List<Pair<Integer, PointIntervalType>> sortedIntervals = retrieveSortedIntervals(beginTime,endTime);
        return simulateRuler(sortedIntervals);
    }

    private static List<Pair<Integer, PointIntervalType>> retrieveSortedIntervals(int beginTime, int endTime) {
        List<CelebritySchedule> schedules = CelebritySchedule.retrieve();
        List<Pair<Integer, PointIntervalType>> intervals = getIntervals(schedules, beginTime,endTime);
        sortByBeginTime(intervals);
        return intervals;
    }

    private static int simulateRuler(List<Pair<Integer, PointIntervalType>> intervals) {
        int count = 0;
        for (Pair<Integer, PointIntervalType> time : intervals) {
            if (time.getSecond() == PointIntervalType.BEGIN) {
                ++count;
            }
        }
        return count;
    }

    private static void sortByBeginTime(List<Pair<Integer, PointIntervalType>> intervals) {
        intervals.sort((Comparator.comparing(Pair::getFirst)));
    }

    private static List<Pair<Integer, PointIntervalType>> getIntervals(List<CelebritySchedule> schedules, int hourFrom, int hourTo) {
        List<Pair<Integer, PointIntervalType>> result = new ArrayList<>();
        for (CelebritySchedule schedule : schedules) {
            if(new IntegerInterval(schedule.getHourFrom(),schedule.getHourTo()).intersects(new IntegerInterval(hourFrom,hourTo))) {
                result.add(new Pair<>(schedule.getHourFrom(), PointIntervalType.BEGIN));
                result.add(new Pair<>(schedule.getHourTo(), PointIntervalType.END));
            }
        }
        return result;
    }
}
