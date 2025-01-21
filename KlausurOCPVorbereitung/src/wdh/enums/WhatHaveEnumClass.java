package wdh.enums;

import java.util.Arrays;
import java.util.Comparator;


enum Color{
	RED , GREEN , BLUE  	// static-contant of color type
	
	// default-enum-Constructor :
	// privat Color()...
}


public class WhatHaveEnumClass {

	public static void main(String[] args) {
		
		
		// 1. Constant are Static-final
		Color c1 = Color.BLUE;   		
		System.out.println("1. " + c1);  // BLUE	
//		Color.GREEN = null; 	// cf : staic-constant are final , cant change value
		
		/*----------------------------------------------------------------*/
		
		// 2. Static-Method
		Color[] allColors = Color.values();  	
		System.out.println("2. allColors= " + allColors);	 //[Lwdh.enums.Color;@4aa8f0b4
		System.out.println("3. Arrays.toString(allColors)= " + Arrays.toString(allColors)); // [RED, GREEN, BLUE]	
		
		Color c2 = Color.valueOf("GREEN");
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
			
		Color[] values = Color.values();  
		Comparator<Color> cmp =  ( e1 , e2 ) -> e1.name().compareTo(e2.name());
		Arrays.sort(values , cmp);
		System.out.println(Arrays.toString(values));	// [BLUE, GREEN, RED]

		Comparator<Color>  reversed = cmp.reversed();
		Arrays.sort(values , reversed);
		System.out.println(Arrays.toString(values));	// [RED, GREEN, BLUE]
		
		
	}
}
