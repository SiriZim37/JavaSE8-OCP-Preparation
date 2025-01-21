package ocp;

public class StreamOfString {
	/*
	 * Which of the following code fragments intended to create a Stream of Strings will compile? (Choose all that apply.)
	 * 
	 * A.	Stream<String> s = 
	 *      Stream.of("Bald eagle", "Golden eagle", "Bateleur eagle");
	 * 
	 * B.	Stream<String> s = 
	 *      Arrays.asList("Bald eagle", "Golden eagle", 
	 *                    "Bateleur eagle").stream();
	 * 
	 * C.	String[] eagles = { "Bald eagle", "Golden eagle", 
	 *                      "Bateleur eagle" };
	 *    	Stream<String> s = Arrays.stream(eagles);
	 * 
	 * D.	String[] eagles = { "Bald eagle", "Golden eagle", 
	 *                      "Bateleur eagle" };
	 *    	Stream<String> s = Stream.of(eagles);
	 * 
	 * E.	ArrayList<String> eagles = new ArrayList<>();
	 *    	eagles.add("Bald eagle");  eagles.add("Golden eagle"); 
	 *    	eagles.add("Bateleur eagle");
	 *   	Stream<String> s = eagles.stream();
	 * 
	 * F.	Map<String, String> eagles = new HashMap<>();
	 *    	eagles.put("bird", "Bald eagle");  
	 *    	eagles.put("bird", "Golden eagle");
	 *   	eagles.put("bird", "Bateleur eagle");
	 *      Stream<String> s = Stream.of(eagles);
	 * 
	 * 
	 * 
	 * 
	 * A, B, C, , and E are correct. All compile; all create a Stream of Strings.
	 * F is incorrect. You cannot stream a Map; you first have to get an EntrySet, stream that, and get the values of the Map from the entry set to create a Stream of Strings (of eagle names):
	 * 
	 * Stream<String> s = eagles.entrySet().stream().map(e -> e.getValue());
	 * 
	 * คำอธิบาย:
	 * - A: ใช้ `Stream.of` เพื่อสร้าง Stream จากค่าที่กำหนดไว้ล่วงหน้า ("Bald eagle", "Golden eagle", "Bateleur eagle") 
	 * 		ซึ่งจะเป็น `Stream<String>` ที่ถูกต้อง
	 * - B: ใช้ `Arrays.asList` เพื่อแปลงอาร์เรย์เป็น List จากนั้นใช้ `.stream()` เพื่อสร้าง Stream จาก List ซึ่งเป็นวิธีที่ถูกต้อง
	 * - C: ใช้ `Arrays.stream` เพื่อสร้าง Stream จากอาร์เรย์ `eagles` ซึ่งจะได้ `Stream<String>` ที่ถูกต้อง
	 * - D: ใช้ `Stream.of` เพื่อสร้าง Stream จากอาร์เรย์ `eagles` ซึ่งจะได้ `Stream<Object[]>` แทน 
	 * 		เนื่องจาก `Stream.of` จะรับค่าเป็นอาร์เรย์ของออบเจ็กต์หนึ่งๆ แต่ในกรณีนี้เราอยากได้ `Stream<String>`, 
	 * 		ดังนั้นตัวเลือกนี้จึง **ไม่ถูกต้อง** เนื่องจากจะเป็น `Stream<Object[]>` ไม่ใช่ `Stream<String>`
	 * - E: ใช้ `ArrayList.stream()` เพื่อสร้าง Stream จาก ArrayList ซึ่งเป็นวิธีที่ถูกต้อง
	 * - F: ข้อนี้ผิด เพราะไม่สามารถสตรีมจาก `Map` ได้โดยตรง ต้องใช้ `entrySet()` ของ `Map` และจากนั้นสตรีม 
	 * 	`entrySet` แล้วแปลงค่าจาก `Map.Entry` เป็น String ด้วย `map(e -> e.getValue())`
	 * 		
	 		Map<String, String> eagles = new HashMap<>();
			eagles.put("bird", "Bald eagle");
			eagles.put("bird", "Golden eagle");
			eagles.put("bird", "Bateleur eagle"); // This will overwrite the previous values
			
			// Create a stream of Map entries
			Stream<Map.Entry<String, String>> entryStream = eagles.entrySet().stream();
			entryStream.forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

	 */

}
