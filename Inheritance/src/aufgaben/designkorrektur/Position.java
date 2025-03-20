package aufgaben.designkorrektur;

public class Position implements PositionInterface {
	public String artikelName = "";
	public int artikelMenge;
	public float artikelPreis;
	public float rabatt = 0.0f;
	

	public Position(String artikelName , int artikelMenge , float artikelPries  , float rabatt  ) {
		this.artikelName = artikelName;
		this.artikelMenge = artikelMenge;
		this.artikelPreis = artikelPries;
		this.rabatt = rabatt;
	}

	public Position(int artikelMenge , float artikelPries   ) {
		this.artikelMenge = artikelMenge;
		this.artikelPreis = artikelPries;
	}
	
	
	public Position(String artikelName , int artikelMenge , float artikelPries  ) {
		this(artikelName , artikelMenge , artikelPries , 0.0f);
	}

	public float getArtikelPreis() {
		return artikelPreis;
	}

	public void setArtikelPreis(float artikelPries) {
		this.artikelPreis = artikelPries;
	}

	public int getArtikelMenge() {
		return artikelMenge;
	}

	public void setArtikelMenge(int artikelMenge) {
		this.artikelMenge = artikelMenge;
	}

	
	public String getArtikelName() {
		return artikelName;
	}

	public void setArtikelName(String artikelName) {
		this.artikelName = artikelName;
	}

	public float getRabatt() {
		return Math.round(rabatt * 100) / 100.0f;
	}
	

	public void setRabatt(float rabatt) {
		this.rabatt = rabatt;
	}
	
	
	@Override
	public String toString() {
		String fmt = "|%5s%20s%5s %10s €%10s %10s €|"; 
		int i = 0 ;
		return String.format(fmt, i + ".", artikelName, artikelMenge, 
               artikelPreis,  getRabatt(), getNettoPreis());
	}

	@Override
	public float getNettoPreis() {
		return (artikelPreis*artikelMenge) * (1 - rabatt);
	}
	
}
