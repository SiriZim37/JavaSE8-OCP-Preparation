package wdh;


class MyClassA{

	/*
	 * MyClassA() {
	 * 	  this(12) {
	 *      this("42") {
	 *        super() {
	 *          ...
	 *        }
	 *        print("c") {
	 *          ...
	 *        }
	 *      }
	 *      print("b") {
	 *        ...
	 *      }
	 *    } 
	 *    print("a") {
	 *      ...
	 *    }
	 * }
	 */
	MyClassA() {
		this(12);
		System.out.print("a");
	}
	
	/*
	 * MyClassA(int) {
	 *    this("42") {
	 *       super() {
	 *         ...
	 *       }
	 *       print("c") {
	 *         ...
	 *       }
	 *    }
	 *    print("b") {
	 *      ...
	 *    }
	 * }
	 */
	MyClassA(int x) {
		this("42");
		System.out.print("b");
	}
	
	/*
	 * MyClassA(String) {
	 * 	 super() {           zuerst läuft der Object-Konstruktor
	 *     ...
	 *   }
	 *   print("c") {        dann läuft die print-Methode
	 *     ...
	 *   }
	 * }
	 */
	MyClassA(String x) {
		// super();
		System.out.print("c");
	}
	
}


public class WdhKonstruktoren2 {

	public static void main(String[] args) {
		
		new MyClassA();
		/*
		 * 	MyClassA() {
		 * 		this(12){  		
		 * 		  ... ---> 1 
		 * 		}
		 * 		print("a"){		    : result = cb		
		 * 		  ...
		 * 		}
		 * } 
		 *  2 --> 
		 * 	MyClassA( int ) {
		 * 		this("42"){  		
		 * 		  ... ---> 3 
		 * 		}
		 * 		print("b"){		    : result = cb		
		 * 		  ...
		 * 		}
		 * } 
		 * 3-->
		 * 	MyClassA( String ) {
		 * 		super(){  		 // zuerst läuft der Object-Konstruktor
		 * 		 ...
		 * 		}
		 * 		print("c"){		 dann läuft die Print-Methode  
		 * 		  ...
		 * 		}
		 * } 
		 */
		

		new MyClassA("moin"); // c
		/*
		 * MyClassA(String x) {
		 * 		Object(){  		 zuerst läuft der Object-Konstruktor
		 * 		}
		 * 		print("c"){		dann läuft die Print-Methode
		 * 		...
		 * 		}
		 * }
		 */
		

	}

}
