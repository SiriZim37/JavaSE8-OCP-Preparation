package ocp;

public class Assertions1 {

	public static void main(String[] args) {
		
		// Assertion must retun value 
		
		int j = 7;
		assert(++j > 7 );					// ok 
		assert(++j > 8 ): "hi";				// ok return String "hi"
		assert(++j > 10): j = 12;			// ok return int j = 12
//		assert(j==12): doStuff();			// cf : return void 
		assert(j==12): new Assertions1();	// ok : return referenz
	}
	static void doStuff() {}
}
