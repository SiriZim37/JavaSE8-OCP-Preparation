package nio;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.print.attribute.standard.MediaSize.NA;


public class B02_PathAPI {

	/*
	 * การทำงานกับเส้นทางไฟล์ (Path) ใน Java โดยใช้ Path, FileSystems, และ Paths 
	 *  ซึ่งเป็นคลาสที่ช่วยให้เราจัดการเส้นทางของไฟล์และโฟลเดอร์ในระบบไฟล์
	 *  
	 *  Path.get(): เป็นเมธอดที่ใช้ในการสร้างเส้นทาง (Path) โดยใช้หลายๆ สตริงที่เป็นส่วนประกอบของเส้นทาง  
	 * 
	 *  FileSystems.getDefault().getPath(): ใช้สร้างเส้นทางผ่าน FileSystem ซึ่งเป็นวิธีที่ใช้สำหรับระบบไฟล์ที่กำหนดเอง (ไม่จำเป็นต้องใช้ในการสอบ)
	 *  
	 *  Paths.get(): เป็นวิธีที่สะดวกที่สุดในการสร้างเส้นทางใน Java โดยสามารถรับหลายๆ สตริงและสร้างเส้นทางจากนั้น    <<<< Prüfung
	 */
	public static void main(String[] args) {
		
		bilden();
		
		test_getNameCount();
		
		test_getFileName_getParent_getRoot();
		
		test_normalize();
		
		test_resolve();		// Exam!
		
		test_relative();	 // Exam!
	}
	
	
	

	static void bilden() {
		System.out.println("*** Path-Objekte bilden");
		
		/*
		 * Ab Java 11 gibt es im Interface Path die Methode : 
		 * 
		 * 			static Path get(String first , String...more)
		 * (nicht in der Prüfung)
		 * 
		 * ใน Java 11 จะมีเมธอด get() ใน Path interface ที่สามารถใช้เพื่อสร้างเส้นทาง (Path) 
		 * โดยใช้ String แรกและตามด้วย String...more (ซึ่งสามารถรับหลายๆ สตริงในรูปแบบ varargs) 
		 * อย่างไรก็ตาม เมธอดนี้ไม่จำเป็นต้องใช้ในการสอบ
		 * 
		 * ตัวอย่างการใช้งาน: 
		 * 
		 * Path p = Path.get("C:", "MyDir", "MyFile");
		 */
		
		
		/*
		 * Klasse 'FileSystem' hat die Methode
		 * 
		 *  	Path getPath(String first, String...more)
		 *  
		 *  So kann sie verwendet werden : 
		 *  
		 *  	FileSystems.getDefault().getPath("dir" , "file");
		 *  
		 *  (unwahrscheinlich in der Prüfung)
		 *  
		 *  
		 *  ใน FileSystem คลาส มีเมธอด getPath() ซึ่งสามารถใช้เพื่อสร้างเส้นทาง (Path) ได้เช่นกัน โดยการใช้ 
		 *  
		 *  	FileSystems.getDefault().getPath("dir", "file");
		 *  
		 *  เมธอดนี้สร้างเส้นทางจาก dir และ file ซึ่งสามารถใช้ได้ในกรณีที่ต้องการจัดการกับระบบไฟล์ที่กำหนดเอง 
		 *  (ไม่จำเป็นต้องใช้ใน Java SE 8 หรือในการสอบ)
		 */
		
		
		/*
		 * Utility-KLasse 'Paths' hat die methode : 
		 * 		
		 * 			static Path get(String first , String...more)
		 */
		Path p1 =  Paths.get("C:\\MyDir\\MyFile");
		System.out.println("p1: "  + p1 );							//	C:\MyDir\MyFile
		
		Path p2 =  Paths.get("C:", "MyDir\\MyFile");
		System.out.println("p2: "  + p2 );							//	C:\MyDir\MyFile
		
		
		Path p3 =  Paths.get("C:", "MyDir","MyFile");
		System.out.println("p3: "  + p3 );							//	C:\MyDir\MyFile
		
		Path p4 =  Paths.get("C:\\\\", "\\MyDir\\","\\MyFile");
		System.out.println("p4: "  + p4 );							//	C:\MyDir\MyFile
		
		
		
		Path p5 = Paths.get(".");
	    System.out.println("p5: " + p5.toAbsolutePath());		// .    - aktuelles Arbeitsverzeichnis

	        // ไดเรกทอรีแม่ (สัมพัทธ์)
	    Path p6 = Paths.get("..");
	    System.out.println("p6: " + p6.toAbsolutePath()); 		// ..    - Oberverzeichnis des aktuellen Arbeitsverzeichnis
	    
		Path currentDir = Paths.get(".");
	    System.out.println("Current directory (resolved): " + currentDir.toAbsolutePath().normalize());

	        // ไดเรกทอรีแม่ (สัมพัทธ์)
	    Path parentDir = Paths.get("..");
	    System.out.println("Parent directory (resolved): " + parentDir.toAbsolutePath().normalize());
		
	}

