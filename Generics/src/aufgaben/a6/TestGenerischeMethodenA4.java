package aufgaben.a6;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Supplier;


public class TestGenerischeMethodenA4 {

	public static void main(String[] args) {
	    
		String[] arrStr = {"a","b","c"};
		
//		Supplier<ArrayDeque<String>> sup = new Supplier<ArrayDeque<String>>() {		
//			@Override
//			public ArrayDeque<String> get() {
//				return null;
//			}
//		};
		
	
		/*
		 * Parametrisierung:
		 * 
		 * 		build( Supplier<ArrayDeque<???> s, String[] values )
		 * 		A = String
		 * 		T = ArrayDeque<String>
		 */
		ArrayDeque<String> deque = build(ArrayDeque::new, arrStr);
		System.out.println("deque: " + deque);

		Integer[] arrInt = { 7, -3, 7, 22, 7, 11 };
		
		TreeSet<Integer> treeSet = build(TreeSet::new, arrInt);
		System.out.println("treeSet: " + treeSet);

	}
	
	/*
	 * เมธอดนี้สร้างคอลเลกชันและเพิ่มค่าที่รับเข้ามา (varargs) ตามที่ผู้ใช้กำหนด
	 * 
	 * - @SafeVarargs: ใช้เพื่อแจ้งให้ JVM รู้ว่าเมธอดนี้รับค่าหลายค่า (varargs) แต่ไม่มีปัญหาด้าน Generics
	 * 
	 * - <A, T extends Collection<A>>: ใช้ Generics โดย:
	 *    - A คือประเภทข้อมูลที่เก็บใน Collection (เช่น String, Integer, ฯลฯ)
	 *    - T คือประเภทขอคอลเลกชัน Type Collection ที่ต้องการ (เช่น ArrayList, HashSet, ฯลฯ)
	 * 
	 * - Supplier<T> s: ใช้ในการสร้างคอลเลกชันใหม่ (เช่น ArrayList::new, HashSet::new)
	 * - A... values: รับค่าหลายค่าเป็นอาร์เรย์ ซึ่งจะถูกเพิ่มเข้าไปในคอลเลกชัน
	 */
	
	@SafeVarargs
	public static <A, T extends Collection<A>> T build( Supplier<T> s, A... values ) {
						
		T c = s.get();				 // สร้างคอลเลกชันใหม่จาก Supplier
		for (A a : values) {		 // วนลูปเพิ่มค่าลงในคอลเลกชัน
			c.add(a);
		}
		return c;					// คืนค่าคอลเลกชันที่มีข้อมูลแล้ว
	}
	

	
	static void testSupplier() {
		Supplier<ArrayDeque<String>> supp = new Supplier<ArrayDeque<String>> () {
			public ArrayDeque<String> get() {
				return new ArrayDeque<>();
			}
		};
		
		Supplier<ArrayDeque<String>> supp2 = () -> {
			return new ArrayDeque<>();
		};
		
		Supplier<ArrayDeque<String>> supp3 = () -> new ArrayDeque<>();
		
		Supplier<ArrayDeque<String>> supp4 = ArrayDeque::new;
	}

}
