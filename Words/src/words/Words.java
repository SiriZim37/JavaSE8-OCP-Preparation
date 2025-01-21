package words;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


public class Words {

	private static List<String> load(String resourcePath) {
		try {
			List<String> list = new ArrayList<>();
		
			InputStream is = Words.class.getResourceAsStream(resourcePath);
	
			ZipInputStream zis = new ZipInputStream(is);
			
			ZipEntry ze = zis.getNextEntry();
			
			if(ze.isDirectory()) {
				throw new IllegalStateException("Das erste (und einzige) Element in der Datenquelle soll eine Textdatei sein");
			}
			
			try( BufferedReader in = new BufferedReader(new InputStreamReader(zis)) ) {
			
				String line = in.readLine(); // Zeile mit Quellenangaben ignorieren
				
				//System.out.println("quelle: " + line);
				
				while( (line = in.readLine()) != null ) {
					list.add(line);
				}
				
			}
			
			return list;
		
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}

	/**
	 * Liefert 10.000 Passwörter zurück, die nicht verwendet werden sollten.
	 * 
	 * @return
	 */
	public static List<String> passwords() {
		String resourcePath = "/words/res/10k_most_common_passwords.zip";
		return load(resourcePath);
	}

	/**
	 * Liefert 354.297 englische Wörter zurück
	 * 
	 * @return
	 */
	public static List<String> englishWords() {
		String resourcePath = "/words/res/lang-english-354297.zip";
		return load(resourcePath);
	}

	/**
	 * Liefert 1.908.815 deutsche Wörter zurück
	 * 
	 * @return
	 */
	public static List<String> germanWords() {
		String resourcePath = "/words/res/lang-german-1908815.zip";
		return load(resourcePath);
	}
	

}
