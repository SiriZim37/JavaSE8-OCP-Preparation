package arrays;

public class ForUndForeach {

	public static void main(String[] args) {
		
		int[] arr = {10,9,8,7,};
		/*
		 * foreach braucht eigene Schleifevariable
		 */
		
		int x1 ;
//		fot(x1 : arr){}	// cf
		
		for(int x : arr ) {}
		
		/*
		 * for kann auch bereits existierende Variable verwenden
		 */
		
		int x2 ;
		for(x2 = 0 ; x2 < 2 ; x2++) {
			
		}
		
		/*
		 * Einschräkungen für for-Schleife : 
		 * 
		 * - eigene Schleifenvariablen müssen denselben (einen) )Typ haben
		 */
		
		int tmp = 2 ; 
		for(String s1 , s2 ; tmp < 1 ; ) {
		}
		
//		for(String s1 , int s2 ; tmp < 1 ;)	// cf 
		
		/*
		 * Einschräkungen für for-Schleife : 
		 * 
		 * - in der Mitte ein (!) boolean-Wert
		 */
		

		for(int i = 0 ; i < 1000 && i+1%2 != 77 ; i++) {
			
		}

//		for(int i = 0 ; i< 1000 , i != 77 ; i++) { // cf
//			
//		}
		
		/*
		 * Ansonsten fast allest erlaubt
		 */
		
		for(;get();) {
			
		}
	}
	
	static boolean get() {
		return false;
	}

}
