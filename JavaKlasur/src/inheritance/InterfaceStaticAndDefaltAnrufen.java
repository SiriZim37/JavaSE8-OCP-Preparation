package inheritance;


interface Frog{
	static int getCC(int temp) {
		return temp;
	}
	
	default String hop() { return "hopping";}
}

class Duck{
	int rat = 0;
	String hip() { return "hiphip : " + rat;}
}

public class InterfaceStaticAndDefaltAnrufen extends Duck implements Frog{

	int dog = 20;
	
	public static void main(String[] args) {
		new InterfaceStaticAndDefaltAnrufen().go();
		System.out.println(new InterfaceStaticAndDefaltAnrufen().dog);   // 20	
		
		InterfaceStaticAndDefaltAnrufen x = null;
//		System.out.println(x.dog);    				// Exception : NullpointerException
	}
	void go() {
		// implement and extend can access Superclass and Interface default
		System.out.println(hop());					// hopping 
		System.out.println(this.hop());				// hopping 
//		System.out.println(super.hop());			// cf : > find in Duck > The method hop() is undefined for the type Duck
		System.out.println(Frog.super.hop());		// ok : 
		
		System.out.println(this.hip());
		System.out.println(new Duck().hip());		// hiphip : 0
		System.out.println(super.hip());		// hiphip : 0
		System.out.println(hip());				// hiphip : 0
		System.out.println(rat);				// 0
		
//		System.out.println(getCC(13));	
		
		System.out.println(Frog.getCC(13));
		
		InterfaceStaticAndDefaltAnrufen x = new InterfaceStaticAndDefaltAnrufen();
//		System.out.println(x.getCC(12));
		System.out.println(x.hip());			// hiphip : 0
		System.out.println(x.hop());			// hopping
	}
	
	
}
