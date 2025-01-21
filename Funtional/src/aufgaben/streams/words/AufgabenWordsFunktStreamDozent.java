package aufgaben.streams.words;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import words.Words;

public class AufgabenWordsFunktStreamDozent {

	public static void main(String[] args) {

		
		
		List<String> listWords = Words.germanWords();
		
		
//		a1(listWords);
//		a2(listWords);
//		a3(listWords);
//		a4(listWords);
//		a5(listWords);
		a6( Words.passwords());
		a7( Words.englishWords());
		a8( Words.englishWords());
		
		
		/*
		 * A. Optional
		 * Überlegen Sie sich weitere Pipelines um die von Ihnen ausgewählten 
		 * intermediate und terminal Operationen zu testen.
		 */	
//		aOptional1(listWords);
//		aOptional2(listWords);
//		aOptional3(listWords);

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
		Collector<String, ?, Long> downstream = Collectors.counting();
		
		Collector<String, ?, Map<Integer, Long>> c1 = Collectors.groupingBy( 
																	String::length , 
																	downstream
																);
		
		Map<Integer, Long> map =  listWords.stream().collect(c1);
		
		map.forEach((key , value) -> System.out.println("length: " + key + " : count = " + value));

	}

	private static void groupingBy(Object object, Collector<String, ?, Long> downstream) {
		// TODO Auto-generated method stub
		
	}

	private static void a7(List<String> listWords) {
		
		System.out.println("\n***A7");
		/*
		 * A7. Bilden Sie mit einer Pipeline Gruppen der Strings. 
		 * Einer Gruppe werden Strings mit derselben Länge zugeordnet.
		 * Gruppen-ID (Key) ist die Länge der Gruppen-Strings.
		 */
		System.out.println( listWords.stream().max(Comparator.comparing(String::length)).get()  );
		
		
	    Function<String, Integer> classifier = (String s) -> s.length();
		Collector<String, ?, Map<Integer, List<String>>> c1 = Collectors.groupingBy(classifier);
		Map<Integer, List<String>> gruppenMap = listWords.stream().collect(c1);
		
		gruppenMap.forEach((length , list) -> {
			System.out.println(length + " : " + list.size());
		});
		
		
		/*
		 * sort
		 */
		System.out.println("Sortiert Key");
		
		Map<Integer, List<String>> gruppenMap2 =  listWords.stream()
				.collect(Collectors.groupingBy(String::length ,
											TreeMap::new ,
											Collectors.toList()) 
				);	
		
		gruppenMap2.forEach((length , list) -> {
			System.out.println(length + " : " + list.size());
		});
	}

	private static void a6(List<String> listWords) {
		System.out.println("\n***A6");
		/*
		 * A6. Definieren Sie eine Pipeline, die überprüft ob es sich in der Liste 
		 * der Passwörter ihr Lieblingspasswort befindet.
		 */
		String meinPasswort = "12345";
		Optional<String> opt = listWords.stream()
									.filter(word -> word.equals(meinPasswort))
									.findAny();

		if(opt.isPresent()) {
			System.out.println(meinPasswort + " hat gefunden");
		}else {
			System.out.println("Kein Passwort gefunden");
		}
	}

	private static void a5(List<String> listWords) {
		System.out.println("\n***A5");
		/*
		 * A5. Definieren Sie eine Pipeline, die eine LinkedList liefert, 
		 * in der alle Wörter gesammelt sind, die den Unterstring 'aba' beinhalten. 
		 */

        LinkedList<String> list = listWords.stream()
										.filter(word -> word.contains("aba"))
								        .collect(LinkedList::new , LinkedList::add , LinkedList::addAll);    
        
		System.out.println("Wörter mit aba-Substring:" + list.size());
		
		System.out.println("\n---------------------------------------------------------------");
		
		Supplier<LinkedList<String>> supp = () -> new LinkedList();
		
		Collector<String, ?, LinkedList<String>> c1 = Collectors.toCollection(supp);
		
		list = listWords.stream()
				.filter(word -> word.contains("aba"))
		        .collect(c1);  
		System.out.println("Wörter mit aba-Substring:" + list.size());
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
//		String str2 = daten.stream().filter(s -> s.startsWith("m")).sorted().getFirst();
//		String str2 = daten.stream().filter(s -> s.startsWith("m")).sorted().findFirst();
		Optional<String> maybeStr2 = listWords.stream()
										.filter(s -> s.startsWith("m"))
										.sorted()
										.findFirst();

		if(maybeStr2.isPresent()) {
			String str2 = maybeStr2.get();
			System.out.println("kleinster String von den Strings, die mit 'm' starten: " + str2);
		} else {
			System.out.println("Keine Strings gefunden, die mit m anfangen");
		}
	}

	private static void a1(List<String> listWords) {
		System.out.println("***A1");
		/*
		 * A1. Definieren Sie eine Pipeline, die die Anzahl der Wörter der Länge größer als 5 ermittelt.
		 */
		
		Collector<String, ?, Long> c1 = Collectors.counting();
		
		long count = listWords.stream()
			                .filter(word -> word.length() > 5) 
			                .collect(c1); 
		System.out.println(count);
		
	}

}
