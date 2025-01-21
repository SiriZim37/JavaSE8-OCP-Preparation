package aufgaben.streams.reduces;

import java.util.Comparator;
import java.util.Optional;

public interface TextStatistics {
	
	public Comparator<String> CMP_STRING_DEFAULT = 
		Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder());	
//   CMP_STRING_DEFAULT -> sort nach length und dann naturl sort 
//	 String : Java vs PHP   :::  Java länger als PHP
//	 String : JAVA vs HTML  :::  Java länger als HTML	
	
	
	public int getCountChars();
	
	public int getCountSpecialChars();
	
	public int getCountLetters();
	
	public Optional<String> getLongestWord();
}