package Java8.java8inaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adam on 19/09/2018.
 */
public class PrettyApplePrinter {

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(150,Color.GREEN));
        apples.add(new Apple(50,Color.RED));

        prettyPrintApple(apples,new ColorAppleConsumer());
        prettyPrintApple(apples,new WeightAppleConsumer());
    }

    public static void prettyPrintApple(List<Apple> apples, AppleConsumer appleConsumer) {
        for (Apple apple: apples) {
            appleConsumer.consume(apple);
        }
    }
}

class Apple {
    int weight;
    Color color;

    public Apple(int weight, Color color) {
        this.weight = weight;
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public Color getColor() {
        return color;
    }
}

enum Color {
    RED, GREEN;
}

interface AppleConsumer {
    void consume(Apple a);
}

class ColorAppleConsumer implements AppleConsumer {
    @Override
    public void consume(Apple a) {
        System.out.println(a.getColor());
    }
}

class WeightAppleConsumer implements AppleConsumer {
    @Override
    public void consume(Apple a) {
        System.out.println("Weight = " + a.getWeight());
    }
}
