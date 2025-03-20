package aufgaben.designkorrektur;

public class Test {


	private final static float MWST = 0.19f;
	
	public static void main(String[] args) {
		
		Position p1 = new PositionBuilder()
				.artikelName("Logitech Maus")
				.artikelMenge(2)
				.artikelPreis(19.99f)
				.build();	
	
		Position p2 = new PositionBuilder()
				.artikelName("Cherry Tastatur")
				.artikelMenge(1)
				.artikelPreis(25.00f)
				.build();	

		Position p3 = new PositionBuilder()
				.artikelName("Laptop")
				.artikelMenge(1)
				.artikelPreis(500.00f)
				.rabatt(0.15f)
				.build();	
		

		Warenkorb waren = new Warenkorb();
		waren.addPosition(p1);
		waren.addPosition(p2);
		waren.addPosition(p3);
		
				
		Bestellung b1 = new Bestellung(waren , MWST);	
		b1.printBestellung();
	}

}
