package ocp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;


public class CollectionArrayBinarySearch {


	public static void main(String[] args) {
	
		/*
		 *  binarySearch และการจัดเรียง (sort)
		 *  binarySearch ต้องการให้อาร์เรย์ถูกจัดเรียงก่อน เพื่อให้สามารถทำงานได้อย่างถูกต้อง
		 *  หากใช้ตัวเปรียบเทียบ (Comparator) ในการจัดเรียง (sort),
		 *  การเรียกใช้ binarySearch จะต้องอ้างอิงตัวเปรียบเทียบเดียวกัน มิฉะนั้นจะไม่สามารถค้นหาได้อย่างถูกต้อง
		 */
		
		String[] a = {"map","pen", "marble" , "key"};
		Othello o = new Othello();
		Arrays.sort(a,o);
		
		for (String s: a) {System.out.println(s);}
		
		System.out.println(Arrays.binarySearch(a, "key"));	   // -1
		
		
		/*
		 *  public static <T> int binarySearch(T[] a, T key, Comparator<? super T> c)
		 */
		System.out.println(Arrays.binarySearch(a, "key", o));	// 3

	}
	
	static class Othello implements Comparator<String>{
		@Override
		public int compare(String o1, String o2) {
			return o2.compareTo(o1);
		}
	}
}
