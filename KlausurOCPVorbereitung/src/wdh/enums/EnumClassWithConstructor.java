package wdh.enums;

import java.util.Arrays;
import java.util.Comparator;

enum Colors{
	RED("Stop") , GREEN("Go") , YELLOW("Ready")   	// static-contant of color type
   ,BLUE("Inner"){
		@Override
		public String toString() {
			return super.toString() + ":test";
		}
	};
//	protected Color(String string) {}// cf : Cannt create protected Constructor!
	
	private String signal;
	private  Colors(String signal) {
		this.signal = signal;
	}
	public String toString() {
		return "\nThis is color" + super.name() +  "["+ signal +"]";
	}
	
}


public class EnumClassWithConstructor {

	public static void main(String[] args) {
		
		
		// 1. Constant are Static-final
		Colors c1 = Colors.BLUE;   		
		System.out.println("1. " + c1);  // BLUE	
//		Color.GREEN = null; 	// cf : staic-constant are final , cant change value
		
		/*----------------------------------------------------------------*/
		
		// 2. Static-Method
		Colors[] allColors = Colors.values();  	
		System.out.println("2. allColors= " + allColors);	 //[Lwdh.enums.Color;@4aa8f0b4
		System.out.println("3. Arrays.toString(allColors)= " + Arrays.toString(allColors)); // [RED, GREEN, BLUE]	
		
		Colors c2 = Colors.valueOf("GREEN");
		System.out.println("4. c2= " + c2);		 		//GREEN
		
		/*----------------------------------------------------------------*/
		
		//3. Instant-Method
		
		// public final String name()
		String name =  c2.name();  
		System.out.println("5. name= " + name);  		// GREEN
		
		// public final String name()
		int ordi =  c2.ordinal();  
		System.out.println("5. ordinal= " + ordi);  	// 1
		
		/*----------------------------------------------------------------*/
		
		// 4. every Enum is Comparable 
		/*
		 * enum แต่ละค่า เช่น RED, GREEN, BLUE จะมี ลำดับ (ordinal) ตามที่กำหนดในโค้ด (เริ่มต้นที่ 0) เช่น:
		 * RED -> ordinal = 0
		 * GREEN -> ordinal = 1
		 * BLUE -> ordinal = 2
		 */
			
		Colors[] values = Colors.values();  
		Comparator<Colors> cmp =  ( e1 , e2 ) -> e1.name().compareTo(e2.name());
		Arrays.sort(values , cmp);
		System.out.println(Arrays.toString(values));	// [BLUE, GREEN, RED]

		Comparator<Colors>  reversed = cmp.reversed();
		Arrays.sort(values , reversed);
		System.out.println(Arrays.toString(values));	// [RED, GREEN, BLUE]
		
		
	}
}
