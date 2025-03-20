package aufgaben.designkorrektur;



public class Bestellung {
	private Warenkorb warenkorb;
	private float mwSt;
	
	public Bestellung(Warenkorb warenkorb , float mwSt) {
		this.warenkorb = warenkorb;
		this.mwSt = mwSt;
	}
	
	public float getGesamtPrise() {
		float nettoPreis = warenkorb.getNettoPreis();
		float gesamtPreis = nettoPreis *(1+ mwSt);
		return gesamtPreis;
	}
	
	public void printBestellung() {
		int breit = 68; 
		System.out.println(getSplit(breit));
		
		String fmt = "|%5s%20s%5s %10s  %10s %10s  |"; 
	
		System.out.format(fmt ,"NO.", "Bestellung" , "menge" ,  "p/E" , "Rabatt" , "P");
		
		System.out.println();
		
		System.out.println(getSplit(breit));
		
		warenkorb.printAllArtikel();
		
		System.out.println(getSplit(breit));
		
		String fmt2 = "%50s € %10s "; 
		System.out.format(fmt2 , getGesamtPrise() , " Gesamt Bestellungpreis" );
	}
	
	private String getSplit(int lenght) {
		
		StringBuilder spilt = new StringBuilder();
		int i = 0 ; 
		while(i<lenght) {
			if(i==0 || i==lenght-1) 
				spilt.append('|');
			else
				spilt.append('-');
			i++;
		}
		return spilt.toString();

	}
	
}
