# Aufgabe 'Locale, format'

#### A1.
Erstellen Sie eine Klasse `PrintLocales`. Definieren Sie eine Methode `printTable(Locale[])`, die ein Array von `java.util.Locale`-Elementen formattiert auf der Console ausgibt. Die Tabelle soll folgende Spalten haben:

		|  Nr. |   		Land |  		Sprache |


> Tipp: Fürs Erzeugen der Spalten können Sie die Methode `System.out.printf` benutzen.

> Tipp: die Methoden `getDisplayCountry()` und `getDisplayLanguage()` der Klasse  `java.util.Locale` ermöglichen es die Daten für die Spalten 'Land' und 'Sprache' zu ermitteln.

#### A2.
Testen Sie bitte die neue Methode mit dem Array aller geladenen Locales. Dieses Array erhält man mit dem Aufruf `Locale.getAvailableLocales()`.

#### A3.
Bitte das Array aufsteigend nach der Spalte 'Land' (und nach 'Sprache' bei gleichen Landesnamen) sortieren und ausgeben.

#### A4.
Bitte das Array absteigend sortieren und ausgeben.

#### A5. Optional
Weitere Spalten für die Tabelle hinzufügen (s. get-Methoden der Kasse `java.util.Locale`). 

#### A6. Optional
Die notwendigen minimalen Spaltenbreiten dynamisch beim Erzeugen der Tabelle ermitteln.
