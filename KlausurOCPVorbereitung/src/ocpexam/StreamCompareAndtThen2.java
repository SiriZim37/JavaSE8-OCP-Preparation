package ocpexam;

import java.util.Arrays;
import java.util.List;

class Person2 {
    String name;
    int year;

    public Person2(String name, int year) {
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


public class StreamCompareAndtThen2 {

	public static void main(String[] args) {
		
		List<Person2> people = Arrays.asList(
			    new Person2("John", 2022),
			    new Person2("Anna", 2021),
			    new Person2("Tom", 2022),
			    new Person2("Anna", 2020),
			    new Person2("John", 2021)
			);
		
	}
	
	
	/*
	 * 
Which of the following code snippets will correctly sort the list of Person objects first by name in descending order, and then by year in ascending order?

Options:

A)

Edit
List<Person> sorted = people.stream()
                            .sorted(Comparator.comparing(Person::getName, Comparator.reverseOrder())
                                              .thenComparing(Person::getYear))
                            .collect(Collectors.toList());
							sorted.forEach(System.out::println);

B)

List<Person> sorted = people.stream()
                            .sorted(Comparator.comparing(Person::getYear)
                                              .thenComparing(Person::getName, Comparator.reverseOrder()))
                            .collect(Collectors.toList());
							sorted.forEach(System.out::println);

C)

List<Person> sorted = people.stream()
                            .sorted(Comparator.comparing(Person::getName, Comparator.reverseOrder())
                                              .thenComparing(Person::getYear)
                                              .reversed())
                            .collect(Collectors.toList());
							sorted.forEach(System.out::println);

D)

List<Person> sorted = people.stream()
                            .sorted(Comparator.comparing(Person::getYear)
                                              .thenComparing(Person::getName, Comparator.reverseOrder())
                                              .reversed())
                            .collect(Collectors.toList());
							sorted.forEach(System.out::println);




Answer Explanation:
The correct answer is A.

Explanation:

Option A is the correct answer because it sorts first by name in descending order (using Comparator.reverseOrder()) and then by year in ascending order (which is the default behavior for integers). This matches the requirement of the question.
Option B sorts by year first (which is not what we want), then by name in descending order.
Option C incorrectly uses .reversed() on the entire sorted result, which would reverse the order of all elements, which is not what we want.
Option D also incorrectly uses .reversed() on the entire sorted result and sorts by year first.
*/
	
	
	
}
