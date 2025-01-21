# Aufgabe 'Lambdas - erweitert'

> Alle vorgestellten Interfaces findet man im Package 'java.util.function'.

> 'mit Lambda ausfürlich zu initialisieren' bedeutet in der Parameterliste die Parametertypen anzugeben und im Rimpf die geschweiften Klammer zu verwenden.

> 'mit Lambda kompakt zu initialisieren' bedeutet in der Parameterliste die Parametertypen und Klammer wenn möglich weg zu lassen und im Rumpf wenn möglich auf die geschweiften Klammer zu verzichten.

###### A1.

Gegeben ist folgende main-Methode:

    public static void main(String[] args) {
		class C1 implements Consumer<Integer> {
			@Override
			public void accept(Integer t) {
				System.out.println(t);
			}
		}
	
		Consumer<Integer> c1 = new C1();
		c1.accept(12);	
		
		Consumer<Integer> c2 = ...
		c2.accept(12);	
		
		Consumer<Integer> c3 = ...
		c3.accept(12);

		Consumer<Integer> c4 = ...
		c4.accept(12);
	}	
	
Alle drei Consumer-Realisierungen sollen dieselbe Ausgabe erzeugen.

- Initialisieren Sie c2 mithilfe einer anonymen Klasse.
- Verwenden Sie eine Lambda-Funktion um c3 ausführlich zu initialisieren.
- Verwenden Sie eine Lambda-Funktion um c4 kompakt zu initialisieren.

###### A2.

Gegeben ist folgende main-Methode:

    public static void main(String[] args) {
    	class S1 implements Supplier<String> {
    		@Override
    		public String get() {
    			return "Montag";
    		}
    	}
    	
    	Supplier<String> s1 = new S1();
    	System.out.println("Heute ist " + s1.get());
    	
    	Supplier<String> s2 = ...
    	System.out.println("Heute ist " + s2.get());
    	
    	Supplier<String> s3 = ...
    	System.out.println("Heute ist " + s3.get());
    	
    	Supplier<String> s4 = ...
    	System.out.println("Heute ist " + s4.get());
    }

- Initialisieren Sie s2 mithilfe einer anonymen Klasse.
- Verwenden Sie eine Lambda-Funktion um s3 ausführlich zu initialisieren.
- Verwenden Sie eine Lambda-Funktion um s4 kompakt zu initialisieren.



###### A3.

> In der Aufgabe wird das Interface `java.util.function.BiFunction` verwendet.

Gegeben ist folgende main-Methode:

    public static void main(String[] args) {
    	class F1 implements BiFunction<String, String, Integer> {
    		@Override
    		public Integer apply(String t1, String t2) {
    			return t1.length() + t2.length();
    		}
    	}
    	
    	BiFunction<String, String, Integer> f1 = new F1();
    	System.out.println( f1.apply("ab", "cde") );
    	
    	BiFunction<String, String, Integer> f2 = ...
    	System.out.println( f2.apply("ab", "cde") );
    	
    	BiFunction<String, String, Integer> f3 = ...
    	System.out.println( f3.apply("ab", "cde") );

    	BiFunction<String, String, Integer> f4 = ...
    	System.out.println( f4.apply("ab", "cde") );
    }

- Initialisieren Sie f2 mithilfe einer anonymen Klasse.
- Verwenden Sie eine Lambda-Funktion um f3 ausführlich zu initialisieren.
- Verwenden Sie eine Lambda-Funktion um f4 kompakt zu initialisieren.

###### A4.

Gegeben:

	/*Typ hier*/ ref = x -> y -> x;

Überlegen Sie ob es für die Variable 'ref' einen Typ geben kann, 
mit dem die Zeile kompiliert.

