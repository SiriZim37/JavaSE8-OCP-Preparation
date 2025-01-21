package set;

public class B010_WasIstHashSet {

	/*
	 * A HashSet in Java is a class that implements the Set interface, 
	 * part of Java's Collection framework. It is used to store a collection of unique elements, 
	 * meaning it "does not allow duplicates". 
	 * เป็นคลาสที่ใช้เก็บค่าข้อมูลที่ไม่ซ้ำกัน ซึ่งอยู่ในชุดของ Java Collection Framework มันถูกใช้ในการเก็บชุดของข้อมูลที่ไม่ซ้ำกัน 
	 * 
	 * 	1. No Duplicate Elements: 
	 * 		A HashSet only allows one instance of each element. 
	 * 		If you try to add an element that already exists in the set, 
	 * 		it will not be added again. 
	 * 		ไม่อนุญาตให้มีข้อมูลซ้ำกัน: HashSet จะเก็บข้อมูลที่ไม่ซ้ำกันเท่านั้น หากพยายามเพิ่มข้อมูลที่มีอยู่แล้ว มันจะไม่ถูกเพิ่มเข้าไปในชุด
	 * 
	 *  2. Unordered Collection: 
	 *  	The elements in a HashSet are not stored in any particular order. 
	 *  	When you iterate over the set, the elements may appear in any arbitrary order, 
	 *  	which is determined by the internal hash mechanism.
	 *  	ไม่มีการจัดลำดับข้อมูล: ข้อมูลใน HashSet จะถูกเก็บโดยไม่มีลำดับที่แน่นอน เมื่อมีการวนลูปหรือดึงข้อมูลออกมา ข้อมูลอาจจะอยู่ในลำดับใดก็ได้ ขึ้นอยู่กับการทำงานภายในของแฮช
	 *  
	 *  3. Fast Access: 
	 *  	HashSet offers constant time performance for the basic operations—add(), 
	 *  	remove(), and contains()—as it uses a hash table internally. 
	 *  	The time complexity for these operations is on average O(1), meaning they are very fast.
	 *  	การเข้าถึงข้อมูลอย่างรวดเร็ว: การทำงานพื้นฐานเช่นการเพิ่มข้อมูล (add()), 
	 *  	การลบข้อมูล (remove()), และการตรวจสอบข้อมูล (contains()) ใน HashSet ใช้เวลาการทำงานเฉลี่ย O(1) ซึ่งหมายถึงมันทำงานได้รวดเร็ว
	 *  
	 *  4. Uses Hashing: 
	 *  	It uses the hashCode() method of objects to generate a hash value 
	 *  	that helps in placing the element in the set. 
	 *  	This is why objects that are stored in a HashSet must properly 
	 *  	implement the equals() and hashCode() methods to ensure that duplicates are handled correctly.
	 *  	ใช้การแฮช: มันใช้เมธอด hashCode() ในการสร้างค่าแฮชเพื่อระบุตำแหน่งข้อมูลในชุด 
	 *  	ดังนั้นอ็อบเจ็กต์ที่เก็บใน HashSet ควรต้องมีการ implement เมธอด equals() และ hashCode() อย่างถูกต้องเพื่อป้องกันปัญหาการเก็บข้อมูลซ้ำ
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
