package exceptions;

public class B06_Excepttions_Override {

	public static void main(String[] args) {
	

	}

}
class Fahrzeug{
	
	public  void fortbewegen() throws ArithmeticException{
		if(Math.random() >= 0.5) {
			int d = 7/0;
			System.out.println(d);	
		}
	}
	
	public Fahrzeug create() throws InterruptedException  { // oder  throws Exception 
		Thread.sleep(500);
		return new Fahrzeug();
	}
	
	

}

class Auto extends Fahrzeug{
	
	// Beim Überschreiben (@Override) einer Methode dürfen neue oder auch breitere Runtimeexceptions deklariert werden
	//  breitere Runtimeexception >> Supertype
	@Override
	public  void fortbewegen() throws RuntimeException { // Es kann nicht public los lassen , es wird compiler fehler. Und es muss gleich Rückgabetype
		if(Math.random() >= 0.5) {
			System.out.println("vorwärts rollen mit Elcktromotor");
		}
	}
	// Beim Überschreiben (@Override) einer Methode dürfen keine neuen! oder auch breitere checked Exceptions! deklariert werden
	@Override
	public Auto create()  throws InterruptedException { // cf : // Beim Überschreiben (@Override) einer Methode dürfen neue oder auch breitere Runtimeexceptions deklariert werden
													   // ok : wenn in Fahrzeug hat  throws InterruptedException 
		Thread.sleep(500);
		return new Auto();
	}
	
	/* #1  TEST */ 
//	@Override
//	public Auto create() throws Exception { // : cf  Exception Exception is not compatible with throws clause in Fahrzeug.create()
//											// weil  create() in Fahrzeug throw InterruptedException , die nicht breite als  Exception
//		Thread.sleep(500);
//		return new Auto();
//	}
	
}