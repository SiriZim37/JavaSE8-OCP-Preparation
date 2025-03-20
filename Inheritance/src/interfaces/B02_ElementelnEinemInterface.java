package interfaces;


// abstract interface compiliert auch.
// Ein Interface ist implizit abstract.
abstract interface MyInterface{
	/*
	 *  Java 8 : alle Elemente in einem Interface sind
	 *  		public (implizit oder explizit)
	 */
	
	/*
	 * 	abstrackte Instanzmetoden
	 */
	void m1();				// implizit : public abstrackt
	abstract void m2();		// implizit : public
	public void m3();		// implizit : abstract
	public abstract void m4();	
	
	
	// void m5() {} 	// cf : Rumpf für abstrackte Methode geht nicht
	
	/*
	 * 
	 * KOnkrete default-Instanzmethodenn
	 */
	default void m6() {}
	
//	default void m7(); // cf : Rumpf muss für default-Mrthode sein
	
	/*
	 * statische KOnstanten ( auch alle public)
	 */
	public static final int K1 = 1 ; 
	static final int K2 = 2 ;		// implizit : public 
	static int K3 = 3 ; 			// implizit : public final
	int K4 = 4 ;				    // implizit : public final static
	
//	int x ; 						// cf : in Interface kann kein objekt Attribut , nur statische Konstante
									// die manuell initialisiert werden muss.
	
	/*
	 * statische Methoden (auch alle implizit public ,  
	 * müssen aber explizit static sein ) 
	 */
	
	public static void m8() {
		System.out.println("m8");
	}
	
	static void m9() {} 			// implizit : public 
	void m11();					  //  implizit : public abstract
//	void m10() {} 				   //  cf : implizit : public abstract , hat aber den Rumpf (body)
	
	/*
	 * Innere Typen (nicht in der Prüfung)
	 */
	
	interface InnerInterface {}
	abstract class AbstractInnerClass{}
	class InnerClass{}
	enum InnerEnum{}
	@interface InnerAnnotation{}
	
} // end of MyInterface


public class B02_ElementelnEinemInterface {

	public static void main(String[] args) {
	
		System.out.println( MyInterface.K1);
		System.out.println( MyInterface.K2);
		System.out.println( MyInterface.K3);
		System.out.println( MyInterface.K4);
//		MyInterface.K4 = 22; // cf K4 ist final 
		
		MyInterface.m8();
	}

}
