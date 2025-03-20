package oca;

public class StringArraysForeach {

	public static void main(String[] args) {

		String[] str = new String[2];
		int count = 0;
		for (String s : str) {
			s.concat("test" + count );	// Exception :  NullPointerException
		}
		System.out.println(count);
	}
	// Aufgabe : Exception in thread "main" java.lang.NullPointerException

}
