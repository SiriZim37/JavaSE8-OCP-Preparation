package ocpexam;

import java.util.Arrays;
import java.util.List;


import java.util.function.Consumer;
import java.util.function.Supplier;

class Bird {
	public void fly(){ System.out.println("Can fly"); }
}

class Penquin extends Bird{
	public void fly(){ System.out.println("Cannot fly"); }
}


public class FunctionClassInterfaceReferenze3OCP {

	public static void main(String[] args)
	{
		fly(()->new Bird());
		fly(Penquin::new);
		
		/** Answered : C, D is correct because parameter of method's fly can be Supplier<Bird> or Supplier<? extends Bird>. **/
	}
	
	 // Option C (Correct)
    static void fly(Supplier<Bird> bird) {
        bird.get().fly();
    }

    // Option D (Fixed to also be correct)
//    static void fly(Supplier<? extends Bird> bird) {
//        bird.get().fly();
//    }
    
    
	

	/*// A.
	 	static void fly (Consumer<Bird> bird){  				// fail
	 		bird::fly();
	 	}
	*/
	/*// B.
	 	static void fly (Consumer<? extends Bird> bird){		// fail
	 		bird.accept().fly(); 	// Fixed : bird.accept()fly();
	 	}
	*/
}


/*
  Question No : 112

	Given:
	
	class Bird {
	public void fly () { System.out.print("Can fly"); }
	}
	class Penguin extends Bird {
	public void fly () { System.out.print("Cannot fly"); }
	}
	
	and the code fragment:
	
	class Birdie {
	public static void main (String [ ] args) {
	fly( ( ) -> new Bird ( ));
	fly (Penguin : : new);
	}
	/* line n1 
	}
	
	Which code fragment, when inserted at line n1, enables the Birdie class to compile?
	
	A. static void fly (Consumer<Bird> bird) {
	bird :: fly ();
	}
	B. static void fly (Consumer<? extends Bird> bird) {
	bird.accept( ) fly ();
	}
	C. static void fly (Supplier<Bird> bird) {
	bird.get( ) fly ();
	}
	D. static void fly (Supplier<? extends Bird> bird) {
	LOST
	
	Answer: C ถูก แต่ถ้าแก้ตัวเลือก D ให้ถูก สามารถตอบได้ทั้ง C,D
	
	Explanation: NOTE: Very confusing question. There is no logic in the options.
 */
