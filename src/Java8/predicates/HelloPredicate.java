package Java8.predicates;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by adam on 05/09/2018.
 */
public class HelloPredicate {
    public static void main(String[] args) {

        acceptThis(SimplePerson::isSmart, new SimplePerson(true,180));
        acceptThis(SimplePerson::isSmart, new SimplePerson(false,160));

        dontAcceptThis(SimplePerson::isSmart, new SimplePerson(true,180));
        dontAcceptThis(SimplePerson::isSmart, new SimplePerson(false,160));

        acceptThat(a->!a,true);
        acceptThat(a->a,true);

        Predicate<SimplePerson> isSmart = SimplePerson::isSmart;
//        Predicate<SimplePerson> isSmart2 = SimplePerson::isSmart2;

        acceptThis(isSmart.negate(), new SimplePerson(true,180));
        acceptThis(isSmart.negate(), new SimplePerson(false,160));

        Predicate<SimplePerson> smartHighPersons = isSmart.and(p->p.getHeight()>170);
        acceptThis(smartHighPersons, new SimplePerson(true,180));
        acceptThis(smartHighPersons, new SimplePerson(true,160));


        List<SimplePerson> personList = new ArrayList<>();
        personList.add(new SimplePerson(true,180));
        personList.add(new SimplePerson(true,182));
        personList.add(new SimplePerson(false,160));
        personList.add(new SimplePerson(false,165));
        personList
                .stream()
//                .filter(SimplePerson::isSmart)
                .filter(SimplePerson::isSmart2)
                .forEach(System.out::println);

    }

    static void acceptThis(Predicate<SimplePerson> a, SimplePerson p) {
        if(a.test(p)) {
            System.out.println("this is a smart person");
        } else {
            System.out.println("this is a stupid person");
        }
    }

    static void dontAcceptThis(Predicate<SimplePerson> a, SimplePerson p) {
        if(a.negate().test(p)) {
            System.out.println("this is not a smart person");
        } else {
            System.out.println("this is not a stupid person");
        }
    }

    static void acceptThat(Predicate<Boolean> a, Boolean v) {
        System.out.println(a.test(v));
    }

}

class SimplePerson {
    private Boolean isSmart;
    private Integer height;

    public SimplePerson(boolean isSmart, Integer height) {
        this.isSmart = isSmart;
        this.height = height;
    }

    public Boolean isSmart() {
        return isSmart;
    }

    public static Boolean isSmart2(SimplePerson p) {
        return p.isSmart();
    }

    public Boolean isStupid() {
        return !isSmart;
    }

    public Integer getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "SimplePerson{" +
                "isSmart=" + isSmart +
                ", height=" + height +
                '}';
    }
}
