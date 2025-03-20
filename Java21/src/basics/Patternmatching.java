package basics;

public class Patternmatching {

	public static void main(String[] args) {


		Object obj = null ;
		
		/*
		 * normaler Code
		 */
		
		if(obj instanceof Integer) {
			Integer x = (Integer) obj;
			System.out.println(x++);
		}else if( obj instanceof String) {
			String x=  (String) obj;
			System.out.println(x.toUpperCase());
		}
		
		/*
		 * neu (nicht in Java 8);
		 * 		Pttern Mathcing for instanceOf
		 */
		
		if(obj instanceof Integer x) {
			System.out.println(x++);
		}else if( obj instanceof String x) {
			System.out.println(x.toUpperCase());
		}
		
		/*
		 * neu (nicht in Java 8);
		 * 		Pttern Mathcing for switchOf
		 */
		
		switch (obj) {
			case Integer x: 
				System.out.println(x++);
				break;
			case String x: 
				System.out.println(x.toUpperCase());
				break;
			default:
			
		}

	}

}
