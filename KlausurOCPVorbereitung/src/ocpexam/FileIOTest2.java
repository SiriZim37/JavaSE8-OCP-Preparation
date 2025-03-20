package ocpexam;

import java.io.File;
import java.io.IOException;

public class FileIOTest2 {

	public void recDelete (String dirName) throws IOException {
		
		File[ ] listOfFiles = new File(dirName) .listFiles();
		
		if (listOfFiles!= null && listOfFiles.length >0) {
		
			for (File aFile : listOfFiles) {
			
				if (!aFile.isDirectory ()) {
				
					if (aFile.getName ().endsWith (".class"))
					
					aFile.delete ();
				
				}
			
			}
		
		}
		
	}
	
	public static void main(String[] args) {
		
		
	}
	/*
	 Given the code fragment:

	public void recDelete (String dirName) throws IOException {
		
		File[ ] listOfFiles = new File(dirName) .listFiles();
		
		if (listOfFiles!= null && listOfFiles.length >0) {
		
			for (File aFile : listOfFiles) {
			
				if (!aFile.isDirectory ()) {
				
					if (aFile.getName ().endsWith (".class"))
					
					aFile.delete ();
				
				}
			
			}
		
		}
		
	}
	
	Assume that Projects contains subdirectories that contain .class files and is passed as
	an argument to the recDelete () method when it is invoked.
	
	What is the result?
	
	Options
	A	The method deletes all the .class files in the Projects directory and its subdirectories.
	B	The method deletes the .class files of the Projects directory only.
	C	The method executes and does not make any changes to the Projects directory.
	D	The method throws an IOException.
	
	
	Answer
B
	 */
}
