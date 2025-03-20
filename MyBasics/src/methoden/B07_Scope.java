package methoden;

// int globalVar = 12; // cf: geht in Java gar nicht

public class B07_Scope {
	
	public static void main(String[] args) { // Parameter: gültig bis zum Ende der Methode
		
		int v1 = 12; // lokale Variable: gültig bis zum Ende der Methode
		
		System.out.println(args);
		System.out.println(v1);
		
		System.out.println(B07_Scope.stVar); // -117
		System.out.println(stVar); // -117
		
		testAccess();
		
		System.out.println("main sucht die stVar");
		System.out.println("stVar: " + stVar); // 42
	}

	static void testAccess() {
//		System.out.println(args);	// cf
//		System.out.println(v1);		// cf
		
		System.out.println(B07_Scope.stVar); // -117
		System.out.println(stVar); // -117
		
		System.out.println("testAccess ändert die stVar");
		stVar = 42;
	}
	void testGo() {
		System.out.println(this.stVar); 
	}
	
	static int stVar = -117; // gültig überall
}
