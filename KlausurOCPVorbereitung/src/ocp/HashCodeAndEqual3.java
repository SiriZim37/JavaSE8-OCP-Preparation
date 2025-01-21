package ocp;

/*
class SortOf {
	  String name;
	  int bal;
	  String code;
	  short rate;
	  public int hashCode() {
	    return (code.length() * bal);
	  }
	  public boolean equals(Object o) {
	    // insert code here
	  }
}
*/
	/*
	 * Which two most closely fulfill the equals() and hashCode() contracts for this class? (Choose two.)
	 * 
	 * A.return ((SortOf)o).bal == this.bal;
	 * B.return ((SortOf)o).code.length() == this.code.length();
	 * C.return ((SortOf)o).code.length() * ((SortOf)o).bal == this.code.length() * this.bal;
	 * D.return ((SortOf)o).code.length() * ((SortOf)o).bal * ((SortOf)o).rate == this.code.length() * this.bal * this.rate;
	 * 
	 * 
	 * 
	 * C and D are correct. The equals() algorithm must be at least as precise in defining what "meaningfully equivalent" means as the hashCode() method is.

A and B are incorrect because these equals() implementations would allow instances to be equal that hashCode() would not see as equal.
	 */
public class HashCodeAndEqual3 {

	public static void main(String[] args) {
/*
 * ใน Java, เมธอด equals() และ hashCode() มีความสำคัญมากในการเปรียบเทียบอ็อบเจ็กต์และการใช้งานในคอลเลกชันต่าง ๆ 
 * (เช่น HashMap, HashSet) โดยมีข้อกำหนด (contract) ที่ต้องปฏิบัติตาม:

	***Equals Contract:

	ถ้า a.equals(b) เป็น true ก็ต้องมี a.hashCode() == b.hashCode() (ควรให้ค่า hashCode() เท่ากันหากอ็อบเจ็กต์สองอันนี้เท่ากัน).
	ถ้า a.equals(b) เป็น false ก็ไม่จำเป็นต้องให้ a.hashCode() != b.hashCode(), แต่มักจะทำให้การเปรียบเทียบมีความถูกต้องมากขึ้น.
	equals() ต้องเป็น สมมาตร, การเชื่อมโยง, และ ไม่เปลี่ยนแปลง.


	*** HashCode Contract:

	ถ้า a.equals(b) เป็น true จะต้องมี a.hashCode() == b.hashCode().
	เมธอด hashCode() ต้องคงที่เมื่อค่าของอ็อบเจ็กต์ไม่เปลี่ยนแปลง.

	ในกรณีนี้ คลาส SortOf มีคุณสมบัติ 4 ตัวคือ name, bal, code, และ rate ซึ่งเราต้องกำหนดวิธีการเปรียบเทียบและคำนวณ hashCode() 
	เพื่อให้ทั้ง equals() และ hashCode() ทำงานร่วมกันได้ถูกต้อง.

	ตัวเลือกที่ให้มา:
	A. return ((SortOf)o).bal == this.bal;
		ไม่ถูกต้อง: หากใช้วิธีนี้เพียงแค่เปรียบเทียบค่า bal ก็จะไม่สามารถรับประกันได้ว่า hashCode() ที่คำนวณจาก code.length() * bal 
		จะให้ผลลัพธ์ที่ตรงกัน เพราะค่า code.length() ยังมีผลต่อการคำนวณ hashCode(). ดังนั้นถ้า bal เท่ากัน 
		แต่ code.length() ไม่เท่ากัน ผลลัพธ์จาก equals() จะผิด.
	B. return ((SortOf)o).code.length() == this.code.length();
		ไม่ถูกต้อง: การเปรียบเทียบแค่ความยาวของ code จะไม่เพียงพอ เพราะ hashCode() ยังพิจารณาจาก bal ด้วย 
		ดังนั้นการเปรียบเทียบแค่ความยาวของ code ไม่สามารถรับประกันได้ว่า hashCode() จะเหมือนกันหาก bal ไม่ตรงกัน.
	C. return ((SortOf)o).code.length() * ((SortOf)o).bal == this.code.length() * this.bal;
		ถูกต้อง: วิธีนี้สามารถทำให้ทั้ง equals() และ hashCode() ทำงานร่วมกันได้ดี เพราะใน hashCode() 
		เราคำนวณจาก code.length() * bal ดังนั้นการเปรียบเทียบใน equals() ควรจะทำในลักษณะเดียวกัน 
		เพื่อให้ผลลัพธ์ของ equals() และ hashCode() สอดคล้องกัน.
	D. return ((SortOf)o).code.length() * ((SortOf)o).bal * ((SortOf)o).rate == this.code.length() * this.bal * this.rate;
		ถูกต้อง: วิธีนี้จะให้ผลลัพธ์ที่แม่นยำมากขึ้น เนื่องจากรวมถึงการพิจารณาค่า rate ในการคำนวณทั้ง equals() และ hashCode(). 
		โดย hashCode() ของคลาสนี้ใช้การคำนวณจาก code.length() * bal ซึ่งถ้าเราต้องการให้ equals() และ hashCode() 
		สอดคล้องกัน การพิจารณาค่า rate ก็ทำให้เปรียบเทียบได้ละเอียดและถูกต้อง.
	
	สรุป:
	คำตอบที่ถูกต้องคือ C และ D เนื่องจากทั้งสองวิธีนี้ทำให้ equals() และ hashCode() สอดคล้องกันในการเปรียบเทียบอ็อบเจ็กต์ที่มีคุณสมบัติทั้ง code.length(), bal, และ rate.
	
	คำตอบที่ผิด: A และ B เพราะทั้งสองจะไม่สามารถรับประกันได้ว่า hashCode() ที่คำนวณจาก code.length() * bal จะให้ผลลัพธ์ที่ตรงกันในกรณีที่มีการเปลี่ยนแปลงบางส่วนของอ็อบเจ็กต์	
 */
		
		
	
	}
}
