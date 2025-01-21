package ocp2;


final class Folder {        //line n1
    //line n2
    public void open () {
        System.out.print("Open");
    }
 }

public class ExceptionClassClose {


	 /*
		final class Folder {        //line n1
		    //line n2
		    public void open () {
		        System.out.print(Open);
		    }
		 }
	
		public class Test {
	
			
		 public static void main (String [] args) throws Exception   {
		        try (Folder f = new Folder())   {
		            f.open();
		        }
		  }
		}
		 
		Which two modifications enable the code to print Open Close? (Choose two.)
		 A. Replace line n1 with: class Folder implements AutoCloseable {
		 B. Replace line n1 with: class Folder extends Closeable {
		 C. Replace line n1 with: class Folder extends Exception {
		 D. At line n2, insert:
		 final void close ()   {
		        System.out.print("Close");
		 }
		 E. At line n2, insert:
		 public void close () throws IOException {
		        System.out.print("Close");
		 }
 
 
 		// Closeable erlaubt nur IOException Aber AutoCloseable kann throw alles
 		  
 		  การแก้ไขที่ถูกต้อง:
			A. Replace line n1 with: class Folder implements AutoCloseable
			
			คลาส Folder ต้อง implement AutoCloseable เพื่อให้ใช้กับ try-with-resources ได้
			AutoCloseable เป็นอินเทอร์เฟซที่กำหนดให้มีเมธอด close()
			
			
			E. At line n2, insert: public void close() throws IOException { System.out.print("Close"); }
			
			ต้องเพิ่มเมธอด close() ที่จำเป็นสำหรับการทำงานของ AutoCloseable
			เมื่อ try-with-resources เสร็จสิ้น close() จะถูกเรียกโดยอัตโนมัติ
	 */
}
