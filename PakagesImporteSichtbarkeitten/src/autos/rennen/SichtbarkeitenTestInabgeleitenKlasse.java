package autos.rennen;

import autos.Auto;

public class SichtbarkeitenTestInabgeleitenKlasse extends Auto {

	public static void main(String[] args) {

		Auto a1 = new Auto();
		
		System.out.println(a1.a);	// public
//		System.out.println(a1.b);	// cf : protected // protected im anderen Pakage mit Basistyp
//		System.out.println(a1.c);	// cf :'pakage private' oder 'default'
//		System.out.println(a1.d);	// cf : private
		

	}

}
