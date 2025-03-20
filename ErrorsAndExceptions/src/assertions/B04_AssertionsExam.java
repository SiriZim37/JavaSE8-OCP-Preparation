package assertions;

public class B04_AssertionsExam {

	public static void main(String[] args) {
	
		/*
		 * In der Prüfung gibt es den Code 
		 * und danach die Besreibeung der Befehle
		 * fürs Kompilieren (nicht immer) und fürs Starten
		 */
		
		/*
		 * Bsp 1.
		 * 
		 * Gegeben ist : 
		 * 
			public static void main(String[] args) {
				int x = 0 ; 
				assert x==0 : System.out.print("a ");
				System.out.println("m ");
			}
		
			und folgende Befelhe : 
			
			javac MyApp
			java MyApp
		
		
			Was ist die Ergebnis ?  Compiler fehler
		 */
		
		/*
		 * Bsp 2.
		 * 
		 * Gegeben ist : 
		 * 
			public static void main(String[] args) {
				int x = 0 ; 
				assert x == 1 : "x muss > 0";
				System.out.println("m");
			}
		
			und folgende Befelhe : 
			
			javac MyApp
			java MyApp
		
		
			Was ist die Ergebnis ?  AssertError
		 */
		
		/*
		 * Bsp 3.
		 * 
		 * Gegeben ist : 
		 * 
			public static void main(String[] args) {
				int x = 1 ; 
				System.out.print("n ");
				assert x <= 1 : "x muss <= 0";
				System.out.print("m ");
			}
		
			und folgende Befelhe : 
			
			javac MyApp
			java MyApp
		
		
			Was ist die Ergebnis ? n m
		 */
		

		 
	}

}
