package lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestNeueToArray {

	public static void main(String[] args) {

		List<Integer> listInt = new ArrayList<Integer>(Arrays.asList( 12 , 13 , 14 , 15 ));
	
		Integer[] arr4 = listInt.toArray(size -> new Integer[size]);
		
		System.out.println("arr4 " + Arrays.toString(arr4) );	// arr4 [12, 13, 14, 15]

	}

}
