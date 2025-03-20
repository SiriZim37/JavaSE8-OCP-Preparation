package variablen;

public class WdhIdentifier {

	public static void main(String[] args) {

		/*
		 * Given :
		 * int x1 = 1;  A
		 * int 1x = 2;	B
		 * int a% = 3;	C
		 * inf a$ = 4;	D
		 * int a_ = 5 ;	E
		 * 
		 * Which line have compilation error?
		 * []  A  
		 * [x] B	not allow number at first
		 * [x] C	not allow Operation to define variable % + - * /    
		 * []  D  
		 * []  E   
		 * 
		 */
		
			int x1 = 1 ;
//			int 1x = 2 ; 
//			int a% = 3 ;
			int a$ = 4 ;
			int a_ = 5 ;
	}

}
