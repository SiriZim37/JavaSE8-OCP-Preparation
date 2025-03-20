package ocpexam;

import java.util.Arrays;
import java.util.List;

class Person {
    String name;
    int year;

    public Person(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return name + " " + year;
    }
}


public class StreamCompareAndtThen {

	public static void main(String[] args) {
		
		List<Person> people = Arrays.asList(
			    new Person("John", 2022),
			    new Person("Anna", 2021),
			    new Person("Tom", 2022),
			    new Person("Anna", 2020),
			    new Person("John", 2021)
			);
		
	}
	
	
	/*
	 * 
Which of the following code snippets will correctly sort the list of Person objects
 first by name, and then by year?



	 Options:

A)

List<Person> sorted = people.stream()
                            .sorted(Comparator.comparing(Person::getName)
                                              .thenComparing(Person::getYear))
                            .collect(Collectors.toList());
							sorted.forEach(System.out::println);

B)
List<Person> sorted = people.stream()
                            .sorted(Comparator.comparing(Person::getYear)
                                              .thenComparing(Person::getName))
                            .collect(Collectors.toList());
							sorted.forEach(System.out::println);


C)

List<Person> sorted = people.stream()
                            .sorted(Comparator.comparing(Person::getName)
                                              .thenComparing(Person::getYear)
                                              .reversed())
                            .collect(Collectors.toList());
							sorted.forEach(System.out::println);


D)
List<Person> sorted = people.stream()
                            .sorted(Comparator.comparing(Person::getYear)
                                              .thenComparing(Person::getName)
                                              .reversed())
                            .collect(Collectors.toList());
							sorted.forEach(System.out::println);
	 */
	
	
	
}
