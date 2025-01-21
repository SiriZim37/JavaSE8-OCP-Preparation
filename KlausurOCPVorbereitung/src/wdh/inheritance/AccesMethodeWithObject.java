package wdh.inheritance;

class Tree{}


public class AccesMethodeWithObject extends Tree {

	public static void main(String[] args) {
	
		new AccesMethodeWithObject().go();

	}
	void go() {
		go2(new Tree() , new AccesMethodeWithObject());
		go2((AccesMethodeWithObject) new Tree(), new AccesMethodeWithObject());
		
//		Tree t1 = (AccesMethodeWithObject) new Tree();	// java.lang.ClassCastException
	}
	void go2( Tree t1 , AccesMethodeWithObject a1) {
		AccesMethodeWithObject v1 = (AccesMethodeWithObject) t1;
		Tree v2 = (Tree) a1;
	}

}
