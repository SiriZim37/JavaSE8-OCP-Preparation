package wdh.methoden;

import java.util.ArrayList;
import java.util.List;

public class RichtigeUeberladenenMethodeFinden {

	public static void main(String[] args) {
//		kleineFrage1();  // wirft Exception

		kleineFrage2();

	}
	
	static void kleineFrage1() {
		List<Integer> list = new ArrayList<>();
		
		list.add(12);
		list.add(13);
		list.add(14);
		
		list.remove(12);	      // IndexOutOfBoundsException : remove(int index)
		System.out.println(list.size());

		
	}
	
	static void kleineFrage2() {
		List<String> list = new ArrayList<>();
		
		list.add("mo");
		list.add("di");
		list.add("mi");
		
		list.remove("mo");	    //  remove(Object elemet)  
		System.out.println(list.size());	// size = 2 
		
	}

}
