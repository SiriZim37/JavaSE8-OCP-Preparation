package operatoren;

public class Wdh {

	public static void main(String[] args) {
		
		int x = 0;

		/*
		 * 		||	- rechte Seite nicht auswerten,
		 * 			  wenn der linke Operand gleich true ist
		 */
		if(x==0 || ++x==22) {
			System.out.println("1. if");
		}
		System.out.println("1. x = " + x); // 0
		
		/*
		 * 		|	- beide Seiten auswerten
		 */
		if(x==0 | ++x==22) {
			System.out.println("2. if");
		}
		System.out.println("2. x = " + x); // 1
		
		/*
		 * 		&&	- rechte Seite nicht auswerten, 
		 * 			  wenn der linke Operand gleich false ist
		 */
		if(x==22 && ++x==77) {
			//...
		}
		System.out.println("3. x = " + x); // 1
		
		/*
		 * 		&	- beide Seiten auswerten
		 */
		if(x==22 & ++x==77) {
			//...
		}
		System.out.println("4. x = " + x); // 2 
		
	}

}
