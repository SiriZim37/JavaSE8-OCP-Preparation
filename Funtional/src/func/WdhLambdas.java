package func;

public class WdhLambdas {

	interface Runnable{
		void run();
	}
	
	
	public static void main(String[] args) {

//			Runnable v1  () ->{ ; };		// cf : Zuweisung fehlt
			
			Runnable v2 = () -> { ; };

//			Runnable v3 = () -> ;;
			
			Runnable v4 = () -> { ; };
			
			/*
			 * Bsp. 1 
			 * Ausgabe :  di
			 */
			System.out.println("*** Bsp. 1 ");
			Runnable v5 = () ->  System.out.println("mo");
			
			System.out.println("di");
			

			/*
			 * Bsp. 2 
			 * Ausgabe :  so mo
			 */
			System.out.println("*** Bsp. 2 ");
			Runnable v6 = () ->  
				System.out.println("sa");
				System.out.println("so");
						
			System.out.println("mo");


			/*
			 * Bsp. 3 
			 * Ausgabe :  so mo sa
			 */
			System.out.println("*** Bsp. 3 ");
			Runnable v7 = () ->  
				System.out.println("sa");
				System.out.println("so");
						
			System.out.println("mo");
			v7.run();
		
			
	} // end of main 

}
