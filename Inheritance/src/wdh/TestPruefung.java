package wdh;


interface interfaceC{
	public default void getO() {}
}
interface interfaceD{
	public void getO();
}


//interface interfaceAAB{
//	public Number fly();
//
//}
//
abstract class interfaceABB{
	protected final int size;
	
	public interfaceABB(int size) {
		this.size = size;
	}
	public Long fly() {return 3L;}

}
//
//
//class test  extends interfaceABB implements interfaceAAB {
//
//	public Long fly() {
//		return 12;		// cf : Es muss return 12L oder (long) 12;
//	}
//}

/*
 *  abstract class interfaceABB hat kein default consstructor , so class test muss einen Konstruktor erzegen.
 */

public class TestPruefung implements interfaceC , interfaceD{

	public void getO( int f ) {
		
	}
	@Override
	public void getO() {
		// TODO Auto-generated method stub
		
	}

	
//	public  void play0() {
//		System.out.println("dsd");
//	}
	
//	private static void play0() {
//		System.out.println("dsd");
//	}
//	


	public static void main(String[] args)    {
//		new TestPruefung().play0();

	}





}
