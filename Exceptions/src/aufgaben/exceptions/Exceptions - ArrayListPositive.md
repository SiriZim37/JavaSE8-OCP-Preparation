# Aufgabe 'Exceptions - ArrayListPositive'

#### A1
Erzeugen Sie eine neue Klasse `ArrayListPositive`, die von der Klasse `java.util.ArrayList` erbt.

#### A2
Gestalten Sie die neue Klasse so, dass sie folgende Bedingungen erfüllt:

	- Nur Integer-Referenzen können in einer `ArrayListPositive` gespeichert werden. 
	- Keine null-Werte können in einer `ArrayListPositive` gespeichert werden. 
	  Beim Versuch wird `NullArgumentException` geworfen.
	- Keine 0-Werte können in einer `ArrayListPositive` gespeichert werden. 
	  Beim Versuch wird `NotPostivieArgumentException` geworfen.
	- Keine negativen Werte können in einer `ArrayListPositive` gespeichert werden.
	  Beim Versuch wird `NotPostivieArgumentException` geworfen.

#### A3
Testen Sie die Lösung. 

#### A4
Optional. Wenn Sie möchten, verwenden Sie im Code die Assertions.
