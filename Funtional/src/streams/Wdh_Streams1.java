package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class Wdh_Streams1 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("a", "b", "c", "d", "e", "f");
		
		/*
		 * Lösung 1.
		 * 
		 * Sie ist korrekt, aber sehr (!) ungünstig: 
		 * Konkatenation ist aufwendig und erzeugt jedes mal ein 
		 * neues String-Objekt. 
		 */
		BinaryOperator<String> acc1 = (s1, s2) -> s1 + s2;
		String res1 = list.stream()
				.parallel()
				.reduce("", acc1);
		
		System.out.println("res1: " + res1);

		/*
		 * Lösung 2.
		 * 
		 * StringBuilder soll viele String-Objekte vermeiden.
		 * 
		 * Diese Lösung ist GANZ FALSCH!
		 * 
		 * Die Pipeline ändert den Kontext!
		 */
		StringBuilder idt = new StringBuilder();
		
		BiFunction<StringBuilder, String, StringBuilder> acc2 = 
				(stringBuilder, nextString) -> {
					
			stringBuilder.append(nextString);
			return stringBuilder;
		};
		
		BinaryOperator<StringBuilder> cmb2 = (sbA, sbB) -> {
			return sbA;
		};
		
		StringBuilder res2 = list.stream()
		//	.parallel()
			.reduce(idt, acc2, cmb2);
		
		System.out.println("res2: " + res2.toString());		
		
		
		/*
		 * Lösung 3.
		 * 
		 * StringBuilder soll viele String-Objekte vermeiden (geht mit reduce wohl kaum).
		 * 
		 * Diese Lösung ist korrekt aber wieder sehr ungünstig
		 */
		StringBuilder idt3 = new StringBuilder();
		BiFunction<StringBuilder, String, StringBuilder> acc3 = (sbPrev, sNext) -> {
			StringBuilder sbNew = new StringBuilder();
			sbNew.append(sbPrev);
			sbNew.append(sNext);
			return sbNew;
		};
		
		BinaryOperator<StringBuilder> cmb3 = (sbA, sbB) -> {
			StringBuilder sbNew = new StringBuilder();
			sbNew.append(sbA);
			sbNew.append(sbB);
			return sbNew;
		};
		
		StringBuilder res3 = list.stream()
				.parallel()
				.reduce(idt3, acc3, cmb3);
			
		System.out.println("res3: " + res3.toString());		

	}
}
