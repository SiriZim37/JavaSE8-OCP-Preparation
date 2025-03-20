package exceptions.wdh;



public class WdhTryCatch {

	public static void main(String[] args) {

		b5();
		System.out.println();
		System.out.println(getStringB6("H","A"));
	}
	
	static String getStringB6(String a , String b ) {

		try {
			return a + " " + b;
		} catch (RuntimeException e) {
			System.out.print("g ");  
		}finally {
			System.out.print("f ");  
		}
		return null;
	}
	// Ausgabe :  t c1 c2 f 
	static void b5() {

		try {
			System.out.print("t ");  
			System.out.print(5/0);  

		} catch (RuntimeException e) {
			System.out.print("c1 ");
			try {
				System.out.print(5/0);  
				System.out.print("t2 ");  
			} catch (Exception e2) {
				System.out.print("c2 ");  
			}	
		}finally {
			System.out.print("f ");
		}

	}
	
	// Ausgabe :  Compiler fehler 
	static void b4() {
		/* 
			try {
				System.out.print("t ");  
				Integer.valueOf("12");	
			} catch (IllegalArgumentException e) {   // IllegalArgumentException ist Basisklasse 
				System.out.print("c2 ");
			}catch (NumberFormatException e) {  	// cf : Abgeleitete Klasse
				System.out.print("c2 ");	
			}finally {
				System.out.print("f ");
			}
		*/
	}

	
	// Ausgabe : t c2 f 
	static void b3() {
		try {
			System.out.print("t ");  
			System.out.print(5/0);  
			
		} catch (NullPointerException e) {
			System.out.print("c1 ");
		} catch (RuntimeException e) {
			System.out.print("c2 ");
		}finally {
			System.out.print("f ");
		}
		
	}
	
	// Ausgabe : t c f 
	static void b2() {
		try {
			System.out.print("t ");  
			System.out.print(5/0);  
		} catch (Exception e) {
			System.out.print("c ");
		}finally {
			System.out.print("f ");
		}
		
	}
	
	
	// Ausgabe : t f 
	static void b1() {
		try {
			System.out.print("t ");  
		} catch (Exception e) {
			System.out.print("c ");
		}finally {
			System.out.print("f ");
		}
		
	}
}
