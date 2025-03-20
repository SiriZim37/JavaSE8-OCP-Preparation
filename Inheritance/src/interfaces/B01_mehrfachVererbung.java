package interfaces;

class ClassA {}

class ClassB{}

//class C1 extends ClassA , ClassB { }			// cf 
//class C2 extends ClassA extends ClassB { }	// cf
//class C2 extends ClassA , extends ClassB { }	// cf

interface Moveable{
	void move();
}

interface Doable{
	void doit();
}

class Person implements Moveable , Doable {

	@Override
	public void doit() {
		System.out.println( "doit");
	}

	@Override
	public void move() {
		System.out.println( "move");
		
	}
	
}

public class B01_mehrfachVererbung {
	/*
	 *  - eine Klasse kann nur eine andere Klasse erweitern
	 *  - eine Klasse kann mehrere Interfaces implementieren
	 *  
	 *  - Mit 'implement' entsteht auch eine IS-A-Beziehung
	 */
	
	
	public static void main(String[] args) {
	
		Person p = new Person();
		
		Moveable m = p ;  // Movable <- IS-A <- Person
		Doable   d = p ;  // Doable <- IS-A <- Person
		
		m.move();
		p.doit();
	}

}
