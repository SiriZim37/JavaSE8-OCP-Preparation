package aufgaben.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class SubDirectories{
	private Path dir;
	
	SubDirectories(Path dir){
		System.out.println("SubDirectories :");

		if (!dir.isAbsolute()) {
	         throw new IllegalArgumentException("Unterverzeichnisse musst asolute Pfade sein!");
	    }
		  
		this.dir = dir;		
	}
	

	void createSubdirs(String subDirPath) {
		System.out.println("\nCreate : ");
		
		Path subDir = Paths.get(subDirPath);

		if(subDir.isAbsolute()) {
			 if (!subDir.startsWith(this.dir)) {
	                throw new IllegalArgumentException("Absolute Pfade muss innerhalb des Basisverzeichnisses liegen!");
	         }

		}else {
			subDir = this.dir.resolve(subDir);
		}

		try {			 
			Files.createDirectories(subDir);
			System.out.println(subDir + " wurde erzeugt."); 
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	void deleteSubdirs(String subDirPath) {
		System.out.println("\nDelete :");
		
		Path subDir = Paths.get(subDirPath);

		if (subDir.isAbsolute()) {
			 if (!subDir.startsWith(this.dir)) {
	                throw new IllegalArgumentException("Absolute Pfade muss innerhalb des Basisverzeichnisses liegen!");
	         }
        } else {
            subDir = this.dir.resolve(subDir);
        }
		
		try { 
			
			 while (!subDir.equals(this.dir)) {
				Files.delete(subDir);
				System.out.println("gelöscht : " + subDir);
				subDir = subDir.getParent();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


public class AufgabeFilesVerzeichnisse {

	public static void main(String[] args) {

		Path dir = Paths.get(".").toAbsolutePath();
		
		System.out.println("AbsolutePath : " + dir);
		
		SubDirectories instance = new SubDirectories(dir);
		
		instance.createSubdirs("a\\b\\c\\d");
          
		instance.deleteSubdirs("a\\b\\c\\d");
	
		
		System.out.println("\n-------------------------------------------------------------");
		
		
		// Test Case exception
	
		String myAbsolutePath = "C:\\a\\b\\c\\d";
		
		try {
	        instance.createSubdirs(myAbsolutePath); 
	    } catch (IllegalArgumentException e) {
	       System.out.println(e.getMessage()); 
	    }
		
		try {
	        instance.deleteSubdirs(myAbsolutePath); 
	    } catch (IllegalArgumentException e) {
	       System.out.println(e.getMessage()); 
	    }

	}

}
