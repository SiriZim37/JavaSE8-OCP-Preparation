# Aufgabe "Verzeichnisse"

> Benutzen Sie bitte für die Lösung die Methode(n) aus der Klasse `java.nio.file.Files`

###### A1.

Definieren Sie eine Klasse `SubDirectories` mit einem Konstruktor `SubDirectories(Path dir)`. Mit dem Konstruktor wird ein Verzeichnis festgelegt, in dem ein SubDirectories-Objekt arbeiten soll:

	Path dir = Paths.get(".").toAbsolutePath()
	SubDirectories instance = new SubDirectories(dir);

Der Konstruktor akzeptiert als Argument nur asolute Pfade.

###### A2.

Erstellen Sie in der Klasse `SubDirectories` eine Methode `createSubdirs(String)` die folgendermaßen aufgerufen werden kann:
 
    instance.createSubdirs("a\\b\\c\\d");
 
Die Methode erzeugt dann die beschriebene Unterverzeichnisstruktur in dem Verzeichnis, das im Konstruktor festgelegt wurde.

Die Methode soll als Argument nur relative Pfade akzeptieren!

> Optional. Die Methode akzeptiert als Argument auch einen absoluten Pfad, wirft aber eine Exeption, falls die Unterverzeichnisse nicht in dem Verzeichnis entstehen sollen, das im Konstruktor festgelet wurde.

###### A3.
Erstellen Sie in der Klasse `SubDirectories` eine weitere Methode `deleteDirs(String)`, die folgendermaßen aufgerufen werden kann:
 
	instance.deleteSubdirs("a\\b\\c\\d");

Die Methode soll die beschriebene Unterverzeichnisstruktur in dem Verzeichnis löschen, das im Konstruktor festgelegt wurde.

Die Methode löscht die Unterverzeichnisse nur wenn sie keine weiteren Elemente beinhalten (also nur leere Unterverzeichnisse).

Die Methode soll als Argument nur relative Pfade akzeptieren!

> Optional. Die Methode akzeptiert als Argument auch einen absoluten Pfad, wirft aber eine Exeption, falls die Unterverzeichnisse nicht in dem Verzeichnis entstehen sollen, das im Konstruktor festgelet wurde.

