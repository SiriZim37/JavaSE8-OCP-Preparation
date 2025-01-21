# Aufgabe 'Collections - functional'

> Die Schreibweise `TypA#method(TypB)` soll im folgenden eine vereinfachte Beschreibung einer Instanzmethode darstellen. So wird mit `Iterable#forEach(Consumer)` die Methode `forEach` aus dem Interface `Iterable` gemeint, die einen `Consumer`-Parameter  deklariert.


- Geben Sie alle Elemente einer Collection mit der Methode `Iterable#forEach(Consumer)` auf der Console untereinander aus. 


- Erzeugen Sie eine List mit folgenden Integer-Werten: 1, 2, 3, 4, 5, 6, 7, 8. 
Verwenden Sie danach die Methode `Collection#removeIf(Predicate)` um alle ungeraden Werte aus der Liste zu entfernen.


- Erzeugen Sie eine List mit folgenden Integer-Werten: 1, 2, 3, 4, 5, 6, 7, 8. 
Verwenden Sie danach die Methode `List#replaceAll(UnaryOperator)` um alle ungeraden Werte in der Liste durch 0 zu ersetzen.


- Erzeugen Sie eine List mit folgenden Integer-Werten: 1, 2, 3, 4, 5, 6, 7, 8.
Verwenden Sie danach die Methode `List#sort(Comparator)` um die List absteigend zu sortieren. Den Comparator definieren Sie bitte als:
    - anonyme Klasse
    - Repla-Funktion
    - Methodenreferenz


- Bilden Sie auf die funktionale Art die Summe aller Elemente einer List mit Integer, die nicht null sind.


- Optional: Beschreiben Sie die Methode `Collection#stream()`
