package func;

import java.util.function.Function;

public class B11_Funtion {
	/*
	 * Interface Funtiona <T1 , R>{
	 * 
	 * }
	 */
	public static void main(String[] args) {
		// annonyme Klasse 
		Function<String	, Integer> f1 = new Function<String, Integer>() {
			public Integer apply(String s) {
				return s.length() ;
			}
		};
		int sum1 = computerSum(f1, "a","bb","ccc");
		System.out.println("sum1 : " + sum1 );
		
		
		// Lamda ausfühlich 
		Function<String	, Integer> f2 = (String s) -> { // Aufruf : apply(String s) 
			return s.length();    						// return : Integer apply(String s) 
		};
		
		int sum2 = computerSum(f2, "a","bb","ccc");
		System.out.println("sum2 : " + sum2 );
		
		// Lamda Kompakte 
		Function<String	, Integer> f3 =  s  -> s.length() ;    
		int sum3 = computerSum(f3, "a","bb","ccc");
		System.out.println("sum3 : " + sum3 );
		
		// Sehr kompakt , ohne Zwischenvariable
		int sum4 = computerSum( s -> s.length() , "a","bb","ccc");
		System.out.println("sum4 : " + sum4 );
		

	} // end of main
	
	static int computerSum(Function<String, Integer> f , String... strings) {
		int sum = 0 ; 
		
		for (String s : strings) {
			int value = f.apply(s);
			sum += value;
		}
		return sum;
	}

}
