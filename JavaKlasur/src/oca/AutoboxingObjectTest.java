package oca;

import java.util.ArrayList;
import java.util.List;

public class AutoboxingObjectTest {

	public static void main(String[] args) {
		 
		List<Integer> listOfIntegers = new ArrayList();
		listOfIntegers.add(1000);
		listOfIntegers.add(1000);
		listOfIntegers.add(127);
		listOfIntegers.add(127);
		
		System.out.println(listOfIntegers.get(0) == listOfIntegers.get(1));	// false
		System.out.println(listOfIntegers.get(2) == listOfIntegers.get(3)); // true

	}

}
