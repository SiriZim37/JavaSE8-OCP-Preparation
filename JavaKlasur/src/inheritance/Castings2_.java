package inheritance;


public class Castings2_ {

	public static void main(String[] args) {
		System.out.println(args.length);
		
		Double v11 = 12.3; 				
		
		Number v66 = (Number)v11;	   		
		
		System.out.println(v66); 	// 12.3	
		
		
//		Integer v1 = 12.3;				// cf : Integer <- IS KEIN <- Double
	
//		Integer v2 = (Integer)12.3; 	// cf :  (Interger)Double
		
		Number v3 = 12.3; 				// ok : Number <- IS-A <- Double
		
		Integer v4 = (Integer)v3;	    // ok : Integer <- IS-A <- Integer
		//  บรรทัดนี้จะคอมไพล์ได้ แต่ตอนรันจะเกิด ClassCastException 
		// เพราะ v3 ไม่ใช่ Integer แต่เป็น Double ดังนั้นเมื่อพยายามแคสต์ Double ไปเป็น Integer จะไม่สามารถแปลงได้
		
		System.out.println(v4); 		// ClassCastException  (NUmber nach Integer)
										// Zuweisung kompilert (Integer IS-A Integer)
										// Zur Laufzeit : ClassCastException
		
		
		////////////////////
		
		Number v5 = 12.3f; 				 // ok : Number <- IS-A <- Double
		
		Double v6 = (Double)v5;	   		 // cf : Double <- IS-A <- Number
		
		System.out.println(v6); 		// ClassCastException
		
		
	}


}
