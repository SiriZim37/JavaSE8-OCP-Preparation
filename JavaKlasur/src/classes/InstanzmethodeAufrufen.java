package classes;

class Hobbit{
	
	void laufen(){
		
	}
	
	void doStuff() {

		Hobbit h = this; 
		
		laufen();	// das ist this.laufen()
		this.laufen();
	}
	
	
	static void doMoreStuff() {
		
//		Hobbit h = this;	// cf
//		h.laufen();
		
//		laufen();		// cf
//		this.laufen();
		
	}
}

public class InstanzmethodeAufrufen {

	public static void main(String[] args) {
		Hobbit h = new Hobbit();
		h.laufen();
		
		Hobbit.doMoreStuff();
		h.doMoreStuff();

	}

}
