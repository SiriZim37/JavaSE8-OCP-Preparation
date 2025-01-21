# Aufgabe 'Serialisieren - Dienste' 

> Die für die Lösung nötigen Klassen sollen die beschriebenen Anforderungen erfüllen. Ansonsten ist die Gestaltung der Klassen frei.

- Erstellen Sie eine __nicht serialisierbare__ Klasse `Dienst`, die ein Attribut `name` und den folgenden Konstruktor definiert:

		public Dienst(String name) {
		    this.name = name;
		}

> Achtung! Die Klasse `Dienst` __darf nicht__ `java.io.Serializable` implementieren  

- Erstellen sie eine __nicht serialisierbare__ Klasse `Defragmentierung` mit den Attributen `zeitabstand (int)` und `laufwerk (String)`. Die Klasse `Defragmentierung` hat die Klasse `Dienst` als Basisklasse.

> Achtung! Die Klasse `Defragmentierung` __darf nicht__ `java.io.Serializable` implementieren  

- Erstellen Sie eine __serialisierbare__ Klasse `SpeicherManager`, die von der Klasse `Dienst` erbt. Die Klasse `SpeicherManager` soll folgende Attribute besitzen: `size (int)` und `defrag (Defragmentierung)`.   
An den Konstruktor der Klasse soll die Größe (size) und das Defragmentierungsdienst (defrag) übergeben werden können. Definieren Sie für die Klasse `SpeicherManager` die toString-Methode wie folgt:

		public String toString() {
		    return "Manager. Size: " + size+ ". Defrag-Dienst: " + defrag;
		}


- Erstellen Sie eine Klasse `Test` mit der main-Methode. Erzeugen Sie in der main-Methode ein Object von Typ `SpeicherManager`:

        SpeicherManager sManager = new SpeicherManager(2000, new Defragmentierung (3000, "C:\\"));

2000 steht für die Größe (size)   
3000 steht für den Zeitabstand   
"C:\\" steht fürs Laufwerk   


- Serialisieren Sie das Objekt in einer Datei 'sManager.bin'.


- Deserialisieren Sie das Object aus der Datei 'sManager.bin' und speichern Sie seine Adresse unter der neuen Referenz SpeicherManager sManager2.


- Geben Sie sManager2 aus. Folgende Konsolenausgabe soll entstehen:
    
        Manager. Size: 2000. Defrag-Dienst: Zeitabstand(3000), LW(C:\) 
