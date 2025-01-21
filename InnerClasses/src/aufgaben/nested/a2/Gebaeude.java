package aufgaben.nested.a2;


/*
 *  Gabäude hat 1 oder mehrere Stockwerke
 *  1 Stockwerk hat 1 oder mehrere Stockwerke (mindestens 1 Raum) 
 */

public class Gebaeude {

	private String strassennamen;
	private int hausnummer;
	private Stockwerk[] stockwerke;

	public Gebaeude(String strassennamen , int hausnummer , int  stockwerkeAnzahl , int raeumeProStockwerk) {
		if (stockwerkeAnzahl < 1) {
	        throw new IllegalArgumentException("Ein Gebäude muss mindestens 1 Stockwerk haben.");
	    }
	    if (raeumeProStockwerk < 1) {
	        throw new IllegalArgumentException("Ein Stockwerk muss mindestens 1 Raum haben.");
	    }
	        
		this.strassennamen = strassennamen;
		this.hausnummer = hausnummer;
		this.stockwerke = new Stockwerk[stockwerkeAnzahl];
		
		for(int i = 0 ; i < stockwerke.length ; i++) {
			stockwerke[i] = new Stockwerk(i , raeumeProStockwerk);
		}
	}

	public Stockwerk getStockwerk(int stockwerkNr) {
		if (stockwerkNr < 0 || stockwerkNr >= stockwerke.length) {
			String errMsg = String.format("Ungültige Stockwerksnummer: %d%nBitte geben Sie Stockwerksnummer zwischen %d und %d ein.", stockwerkNr ,  0 ,this.stockwerke.length - 1);
			throw new IllegalArgumentException(errMsg);
		}
		return this.stockwerke[stockwerkNr];
	}
	
	
    public Raum getRaum(int stockwerkNr, int raumNr) {
        Stockwerk stockwerk = getStockwerk(stockwerkNr);
        return stockwerk.getRaum(raumNr);
    }
 
    public String toString() {
        return "Gebäude " 
			    + strassennamen 	// this.strassennamen
			    + " Nr. " 
			    + hausnummer;  		// this.hausnummer
    }
    

	class Stockwerk{
		private int stockwerkNr ;
		private Raum[] raeume;
		
		public Stockwerk(int stockNummer , int raeumeAnzahl ) {
			if (raeumeAnzahl < 1) {
	             throw new IllegalArgumentException("Ein Stockwerk muss mindestens 1 Raum haben.");
	        }
			 
			this.stockwerkNr = stockNummer;
			this.raeume = new Raum[raeumeAnzahl];
			
			for(int i = 0 ; i < raeumeAnzahl ; i++) {
				this.raeume[i] = new Raum(stockNummer , i );
			}
		}	

		public Raum getRaum(int raumNr) {
			if (raumNr < 0 || raumNr >= raeume.length) { 
				String errMsg = String.format("Ungültige Raumnummer: %d%n"
						+ "Bitte geben Sie Raumnummer zwischen %d und %d "
						+ "für Stockwerk  %d ein.", stockwerkNr  ,  0 ,this.raeume.length - 1 , stockwerkNr);
				throw new IllegalArgumentException(errMsg);
	        }
			return this.raeume[raumNr];
		}
		
		public String toString() {
			 return "Stockwerk " 
					 	+ stockwerkNr 	// this.hausnummer
					 	+ " mit " 
					    + raeume.length // this.raeume.length
					    + " Räumen.";
		}
	}
	
	class Raum{
		private int stockNr;
		private int raumNr;
		
		public Raum(int stockNr ,  int raumNr ) {
			this.stockNr = stockNr;
			this.raumNr = raumNr;
		}
		
		public String toString() {
		
			return "Raum " 
					+ this.stockNr +  "." 
					+ this.raumNr  + " / " 
					+ strassennamen + ". "  // Gebaeude.this.strassennamen
					+ hausnummer ;			 // Gebaeude.this.hausnummer
		}
	}

}
