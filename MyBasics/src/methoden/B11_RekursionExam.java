package methoden;

public class B11_RekursionExam {

	public static void main(String[] args) {
//		b1();
//		b2();
//		b3(3);
		b4(3);
	}
	
	/*
	 * b4(a=3) {
	 * 		Ausgabe 3
	 * 
	 * 		b4(a=2) {
	 * 			Ausgabe 2
	 * 
	 * 			b4(a=1) {
	 * 				Ausgabe 1
	 * 
	 * 				b4(a=0) {
	 * 					Ausgabe 0
	 * 
	 * 					return
	 * 				}
	 * 			}
	 * 		}
	 * }
	 */
	static void b4(int a) {
		System.out.println(a);
		
		if(a==0) {
			return;
		}
		
//		b4(--a); // auch ok
		b4(a-1);
	}
	
	/*
	 * Wenn b3 aufgerufen wird, 
	 * gibt es viele Ausgaben 3 3 3 3...
	 * aber dann StackOverflowError
	 * 
	 *  b3(a=3) {
	 * 		Ausgabe 3
	 * 
	 * 		b3(a=3) {
	 *         Ausgabe 3
	 *         
	 *         b3(a=3) {
	 *            Ausgabe 3
	 *            
	 *            ...
	 *         }
	 *      }
	 *  }
	 */
	static void b3(int a) {
		System.out.println(a);
		
		if(a==0) {
			return;
		}
		
		b3(a--); // Bug hier! der alte Wer von a wird als Argument übergeben: int a' = a--
	}

	/*
	 * Wenn die Methode b2() (oder x() oder y()) aufgerufen wird, 
	 * gibt es den StackOverflowError
	 */
	static void b2() {
		x();
	}
	static void x() {
		y();
	}
	static void y() {
		x();
	}
	
	/*
	 * Wenn diese Methode aufgerufen wird, 
	 * gibt es den StackOverflowError
	 */
	static void b1() {
		b1();
	}

}
