# Aufgabe 'Generics - Platzhalter - Functional'

Gegeben ist der Code:

		Predicate<Number> istPositiv = n -> n.doubleValue() > 0;
		Predicate<Integer> istGerade = x -> x%2==0;
		Predicate<String> istLeer = s -> s.isEmpty();
		
		Predicate< PARAMETRISIERUNG-HIER > p0;
		
		p0 = istPositiv; // muss kompilieren
		p0 = istGerade; // darf nicht kompilieren
		p0 = istLeer; // darf nicht kompilieren
		
		p0.test(22); // muss kompilieren
		
		Predicate< PARAMETRISIERUNG-HIER > p1;
		
		p1 = istPositiv; // muss kompilieren
		p1 = istGerade; // muss kompilieren
		p1 = istLeer; // darf nicht kompilieren
		
		p1.test(22); // muss kompilieren
		
		Predicate< PARAMETRISIERUNG-HIER > p2;

		p2 = istPositiv; // muss kompilieren
		p2 = istGerade; // muss kompilieren
		p2 = istLeer; // darf nicht kompilieren
		
		p2.test(22); // darf nicht kompilieren
		
 
Parametrisieren Sie bitte die Variablen p0, p1 und p2 so, dass die Anforderungen in den Kommentaren erfüllt sind.