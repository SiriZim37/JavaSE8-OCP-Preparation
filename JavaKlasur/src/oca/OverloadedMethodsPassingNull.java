package oca;

public class OverloadedMethodsPassingNull {

	/*
	 * Method Overloading
	 * 
	 * 1. Different number or types of parameters:  ต้องมีจำนวนหรือชนิดของพารามิเตอร์ต่างกัน: 
	 * 2. Same method name ชื่อเมธอดต้องเหมือนกัน: 
	 * 3. Return type does not matter: ไม่เกี่ยวกับชนิดของค่าที่คืนกลับ (Return type)
	 */
	   public static void main(String[] args) {

	        
//	        printValue();	// cf 
		   
	        printValue("","jk");
	    }

	    static void printValue(String s) {
	        System.out.println("String method");
	    }

	    static void printValue(Object o) {
	        System.out.println("Object method");
	    }
	    
	    static String printValue(String s1 , String s2) {
	    	System.out.println( s1 + s2);
	       return s1 + s2 ;
	    }

}
