package aufgaben.lambdas.v2.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AufgabeLambdasA2 {

	public static void main(String[] args) {
		
		String[] arr = { "aaaa", "cc", "aaaa", "m", "bb" , "aaa" };
		System.out.println("arr: " + Arrays.toString(arr));
		
		System.out.println("natürlich aufsteigend sortiert:");
		Arrays.sort(arr);
		System.out.println("arr: " + Arrays.toString(arr));
		
		System.out.println("nach Länge sortiert:");
		Comparator<String> cmp = (s1, s2) -> s1.length() - s2.length();
		Arrays.sort(arr, cmp);
		System.out.println("arr: " + Arrays.toString(arr));
		
		System.out.println();
		List<String> list = new ArrayList<>();
		for(String s : arr) {
			list.add(s);
		}
		
		//Liste zuerst mischen:
		Collections.shuffle(list);
		System.out.println("list: " + list);
		
		System.out.println("natürlich aufsteigend sortiert:");
		Collections.sort(list);
		System.out.println("list: " + list);
		
		System.out.println("nach Länge sortiert:");
		Collections.sort(list, cmp);
		System.out.println("list: " + list);
		
	}

}
