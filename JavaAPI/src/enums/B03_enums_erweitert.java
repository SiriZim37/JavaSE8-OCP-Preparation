package enums;

public class B03_enums_erweitert {

	public static void main(String[] args) {
		
		CoffeSize ersterKaffee = CoffeSize.MAXIMUM;
		CoffeSize zweiterKaffee = CoffeSize.BIG;
		CoffeSize dritterKaffee = CoffeSize.MEDIUM;
		int summeKaffee = ersterKaffee.getMl() + zweiterKaffee.getMl() + dritterKaffee.getMl();
		System.out.println("ersterKaffee = " + ersterKaffee);
		System.out.println("zweiterKaffee = " + zweiterKaffee);
		System.out.println("dritterKaffee = " + dritterKaffee);
		System.out.println("summeKaffee = " + summeKaffee);
	}

}
// einem könen eigene Variable haben
// enum können eigene Methode haben
// man kann im enum einen Konstruktor definieren
// man kann in einem enum Methoden überscreiben
// man kann nut für eine Konstantane im enum eine Methode überschreieben
enum CoffeSize{
	
//	MEDIUM(200) , BIG(300) , MAXIMUM(400);
	
	MEDIUM(200) , BIG(300) , MAXIMUM(400) { //  man kann nut für eine Konstantane im enum eine Methode überschreieben
		 @Override
			public String toString() {
				return "**********" + super.toString() + "*********" ;
			}
	};
	
	private int ml;
	
	 private CoffeSize(int ml) { // man kann im enum einen Konstruktor definieren
		 						 // private implizit , enum-Konstruktor sind immer private
		this.ml = ml;
	}
	 
	 public int getMl() { // enum können eigene Methode haben
		return ml;
	}
	 
	 @Override
	public String toString() {
		return this.name() + " , " + this.ml + " ml" ;
	}
}
