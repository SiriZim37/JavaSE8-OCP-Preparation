package klausur;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Person implements Comparable<Person> {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // compareTo method for natural ordering (by age)
    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return name + " (" + age + " years old)";
    }
}

// Comparator to compare Person objects by name
class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.name.compareTo(p2.name);  // Comparing by name
    }
}

public class ComparableComparator {

	public static void main(String[] args) {
		 // Creating some Person objects
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 35));

        // Sorting by age using Comparable (natural order)
        System.out.println("Sorted by age:");
        Collections.sort(people);
        for (Person person : people) {
            System.out.println(person);
        }

        // Sorting by name using Comparator
        System.out.println("\nSorted by name:");
        Collections.sort(people, new NameComparator());
        for (Person person : people) {
            System.out.println(person);
        }
	}
}
