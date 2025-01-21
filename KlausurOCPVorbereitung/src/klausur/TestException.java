package klausur;

/*
 Gegeben:

  public static void main(String[] args)  throws Exception {
    try( MyResource r = new MyResource() ) {
      System.out.println("try");
    }
  }

Was ist richtig?
Eine oder mehrere richtige Antworten sind möglich.

[ X ] Die Klasse 'MyResource' muss das Interface 'AutoCloseable' implementieren, damit der Code kompiliert.
[   ] Die Klasse 'MyResource' muss das Interface 'Collectable' implementieren, damit der Code kompiliert.
[   ] Der Code kompiliert nur, wenn dazu ein catch-Block hinzugefügt wird.
[   ] Der Code kompiliert nur, wenn dazu ein finally-Block hinzugefügt wird.

 */


class MyResource implements AutoCloseable{

	@Override
	public void close() throws Exception {
		
	}
	
}
public class TestException {

	  public static void main(String[] args)  throws Exception {
		    try( MyResource r = new MyResource() ) {
		      System.out.println("try");
		    }
		  }
}
