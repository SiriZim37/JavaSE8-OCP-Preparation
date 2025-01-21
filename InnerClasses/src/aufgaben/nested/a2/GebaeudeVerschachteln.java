package aufgaben.nested.a2;

import aufgaben.nested.a2.Gebaeude.Stockwerk;

public class GebaeudeVerschachteln {
    
	private String strassennamen;
	private int hausnummer;
	private Stockwerk[] stockwerke;
	
	public GebaeudeVerschachteln(String strassennamen , int hausnummer , int  stockwerkeAnzahl , int raeumeProStockwerk) {
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
	    
	 public Stockwerk.Raum getRaum(int stockwerkNr, int raumNr) {
		  Stockwerk stockwerk = getStockwerk(stockwerkNr);
		 return stockwerk.getRaum(raumNr);
	 }
	   
	
	class Stockwerk {
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
	                throw new IllegalArgumentException("Ungültige Raumnummer: " + raumNr 
	                    + "\nBitte geben Sie eine Raumnummer zwischen 0 und " 
	                    + (this.raeume.length - 1) + " für Stockwerk " + stockwerkNr + " ein.");
	            }
	            return this.raeume[raumNr];
	    }
			
        class Raum {
        	private int stockNr;
    		private int raumNr;
    		
    		public Raum(int stockNr ,  int raumNr ) {
    			this.stockNr = stockNr;
    			this.raumNr = raumNr;
    		}
    		
    		public String toString() {
    		
    			return  "Raum " 
    					+ Stockwerk.this.stockwerkNr +  "."  // oder + this.stockNr +  "." 
    					+ this.raumNr  + " / " 
    					+ strassennamen + ". "  // Gebaeude.this.strassennamen
    					+ hausnummer ;			 // Gebaeude.this.hausnummer
    		}
        	
         }
    }
}


