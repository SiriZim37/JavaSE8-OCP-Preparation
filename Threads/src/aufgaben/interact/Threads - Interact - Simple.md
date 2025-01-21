# Aufgabe 'Threads - Interact'

##### A1
- Der Thread A erzeugt 20 zufällige int-Werte und speichert sie.
- Der Thread B erzeugt 30 zufällige int-Werte und speichert sie.
- Der main-Thread erzeugt und startet die Threads A und B. Wenn sie fertig sind, bildet der main-Thread die Summe aller 50 int-Werte der beiden Threads und gibt die Summe aus.

###### A2
Bitte einen Extra-Thread starten, der die statische Variable `count` in einer for-Schleife 1 Mio. mal um eins inkrementiert. Bitte in der main den Wert der Variable ausgeben. 

##### A3
Bitte einen Extra-Thread starten, der endlos ca. jede Sekunde eine Ausgabe tätigt. Der main-Thread wartet nach dem Start vom extra-Thread ca. 5 Sek. und beendet den Extra-Thread mit interrupt (danach darf die ganze Anwendung beendet werden).
