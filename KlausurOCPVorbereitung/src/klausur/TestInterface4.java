package klausur;

/*
 Gegeben ist der Code:

  interface MyInterface {
    void m();
  }
  
  public class MyClass implements MyInterface {
    void m() {}
  
    public static void main(String... a) {
      new MyClass().m();
    }
  }


Was ist das Ergebnis? 

[ X ] Compilerfehler.
[   ] Eine Exception wird geworfen.
[   ] Ein Error wird geworfen.
[   ] Der Code kompiliert und läuft ohne Fehler.
 */

interface MyInterface1 {
    void m();
  }
  

public class TestInterface4 implements MyInterface1 {

//    void m() {}
    
    public static void main(String... a) {
      new TestInterface4().m();
    }

	@Override
	public void m() {
		// TODO Auto-generated method stub
		
	}


}
