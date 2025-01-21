package aufgaben.dao.tiere;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class TestFileTierDAO implements TierDao {

	private Path file = Paths.get("tiere.txt");
	
	public TestFileTierDAO() {
		try {
			if(!Files.exists(file))
				Files.createFile(file);
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
	

	
	@Override
	public List<Tier> getAllTiere() throws UncheckedIOException, IllegalArgumentException {
		
		if(!Files.isRegularFile(file)) {
			throw new IllegalArgumentException("Datei mit Tieren nicht gefunden: " + file);
		}
		
		try (Stream<String> s = Files.lines(file)) {
			return s.map(line -> parseTier(line)).collect(Collectors.toList());
			
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}

	/*
	 * Format der line:
	 * 
	 * 		id , Name , Art , 1960
	 */
	private static Tier parseTier(String line) {
		String[] parts = line.split("\\|");
		
	    try {
	        int id = Integer.parseInt(parts[1].trim()); 			// Get and parse ID
	        String name = parts[2].trim(); 							// Get name
	        String art = parts[3].trim(); 							// Get animal type
	        int geburtsjahr = Integer.parseInt(parts[4].trim()); 	// Get and parse birth year
	        
	        // Return a new Tier object
	        return new Tier(id, name, art, geburtsjahr);
	    } catch (NumberFormatException e) {
	        // Handle parsing error
	        System.out.println("Error parsing line: " + line);
	        return null;
	    }
	}
	
	@Override
	public boolean deleteOnId(int id) {

		List<Tier> tiere = getAllTiere();	
		int size = tiere.size();		
		tiere.removeIf( t -> t.getId() == id);	
		if(tiere.size() == size) {
			return false;
		}
		save(tiere);
		return true;
	}

	@Override
	public void add(Tier newTier) throws IllegalArgumentException {
		
		List<Tier> alleTiere = getAllTiere();
		
		boolean idExistiert = alleTiere.stream().anyMatch(t -> t.getId()==newTier.getId());
		
		if(idExistiert) {
			throw new IllegalArgumentException("Es gibt bereits ein Tier mit der id = " + newTier.getId());
		}
		
		alleTiere.add(newTier);
		save(alleTiere);
	}
	
	private void save(List<Tier> tiere) {
		try (PrintWriter out = new PrintWriter(file.toFile())){
			
			String fmt = "|%3s|%10s|%10s|%12s|";
			for (Tier t : tiere) {
				out.format(fmt , t.getId() , t.getName() , t.getArt() , t.getGeburtsjahr());
			}
			
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
		

	}



}
