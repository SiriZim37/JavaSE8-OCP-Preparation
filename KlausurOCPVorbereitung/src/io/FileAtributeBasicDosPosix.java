package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.util.concurrent.TimeUnit;

public class FileAtributeBasicDosPosix {
	
	/*
	 * 	 ในแผนภาพข้างต้น BasicFileAttributes เป็นคลาสหลักที่ใช้จัดการกับคุณสมบัติของไฟล์ในระบบไฟล์
	 *   โดย DosFileAttributes (Window) และ PosixFileAttributes (Linux)
	 *   
	 *    
	 * 					 BasicFileAttributes
	 * 							  |
	 * 					---------------------
	 * 					|				    |
	 * 		DosFileAttributes        	 PosixFileAttributes
	 * 
	 *  
	 * 
	 * 					BasicFileAttributeView
	 * 							|
	 * 					---------------------
	 * 					|				    |
	 * 		DosFileAttributeView  	    PosixFileAttributeView
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
		Name		Type
		readonly	Boolean
		hidden		Boolean
		system		Boolean
		archive		Boolean


	PosixFileAttributeView
		 Name			Type
		"permissions"	Set<PosixFilePermission>
		"group"			GroupPrincipal


	 */
	public static void main(String[] args) throws IOException {
		Path path = Paths.get("mydata/dir1/file0.txt");
		
		BasicFileAttributes b1 = Files.readAttributes(path, BasicFileAttributes.class); 
		BasicFileAttributes b2 = Files.readAttributes(path, DosFileAttributes.class); 	 // for Window
		try {
			BasicFileAttributes b3 = Files.readAttributes(path, PosixFileAttributes.class); // for Linux
		} catch (Exception e) {
			System.out.println("Fehler! Keine Posix-Attribute unter Windows! " + e );
		} 
		
		BasicFileAttributeView v1 = Files.getFileAttributeView(path, BasicFileAttributeView.class);
		DosFileAttributeView v2 = Files.getFileAttributeView(path, DosFileAttributeView.class);    // for Window
		PosixFileAttributeView v3 = Files.getFileAttributeView(path, PosixFileAttributeView.class);  // for Linux
	
	
		// BasicFileAttributeView
		FileTime lastModifiedTime = null;
		FileTime lastAccessTime = null;
		FileTime creationTime = FileTime.from(0, TimeUnit.MILLISECONDS); // 1.1.1970

		// การตั้งเวลาในไฟล์
		v1.setTimes(lastModifiedTime, lastAccessTime, creationTime);
		
		System.out.println("b1: "+ b1.lastAccessTime());
		System.out.println("b2: "+ b2);
		System.out.println("v1: "+ v1);
		System.out.println("v2: "+ v2);
		System.out.println("v1: "+ v1.readAttributes().lastAccessTime());
		
		// DosFileAttributeView
		v2.setHidden(false);
		v2.setArchive(false);
	}
}
