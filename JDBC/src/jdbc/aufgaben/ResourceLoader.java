package jdbc.aufgaben;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ResourceLoader {
	
	public static String load(Path filePath) {
	  StringBuilder content = new StringBuilder();

	  try (BufferedReader br = new BufferedReader(new FileReader(filePath.toFile()))) {
	            
	      String line;
	      while ((line = br.readLine()) != null) {
	          content.append(line).append("\n");
	      }
	      
	  } catch (IOException e) {
			e.printStackTrace();
	  }
	  
	  return content.toString();
	}
	
	public static void main(String[] args) {	
	
//	   Path dir = Paths.get(".").toAbsolutePath().normalize();
//	   Path filePath = dir.resolve("sql").resolve("create_data.sql");
//	   System.out.println(filePath);
	   Path filePath = Paths.get("sql/create_data.sql"); 
	   
	   String text = ResourceLoader.load(filePath);
	   System.out.println(text);  
 
	}

}
