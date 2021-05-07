package Java8;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.*;

class HigherOrderFunction {
	public static void main(String[] args) {
		System.out.println("Hello world!");
		System.out.println("We will sort animals by name now :)");
		
		List<String> animals = animalsNames();
		
		System.out.println("Animals sorted in an ascending order:");
		animals.sort(compareInDirection(1));
		System.out.println(animals);

		System.out.println("Animals sorted in a descending order:");
		animals.sort(compareInDirection(-1));
		System.out.println(animals);

		List<Animal> animalsObjects = animals.stream().map(Animal::new).collect(Collectors.toList());
		System.out.println("Animals objects");	
		System.out.println(animalsObjects);

		animalsObjects.add(new Animal(null));
		animalsObjects.sort(Comparator.comparing(Animal::getName, nullsLast(naturalOrder())));
		System.out.println("Animals objects sorted");	
		System.out.println(animalsObjects);
	}

	//returns a function
	public static Comparator<String> compareInDirection(int direction) {
		return (x,y) -> direction * x.compareTo(y);
	}

	//modifies a function, which is taken as an input parameter
	public static Comparator<String> reverse(Comparator<String> comp) {
		return comp;
	}

	public static List<String> animalsNames() {
		List<String> animals = new ArrayList<>();
		animals.add("Hektor");
		animals.add("Lula");
		animals.add("Egon");
		animals.add("Tysia");
		animals.add("Kempes");
		animals.add("Bazyl");
		return animals;
	}
}

class Animal {
	private String name;

	public Animal(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return this.name;
	}
}