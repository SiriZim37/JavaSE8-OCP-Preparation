package aufgaben;

class Printer extends Thread{
	private char zeichen;
	private int anzahlZeichen;
	private int anzahlZeilen;

	Printer(char zeichen , int anzahlZeichen , int anzahlZeilen){
		this.zeichen = zeichen;
		this.anzahlZeichen = anzahlZeichen;
		this.anzahlZeilen = anzahlZeilen;
	}

	// Variante 1 
	/*
	 * การใช้ this เป็น Monitor
	 * 	-	ใน Java เมื่อใช้ synchronized (this) จะหมายถึง Thread ที่เข้าไปในโค้ดนี้จะล็อก this ซึ่งเป็นอ็อบเจกต์ของอินสแตนซ์ปัจจุบันที่ใช้งานอยู่
	 * 	-	หากแต่ละ Thread มีอ็อบเจกต์ของตัวเอง เช่น Printer แต่ละ Thread จะมี this ที่ต่างกัน
	 *	-	นั่นหมายความว่า Thread แต่ละตัวจะล็อกเฉพาะอ็อบเจกต์ของตัวเอง และไม่ส่งผลต่อกัน
	 * 	-	ผลลัพธ์คือ Threads ไม่ได้ทำงานแบบ Synchronize ร่วมกัน
	 * 2. การใช้ Shared Object เพื่อ Synchronization
	 * 	-	เพื่อให้ Threads ทุกตัวทำงานแบบ Synchronize ร่วมกัน จะต้องใช้ อ็อบเจกต์ตัวเดียวกัน สำหรับการล็อก
	 * 	-	ในกรณีของคุณ:
	 * 	-	ใช้ Printer.class หรือสร้างอ็อบเจกต์ static สำหรับการล็อก
	 * 	-	วิธีนี้ทำให้ทุก Thread ใช้ Monitor เดียวกัน เมื่อ Thread หนึ่งล็อกไว้ Thread อื่นจะต้องรอจนกว่าจะปล่อยล็อก
	 */
	@Override
	public void run() {		
		for (int i = 0; i < anzahlZeilen; i++) {
			//การ Synchronize ด้วย Class-Level Object			
			//ในโค้ดนี้ Threads ทุกตัวจะใช้ล็อกร่วมกัน (Printer.class) ทำให้มั่นใจได้ว่า 
			//มีเพียง Thread เดียวเท่านั้นที่เข้าถึงโค้ดใน synchronized block ได้ในเวลาเดียวกัน	
			
			synchronized (Printer.class) { 			// auch ok synchronized (System.out) 
				for (int j = 0; j < anzahlZeichen; j++) {
					System.out.print(zeichen);			
				}
				System.out.println();
			}
			MyThreadUtils.pause(1);
		}
	}
	
	// Variante 2 
//	@Override
//	public void run() {		
//		String line = new StringBuilder()
//					.repeat(zeichen, anzahlZeichen)
//					.toString();
//		for (int i = 0; i < anzahlZeilen; i++) {
//			System.out.println(line);
//		}
//	}
	
	
}

public class AufgabenThreadsPrinter {
	
	public static void main(String[] args) throws InterruptedException {
		
		
		Printer p1 = new Printer('a', 10, 20);
		p1.start();
		
		Printer p2 = new Printer('*', 15, 40);
		p2.start();
		
		p1.join();
		p2.join();

		System.out.println("End");

	}

}
