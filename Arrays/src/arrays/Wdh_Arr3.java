package arrays;

class Kreiss{
	int radius;
}



public class Wdh_Arr3 {

	public static void main(String[] args) {
	
		Kreiss[] a1 = new Kreiss[2];
		
		a1[0] = new Kreiss();
		a1[1] = new Kreiss();
		
		a1[0].radius = 42;
		
		System.out.println(a1[0].radius);
		System.out.println(a1[1].radius);
	}

}