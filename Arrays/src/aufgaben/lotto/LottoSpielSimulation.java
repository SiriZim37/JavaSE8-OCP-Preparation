package aufgaben.lotto;

public class LottoSpielSimulation {

	public static void main(String[] args) {


  
		int anzahlKugel = 7 ; 
		int anzahlKugelGesamt = 49 ; 
		
		LottoSpiel lotto = new LottoSpiel(anzahlKugel , anzahlKugelGesamt );
		System.out.println( lotto ); // Spiel 7 aus 49. Es gab noch keine Ziehung
		
		lotto.ziehen();
		System.out.println(lotto);
		
		
		LottoTipp tipp = new LottoTipp(anzahlKugel, anzahlKugelGesamt);
		System.out.println( tipp ); // Tipp 7 aus 49. Noch nicht abgegeben
	
		
		tipp.abgeben();
		System.out.println(tipp);
		

		int gewinn = lotto.vergleichenVonDozent(tipp);
		 System.out.format("Gewinn: %d Euro\n" , gewinn);
		
		
		 System.out.println("\n*****");
		 endlichVieleRichtige();
		
		// Optional: Simulate 100000 games with the same tip
		System.out.println("----------------Optional------------------------");
				
		int totalPrize = 0 ;
		int totalcost = 100000; // 100000 mal Lotto Spiel , each costing 1 Euro
		for(int i =0 ; i< totalcost ; i++) {
			lotto.ziehen();
//			System.out.println(lotto);
			totalPrize+=lotto.vergleichen(tipp);
		}
		
		System.out.format("Gesamtgewinn nach %d Spielen: %d Euro\n" , totalcost , totalPrize);
		System.out.format("Kosten: %d Euro\n" , totalcost  );
		System.out.format("Netto-Gewinn  : %d Euro\n" , (totalPrize - totalcost));

		
		 
	}
	
	static void endlichVieleRichtige() {
		int anzahlKugel = 7;
		int anzahlKugelGesamt = 49;
		LottoSpiel lotto = new LottoSpiel(anzahlKugel, anzahlKugelGesamt);
		LottoTipp tipp = new LottoTipp(anzahlKugel, anzahlKugelGesamt);
		
		int gewinn = 0;
		long count = 0;
		while(gewinn < 100) {
			count++;
			lotto.ziehen();
			tipp.abgeben();
			gewinn = lotto.vergleichen(tipp);
		}
		
		System.out.println("Endlich nach " + count + " Spiel(en)!");
		System.out.println(lotto);
		System.out.println(tipp);
		System.out.println("Gewinn: " + gewinn);
	}
	
	
	
}
