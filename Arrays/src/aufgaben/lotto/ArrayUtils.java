package aufgaben.lotto;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ArrayUtils {
	public static void main(String[] args) {
		int[] arr = createRandomUniqueArray(100, 1, 5);
		System.out.println("soll: null, ist: " + Arrays.toString(arr));
		
		arr = createRandomUniqueArray(-1, 1, 5);
		System.out.println("soll: null, ist: " + Arrays.toString(arr));

		arr = createRandomUniqueArray(5, -10, 10);
		System.out.println("soll: 5 Werte aus [-10..10], ist: " + Arrays.toString(arr));
		
		arr = createRandomUniqueArray(3, -1, 1);
		System.out.println("soll: 3 Werte aus [-1..1], ist: " + Arrays.toString(arr));
	}

	/**
	 * Erzeugt ein neues Array mit Zufallswerten.
	 * 
	 * @param len - Anzahl der Zufallswerte in dem neuen Array
	 * @param min - Untegrenze für Zufallswerte (inklusive) 
	 * @param max - Obergrenze für Zufallswerte (inklusive)
	 * @return Array mit Zufallswerten
	 */
	public static int[] createRandomUniqueArray(int len, int min, int max) {
		// todo: Exception werfen, wenn len negativ ist
		if( len<0 ) {
			return null; // nicht so gut
		}
		
		if( (max - min + 1) < len ) {
			// todo: Exception werfen, wenn es soviele einzigartige Werte 
			//       in dem festgelegten Bereich nicht gibt 
			return null; // nocht so gut
		}
		
		int[] arr = new int[len];
		
		Random rnd = new Random();
		
		for (int i = 0; i < arr.length; i++) {
			int value = rnd.nextInt(max-min+1) + min;
			if( hasValueAtPostionsBefore(value, arr, i) ) {
				i--; // damit kann Schleifendurchlauf wiederholt für die Position i werden
				continue;
			} else {
				arr[i] = value;
			}
		}
		
		return arr;
	}
	
	private static boolean hasValueAtPostionsBefore(int value, int[] arr, int maxIndex) {
		for (int i = 0; i < maxIndex; i++) {
			if( arr[i] == value ) {
				return true;
			}
		}
		
		return false;
	}
    
}
