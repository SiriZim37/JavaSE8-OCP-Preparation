# Aufgabe 'Map - TextStatistics'

- Erstellen Sie eine Klasse `TextStatistics`.

- Definieren Sie eine statische Methode `of` für die Klasse `TextStatistics`, an die man ein String übergeben kann:

		TextStatistics stat = TextStatistics.of("Heute ist Montag!");


- Definieren Sie eine weitere Methode `getUniqueChars`, die eine Collection von `Character` liefert, in der alle auftretenden Zeichen von dem zu untersuchenden String aufgelistet sind und __einmalig__ auftauchen:

		Collection<Character> chars = stat.getUniqueChars();

- Geben Sie die gefundenen Zeichen aus.

- Definieren Sie eine weitere Methode `getCharCounts`, die eine `Map<Character, Integer>` zurückliefert.
Jedem in Text gefundenen Zeichen wird in der Map die Zahl zugeordnet, die sagt, wie oft das Zeichen in dem Text vorkommt.

> Tipp: Mit der Methode `put` ist es möglich den alten Wert, der dem Schlüßel bereits zugeordnet war, durch den neuen Wert zu ersetzen.
