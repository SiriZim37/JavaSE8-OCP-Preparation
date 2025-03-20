package ocpexam;


interface BoxA<T> {
    T apply(T x);
}


public class InterfaceGenericButNotFunctionInterface {

	public static void main(String[] args) {
		
		BoxA<Integer> intBox = (x) -> x * 2;
        BoxA<?> wildcardBox = (Integer x) -> x * 2; // Error: Type mismatch
		 
        

        /*
         What is the problem with the second lambda expression assigned to wildcardBox?

		Options:
		
		a) The wildcard <?> in Box<?> means that the type is unknown, so you cannot assign a lambda expression that specifies the type (Integer x -> x * 2).
		
		b) The lambda expression (Integer x) -> x * 2 is valid for Box<?> because it is a wildcard that can match any type.
		
		c) Box<?> can only be used with types that are subclasses of Integer, not Integer itself.
		
		d) There is no issue with the lambda expression. It should work fine with Box<?>.
		
	
		
		
		Correct Answer: a) The wildcard <?> in Box<?> means that the type is unknown, so you cannot assign a lambda expression that specifies the type (Integer x -> x * 2).
         */
	}
}
