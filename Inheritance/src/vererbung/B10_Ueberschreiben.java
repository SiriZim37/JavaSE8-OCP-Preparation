package vererbung;


/*		 ---- @Overriding --- // Overriding and Access-Modifiers
 *  In Java ist Overriding eine Funktion, die es einer Unterklasse oder Kindklasse ermöglicht, 
 *  eine bestimmte Implementierung einer Methode bereitzustellen, 
 *  die bereits von einer ihrer Superklassen oder Elternklassen bereitgestellt wird.
 *  Wenn eine Methode in einer Unterklasse denselben Namen, dieselben Parameter 
 *  oder Signaturen und denselben Rückgabetyp (oder Untertyp) wie eine Methode 
 *  in ihrer Superklasse hat, dann wird gesagt, dass die Methode in der Unterklasse 
 *  die Methode in der Superklasse überschreibt .
 *  
 *  // private methods are not overridden
 *  // final methods cannot be overridden
 *  
 * 
 */
class ClassA {
	/*
	 * ClassA erbt die toString-Methode an der Basisklasse Objekt
	 * 
	 */
}
class ClassB {
	/*
	 * ClassB erbt die toString-Methode an der Basisklasse Objekt
	 * 
	 */
	/*
	 * ClassB überlädt die toString-Methode und hat damit zwei toString-Methoden
	 * 
	 */
	/// private kann nicht overriding
//	public String toString(int x ) { return "Text aus toString(int)";}  // : ok 
	protected String toString(int x ) { return "Text aus toString(int)";}  // : ok 
}


class ClassC{
	/*
	 *  ClassC überscheibt die toString-Methode und
	 */
	public String toString() {return "Text aus toString()";}
}


public class B10_Ueberschreiben {  // @Overriding 
	
	/*
	 * - Überschreiben : Ersetzen einer geerbten Methode
	 * 	 durch eine Methode mit derselben Signatur
	 * 
	 * - Regeln beim Überschreiben :
	 * 
	 * 		1. Sichtbarkeit nicht verschärfen  // อย่าเพิ่มการมองเห็น 
	 * 		2. Rückgabetyp nicht ändern. (Kovarianz ist ok)
	 * 		3. Zusätzliche checked Exceptions nicht deklarieren
	 * 			(s. Projekt 'Excepttions' )
	 */
	public static void main(String[] args) {
	
		ClassA a = new ClassA();
		System.out.println(a.toString()); // vererbung.ClassA@65ae6ba4
		
		ClassB b = new ClassB();
		System.out.println(b.toString()); //vererbung.ClassB@6a6824be
		System.out.println(b.toString(12)); // Text aus toString(int)
		
		

		System.out.println();

        Parent obj1 = new Child();
        // As per overriding rules this
        // should call to class Child static
        // overridden method. Since static
        // method can not be overridden, it
        // calls Parent's m1()
        obj1.m1();  
 
        // Here overriding works
        // and Child's m2() is called
        obj1.m2();
        
        System.out.println();
        
        Child obj2 = new Child();
        obj2.m2();
        obj2.m1();
	}

}

/// Example Statische

	//Java program to show that
	// if the static method is redefined by
	// a derived class, then it is not
	// overriding, it is hiding

class Parent {
    // Static method in base class
    // which will be hidden in subclass
    static void m1()
    {
        System.out.println("From parent "
                           + "static m1()");
    }
 
    // Non-static method which will
    // be overridden in derived class
    void m2()
    {
        System.out.println(
            "From parent "
            + "non - static(instance) m2() ");
    }
}
 


class Child extends Parent {
    // This method hides m1() in Parent
    static void m1()
    {
        System.out.println("From child static m1()");
    }
 
    // This method overrides m2() in Parent
    @Override public void m2()
    {
        System.out.println(
            "From child "
            + "non - static(instance) m2() ");
    }
}

