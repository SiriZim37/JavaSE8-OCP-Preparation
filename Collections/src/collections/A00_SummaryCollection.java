package collections;

public class A00_SummaryCollection {

	/*
	 สรุปเรื่อง Collection ใน Java SE 8 (สำหรับเตรียมสอบ OCP)

	1. **Collection Framework คืออะไร?**
	   - โครงสร้างข้อมูลใน Java สำหรับจัดการกลุ่มข้อมูล เช่น List, Set, Queue
	   - อยู่ในแพ็กเกจ `java.util`

	2. **ประเภทของ Collection หลัก** แบ่งออกเป็น 3 กลุ่มหลัก:
	   - 1. List**: เก็บข้อมูลซ้ำได้, เรียงลำดับ เช่น `ArrayList`, `LinkedList`, `Vector`
	   - 2. Set**: เก็บข้อมูลไม่ซ้ำ เช่น `HashSet`, `TreeSet`, `LinkedHashSet`
	   - 3. Queue/Deque**: ใช้กับคิว (FIFO) เช่น `PriorityQueue`, `ArrayDeque`

	3. **Map (ไม่ใช่ Collection แต่เป็นส่วนหนึ่งของ Framework)**
	   - เก็บข้อมูลในรูปแบบ Key-Value Pair
	   - เช่น `HashMap`, `TreeMap`, `LinkedHashMap`, `Hashtable`

	4. **ความแตกต่างของแต่ละประเภท**
	   | ประเภท  | คุณสมบัติเด่น                    | ตัวอย่างคลาส          |
	   |---------|----------------------------|-----------------------|
	   | List    | ซ้ำได้, เข้าถึงด้วย index          | `ArrayList`, `LinkedList` |
	   | Set     | ไม่เก็บข้อมูลซ้ำ                  | `HashSet`, `TreeSet`   LinkedHashSet    |
	   | Queue   | จัดการข้อมูลแบบคิว (FIFO)         | `PriorityQueue` ,`LinkedList` |
	   | Deque   | เพิ่ม/ลบได้ทั้งหัวและท้าย             | `ArrayDeque`, `LinkedList` |
	   | Map     | เก็บข้อมูลแบบ Key-Value Pair    | `HashMap`, `TreeMap`         |
	   

	5. **คลาสที่ควรรู้**
	   - `ArrayList`: เก็บข้อมูลในอาเรย์แบบไดนามิก อ่านข้อมูลเร็ว เหมาะสำหรับอ่านบ่อย
	   - `LinkedList`: เหมาะสำหรับการเพิ่ม/ลบข้อมูลบ่อย ๆ เพราะใช้โครงสร้าง Node
	   - `HashSet`: เก็บข้อมูลไม่ซ้ำ ไม่มีการเรียงลำดับ
	   - `TreeSet`: เก็บข้อมูลไม่ซ้ำ เรียงลำดับตามธรรมชาติ
	   - `HashMap`: เก็บ Key-Value แบบไม่มีลำดับ
	   - `TreeMap`: เรียง Key ตามธรรมชาติหรือ Comparator

	6. **Interfaces หลัก**
	   - **Collection**: แม่ของ `List`, `Set`, `Queue`
	     - เมธอดสำคัญ: `add`, `remove`, `size`, `contains`
	   - **List**: เมธอดสำคัญ: `get`, `set`, `indexOf`
	   - **Set**: เน้นข้อมูลไม่ซ้ำ
	   - **Map**: เมธอดสำคัญ: `put`, `get`, `keySet`, `values`

	7. **คุณสมบัติของ Collection แต่ละประเภท**
	   | ชื่อ          | ซ้ำได้ | เรียงลำดับ | Null ได้ | Thread-Safe |
	   |---------------|-------|-----------|---------|------------|
	   | ArrayList     | ✅     | ✅         | ✅       | ❌          |
	   | LinkedList    | ✅     | ✅         | ✅       | ❌          |
	   | HashSet       | ❌     | ❌         | ✅       | ❌          |
	   | TreeSet       | ❌     | ✅         | ❌       | ❌          |
	   | HashMap       | ✅     | ❌         | ✅ (Key 1 ค่า) | ❌    |
	   | TreeMap       | ✅     | ✅         | ✅ (Value เท่านั้น) | ❌ |

	8. **Stream API (Java SE 8)**
	   - ช่วยประมวลผลข้อมูลใน Collection ได้อย่างมีประสิทธิภาพ
	   - ตัวอย่าง:
	     ```java
	     List<String> names = Arrays.asList("John", "Jane", "Jack");
	     names.stream()
	          .filter(name -> name.startsWith("J")) // คัดกรอง
	          .forEach(System.out::println);       // แสดงผล
	     ```

	9. **ข้อสอบที่ควรระวัง**
	   - การใช้ Generics เช่น `List<String>`, `Map<Integer, String>`
	   - การจัดลำดับใน `TreeSet` และ `TreeMap` (ต้องมี `Comparable` หรือ `Comparator`)
	   - การใช้ Stream กับ Collection
	   - ความต่างของ Thread-Safe vs Non-Thread-Safe (`Vector` vs `ArrayList`)

	10. **สรุป**
	   - จำโครงสร้างพื้นฐาน: `List`, `Set`, `Queue`, `Map`
	   - รู้ข้อดีข้อเสียของแต่ละคลาส เช่น `ArrayList` เหมาะกับอ่านข้อมูล, `LinkedList` เหมาะกับเพิ่ม/ลบ
	   - ฝึกใช้ Stream API: เพื่อช่วยจัดการข้อมูล
	   - เข้าใจ Generics: เพื่อเขียนโค้ดที่ปลอดภัย
	*/

}
