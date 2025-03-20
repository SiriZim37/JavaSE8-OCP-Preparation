package aufgaben.lambdas.v2.solution;


interface IntOperation { 
	int execute(int x, int y); 
}

class Sum implements IntOperation {
	public int execute(int a, int b) { return a + b; }
}

class Max implements IntOperation {
	public int execute(int x, int y) { return x > y ? x : y; }
}

public class AufgabeLambdasA1 {
	
	public static void main(String[] args) {
		IntOperation op1 = new Sum();	// Kann Summe bilden
		System.out.println( op1.execute(2, 3) ); // 5

		IntOperation op2 = (a, b) -> a + b;	// hier eine Lambda zum Bilden der Summe
		System.out.println( op2.execute(2, 3) ); // 5

		IntOperation op3 = new Max(); // Kann den größeren Wert ermitteln
		System.out.println( op3.execute(-6, 17) ); // 17

		IntOperation op4 = (s1, s2) -> s1 > s1 ? s1 : s2; // hier eine Lambda um den größeren Wert zu ermitteln
		System.out.println( op4.execute(-6, 17) ); // 17

	}
	/*
		Gegeben ist die Zeile aus der main:

			IntOperation op4 = (s1, s2) -> true;
		
		Kompiliert die Zeile?
		
		Klasse nachbilden:
		
			class Blabla implements IntOperation {
				public int execute(int s1, int s2) {
					return s1 > s1 ? s1 : s2;
				}
			}
	 */
	
	
	/*
		Gegeben ist die Zeile aus der main:
		
			IntOperation op2 = (a, b) -> a + b;

		Ob die Lambda kompiliert?
		
		Klasse nachbilden:
		
			class Blabla implements IntOperation {
				public int execute(int a, int b) {
					return a + b;
				} 
			}
	 */

}
