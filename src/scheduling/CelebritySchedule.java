package scheduling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by adam on 02/05/2018.
 */
class CelebritySchedule {
    private String name;
    private int hourFrom;
    private int hourTo;
    private int weight;

    public CelebritySchedule(String name, int hourFrom, int hourTo) {
        this.name = name;
        this.hourFrom = hourFrom;
        this.hourTo = hourTo;
    }

    public CelebritySchedule(String name, int hourFrom, int hourTo, int weight) {
        this.name = name;
        this.hourFrom = hourFrom;
        this.hourTo = hourTo;
        this.weight = weight;
    }

    public static List<CelebritySchedule> retrieve() {
        List<CelebritySchedule> celebritySchedules = new ArrayList<>();
        /*
        //3 celebrities at 10
        celebritySchedules.add(new CelebritySchedule("Beyoncee",6,7));
        celebritySchedules.add(new CelebritySchedule("Taylor",7,9));
        celebritySchedules.add(new CelebritySchedule("Brad",10,11));
        celebritySchedules.add(new CelebritySchedule("Katy",10,12));
        celebritySchedules.add(new CelebritySchedule("Tom",8,10));
        celebritySchedules.add(new CelebritySchedule("Drake",9,11));
        celebritySchedules.add(new CelebritySchedule("Alicia",6,8));
        */
        //5 celebrities at 9
        celebritySchedules.add(new CelebritySchedule("A",6,8));
        celebritySchedules.add(new CelebritySchedule("B",6,12));
        celebritySchedules.add(new CelebritySchedule("C",6,7));
        celebritySchedules.add(new CelebritySchedule("D",7,8));
        celebritySchedules.add(new CelebritySchedule("E",7,10));
        celebritySchedules.add(new CelebritySchedule("F",8,9));
        celebritySchedules.add(new CelebritySchedule("G",8,10));
        celebritySchedules.add(new CelebritySchedule("H",9,12));
        celebritySchedules.add(new CelebritySchedule("I",9,10));
        celebritySchedules.add(new CelebritySchedule("J",10,11));
        celebritySchedules.add(new CelebritySchedule("K",10,12));
        celebritySchedules.add(new CelebritySchedule("L",11,12));
        return Collections.unmodifiableList(celebritySchedules);
    }

    public static List<CelebritySchedule> retrieveWeights() {
        List<CelebritySchedule> celebritySchedules = new ArrayList<>();
        //5 celebrities at 9
        celebritySchedules.add(new CelebritySchedule("A",6,8,2));
        celebritySchedules.add(new CelebritySchedule("B",6,12,1));
        celebritySchedules.add(new CelebritySchedule("C",6,7,2));
        celebritySchedules.add(new CelebritySchedule("D",7,8,2));
        celebritySchedules.add(new CelebritySchedule("E",7,10,3));
        celebritySchedules.add(new CelebritySchedule("F",8,9,2));
        celebritySchedules.add(new CelebritySchedule("G",8,10,1));
        celebritySchedules.add(new CelebritySchedule("H",9,12,2));
        celebritySchedules.add(new CelebritySchedule("I",9,10,4));
        celebritySchedules.add(new CelebritySchedule("J",10,11,2));
        celebritySchedules.add(new CelebritySchedule("K",10,12,3));
        celebritySchedules.add(new CelebritySchedule("L",11,12,7));
        return Collections.unmodifiableList(celebritySchedules);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CelebritySchedule schedule = (CelebritySchedule) o;

        if (getHourFrom() != schedule.getHourFrom()) return false;
        if (getHourTo() != schedule.getHourTo()) return false;
        return getName() != null ? getName().equals(schedule.getName()) : schedule.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + getHourFrom();
        result = 31 * result + getHourTo();
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHourFrom() {
        return hourFrom;
    }

    public void setHourFrom(int hourFrom) {
        this.hourFrom = hourFrom;
    }

    public int getHourTo() {
        return hourTo;
    }

    public void setHourTo(int hourTo) {
        this.hourTo = hourTo;
    }

    public int getWeight() {
        return weight;
    }
}