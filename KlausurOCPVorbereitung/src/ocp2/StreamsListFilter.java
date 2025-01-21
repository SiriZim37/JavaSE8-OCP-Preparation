package ocp2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StreamsListFilter {

	public static void main(String[] args) {
		List<String> str = Arrays.asList ("my", "pen", "is", "your", "pen");
		Predicate<String> test = s -> {
		   int i = 0;
	
		   boolean result = s.contains ("pen");
		   System.out.print( i++ + ":");
		   return result;
		};

	
	 str.stream()
	        .filter(test)
	        .findFirst()
	 		.ifPresent(System.out ::print);
	}
	
	/*
	  What is the result?
	 A. 0 : 0 : pen
	 B. 0 : 1 : pen
	 C. 0 : 0 : 0 : 0 : 0 : pen
	 D. 0 : 1 : 2 : 3 : 4 :
	 E. A compilation error occurs
	 */
	
	/*
	 	ทำไมถึงได้ 0:0:pen:
		ใน test, i ถูกประกาศและรีเซ็ตเป็น 0 ในทุกๆ ครั้งที่ Predicate ถูกเรียกใช้. ดังนั้นจะพิมพ์ 0: ทุกครั้งที่ Predicate ถูกใช้.
		ตัวแปร i จะถูกรีเซ็ตเป็น 0 ในทุกๆ การเรียกใน filter, ดังนั้นจะพิมพ์ 0: ซ้ำ 2 ครั้ง.
		หลังจากที่พบตัวแรกที่ตรงกับเงื่อนไขใน filter (คำว่า "pen"), ค่าตัวแรกที่ตรงเงื่อนไขคือ "pen" ซึ่งจะถูกพิมพ์ออกมา.
	 */
}
