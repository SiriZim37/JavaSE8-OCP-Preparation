package arrays;

class Rechteck{
	int breite;
	int hoehe;
}


public class Wdh_Arr1 {

	public static void main(String[] args) {
	
		Rechteck r1;
		int[] a1;
		
		r1 = new Rechteck();
		a1 = new int[2];    // a1 Referenz wird neu Objekt int Array referenziert.
//		System.out.println(a1[2]); // cf : java.lang.ArrayIndexOutOfBoundsException: Index 2 out of bounds for length 2
		r1.breite = 42;
		a1[0] = 43;
		System.out.println("a1[0]" + a1[0]);
		System.out.println("a1[1]" + a1[1]);
		
	}

}
