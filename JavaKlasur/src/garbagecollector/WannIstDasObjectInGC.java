package garbagecollector;

public class WannIstDasObjectInGC {
	
	private Object o ;
	private void doSomethingElse(Object o) {
		
	}
	private void doSomething(Object o) {
		o = new Object();	// zeile A
		doSomething(o);
		o = new Object();
		doSomethingElse(null);
		o = null;
	}
	
	public static void main(String[] args) {
		
		WannIstDasObjectInGC gc = new WannIstDasObjectInGC();
		gc.doSomething(gc);

	}

}
