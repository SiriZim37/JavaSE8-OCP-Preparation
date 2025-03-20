package aufgaben.lambdas.v2;

public class CPU {

	private int anzahlKerne ; 
	private String hersteller;
	
	public CPU( int anzahlKerne , String hersteller) {
		this.anzahlKerne = anzahlKerne;
		this.hersteller = hersteller;
	}
	
	public int getAnzahlKerne() {
		return anzahlKerne;
	}

	public String getHersteller() {
		return hersteller;
	}

	@Override
	public String toString() {
		return hersteller + " [" + anzahlKerne+ "]";
	}
}
