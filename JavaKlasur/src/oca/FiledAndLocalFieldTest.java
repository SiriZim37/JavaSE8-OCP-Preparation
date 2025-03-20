package oca;

public class FiledAndLocalFieldTest {

	static int count;
	int p , b , a; 
	public static void main(String[] args) {

		//**** Aufgabe
		
		/* 1 .  Überladen  */
		if(count == 0) {
			int p , b , h ;
			p = 3 ;
			b = 4;
			h = 5 ;
			FiledAndLocalFieldTest obj = new FiledAndLocalFieldTest();
			System.out.println(obj.p + obj.b);
			System.out.println(p*b*h + count++); 
		}
//		System.out.println(p*b*h); // The local variable p may not have been initialized
		System.out.println(count); // The local variable p may not have been initialized
		
		
		// Java object 
		// for loop 
		// 

	}

}
