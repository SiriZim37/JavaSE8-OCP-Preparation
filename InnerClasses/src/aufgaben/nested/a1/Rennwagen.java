package aufgaben.nested.a1;

public class Rennwagen {

	private String  hersteller;
	private Fahrer  fahrer;
	private Motor	motor;
	
	public Rennwagen( String marke ) {
		this.hersteller = marke;
		this.motor = new Motor("Type1");		// implizit this.new Motor("Type1");
//		this.motor = this.new Motor("Type1");	// ok
	}	
	
	void setFahrer(Fahrer fahrer  ) {
		this.fahrer = fahrer;
	}
		
	void setMotor(Motor motor) {
		this.motor = motor;
	}	
	
	public Fahrer getFahrer() {
		return this.fahrer;
	}
	public Motor getMotor() {
		return this.motor;
	}
	
	public String toString() {

		return "Rennwagen " + this.hersteller + ". " + this.getFahrer(); 
	}
	
	public static class Fahrer{
		
		 private String vorname;
	     private String nachname;

	     public Fahrer(String vorname, String nachname) {
	         this.vorname = vorname;
	         this.nachname = nachname;
	     }

		public String getVorname() {
			return vorname;
		}

		public String getNachname() {
			return nachname;
		}

		public String toString() {
			return  "Fahrer: " +  this.vorname + " " + this.nachname ;
		}
	} // end of Fahrer
	
	public class Motor{
		
		 private String typ;

	     public Motor(String typ) {
	         this.typ = typ; 
	     }
	        
		public String toString() {
			return "Motor " + this.typ + " aus dem Rennwagen " 
//								+ Rennwagen.this.marke; // auch ok 
								+ hersteller;	// ok 
		}
	} // end of Motor

}
