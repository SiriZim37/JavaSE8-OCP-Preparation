package ocpexam;

import java.io.File;
import java.io.IOException;




/*

QUESTION: 25


public void recDelete(String dirName) throws IOException {
File[] listOfFiles = new File(dirName).listFiles();
if (listOfFiles != null && listOfFiles.length > 0) {
	for (File aFile : listOfFiles) {
		if (aFile.isDirectory()) {
			recDelete(aFile.getAbsolutePath());
		} else {
			if (aFile.getName().endsWith(".class"))
				aFile.delete();
		}
	}
}
}

Assume that Projects contains subdirectories that contain .class files and is passed as an argument to the recDelete () method when it is invoked.
What is the result?

A. The method deletes all the .class files in the Projects directory and its subdirectories. 
B. The method deletes the .class files of the Projects directory only.
C. The method executes and does not make any changes to the Projects directory.
D. The method throws an IOException.


--------------
Answer: A 
--------------

*/


public class NIOTest3 {

	public static void main(String[] args) throws IOException {
		NIOTest3 q = new NIOTest3();
//		String filName = "/wmsl-java-certificate/src/main/java/com/wealth/certificate/dumps_1z0_809/question025/classFile";
		q.recDelete(getCurrentPath() + "/classFile");
	}

	public void recDelete(String dirName) throws IOException {
		File[] listOfFiles = new File(dirName).listFiles();	// get all of file in directory (all of file in folder include folder)
		if (listOfFiles != null && listOfFiles.length > 0) {
			for (File aFile : listOfFiles) {
				if (aFile.isDirectory()) {	// if is a Folder (folder id directory) 
					recDelete(aFile.getAbsolutePath());	// then parse the path of folder to self (recursive)
				} else {
					if (aFile.getName().endsWith(".class"))
						aFile.delete();
//						System.out.println("delete '"+aFile.getName()+"' completed status: "+aFile.delete());	// delete file that end with .class
				}
			}
		}
	}
	
	// Not in Question : Addition for get question's properties file path.
	private static String getCurrentPath() {
		return System.getProperty("user.dir") + "/Documents/Dev Project/Java-Workspace/javaocpse8/KlausurOCPVorbereitung/src/ocpexam/NIOTest3";
	}

}


