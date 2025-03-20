package oca;

public class WrapperClassAutoBoxingUnBoxing {

	public static void main(String[] args) {
		
		Short s1 = 200;
		Integer s2 = 100;
		Long s3 = s1 + (long)s2 ;  // ok  s1 จะถูกแปลงเป็นค่า short ที่เก็บไว้ในตัวแปร Short และจะถูกแปลงเป็น int (ค่า primitive) โดยอัตโนมัติเมื่อใช้ในการคำนวณ 
							      //  s2 ซึ่งเป็นตัวแปรชนิด Integer จะถูกแปลงเป็นค่า int โดยการ unboxing (การแปลงจาก wrapper class เป็น primitive type)
		 s3 = (long) s1 + s2 ;    // ok 
		Integer s4 = (int)(s2*s3);
//		String s4 = (String)(s2*s3);
//		System.out.println("Sum ist " + s4 );			// cf 

		 /*
		  	String s4 = (String)(s2 * s3);

			โค้ดนี้ผิดพลาด เนื่องจากการแปลง (String) ไม่สามารถแปลงผลลัพธ์ของการคูณ (s2 * s3) ซึ่งเป็นชนิดตัวเลข (long) เป็น String ได้โดยตรง
			System.out.println("Sum ist " + s4);
			
			การแสดงผลจะไม่สามารถทำงานได้ เนื่องจากตัวแปร s4 มีการประกาศผิดพลาด
		  */
	}
}
