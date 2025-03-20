# Aufgabe 'Lambdas und Predicate'

Das Interface `Predicate` aus dem Package 'java.util.function' kann verwendet werden, um eine Art Test-Funktion zu definieren. Z.B.:

	Predicate<String> stringTester = s -> s.length() > 3;
	boolean laengerAlsDreiZeichen = stringTester.test("Hallo Welt"); // true

###### A1.
Erzeugen Sie eine Methode `printIf(Integer[], Predicate<Integer>)`, die nur die Integer aus dem Array (Parameter 1) ausgibt, die mit dem übergebenen Predicate (Parameter 2) `true` ergeben.

###### A2.
Erzeugen Sie ein Test-Array mit unterschiedlichen Integer.

###### A3.
Bilden Sie mit einer Lambda-Funktion ein `Predicate`, mit dem die Methode `printIf` nur positive Werte aus dem übergebenen Test-Array ausgibt. Bitte testen.

###### A4.
Bilden Sie mit einer Lambda-Funktion ein `Predicate`, mit dem die Methode `printIf` nur gerade Werte (dividierbar durch 2 ohne Rest) aus dem übergebenen Test-Array ausgibt. Bitte testen.

###### A5.
Bilden Sie mit einer Lambda-Funktion ein `Predicate`, mit dem die Methode `printIf` gerade positive Integer aus dem übergebenen Test-Array ausgibt. Bitte testen.
