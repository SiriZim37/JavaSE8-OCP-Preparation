package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class B03_List_replaceAll {

	public static void main(String[] args) {


		List<Integer> list = Arrays.asList(1, null , 2 , null);
		
		System.out.println("1. list : " + list);		// list : [1, null, 2, null]
		
		/*
		 * default void replaceAll(UnaryOperator<E> operator)
		 */
		
		UnaryOperator<Integer> op1 = (Integer x ) ->{
			return x != null ? x : 0 ;
		};
		
		list.replaceAll(op1);

		System.out.println("2. list : " + list );   		// list = [1, 0, 2, 0]
		
		list.replaceAll( x -> x != null ? x : 0  );
		
		System.out.println("3. list : " + list );   		// list = [1, 0, 2, 0]
		

	}

}
