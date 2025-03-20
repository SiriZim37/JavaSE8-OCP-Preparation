package operatoren;

public class InkrementDekrement {

	/*
	 *  x++ ist Inkrement:
	 *  
	 *   	x = x + 1
	 */
	public static void main(String[] args) {
		int x = 42;
		System.out.println("1. x = " + x); // 42
		
		x++; // Postinkrement
		System.out.println("2. x = " + x); // 43
		
		++x; // Präinkrement
		System.out.println("3. x = " + x); // 44

		x--; // Postdekrement
		System.out.println("4. x = " + x); // 43

		--x; // Prädekrement
		System.out.println("5. x = " + x); // 42
		
		/*
		 * Zwischen Post- und Prä-Versionen gibt
		 * es nur dann Unterschied, wenn die
		 * Variable an weiteren Leseoperation
		 * in einem Ausdruck beteiligt wird
		 * 
		 */

		/*
		 * Wenn es Post-Inkrement (-Dekrement) ist:
		 * 1. Den alten Wert für die weitere Operation lesen 
		 *    (in die CPU zwischenkopieren)
		 * 2. Variable inkrementieren (dekrementieren)
		 * 3. Gelesenen Wert (alten) verwenden
		 * 
		 */
		System.out.println("\n*** Test Postinkrement");
		int y = 0;
		System.out.println(y++); // Ausgabe: 0, y wird aber inkrementiert
		System.out.println("y = " + y); // 1

		/*
		 * Wenn es Prä-Inkrement (-Dekrement) ist:
		 * 1. Variable inkrementieren (dekrementieren)
		 * 2. Lesen für die weitere Operation
		 * 3. Gelesenen Wert verwenden
		 */
		System.out.println("\n*** Test Präinkrement");
		int z = 0;
		System.out.println(++z); // 1
		System.out.println("z = " + z); // 1
		
		System.out.println("\n*** mehr Tests");
		
		x = 0;
		x = ++x;
		/*
		 * 1. x inkrementieren (x ist danach 1)
		 * 2. x hochladen in die CPU (tmp = 1)
		 * 3. Aus CPU in x kopieren (aus tmp in x)
		 */
		System.out.println("x = " + x); // 1
		
		y = 0;
		/*
		 * 1. y lesen (in CPU hochladen: tmp = 0)
		 * 2. y inkrementieren (y ist 1)
		 * 3. Aus CPU in y kopieren (aus tmp in y) 
		 */
		y = y++;
		
		System.out.println("y = " + y); // 0
		
		z = 0;
		/*
		 * 1. z Inkrementieren, da im nächsten Schritt sie gelesen wird
		 * 		z = 1
		 * 2. Linken Operanden (z) lesen (für Addition)
		 * 		tmpLeft = 1
		 * 3. Rechten Operanden (z) lesen (für Addition)
		 * 		tmpRight = 1
		 * 4. z Inkrementieren (nachdem sie für Addition im vorherigen
		 *    Schritt gelesen wurde)
		 *    	z = 2
		 * 5. Addieren
		 * 		tmpResult = tmpLeft + tmpRight = 2
		 * 6. tmpResult mit dem Zuweisungsoperator in z kopieren
		 * 		z = 2 
		 */
		z = ++z + z++; // bitte in der Praxis sowas nicht programmieren
		System.out.println("z = " + z); // 2
		
		
		/*
		 * Achtung! Beim Inkrementieren gibt es 
		 * implizites Casting (wenn nötig)
		 */
		byte b1 = 1;
//		b1 = b1 + 1; // cf: byte <- int
		b1 = (byte)(b1 + 1); // explizites Casting
		
		b1++; // b1 = (byte)(b1 + 1);
		System.out.println("a. b1 = " + b1); // 3
		
		b1 = Byte.MAX_VALUE; // 127
		System.out.println("b. b1 = " + b1); // 127
		
		b1++; // byte-Overflow
		System.out.println("c. b1 = " + b1); // falscher Wert
	}

}
