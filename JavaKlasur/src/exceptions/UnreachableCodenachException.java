package exceptions;

public class UnreachableCodenachException {

	public static void main(String[] args) {

		boolean b = true ;
		if(b)
			throw new RuntimeException();
		
		System.out.println("1 UnreachableCode");
		
		
		if(true)
			throw new RuntimeException();
		
		System.out.println("2 UnreachableCode"); // ok : warning : Dead code
		
		throw new RuntimeException();
//		System.out.println("3 UnreachableCode");  // cf : Unreachable code
		
	}

}
