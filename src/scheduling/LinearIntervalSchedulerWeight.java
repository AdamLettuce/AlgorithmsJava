package scheduling;

import util.Pair;
import util.Triple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by adam on 02/05/2018.
 */
public class LinearIntervalSchedulerWeight {

    public static void main(String[] args) {
        Pair<Integer, Integer> result = findSolution();
        System.out.printf("Maximum selfies with %d celebrity(ies) from %d%n", result.getFirst(), result.getSecond());
    }

    private static Pair<Integer, Integer> findSolution() {
        return simulateRuler(retrieveSortedIntervals());
    }

    private static List<Triple<Integer, PointIntervalType,Integer>> retrieveSortedIntervals() {
        List<CelebritySchedule> schedules = CelebritySchedule.retrieveWeights();
        List<Triple<Integer, PointIntervalType, Integer>> intervals = getIntervals(schedules);
        sortByTime(intervals);
        return intervals;
    }

    private static Pair<Integer, Integer> simulateRuler(List<Triple<Integer, PointIntervalType, Integer>> intervals) {
        int bestHour = 0;

        int count = 0;
        int maxCount = 0;

        int weight = 0;
        int maxWeight = 0;

        for (Triple<Integer, PointIntervalType, Integer> timeWithWeight : intervals) {
            if (timeWithWeight.getSecond() == PointIntervalType.BEGIN) {
                ++count;
                weight+=timeWithWeight.getThird();
            }
            if (timeWithWeight.getSecond() == PointIntervalType.END) {
                --count;
                weight-=timeWithWeight.getThird();
            }
            if (weight>maxWeight) {
                bestHour = timeWithWeight.getFirst();
                maxCount = count;
                maxWeight = weight;
            }
        }
        return new Pair<>(maxCount, bestHour);
    }

    private static void sortByTime(List<Triple<Integer, PointIntervalType, Integer>> intervals) {
        intervals.sort((Comparator.comparing(Triple::getFirst)));
    }


    private static List<Triple<Integer, PointIntervalType,Integer>> getIntervals(List<CelebritySchedule> schedules) {
        List<Triple<Integer, PointIntervalType, Integer>> result = new ArrayList<>();
        for (CelebritySchedule schedule : schedules) {
            result.add(new Triple<>(schedule.getHourFrom(), PointIntervalType.BEGIN, schedule.getWeight()));
            result.add(new Triple<>(schedule.getHourTo(), PointIntervalType.END, schedule.getWeight()));
        }
        return result;
    }



}
