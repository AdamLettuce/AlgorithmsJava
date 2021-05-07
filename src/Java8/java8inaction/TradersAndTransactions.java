package Java8.java8inaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TradersAndTransactions {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        System.out.println("\n1. Find all transactions in the year 2011 and sort them by value (small to high).");
        transactions.stream()
                .filter(t->t.getYear()==2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("\n2. What are all the unique cities where the traders work?");
        transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .collect(Collectors.toSet())//my solution
//                .distinct()//book solution
                .forEach(System.out::println);

        System.out.println("\n3. Find all traders from Cambridge and sort them by name.");
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(t->"Cambridge".equals(t.getCity()))
                .sorted(Comparator.comparing(Trader::getName))
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("\n4. Return a string of all traders’ names sorted alphabetically.");
        String result = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));
        System.out.println(result);


        System.out.println("\n5. Are any traders based in Milan?");
        boolean traderBasedInMilanExists =transactions.stream()
                .map(t->t.getTrader().getCity())
                .anyMatch("Milan"::equals);
        System.out.println(traderBasedInMilanExists);

        System.out.println("\n6. Print the values of all transactions from the traders living in Cambridge.");
        transactions.stream()
                .filter(t->"Cambridge".equals(t.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        System.out.println("\n7. What’s the highest value of all the transactions?");
        Optional<Integer> max = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println(max);

        System.out.println("\n8. Find the transaction with the smallest value.");
        Optional<Transaction> min = transactions.stream()
                .min(Comparator.comparing(Transaction::getValue));
        System.out.println(min);
    }
}

class Trader {
    private final String name;
    private final String city;

    public Trader(String n, String c) {
        this.name = n;
        this.city = c;
    }

    public String getName() {
        return this.name;
    }

    public String getCity() {
        return this.city;
    }

    public String toString() {
        return "Trader:" + this.name + " in " + this.city;
    }
}

class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return this.trader;
    }

    public int getYear() {
        return this.year;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "Transaction: " +
                "trader=" + trader +
                ", year=" + year +
                ", value=" + value +
                '}';
    }
}