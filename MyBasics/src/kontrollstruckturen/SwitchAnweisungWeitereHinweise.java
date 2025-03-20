package kontrollstruckturen;

public class SwitchAnweisungWeitereHinweise {
	static final Integer y5 = 8;
	static final int y6 = 8;
	public static void main(String[] args) {
		
		/*
		 * Für case-Zweige nur Compilerzeit-Konstanten!
		 */
		int day = 0;
		
		int y1 = 1;
		
		final int y2 = 2; // Compilerzeit-Konstante
		
		final int y3;	  // Laufzeit-Konstante
		y3 = 3;
		
		final int y4 = (int)Math.random(); // Laufzeit-Konstante
		
		switch(day) {
//			case y1:	// cf keine Compilerzeit-Konstante  y1 ไม่ใช่ final จึงไม่ใช่ค่าคงที่ที่คอมไพล์รู้ได้ ทำให้เกิดข้อผิดพลาด
			case y2: 	// ok y2 ถูกกำหนดเป็น final และมีค่าแบบคงที่ที่คอมไพล์รู้ได้ ดังนั้นสามารถใช้ได้
//			case y3:	//cf:  Compilerzeit-Konstante  ถึงแม้จะเป็น final แต่ค่า y3 กำหนดหลังจากคอมไพล์ ทำให้เป็นค่าคงที่ขณะรันไทม์ จึงไม่สามารถใช้ใน case
//			case y4:	//cf:  Compilerzeit-Konstante  y4 ถูกกำหนดด้วยการคำนวณแบบสุ่ม (Math.random()) ทำให้เป็นค่าคงที่ขณะรันไทม์ จึงไม่สามารถใช้ใน case
//			case y5:	//cf: แม้ y5 เป็น static final แต่เนื่องจากเป็น Integer (ไม่ใช่ primitive type) คอมไพล์จึงไม่รับ
			case y6:	//ok: y6 เป็น static final int ซึ่งเป็น primitive type คอมไพล์จึงรับ
		}
		
		/*
		 * Exam.
		 * 
		 * Keine mehrfachen Werte!
		 */
		switch(day) {
			case y2:
//			case 2:		// cf: 2 gibt es bereits
		}

	}

}
