package oca;

import java.util.ArrayList;
import java.util.List;

public class ListsTest {

	public static void main(String[] args) {
		
		List<Integer> intlist = new ArrayList<Integer>();
		
		intlist.add(10);
		intlist.add(20);
		intlist.add(30);
		intlist.add(40);
		
		intlist.remove(3);
		System.out.println(intlist); // [10, 20, 30]
		
		intlist.set(2, 50);
		System.out.println(intlist); // [10, 20, 50]
		
		intlist.add(3 , 80);
		System.out.println(intlist); // [10, 20, 50 ,80]

		
	}
}
