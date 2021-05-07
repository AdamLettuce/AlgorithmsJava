package Java8.interfaces;

/**
 * Created by adam on 31/03/2018.
 */
public interface Identity {
    default int getId() {
        return 0;
    }
}
