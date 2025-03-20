package aufgaben.designkorrektur;



public class Warenkorb implements PositionInterface {
	
	private final int MAX_KORB = 10;
	public Position[] positionen;
	

	public Warenkorb() {
		this.positionen = new Position[MAX_KORB];
	}
	
	public static int nextPosition = 0; 
	
	public void addPosition(Position pos) {
		positionen[nextPosition++] = pos ;
	}
	

	public void printAllArtikel() {
		for(Position val : positionen) {
			if(val !=null) 
				System.out.println(val);
		}
	}


	@Override
	public float getNettoPreis() {
		float nettoPreis = 0 ; 
		for(Position val : positionen) {
			if(val !=null)
				nettoPreis += val.getNettoPreis() ;
		}
		return nettoPreis ;
	}
	
	
}
