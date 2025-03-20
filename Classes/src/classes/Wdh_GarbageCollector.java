package classes;


class Foo {
	Bar bar ; 
}

class Bar {
	Foo foo;
}

public class Wdh_GarbageCollector {

	public static void main(String[] args) {
		
		Foo foo = new Foo();
		Bar bar = new Bar();
		
		foo.bar = bar;   
		bar.foo = foo;

		
		foo = null;  // :  keine Autos-Objekt im Heap steht dem GC zur Verfügung 
		bar = null;  // :  zwei Autos-Objekt im Heap steht dem GC zur Verfügung 
	
		/*
		 * 
		 * keine Objekt werden benutzt!!! dann löscht alles
		 * 
		 */
	}
	
	

}
