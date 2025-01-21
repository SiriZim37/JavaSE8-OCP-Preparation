package ocp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

class Weather {
    int year;
    int month;
    int temp;
    public Weather(int y, int m, int t) { 
        this.year = y; this.month = m; this.temp = t;
    }
    public int getYear() { return this.year; }
    public int getMonth() { return this.month; }
    public int getTemp() { return this.temp; }
    public String toString() { 
        return year + "/" + month + ": " + temp;
    }
}

public class Stream5 {
	
	public static void main(String[] args) {
		List<Weather> weather = new ArrayList<>();
		weather.add(new Weather(2017, 1, 31));
		weather.add(new Weather(2016, 1, 29));
		weather.add(new Weather(2015, 2, 33));
		Optional<Weather> w = 
		   weather.stream().sorted(Comparator.comparing(Weather::getTemp)).findFirst();
		w.ifPresent(t -> System.out.println(t.getTemp()));

		/*
		 * What is the result?
		 * 
		 * A. 31
		 * B. 29
		 * C. 33
		 * D. The code does not compile
		 * E. A runtimerror
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * Answer: B is correct.
		 * 
		 * Explanation:
		 * - We sort the weather stream using a Comparator created by passing a Function (Weather::getTemp) 
		 *   to comparing(), which produces a sort key for the comparison. This sorts the items by their 
		 *   temperature, in ascending (natural) order.
		 * - We then use findFirst() to get the first result, which will be the Weather item with the 
		 *   lowest temperature, 29. 
		 * - This returns an Optional<Weather>, so we use ifPresent() to display the result, 29, 
		 *   if it exists, which it does.
		 * 
		 * A, C, D, and E are incorrect for the following reasons:
		 * - A and C are incorrect because 31 and 33 are not the lowest temperatures in the list.
		 * - D is incorrect because the code compiles successfully.
		 * - E is incorrect because the code executes without throwing any runtime exceptions.
		 * 
		 * คำอธิบาย (ภาษาไทย):
		 * - คำตอบคือ B (29) เนื่องจากในโค้ดมีการเรียงลำดับข้อมูลใน weather stream โดยใช้ Comparator 
		 *   ซึ่งสร้างจาก Function (Weather::getTemp) และเปรียบเทียบอุณหภูมิจากค่าน้อยไปมาก
		 * - คำสั่ง findFirst() ใช้เพื่อดึงค่าข้อมูลตัวแรกสุดในลำดับ ซึ่งในกรณีนี้คือข้อมูล Weather 
		 *   ที่มีอุณหภูมิต่ำที่สุด (29)
		 * - คำสั่ง findFirst() คืนค่าเป็น Optional<Weather> ดังนั้นใช้ ifPresent() เพื่อตรวจสอบและแสดงผลถ้ามีค่า 
		 *   ซึ่งในที่นี้มีค่า จึงแสดง 29 ออกมา
		 * 
		 * เหตุผลที่ A, C, D, และ E ไม่ถูกต้อง:
		 * - A และ C ไม่ถูกต้องเพราะ 31 และ 33 ไม่ใช่อุณหภูมิที่ต่ำที่สุด
		 * - D ไม่ถูกต้องเพราะโค้ดสามารถคอมไพล์ได้ไม่มีปัญหา
		 * - E ไม่ถูกต้องเพราะโค้ดไม่มีข้อผิดพลาดขณะรันไทม์
		 */

		
	}
}
