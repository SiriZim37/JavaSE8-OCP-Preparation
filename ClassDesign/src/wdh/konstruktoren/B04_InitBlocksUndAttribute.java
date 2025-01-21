package wdh.konstruktoren;

class Blume{
	int a ;
	int b = 12; 
	int c = 42; 
	
	public Blume(int c) {
		/* super();  									//  implizit super(); generiert !
		 * this.c = 0; 
		 * this.b = 12;
		 * this.c = 42;  >> this.c = 111; >> this.c = 75
		 */
		this.c = c;
		
	}
	
	{
		c = 111; 	// this.c = 111
	}
}


public class B04_InitBlocksUndAttribute {

	public static void main(String[] args) {
		System.out.println( new Blume(75).c);  // zuerst c = 111 und danach z wurde zugewiesen dann c = 75 
	}
}
