 package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class B05_Streams_terminal_two {

	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("Wilma", "Fred", "Pebbles", "Barney", "Betty", "Bambam");
		
		Optional<String> optName =  list.stream()
										.parallel()
										.filter(s -> s.startsWith("B"))
										.findAny();

		if(optName.isPresent()) {
			String name = optName.get();
			System.out.println("Name = " + name) ;  // Name = Barney
		}
		
		optName =  list.stream()
						.parallel()
						.filter(s -> s.startsWith("B"))
						.findFirst();
		
		if(optName.isPresent()) {
			String name = optName.get();
			System.out.println("Name = " + name) ;  // Name = Barney
		}
		
		split();
		
		/*
		 * Optional<Integer> และสตรีมเพื่อหาหมายเลขเฉพาะ (prime number):
		 */
		Optional<Integer> optPrimZahl = Stream.iterate(1_000_000 ,  i -> i+1 )  // สร้างสตรีมจากหมายเลข 1,000,000 และเพิ่มค่าขึ้นทีละ 1 (1,000,001, 1,000,002, ...)
											   .filter(Math::isPrime)			//ใช้ฟังก์ชัน isPrime เพื่อตรวจสอบว่าหมายเลขนั้นเป็นหมายเลขเฉพาะหรือไม่
											   .findFirst();					//ค้นหาหมายเลขเฉพาะตัวแรกในสตรีมที่ถูกกรอง ซึ่งจะส่งกลับเป็น Optional<Integer> หากมีหมายเลขเฉพาะ หรือว่างเปล่าหากไม่มีหมายเลขเฉพาะ
		
		System.out.println("primzahl = " + optPrimZahl.get()) ; 				//ถ้าหมายเลขเฉพาะที่พบมีอยู่ (Optional ไม่ว่างเปล่า) ค่าของหมายเลขนั้นจะถูกนำมาใช้
																				//หากไม่พบหมายเลขเฉพาะ จะเกิด NoSuchElementException หากพยายามเรียก get() จาก Optional ที่ว่างเปล่า
	
	
		split();
		
		
		
		Integer[] arr = {12 , -5 , 33 , 7 , 9 };
		Predicate<Integer> isPositive = i -> i > 0 ; 
		
		boolean allMatch = Arrays.stream(arr).allMatch(isPositive);
		System.out.println("allMatch : " + allMatch );					//false
		
		boolean anyMatch = Arrays.stream(arr).anyMatch(isPositive);
		System.out.println("allMatch : " + anyMatch );					//true
		
		boolean noneMatch = Arrays.stream(arr).noneMatch(isPositive);
		System.out.println("allMatch : " + noneMatch );					//false
	
	}

	public static boolean isPrime(int zahl) {
		for (int i = 2; i < zahl /2 ; i++) {
			if(zahl % i == 0 ) {
				return false;   // ถ้ามีการหารลงตัวแสดงว่าไม่เป็นหมายเลขเฉพาะ
			}
		}
		return true;			// ถ้าไม่มีการหารลงตัวแสดงว่าเป็นหมายเลขเฉพาะ
	}

	static void split() {
		System.out.println("------------------------------------------------------");
	}
}

class Math{
	public static boolean isPrime(int zahl) {
		for (int i = 2; i < zahl /2 ; i++) {
			if(zahl % i == 0 ) {
				return false; // ถ้ามีการหารลงตัวแสดงว่าไม่เป็นหมายเลขเฉพาะ
			}
		}
		return true;		  // ถ้าไม่มีการหารลงตัวแสดงว่าเป็นหมายเลขเฉพาะ
	}
}