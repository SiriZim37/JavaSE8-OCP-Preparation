package interfaces;


interface Fahrbar{
	void start();
	void stop();
//	default void fahren();	// cf : default-Methode braucht den Rümpf(body) !!! !
	default void fahren() { // OK
		start();
		System.out.print("fahren ");
		stop();
	
	} 
}

//class Fahrzeug implements Fahrbar{	// cf :  Klass ist nicht abstract , 
//										//deshalb darf kein abstrakt definieren.
//}

//abstract class Fahrzeug implements Fahrbar{	} // OK : 

class Fahrzeug implements Fahrbar{

	public void start() {	// die Sichtbarkeit verschäfen. Es muss Public sein!
		System.out.print("start ");
	}

	public void stop() { // die Sichtbarkeit verschäfen. Es muss Public sein!
		System.out.print("stop ");
	}
	
}


public class WdhDefault {

	public static void main(String[] args) {
		
		Fahrbar v1 = new Fahrzeug();
		v1.fahren(); 	// start fahren stop 
	}

}
