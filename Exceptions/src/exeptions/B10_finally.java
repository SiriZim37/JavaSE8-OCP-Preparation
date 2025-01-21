package exeptions;

import java.io.FileReader;
import java.io.IOException;

public class B10_finally {

	/*
	 * 	- finally läuft immer , wenn der ( und evtl. catch) bendet wird  
	 * 			ส่วนของ finally จะทำงานเสมอเมื่อ (และ catch ถ้ามี) จบการทำงาน
	 * 
	 * 	- in dem finally-Block kann man garantiert 'Ressourcen' schliessen
	 * 			ใน finally block เราสามารถปิด 'ทรัพยากร' ได้อย่างแน่นอน
	 * 
	 * 	- Sinvolles Bsp. gibt es im Projekt 'Threads' (Interface 'Lock')
	 * 			ตัวอย่างที่มีประโยชน์อยู่ในโปรเจค 'Threads' (ใช้ Interface 'Lock')
	 * 
	 */
	public static void main(String[] args) {
		vorJava7();

	}
	/*
	 * In dem finally-Block wird die Ressource garantiert geschlossen , 
	 * falls sie geöffnet wird.	 ใน finally block จะปิดทรัพยากรอย่างแน่นอนถ้าได้เปิดไว้
	 * 
	 * So hat man programmiert, bevor es in Java try-with
     * การเขียนแบบนี้เป็นวิธีที่ใช้ก่อนที่จะมี try-with-resources ใน Java 7
	 */
	static void vorJava7() {
		FileReader fr = null;
		try {
			 fr = new FileReader("file2.txt");
			
			// Datei lesen...
			// andere Sachen erledigen...
			// Datei lesen...
			// andere Sachen erledegen...
			
			System.out.println("Datei geöffnet");
			
		} catch (IOException e) {
			System.out.println("IOException");
			e.printStackTrace();
		}finally {
			System.out.println("finally");
			try {
				
				if(fr!=null) {
					fr.close();
				}
				System.out.println("Datei schliessen");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
