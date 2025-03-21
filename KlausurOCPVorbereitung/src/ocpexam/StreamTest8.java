package ocpexam;


import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Given the definition of the Emp class:
public class Emp {

	private String eName;
	private Integer eAge;

	Emp(String eN, Integer eA) {
		this.eName = eN;
		this.eAge = eA;
	}

	public Integer getEAge() {
		return eAge;
	}

	public String getEName() {
		return eName;
	}

	public static void main(String[] args) {
		List<Emp> li = Arrays.asList(new Question054("Sam", 20), new Question054("John", 60),new Question054("Jim", 51));
		Predicate<Emp> agVal = s -> s.getEAge() > 50;// line n1
		li = li.stream().filter(agVal).collect(Collectors.toList());
		Stream<String> names = li.stream().map(Emp::getEName);// line n2 
		names.forEach(n -> System.out.print(n + " "));
	}
}


What is the result?

A. Sam John Jim
B. John Jim
C. A compilation error occurs at line n1. D. 
A compilation error occurs at line n2.

Answer: B. John Jim 
 */


public class StreamTest8 {
	private String eName;
	private Integer eAge;

	StreamTest8(String eN, Integer eA) {
		this.eName = eN;
		this.eAge = eA;
	}

	public Integer getEAge() {
		return eAge;
	}

	public String getEName() {
		return eName;
	}

	public static void main(String[] args) {
		List<StreamTest8> li = Arrays.asList(new StreamTest8("Sam", 20), new StreamTest8("John", 60),new StreamTest8("Jim", 51));
		Predicate<StreamTest8> agVal = s -> s.getEAge() > 50;// line n1
		li = li.stream().filter(agVal).collect(Collectors.toList());
		Stream<String> names = li.stream().map(StreamTest8::getEName);// line n2 
		names.forEach(n -> System.out.print(n + " "));
	}
}