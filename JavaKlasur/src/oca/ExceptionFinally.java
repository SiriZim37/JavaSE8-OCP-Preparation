package oca;


public class ExceptionFinally {

	/*
	 ทำไมเกิดปัญหา?
		คำสั่ง throw new Exception(); โยน checked exception ออกมา.
		แต่ในโค้ดนี้ไม่ได้จัดการ exception ด้วย try-catch หรือไม่ได้ประกาศ throws Exception ในเมธอด jumper().
		ดังนั้น คอมไพเลอร์จะฟ้องว่า exception นี้ไม่ได้จัดการ (unhandled).
	 */
	static void jumper(){
		try {
//			throw new Exception();		// Unhandled exception type Exception  // cf 
		} finally {
			System.out.println("finally");
		}
	}
	
	public static void main(String[] args) {
		try {
			jumper();
		} catch (Exception e) {
			System.out.println("exe");
		}
	}
}
