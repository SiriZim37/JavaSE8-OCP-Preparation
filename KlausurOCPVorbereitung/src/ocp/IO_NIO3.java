package ocp;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IO_NIO3 extends Dog {
	/*
	 * public void read(Path dir) throws Exception {
	 *   // INSERT code here
	 *   System.out.println(attr.isArchive());
	 * }
	 * Which compile and run without error in Windows?
	 * 
	 * A. BasicFileAttributes attr = Files.readAttributes(dir, BasicFileAttributes.class);
	 * 
	 * B. BasicFileAttributes attr = Files.readAttributes(dir, DosFileAttributes.class);
	 * 
	 * C. DosFileAttributes attr = Files.readAttributes(dir, BasicFileAttributes.class);
	 * 
	 * D. DosFileAttributes attr = Files.readAttributes(dir, DosFileAttributes.class);
	 * 
	 * E. BasicFileAttributes attr = new BasicFileAttributes(dir);
	 * 
	 * F. BasicFileAttributes attr = dir.getBasicFileAttributes();
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * D is correct.
	 * A, B, C, E, and F are incorrect. A and B are incorrect because the archive attribute only exists on the Windows platform. 
	 * The code fails to compile since archive is not found on BasicFileAttributes. C is incorrect because you cannot assign a more general type to a more specific type. 
	 * E and F are incorrect because those methods do not exist. You must use the Files class to get the attributes.
	 * 
	 * คำอธิบาย:
	 * - A: ข้อนี้ไม่ถูกต้อง เพราะ attribute "archive" มีเฉพาะใน Windows และไม่สามารถใช้งานกับ BasicFileAttributes ได้
	 * - B: ข้อนี้ไม่ถูกต้อง เนื่องจาก "archive" ไม่มีใน BasicFileAttributes และไม่สามารถใช้งานกับ class นี้ได้
	 * - C: ข้อนี้ไม่ถูกต้อง เพราะไม่สามารถกำหนดค่าให้กับชนิดข้อมูลที่กว้างกว่ากับชนิดข้อมูลที่เฉพาะเจาะจงได้
	 * - D: ข้อนี้ถูกต้อง เพราะ DosFileAttributes รองรับ attribute "archive" ที่สามารถใช้งานได้บน Windows
	 * - E: ข้อนี้ไม่ถูกต้อง เพราะไม่มี constructor แบบนั้นใน BasicFileAttributes
	 * - F: ข้อนี้ไม่ถูกต้อง เพราะไม่มีเมธอด `getBasicFileAttributes` ใน Path
	 */

	/*
	 
	 BasicFileAttributeView
		Name	Type
		"lastModifiedTime"	FileTime
		"lastAccessTime"	FileTime
		"creationTime"	FileTime
		"size"	Long
		"isRegularFile"	Boolean
		"isDirectory"	Boolean
		"isSymbolicLink"	Boolean
		"isOther"	Boolean
		"fileKey"	Object

	 DosFileAttributeView
		Name	Type
		readonly	Boolean
		hidden	Boolean
		system	Boolean
		archive	Boolean


	PosixFileAttributeView
		Name	Type
		"permissions"	Set<PosixFilePermission>
		"group"	GroupPrincipal


	 */
	
}

