package operatoren;

public class LogischeOperatoren {

	public static void main(String[] args) {
		
		/*
		 * 		!			NOT-Operator (unär)
		 * 
		 * 		&			AND ตรวจสอบว่าเงื่อนไขทั้งสองต้องเป็น true เท่านั้นถึงจะให้ผลลัพธ์เป็น true
		 * 		&&			AND short circuit
		 * 						(liefert false sofort zurück, wenn links false steht)
		 * 						ตรวจสอบว่าเงื่อนไขทั้งสองต้องเป็น true เท่านั้นถึงจะให้ผลลัพธ์เป็น true
		 * 
		 * 		|			OR ตรวจสอบว่าเงื่อนไขอย่างน้อยหนึ่งต้องเป็น true ถึงจะให้ผลลัพธ์เป็น true ประเมินเงื่อนไขทั้งสองเสมอ
		 * 		||			OR short circuit
		 * 						(liefert true sofort zurück, wenn links true steht)
		 * 
		 * 		^			XOR
		 */
		
		boolean b1 = true;
		System.out.println("!b1 = " + !b1); // false
		
		System.out.println();
		System.out.println("*** &-Operator: ");
		System.out.println("true & true: " + (true & true)); // true
		System.out.println("true & false: " + (true & false)); // false
		System.out.println("false & true: " + (false & true)); // false
		System.out.println("false & false: " + (false & false)); // false
		
		System.out.println();
		System.out.println("*** &&-Operator: ");
		System.out.println("true && true: " + (true && true)); // true
		System.out.println("true && false: " + (true && false)); // false
		System.out.println("false && true: " + (false && true)); // false
		System.out.println("false && false: " + (false && false)); // false
		
		/*
		 * Logische Operatoren in der Praxis.
		 * Unterschied zw. 'normalen' und 'short circuit' Operator.
		 * 
		 * Folgender Code wirft eine Exception, wenn args gleich null ist:
		 */
		try {
			if( args != null | args[0] == "test" ) {  // | check both
				// mit dem args arbeiten
				System.out.println("|");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			if( args != null & args[0] == "test" ) {  // & check both
				// mit dem args arbeiten
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		

		/*
		 * 
		 * Der Code hat keine Exception.
		 * 
		 * Wenn der linke Operand den Wert false hat, wird der
		 * Operator && den rechten Operanden nicht auswerten,
		 * sondern direkt false liefern. 
		 */
		if( args != null && args.length > 0 ) {
			// mit dem args arbeiten
		}
		
		/*
		 * XOR-Tabelle
		 */
		System.out.println("\n*** ^-Operator");
		System.out.println("true ^ true: " + (true ^ true)); // false
		System.out.println("true ^ false: " + (true ^ false)); // true
		System.out.println("false ^ true: " + (false ^ true)); // true
		System.out.println("false ^ false: " + (false ^ false)); // false
		
	} // end of main

}
