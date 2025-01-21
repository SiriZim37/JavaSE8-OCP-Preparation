package aufgaben.nested.a4;

import java.util.Comparator;

/*
 *  	1.  Mit einer Toplevel-Klasse
 */
class StringLengthComparator implements Comparator<String> {
    public int compare(String s1, String s2) {
        return Integer.compare(s1.length(), s2.length());
    }
}



public class TestInnereKlassenComparator {

	/*
	 *  	2. Mit einer inneren (nested) Klasse
	 */
	class StringComparatorWithInnerClass implements Comparator<String>{

		public int compare(String s1, String s2) {
		      return Integer.compare(s1.length(), s2.length());
		}
		
	}

	
	public static void main(String[] args) {
	
		/*
		 * 1. Mit einer Toplevel-Klasse
		 */
		Comparator<String> toplevel = new StringLengthComparator();
		System.out.println("***1." + toplevel.compare("abc", "abcd"));
		
		/*
		 * 2. Mit einer inneren (nested) Klasse
		 */
		Comparator<String> innerClass = new TestInnereKlassenComparator().new StringComparatorWithInnerClass();
		System.out.println("***2." + innerClass.compare("abc", "abcd"));

		/*
		 *  	3. Mit einer lokalen Klasse
		 */
		class StringComparatorWithLocalClass {
		    public Comparator<String> getComparator() {
		        class LengthComparator implements Comparator<String> {
		            public int compare(String s1, String s2) {
		                return Integer.compare(s1.length(), s2.length());
		            }
		        }
		        return new LengthComparator();
		    }
		}

		Comparator<String> localClass = new StringComparatorWithLocalClass().getComparator(); // Aufruf local Class
		System.out.println("***3." + localClass.compare("abc", "abcd"));
		

		/*
		 *  	4.Mit einer anonymen Klasse  
		 */
		// 4.+2. annonyme Klasse definieren und sofort instantzieren
		Comparator<String> annonymeClass  = new Comparator<String>(){
			public int compare(String s1, String s2) {
	             return Integer.compare(s1.length(), s2.length());
	        }
		};
		System.out.println("***4." + annonymeClass.compare("abc", "abcd"));

		/*
		 * 		5. Mit einer Lambda-Funktion
		 */
		// 4.+2. mit einer Lambda
		Comparator<Integer> annonymeMitlambda1 = (Integer x , Integer y) ->{
			return x-y;
		};
		System.out.println("***5." + annonymeMitlambda1.compare("abc".length(), "abcd".length()));
		
		
		Comparator<String> annonymeMitlambda2 = (s1, s2) -> Integer.compare(s1.length(), s2.length());
		System.out.println("***6." + annonymeMitlambda2.compare("abc", "abcd"));
		
		/*
		 * Optional. Mit einer Methodenreferenz
		 */
		
	     Comparator<String> methodenReferenz = TestInnereKlassenComparator::compareByLength;
	     System.out.println("***7." + methodenReferenz.compare("abc", "abcd"));
		
		
	} // end of main 


    // Statische Methode, um die Längen von zwei Strings zu vergleichen
    public static int compareByLength(String s1, String s2) {
        return Integer.compare(s1.length(), s2.length());
    }

}
