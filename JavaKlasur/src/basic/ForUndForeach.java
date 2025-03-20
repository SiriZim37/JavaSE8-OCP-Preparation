package basic;

public class ForUndForeach {

	public static void main(String[] args) {
		
		int[] arr = { 10, 20, 30 ,};
		System.out.println(arr.length); // 3 
		/*
		 * foreach braucht eigene Schleifenvariable
		 */
		int x1;
//		for(x1 : arr) {} // cf
		
		for(int x : arr) {}

		/*
		 * for kann auch bereits existierende Variable verwenden
		 */
		int x2;
		for(x2=0; x2<2 ;x2++) {
			
		}
		
		/*
		 * Einschränkungen für for-Schleife:
		 * 
		 * - eigene Schleifenvariablen müssen denselben (einen) Typ haben
		 */
		int tmp = 2;
		for(String s1, s2; tmp<1;) {
			
		}
		
//		for(String s1, String s2; tmp<1;) { // cf
//			
//		}
		
//		for(String s1, int s2; tmp<1;) { // cf
//			
//		}
		
		/*
		 * Einschränkungen für for-Schleife:
		 * 
		 * - in der Mitte ein(!) boolean-Wert 
		 */
		for(int i=0; i<1000 && i+1%2!=77 ;i++) {
			
		}
		
//		for(int i=0; i<1000, i!=77 ;i++) { // cf
//			
//		}
		
		/*
		 * Ansonsten fast alles erlaubt.
		 * 
		 * z.B. (aber bitte nicht in der Praxis):
		 */
		for(get(), get() ; get() ; get(), get(), get()) {}
		
	}
	
	static boolean get() {
		return false;
	}

}
