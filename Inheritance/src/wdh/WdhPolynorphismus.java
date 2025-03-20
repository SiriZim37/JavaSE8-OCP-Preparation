package wdh;



class Animal{
	String name() { return "noname";}
}


class Cat extends Animal {
	public String name() { return "Tom";} // ok : Sichtbarkeit entshärfen 
}

class Mouse extends Animal {
//	protected void name() {} // cf : Rückgabetyp darf nicht ändern.
	protected String name() {return "Jerry";}
}


public class WdhPolynorphismus {

	public static void main(String[] args) {
		
		Animal a = new Animal(); // Aufruf Instanz Methode
		System.out.println(a.name()); // noname

		a = new Cat();
		System.out.println(a.name()); // Tom

		a = new Mouse();
		System.out.println(a.name()); // Jerry
		
		System.out.println(((Animal)a).name()); // den Typ von den Objekt kann nicht  andern.
		
		System.out.println(((Animal)(Animal)(Animal)a).name()); // Jerry
		
		System.out.println(a); // Das Objekts Referenz ist wdh.Mouse@6a6824be
		
		System.out.println(((Cat)a).name()); // ClassCastException : Cat und Mouse sind Geschwisterklassen
		
		
	}

}
