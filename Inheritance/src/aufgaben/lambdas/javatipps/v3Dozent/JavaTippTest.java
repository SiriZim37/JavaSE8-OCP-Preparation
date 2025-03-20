package aufgaben.lambdas.javatipps.v3Dozent;

import java.util.function.Predicate;

public class JavaTippTest {

	public static void main(String[] args) {
		JavaTipp[] javatipps = createAndFillArray();
		
		// A3
		// printIf(javatipps, tipp -> tipp != null);
		System.out.println("alle Tipps");
		printIf(javatipps, t -> true);
		
		// A4
		System.out.println("alle Tipps mit dem Wort Klasse im Text");
		printIf(javatipps, t -> t.getText().contains("Klasse"));
		
		// A5
		System.out.println("alle Tipps mit genau zwei Themen");
		printIf(javatipps, t -> t.getThemen().indexOf(",") > 0 && t.getThemen().indexOf(",") == t.getThemen().lastIndexOf(","));
		
		// A6 
		System.out.println("alle Tipps mit dem Thema Klassen");
		printIf(javatipps, t -> t.getThemen().contains("Klassen"));
		
		// A7
		System.out.println("alle Tipps mit dem Thema Klassen, aber nicht mit dem Thema Vererbung");
		printIf(javatipps, t -> t.getThemen().contains("Klassen") && !t.getThemen().contains("Vererbung"));
		
	}
	
	// A2
	public static void printIf(JavaTipp[] javatipps, Predicate<JavaTipp> pred) {
		for (JavaTipp javaTipp : javatipps) {
			if (pred.test(javaTipp)) {
				System.out.println(javaTipp);
			}
		}
	}
	
	// A1
	public static JavaTipp[] createAndFillArray() {
		JavaTipp[] javatipps = new JavaTipp[6];
		
		String text = "Mit dem Schlüsselwort 'implements' kann eine Klasse ein Interface realisieren.";
		JavaTipp tipp = new JavaTipp(text, "Vererbung, Klassen, Interfaces");
		javatipps[0] = tipp;
		
		text = "Eine Klasse kann nur eine andere Klasse erweitern."; 
		tipp = new JavaTipp(text, "Vererbung, Klassen");
		javatipps[1] = tipp;
		
		text = "Statische Methoden werden mit dem Klassennamen aufgerufen.";
		tipp = new JavaTipp(text, "Klassen, Methoden, static");
		javatipps[2] = tipp;
		
		text = "Alle Attribute in einem neuen Objekt werden im Konstruktor initialisiert.";
		tipp = new JavaTipp(text, "Klassen, Konstruktoren, Attribute");
		javatipps[3] = tipp;
		
		text = "Beim Überschreiben darf die Sichtbarkeit nicht verschärft werden.";
		tipp = new JavaTipp(text, "Klassen, Methoden, Überschreiben");
		javatipps[4] = tipp;
		
		text = "Alle Elemente in einem Interface sind immer 'public'";
		tipp = new JavaTipp(text, "Interfaces, Sichtbarkeiten, Java 8");		
		javatipps[5] = tipp;
		
		return javatipps;
	}

}
