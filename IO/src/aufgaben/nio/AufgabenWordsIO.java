package aufgaben.nio;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import words.Words;

public class AufgabenWordsIO {

	public static void main(String[] args) {

		List<String> listWords = Words.germanWords();
		
//		listWords.stream().forEach(System.out::println);

		Path targetDir  = Paths.get("myWords");
		System.out.println("path: " + targetDir );

		
		
		Map<String, List<String>>  mapFileNameToLines = buildFileContent(listWords);
			
			
		createFiles( targetDir , mapFileNameToLines);
		System.out.println("Dateien wurden erzeugt");
			 
		deleteInDirectory(targetDir);
		System.out.println("Verzeichnis gelöscht: " + targetDir);
	}

	private static void deleteInDirectory(Path targetDir) {
		if( !Files.isDirectory(targetDir)) {
			throw new IllegalArgumentException("Es ist kein Verzeichnis. " + targetDir);
		}
		
		// Work when in Folder has no sub folder 
		// Es wird UncheckedIOException geben , wenn Vercheinis auch noch subdir zur Verfügung stellt.
//		try (Stream<Path> s = Files.list(targetDir)){
//	
//			s.forEach(t -> {
//				try {		
//					Files.delete(t);
//				} catch (IOException e) {
//					throw new UncheckedIOException(e);
//				}
//			});
//			Files.delete(targetDir);
//			
//		} catch (IOException e) {
//			throw new UncheckedIOException(e);
//		}
			
		FileVisitor<Path> visitor = new SimpleFileVisitor<Path>() {
				
				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
					Files.delete(file);
					return FileVisitResult.CONTINUE;
				}
				
				@Override
				public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
					Files.delete(dir);
					return FileVisitResult.CONTINUE;
				}
			};
			
			try {
				Files.walkFileTree(targetDir, visitor);
				
			} catch (IOException e) {
				throw new UncheckedIOException(e);
			}
		}


	static Map<String, List<String>> buildFileContent(List<String> listWords){	
		
//		Function<String, String>  classifier =  word -> word.charAt(0) + ".txt" ;
//		
//		Map<String, List<String>> gruppeWords  = listWords.stream()
//						  .map(String::toLowerCase) 
//				 		  .collect(Collectors.groupingBy(classifier));
//		
//		return gruppeWords;
		
		Function<String, String> classifier = word -> 
							(word.charAt(0) + ".txt").toLowerCase(); 
	
		return listWords.stream().collect(Collectors.groupingBy(classifier));
		
	}
	
	private static void createFiles(Path targetDir, Map<String, List<String>> mapContents) {
		if(Files.isRegularFile(targetDir)) {
			throw new IllegalArgumentException("Das Zielverzeichnis ist eine Datei : " + targetDir);
		}
		

		if(!Files.isDirectory(targetDir)) {
			createDirectory(targetDir);
		}

//		try {
//			for(String fileName : mapContents.keySet()) {
//				List<String> lines = mapContents.get(fileName);
//				
//				Path file = targetDir.resolve(fileName);
//				
//				Files.write(file, lines);
//			}
//		} catch (IOException e) {
//			throw new UncheckedIOException(e);
//		}
//		
		mapContents.entrySet().forEach( entry -> {		
			
			String fileNameKey = entry.getKey();
			List<String> listValue = entry.getValue();
			    
            Path filePath = targetDir.resolve(fileNameKey); 
            try {
            	
                Files.write(filePath, listValue); 
                
                System.out.println("Datei " + fileNameKey + " erzeugt.");
                
            } catch (IOException e) {
           	 	System.out.println("Fehler beim Schreiben der Datei " + fileNameKey + ".txt");
                e.printStackTrace();
            }
        });
	     
	}
	
	static void createDirectory(Path path) {
		try {
			
		   Files.createDirectory(path);
		   System.out.println("Datei "+ path +" erzeugt. "); 
		   
		}catch (IOException e) {
			  System.out.println("Fehler beim Erstellen der Datei."); 
			e.printStackTrace();
		}

	}
	
	

}
