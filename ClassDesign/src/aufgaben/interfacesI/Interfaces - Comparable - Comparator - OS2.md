# Aufgabe 'Interfaces - Comparable/Comparator - OS'

#### A1.
Erstellen Sie  eine Klasse "OS" (Operating System) mit den Attributen 'String name' und 'int version'. 

*Erstellen Sie eine Klasse mit der main-Methode, in der folgende Aufgaben gelöst werden*

#### A2.
Speichern Sie in einem Array vier OS-Referenzen (keine Strings):

        Linux 3
        Windows 95
        Mac 9
        Linux 1


#### A3.
Geben Sie den Inhalt des Arrays auf der Konsole aus:

		 | 1. | Linux   |  3 |
		 | 2. | Windows | 95 |
		 | 3. | Mac     |  9 |
		 | 4. | Linux   |  1 |

> Gestaltung der Ausgabe als eine Tabelle ist optional. Tipp: System.out.format

#### A4.
Sortieren Sie das Array mit Hilfe der Methode `java.util.Arrays.sort(Object[])`. Dabei müssen die OS nach dem Namen und bei gleichen Namen nach der Version verglichen werden.
Geben Sie erneut den Inhalt des Arrays auf der Konsole aus.


#### A5.
Das Array bitte absteigend sortieren und ausgeben.

>Tipp: Interface java.util.Comparator

>Tipp: java.util.Arrays.sort(array, comparator)


#### A6. Optional
Suchen Sie in dem __aufsteigend__ sortiertem Array nach der OS 'Linux 1' 

>Tipp: java.util.Arrays.binarySearch(array, key)


#### A7. Optional
Suchen Sie in dem __absteigend__ sortiertem Array nach der OS 'Windows 95'.
    
>Tipp: java.util.Arrays.binarySearch(array, key, comparator)

#### A8. Optional
Entwicklen Sie eine Methode `shuffle(OS[])`, die die Elemente im übergebenen array zufällig mischt. 
Testen Sie die Methode mit dem vorhandenen Array und geben Sie danach das Array aus.  
