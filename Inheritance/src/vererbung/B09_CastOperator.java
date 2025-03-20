package vererbung;

final class Circle{
	int x , y ;
	/*
	 * Ein Bespiel , wo Casting sinn ergibt : beim Überschreiben der equals-Methode
	 */
	public boolean equals(Object obj) {
		if(!(obj instanceof Circle)) {
			return false;
		}
		Circle k2 = (Circle) obj; // casting
		return x == k2.x && y == k2.y; //  obj.x wird cf : weil obj kennt nur den Typ  
		
	}
}
class Rectangle{
	int width , height;
}



public class B09_CastOperator {

	public static void main(String[] args) {
		/*
		 * 
		 * 	- Casting kompiliert zw.Klassen nur entlang einer Vererbunglinie.!
		 */
		Circle ref1 = null;
		Rectangle ref2 = null ;
		
//		ref1 = ref2;  // cf : bei der Zuweisung Circle <- IS-KEON- Rectangle 
//		ref1 = (Circle) ref;  // cf : bei Casting  Circle und Rectangle sind Gescwisterklasse
	
		Object ref3 = ref1;
		Object ref4 = (Object)ref1; // ok : Upcasting : 
		
		
//		ref2 = ref4;  / cf :  Rectangle <- IS-KEIN- Object
		ref2 = (Rectangle)ref4; // ok : Downcasting
		ref3 = (Rectangle)ref4; // ok : Downcasting
		/*
		 * Casting '(Ractengle) ref4' zur Compilierzeit :
		 * 
		 * 		der Compiler soll sich an der Stelle des Castings vorstellen, 
		 * 		dass die Referenz ref4 von dem Typ 'Rectangle' ist.
		 * 
		 */
		
		
		
		/*	Ptüfung!!!!
		 * 
		 * Casting '(Rectangle)' ref4 zur Laufzeit : 
		 * 	
		 * 		if( !(ref4 instanceof Rectangle)){
		 * 			throw new ClassCastingExeption();
		 * 		}
		 */		
		Object refObject = new Circle();
		Circle refCircle = (Circle)refObject;// ok
		System.out.println(refCircle);  // In Ordung! 
		
		
		
		refObject = "bin kein Kreis"; // Referenz ist nicht Circle Object
		refCircle = (Circle) refObject;	 // ClassCastException
		// Der Typ der Referenz is nicht den Typ in Object ist

		
	}

}
