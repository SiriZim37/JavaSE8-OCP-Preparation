# Aufgabe 'Words - Files'

> Laden Sie alle englischen Wörter in eine `java.util.List`.
> Quelle: https://github.com/danielmiessler/SecLists/tree/master/Miscellaneous
>
> Wenn dafür eine Lösung vom Dozenten freigegeben wurde, bitte diese Lösung verwenden. 
> Verwenden Sie eine der beiden Listen als Datenquelle beim Lösen der folgenden Aufgaben.

#### A1.
Erzeugen Sie bitte folgende Dateien auf der Festplatte in einem Verzeichnis ihrer Wahl:
	
		mydir/
			|- a.txt
			|- b.txt
			...
			|- z.txt

Jede von Ihnen erzeugte Datei beinhaltet alle Wörter mit dem entsprechenden Anfangsbuchstaben ('a.txt' hat alle Wörter auf 'a',  'b.txt' alle Wörter auf 'b' usw.). 

- Verwenden Sie wenn möglich eine Stream-Pipeline um die Wörter zu gruppieren.
- Verwenden Sie wenn möglich die nio-API (Interface `Path`, Klasse `Files`).

#### A2.
Definieren Sie eine Methode, die alle Dateien aus dem Verzeichnis löscht, das für die Aufgabe A1 erstellt wurde.
 
