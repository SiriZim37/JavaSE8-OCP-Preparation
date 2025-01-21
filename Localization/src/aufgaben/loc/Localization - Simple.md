# Aufgabe 'Localization - Simple'

#### A1.
Erzeugen Sie eine neue Klasse, die die main-Methode hat und abhängig von den Spracheinstellungen des Systems funktioniert. 

Falls die Sprache 'de' im default-Locale gesetzt wurde, ermittelt die main-Methode das aktuelle Datum und erzeugt folgende Ausgaben:

	Heute ist 9. Oktober 2018.
	Es ist Dienstag.

> In dem Beispiel wurde die main am 9. Oktober 2018 ausgeführt.

Falls eine andere Sprache im default-Locale gesetzt wurde, liefert die main in englisch verfassten Texte:

	Today is October 9, 2018.
	It's Tuesday.

> Tipp: verwenden Sie `DateTimeFormatter.ofPattern` um das Datum bzw. den Wochentagnamen zu formatieren. 

Achten Sie bitte auf die unterschiedlichen Formatierungen des Datums, die von dem default-Locale auch abhängig sind.

#### A2.
Erweitern Sie die Anwendung so, dass sie beim Start nach der System-Property 'user.name' sucht und den Benutzer mit dem Namen begrüßt.

#### A3. Optional
Erweitern Sie die Anwendung so, dass sie beim Starten nach der System-Property 'user.birthday' sucht, in der ein Geburtstags-Datum übergeben wird. Falls die Property gefunden wird, soll die Anwendung die Anzahl der Tage bis zum Geburtstag berechnen und ausgeben bzw. den Benutzer zum Geburtstag gratulieren.

#### A4. Optional
Erweitern Sie die Anwendung so, dass wenn beim Starten die System-Property 'user.birthday' nicht gefunden wird, die Anwendung versucht die Property 'user.birthday' aus einer eigenen Konfigurationsdatei zu laden. Die Konfigurationsdatei kann die Anwendung im eigenen Unterverzeichnis verwalten, das die Anwendung sich im User-Verzeichnis erstellt und pflegt.
