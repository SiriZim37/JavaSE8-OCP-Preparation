package oca;

import java.util.ArrayList;
import java.util.List;

public class ArrayListAPITest {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(new Integer("6"));
		list.add(7);
		list.add(6);
		list.add(10);
		list.add(5);
		
		System.out.println(list);
		list.remove(5);
		System.out.println(list);
		
		System.out.println();
		list.remove("6");   // Not delete because no Object 6 
		System.out.println(list);
		list.remove(new Integer("6"));  // Autounboxing and deleted 6 at first meet
		System.out.println(list);	
		
		
		System.out.println();
		List<String> list2 = new ArrayList<>();
		list2.add("5");
		list2.add("6");
		list2.add("7");
		list2.add("6");
		list2.add("10");
		list2.add("5");
		
		System.out.println(list2);
		list2.remove("5");
		System.out.println(list2);
	}
}
