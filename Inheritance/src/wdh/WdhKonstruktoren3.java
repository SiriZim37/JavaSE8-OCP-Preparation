package wdh;


class CA {
	
	
	CA(){
		System.out.print("a");
	}
	
	CA(int x){
		System.out.print("c");
	}
}

class CB extends CA {
	CB(){
		// super();
		System.out.print("b");
	}
	
	CB(int x){
		// super();
		System.out.print("d");
	}
}




public class WdhKonstruktoren3 {

	public static void main(String[] args) {
	
//		new CB(); 
		new CB(123); // ad

	}

}
