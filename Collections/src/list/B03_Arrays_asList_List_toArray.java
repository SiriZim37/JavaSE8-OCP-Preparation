package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;

public class B03_Arrays_asList_List_toArray {

	public static void main(String[] args) {
		test_Array_asList();
		test_list_toList();
	}
	
	static void test_list_toList() {
		System.out.println("\n*** test Collection/toArray");
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(12);
		list.add(13);
		list.add(14);
		list.add(15);
		System.out.println("1. list : " + list);
		/*
		 * Object[] toArray()
		 */
		
		/*
		 *   [12, 13, 14, 15]
		 */
		Object[] arrObj = list.toArray();
		System.out.println("1. arrObj :" + Arrays.toString(arrObj));
		
//		Integer[] arrInt = list.toArray(); // cf : Object[] to Integer[]
		try {
			Integer[] arrTmp = (Integer[]) list.toArray();		
		} catch (ClassCastException e) {
			System.out.println("ClassCastException Object[] ist nicht Integer");
		}
		
		/*
		 *    <T> T[] toArray(T[] a);
		 *    
		 *    	wenn das übergebene Array groß genug ist , 
		 *    	speichert toArray die Elemete der Liste im 
		 *      übergebenen Array. 
		 *      Ansonsten wird ein neues Array erzeugt
		 *    - เมธอดนี้ใช้สำหรับแปลงข้อมูลใน Collection ไปเป็นอาเรย์
		 *    - ถ้าอาเรย์ที่ส่งเข้ามา (`a`) มีขนาดใหญ่พอ:
		 *      จะนำข้อมูลใน Collection ไปเก็บในอาเรย์นั้นโดยตรง
		 *    - ถ้าอาเรย์ที่ส่งมาเล็กเกินไป:
		 *      เมธอดจะสร้างอาเรย์ใหม่ที่มีขนาดเพียงพอและคืนค่ากลับมา    
		 *    ตัวอย่าง:
		 *    
		 *    List<String> list = Arrays.asList("A", "B", "C");
		 *    String[] array = new String[list.size()];
		 *    array = list.toArray(array);
		 *    
		 *    - ถ้า `array` มีขนาดเพียงพอ:
		 *      ข้อมูลจะถูกเก็บใน `array` เดิม
		 *    - ถ้าไม่เพียงพอ:
		 *      เมธอดจะสร้างอาเรย์ใหม่และคืนค่ากลับมา    
		 */
		System.out.println("***\n");
		/*
		 *   [12, 13, 14, 15]
		 */
		Integer[] arrInt1 = list.toArray(new Integer[0]);
		System.out.println("2. arrInt1 :" + Arrays.toString(arrInt1));
		
		/*
		 *   [12, 13, 14, 15, null, null, null, null, null, null]
		 */
		Integer[] arrInt2 = list.toArray(new Integer[10]);
		System.out.println("3. arrInt2 :" + Arrays.toString(arrInt2));
		
		
		/*
		 * Ab Java 11:
		 * 
		 * <T> T[] toArray(IntFunction<T[]> generator) 
		 */
//		Integer[] arrInt3 = list.toArray( (int size) -> new Integer[size] );
//		System.out.println("3. arrInt3: " + Arrays.toString(arrInt3));
		
		
	}
	
	static void test_Array_asList() {	
		System.out.println("\n*** test Array.asList");
		
		List<String> listGehtAuch = new ArrayList<String>();
		listGehtAuch.add("mo");
		listGehtAuch.add("di");
		listGehtAuch.add("mi");
		
//		List<String> listAbjava9 = List.of("mo" , "di","mi"); // nicht in der Prüfung
		
		/*
		 * static<T> List<T> asList(T...a)
		 */
		
		/*
		 *   [mo, di, mi]
		 */
		List<String> listStr =  Arrays.asList("mo" , "di","mi");
		System.out.println("1. listStr : " + listStr);
		
		
		/*
		 * Achtung! Prüfung! 
		 * 
		 * Die Liste , die von asList erzeigt wird , hat fixierte Größe!!
		 */
		
		/*				0   1   2   
		 *  vorher :   [mo, di, mi]
		 *  nachher :  java.lang.UnsupportedOperationException ( RuntimeException )
		 */
		try {
			listStr.add("Do");
			System.out.println("1. listStr : " + listStr);
		} catch (UnsupportedOperationException e) {
			System.out.println("UnsupportedOperationException!" + e );
		}
		
		// Elemente zu ersetzen ist ok :
		
		/*				0   1         2   
		 *  vorher :   [mo, di, 	  mi]
		 *  nachher :  [mo, Dienstag, mi]
		 */
		listStr.set(1, "Dienstag");
		System.out.println("2. listStr : " + listStr); 
		
		
		/*
		 * Unwarhscheinlich in der Prüfung : 
		 * Die Liste aus asList ist mit dem Array 'verbunden'
		 */
		System.out.println("\n*** Test 'backed' list");
		
		/*					 0      1      2   
		 *  Double[] 	:   [12.1, 13.2, 14.5]
		 *  List<Double>:   [12.1, 13.2, 14.5]
		 */
		Double[] array = {12.1 , 13.2 , 14.5};
		List<Double> listDouble = Arrays.asList(array);
		System.out.println("a. array : " + Arrays.toString(array)); 
		System.out.println("a. listDouble : " + listDouble); 
		
		/*					 0      1      2   
		 *  Double[] 	:   [-5.1, 13.2, 14.5]
		 *  List<Double>:   [-5.1, 13.2, 14.5]
		 */
		array[0] = -5.1;
		System.out.println("b. array: " + Arrays.toString(array));
		System.out.println("b. listDouble: " + listDouble);
		
		/*					 0      1      2   
		 *  Double[] 	:   [-5.1, -7.8, 14.5]
		 *  List<Double>:   [-5.1, -7.8, 14.5]
		 */
		listDouble.set(1, -7.8);
		System.out.println("c. array : " + Arrays.toString(array)); 
		System.out.println("c. listDouble : " + listDouble); 

		/*					 0      1      2   
		 *  Double[] 	:   [12.1, 15.5, 14.5]
		 *  List<Double>:   UnsupportedOperationException
		 */
		try {
			listDouble.add(2, -555.55);
		} catch (UnsupportedOperationException e) {
			System.out.println("UnsupportedOperationException!" + e );
		}
		

		
		
	}

}
