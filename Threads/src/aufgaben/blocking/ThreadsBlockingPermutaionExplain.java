package aufgaben.blocking;

import java.util.Arrays;

public class ThreadsBlockingPermutaionExplain {
	/*
	 *  โครงสร้างของโค้ด
		เมธอด main
		
		สร้างอาร์เรย์ array ที่มีตัวอักษร { 'a', 'b', 'c' } แล้วเรียกใช้เมธอด permutate เพื่อหาการเรียงสับเปลี่ยนทั้งหมดและแสดงผล
		สร้างอาร์เรย์ที่สอง array2 ที่มีตัวอักษร { 'd', 'e', 'f', 'g', 'h', 'i' } และใช้ Runnable เพื่อรันการเรียงสับเปลี่ยนในเธรดแยก
		เมธอด permutate
		
		ใช้กระบวนการแบบ Recursive (เรียกตัวเองซ้ำ) เพื่อหาการเรียงสับเปลี่ยนของตัวอักษรในอาร์เรย์
		ใช้เงื่อนไข:
		หากตัวแปร pointer มีค่าเท่ากับ 1 ให้พิมพ์การเรียงลำดับปัจจุบันของอาร์เรย์ออกมา
		หาก pointer เป็นจำนวนคู่ จะสลับตำแหน่งตัวอักษรที่ pointer-1 กับตัวอักษรที่ตำแหน่ง i
		หาก pointer เป็นจำนวนคี่ จะสลับตำแหน่งตัวอักษรที่ pointer-1 กับตัวอักษรแรก (arr[0])
		Runnable และ Thread
		
		ใช้ Runnable เพื่อเรียกใช้งาน permutate กับอาร์เรย์ array2 ในเธรดใหม่ ทำให้การคำนวณสามารถทำงานแยกจาก main ได้โดยไม่บล็อกการทำงาน	
	 */
	
	public static void main(String[] args) {
		
		char[] array = { 'a', 'b', 'c' };
		permutate(array, array.length);
		
		
		// A1
		System.out.println("\n*** A1");
		char[] array2 = { 'd', 'e', 'f' , 'g' , 'h' , 'i' };
		Runnable permuteTask = () -> {		
			permutate( array2 , array2.length);
		};
		
		new Thread(permuteTask).start();
		
	}
	
	public static void permutate(char[] arr, int pointer) {
	    if(pointer==1) {
	        System.out.printf("%s %n", Arrays.toString(arr));
	        return;
	    }
	    
		for (int i = 0; i < pointer-1; i++) {
		   permutate(arr, pointer-1);
		    
			if(pointer%2==0) {
			    char tmp = arr[pointer-1];
			    arr[pointer-1] = arr[i];
			    arr[i] = tmp;
			} else {
			    char tmp = arr[pointer-1];
			    arr[pointer-1] = arr[0];
			    arr[0] = tmp;
			}
		}
		
		permutate(arr, pointer-1);
	}
	
}

