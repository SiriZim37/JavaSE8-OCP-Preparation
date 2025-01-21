package wdh.konstruktoren;

class Person{
	
	{
		System.out.print("init 1 ");
	}
	
	Person() {							// default- Konstruktor 
		//super();  					//  implizit super(); generiert !
		// System.out.print("init 1 ");
		// System.out.print("init 2 ");
		System.out.print("Person()-");
	}
	
	Person(int x) {						// explizit- Konstruktor 
		//super();  					//  implizit super(); generiert !
		// System.out.print("init 1 ");
		// System.out.print("init 2 ");
		System.out.print("Person(int x)- ");
	}
	
	Person(String s) {			// explizit- Konstruktor 
		//super();  					//  implizit super(); generiert !
		// System.out.print("init 1 ");
		// System.out.print("init 2 ");
		System.out.print("Person(String s)- ");
	}
	
	Person(String s1 , String s2) {			// explizit- Konstruktor 
		//super();  					//  implizit super(); generiert !
		// System.out.print("init 1 ");
		// System.out.print("init 2 ");
		this();
		System.out.print("Person(String s)- ");
	}
	
	
	{
		System.out.print("init 2 ");
	}

}


public class B04_InitBlocks {

	public static void main(String[] args) {
		
		new Person();					// init 1 Person()
		
		System.out.println();
		
		new Person("moin");				// init 1 init 2  Person(String s) 
		
		System.out.println();
		
		new Person("moin","moin");		// init 1 init 2 Person() Person(String s) 

	}

	{
		{ int x = 3 ; }
	}
}
