package nio;


import java.io.File;
import java.io.IOException;
import java.nio.file.Path;      // นำเข้า Path คลาสจากแพ็กเกจ java.nio.file สำหรับจัดการเส้นทางไฟล์
import java.nio.file.Paths;     // นำเข้า Paths คลาสที่ใช้สร้างอินสแตนซ์ของ Path

public class B01_Pfade {

	/*
	 * Pfade" หมายถึง เส้นทาง (Path) ที่ใช้ในการอ้างอิงไฟล์หรือไดเรกทอรีในระบบไฟล์ ซึ่งจะเป็นที่ตั้งของไฟล์หรือไดเรกทอรีที่โปรแกรมต้องการเข้าถึง อ่าน หรือเขียนข้อมูล
	 * 
	 * 
		ใน Java SE เกี่ยวกับการทำงานกับ IO (Input/Output) "Pfade" หมายถึง เส้นทาง (Path) ที่ใช้ในการอ้างอิงไฟล์หรือไดเรกทอรีในระบบไฟล์ ซึ่งจะเป็นที่ตั้งของไฟล์หรือไดเรกทอรีที่โปรแกรมต้องการเข้าถึง อ่าน หรือเขียนข้อมูล
		
		ประเภทของ Pfade (Path)
		1.Absolute Path (เส้นทางแบบสมบูรณ์):
		
			- เป็นเส้นทางที่เริ่มต้นจาก root ของระบบไฟล์ เช่น
				บน Windows: C:\Users\Username\Documents\file.txt
				บน Unix/Linux: /home/username/documents/file.txt
			- Absolute Path จะอ้างอิงไปยังที่ตั้งของไฟล์หรือไดเรกทอรีได้ตรงตำแหน่ง
		2.Relative Path (เส้นทางแบบสัมพัทธ์):
		
			- เป็นเส้นทางที่อ้างอิงตามตำแหน่งปัจจุบันของโปรแกรม
			- เช่น documents/file.txt หมายถึงว่าไฟล์ file.txt อยู่ในโฟลเดอร์ documents ซึ่งอยู่ในตำแหน่งปัจจุบันของโปรแกรม
			- ใช้ประโยชน์ได้ดีเมื่อไม่ต้องการระบุตำแหน่งที่แน่นอนของไฟล์
			
		Java มีคลาส Path และ Paths (อยู่ในแพ็กเกจ java.nio.file) ที่ช่วยในการจัดการกับเส้นทางของไฟล์หรือไดเรกทอรีได้ง่ายขึ้น เช่น
	 */	 
	public static void main(String[] args) throws IOException {


		/*
		 * Pfadandegeb (Path root) mit String  
		 * การกำหนดเส้นทางแบบ Absolute (Absolute Path)
		 */
		
		String p1 = "C:\\Windows"; 		// absolut , Windows-Notation		
		String p2 = "/Windows/Temp"; 	//UNIX-Notation
		
		/*
		 * relative Pfad (Relativ zum aktuellen Arbeitsverzeichenis)
		 * เส้นทางแบบ Relative (Relative Path) ที่สัมพันธ์กับตำแหน่งการทำงานปัจจุบัน
		 */
		String p3 = "dir\\subdir\\file"; // Windows-Notation
		String p4 = "dir/subdir/file";   // Unix-Notation
		
		
		
		/*
		 * Spezielle relative Pfadangeben
		 * 
		 * 		. 		- aktuelles Verzeichnis 
		 * 				    "." (จุดเดียว): หมายถึง โฟลเดอร์ปัจจุบัน หรือ ไดเรกทอรีที่ทำงานอยู่ในขณะนั้น 
		 * 				    เช่น ถ้าเรากำลังทำงานในโฟลเดอร์ C:\Users\Username\Documents การใช้ "." หมายถึงโฟลเดอร์นี้ (ตำแหน่งที่โปรแกรมทำงานอยู่)
		 * 		..		- Oberverzeichnis über dem aktuellen Verzeichnis
		 * 					".." (สองจุด):หมายถึง โฟลเดอร์ระดับบนสุด หรือ หนึ่งระดับขึ้นไปจากโฟลเดอร์ปัจจุบัน 
		 * 					เช่น ถ้าเราอยู่ในโฟลเดอร์ C:\Users\Username\Documents การใช้ ".." หมายถึงโฟลเดอร์ C:\Users\Username
		 * 					ตัวอย่าง: new File("..") จะไปที่โฟลเดอร์ที่สูงกว่าโฟลเดอร์ปัจจุบันหนึ่งระดับถ้าเราใช้ "..\.." มันจะไปที่โฟลเดอร์ที่สูงขึ้นสองระดับ
		 * 
		 * 			. ใช้เพื่ออ้างอิงถึงโฟลเดอร์ปัจจุบัน
					.. ใช้เพื่ออ้างอิงถึงโฟลเดอร์ที่อยู่เหนือโฟลเดอร์ปัจจุบันหนึ่งระดับ
		 */
		
		
		/* **************************************************************************************** */
		
		
		/*
		 * Pfadangeben mit java.io.File(bereits vor Java 8, wird aber weiter verwendet)
		 */
		/*
		 *  (Path) แบบเก่าใน Java (ใช้ java.io.File) 
		 */
		
		 
		// import java.io.File;
		
		/*
		 * File ใน Java คือการสร้างออบเจ็กต์ที่แสดงถึงไฟล์หรือไดเรกทอรี (folder) ในระบบไฟล์ของเครื่องคอมพิวเตอร์ 
		 * แต่ว่า File เองไม่ได้สร้างไฟล์ขึ้นมาใหม่เมื่อใช้เพียงแค่ new File("C:\\Windows") โดยตรง 
		 * 
		 * ทำไมถึงไม่มีไฟล์ที่ new File("C:\\Windows")?
		 * การใช้ new File("C:\\Windows") เพียงแค่สร้างออบเจ็กต์ที่อ้างถึงไฟล์หรือไดเรกทอรีที่ตำแหน่งนั้นเท่านั้น 
		 * แต่มันจะไม่ได้ทำการสร้างไฟล์หรือไดเรกทอรีจริงๆ ในระบบไฟล์ 
		 * ถ้าคุณต้องการสร้างไฟล์หรือไดเรกทอรีจริงๆ ในระบบไฟล์ คุณต้องใช้เมธอดอื่นๆ ที่อยู่ในคลาส File
		 */
		
		File p5 = new File("C:\\Windows");	
		System.out.println("p5: " + p5);				//	C:\Windows
		
		File p6 = new File("/Windows");		
		System.out.println("p6: " + p6);				//  \Windows
		
		File p7 = new File("dirA\\dirB", "dirC\\file");		
		System.out.println("p7: " + p7);			 	//	dirA\dirB\dirC\file
		
		File p8 = new File("dirA/dirB", "dirC/file");		
		System.out.println("p8: " + p8); 				// 	dirA\dirB\dirC\file
		
		
		
		
		File pathAktuellRelativ = new File(".");
		File pathAktuelleAbsolut = pathAktuellRelativ.getAbsoluteFile();
		System.out.println("Aktuelles Arbeitsverzeichenis :  " + pathAktuelleAbsolut);  
		//  C:\Users\CC-Student\Documents\sorceTreeGit\java_ocpse8\IO\.
		
		
		File pathAktuellAbsolutNormalisiert = pathAktuelleAbsolut.getCanonicalFile();
		System.out.println("Aktuelles Arbeitsverzeichenis normalisiert :  " + pathAktuellAbsolutNormalisiert );
		// C:\Users\CC-Student\Documents\sorceTreeGit\java_ocpse8\IO
		
		System.out.println();
		
		File pathAktuellRelativ2 = new File("..");
		File pathAktuelleAbsolut2 = pathAktuellRelativ2.getAbsoluteFile();
		System.out.println("Aktuelles Arbeitsverzeichenis :  " + pathAktuelleAbsolut2);
		//C:\Users\CC-Student\Documents\sorceTreeGit\java_ocpse8\IO\..
		
		
		File pathAktuellAbsolutNormalisiert2 = pathAktuelleAbsolut2.getCanonicalFile();
		System.out.println("Aktuelles Arbeitsverzeichenis normalisiert :  " + pathAktuellAbsolutNormalisiert2 );
		//C:\Users\CC-Student\Documents\sorceTreeGit\java_ocpse8
		
		/* **************************************************************************************** */
		
		/*
		 * Pfadangeben mit java.nio.file.Path (ab Java 8)
		 * แบบใหม่ที่มีตั้งแต่ Java 8 ขึ้นไป (ใช้ java.nio.file.Path) 
		 * 
		 * 		Interface Path kann : 
		 * 			- virtuell Pfade beschreiben
		 * 
		 * 		Klasse Java.nio.file.Files kann :
		 * 			- auf Dateisystem zugreifen
		 */
		
		 Path absolutePath1 = Paths.get("C:\\Windows");
		 Path absolutePath2 = Paths.get("/Windows/Temp");

	     Path relativePath1 = Paths.get("dir\\subdir\\file");
	     Path relativePath2= Paths.get("dir/dirB/file");  // 
		
	     Path relativePath3= Paths.get("dirA","dirB/dirC/file");
	     
	     
	     
		// Example
	     System.out.println();
		  Path absolutePath = Paths.get("C:/Users/Username/Documents/file.txt");

	      Path relativePath = Paths.get("documents/file.txt");

	      System.out.println("Absolute Path: " + absolutePath);

	      System.out.println("Relative Path: " + relativePath);
		
		

        System.out.println("------------------------------------------------------------");

       
        
	}

}
