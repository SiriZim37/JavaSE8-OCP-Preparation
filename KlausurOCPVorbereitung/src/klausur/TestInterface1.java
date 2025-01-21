package klausur;

/*
 Gegeben ist das Interface:

  interface Faltbar {
    void falten(int x);
  }

Was kompiliert?
Eine oder mehrere richtige Antworten sind möglich.

[   ] Faltbar f = (i) -> {};
[   ] Faltbar f = i -> {};
[   ] Faltbar f = int i -> {};
[   ] Faltbar f = (int i) -> {};
 */



interface Faltbar {
    void falten(int x);
  }
public class TestInterface1 {

	public static void main(String[] args) {
	
		
			 Faltbar f1 = (i) -> {};
			 Faltbar f2 = i -> {};
//			 Faltbar f3 = int i -> {};
			 Faltbar f4 = (int i) -> {};
		
	}
	
}
