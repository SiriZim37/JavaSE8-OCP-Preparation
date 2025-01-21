# Aufgabe 'Generics - Tonträger'

Gegeben sind folgende Typen:

	interface Tontraeger {}
	
	class Schallplatte implements Tontraeger {}
	class Tonband implements Tontraeger {}
	class CD implements Tontraeger {}
	
	class Abspielgeraet {
		void abspielen(Tontraeger t) {}
	}

- Ändern Sie die Klasse `Abspielgeraet` so, dass 
    - Abspielgerät nur für Schallplatten möglich ist 
    - Abspielgerät nur für CDs möglich ist
    - Kein Abspielgerät für Strings möglich ist

- Bitte testen Sie die Lösung. Überprüfen Sie dabei ob Kompilerfehler 
Sie vor falschen Typen schützen.
