package ocpexam;


abstract class abS1 {
	
	 abstract void met1();
	 
	 static void met2() {}
	 
	 void met3() {}
	 
//	  void met4();  // compiler fail
}

class SubClassAbS extends abS1{

	 void met1() {}  // ok protected, public 
		
//	public void met2() {}	// static failer
	 	 
	 public void met3() {}
	
	 void met3(String num) {}
	 
}

public class AbstractClassWithmethodeStaticandLocal {

}
