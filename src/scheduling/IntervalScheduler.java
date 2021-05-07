package scheduling;

import util.IntegerInterval;
import util.Pair;

import java.util.*;

/**
 * Created by adam on 02/05/2018.
 */
public class IntervalScheduler {

    public static void main(String[] args) {
        Pair<Integer, IntegerInterval> result = findSolution();
        System.out.printf("Maximum selfies with %d celebrity(ies) between %s%n",result.getFirst(), result.getSecond());
    }

    private static Pair<Integer, IntegerInterval> findSolution() {
        List<CelebritySchedule> schedules = CelebritySchedule.retrieve();
        return findMax(buildHoursToCelebrityCount(schedules,getIntervals(getIntervalPoints(schedules))));
    }

    private static Pair<Integer,IntegerInterval>  findMax(Map<IntegerInterval,Integer> hourToCelebrityCount) {
        IntegerInterval bestHours = null;
        int celebritiesAtBestHour = 0;
        for (Map.Entry<IntegerInterval,Integer> entry: hourToCelebrityCount.entrySet()) {
            if(entry.getValue()>celebritiesAtBestHour) {
                celebritiesAtBestHour = entry.getValue();
                bestHours = entry.getKey();
            }
        }
        return new Pair<>(celebritiesAtBestHour,bestHours);
    }


    private static Map<IntegerInterval,Integer> buildHoursToCelebrityCount(List<CelebritySchedule> celebritySchedules, List<IntegerInterval> intervals) {
        Map<IntegerInterval,Integer> intervalCelebritiesCount = new HashMap<>();
        for(int i=0;i<intervals.size();++i) {
            intervalCelebritiesCount.put(intervals.get(i),0);
        }

        for(IntegerInterval interval: intervals) {
            for (int i = 0; i < celebritySchedules.size(); i++) {
                if(interval.intersects(new IntegerInterval(celebritySchedules.get(i).getHourFrom(), celebritySchedules.get(i).getHourTo()))) {
                    intervalCelebritiesCount.put(interval,intervalCelebritiesCount.get(interval)+1);
                }
            }
        }
        return intervalCelebritiesCount;
    }

    private static List<IntegerInterval> getIntervals(List<Integer> intervalPoints) {
        List<IntegerInterval> result = new ArrayList<>();
        for (int i = 1; i < intervalPoints.size(); i++) {
            result.add(new IntegerInterval(intervalPoints.get(i-1),intervalPoints.get(i)));
        }
        return result;
    }

    private static List<Integer> getIntervalPoints(List<CelebritySchedule> schedules) {
        Set<Integer> intervalPoints = new TreeSet<>();
        for (CelebritySchedule schedule: schedules) {
            intervalPoints.add(schedule.getHourFrom());
            intervalPoints.add(schedule.getHourTo());
        }
        return new ArrayList<>(intervalPoints);
    }
}
