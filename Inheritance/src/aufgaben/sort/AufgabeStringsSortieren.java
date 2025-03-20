package aufgaben.sort;

import java.util.Arrays;
import java.util.Comparator;

class MyStringReverseCmp implements Comparator<String> {
	@Override
	public int compare(String s1, String s2) {
		int result = s1.length() - s2.length();
		
		if(result==0) {
			result = s1.compareTo(s2);
		}
		
		return result;
	}
}

public class AufgabeStringsSortieren {
	public static void main(String[] args) {
		String[] arr = {
			"def", "ffff", "zz", "abc", "ABCDE", "hhhh", "xyz"	
		};
		
		System.out.println("*** nicht sortiert: ");
		System.out.println(Arrays.toString(arr));
		
//		System.out.println("\n aufsteigend natürlich sortiert:");
//		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));
		
		System.out.println("\n aufsteigend nach Länge sortiert.");
		System.out.println(" Bei gleicher Länge lexikografisch:");
		
//		Comparator<String> cmp = new MyStringReverseCmp(); // auch ok
		
		Comparator<String> cmp = (s1, s2) -> {
			int result = s1.length() - s2.length();
			if(result==0) {
				result = s1.compareTo(s2);
			}
			return result;
		};
		Arrays.sort(arr, cmp);
		System.out.println(Arrays.toString(arr));
		
	}
}
