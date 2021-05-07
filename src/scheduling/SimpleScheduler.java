package scheduling;

import util.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by adam on 01/05/2018.
 * This algorithm schedules meetings by iterating through all the time interval.
 */
public class SimpleScheduler {
    public static void main(String[] args) {
        Pair<Integer, Integer> result = findSolution();
        System.out.printf("Maximum selfies with %d celebrity(ies) at %d%n",result.getFirst(), result.getSecond());
    }

    private static Pair<Integer, Integer> findSolution() {
        List<CelebritySchedule> celebritySchedules = CelebritySchedule.retrieve();
        return findMax(buildHoursToCelebrityCount(celebritySchedules, getMinMaxHours(celebritySchedules)));
    }

    private static Pair<Integer,Integer>  findMax(Map<Integer,Integer> hourToCelebrityCount) {
        int bestHour = 0;
        int celebritiesAtBestHour = 0;
        for (Map.Entry<Integer,Integer> entry: hourToCelebrityCount.entrySet()) {
            if(entry.getValue()>celebritiesAtBestHour) {
                celebritiesAtBestHour = entry.getValue();
                bestHour = entry.getKey();
            }
        }
        return new Pair<>(celebritiesAtBestHour,bestHour);
    }

    private static Map<Integer,Integer> buildHoursToCelebrityCount(List<CelebritySchedule> celebritySchedules, Pair<Integer, Integer> minMaxHour) {
        Map<Integer,Integer> hourToCelebritiesCount = new HashMap<>();
        for(int i=minMaxHour.getFirst();i<=minMaxHour.getSecond();++i) {
            hourToCelebritiesCount.put(i,0);
        }

        for(int i=minMaxHour.getFirst();i<=minMaxHour.getSecond();++i) {
            for (CelebritySchedule celebritySchedule : celebritySchedules) {
                if (celebritySchedule.getHourFrom() <= i && i < celebritySchedule.getHourTo()) {
                    hourToCelebritiesCount.put(i, hourToCelebritiesCount.get(i) + 1);
                }
            }
        }
        return hourToCelebritiesCount;
    }

    private static Pair<Integer,Integer> getMinMaxHours(List<CelebritySchedule> celebritySchedules) {
        int minHour = celebritySchedules.get(0).getHourFrom();
        int maxHour = celebritySchedules.get(0).getHourTo();

        for (int i = 1; i < celebritySchedules.size(); i++) {
            if(celebritySchedules.get(i).getHourFrom()<minHour) {
                minHour = celebritySchedules.get(i).getHourFrom();
            }
            if(celebritySchedules.get(i).getHourTo()>maxHour) {
                maxHour = celebritySchedules.get(i).getHourTo();
            }
        }

        return new Pair<>(minHour,maxHour);
    }
}




