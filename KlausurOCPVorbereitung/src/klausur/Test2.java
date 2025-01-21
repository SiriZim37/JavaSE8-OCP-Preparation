package klausur;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

/*
 * 
 public class Test {
  static boolean startsWithA(String s) {
    return s.startsWith("A");
  }

  public static void main(String[] args) {
    Collection<String> coll = new ArrayList<>();
    coll.add("AA");
    coll.add("BB");
    coll.add("CC");

    coll.removeIf(
        new Predicate<String>() {
          public boolean test(String element) {
            return false;
          }
        });
    coll.removeIf(Test::startsWithA);
    coll.removeIf(param -> param.startsWith("B"));

    System.out.println(coll);
  }
}


Was ist richtig, wenn alle Typen richtig importiert wurden?

[   ] Compilerfehler
[   ] Exception
[   ] Ausgabe ist [CC]
[   ] Die Liste ist leer, Ausgabe ist []
 */
public class Test2 {

	  static boolean startsWithA(String s) {
		    return s.startsWith("A");
		  }

		  public static void main(String[] args) {
		    Collection<String> coll = new ArrayList<>();
		    coll.add("AA");
		    coll.add("BB");
		    coll.add("CC");

		    coll.removeIf(
		        new Predicate<String>() {
		          public boolean test(String element) {
		            return false;
		          }
		        });
		    coll.removeIf(Test2::startsWithA);
		    coll.removeIf(param -> param.startsWith("B"));

		    System.out.println(coll);
		  }
		  
}
