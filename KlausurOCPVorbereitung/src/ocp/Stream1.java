package ocp;

import java.util.ArrayList;
import java.util.List;

class Reading {
	    int year;
	    double extent;
	    
	    public Reading(int y, double e) { 
	        this.year = y; 
	        this.extent = e; 
	    }
	    
	    public int getYear() { 
	        return this.year; 
	    }
	    
	    public double getExtent() { 
	        return this.extent; 
	    }
	    
	    public String toString() { 
	        return extent + " in " + year; 
	    } 
	}
public class Stream1 {
	
	public static void main(String[] args) {
		
		
		List<Reading> readings = new ArrayList<>();
		readings.add(new Reading(2002, 5.98)); 
		readings.add(new Reading(2007, 4.32)); 
		readings.add(new Reading(2012, 3.63)); 
		readings.add(new Reading(2017, 4.64));
		
		readings.stream().mapToInt(r -> r.getYear())
		             .peek(System.out::print)
		             .filter(v -> v > 2010)
		             .forEach(System.out::print);
		 
	}
	/*
	 * 
	 * What is the result?
	 * 
	 * A.  200220072012201720122017
	 * B.  20022007201220172002200720122017
	 * C.  201220172002200720122017
	 * D.  200220072012201220172017
	 * E.  20122017
	 * 
	 * D is correct.
	 * 
	 * Explanation:
	 * - เราเริ่มจากการแปลงสตรีมของ Reading เป็น `mapToInt` เพื่อดึงค่า `year` (ปี)
	 * - `peek(System.out::print)` จะพิมพ์ค่าปีออกมาทีละค่าในลำดับที่สตรีมไหลผ่าน เช่น 2002, 2007, 2012, 2017
	 * - `filter(v -> v > 2010)` จะกรองปีที่มากกว่า 2010 ซึ่งเหลือเพียง 2012 และ 2017
	 * - `forEach(System.out::print)` จะพิมพ์ค่าที่เหลือ (2012 และ 2017) อีกครั้ง
	 * 
	 * ดังนั้น ลำดับการพิมพ์จะเป็น:
	 * - `peek`: 2002, 2007, 2012, 2017
	 * - `forEach`: 2012, 2017
	 * ผลลัพธ์รวมคือ: 200220072012201220172017
	 * 
	 * ทำไม D ถูกต้อง:
	 * - ข้อมูลทั้งหมดในสตรีมจะพิมพ์ออกโดย `peek` ก่อน
	 * - ค่า 2012 และ 2017 ผ่านการกรองและถูกพิมพ์อีกครั้งใน `forEach`
	 * - ดังนั้นค่าที่ปรากฏจะเป็นลำดับที่ตรงกับกระบวนการของสตรีม
	 * 
	 * ทำไม A, B, C, และ E ไม่ถูกต้อง:
	 * - A: มีการพิมพ์ค่าซ้ำที่ไม่ถูกต้องตามกระบวนการจริง
	 * - B: รวมค่าที่พิมพ์โดย `peek` และ `forEach` แต่ลำดับไม่ถูกต้อง
	 * - C: เริ่มพิมพ์จากค่า 2012 และ 2017 ก่อน ซึ่งไม่สอดคล้องกับลำดับของสตรีม
	 * - E: แสดงเฉพาะค่าที่ผ่านการกรอง แต่ไม่รวมค่าที่พิมพ์ใน `peek`
	 */

}
