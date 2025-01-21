 package aufgaben.fork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

import words.Words;

class GetMaxTask extends RecursiveTask<String>{
	
	private static final int THRESHOLD = 2000;	// 
	
	private List<String> words;
	private int indexFrom, indexTo;
	
	 public GetMaxTask(List<String> words, int indexFrom, int indexTo) {
		this.words = words;
        this.indexFrom = indexFrom;
        this.indexTo = indexTo;
	 }
	
			 
	@Override
	protected String compute() {
		 /*  FALLS 
		 *  	die Aufgabe ist einfach genug
		 *  DANN 
		 *  	die Aufgabe lösen und dann das Ergebnis zurück liefen
		 *  SONST
		 *  	- die Aufgabe is zwei (oder mehr) einfachere Aufgaben teilen
		 *  	- die Unteraufgabe B in einem anderen Thread aktivieren (fork)
		 *  	- die Unteraufgabe A in dem aktuellen Thread aktivieren
		 *  	- das Ergebnis der Unteraufgabe B im aktuellen Thread abwarten(join)
		 *  	- die Ergebnisse A und B kombinieren zurück liefern
		 *   
		 **** คำอธิบายแบบง่าย ***
		 *  
		 * FALLS
		 *   ถ้างานง่ายทำเลย
		 * DANN
		 *   แก้ปัญหานั้นทันทีและส่งผลลัพธ์กลับ
		 * SONST
		 *   - แบ่งงานเป็นงานย่อย
		 *   - ส่งงานย่อยไปทำใน Thread อื่น
		 *   - ทำงานย่อยใน Thread ปัจจุบัน
		 *   - รอผลจากงานย่อย
		 *   - รวมผลทั้งสองแล้วส่งกลับ
		 */
		if( (indexTo - indexFrom)  <= THRESHOLD) { 	
//			String word = words.get(indexFrom);
//			
//			for (int i = indexFrom; i < indexTo; i++) {
//				if (words.get(i).compareTo(word) > 0) {
//					word = words.get(i);
//		        }
//	        }
//			
			return words.stream()
					.max(Comparator.naturalOrder())
					.get();
		}else { 
			int indexMitte = (indexFrom + indexTo) / 2;

			GetMaxTask leftTask = new GetMaxTask(words , indexFrom , indexMitte);
			GetMaxTask rightTask = new GetMaxTask(words , indexMitte , indexTo);
		
//			invokeAll(leftTask, rightTask);
//			String strA = rightTask.join(); 
//			String strB = leftTask.join();
//			return strA.compareTo(strB) > 0 ? strA : strB; 
			
			leftTask.fork();
			String strA = rightTask.compute(); 
			String strB = leftTask.join();	
			return strA.compareTo(strB) > 0 ? strA : strB; 

		}	
	}
}


public class AufgabenForkJoinMitListRecursiveTask {

	public static void main(String[] args) {

		List<String> words = Words.englishWords();
		Collections.shuffle(words);
		
//		Optional<String> streamString = 
//					words.stream()
//						.reduce((word1, word2) -> word1.compareTo(word2) > 0 ? word1 : word2);
//		System.out.println("Largest: "+ streamString);	//zyzzyvas

		ForkJoinPool pool = new ForkJoinPool();
		
		String groesstenString = pool.invoke(new GetMaxTask(words, 0, words.size()));

		System.out.println("Der lexikographisch grössten String = " + groesstenString);
       
		
		

	}
}
