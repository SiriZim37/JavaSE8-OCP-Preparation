package ocp;

public class Stream2 {
	/*
	 * public class Weather {
	 *     int year;
	 *     int month;
	 *     int temp;
	 *     public Weather(int y, int m, int t) { 
	 *         this.year = y; this.month = m; this.temp = t;
	 *     }
	 *     public int getYear() { return this.year; }
	 *     public int getMonth() { return this.month; }
	 *     public int getTemp() { return this.temp; }
	 *     public String toString() { 
	 *         return year + "/" + month + ": " + temp;
	 *     }
	 * }
	 * 
	 * And the code fragment:
	 * 
	 * List<Weather> weather = …; // properly created and populated
	 * Comparator<Weather> byTemp = (w1, w2) -> w1.getTemp() < w2.getTemp() ? -1 : 1;
	 * Comparator<Weather> byMonth = (w1, w2) -> w1.getMonth() < w2.getMonth() ? -1 : 1;
	 * // L1
	 * 
	 * Which, when inserted at line L1, enable the code to sort the weather list by temperature 
	 * and sort weather entries with the same temperature by month?
	 * 
	 * A. weather.stream().sorted(byTemp.thenComparing(byMonth));
	 * 
	 * B. weather.stream().sorted(byTemp).thenComparing(byMonth);
	 * 
	 * C. weather.stream().sorted(byTemp).thenComparing.sorted(byMonth);
	 * 
	 * D. weather.stream().sorted().thenComparing(byTemp, byMonth);
	 * 
	 * E. weather.stream().sorted(byTemp, byMonth);
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * Correct Answer: A
	 * 
	 * Explanation (English):
	 * - A is correct because `sorted(byTemp.thenComparing(byMonth))` combines the two Comparators 
	 *   (byTemp and byMonth) into a single Comparator. The method `thenComparing()` is used to 
	 *   chain Comparators, ensuring that the list is first sorted by temperature and then by month.
	 * 
	 * - B, C, D, and E are incorrect for the following reasons:
	 *   - B: `thenComparing()` cannot be called on a stream; it must be called on a Comparator.
	 *   - C: The second call to `sorted()` is unnecessary and causes a syntax error.
	 *   - D: `thenComparing()` requires one Comparator, not two.
	 *   - E: `sorted()` only accepts a single Comparator. Multiple Comparators need to be combined first.
	 * 
	 * คำอธิบาย (ภาษาไทย):
	 * - A ถูกต้องเพราะ `sorted(byTemp.thenComparing(byMonth))` ใช้ `thenComparing()` เพื่อรวม Comparator สองตัว 
	 *   คือ `byTemp` และ `byMonth` เข้าด้วยกัน ทำให้ลิสต์ถูกจัดเรียงตามอุณหภูมิก่อน และจัดเรียงเดือนเมื่ออุณหภูมิเหมือนกัน
	 * 
	 * - B, C, D และ E ไม่ถูกต้องเนื่องจาก:
	 *   - B: `thenComparing()` ไม่สามารถเรียกใช้งานบนสตรีมได้ ต้องเรียกใช้บน Comparator เท่านั้น
	 *   - C: การเรียก `sorted()` ครั้งที่สองเป็นสิ่งที่ไม่จำเป็น และทำให้เกิดข้อผิดพลาดในไวยากรณ์
	 *   - D: `thenComparing()` ต้องการ Comparator หนึ่งตัวเท่านั้น ไม่สามารถรับสองตัวพร้อมกันได้
	 *   - E: `sorted()` รองรับเฉพาะ Comparator หนึ่งตัวเท่านั้น ดังนั้นจำเป็นต้องรวม Comparator สองตัวก่อน
	 */


}
