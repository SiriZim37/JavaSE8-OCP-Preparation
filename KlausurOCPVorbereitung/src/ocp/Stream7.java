package ocp;

public class Stream7 {
	
	/*
	 * Question:
	 * public class Reading {
	 *     int year;
	 *     double extent;
	 *     public Reading(int y, double e) { this.year = y; this.extent = e; }
	 *     public int getYear() { return this.year; }
	 *     public double getExtent() { return this.extent; }
	 *     public String toString() { return extent + " in " + year; } 
	 * }
	 * 
	 * List<Reading> readings = new ArrayList<>();
	 * readings.add(new Reading(2002, 5.98));
	 * readings.add(new Reading(2007, 4.32));
	 * readings.add(new Reading(2012, 3.63));
	 * readings.add(new Reading(2017, 4.64));
	 * 
	 * Comparator<Reading> c = Comparator.comparing(Reading::getExtent);
	 * Optional<Reading> minReading = ___F1___;
	 * Optional<Reading> maxReading = ___F2___;
	 * System.out.print("Min: "); minReading.ifPresent(System.out::println);
	 * System.out.print("Max: "); maxReading.ifPresent(System.out::println);
	 * 
	 * Which code fragments, inserted independently at F1 and F2, will produce the result:
	 * 
	 * Min: 3.63 in 2012
	 * Max: 5.98 in 2002
	 * 
	 * A.
	 * F1: readings.stream().collect(Collectors.groupingBy(c).min())
	 * F2: readings.stream().collect(Collectors.groupingBy(c).max())
	 * 
	 * B.
	 * F1: readings.stream().collect(Collectors.groupingBy(c).minBy())
	 * F2: readings.stream().collect(Collectors.groupingBy(c).maxBy())
	 * 
	 * C.
	 * F1: readings.stream().collect(Collectors.sorted(c).min())
	 * F2: readings.stream().collect(Collectors.sorted(c).max())
	 * 
	 * D.
	 * F1: readings.stream().collect(Collectors.sorted(c).minBy())
	 * F2: readings.stream().collect(Collectors.sorted(c).maxBy())
	 * 
	 * E.
	 * F1: readings.stream().collect(Collectors.minBy(c))
	 * F2: readings.stream().collect(Collectors.maxBy(c))
	 * 
	 * E is correct.
	 * 
	 * A, B, C, and D are incorrect. A and B are invalid ways of using groupingBy(); C and D are invalid ways of using sorted().
	 */

	/*
	 * คำอธิบาย:
	 * ตัวเลือก E คือคำตอบที่ถูกต้อง เนื่องจาก `Collectors.minBy(c)` และ `Collectors.maxBy(c)` เป็นวิธีที่ถูกต้องในการหาค่าต่ำสุดและค่าสูงสุดใน Stream โดยใช้ Comparator ซึ่งจะทำให้ผลลัพธ์เป็น "Min: 3.63 in 2012" และ "Max: 5.98 in 2002"
	 * 
	 * ส่วนตัวเลือก A, B, C, และ D ผิดทั้งหมด:
	 * - A และ B ใช้ `groupingBy` ซึ่งไม่ใช่การใช้งานที่ถูกต้องในการหาค่าต่ำสุดและค่าสูงสุดตามที่ต้องการ
	 * - C และ D ใช้ `sorted()` ซึ่งก็ไม่ได้ผลลัพธ์ที่ถูกต้อง เนื่องจาก `min()` และ `max()` ไม่ได้ทำงานกับ SortedStream ในลักษณะนี้
	 */

	

}
