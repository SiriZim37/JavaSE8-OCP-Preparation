package aufgaben;

import java.util.Random;

public class MyArrayUtils {

	/**
	 * Erzeugt ein Array mit Zufallswerten
	 * 
	 * @param length : Die Größe des Arrays
	 * @param min 	 : kleinstmöglicher Zufallswert inklusive
	 * @param max	 : größtmöglicher Zufalsswerte exklusive
	 * @return
	 */
	public static int[] createArray(int length, int min, int max) {
		if(min > max) {
			throw new IllegalArgumentException("min muss kleiner als max sein");
		}
		
		 Random random = new Random();
		 
		int[] arr = new int[length];
		
		for (int i = 0; i < length; i++) {
				arr[i] = random.nextInt(max - min) + min; // obergrenzen Exclusive
		}
		return arr ;
	}
}
