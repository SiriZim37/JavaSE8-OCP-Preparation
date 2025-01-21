package ocp;

public class Concurrency18 {
	/*
	 * public class Messager implements Runnable {
	 *   public static void main(String[] args) {
	 *     new Thread(new Messager("Wallace")).start();
	 *     new Thread(new Messager("Gromit")).start();
	 *   }
	 *   private String name;
	 *   public Messager(String name) { this.name = name; }
	 *   public void run() {
	 *     message(1); message(2);
	 *   }
	 *   private synchronized void message(int n) {
	 *     System.out.print(name + "-" + n + " ");
	 *   }
	 * }
	 *
	 * Which is a possible result?
	 *
	 * A. Wallace-1 Wallace-2 Gromit-1
	 * B. Wallace-1 Gromit-2 Wallace-2 Gromit-1
	 * C. Wallace-1 Gromit-1 Gromit-2 Wallace-2
	 * D. Gromit-1 Gromit-2
	 * E. Gromit-2 Wallace-1 Gromit-1 Wallace-2
	 * F. The code does not compile
	 * G. An error occurs at runtime
	 *
	 * C is correct. Both threads will print two messages each. Wallace-1 must be before Wallace-2, 
	 * and Gromit-1 must be before Gromit-2. Other than that, the Wallace and Gromit messages 
	 * can be intermingled in any order.
	 * 
	 * A, B, D, E, F, and G are incorrect based on the above.
	 * 
	 * คำอธิบาย:
	 * - เนื่องจาก `message` เป็น method ที่ถูกซิงโครไนซ์ (synchronized) ทำให้สามารถมีการเรียกใช้จากหนึ่งเธรดได้ทีละคำสั่งเท่านั้น
	 * - แต่ละเธรดจะพิมพ์ข้อความ 2 ข้อความ, โดยที่ข้อความของ Wallace ต้องมาในลำดับที่ถูกต้อง เช่น `Wallace-1` ก่อน `Wallace-2`
	 * - เช่นเดียวกับ Gromit ที่ต้องพิมพ์ข้อความ `Gromit-1` ก่อน `Gromit-2`
	 * - ข้อความระหว่างเธรดสามารถสลับกันได้, ดังนั้นจึงเป็นไปได้ที่ผลลัพธ์จะเป็น `Wallace-1 Gromit-1 Gromit-2 Wallace-2` ซึ่งเป็นตัวเลือก C
	 * 
	 * ตัวเลือกอื่นๆ A, B, D, E, F และ G ไม่ถูกต้องเนื่องจากเหตุผลที่กล่าวถึงข้างต้น
	 */

}
