package classes;


class Motor { int typ;}

class Autoss { Motor motor;}


public class WdhKlassen2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Motor m = new Motor();
		
		Autoss a1 = new Autoss();
		a1.motor = m;
		
		Autoss a2 = new Autoss();
		a2.motor = m;
		
		m.typ = 42;
				
		System.out.println(a1.motor.typ);		// 42
		System.out.println(a2.motor.typ);		// 42
		
		
		/*
		 *  a1 in stack --> onjekt int heap
		 *  a2 
		 * 
		 */
	}

}
