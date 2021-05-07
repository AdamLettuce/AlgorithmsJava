package Java8.optionals;

import java.util.Optional;

public class Test {
    public static void main(String[] args) {
        Optional<Optional<String>> insranceType = Optional.of(new Person())
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .flatMap(Insurance::getType)
                .map(Type::getName);


//        Person person = new Person(new Car(new Insurance("Test")),19);
//        Person person = null;
        Person person = new Person();
        System.out.println(new Test().getCarInsuranceName(Optional.ofNullable(person),18));
    }

    public String getCarInsuranceName(Optional<Person> person) {
        return person.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }


    public String getCarInsuranceName(Optional<Person> person, int minAge) {
//        so that the insurance company name is returned only if the person has an age greater than or equal to the minAge argument.
        return person.filter(
                p -> Optional.ofNullable(p.getAge()).orElse(Integer.MIN_VALUE) > minAge
        )
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }
}

class Person {
    private Car car;

    private Integer age;

    public Optional<Car> getCar() {
        return Optional.ofNullable(car);
    }

    public Integer getAge() {
        return age;
    }

    public Person(Car car, Integer age) {
        this.car = car;
        this.age = age;
    }

    public Person() {
    }
}

class Car {
    private Insurance insurance;

    public Optional<Insurance> getInsurance() {
        return Optional.ofNullable(insurance);
    }

    public Car(Insurance insurance) {
        this.insurance = insurance;
    }
}

class Insurance {
    private Type type;

    private String name;

    public Optional<Type> getType() {
        return Optional.ofNullable(type);
    }

    public String getName() {
        return name;
    }

    public Insurance(String name) {
        this.name = name;
    }
}

class Type {
    private String name;

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }
}
