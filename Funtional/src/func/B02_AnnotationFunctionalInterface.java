package func;

public class B02_AnnotationFunctionalInterface {

	interface I1{  // funkt.Interface
		void m();
	}
	
	@FunctionalInterface
	interface I2{  // funkt.Interface
		void m();
	}
	

	interface I3{  // kein funkt.Interface. aber ein gültiges Interface
		void m1();
		void m2();
	}
	
	@FunctionalInterface
	interface I4{  // cf : kein funkt.Interface. aber ein gültiges Interface
		void m1();
	}
	
//	@FunctionalInterface
//	interface I5{  // kein funkt.Interface. aber ein gültiges Interface
//		default void m1() {}
//	}
	
	/*
	 * Die Annotation @FunctionalInterface schaltet nur eine 
	 * weitere Compiler-Kontrolle ein : 
	 * 
	 * Der Compiler überprüft , ob das wirklich funtionales Interface ist.
	 */
	public static void main(String[] args) {
		
		I4 v4 = ()->{};
		
//		I5 v5 = ()->{};

	}

}
