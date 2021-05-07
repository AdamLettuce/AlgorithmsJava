package decisiontable;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static decisiontable.Condition.newCondition;
import static java.time.Duration.ofMinutes;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

public class Table {
    public static void main(String[] args) {
        int pushups = 21;
        int situps = 21;
        Duration runningTime = ofMinutes(10).plusSeconds(25);
        Duration cyclingTime = ofMinutes(30).plusSeconds(42);

        System.out.println(decideUsingConditions(pushups, situps, runningTime, cyclingTime));
        System.out.println(decideUsingTable(pushups, situps, runningTime, cyclingTime));
    }

    private static String decideUsingConditions(int pushups, int situps, Duration runningTime, Duration cyclingTime) {
        if (pushups == 1 && situps == 1 && ofMinutes(2).compareTo(runningTime) > 0) {
            return "Very very bad";
        }
        if (pushups == 2 && situps == 1 && ofMinutes(2).compareTo(runningTime) > 0) {
            return "Very bad";
        }
        if (pushups == 2 && situps == 2 && ofMinutes(2).compareTo(runningTime) > 0) {
            return "Bad";
        }
        if (2 < pushups && pushups <= 5 && situps > 2 && situps <= 5 && ofMinutes(3).compareTo(runningTime) > 0) {
            return "Better";
        }
        if (5 < pushups && pushups <= 10 && situps > 5 && situps <= 10 && ofMinutes(4).compareTo(runningTime) > 0) {
            return "Good";
        }
        if (10 < pushups && pushups <= 20 && situps > 10 && situps <= 20 && ofMinutes(5).compareTo(runningTime) > 0) {
            return "Great";
        }
        if (20 < pushups && 20 < situps && ofMinutes(10).compareTo(runningTime) < 0 && ofMinutes(30).compareTo(cyclingTime) < 0) {
            return "Excellent";
        }
        return "None match";
    }

    private static String decideUsingTable(int pushups, int situps, Duration runningTime, Duration cyclingTime) {
        return decisionTable(pushups, situps, runningTime, cyclingTime)
                .stream()
                .filter(e -> e.getCodition().stream().allMatch(Supplier::get))
                .findAny()
                .orElse(newCondition(singletonList(() -> true), "None match"))
                .getResult();

    }

    private static List<Condition> decisionTable(int pushups, int situps, Duration runningTime, Duration cyclingTime) {
        List<Condition> result = new ArrayList<>();
        result.add(newCondition(asList(() -> pushups == 1, () -> situps == 1, () -> ofMinutes(2).compareTo(runningTime) > 0), "Very very bad"));
        result.add(newCondition(asList(() -> pushups == 2, () -> situps == 1, () -> ofMinutes(2).compareTo(runningTime) > 0), "Very bad"));
        result.add(newCondition(asList(() -> pushups == 2, () -> situps == 2, () -> ofMinutes(2).compareTo(runningTime) > 0), "Bad"));
        result.add(newCondition(asList(() -> 2 < pushups && pushups <= 5, () -> situps > 2 && situps <= 5, () -> ofMinutes(3).compareTo(runningTime) > 0), "Better"));
        result.add(newCondition(asList(() -> 5 < pushups && pushups <= 10, () -> situps > 5 && situps <= 10, () -> ofMinutes(4).compareTo(runningTime) > 0), "Good"));
        result.add(newCondition(asList(() -> 10 < pushups && pushups <= 20, () -> situps > 10 && situps <= 20, () -> ofMinutes(5).compareTo(runningTime) > 0), "Great)"));
        result.add(newCondition(asList(() -> 20 < pushups, () -> 20 < situps, () -> ofMinutes(10).compareTo(runningTime) < 0, () -> ofMinutes(30).compareTo(cyclingTime) < 0), "Excellent"));
        return result;
    }

}

class Condition {
    private String result;
    private List<Supplier<Boolean>> codition;

    static Condition newCondition(List<Supplier<Boolean>> conditions, String result) {
        Condition option = new Condition();
        option.codition = conditions;
        option.result = result;
        return option;
    }

    List<Supplier<Boolean>> getCodition() {
        return codition;
    }

    public String getResult() {
        return result;
    }
}