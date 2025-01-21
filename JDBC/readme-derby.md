# JDBC

## SQL

Tutorial: https://www.w3schools.com/sql/

## Derby 'embedded'

#### Herunterladen: 
  
  	https://db.apache.org/derby/derby_downloads.html

#### Letzte Version: 

	https://db.apache.org/derby/releases/release-10_17_1_0.cgi

- lib-Distribution herunterladen und extrahieren
- Zwei Dateien werden daraus benötigt:
    - derby.jar
    - derbyshared.jar

#### Derby in das eigene Eclipse-Projekt einbinden

- Die beiden Jar-Dateien in ein Unterverzeichnis kopieren
- Die beiden Jar-Dateien im Classpath eintragen:
    - Rechtsklick auf das Projekt
    - im Menü: 'Properties'
    - im neuen Fenster Java Buildpath'
    - rechts unter 'Libraries' die Schaltfläche 'Add Jars'

#### Datenbanke erzeugen/löschen

- Erzeugen: Connection öffnen mit der Url, die als Parameter ';create=true' hat

> In der URL "jdbc:derby:dir/mydb" ist dir/mydb der Pfad zu dem Verzeichnis mit der Datenbank. Der Pfad darf auch absolut sein: "jdbc:derby:C:/dir/mydb"

- Löschen: 
    - Zuerst Datenbank schliessen, dafür Connection öffnen mit der Url, die als Parameter ';shutdown=true' hat
    - Danach das Verzeichnis mit der Datenbank löschen (z.B. mit Files.walkFileTree)


