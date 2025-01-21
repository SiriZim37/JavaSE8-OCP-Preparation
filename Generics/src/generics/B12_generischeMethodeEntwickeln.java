package generics;

import java.time.LocalDate;

/*
	 1. การใช้ Generic ในเมธอด getMax
	เมธอด getMax ถูกสร้างให้สามารถรับประเภทข้อมูลอะไรก็ได้ (ที่เป็นประเภทที่สามารถเปรียบเทียบกันได้) 
	โดยใช้ Generic Type และ Type Bound เพื่อให้ประเภทนั้นๆ ต้อง implements Comparable<T>
	
	<T extends Comparable<? super T>>:
	<T> หมายถึงประเภทข้อมูลทั่วไป (Generic Type) เช่น Integer, String, LocalDate ฯลฯ
	extends Comparable<? super T> หมายความว่า:
	T ต้อง implements Comparable ซึ่งทำให้เราสามารถใช้เมธอด compareTo เพื่อเปรียบเทียบค่าของ T ได้
	? super T หมายถึง เราสามารถใช้ประเภทที่เป็นพ่อของ T ในการเปรียบเทียบได้ ซึ่งเพิ่มความยืดหยุ่นในการเปรียบเทียบ 
	(ตัวอย่างเช่น ถ้า T คือ Integer ก็สามารถเปรียบเทียบกับ Number ซึ่งเป็น superclass ของ Integer ได้)
	
	2. การใช้งาน getMax ในโค้ด
	ใน main method มีตัวอย่างการใช้เมธอด getMax กับประเภทข้อมูลต่างๆ:
	
	Integer: getMax(12, -3) จะเปรียบเทียบตัวเลขทั้งสองและคืนค่าที่มากกว่า
	Double: getMax(33.0, 77.3) จะเปรียบเทียบตัวเลขทศนิยม
	String: getMax("mm", "aa") จะใช้ compareTo เพื่อเปรียบเทียบตัวอักษรในสายอักขระ
	LocalDate: getMax(date1, date2) จะใช้ compareTo เพื่อเปรียบเทียบวันที่
	
	3. ข้อผิดพลาดในการคอมไพล์ (Compile-time error)
	โค้ดบางบรรทัดที่คอมเมนต์ออก (เช่น getMax(12, date1)) จะไม่สามารถคอมไพล์ได้ เพราะการใช้ประเภทที่ไม่สามารถเปรียบเทียบกันได้ เช่น int กับ LocalDate ซึ่งไม่สามารถเปรียบเทียบกันได้ตรงๆ
	
	นอกจากนี้ยังมีตัวอย่างการใช้ Thread ซึ่งไม่สามารถใช้ compareTo ได้เนื่องจาก Thread ไม่ได้ implements Comparable:
	
	getMax(new Thread(), new Thread()) จะไม่สามารถคอมไพล์ได้เพราะ Thread ไม่มีการเปรียบเทียบ (ไม่สามารถใช้ compareTo ได้)
 */
public class B12_generischeMethodeEntwickeln {

	public static void main(String[] args) {
		// Demonstrating getMax with integer values
        int x = getMax(12, -3);  // int, auto-boxed to Integer
        System.out.println("x = " + x);
        
        // Demonstrating getMax with double values
        double d = getMax(33.0, 77.3);  // double, auto-boxed to Double
        System.out.println("d = " + d);
        
        // Demonstrating getMax with String values (Comparable)
        String s = getMax("mm", "aa");  // String, using compareTo
        System.out.println("s = " + s);
        
        // Demonstrating getMax with LocalDate values
        LocalDate date1 = LocalDate.of(2024, 1, 1);
        LocalDate date2 = LocalDate.of(2024, 1, 1);
        LocalDate date = getMax(date1, date2);  	// LocalDate, using compareTo
        System.out.println("date = " + date);
        
        // These calls will not compile due to type safety
//         getMax(12, date1);  		 // Incompatible types (int vs. LocalDate)
//         getMax("moin", 33.0); 		 // Incompatible types (String vs. double)
//         getMax(12, 33.0);  		 // Incompatible types (int vs. double)
        
//         getMax(new Thread(), new Thread());   // Thread does not implement the Comparable interface
         getMax("Apple", "Banana");	
         System.out.println(getMax("Apple", "Banana")); 
    }
	

    // Generic method to get the maximum of two elements
    // T must extend Comparable to be able to compare the values
	/*
		static <T extends Comparable<T>> T getMax(T a, T b) {
			if (a.compareTo(b) > 0) {
			    return a;
			}
			return b;
	 	}
	 *
	 *    
	 *    Mit der Methode kompiliert der Aufruf nicht : 
	 *    	LocalDate date = getMax(date1, date2); 
	 *    
	 *    Da 	: 	Localdate extends ChronoLocalDate
	 *    und 	: 	ChronoLocalDate implements Comparable<ChronoLocalDate> 
	 *    folgt : 	LocalDate IST Comparable<ChronoLocalDate>
	 *    aber 	: 	Typebound sagt , dass T muss Comparable<T> sein
	 */
	/*
	 * 		static <T extends Comparable<? super T>> void sort(List<T> list)
	 *  	- เมธอดนี้ใช้ Generic กับ Type Bound ที่บังคับให้ T ต้อง extend Comparable<? super T>
	 */
	/*
	 * เมธอดนี้ใช้ Generics โดยใช้รูปแบบ <T extends Comparable<? super T>>:
	 *
	 * 1. <T> หมายถึง ประเภทข้อมูลทั่วไป (Generic Type) ซึ่งจะถูกแทนที่ในขณะรันไทม์ เช่น Integer, String หรือประเภทอื่นๆ
	 *
	 * 2. extends Comparable<? super T> หมายความว่า:
	 *    - T ต้อง implement อินเตอร์เฟส Comparable ซึ่งช่วยให้เราสามารถเปรียบเทียบค่าของ T ได้
	 *    - ? super T หมายถึง เราสามารถใช้ประเภทพ่อ (superclass) ของ T ในการเปรียบเทียบได้ ซึ่งเพิ่มความยืดหยุ่นให้กับการเปรียบเทียบ
	 *    - เช่น ถ้า T คือ Integer เราสามารถเปรียบเทียบกับ Number ซึ่งเป็น superclass ของ Integer ได้
	 *
	 * 3. เมธอดนี้จะเปรียบเทียบ 2 ค่า a และ b โดยใช้เมธอด compareTo()
	 *    - ถ้า a มากกว่า b จะคืนค่า a
	 *    - ถ้า b มากกว่า a จะคืนค่า b
	 *
	 * ตัวอย่างการใช้งาน:
	 *  getMax(10, 20);        		// ใช้กับ Integer
	 *  getMax("Apple", "Banana");  // ใช้กับ String
	 */
    static <T  extends Comparable<? super T>> T getMax(T a, T  b) {
        if (a.compareTo(b) > 0) {
            return a;
        }
        return b;
    }
    
    
//    // Overloaded method for int values
//    static int getMax(int a, int b) {
//        if (a > b) {
//            return a;
//        }
//        return b;
//    }
//
//    // Overloaded method for double values
//    static double getMax(double a, double b) {
//        if (a > b) {
//            return a;
//        }
//        return b;
//    }
}
