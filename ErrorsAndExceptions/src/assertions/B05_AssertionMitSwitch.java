package assertions;

public class B05_AssertionMitSwitch {

	public static void main(String[] args) {
		/*
		 Assertion ใน switch (OCP) คืออะไร?

		ใน Java เราสามารถใช้ assertions เพื่อตรวจสอบความถูกต้องของโค้ดในขณะ runtime
		โดย assertion จะช่วยตรวจสอบเงื่อนไขที่ควรเป็นจริง หากเงื่อนไขไม่เป็นจริงจะเกิดข้อผิดพลาดแบบ AssertionError
		การใช้ assertion ใน switch: ใน switch statement เราสามารถใช้ assertion
		เพื่อตรวจสอบค่าของตัวแปรที่ใช้ใน switch ได้ เช่น ตรวจสอบว่าค่าของตัวแปรตรงกับ case ที่เราคาดหวัง
		
		*/

		        int day = 3; // ค่าที่เราจะตรวจสอบ
		        switch (day) {
		            case 1:
		                System.out.println("Monday");
		                break;
		            case 2:
		                System.out.println("Tuesday");
		                break;
		            case 3:
		                System.out.println("Wednesday");
		                break;
		            default:
		                // ใช้ assertion เพื่อยืนยันว่าค่าไม่ควรเกิน 3
		                assert false : "Unexpected day value: " + day;
		        }

		/*
			อธิบายโค้ด:
			ตัวแปร day ถูกตรวจสอบใน switch statement
			หาก day มีค่าไม่ตรงกับ case ใดๆ (1, 2, 3) จะเข้าสู่ default
			ใน default เราใช้ assert false เพื่อโยนข้อผิดพลาดแบบ AssertionError พร้อมข้อความ
		 */
	}
}
