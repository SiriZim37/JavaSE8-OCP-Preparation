package klausur;

/*
 Gegeben ist der Code:

  enum MyEnum {
    A,  B,  C
  }

  public class Test {
    public static void main(String... a) {
      // Zeile A
    }
  }

Was kompiliert eingesetzt (einzeln) in der Zeile A?
Eine oder mehrere richtige Antworten sind möglich.

[   ] java.util.Iterator x = MyEnum.iterator();
[ X ] Comparable<MyEnum> x = MyEnum.A;
[   ] MyEnum x = new MyEnum().A;
[ X  ] MyEnum[] x = MyEnum.values();
 */
public class TestENum1 {

	enum MyEnum {
	    A,  B,  C
	  }
	
	public static void main(String[] args) {
		
	
//		java.util.Iterator x = MyEnum.iterator();
		Comparable<MyEnum> x1 = MyEnum.A;		// MyEnum.A ist eine Instanz des Enums MyEnum und implementiert automatisch das Interface Comparable<MyEnum>
//		MyEnum x = new MyEnum().A;				// In Java können Sie Enums nicht mit new instanziieren.
		MyEnum[] x2 = MyEnum.values();			// values() ist eine statische Methode, die in jedem Enum automatisch verfügbar ist und ein Array aller Konstanten des Enums zurückgibt.

	}
}
