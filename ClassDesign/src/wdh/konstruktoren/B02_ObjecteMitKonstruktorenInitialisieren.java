package wdh.konstruktoren;

class Auto{
	int baujahr; 
	
//	 public Auto() {		 // default-Konstruktor
//		 super();  			 // super();  generiert !
//		 this.baujahr = 0 ;  // implizit generiert 
//	 }
	
}

class VM extends Auto{
	String modell; 
	
//	 public VM() {			// default-Konstruktor
//		 super();  			// super();  generiert !
//		 this.modell = null ;  // implizit generiert 
//	 }
	
	
	
}

class Mazda extends Auto{
	int preis; 
	
	 Mazda() {			// explizit-Konstruktor
				 
		 this(2000);   			// cf : cannt use with super();
	 }
	 
	 Mazda(int preis) {		
		 //super();  				// super();  generiert !
		 this.preis = preis;
	 }
	 

}

class Auto_A{
	
	 Auto_A(String s) {			// keine default-Konstruktor
//		 super();  			      //  cf :  super() must  first statement in a constructor
		 						 //  public Auto(){ }
	 }
	
}

/*
class VM_A extends Auto_A{	  // cf : It need  call super((String))
	
	//	VM_A(){ 			
	//		super("");		// ok
	//	}
	
}
*/



public class B02_ObjecteMitKonstruktorenInitialisieren {

	public static void main(String[] args) {
		new VM();
		new Mazda(3333);
		new Mazda();
	}

}
