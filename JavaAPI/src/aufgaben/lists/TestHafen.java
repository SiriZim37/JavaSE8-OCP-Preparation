package aufgaben.lists;



public class TestHafen {

	
	public static void main(String[] args) {

		
		Hafen h = new Hafen();
		
		//1. neue 12 Schiffe ohne Name
		System.out.println("1. neue 12 Schiffe ohne Name");
		for (int i = 0; i < 12; i++) {
			 h.hinzufügen(new Schiff(""));
		}
		printSchiff(h);
		

		//2. neue 3 Schiffe mit Name
		System.out.println("2. neue 3 Schiffe mit Name");
		h.hinzufügen(new Schiff("S1"));
		h.hinzufügen(new Schiff("S2"));
		h.hinzufügen(new Schiff("S3"));
	
		printSchiff(h);
		 
		//------------ TestHafen ------------
		//3. neue 100 Schiff ankern
		System.out.println("3. neue 100 Schiff ankern");
		
		int anzehlWarteschlange = 0 ;
		for (int i = 0; i < 100; i++) {
			if(!h.hinzufügen(new Schiff(""))){
				anzehlWarteschlange++;
			}
		}
		printSchiff(h);
		System.out.println("Anzahl der Schiffe in der Warteschlange : " + anzehlWarteschlange + "\n" );

		
		
		// 4. Shiff index 5 und 14 verlassen
		System.out.println("4. Shiff index 5 und 14 verlassen");
		h.shiffVerlassen(5);
		h.shiffVerlassen(11);
		
		printSchiff(h);
		
		//5. Finden schiff am Hafen
		System.out.println("5. Finden schiff 'S2' am Hafen");
		int findIndex = h.schiffFinden(new Schiff("S2"));
		System.out.println("S2 : " + findIndex);
		
		findIndex= h.schiffFinden("");
		System.out.println("\"\" : " + findIndex);
		
		findIndex= h.schiffFinden("S1");
		System.out.println("S1 : " +findIndex);


	}
	
	static void printSchiff(Hafen h) {
		StringBuilder sb = new StringBuilder();
	    for (Schiff s : h) {
	        sb.append(s).append(" | ");
	    }
	    if (sb.length() > 0) {
	        sb.setLength(sb.length() - 3);
	    }
	    System.out.println(sb.toString() + "\n" + h + "\n");

	}


}
