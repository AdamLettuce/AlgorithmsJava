package scheduling;

import util.IntegerInterval;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by adam on 04/05/2018.
 */
public class CelebrityWithOtherScheduler {
    public static void main(String[] args) {
        List<CelebritySchedule> schedules = CelebritySchedule.retrieve();
        Map.Entry<IntegerInterval, Integer> max = findMaximumInterval(buildIntervalCelebrityCount(schedules),1);
        System.out.printf("Maximum selfies with %d celebrity(ies) between %s%n",max.getValue(), max.getKey());
    }

    private static Map<IntegerInterval, Integer> buildIntervalCelebrityCount(List<CelebritySchedule> schedules) {
        Map<IntegerInterval, Integer> intervalToCount = new HashMap<>();

        for (CelebritySchedule schedule: schedules) {
            IntegerInterval interval = new IntegerInterval(schedule.getHourFrom(), schedule.getHourTo());
            intervalToCount.put(interval,1);
        }

        for (int i = 0; i < schedules.size(); i++) {
            for (int j = i+1; j < schedules.size(); j++) {
                CelebritySchedule previousSchedule = schedules.get(i);
                CelebritySchedule actualSchedule = schedules.get(j);
                IntegerInterval previousInterval = new IntegerInterval(previousSchedule.getHourFrom(), previousSchedule.getHourTo());
                IntegerInterval actualInterval = new IntegerInterval(actualSchedule.getHourFrom(), actualSchedule.getHourTo());
                if (previousInterval.intersects(actualInterval)) {
                    intervalToCount.put(previousInterval, intervalToCount.get(previousInterval) + 1);
                    intervalToCount.put(actualInterval, intervalToCount.get(actualInterval) + 1);
                }
            }
        }
        return intervalToCount;
    }

    private static Map.Entry<IntegerInterval, Integer> findMaximumInterval(Map<IntegerInterval, Integer> intervalToCount, int length) {
        Map.Entry<IntegerInterval,Integer> max = intervalToCount.entrySet().iterator().next();
        for (Map.Entry<IntegerInterval,Integer> entry: intervalToCount.entrySet()) {
           if(entry.getValue()>max.getValue() && entry.getKey().length()==length) {
               max = entry;
           }
        }
        return max;
    }

}

