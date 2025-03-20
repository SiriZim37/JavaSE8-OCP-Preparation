package vererbung;

public class B15_VererbungBeiArrays {

	public static void main(String[] args) {
		/*
		 * Arrays mit primitiven Elementen
		 * erweiter alle direkt die Klasse Object
		 * 
		 * Das ist ungünstig , wenn nam unterschiedliche
		 * Arrays änhlich behandeln will.
		 * 
		 */
		
		int[] a1 = {1 ,2, 3};
		char[] a2 = { 'a' , 'b' , 'c'};
		printPrimitivesArray(a1);
		printPrimitivesArray(a2);
		printPrimitivesArray("bin kein primitives Array und bin als Argument sind.");
		
		/*
		 *	Aber bei Referenzen-Arrays :
		 *
		 * Wenn : 
		 * 		Hund -> IS-A -> Tier -> IS-A -> Object 
		 * dann : 
		 * 		Hund[]-> IS-A -> Tier[] -> IS-A -> Object[]
		 * 
		 */
		String[] a3 = {"mo","di","mi"};
		
		printReferenzenArray(a3); // Object[] arr = a3
								  // Object[] <- IS-A <- String

	}
	
	
	
	static void printReferenzenArray(Object[] arr) {
		for(Object x : arr) {
			System.out.println( x + " ");
		}
		System.out.println();
	}
	
	static void printPrimitivesArray(Object arr) { 
		if( arr instanceof int[]) {
			int[] a1 = (int[]) arr;
			for(int x : a1) {
				System.out.println(x + " ");
			}
			System.out.println();
		}else if(arr instanceof char[]) {
			char[] c1 = (char[]) arr;
			for(char x : c1) {
				System.out.println(x + " ");
			}
			System.out.println();
		}
		// else-if-Zweige für andere primative Arrays hier.
	}
}
