package aufgaben.interact;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Stream;

class TaskRandomInts implements Runnable {
	
	private int numberOfValues;
	private List<Integer> ints = new ArrayList<>(); 
	
	public TaskRandomInts(int numberOfValues) {
		this.numberOfValues = numberOfValues;
	} 
	
	@Override
	 public void run() {
	     // ใช้ ThreadLocalRandom.current() เพื่อสร้างออบเจกต์ Random ที่เฉพาะตัวสำหรับเธรดนี้
	     // ซึ่งช่วยเพิ่มประสิทธิภาพในโปรแกรมที่ทำงานในหลายเธรดพร้อมกัน
	     // ThreadLocalRandom จะไม่แชร์ออบเจกต์ Random ระหว่างเธรดต่างๆ, ทำให้ลดปัญหาคอขวด (bottleneck)
	     // และช่วยให้การสร้างเลขสุ่มในหลายเธรดทำได้เร็วขึ้น
	     Random rnd = ThreadLocalRandom.current();
	     
	     // สร้างเลขสุ่มจำนวน numberOfValues ตัวและเพิ่มเข้าไปในลิสต์
	     for (int i = 0; i < numberOfValues; i++) {
	         int value = rnd.nextInt();  // สร้างเลขสุ่ม
	         ints.add(value);  // เพิ่มเลขสุ่มลงในลิสต์
	     }
	 }
	public List<Integer> getInts() {
		return ints;
	}
}

public class AufgabeThreadsInteractA1 {
	
	public static void main(String[] args) throws InterruptedException{
		
		TaskRandomInts taskA = new TaskRandomInts(20_000_000);
		TaskRandomInts taskB = new TaskRandomInts(30_000_000);
		
		Thread tA = new Thread(taskA);
		Thread tB = new Thread(taskB);
		
		tA.start();
		tB.start();
		
		tA.join();
		tB.join();
		
		List<Integer> listA = taskA.getInts();
		List<Integer> listB = taskB.getInts();
		
//		Function<List<Integer>, Stream<Integer>> func = list -> list.stream();
		//oder 
		Function<List<Integer>, Stream<Integer>> func = List::stream;
		int summe = Stream.of(listA, listB) 	// Stream<List<Integer>>
			.flatMap(func) 						// Stream<Integer>
			.mapToInt(x -> x)
			.sum();
		
		System.out.println("Summe: " + summe); // 

		/*
		 * so würde es auch gehen:
		 * 
		 */
//		List<Integer> ints = new ArrayList<>();
//		
//		Runnable taskA = () -> {
//			for (int i = 0; i < 20; i++) {
//				int value = 1;
//				ints.add(value);
//			}
//		};
//		
//		new Thread(taskA).start();
//		...
		
	}
}
