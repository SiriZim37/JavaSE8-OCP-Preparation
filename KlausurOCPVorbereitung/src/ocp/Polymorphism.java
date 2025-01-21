package ocp;

class Helper {
	  public static void help(Tool t) {
	    t.work();
	    t.name();
	    t.work();
	} }

class Tool {
	  public void work() {
	    System.out.print("work ");
	  }
	  public void name() {
	    System.out.print("tool ");
	} }

class Hammer extends Tool {
	  public void work() {
	    System.out.print("bang ");
	} }
	
public class Polymorphism {

	/*
	 * Which are possible as output from invoking the Helper.help() method? (Choose all that apply.)
	 * 
	 * 	public static void main(String[] args) {
			new Helper().help(new Tool());
			System.out.println();
			new Helper().help(new Hammer());
	    }
	
	 * A.bang tool bang
	 * B.bang tool work
	 * C.work tool bang
	 * D.work tool work
	 * E.Code fails to compile
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * A and D are correct. Helper.help() can be passed Tool or any subclass of Tool. Since Hammer is a subclass, bang can be in the output.
	 * B, C, and E are incorrect based on the above.
	 */
	public static void main(String[] args) {
		new Helper().help(new Tool());
		System.out.println();
		new Helper().help(new Hammer());
	}

	/*
	 * วิธีการทำงาน:
	เมื่อเรียกใช้ Helper.help() และส่งผ่านออบเจ็กต์ที่เป็น Tool หรือ Hammer ไปยังเมธอด help()
	ถ้าใช้ Tool: เมธอด work() จะเรียกใช้จาก Tool ซึ่งแสดงข้อความ "work ".
	ถ้าใช้ Hammer: เมธอด work() จะถูก Override ให้แสดงข้อความ "bang " ตามที่กำหนดในคลาส Hammer.
	
	คำตอบที่ถูกต้อง:
	A. bang tool bang
		เมื่อส่ง Hammer ไปยัง Helper.help() เมธอด work() ใน Hammer จะถูกเรียกใช้ (แสดง "bang ") 
		และ name() ใน Tool จะแสดง "tool ", หลังจากนั้น work() จะถูกเรียกอีกครั้งและแสดง "bang ".
	D. work tool work
		เมื่อส่ง Tool ไปยัง Helper.help() เมธอด work() ใน Tool จะถูกเรียกใช้ (แสดง "work ") 
		และ name() ใน Tool จะแสดง "tool ", หลังจากนั้น work() จะถูกเรียกอีกครั้งและแสดง "work ".
	 */
}
