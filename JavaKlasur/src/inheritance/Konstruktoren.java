package inheritance;


class K1{

//	K1() {
//		super();
//	}
}

class K2 {
	int x ;
	
//	K2() {
//		super();
//		this.x = 0;
//	}

}

class K3 {
	int x = 12;
	
//	K3() {
//		super();
//		this.x = this;
//	}

}

class K4 {
	int x = 12;
	
	K4(int x){
//		super();
//		this.x = 12;
	}
	
	K4() {
		this(77);
	}
	
	K4(String s){
		super();
//		this.x =12;
	}
}

class K5 {
	K5(){
		super();
		System.out.println();
	}
}

// Exam 
/*
 * Basisklasse hat keinen Konstruktore, den die abgeleitete klass nicht kompiliert
 */
class Tier {
	Tier(int x){

	}
}

class Hund extends Tier {
	Hund(){
		super(0);
	}
}

class Katze extends Tier {
	Katze(){
		super(0);
	}
}

//class Hund extends Tier {
//// Hund() {
////	super();
//// }
//}
//
//class Katze extends Tier {
//Katze() {
//	// super();
//}
//}
//
//class Maus extends Tier {
//Maus() {
//	super();
//}
//}


//class K6 {
//K6() {
//	super();
//	super();				<- cf
//}
//K6(int x) {
//	// super();
//	System.out.println();
//	super();				<- cf
//}
//}


public class Konstruktoren  {
	
	
	public Konstruktoren(int x) {
		
	}
	
	public static void main(String[] args) {

	}

}
