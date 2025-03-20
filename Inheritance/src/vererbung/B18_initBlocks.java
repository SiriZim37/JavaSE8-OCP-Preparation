package vererbung;


class Bird {
	
	// init block
	{
		System.out.println("Bird. init");
	}
	
	Bird(){
		/*
		 * 	vom Compiler generiert :
		 * 
		 * 	super();
		 * 	{
		 * 		System.out.println("Bird. init");
		 * 	}
		 */
		System.out.println("Bird()");
		
	}
	
	Bird(int x){
		/*
		 * 	vom Compiler generiert :
		 * 
		 * 	super();
		 * 	{
		 * 		System.out.println("Bird. init");
		 * 	}
		 */
		System.out.println("Bird(int)");
	}
	
	Bird(String x){
		this();
		/*
		 * 	vom Compiler generiert :
		 * 
		 * 	super();
		 * 	{
		 * 		System.out.println("Bird. init");
		 * 	}
		 */
		System.out.println("Bird(String)");
	}
}

public class B18_initBlocks {

	/*
	 * 	  - Init-Block wird die Konstruktoren
	 * 		nach dem Super-Konstruktor-Aufruf 
	 * 		intelligent integriert.
	 * 		
	 */
	
	public static void main(String[] args) {
		
		new Bird();
		System.out.println("-------------");
		new Bird();
		System.out.println("-------------");
		new Bird(12);
		System.out.println("-------------");
		new Bird("A");
		System.out.println("-------------");

	}

}
