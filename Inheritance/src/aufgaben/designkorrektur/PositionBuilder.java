package aufgaben.designkorrektur;


public class PositionBuilder {
	public float artikelPreis;
	public int artikelMenge;
	public String artikelName;
	public float rabatt = 0;
	
	public PositionBuilder artikelName(String artikelName) {
		this.artikelName = artikelName;
		return this;
	}

	public PositionBuilder artikelPreis(float artikelPreis) {
		this.artikelPreis = artikelPreis;
		return this;
	}
	
	public PositionBuilder artikelMenge(int artikelMenge) {
		this.artikelMenge = artikelMenge;
		return this;
	}
	
	public PositionBuilder rabatt(float rabatt) {
		this.rabatt = rabatt;
		return this;
	}
	
	 public Position build() {
         return new Position(artikelName, artikelMenge, artikelPreis, rabatt);
     }
}
