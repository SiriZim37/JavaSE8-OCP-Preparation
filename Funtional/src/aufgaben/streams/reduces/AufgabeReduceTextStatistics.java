package aufgaben.streams.reduces;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;


public class AufgabeReduceTextStatistics {

	public static void main(String[] args) {
		a1();
		a2();
	}
	
	static void a2() {
		System.out.println("*** A2");
		
		String[] input = { 
				"String 1",			// chars: 8, letters: 6, spec.: 2, longest: String  
				"Heute ist Montag", // chars: 16, letters: 14, spec.: 2, longest: Montag
				"Java ist toll!",   // chars: 14, letters: 11, spec.: 3, longest: toll!
				//...
			};
		
		// gesamt:
		// chars: 38, letters: 31, spec.: 7, longest: String
		
		TextStatistics idt = new TextStatisticsImpl("");
		
		BiFunction<TextStatistics, String, TextStatistics> acc = 
				(statPrev, nextStr) -> {
					TextStatistics statNew = new TextStatisticsImpl(nextStr);
					return new CombinedTextStatistics(statPrev, statNew);
				};
		
		BinaryOperator<TextStatistics> cmb = CombinedTextStatistics::new;
		
		TextStatistics stats = Arrays.stream(input).reduce(idt, acc, cmb);
		
		System.out.println("getCountChars: " + stats.getCountChars());
		System.out.println("getCountLetters: " + stats.getCountLetters());
		System.out.println("getCountSpecialChars: " + stats.getCountSpecialChars());
		System.out.println("getLongestWord, get: " + stats.getLongestWord().get());
	}
		
	static void a1() {
		System.out.println("*** A1");
		
		String text = "a dddd b1 c$c";
		
		TextStatistics stats = new TextStatisticsImpl(text);
		
		System.out.println("* test getCountChars");
		int result = stats.getCountChars();
		int soll = 13;
		
		if(result == soll) {
			System.out.println("OK");
		} else {
			System.out.println("Fehler! soll = " + soll + ", result = " + result);
		}
		
		System.out.println("* test getCountSpecialChars");
		result = stats.getCountSpecialChars();
		soll = 5;
		
		if(result == soll) {
			System.out.println("OK");
		} else {
			System.out.println("Fehler! soll = " + soll + ", result = " + result);
		}
		
		System.out.println("* test getCountLetters");
		result = stats.getCountLetters();
		soll = 8;
		
		if(result == soll) {
			System.out.println("OK");
		} else {
			System.out.println("Fehler! soll = " + soll + ", result = " + result);
		}
	
		System.out.println("* test ");
		String longest = stats.getLongestWord().get();
		String longestSoll = "dddd";
		
		if(longest.equals(longestSoll)) {
			System.out.println("OK");
		} else {
			System.out.println("Fehler! soll = " + longestSoll + ", result = " + longest);
		}
	}

}
