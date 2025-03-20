package inheritance;

//abstrct final class C100{}	// final = davon darf nicht geererbt werden
								// abstract = Basisklasse um davon zu Erben

abstract class C01{
//	abstract void m1() {};	 // cf : abstract muss kein Rumpf
	
//	abstract final void m2(); 	// cf : abstract final ( Final kann nicht erben )
	
	private final void m3() {}	// ok aber Wiedersprich kompiliert 
								// private wird nucht vererbt
								// final : nicht überschreibbar
}



class AgedP{
	AgedP() {
		
	}
	public AgedP(int x) {

	}
}

class Kinder extends AgedP{
	
	public Kinder(int x) {
		super();
	}
	
}

public class Widerspruch {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
