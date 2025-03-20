package wdh;

class CC1{
	int x = 17 ; 
	/*
	 * 
	 */
}

class CC2{
	int x = 17 ; 
	CC2(){
		// super();
		x = 42;
	}
}



class CC3{
	int x = 17 ; 
	CC3(){
		// super(); 
		// No Attribute 
	}
	CC3(int x ){
		// super(); 
		// No generiert vom Attribute 
	}

}

class CC4{
	int x = 17 ; 
	CC4(){
		this(42);
	}
	CC4(int x){
		this("-9")	;
	}
	CC4(String x){
		// super();
		//	x = 17;
	}
}


public class WdhKonstruktoren {

	public static void main(String[] args) {
		
		System.out.println(new CC1().x); // 17 
		System.out.println(new CC2().x); // 42
		System.out.println(new CC3(42).x); // 17
		System.out.println(new CC4().x); // 17
	}

}
