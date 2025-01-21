package generics;

import java.util.Arrays;
import java.util.List;

public class B13_genericheMethodeParameterisieren {

	public static void main(String[] args) {

		/*
		 * Normalerweiser wird eine generische Methode
		 * bei dem Aufruf automatisch parametrisiert
		 * โดยทั่วไปแล้ว เมธอดที่เป็น Generics จะถูก "parametrisiert" (ตั้งค่าประเภท) อัตโนมัติเมื่อถูกเรียกใช้
		 * หมายความว่าเมื่อคุณเรียกใช้เมธอดที่มี Generics แล้ว Java จะทำการตั้งค่าประเภท (Type) ให้โดยอัตโนมัติ
		 */
		
		Integer[] arrInt = {1,2,3};
		
		//parametrisieret mit Integer
		List<Integer> listInt = Arrays.asList(arrInt);	//  แปลงจาก Integer[] เป็น List<Integer>
		
		//parametrisieret mit Number
		List<Number> listNum = Arrays.asList(arrInt);
		
		
		List<Object> listObj= Arrays.asList(arrInt);	// 
		
		/*
		 * Explizite Parametrisierung ist auch möglich
		 * 
		 * การตั้งค่าประเภทอย่างชัดเจน (Explizite Parametrisierung) 
		 * ก็สามารถทำได้ โดยไม่ต้องให้ Java กำหนดประเภทอัตโนมัติ:
		 * 
		 * การตั้งค่าแบบ explicit (ชัดเจน) จะทำให้คุณสามารถควบคุมประเภทที่ใช้ได้อย่างแม่นยำมากขึ้น
		 */
		
		Arrays.<Integer>asList(arrInt); // จะให้ Java ทราบว่าคุณต้องการให้เมธอดนี้ทำงานกับ `Integer`
		Arrays.<Number>asList(arrInt); // จะให้ Java ทราบว่าคุณต้องการให้เมธอดนี้ทำงานกับ `Number`
		Arrays.<Object>asList(arrInt); // จะให้ Java ทราบว่าคุณต้องการให้เมธอดนี้ทำงานกับ `Object`
		
		listInt =  Arrays.<Integer>asList(arrInt);
//		listInt =  Arrays.<Number>asList(arrInt);	//`arrInt` คืออาร์เรย์ของ `Integer[]`, 
													// แต่ `Arrays.asList()` จะไม่แปลงประเภทของอาร์เรย์นี้เป็น `List<Number>`
		listNum =  Arrays.<Number>asList(arrInt);
		listObj =  Arrays.<Object>asList(arrInt);
		
		Arrays.<Object>asList(args); // cf : asList(Integer... ) mit String[] asList
	}

}
