package exceptions;



@SuppressWarnings("serial")
class MyUncheckedExeption extends RuntimeException{}

@SuppressWarnings("serial")
class SpingExeption extends Exception{}

@SuppressWarnings("serial")
class AusrutchenBeimSpringCheckedExeption extends SpingExeption{}

class Tier{
	void laufen() { System.out.print("Tier läuft"); }
	
	int springen() throws SpingExeption{ return 0 ;}
	
	private void running() { System.out.print("Tier läuft"); }
}


class Katze extends Tier{
	void laufen() throws ArithmeticException  {}	// ok , (Überschreiben) uncheck exception
	
	public void running() { System.out.print("Katze läuft"); }
}
class Hund extends Tier{
//	void laufen() throws MyCheckedExeption  {}	//  cf : (Überschreiben) checked , 
												//  die es in Tier/laufen nicht gibt
	 
	int springen() throws SpingExeption { return 5 ; } // ok : (Überschreiben) checked , 
														   // die es in Tier/springen  gibt
	private void running() { System.out.print("Hund läuft"); }
}

class Affe extends Tier{
//	private  void laufen() {}	// cf
//	protected void laufen() {}	// ok 
//	public void laufen() {}		// ok 
	void laufen()   {}			// ok , (Überschreiben)  gar keine Exception
	
	int springen() throws AusrutchenBeimSpringCheckedExeption { return 25; } // ok : (Überschreiben) ist MyCheckedExeption  
	   															 //  in Tier/springen  erlaubt.
	
}

class Maus extends Tier{
//	int springen() throws IOException { return 1; } 	// cf : checked , die es in 
														// Tier/springen nicht gibt.
}



class SubExceptions extends Exception{}
class SubSubExceptions extends SubExceptions{}

class CC {	void doStuff() throws SubExceptions {}	}
class CC1 extends CC {	void doStuff() throws SubExceptions {}	}
class CC2 extends CC {	void doStuff() throws SubSubExceptions {}	}
//class CC3 extends CC {	void doStuff() throws Exception {}	}
class CC4 extends CC {	void doStuff(int x) throws Exception {}	}
class CC5 extends CC {	void doStuff(int x) {}	}

public class UeberschreibenUndException {

	public void testException() throws Exception{ throw new RuntimeException("test"); }
	
	public static void main(String[] args) throws SubExceptions  {

		/*
		 * Regeln beim Überschreiben oder Implementieren
		 * einer abstrakten Methoden
		 * 
		 * 1.	Sichtbarkeit nicht ändern
		 * 
		 * 2. Rückgabetyp nicht ändern
		 * 
		 * 3. Keine zusätzlichen checked Exceptions deklarieren.
		 */
		/*
		 * Diese der Regeln ermöglichen es, den universellen Code zu entwickeln : 
		 */
		Tier t = new Affe();
		t.laufen();
		
		try {
			int x = t.springen();
		} catch (SpingExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		try {
//			new UeberschreibenUndException().testException();	// Unhandled exception type Exception
//		} catch (NullPointerException e) {	
//			throw e;
//		}
		
		try {
			throw new SubSubExceptions();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			throw new SubExceptions();
		}

		
		

	}

}
