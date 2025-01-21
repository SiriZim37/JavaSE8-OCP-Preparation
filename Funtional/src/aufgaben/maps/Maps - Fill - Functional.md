# Aufgabe 'Maps - fill - functional'

Gegeben ist folgender Code:

		/*
		 * Wie oft kommt jeder String im Array vor?
		 */
		String[] arr = {
			"dd", "aa", "dd", "aa", "aa", "mm"	
		};
		
		Map<String, Integer> mapCounts = new HashMap<>();
		
		for(String s : arr) {
			Integer count = mapCounts.get(s);
			
			if(count==null) {
				mapCounts.put(s, 1);
			} else {
				mapCounts.put(s, count+1);
			}
		}
		
		System.out.println(mapCounts);

Die forEach-Schleife belegt die Map 'mapCounts' mit den gewünschten Informationen: wie oft jeder String in dem Array vorkommt.

#### A1.
Ändern Sie die forEach-Schleife. Benutzen Sie die Methoden `Map.computeIfAbsent` und `Map.computeIfPresent` um dasselbe Ergebnis zu erhalten.

#### A2.
Ändern Sie die forEach-Schleife. Benutzen Sie die Methode `Map.compute` um dasselbe Ergebnis zu erhalten.

#### A3.
Ändern Sie die forEach-Schleife. Benutzen Sie die Methode `Map.merge` um dasselbe Ergebnis zu erhalten.

