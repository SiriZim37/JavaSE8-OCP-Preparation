package ocp2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

interface CourseFilter extends Predicate<String> {
    public default boolean test(String str) {
        return str.equals("Java");
    }
}



public class InterfacePredicateTest {

	public static void main(String[] args) {
		  List<String> strs = Arrays.asList("Java", "Java EE", "Java ME");  
	       Predicate<String> cf1 = s -> s.length() > 3;  

	       Predicate cf2 = new CourseFilter() {  // line n1
	            public boolean test(String s) { 
	                return s.contains("Java");
	            }
	        };

	        long c = strs.stream()
		            .filter(cf1)
		            .filter(cf2)  // line n2
	            .count();

	        System.out.println(c);
	}
	
	/*
	 * เนื่องจากทุกตัวอักษรใน strs ("Java", "Java EE", "Java ME") ผ่านทั้งฟิลเตอร์ cf1 และ cf2 จึงทำให้จำนวนของอิลิเมนต์ในสตรีมที่ผ่านฟิลเตอร์ทั้งสองนี้คือ 3.
	 * ดังนั้น เมื่อใช้คำสั่ง count() จำนวนของอิลิเมนต์ที่ตรงกับเงื่อนไขทั้งสองจะเท่ากับ 3:
	 */
}
