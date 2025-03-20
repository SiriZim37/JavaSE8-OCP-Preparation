package aufgaben.lambdas.javatipps.v2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdasJavaTipp2 {


    // Beispiel-Verbraucher, der Tipps auf der Konsole ausgibt
    public static void main(String[] args) {
    	JavaTipp2[] tipps = {
    	            new JavaTipp2("Mit dem Schlüsselwort 'implements' kann eine Klasse ein Interface realisieren.",
    	                         Arrays.asList("Vererbung", "Klassen", "Interfaces")),
    	            new JavaTipp2("Eine Klasse kann nur eine andere Klasse erweitern.",
    	                         Arrays.asList("Vererbung", "Klassen")),
    	            new JavaTipp2("Statische Methoden werden mit dem Klassennamen aufgerufen.",
    	                         Arrays.asList("Klassen", "Methoden", "static")),
    	            new JavaTipp2("Alle Attribute in einem neuen Objekt werden im Konstruktor initialisiert.",
    	                         Arrays.asList("Klassen", "Konstruktoren", "Attribute")),
    	            new JavaTipp2("Beim Überschreiben darf die Sichtbarkeit nicht verschärft werden.",
    	                         Arrays.asList("Klassen", "Methoden", "Überschreiben")),
    	            new JavaTipp2("Alle Elemente in einem Interface sind immer 'public'",
    	                         Arrays.asList("Interfaces", "Sichtbarkeiten", "Java 8"))
    	        };

        // Beispiel: Alle Tipps finden und ausgeben
        filterTipps(tipps, t -> true, System.out::println);

        // Optional: Tipps in eine ArrayList speichern
        List<JavaTipp2> tippList = new ArrayList<>();
        filterTipps(tipps, t -> true, tippList::add);
        System.out.println(tippList);

        // Optional: Beispiel für die Verwendung eines Verbrauchers
        Consumer<JavaTipp2> printer = t -> System.out.println("Gefundener Tipp: " + t);
        filterTipps(tipps, t -> true, printer);
        
        filterTipps(tipps, t -> t.getText().contains("Klasse"), System.out::println);
        filterTipps(tipps, t -> t.getThemen().size() == 2, System.out::println);
        filterTipps(tipps, t -> t.getThemen().contains("Klassen"), System.out::println);
        filterTipps(tipps, t -> t.getThemen().contains("Klassen") && !t.getThemen().contains("Vererbung"), System.out::println);

    }
    
    
    // Methode zur Filterung der Tipps basierend auf einem Predicate
    public static void filterTipps(JavaTipp2[] tipps, Predicate<JavaTipp2> predicate, Consumer<JavaTipp2> consumer) {
        for (JavaTipp2 tipp : tipps) {
            if (predicate.test(tipp)) {
                consumer.accept(tipp);
            }
        }
    }

}

