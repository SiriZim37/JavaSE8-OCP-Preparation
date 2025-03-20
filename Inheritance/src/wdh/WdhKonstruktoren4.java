package wdh;


class Tier {
	Tier(){
		this(12);
		System.out.print("a");
	}
	Tier(int x){
		System.out.print("c");
	}
}

class Hund extends Tier {
	Hund(){
		// super();
		System.out.print("b");
	}
	
	Hund(int x){
		this();
		System.out.print("d");
	}
}

public class WdhKonstruktoren4 {

	public static void main(String[] args) {
		
		/*
		 * Hund(int) {
		 *    Hund() {
		 *      Tier() { 
		 *         Tier(12) {
		 *             Object();
		 *             print("c")
		 *         }
		 *         print("a")
		 *      }
		 *      print("b")
		 *    }
		 *    print("d")
		 * }
		 */
		new Hund(12);
	
		System.out.println();
		
		/*
		 * Hund() {
		 *    super() {    <- Aufruf vom Tier()
		 *       this(12) {   <- Aufruf vom Tier(int)
		 *          super()      <- Aufruf vom Object()
		 *          print("c")
		 *       }
		 *       print("a")
		 *    }
		 *    print("b")
		 * }
		 */
		new Hund();
		
	}

}
