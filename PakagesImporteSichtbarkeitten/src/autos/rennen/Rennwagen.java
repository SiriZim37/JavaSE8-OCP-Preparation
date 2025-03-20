package autos.rennen;

import autos.Auto;


public class Rennwagen extends Auto{
	
	public Rennwagen() {
		b = 22 ;
	}

	public static void main(String[] args) {
	
		Auto a1 = new Auto();
//		System.out.println(a1.b); //  cf : protected im anderen Pakage mit Basistyp
		
		Rennwagen rw1 = new Rennwagen();
		System.out.println(rw1.b); // protected im anderen Pakage mit dem abgeleiteten Typ
//		System.out.println(b); // cf : Cannot make a static reference to the non-static field b
	}

}
