package ocp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Weather2 {
    int year;
    int month;
    int temp;
    public Weather2(int y, int m, int t) { 
        this.year = y; this.month = m; this.temp = t;
    }
    public int getYear() { return this.year; }
    public int getMonth() { return this.month; }
    public int getTemp() { return this.temp; }
    public String toString() { 
        return year + "/" + month + ": " + temp;
    }
}

public class Stream8 {
	
	public static void main(String[] args) {
		
		List<Weather2> weather = new ArrayList<>();
		weather.add(new Weather2(2017, 1, 31));
		weather.add(new Weather2(2016, 1, 29));
		weather.add(new Weather2(2015, 2, 33));
		weather.add(new Weather2(2014, 1, 35));
		weather.add(new Weather2(2011, 2, 27));
		weather.add(new Weather2(2010, 3, 28));
		weather.stream()
		    .collect(Collectors.groupingBy(Weather2::getMonth))
		    .forEach((m, w) -> System.out.println(w));
		
	}
	/*
	 * What is the result?
	 * 
	 * A. [1, 1, 1]
	 *    [2, 2]
	 *    [3]
	 * 
	 * B. [1, 1, 1, 2, 2, 3]
	 * 
	 * C. [2017/1: 31, 2016/1: 29, 2014/1: 35, 2015/2: 33, 2011/2: 27, 2010/3: 28]
	 * 
	 * D. [2017/1: 31, 2016/1: 29, 2014/1: 35]
	 *    [2015/2: 33, 2011/2: 27]
	 *    [2010/3: 28]
	 * 
	 * E. A compile-time error occurs
	 * 
	 * D is correct. The groupingBy() method with Weather::getMonth groups the Weather items by month, 
	 * each into a separate list. Each list is added to a Map, with the month as key. When we call forEach() 
	 * on a Map, we need a BiConsumer (two parameters), the key, and the value (the month and list). 
	 * When we print the Weather items in each list, we see the toString() version of each Weather item.
	 * 
	 * A, B, C, and E are incorrect.
	 * 
	 * คำอธิบาย:
	 * - คำตอบ D ถูกต้อง เพราะการใช้ `groupingBy(Weather::getMonth)` จะทำการจัดกลุ่มข้อมูลจาก `Weather` โดยแยกตามเดือน
	 *   และจะได้ผลลัพธ์เป็น Map ที่มีเดือนเป็นคีย์ และค่าคือรายการของ Weather ที่มีเดือนเดียวกัน
	 * - คำตอบ A ไม่ถูกต้อง เพราะการใช้ `groupingBy` จะไม่แสดงแค่เดือน แต่จะรวมข้อมูล Weather ที่ตรงกับเดือนนั้นๆ ในรูปแบบของรายการ
	 * - คำตอบ B ไม่ถูกต้อง เนื่องจากเราไม่ได้รวมทุก Weather ในรายการเดียวกัน
	 * - คำตอบ C ไม่ถูกต้อง เพราะ `groupingBy` จะแสดงผลเป็นการจัดกลุ่มของ Weather ตามเดือน ไม่ใช่การแสดงผลทั้งหมดในลักษณะนั้น
	 * - คำตอบ E ไม่ถูกต้อง เนื่องจากไม่มีข้อผิดพลาดในการคอมไพล์
	 */

}
