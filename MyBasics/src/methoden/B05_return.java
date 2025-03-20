package methoden;

public class B05_return {

	public static void main(String[] args) {
		
		/*
		 * Das Ergebnis einer Methode kann ignoriert werden:
		 */
		add(2, 3);
		
		/*
		 * Das Ergenis eines Methodenaufrufes wird hochgeladen,
		 * danach kann er z.B. in einer lokalen Variable
		 * kopiert werden:
		 */
		int result = add(2, 3);
		System.out.println("result = " + result);
	}

	
	static int add(int a, int b) {
		return a + b;  // diese return-Anweisung hat das Argument: a + b
	}
	
	/*
	 * void-Methode braucht keine return-Anweisung
	 */
	static void m1() {
		
	}
	
	/*
	 * void-Methode kann return-Anweisungen haben
	 */
	static void m2(int param) {
		if(param<0) {
			//...
			return; // methode m2 beenden
		}
		
		if(param>0) {
			//...
			return; // methode m2 beenden
		}
		
		//return 1; // cf: void darf nichts zurück liefern
		
		//...
	}
	
	/*
	 * Wenn return ein Argument hat,
	 * muss die Methode den passenden Typ
	 * als Rückgabetyp deklarieren 
	 */
	static void m3() {
//		return 42; // cf: Rückgabetyp passt nicht für 42
	}
	
}
