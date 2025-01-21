package aufgaben.filescount;

import java.nio.file.Path;

public class PathUtils {

	public static boolean hasExtension(Path file , String extension) {

		String filename = file.getFileName().toString().toLowerCase();

		int indexOfPoint = filename.lastIndexOf('.');
		
		String fileExtension = filename.substring(indexOfPoint+1);
		
		return fileExtension.equals(extension.toLowerCase());
	}
}
