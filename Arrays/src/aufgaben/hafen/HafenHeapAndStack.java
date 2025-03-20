package aufgaben.hafen;

 class Schiff1 {
	
	private String name;
	
	Schiff1(){ this.name = "" ;} // set default empty name
	
	Schiff1(String name){
		this.name = name;
	}

	public String getName() {	   
		return name;
	}
	
	public void setName(String name) {
		this.name = name;		
	}
	
	public String toString() {
		return name;
	}
}

class Hafen1{
	static Schiff1[] arrSchiffe = new Schiff1[5]; /// Global variable : static gehört nicht zu Foo class
												 // wenn neu Objekt erzeugen , wird array nicht ändern 
												 // arr at position 0 wird ersezt
	
	int nextFreePosition = 0 ;
	
	void add(Schiff1 s) {
		arrSchiffe[nextFreePosition++] = s;
	}
	
	Schiff1 get(int index) {
		return arrSchiffe[index];
	}

}
class Hafen2{
	
	Schiff1[] arrSchiffe = new Schiff1[5];  // Not  static
	
	int nextFreePosition;
	
	void add(Schiff1 s) {
		arrSchiffe[nextFreePosition++] = s;
	}
	
	Schiff1 get(int index) {
		return arrSchiffe[index];
	}
}


public class HafenHeapAndStack {

	public static void main(String[] args) {
		
		Hafen1 h1 = new Hafen1();  /*  Heap:  A new Hafen1 object is created in the heap.
								   * Stack: A reference to this Hafen1 object is stored in the variable h1.
								   */
		
		Schiff1 s = new Schiff1("Aida"); /*  Heap: A new Schiff1 object is created in the heap with the name "Aida".
									      *  Stack: A reference to this Schiff1 object is stored in the variable s.
									      */
		
		h1.add(s); 
		/*  The add method of Hafen1 is called with the Schiff1 object s.
		*	Heap: The static array arrSchiffe in Hafen1 is updated to hold the reference to s at index 0.
		*	Stack: The nextFreePosition of the Hafen1 object h is incremented to 1.
		*/
		
		System.out.println(h1.get(0));
		/*
		 * The get method of Hafen1 is called with index 0.
		 *	Heap: The Schiff1 object at index 0 of the static array arrSchiffe (which is s with name "Aida") is retrieved.
		 *	Stack: The toString method of Schiff1 is called, returning "Aida".
		 *	Output: "Aida".
		 */
		Hafen1 h2 = new Hafen1(); /*  Heap:  A new Hafen1 object is created in the heap.
								   *   Stack: A reference to this Hafen1 object is stored in the variable h2.
								   */
		
		h2.add(new Schiff1("Titanic"));
		/*
		 *  A new Schiff1 object is created in the heap with the name "Titanic".
		 *	The add method of Hafen1 is called with this new Schiff1 object.
		 *	Heap: The static array arrSchiffe in Hafen1 is updated to hold the reference to the new Schiff1 object at index 0, replacing the previous reference to s.
		 *	Stack: The nextFreePosition of the Hafen1 object h2 is incremented to 1.
		 */
		System.out.println(h1.get(0));
		/*
		 *  The get method of Hafen1 is called with index 0.
			Heap: The Schiff1 object at index 0 of the static array arrSchiffe (which is now the "Titanic" ship) is retrieved.
			Stack: The toString method of Schiff1 is called, returning "Titanic".
			Output: "Titanic".
		 */

		/*
		 * 
		 * Key Points
		 *	The static array arrSchiffe in Hafen1 is shared across all instances of Hafen1. Therefore, changes made to arrSchiffe through one instance are reflected across all instances.
		 *	The stack holds references to objects and local variables, while the heap holds the actual objects.
		 *	When the "Titanic" ship is added, it replaces the "Aida" ship in the shared static array, demonstrating how static variables are shared among instances.
		 */
		
	
		Hafen2 hh1 = new Hafen2();
		
		Schiff1 ss1 = new Schiff1("Aida");
		
		hh1.add(ss1);
		
		System.out.println( hh1.get(0) ); // ?
		
		Hafen2 hh2 = new Hafen2();
		
		hh2.add(new Schiff1("Titanic"));
		
		System.out.println( hh1.get(0) );
			
	}

}
