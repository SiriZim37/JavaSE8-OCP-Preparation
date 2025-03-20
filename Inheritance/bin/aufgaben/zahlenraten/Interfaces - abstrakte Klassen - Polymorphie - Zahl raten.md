# Aufgabe 'Zahl raten'

#### A1.
Erzeugen Sie eine Zufallszahl zwischen 1 bis 10 (inklusive) und speichern Sie in der Konstante `x`. Geben Sie die Zahl aus.
 
#### A2.
Folgender Code soll die generierte Zahl mit 2 multiplizieren:
 
 		IntOperation op1 = new Multiply(2);
 		int result1 = op1.execute(x); // result1 ist 2 * x

#### A3.
Folgender Code soll das Ergebnis der vorherigen Operation mit 5 multiplizieren:
 
 		IntOperation op2 = new Multiply(5);
 		int result2 = op2.execute(result1); 

#### A4.
Folgender Code soll das Ergebnis der vorherigen Operation durch `x` teilen:
 
 		IntOperation op3 = new Divide(x);
 		int result3 = op3.execute(result2); 

#### A5.
Folgender Code soll von dem Ergebnis der vorherigen Operation 7 subtrahieren:
 
 		IntOperation op4 = new Subtract(7);
 		int result4 = op4.execute(result3); 

Überprüfen Sie das Ergebnis in `result4`. Es muss gleich 3 sein.

#### A6. Optional. 

> https://de.wikihow.com/Mit-Mathematik-Gedanken-lesen-(Mathe-Trick)
 
Erstellen Sie eine interaktive Konsolenanwendung, die den Gedanken-Lese-Trick dem Benutzer zeigt.
 
> Dafür müssen natürlich keine Operationen mit einem int-Wert durchgeführt werden, da das Ergebniss ja immer 3 ist.

#### A7.
Bilden Sie folgendes Array:

	IntOperation[] ops = {
		new Add(5), // addiert 5
		new ChangeSign(), // ändert das Vorzeichen
		new Multiply(2), // mit 2 multiplizieren
		new Subtract(3)  // 3 subtrahieren
	};

Jagen Sie einen int-Wert durch das Array so, dass alle Operationen sequentiell ausgeführt werden und jede nächste Operation als Eingangswert (input) das Ergebnis der vorherigen Operation erhält.

Z.B. wenn an die erste Operation 2 übergeben wird, kommt als Ergebnis der letzten Operation -17 raus.

	Symbolisch erklärt:
	2 -> (2+5) = 7 -> (Vorzeichen ändern) -7 -> (-7*2) = -14 -> (-14-3) = -17

#### A8. Optional

Ändern Sie die Lösung so, dass mehrere Operationen nicht mehr in einem Array gespeichert werden müssen, sondern nach folgendem Muster kombiniert werden können:

 		IntOperation op = new Add(5)
 							.andThen( new ChangeSign() )
 							.andThen( new Multiply(2) )
 							.andThen( new Subtract(3) );

		int result = op.execute(2); // result ist -17
