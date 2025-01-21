package wdh.konstruktoren;

class Tier{
	int id;
	
	Tier(int id) {	// explizit- Konstruktor 
		//super();  	//  implizit super(); generiert !
		this.id = id;
	}
	
}

/*
class Hund extends Tier{
	
//	Hund() { 			// cf : generiert default- Konstruktor 
//		super();
//	}
	
}

class Katze extends Tier{
	
	Katze() { 			// explizit- Konstruktor 
		// super();  	// cf : implizit super(); generiert !
	}
	
}

class Zebra extends Tier{
	
	Zebra() { 			// explizit- Konstruktor 
		super();  	   // cf : explizit super(); aber Konstruktor in Tier nicht definiert 
	}
	
}
*/
class Maus extends Tier{
	
	Maus() { 			// explizit- Konstruktor 
		super(0);  	   // explizit super(); generiert !
	}
	
}


public class B03_Exam {

	public static void main(String[] args) {
		new Tier(111);
	}

}
