package aufgaben.fork;


import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import words.Words;

class ToUpperCaseAction extends RecursiveAction{
	
	private static final int THRESHOLD = 2000;	// 
	private List<String> words;
	private int indexFrom, indexTo;
	
	 public ToUpperCaseAction(List<String> words, int indexFrom, int indexTo) {
		this.words = words;
        this.indexFrom = indexFrom;
        this.indexTo = indexTo;
	 }
	
	@Override
	protected void compute() {
		/*
		 *  FALLS 
		 *  	die Aufgabe ist einfach genug
		 *  DANN 
		 *  	die Aufgabe lösen
		 *  SONST
		 *  	- die Aufgabe is zwei (oder mehr) einfachere Aufgaben teilen
		 *  	- die einfache Teileaufgaben an die Threads des ForkJoin-Pools 
		 *  	  zum aus füren übergeben 
		 *   
		 **** คำอธิบายแบบง่าย ***
		 *  - ถ้าทำเองได้เลย → แก้ปัญหาเลย
		 *  - ถ้างานใหญ่ → แบ่งงานเป็นชิ้นเล็ก ๆ → ส่งไปให้ Threads ต่าง ๆ ช่วยกันทำ → รวมผลกลับมาที่เดียวกัน
		 */
		if( (indexTo - indexFrom)  <= THRESHOLD) { 	
			 for (int i = indexFrom; i < indexTo; i++) {
	              words.set(i, words.get(i).toUpperCase());
	         }
		}else { 
			
			int indexMitte = (indexFrom + indexTo) / 2;
//			System.out.println(indexFrom +" bis "+ indexMitte);
//			System.out.println(indexMitte +" bis " + indexTo);
			
			ToUpperCaseAction  leftAction = new ToUpperCaseAction(words , indexFrom , indexMitte);
			ToUpperCaseAction  rightAction = new ToUpperCaseAction(words , indexMitte , indexTo);
			
//           leftAction.fork();  
//           rightAction.compute(); 
//           leftAction.join(); 
            
			invokeAll(leftAction,rightAction);
		
		}	
	}
}


public class AufgabenForkJoinMitListRecursiveAction {

	public static void main(String[] args) {
		
		List<String> words = Words.englishWords();
//		System.out.println("Word.size(): "+ words.size() );
		
		ForkJoinPool pool = new ForkJoinPool();		
		pool.invoke(new ToUpperCaseAction(words, 0, words.size()));
	
		/*
		 * Result
		 */
		
//		words.stream().sorted().forEach(System.out::println);

//		words.stream().skip(150000).limit(1).forEach(System.out::println);
		
		AtomicInteger count = new AtomicInteger();
		words.stream()
			.filter(s -> count.incrementAndGet()%10000 == 0)
			.forEach(System.out::println);
		
		/* 
		 * การทำงานของโค้ด:
		 * 1. สร้างรายการคำภาษาอังกฤษ:
		 *    - List<String> words = Words.englishWords();
		 *    - สร้าง List ที่เก็บคำภาษาอังกฤษ เช่น ["apple", "banana", "cat", ...]
		 *
		 * 2. ใช้ AtomicInteger เป็นตัวนับ:
		 *    - AtomicInteger count = new AtomicInteger();
		 *    - ใช้เก็บค่าตัวนับแบบ Thread-safe สำหรับงานประมวลผลแบบขนาน
		 *
		 * 3. ประมวลผล Stream:
		 *    - words.stream(): แปลง List<String> เป็น Stream เพื่อประมวลผลรายการได้ยืดหยุ่น
		 *    - .filter(s -> count.incrementAndGet() % 10000 == 0):
		 *      - เพิ่มค่าตัวนับทีละ 1 ด้วย count.incrementAndGet()
		 *      - เลือกคำที่ตำแหน่งตัวนับหาร 10,000 ลงตัว (% 10000 == 0)
		 *    - .forEach(System.out::println): พิมพ์คำที่ผ่านการกรองลงคอนโซล
		 *
		 * 4. เหตุผลที่ใช้ AtomicInteger:
		 *    - เพื่อเพิ่มค่าตัวนับอย่างปลอดภัยในงานแบบขนาน
		 *    - ถ้าใช้ int แทน AtomicInteger อาจเกิดปัญหา Race Condition ได้
		 */

	}
}
