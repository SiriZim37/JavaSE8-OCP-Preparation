package inheritance;

import java.util.function.Predicate;

class Beta{
	
}

class MyBaseClass{

	static Beta aa1 ;
	Beta aa2;

	
	int att ; 
	static int staticAtt;  
	
	int x = 1 ; 
	static int y = 2 ; 

	String doSome() {
		return "dosome";
	}

}


public  class Scope extends MyBaseClass {
	
	int x = 111 ; 
	static int  y = 222  ;
	
	static void staticAccessMethode() {
//		System.out.println(att);	   // cf  : Instanzvariable
		System.out.println(staticAtt); // ok 
		
		System.out.println("-----");
		System.out.println(y); // 222
		System.out.println(Scope.y); // 222
		System.out.println(MyBaseClass.y); // 2
		
		System.out.println(aa1);
//		System.out.println(MyBaseClass.aa2);		

		// super und this können in statischen Methoden nicht verwendet werden.
		// Hier ist der Grund dafür:
//		System.out.println(this.x); // 
//		System.out.println(super.x); // 
		

		
	}
	
	void instanceMethode() {

		System.out.println(att); 	   // ok 
		System.out.println(staticAtt); // ok 
		
		System.out.println("A. -----");
		System.out.println(y); // 222
		System.out.println(Scope.y); // 222
		System.out.println(MyBaseClass.y); // 2
		
		
		// this und super funktionieren nur in Instanzmethoden !!!! 
		System.out.println("B. -----");
		System.out.println(x); // 111
		System.out.println(this.x); // 111
		System.out.println(super.x); // 1
		
		System.out.println("C. -----");
		String y = "montag";
		System.out.println(y); // montag
		System.out.println(Scope.y); // 222
		System.out.println(MyBaseClass.y); // 2
		
		boolean x = false;
		System.out.println(x); 			// false
		System.out.println(this.x); 	// 111
		System.out.println(super.x); 	// 1 
	
		System.out.println(doSome());	// dosome
		System.out.println(super.doSome());	// dosome
		
		
		{
//			int x = 3; // cf : es gibt bereits eine lokale Variable x 
		}
		
		/*
		 * unwahrscheinlich in der Prüfung
		 * 
		 * in einer Lambda kann die Lokale Variable
		 * der umschliessenden Methode gelesen werden. ( closure )
		 */
		
		
		int day = 1 ; 
		
		Predicate<Integer> p = param -> {
//			int x = 3 ;
			return day == 1 ; 	// Zugriff auf lokale Variable der umschliessenden Methode
		};
		
	}


	public  static void main( String[] args) {
		
		
		
		staticAccessMethode();
		
		new Scope().instanceMethode();
	}
	

	

}
