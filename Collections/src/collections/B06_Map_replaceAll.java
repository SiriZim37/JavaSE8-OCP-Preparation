package collections;

import java.util.Map;
import java.util.function.BiFunction;

public class B06_Map_replaceAll {

	public static void main(String[] args) {
	
		Map<Integer , String> map = MyMapUtils.mapWoche();

		//  {1=mo, 2=di, 3=mi, 4=do, 5=fr}
		System.out.println("1. map : " + map ); 
		
		/*
		 * default void replaceAll(BiConsumer<? super K, ? superU , ? extends V>  function)
		 * 
		 * vereinfacht  :
		 * default void replaceAll(BiFunction<K, U , V> function) 
		 */
		BiFunction<Integer,String, String> biFunc1 = new  BiFunction<Integer,String, String>() {
			public String apply(Integer key, String oldValue) {
				return oldValue.toUpperCase();
			};
		};
		

		map.replaceAll(biFunc1);
		//{1=MO, 2=DI, 3=MI, 4=DO, 5=FR}
		System.out.println("2. map : " + map ); 
		
		
		BiFunction<Integer,String, String> biFunc2 = (Integer key, String oldValue) -> {
				if(key==4) {
					oldValue = "DONESTAG";
				}
				return oldValue.toUpperCase() ;
		};
		
		map.replaceAll(biFunc2);
		//3. map : {1=MO, 2=DI, 3=MI, 4=DONESTAG, 5=FR}
		System.out.println("3. map : " + map ); 
		
		
		map.replaceAll((k,v) -> "<"+ v + ">");
		//4. map : {1=<MO>, 2=<DI>, 3=<MI>, 4=<DONESTAG>, 5=<FR>}
		System.out.println("4. map : " + map ); 
		
		
		
		
		
	}

}
