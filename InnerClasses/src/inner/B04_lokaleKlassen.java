package inner;

public class B04_lokaleKlassen {

	/*
	 * lokale Klassen : 
	 * 
	 * 			- werden in einer Methode definiert
	 * 			- ist ab der Stelle der Definition
	 * 			  bis Zum Ende der Methode gültig
	 */
	public static void main(String[] args) {

		myMethod();
	}
	
	static void myMethod() {
		
//		Game g1 = new Game(); // cf :  Game cannot be resolved to a type ( unbekannte Klasse )
		
		class Game{
			
		}	// gültig ab hier bis zum Ende der Methode
		
		Game g1 = new Game();   // ok 
		
		
		abstract class AbstractGame2{
			 abstract void printMessage();
		}	
		class ConcreteInner extends AbstractGame2 {
	          void printMessage() {
	                System.out.println("Concrete implementation!");
	         }
	    }
//		Game2 g2 = new Game2();   // cf 
		
		AbstractGame2 instance = new ConcreteInner();
        instance.printMessage();
	}

}
