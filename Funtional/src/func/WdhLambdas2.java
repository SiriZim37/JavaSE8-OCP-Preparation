package func;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class WdhLambdas2 {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		
//		Predicate<Interger> p1 = x -> list.add(x);
		
		/*
		 * eine Klasse nachbilden : 
		 * 
		 * class Blabla implements Predicate<Object>{
		 * 		public boolean test(Object x)
		 * 			return list.add(x);		 // cf : Objrct-Argument 
		 * }
		 */
		
		StringBuilder sb = new StringBuilder();
//		Predicate<Object> p1 =  i -> sb.append(i).append(" ");		// cf 

		/*
		 * eine Klasse nachbilden : 
		 * 
		 * class Blabla implements Predicate<Object>{
		 * 		public boolean test(Object i)
		 * 			return  sb.append(i).append(" ");		 // cf : Stringbuilder zurück
		 * }
		 */
		
		Function<Integer, Object> f1 = x -> list.add(x);
		Function<Integer, Object> f2 =  i -> sb.append(i).append(" ");
		
		
	}


}
