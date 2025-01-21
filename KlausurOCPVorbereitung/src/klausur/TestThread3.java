package klausur;

/*
 
Gegeben ist der Code:

public static void main(String[] args) throws Exception {
  Thread t1 = new Thread( () -> System.out.print( "A" ) );

  t1.start();
  t1.join();

  System.out.print("B");
}

Was ist das Ergebnis?

[   ] Compilerfehler
[   ] BA
[   ] AB
[   ] Die Reihenfolge der Ausgaben kann nicht vorausgesehen werden
 */
public class TestThread3 {

	public static void main(String[] args) throws Exception {
		  Thread t1 = new Thread( () -> System.out.print( "A" ) );

		  t1.start();
		  t1.join();

		  System.out.print("B");
		}
	
}
