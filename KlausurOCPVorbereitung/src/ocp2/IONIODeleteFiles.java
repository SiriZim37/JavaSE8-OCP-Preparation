package ocp2;

import java.io.File;
import java.io.IOException;

public class IONIODeleteFiles {

	
	 public void recDelete (String dirName) throws IOException   {
		    File [ ] listOfFiles = new File (dirName) .listFiles();
		    if (listOfFiles != null && listOfFiles.length >0)   {
		        for (File aFile : listOfFiles)   {
		            if (aFile.isDirectory ())    {
		                recDelete (aFile.getAbsolutePath ());
		            }    else   {
		                if (aFile.getName ().endsWith (".class"))
		                    aFile.delete ();
		            }
		        }
		    }
		 }
/*
	 Assume that Projects contains subdirectories that contain .class files 
	 and is passed as an argument to the recDelete () method 
	 when it is invoked.
	 What is the result?
	 A. The method deletes all the .class files in the Projects directory and its subdirectories.
	 B. The method deletes the .class files of the Projects directory only.
	 C. The method executes and does not make any changes to the Projects directory.
	 D. The method throws an IOException
	 
*/	 
	public static void main(String[] args) {
		
		/*
		  โค้ดนี้เป็นเมธอด recDelete ที่ทำงานดังนี้:

รับชื่อไดเรกทอรี (dirName) เป็นพารามิเตอร์

ใช้ File(dirName).l istFiles() เพื่อดึงรายการไฟล์และไดเรกทอรีย่อยทั้งหมดในไดเรกทอรีที่ระบุ
ตรวจสอบรายการไฟล์ในไดเรกทอรี:

หากรายการไม่เป็น null และมีไฟล์หรือไดเรกทอรีย่อย (listOfFiles.length > 0)
ทำการวนลูป (for-each) เพื่อประมวลผลไฟล์หรือไดเรกทอรีย่อยแต่ละรายการ
การตรวจสอบแต่ละไฟล์:

ถ้าเป็น ไดเรกทอรี (aFile.isDirectory())
เรียกใช้เมธอด recDelete ซ้ำ (recursive) เพื่อประมวลผลไดเรกทอรีย่อย
ถ้าเป็น ไฟล์ปกติ:
ตรวจสอบว่าไฟล์นั้นลงท้ายด้วย .class
หากใช่ ให้ลบไฟล์ (aFile.delete())
		   A. The method deletes all the .class files in the Projects directory and its subdirectories.
			ถูกต้อง
			เมธอดนี้ทำงานแบบ recursive:
			มันประมวลผลทุกไฟล์และไดเรกทอรีย่อยของ Projects
			หากพบไฟล์ .class ไม่ว่าจะอยู่ในไดเรกทอรีหลักหรือไดเรกทอรีย่อย จะลบไฟล์ทั้งหมดที่ตรงเงื่อนไข

		 */
		

	}
}