	static void test_getNameCount() {
		System.out.println("\n***getNameCount");
		
		// index					0     1        2           3
		Path p1 = Paths.get("C:\\Windows\\MyDir\\MySubDir\\MyFile");
		System.out.println("p1: " + p1 );						// C:\Windows\MyDir\MySubDir\MyFile
		
		int nameCount = p1.getNameCount();
		System.out.println("getNameCount() : "+ nameCount);		// 4 
		
		int index = 2;
		
		Path p2 = p1.getName(index);
		System.out.println("getNaem(2) : " + p2);				// 	MySubDir
		
		Path p3 = p1.subpath(1, 3);
		System.out.println("p3 : " + p3 ); 						// 	MyDir\MySubDir
	
		
	}

	
	static void test_getFileName_getParent_getRoot() {
			System.out.println("\n***getFileName() ,  getParent() , getRoot() ");
			
			Path p1 = Paths.get("C:\\Windows\\MyDir\\files");
			
			// The file name is the farthest element from the root in the directory hierarchy
			Path fileName = p1.getFileName();
			System.out.println("getFileName: " + fileName); 		// files
			
			Path parent = p1.getParent();
			System.out.println("getParent(): " + parent);   		// C:\Windows\MyDir
			
			Path root = p1.getRoot();
			System.out.println("getRoot(): " + root);   			// C:\
			
		
			
			System.out.println("\n********Test only filename");
			
			Path p2 = Paths.get("MyDir");
			System.out.println("getFileName: " + p2.getFileName()); 		// MyDir
			System.out.println("getParent(): " + p2.getParent());   		// null
			System.out.println("getRoot(): " + p2.getRoot());   			// null
		}
	
	
	static void test_normalize() {
		System.out.println("\n***normalize()");
		
		Path p1 = Paths.get("dir/file");  // relative Pfad
		System.out.println("p1: " + p1);
		
		Path pathAbs = p1.toAbsolutePath();
		System.out.println("p1.toAbsolutePath() : " + pathAbs);   // absoluter aktueller pfad
		// C:\Users\CC-Student\Documents\sorceTreeGit\java_ocpse8\IO\dir\file
		
		/*
		 *  Paths.get() เพื่อสร้าง Path และใช้เมธอด normalize() 
		 *  เพื่อ "ทำให้เส้นทางเป็นมาตรฐาน" โดยการกำจัดส่วนที่ซ้ำซ้อนหรือไม่จำเป็น (เช่น .. และ . ที่เป็นการอ้างอิงในทางสัมพัทธ์)
		 *  
		 *  dir\subdirA\..\subdirB\.\file
		 *  นี่คือเส้นทางสัมพัทธ์ที่ประกอบด้วย .. และ . ซึ่งเป็นส่วนเก่าของเส้นทางที่สามารถทำให้ซับซ้อนโดยไม่จำเป็น
		 *  การใช้ .. จะถูกแทนที่ด้วยการกลับไปที่ไดเรกทอรีที่สูงกว่า
		 *  การใช้ . จะถูกแทนที่ด้วยการย้ายไปที่ไดเรกทอรีปัจจุบัน (ซึ่งไม่มีผล)
		 */
		Path p2 = Paths.get("dir/subdirA/../subdirB/./file");
		System.out.println("p2: " + p2);				 				// dir\subdirA\..\subdirB\.\file
		
		Path pathNormalise = p2.normalize();
		System.out.println("p2.normalize(): " + p2.normalize());		// dir\subdirB\file
		
		/*
		 * เมื่อใช้ normalize() กับ p2:
		 * 
		 * subdirA/.. จะถูกลดลงเหลือแค่ subdirB เพราะ .. หมายถึง "ย้ายขึ้นไปหนึ่งระดับ" 
		 * ซึ่งจะข้าม subdirA ไปที่ไดเรกทอรีที่เป็น parent และแล้วไปที่ subdirB
		 * 
		 * ./file จะถูกแทนที่ด้วย file ในไดเรกทอรีปัจจุบัน เพราะ . หมายถึง "ไดเรกทอรีปัจจุบัน" ที่ไม่มีผลใดๆ กับเส้นทาง
		 */
	}

