# Aufgabe 'reduce - TextStatistics'

#### A1.

Realisieren Sie bitte mit der Klasse `TextStatisticsImpl`, die den an den Konstruktor übergebenen Text analysieren kann, folgendes Interface:

		public interface TextStatistics {
			
			public int getCountChars();
			
			public int getCountSpecialChars();
			
			public int getCountLetters();
			
			public Optional<String> getLongestWord();
		}

Verwenden Sie wenn es geht beim Realisieren der Methoden die funktionalen Streams.

> Zur Vereinfachung dürfen die Ziffern auch als Sonderzeichen betrachtet werden.

> Um die Wörte im Text zu finden, dürfen Sie zur Vereinfachung davon ausgehen, 
> dass die einzelnen Wörter voneinander mit Leerzeichen getrennt werden und 
> andere Sonderzeichen beinhalten können (oder komplett aus Sonderzeichen bestehen können). 
> Dann wird folgende Zeile ein Array aus einzelnen Wörtern erstellen:

		String[] words = text.split(" ");	// Leerzeichen als Trenner

#### A2.

Verwenden Sie alle überladenen Varianten der Stream-Methode `reduce` um mit jeder Variante die `TextStatistics` für ein Stream von Texten (Strings) zu erhalten. So z.B. könnte der Test für die Variante 3 der Methode `reduce` aussehen:

	String[] input = { 
		"String 1",
		"Heute ist Montag",
		"Java ist toll!",
		//...
	};
	
	//...
	TextStatistics stats = Arrays.stream(input).reduce(idt, acc, cmb);
	//...

Das Ergebnis soll die Gesamtstatistiken alle Strings des Arrays beinhalten.
