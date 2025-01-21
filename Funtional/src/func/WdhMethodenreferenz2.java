package func;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class WdhMethodenreferenz2 {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1,2,3,4);
		
		// void forEach(Consumer<Integer> action) {
		list.forEach(System.out::print);

		System.out.println();
		
		// Consumer<T>  void accept 
		Consumer<Integer> action = System.out::print;
		
		Consumer<Integer> actions = new Consumer<Integer>() {		
			@Override
			public void accept(Integer t) {
				System.out.print(t);
			}
		};
		for (Integer i : list) {
			actions.accept(i);
		}
		
		
	}

}
