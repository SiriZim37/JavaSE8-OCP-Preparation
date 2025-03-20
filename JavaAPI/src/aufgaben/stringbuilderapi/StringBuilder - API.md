# Aufgabe 'StringBuilder - API'

> https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuilder.html

#### A1.
Kennen Sie die Konstruktoren?

    - StringBuilder()
    - StringBuilder(String)
    - StringBuilder(int) 

#### A2.
Testen Sie folgende Methoden. Sehen Sie sich dabei die Methodendedklarationen an.

    - StringBuilder append(param) (mehrfach überladen)
    - StringBuilder delete(int start, int end)
    - StringBuilder deleteCharAt(int index)
    - StringBuilder insert(int offset, param) (mehrfach überladen)
    - StringBuilder replace(int start, int end, String str)
    - StringBuilder reverse()
    
    - String toString()

#### A3.
Testen Sie folgende Methoden. Sehen Sie sich dabei die Methodendedklarationen an. Überlegen Sie ob es eine Klasse gibt, die ähnliche Methoden hat.

	- int charAt(index)
	- int length()
	
	- int indexOf(String str)
	- int indexOf(String str, int fromIndex)
	- int lastIndexOf(String str)
	- int lastIndexOf(String str, int fromIndex)
	
	- String substring(int start)
	- String substring(int start, int end)

#### A4. Optional. 
Testen Sie folgende Methoden. Sehen Sie sich dabei die Methodendedklarationen an. 

    - void setCharAt(int index, char ch)
    - void setLength(int newLength)

#### A5.
Vergleichen Sie die API der Klassen `StringBuilder` und `StringBuffer`. Was können Sie sagen?
