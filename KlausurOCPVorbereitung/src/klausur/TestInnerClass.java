package klausur;

import java.util.Map;

/*
 * 
 * Frage 26. (3 Punkte)

	Gegeben ist folgender Code, der kompiliert:
	
	    Map.Entry<Integer, String> entry = new Pairs.Element();
	
	Was trifft definitiv zu?
	Eine oder mehrere richtige Antworten sind möglich.
	
	[ X ] 'Element' ist eine statische innere Klasse.
	[  ] 'Element' ist eine innere Klasse, die nicht statisch ist.
	[   ] 'Element' ist eine generische Klasse.
	[ X  ] 'Element' ist keine anonyme Klasse

 */

/*
 // correct :  'Element' ist eine statische innere Klasse. 
		 		'Element' ist keine anonyme Klasse
//  incorrect ; Element' ist eine generische Klasse. (Es kann generisch & nicht generrische Klasse sein)
 */
class Pairs1 {
	class Element{}	
}
class Pairs2 {
	static class Element{}	
}
class Pairs3 {
	static class Element<T>{}			// generic class 	
}
class Pairs4 {
	static class Element<T ,X>{}		// generic class 	
}
class Pairs5{
	static class Element implements Map.Entry<Integer, String>{			// not-generic class
		public Integer getKey() {return null;}
		public String getValue() {	return null;}
		public String setValue(String value) {return null;}
	}
}
class Pairs6{
	static class Element<T> implements Map.Entry<Integer, String>{			// generic class 	
		public Integer getKey() {return null;}
		public String getValue() {	return null;}
		public String setValue(String value) {return null;}
	}
}
class Pairs7{
	static class Element<T> implements Map.Entry<T, String>{			// generic class 	
		public T getKey() {return null;}
		public String getValue() {	return null;}
		public String setValue(String value) {return null;}
	}
}


public class TestInnerClass {

	
	public static void main(String[] args) {
	
//		  Map.Entry<Integer, String> entry = new Pairs.Element();
		
		
//		 new Pairs1.Element();													// cf 
		 new Pairs1().new Element();											// ok - non-static inner class
//		 Map.Entry<Integer, String> entry1 = new Pairs1().new Element();		// cf
		
		 new Pairs2.Element();	
		 new Pairs3.Element();	// ok - static inner class
//		 Map.Entry<Integer, String> entry2 =  new Pairs2.Element();				// cf
//		 new Pairs2().new Element();											// cf 
		
		 Map.Entry<Integer, String> entry3 = new Pairs5.Element();
		 Map.Entry<Integer, String> entry4 = new Pairs6.Element();
		 Map.Entry<Integer, String> entry5 = new Pairs6.Element<Boolean>();
		 
//		 Map.Entry<Integer, String> entry6 = new Pairs7.Element<Boolean>;		// cf 


		  
	}
}
