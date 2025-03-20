package vererbung;

final class MyString {
	/*
	 * final-Klasse kann nicht erwitert werden
	 */
}

//final class MycoolString extends MyString{} // cf : Basisklasse ist abstract

class Blume{

	private int preis;
	
	public Blume(int preis) {
		this.preis = preis;
	}
	/*
	 * final-Methode darf nicht überschreiben werden
	 */
	public final void setPreis(int preis) {
			this.preis = preis;
	}
		
	public int getPreis() {
		return preis;
	}
		

}

class WiesenBlume extends Blume{

	public WiesenBlume(int preis) {
		super(preis);
	}
	

	 @Override
	public int getPreis() {
		return super.getPreis();
	}
	 
	 
//	 @Override
//	 public final void setPreis(int preis) { // setPreis ist final
//			this.preis = preis;
//	}
}


public class B14_final {

	public static void main(String[] args) {
	
		Blume b = new WiesenBlume(100);
		System.out.println(b.getPreis());

	}

}
