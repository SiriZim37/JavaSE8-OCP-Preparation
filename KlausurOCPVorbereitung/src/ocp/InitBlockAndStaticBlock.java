package ocp;


class TarsierX {
	  static String s = "-";
	  public static void main(String[] args) {
	    go();
	    System.out.println(s);
	  }
	  { go(); }
	  static { go(); }
	  static void go() { s+= "s"; }
	  
	  /*
		A.-s
		B.-ss
		C.-sss
		D.-ssss
		E.-ssssss
		F.Compilation fails
		
		B is correct. The go() method is called once from the static init block
		and then once from main. The nonstatic init block is never invoked because
		no instance of TarsierX is created.
	   */
}

public class InitBlockAndStaticBlock {

	public static void main(String[] args) {

	}
}
