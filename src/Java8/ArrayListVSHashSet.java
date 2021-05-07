package Java8;


import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.function.Function;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class ArrayListVSHashSet {

    private static final Random r1 = new Random();
    private static final Random r2 = new Random();
    private static final Numbers[] numbers = Numbers.values();
    private static final int BOUND = 51;

    public static void main(String[] args) {
        while (true) {
            testForAllValuesFindByCode(Numbers::byCodeUsingList);
            testForAllValuesFindByCode(Numbers::byCodeUsingMap);
            testForAllValuesContains(Numbers::containsUsingList);
            testForAllValuesContains(Numbers::containsUsingSet);
        }
    }

    private static void testForAllValuesFindByCode(Function<String, Optional<Numbers>> test) {
        test.apply("" + r1.nextInt(BOUND));
    }

    private static void testForAllValuesContains(Function<Numbers, Boolean> test) {
        test.apply(numbers[r2.nextInt(BOUND)]);
    }


}

enum Numbers {
    Zero("0"),
    One("1"),
    Two("2"),
    Three("3"),
    Four("4"),
    Five("5"),
    Six("6"),
    Seven("7"),
    Eight("8"),
    Nine("9"),
    Ten("10"),
    Eleven("11"),
    Twelve("12"),
    Thirteen("13"),
    Fourteen("14"),
    Fiveteen("15"),
    Sixteen("16"),
    Seventeen("17"),
    Eighteen("18"),
    Nignteen("19"),
    Twenty("20"),
    TwentyOne("21"),
    TwentyTwo("22"),
    TwentyThree("23"),
    TwentyFour("24"),
    TwentyFive("25"),
    TwentySix("26"),
    TwentySeven("27"),
    TwentyEight("28"),
    TwentyNine("29"),
    Thirty("30"),
    ThirtyOne("31"),
    ThirtyTwo("32"),
    ThirtyThree("33"),
    ThirtyFour("34"),
    ThirtyFive("35"),
    ThirtySix("36"),
    ThirtySeven("37"),
    ThirtyEight("38"),
    ThirtyNine("39"),
    Fourty("40"),
    FourtyOne("41"),
    FourtyTwo("42"),
    FourtyThree("43"),
    FourtyFour("44"),
    FourtyFive("45"),
    FourtySix("46"),
    FourtySeven("47"),
    FourtyEight("48"),
    FourtyNine("49"),
    Fivety("50");

    private String value;

    Numbers(String value) {
        this.value = value;
    }

    private static final List<Numbers> numbersList;

    static {
        numbersList = Arrays.stream(values()).collect(toList());
    }

    static Optional<Numbers> byCodeUsingList(String code) {
        return numbersList.stream().filter(c -> c.value.equals(code)).findAny();
    }

    static boolean containsUsingList(Numbers number) {
        return numbersList.contains(number);
    }

    private static final Map<String, Numbers> codeToNumber;

    static {
        codeToNumber = Arrays.stream(values()).collect(toMap((Numbers k) -> k.value, identity()));
    }

    static Optional<Numbers> byCodeUsingMap(String code) {
        return Optional.of(codeToNumber.get(code));
    }

    private static final EnumSet<Numbers> numbersEnumSet = EnumSet.allOf(Numbers.class);

    static boolean containsUsingSet(Numbers number) {
        return numbersEnumSet.contains(number);
    }

}