*** Aufgabe: Exception Pizza

*** A1
Schreiben Sie ein Programm mit dem Namen PizzaService, das eine
Pizzabestellung simuliert. Eine Pizza darf drei Beläge haben, welche über die
Kommandozeile eingegeben werden sollen.

Beispiel: java PizzaService Tomaten Käse Pilze

Es stehen 7 Beläge zur Verfügung, nämlich:
▪ Tomaten
▪ Pilze
▪ Salami
▪ Schinken
▪ Artischocken
▪ Käse
▪ Broccoli

*** A2
Gibt der Benutzer einen ungültigen Belag ein, soll eine BadFoodException
ausgelöst werden, die von Ihnen sinnvoll mit einer Fehlermeldung behandelt
wird.

*** A3
Bei richtiger Eingabe soll eine formatierte Ausgabe der Beläge auf der Konsole
erscheinen.

*** A4
Die BadFoodException soll die Klasse Exception erweitern und einen String-
Konstruktor, dem eine Fehlermeldung übergeben werden kann, besitzen.

*** A5
Zusätzlich soll noch vor der Ausgabe eine IllegalToppingsCountException
geworfen werden, falls die Anzahl der gewählten Beläge ungleich 3 ist. Diese
Exception ist eine Unterklasse von RuntimeException.