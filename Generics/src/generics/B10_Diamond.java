package generics;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
 * Diamond Operator (<>) ใน Java ซึ่งเป็นฟีเจอร์ที่เพิ่มเข้ามาใน Java 7 
 * เพื่อทำให้การประกาศประเภทข้อมูล (generic types) ง่ายขึ้น 
 * โดยไม่ต้องระบุชนิดข้อมูลซ้ำๆ ในทั้งสองฝั่งของการประกาศตัวแปร
 * 
 * ทำไมต้องใช้ Diamond Operator?
 * 	1. Type Inference: คอมไพเลอร์สามารถเดาชนิดข้อมูลได้จากประเภทที่ประกาศไว้ในฝั่งซ้าย โดยไม่ต้องระบุซ้ำในฝั่งขวา.
 * 	2. ลดความซ้ำซ้อน (Avoid Redundancy): การใช้ Diamond Operator ช่วยให้โค้ดสั้นลงและอ่านง่ายขึ้น โดยไม่ต้องพิมพ์ชนิดข้อมูลซ้ำ.
 */
public class B10_Diamond {

	/*
	 * Diamond-Operator = Type-Inference-Operator
	 */
	public static void main(String[] args) {
		
		/*
		 * Ohne Diamond-Operator :
		 * 
		 * ในการสร้าง HashMap ฝั่งขวา (new HashMap<LocalDateTime, List<String>>()) 
		 * เราต้องระบุชนิดข้อมูลทั้งสองชนิดนี้ซ้ำอีกครั้ง ซึ่งทำให้โค้ดยาวขึ้นและดูซ้ำซ้อน.
		 */
		
		Map<LocalDateTime , List<String>> map1 = new HashMap<LocalDateTime, List<String>>();

		/*
		 * Mit Diamond-Operator : 
		 * 
		 * diamond operator <> ช่วยให้คอมไพเลอร์สามารถเดาชนิดข้อมูลที่ต้องการได้จากการประกาศในฝั่งซ้าย 
		 * (Map<LocalDateTime, List<String>>) ดังนั้นไม่จำเป็นต้องระบุชนิดข้อมูลซ้ำในฝั่งขวา.
		 * คอมไพเลอร์จะทราบว่าในฝั่งขวาควรสร้าง HashMap<LocalDateTime, List<String>>.
		 */
		Map<LocalDateTime , List<String>> map2 = new HashMap<>();
		
		
		/*
		 * Warum überhaupt den Konstrultor-Aufruf parameterisieren , 
		 * wenn es Erasure gibt ? 
		 * 
		 * Ein Beispiel.
		 * Die  Klasse Array list hat unter anderem die Konstruktoren : 
		 * 
		 * ArrayList() 
		 * 	und
		 * ArrayList(Collection<? extends E> c) 
		 */
		/*
		 * ทำไมต้อง parameterisieren constructor?
		 * แม้ว่า Erasure จะลบประเภทข้อมูลในระหว่างการคอมไพล์ แต่เรายังต้องการระบุประเภท (parameterize) 
		 * ในการสร้าง ArrayList เพื่อให้:
		 * 		- คอมไพเลอร์ สามารถตรวจสอบความถูกต้องของประเภทข้อมูลที่เรากำหนด
		 * 			ในขณะที่เขียนโค้ด (compile-time checking).
		 * 		- ลดข้อผิดพลาด โดยไม่ให้เราใช้ข้อมูลผิดประเภทใน ArrayList.
		 */
		
		List<Integer> listA = new ArrayList<Integer>();		// ระบุประเภท Integer
//		List<Integer> listA2 = new ArrayList<Double>(); 	//  cf : ไม่สามารถใช้ Double แทน Integer ได้

		List<Integer> listB = new ArrayList<>();			// / ใช้ Diamond Operator: คอมไพเลอร์เดาได้ว่าเป็น ArrayList<Integer>
		
		
		// zuerst war es so : new ArrayList<Double>()
		// danach geändert z : new ArrayList<Double>(listA)
		// คอมเมนต์นี้แสดงให้เห็นถึงกรณีที่การใช้ ArrayList แบบ parameterized จะไม่ทำงาน:
		
//		List<Double> listC = new ArrayList<Double>(listA);	// cf : listA ist ArrayList<Integer>() 
															//  ไม่สามารถใช้ listA ซึ่งเป็น ArrayList<Integer> กับ ArrayList<Double> ได้
		
//		List<Double> listD = new ArrayList<>(listA);		// cf : เนื่องจาก listA คือ ArrayList<Integer> ซึ่งเป็น List<Integer>.
		
		List<Number> listE = new ArrayList<>(listA);		// List<Number> listE = new ArrayList<>(listA); 
															// สามารถทำได้เนื่องจาก Integer เป็นชนิดย่อยของ Number.
		
		
		/*
		 * Parametrisiereung kann auch durch den Aufruf entstehen
		 */
		
		new ArrayList<>();			// <Object>
		new ArrayList<>(listA);		// <Integer>
		
		/*
		 * 	Exam : 
		 */
		/*
		 * 	Diamon : 
		 * 		- 	Diamon nur Konstruktoaufruf  :  
		 *		-	Diamond operator (<>) สามารถใช้ได้เฉพาะเมื่อ สร้างอินสแตนซ์ (instance)
		 *		    ของคลาสที่ใช้ Generics เท่านั้น, ไม่สามารถใช้กับการเรียกใช้เมธอดหรือการแสดงผลอื่น ๆ
		 * 		- ไม่สามารถ ใช้ diamond operator ในที่อื่น ๆ เช่น การเรียกใช้เมธอด.
		 * 
		 * 		Map<String, Integer> map = new HashMap<>();  // ใช้ diamond operator ได้ที่นี่
		 */
		
		/* Platzhalter : 
		 * 		-	Platzhalter nie bei einem Konstruktoraufruf ไม่สามารถใช้ Wildcard กับการเรียกใช้คอนสตรัคเตอร์
		 * 		- 	ประเภทใน Generics (เช่น <?>) ไม่สามารถใช้กับการเรียกใช้คอนสตรัคเตอร์ได้ เพราะ generics จะถูกลบ 
		 * 			(erasure) เมื่อทำการคอมไพล์, ดังนั้นชนิดของข้อมูลไม่สามารถใช้งานในคอนสตรัคเตอร์ได้
		 * 		- คุณไม่สามารถส่ง <?> เป็นประเภท generics ในการเรียกใช้คอนสตรัคเตอร์
		 * 
		 * 		// compiler fehler, ไม่สามารถใช้ wildcard (เช่น <?>) ในการเรียกใช้คอนสตรัคเตอร์
		 * 		List<?> list = new ArrayList<?>();  // cf 
		 */
		
		
		List<Integer> list1 = new ArrayList<>();
//		List<> list2 = new ArrayList<Integer>();		// cf 
		
		List<Integer> list3 = new ArrayList<Integer>();		// cf 
//		List<Integer> list4 = new ArrayList<?>();		// cf 
		
		
		
	}

}
