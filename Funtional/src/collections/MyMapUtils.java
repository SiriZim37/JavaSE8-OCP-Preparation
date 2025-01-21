package collections;

import java.util.Map;
import java.util.TreeMap;

public class MyMapUtils {

	public static Map<Integer,String> mapWoche() {
		Map<Integer , String> map = new TreeMap<>();
		
		map.put(1, "mo");
		map.put(2, "di");
		map.put(3, "mi");
		map.put(4, "do");
		map.put(5, "fr");
		
		return map;
	}

}
