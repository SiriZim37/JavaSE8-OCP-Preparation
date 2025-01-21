package wdh.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveIfinIfElse {

	public static void main(String[] args) {
		List<Integer> intlist = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6));
		if(intlist.removeIf(s -> {System.out.println(s); return s>5;})) {
			System.out.println("test");
		}
	}
}
