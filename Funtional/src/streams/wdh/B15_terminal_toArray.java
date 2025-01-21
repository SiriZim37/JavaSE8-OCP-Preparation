package streams.wdh;

import java.util.Arrays;
import java.util.function.IntFunction;
import java.util.stream.Stream;

public class B15_terminal_toArray {

	public static void main(String[] args) {
	
		/*
		 *   Object[] toArray();
		 */
		Object[] arr1 = Stream.of("a" , "bb" , "c" , "dd" , "e" , "ff")
								.filter( s -> s.length() > 1)
								.toArray();
		
		System.out.println("Typ von arr1 : " + arr1.getClass().getSimpleName()); 		// Object[]
		System.out.println("arr1: " + Arrays.toString(arr1)); 	// [bb, dd, ff]  
			
		
		System.out.println("------------------------------------------------------------------\n");
		/*
		 * <A> A[] toArray(IntFunction<A[]> generator)
		 */
		
		IntFunction<String[]> f1 = length -> new String[length];
		/*
		 * .toArray(f1) converts the filtered stream back into an array, 
		 * using the IntFunction f1 to create the new array of the appropriate size
		 * toArray(f1) แปลง Stream ที่กรองแล้วกลับไปเป็นอาร์เรย์ โดยใช้ IntFunction f1 เพื่อสร้างอาร์เรย์ใหม่ที่มีขนาดเหมาะสม
		 */
		String[] arr2 =  Stream.of("a" , "bb" , "c" , "dd" , "e" , "ff")
							.filter( s -> s.length() > 1)
							.toArray(f1);					// liefert new Array zurück 
		
		
		System.out.println("Typ von arr2 : " + arr2.getClass().getSimpleName()); 		// Object[]
		System.out.println("arr2: " + Arrays.toString(arr2)); 	// [bb, dd, ff]
	}

}
