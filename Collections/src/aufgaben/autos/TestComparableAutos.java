package aufgaben.autos;


public class TestComparableAutos {

	public static void main(String[] args) {
		VW 	vw1 = new VW ("Golf" , 1990);
		VW 	vw2 = new VW ("Polo"  , 2021);
		
		int res = vw1.compareTo(vw2);
		System.out.println("vw1.compareTo(vw2) = " + res);		// vw1 (Golf 1990) große als vw2 (Polo 2021) 
																// 	Negative -9
		
		BMW bmw1 = new BMW("Z4", 2000);
		BMW bmw2 = new BMW("Z2", 2021);
		
		res = bmw1.compareTo(bmw2);
		System.out.println("bmw1.compareTo(bmw2) = " + res);    // bmw1 (Z4 2000) große als bmw2 (Z2 2021) 
																// Positiv 2
		
		/*
		 *  Generische Klasse kann das Problem lösen! 
		 */
		res = vw1.compareTo(bmw1);
		System.out.println("vw1 compareTo bmw1: " + res);		
									
		
		
	}

}
