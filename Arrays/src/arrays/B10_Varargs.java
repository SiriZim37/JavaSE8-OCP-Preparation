package arrays;

public class B10_Varargs {

	public static void main(String... args) {
		int x = 0 ;
		
		/*
		 *  wenn Methode static int add(int[] arr)  darf nicht aufrufen 
		 *  
		 *  nur static int add(int... arr) 
		 */
		x = add(); // leeres Array
		x = add(1); // Array mit 1 Element übergeben
		x = add(1, 2); // Array mit 2 Elementen übergeben
		x = add(1, 2, 3); // Array mit 3 Elementen übergeben
		x = add(1, 2, 3, 4); // Array mit 3 Elementen übergeben

		int[] a1 = { 1, 2};
		x = add(a1);
		
		int[] a2 = { 1 , 2 , 3};
		x = add(a2);
		
//		x = add({1,2,3,4}); // cf : 
		x = add(new int[] {1,2,3,4});
		
	}
	
//	static int add( int a , int b ) {return a+b;}
//	static int add( int a , int b , int c ) { return a+b+c;} ;
//	static int add( int a , int b , int c , int d) { return a+b+c+d;} ;

	/*
	 * Der einzige Unterschied zu dem normalen Parameter int[] arr:
	 * 
	 * Wenn man diese Methode aufruft, darf man die Elemente
	 * des Arrays Komma-getrennt auflisten. 
	 * Der Compiler generiert damit ein Array. 
	 */
	
	static int add(int... arr) { 
		int sum = 0;
		for(int x : arr) {
			sum+=x;
		}
		return sum;
	}
	
//	static int add(int[] arr) {
//	return 0;
//}
	
}
