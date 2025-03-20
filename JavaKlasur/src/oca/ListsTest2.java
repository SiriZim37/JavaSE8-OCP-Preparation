package oca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListsTest2 {

	public static void main(String[] args) {
		
		List<Integer> intlist = new ArrayList<Integer>();
		
		intlist.add(10);
		intlist.add(20);
		intlist.add(30);
		intlist.add(40);

		ArrayList<Integer> intlist2 = new ArrayList<Integer>();
		intlist = intlist2;
		
		intlist2.add(50);
		
		System.out.println(intlist);    //  [50]
		

		List<Integer> intlist3 = new ArrayList<>(intlist2); 
		
		intlist2.add(60);
		
		System.out.println(intlist);     //  [50 , 60]
		System.out.println(intlist3);    //  [50]
	}
}
