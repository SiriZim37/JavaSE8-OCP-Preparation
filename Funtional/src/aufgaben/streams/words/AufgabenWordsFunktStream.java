package aufgaben.streams.words;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import words.Words;

public class AufgabenWordsFunktStream {

	public static void main(String[] args) {

		
		
		List<String> listWords = Words.germanWords();
		
		
		a1(listWords);
		a2(listWords);
		a3(listWords);
		a4(listWords);
		a5(listWords);
		a6(listWords);
		a7(listWords);
		a8(listWords);
		
		
		/*
		 * A. Optional
		 * Überlegen Sie sich weitere Pipelines um die von Ihnen ausgewählten 
		 * intermediate und terminal Operationen zu testen.
		 */	
		aOptional1(listWords);
		aOptional2(listWords);
		aOptional3(listWords);

	}

	private static void aOptional3(List<String> listWords) {		
		System.out.println("\n***A Optional 3");
		
		/* Optional 2 : 
		 * 
		 * - Gruppierung nach Vokalen 
		 * - die ersten 10 Wörter pro Vokal
		 */
		List<Character> arr = Arrays.asList('a', 'e', 'i', 'o', 'u');
		 Set<Character> vokale = new HashSet<>(arr);
		
		listWords.stream()
				.filter(word -> vokale.contains(Character.toLowerCase(word.charAt(0))))
		    	.collect(Collectors.groupingBy( c -> c.charAt(0) ))
		    	.forEach((key , value) -> {
		    		 List<String> listNur10 = value.stream()
		    				 						.limit(10)
		    				 					    .collect(Collectors.toList());
		    		System.out.println( key + " : " + listNur10);
		    	});
	}
	
	private static void aOptional2(List<String> listWords) {	
		System.out.println("\n***A Optional 2");
		/*
		 * Optional 2 : 
		 * 
		 * Längstes Word
		 */
		Comparator<String> cmp = (word1, word2) -> Integer.compare(word1.length(), word2.length());
		Optional<String> laengstesWord = listWords.stream()
										.max(cmp);								  
		System.out.println("Längstes Word : " + laengstesWord.get());
		        
	}
	
	private static void aOptional1(List<String> listWords) {
		System.out.println("\n***A Optional 1 ");
		/* 
		 * Optional 1 : 
		 * 
		 * - Gesamtsumme der Längen aller Wörter in der Liste.
		 */
		// Alternativ 1 
		int summeLength = listWords.stream()
									.mapToInt(String::length) 
									.sum();
		System.out.println("Summe1 : " + summeLength);
		
		// Alternativ 2 
		summeLength = listWords.stream()
								.map(String::length) 
								.reduce(0, Integer::sum);
		System.out.println("Summe2 : " + summeLength);
		
		IntStream summeLengthIntStream = listWords.stream()
												.mapToInt(String::length);
	
		System.out.println("IntStream Summe1 : " + summeLengthIntStream.sum());
		
	}

	private static void a8(List<String> listWords) {
		System.out.println("\n***A8");
		/*
		 * A8. Bilden Sie mit einer Pipeline folgende Gruppen: in einer Gruppe wird 
		 * der Länge der Gruppenstrings die Anzahl der Strings dieser Länge zugeordnet.
		 */
		listWords.stream()
    			.collect(Collectors.groupingBy( 
	    					String::length , 
	    					Collectors.counting()
    					))
    			.forEach((key , value) -> System.out.println("Länge: " + key + " : Anzahl = " + value));
	}

	private static void a7(List<String> listWords) {
		
		System.out.println("\n***A7");
		/*
		 * A7. Bilden Sie mit einer Pipeline Gruppen der Strings. 
		 * Einer Gruppe werden Strings mit derselben Länge zugeordnet.
		 * Gruppen-ID (Key) ist die Länge der Gruppen-Strings.
		 */
		listWords.stream()
			    	.collect(Collectors.groupingBy(String::length))
			    	.forEach((key , value) -> System.out.println("Länge: " + key + " : " + value));
		
	}

	private static void a6(List<String> listWords) {
		System.out.println("\n***A6");
		/*
		 * A6. Definieren Sie eine Pipeline, die überprüft ob es sich in der Liste 
		 * der Passwörter ihr Lieblingspasswort befindet.
		 */
		String meinPasswort = "abcdefghij";
		Optional<String> opt = listWords.stream()
					.filter(word -> word.equals(meinPasswort))
					.findFirst();

		if(opt.isPresent()) {
			System.out.println(true);
		}else {
			System.out.println("Kein Wort gefunden");
		}
	}

	private static void a5(List<String> listWords) {
		System.out.println("\n***A5");
		/*
		 * A5. Definieren Sie eine Pipeline, die eine LinkedList liefert, 
		 * in der alle Wörter gesammelt sind, die den Unterstring 'aba' beinhalten. 
		 */
        LinkedList<String> list = 
        				listWords.stream()
								.filter(word -> word.contains("aba"))
						        .collect(Collectors.toCollection(LinkedList::new));		
		System.out.println("list :" + list);
		
	}

	private static void a4(List<String> listWords) {
		System.out.println("\n***A4");
		/*
		 * A4. Definieren Sie eine Pipeline, die überprüft, ob es mindestens 
		 * ein Wort gibt in dem es den Unterstring 'ooo' gibt.
		 */
		String keyword = "ooo";
		// Alternativ 1
		Optional<String> opt = listWords.stream()
								.filter(s -> s.contains(keyword))
								.findAny();

		if(opt.isPresent()) {
			String str = opt.get();
			 System.out.println("Such nach String (" + keyword +") = " + str);
		}else {
			System.out.println("Kein Wort gefunden");
		}
		
		// Alternativ 2
		boolean gefunden = listWords
								.stream()
								.anyMatch(s -> s.contains(keyword));
		System.out.println("Such nach String (" + keyword +") = "+ gefunden);
		
	}

	private static void a3(List<String> listWords) {
		System.out.println("\n***A3");
		/*
		 * A3. Definieren Sie eine Pipeline, die die ersten 20 Wörter überspringt 
		 * und dann die nächsten 10 Wörter ausgibt.
		 */
		listWords.stream()
					 .skip(20)
					 .limit(10)
					 .forEach(System.out::println);
		
		
	}

	private static void a2(List<String> listWords) {
		System.out.println("\n***A2");
		/*
		 * A2. Definieren Sie eine Pipeline, die den lexikografisch kleinsten
		 * String liefert von den Strings, die mit 'm' starten.
		 */
		Optional<String> opt =  listWords.stream()
					.filter( word -> word.startsWith("m"))
					.sorted(String::compareTo).findFirst();
					
		if(opt.isPresent()) {
			String str = opt.get();
			 System.out.println("Lexikografisch kleinster String mit 'm' = " + str);
		}else {
			System.out.println("Kein Wort gefunden");
		}
		/*
		 *  Wdh : 
		 */
		// String str2 = listWords.stream().filter(s -> s.contains('m')).sorted().getFirst();			// cf 
		// String str2 = listWords.stream().filter(s -> s.contains("m")).sorted().findFirst();			// cf 
		Optional<String> str2 = listWords.stream().filter(s -> s.contains("m")).sorted().findFirst();	// richtig !
		
	}

	private static void a1(List<String> listWords) {
		System.out.println("***A1");
		/*
		 * A1. Definieren Sie eine Pipeline, die die Anzahl der Wörter der Länge größer als 5 ermittelt.
		 */
		long count = listWords.stream()
								.filter( word -> word.length()>5)
								.count(); 
		System.out.println(count);
		
	}

}
