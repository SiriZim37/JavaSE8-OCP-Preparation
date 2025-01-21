# Aufgabe 'JDBC'

###### A1. 
Wählen Sie einen Datenbank-Lösung aus, mit dem folgende Aufgaben gelöst werden können, z.B Apache Derby, MySQL, SQLite oder eine andere Lösung Ihrer Wahl.

###### A2. Optional
Erzeugen Sie bitte eine Klasse `ResourceLoader` mit der Methode `load`, die eine Textdatei im Classpath findet und in einem String lädt:

		String text = ResourceLoader.load("path/to/textfile/in/classpath"); 

Beim Lösen weiterer Aufgaben können Sie die SQL-Befehle in sql-Scriptdateien definieren und mit Hilfe dieser Klasse laden.


*Weitere Aufgaben lösen Sie bitte programmtechnisch mit JDBC*

###### A3.
Die weitere Methode `getConnection` in der Klasse `JDBCUtils` soll die Verbindung zu der Datenbank erstellen.

###### A4.
Erzeugen Sie in der Klasse `JDBCUtils` die Methode `rebuildTable`. In der Methode erzeugen Sie bitte in Ihrer Datenbank die Tabelle 'personen' mit den Spalten 'id', 'vorname', 'nachname' und 'geburtsjahr'. Falls eine solche Tabelle bereits existiert, soll sie gelöscht und wieder erzeugt werden. Füllen Sie die Tabelle mit 3-4 Datensätzen.

> wenn Sie möchten, können Sie stattdessen eigene Tabelle mit anderen Spalten definieren

###### A5.
Erzeugen Sie in der Klasse `JDBCUtils` eine Methode `printTable`. In der Methode lesen Sie bitte alle Datensätze aus der Tabelle 'personen' und geben Sie sie auf der Konsole aus.

> Optional: Tabelle mit printf formatiert ausgeben

###### A6.
Erzeugen Sie eine Klasse `PersonDAOImpl` die folgendes Interface sinnvoll realisiert:

	interface PersonDAO {
		List<Person> selectAll() ;
		boolean insert(Person p) ;
		void deleteOnID(int id) ;
	}

Testen Sie die Klasse.

###### A7. Optional
Überprüfen Sie, ob das parallele Lesen aus derselben Tabelle mit zwei oder mehreren Threads ohne Synchronisieren in der von Ihnen ausgewählten Datenbank-Lösung möglich ist.

###### A8. Optional
Überprüfen Sie, ob das parallele Lesen und Schreiben in dieselbe Tabelle mit zwei oder mehreren Threads ohne Synchronisieren in der von Ihnen ausgewählten Datenbank-Lösung möglich ist.

