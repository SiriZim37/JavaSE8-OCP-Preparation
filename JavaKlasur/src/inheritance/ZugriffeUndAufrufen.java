package inheritance;

interface Fahrbar{
	int x = 24;	
	default String m1() { return "fb1";}	
	default String m2() { return "fb2"; }
}

class Auto{
	public String m2() { return "au2"; }	
	public String m4() { return "au4"; }
}

class VW extends Auto implements Fahrbar{
	public String m3() { return "vw3"; }	
	public String m4() { return "vw4"; }
}


public class ZugriffeUndAufrufen {

	static Fahrbar f = new VW();
	static Auto a1 = new Auto();
	static Auto a2 = new VW();
	static VW v = new VW();	
	
	public static void main(String[] args) {
			
		
		System.out.println(f.x); 	        // Warnung Sinnloser Zugriff ! Fahrbar.x sollte 
		System.out.println(Fahrbar.x);		// mit dem Klassennamen aufgerufen werden ! 

		System.out.println(v.x);  			// Warnung Sinnloser Zugriff ! VW.x sollte 
		System.out.println(VW.x); 			// mit dem Klassennamen aufgerufen werden ! 
		
		System.out.println(f.m1());	// fb1	(polymorphisch)
		
		System.out.println(f.m2()); // au2	(polymorphisch)
		
//		System.out.println(f.m3()); // cf : keine m3() in Fahrbar
		
		System.out.println(v.m3()); // vw3
//		VW vw = (VW)f; (Downcasting)
		System.out.println(((VW)f).m3());	// vw3 : DownCasting
		
		System.out.println(a1.m4());	// au4
		System.out.println(a2.m4());	// vw4
	}

}
