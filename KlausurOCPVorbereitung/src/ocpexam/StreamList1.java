package ocpexam;

import java.util.Arrays;
import java.util.List;

class Student{
	
	String name;
	int age;
	public Student(String name , int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return name +"="+ age;
	}
}

public class StreamList1 {

	public static void main(String[] args) {
		
		List<Student> list = Arrays.asList(new Student("A", 25) ,
							new Student("B", 30) , 
							new Student("C", 40));
		
		
		list.stream().filter(p -> p.age > 25).forEach(s -> System.out.println(s));
	}
	
}
