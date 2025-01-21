package ocp;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IO_NIO1 extends Dog {
	/*
	 
		public void print(Path d) throws IOException {
		  try (DirectoryStream<Path> stream = Files.newDirectoryStream(d)) {
		    for (Path path: stream) {
		     System.out.println(path.getFileName());
		 } } }


	 * Which types are printed out? (Choose all that apply.)
	 *
	 * A. Hidden files in d
	 *
	 * B. Regular files in d
	 *
	 * C. Regular files in all subdirectories of d
	 *
	 * D. Immediate subdirectories of d
	 *
	 * E. All subdirectories (recursively) in d
	 *
	 * A, B, and D are correct. DirectoryStream only returns files or directories directly under the given directory path. It does not recurse through subdirectories. It does look at hidden files by default.
	 *
	 * C and E are incorrect based on the above.
	 *
	 * คำอธิบาย:
	 * - A: สตรีมจะพิจารณาไฟล์ที่ซ่อน (hidden files) ได้ โดยไม่มีการตั้งค่าพิเศษใดๆ ใน `DirectoryStream` จึงสามารถพิมพ์ไฟล์ที่ซ่อนใน d ได้
	 * - B: สตรีมนี้จะพิมพ์ไฟล์ปกติ (regular files) ที่อยู่ภายในโฟลเดอร์ d ได้
	 * - C: ข้อนี้ไม่ถูกต้อง เพราะ `DirectoryStream` จะไม่ทำงานกับไฟล์ใน subdirectories (โฟลเดอร์ย่อย) ของ d โดยตรง
	 * - D: `DirectoryStream` จะพิมพ์ subdirectories ที่อยู่ทันทีใต้โฟลเดอร์ d เท่านั้น
	 * - E: ข้อนี้ไม่ถูกต้อง เนื่องจาก `DirectoryStream` จะไม่ทำงานกับโฟลเดอร์ย่อยทั้งหมดแบบ recursive
	 */

	// Example 
	 public void print(Path d) throws IOException {
	        try (DirectoryStream<Path> stream = Files.newDirectoryStream(d)) {
	            for (Path path : stream) {
	                System.out.println(path.getFileName());
	            }
	        }
	    }

	    public static void main(String[] args) throws IOException {
	        Path directoryPath = Paths.get("C:/Users/YourUsername/Documents/TestDirectory");

	        IO_NIO1 example = new IO_NIO1();
	        example.print(directoryPath);
	    }
	    
	    /*
	     TestDirectory/
		    file1.txt
		    file2.jpg
		    .hiddenfile
		    subfolder1/
		        file3.txt
		    subfolder2/
		        .hiddenfolder/
		            file4.txt

	     */
	    
	    /*
	     * Ergebnis : 
			    file1.txt
				file2.jpg
				.hiddenfile
				subfolder1
				subfolder2

	     */
}

