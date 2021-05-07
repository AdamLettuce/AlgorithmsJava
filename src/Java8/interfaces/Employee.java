package Java8.interfaces;

/**
 * Created by adam on 31/03/2018.
 */
public class Employee implements Person, Identity {

    private static int count = 0;
    private int id = 0;

    public Employee() {
        id = count;
        count++;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                '}';
    }

    @Override
    public Employee clone() {
        return null;
    }
}