	/*
	 * Path resolve(String subPath)
	 * Path resolve(Path subPath)
	 * 
	 * resolve() เพื่อรวมเส้นทางที่ให้มาเข้าด้วยกัน 
	 */
	private static void test_resolve() {
		System.out.println("\n**resolve");
		
		Path parent = Paths.get("mydir");
		System.out.println("parent : " + parent);   // mydir
		
		Path file = parent.resolve("mysubdir/myfile");
		System.out.println("file: " + file);        // mydir\mysubdir\myfile
		

		System.out.println("******** 1. Pfad ist absolut, 2. Pfad ist relativ ");
		// ถ้าเส้นทางที่ให้มาคือเส้นทางสัมพัทธ์ (relative path), resolve() จะนำเส้นทางนั้นมารวมกับเส้นทางที่แม่ (parent path).
		
		parent = Paths.get("C:\\mydir");
		System.out.println("parent : " + parent);   //	 C:\mydir
		
		file = parent.resolve("mysubdir/myfile");
		System.out.println("file: " + file);        // 	C:\mydir\mysubdir\myfile
		
		
		parent = Paths.get("gg");
		System.out.println("parent : " + parent);  
		
		file = parent.resolve("C:\\mysubdir\\myfile");
		System.out.println("file-test: " + file);        // 	 C:\mysubdir\myfile  <<< No gg 
		
		
		
		System.out.println("******** 2. Pfad ist absolut");
		// resolve liefert einface den 2. Pfad zurück
		// ถ้าเส้นทางที่ให้มาเป็นเส้นทางสมบูรณ์ (absolute path), resolve() จะใช้เส้นทางนั้นโดยตรงและไม่สนใจ parent path.
		
		parent = Paths.get("C:\\mydir");
		System.out.println("parent : " + parent);   //	 C:\mydir
		
		file = parent.resolve("C:/mysubdir/myfile");
		System.out.println("file: " + file);        // 	 C:\mysubdir\myfile
		
		
	}
	
	
	/*
	 * relativize() ใน Java ใช้ในการคำนวณเส้นทางสัมพัทธ์ (relative path) ระหว่างสองพาธ ถ้าพาธทั้งสองเป็นประเภทเดียวกัน
	 */
	private static void test_relative() {
		
		System.out.println("\n**relativize");
		
		/*
		 * เมื่อทั้งสองพาธเป็นสัมพัทธ์ (relative paths): relativize() จะคำนวณเส้นทางสัมพัทธ์จากพาธแรกไปยังพาธที่สองได้
		 * เมื่อทั้งสองพาธเป็นสมบูรณ์ (absolute paths): relativize() จะคำนวณเส้นทางสัมพัทธ์ระหว่างพาธทั้งสองได้
		 * 
		 * เมื่อพาธหนึ่งเป็นrelative pathsและอีกอันเป็น absolute paths:
		 * จะเกิดข้อผิดพลาด IllegalArgumentException เนื่องจากไม่สามารถคำนวณเส้นทางสัมพัทธ์ระหว่างพาธที่แตกต่างกันได้
		 */
		System.out.println("******** beide Pfad sind relativ :");
		
		Path p1 = Paths.get("a/b/c/d");
		Path p2 = Paths.get("a/b/x/y");
		System.out.println("p1: " + p1);
		System.out.println("p2: " + p2);
		
		Path p3 = p1.relativize(p2);						
		System.out.println("p1.relativize(p2) : " + p3);     // ..\..\x\y
		p3 = p2.relativize(p1);	
		System.out.println("p2.relativize(p1) : " + p3);     // ..\..\c\d
		
		
		p1 = Paths.get("c/d");
		p2 = Paths.get("x/y");
		
		System.out.println("p1: " + p1);
		System.out.println("p2: " + p2);
		
		p3 = p2.relativize(p1);
		System.out.println("p2.relativize(p1) : " + p3);    // ..\..\c\d
		
		System.out.println("******** beide Pfad sind absolut (derselber logischer Laufwerk):");
		
		p1 = Paths.get("C:\\myDir\\c\\d");
		p2 = Paths.get("C:\\myDir\\x\\y");
		System.out.println("p1: " + p1);
		System.out.println("p2: " + p2);
		
		p3 = p1.relativize(p2);						
		System.out.println("p1.relativize(p2) : " + p3);     // ..\..\x\y
		p3 = p2.relativize(p1);	
		System.out.println("p2.relativize(p1) : " + p3);     // ..\..\c\d
		
		
		System.out.println("******** ein Pfad ist relativ, andere ist absolut ( Exception):");
		p1 = Paths.get("C:\\myDir\\c\\d");
		p2 = Paths.get("x/y");
		
		try {
			p3 = p1.relativize(p2);						
			System.out.println("p1.relativize(p2) : " + p3);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

	}

	
}
