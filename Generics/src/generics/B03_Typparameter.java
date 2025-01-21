package generics;



public class B03_Typparameter {

	/*
	 * Typparameter kann den Namen wie ein Java-Identifier
	 * bekommen ( sollte aber aus Grossbuchstaben bestehen)
	 */
	
	class C1 <BuchStaBen_1234_$> {	// geht aber nicht so Gut
		
	}
	
	class C2<A>{	// ok 
		// static A staticRef;
				A ref;
	}
	
	/*
	 * Mehrere Typparameter kann es geben
	 */
	class C3<T1,T2,T3,T4,T5>{
		
	}
	
	
	/*
	 * Typparameter kann man erben
	 * (s. auch ArrayList implements List)
	 */
	static class Base<T>{
		T get() {
			return null ;
		}
	}
	
	// normale Klasse DerviedA
	static class DerviedA extends Base<String>{}		
	
	// generische Klasse DerviedB mit dem eigenen Txpparameter
	static class DerviedB <T> extends Base<String>{}			

	// generische Klasse DerviedC , die den Typparameter erbt
	static class DerviedC <T> extends Base<T>{}			
	
	public static void main(String[] args) {
		
		DerviedA v1 = new DerviedA();
		String s1 = v1.get();
		
		/*	return typ Base<String>
		 * 	new DerviedB<>();
		 */
		DerviedB<Integer> v2 = new DerviedB<>();	// DerviedB ist immer Base<String> 
		String s2 = v2.get();
		
		
		/*	return typ
		 * 	new DerviedC<Integer>();
		 */
		DerviedC<Integer> v3 = new DerviedC<Integer>(); // DerviedC<Integer> ist  Base<Integer> 
		Integer s3 = v3.get();
	}

}
