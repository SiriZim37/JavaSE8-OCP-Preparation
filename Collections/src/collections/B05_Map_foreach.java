package collections;

import java.time.LocalDate;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class B05_Map_foreach {

	public static void main(String[] args) {


		Map<Integer, String> map = MyMapUtils.mapWoche();
		
		System.out.println(	map.values());
		
		/*
		 * default void forEach(BiConsumer<? super K, ? super V> action)
		 * 
		 * vereinfacht betrachtet :
		 * default void forEach(BiConsumer<K,V) action
		 */

		BiConsumer<Integer, String> bc1 = (Integer key , String value) ->{
			System.out.println(key+" = "+ value);
		};
		System.out.println(bc1);
		
		map.entrySet().forEach( entry -> System.out.println(entry.getKey() + " = " + entry.getValue()));
		


	}

}
