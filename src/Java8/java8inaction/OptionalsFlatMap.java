package Java8.java8inaction;

import java.util.Optional;

public class OptionalsFlatMap {
    public static void main(String[] args) {
        Person p = new Person(new Car("bmw","5", new Insurance("1234567890")));
        String insuranceNumber = Optional.ofNullable(p)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getNumber)
                .orElse("Missing");
        System.out.println(insuranceNumber);

    }
}

class Person {
    private Car car;

    public Person(Car car) {
        this.car = car;
    }

    public Optional<Car> getCar() {
        return Optional.ofNullable(car);
    }
}

class Car {
    private String make;
    private String model;

    private Insurance insurance;

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public Car(String make, String model, Insurance insurance) {
        this.make = make;
        this.model = model;
        this.insurance = insurance;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Optional<Insurance> getInsurance() {
        return Optional.ofNullable(insurance);
    }
}

class Insurance {
    private String number;

    public Insurance(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
