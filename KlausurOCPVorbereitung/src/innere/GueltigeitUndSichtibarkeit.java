package innere;

class Outer{
	class Inner{
		void testAcess(){
			Outer o = Outer.this;
			
			System.out.println(v1); 
			System.out.println(v2);
			
			methode1();				
			methode2();
		}
	}
	static class StaticInner{
		void testAcess(){  			// methode is same static methode
//			Outer o = Outer.this;   // this and Super cannt call in Static methode! 
			
//			System.out.println(v1); // cf
			System.out.println(v2);
			
//			methode1();				// cf
			methode2();
		}
	}
	private int v1;
	private static int v2;
	
	private void methode1() {}
	private static void methode2() {}
}



public class GueltigeitUndSichtibarkeit {

}
