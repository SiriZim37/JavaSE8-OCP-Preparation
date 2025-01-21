package func;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class B09_Supplier {

	public static void main(String[] args) {
		// annonyme Klasse 
		Supplier<Integer> s1 = new Supplier<Integer>() {
			public Integer get() {
				return 42;
			}
		};
		
		List<Integer> list1 = buildTest(5, s1);
		System.out.println(list1);

		
		// Lamda ausfühlich 
		Supplier<Integer> s2 = () -> {
			return 42 ; 
		};
		List<Integer> list2 = buildTest(5, s2);
		System.out.println(list2);
		
		// Lamda kompakt 
		Supplier<Integer> s3 = () -> 42 ; 
		List<Integer> list3 = buildTest(5, s3);
		System.out.println(list3);
	}
	
	static List<Integer> buildTest(int size , Supplier<Integer> s) {
		List<Integer> list = new ArrayList<>();
		for(int i = 0 ; i < size ; i++) {
			list.add(s.get());
		}
		return list;
		
	}

}
