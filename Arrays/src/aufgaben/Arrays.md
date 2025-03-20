# Aufgabe 'Array - einfach'

#### A1.
Bitte definieren Sie eine Methode 'createArray', die ein int-Array erzeugt und mit Zufallswerten belegt. Die neue Methode soll aus der main-Methode folgendermassen aufgerufen werden koennen:
    
    	int[] arr = createArray(2, 15, 30);

> In diesem Beispiel wird ein Array der Länge 30 erzeugt und mit den Zufallswerten aus dem Bereich [2 .. 15] belegt.

#### A2.
Bitte geben Sie das in A1 erzeugte Array aus. Dafür definieren Sie eine weitere Methode `printArray`, an die Sie das Array übergeben.

#### A3.
Definieren Sie eine statische Methode `deutscheUmlaute`, die ein Array mit den Zeichen 'ä', 'ö' und 'ü' zurück liefert. Testen Sie die Methode.

#### A4.
Definieren Sie eine statische Methode `deutscheBuchstaben`, die ein Array mit allen deutschen Kleinbuchstaben inklusive Umlaute und 'ß' zurück liefert. Testen Sie die Methode.

#### A5.
Erzeugen Sie bitte ein Array in dem die Konstanten Math.PI und Math.E gespeichert werden. Geben Sie dann das Array aus.

#### A6.
Gegeben sind folgende zwei Arrays:

		int[] a1 = { 1, 2, 3 };
		int[] a2 = { 12, 13, 14 };

und folgender Methodenaufruf:
		
		int[] a3 = add(a1, a2); // a3 bekommt folgende Werte: 13, 15, 17 

Diefinieren Sie bitte die Methode `add` so, dass sie die ensprechenden Elemente der beiden übergebenen Arrays addiert und in einem neuen Array zurück liefert. Testen Sie die Methode.
		
#### A7.
Gegeben sind folgende zwei Arrays:

		int[] a1 = { 1, 2, 3 };
		int[] a2 = { 12, 13, 14 };

und folgender Methodenaufruf:

		int[] a3 = join(a1, a2); // a3 bekommt folgende Werte: 1, 2, 3, 12, 13, 14

Definieren Sie bitte die Methode `join` so, dass sie ein neues Array liefert in dem die Elemente der beiden übergebenen Arrays erhalten sind. Testen Sie die Methode.

