package garbagecollector;


class Beta{
	
}

class Alpha{

	static Beta b1 ;
	Beta b2;

}
//  which objects are eligible for garbage collection ? 
//  Answer : only the Alpha-1 object



public class AlphaBetaTest {

	public static void main(String[] args) {

		Beta b1  = new Beta();  // (1) b1 refers to a new Beta object (Beta-1)
		Beta b2  = new Beta();  // (2) b2 refers to another new Beta object (Beta-2)
		Alpha a1 = new Alpha(); // (3) a1 refers to a new Alpha object (Alpha-1)
		Alpha a2 = new Alpha(); // (4) a2 refers to another new Alpha object (Alpha-2)
		a1.b1 = b1 ;            // (5) The static reference a1.b1 refers to b1 (Beta-1)
		a1.b2 = b1 ;            // (6) a1.b2 refers to b1 (Beta-1)
		a1.b2 = b2 ;            // (7) a1.b2 is updated to refer to b2 (Beta-2), so a1.b2 no longer refers to Beta-1
		a1 = null ;             // (8) a1 is set to null, making the Alpha-1 object eligible for garbage collection
		b1 = null ;             // (9) b1 is set to null, but Beta-1 is still referenced by the static a1.b1
		b2 = null ;             // (10) b2 is set to null, but Beta-2 is still referenced by a1.b2

		
/*		After a1 = null;, b1 = null;, b2 = null;:
 * 
 * 		1. a1 (which refers to Alpha-1) is now null, meaning Alpha-1 is eligible 
 * 			for garbage collection because no references point to it.
 * 
 * 		2. b1 is null, but Beta-1 is still being referenced by 
 * 		   	the static variable Alpha.b1. Therefore, Beta-1 
 * 			is not eligible for garbage collection.
 * 
 * 		3. b2 is null, but Beta-2 is still being referenced by a1.b2 
 * 			(before a1 was nullified). Therefore, Beta-2 is not eligible 
 * 			for garbage collection.
 */
			

		
	}

}
