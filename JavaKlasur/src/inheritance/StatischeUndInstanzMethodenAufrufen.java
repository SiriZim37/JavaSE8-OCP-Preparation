package inheritance;

import java.util.Random;


abstract class testAbstract {

	protected static String str1 = "str1";
	public testAbstract() {
		this.str1 = "str3";
	}	
}
	
class Singer {

	protected String str1 = "str1";
	String str2= "str1";
	static void singUnlogish() {
		System.out.println("s1");
	}
	
	void singLogish() {
		System.out.println("s3");
	}
	static {
		System.out.println("s55"); 	// Ausgabe : Klasse Display wird geladen  
									// Klasse Display wird hier zum 1. mal benutzt
									// Die JVM läde die Klasse in das Class-Objekt
		
	}
}

class Tenor extends Singer {
//	private static void singUnlogish() {}	// Cannot reduce the visibility of the inherited method from Singer

	static void singUnlogish(){
		System.out.println("s2");
	}
	

	void singLogish() {
		System.out.println("s4" );
	}
}

public class StatischeUndInstanzMethodenAufrufen  extends testAbstract{

	protected static String str1 = "str2";
	 public String getTest() {
		 return super.str1;
	}
	
	
	public static void main(String[] args) {

	
			Singer ref = getSinger();
			
			System.out.println();
			
			ref.singLogish();  	// polymorpischer Aufruf!
			
			/*
			 * statische Methoden sollten mit dem Klassennamen
			 * aufgerufen werden ! 
			 */
			
			System.out.println();
			
			Singer.singUnlogish();
			Tenor.singUnlogish();
			
			System.out.println();
			
			Singer refS = new Tenor();
//			Tenor refD = new Singer();
			Tenor refT = new Tenor();
			
			/*
			 * Absolut sinnloser komischer leider kompilierbar 
			 * Aufruf einer statischen Methode mit einer Referenz : 
			 * 
			 * Der Compiler ersezt 
			 */
			System.out.println();
			
			refS.singUnlogish();		
			refT.singUnlogish();

			System.out.println();
			
			System.out.println("Test" + new StatischeUndInstanzMethodenAufrufen().getTest());
	}
	
	static Singer getSinger() {
		if(new Random().nextBoolean()) {
			return new Singer();
		}
		return new Tenor();
	}

}
