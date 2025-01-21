package ocp;

public class StreamPrimitiv {
	/*
	 * What java.util.function and java.util.stream package interface(s) would you use if you wanted to efficiently process 
	 * a large number of temperature measurements represented by primitive double values and avoid autoboxing values? 
	 * (Choose all that apply.)
	 * 
	 * A. Consumer<Double>
	 * 
	 * B. Supplier<Double>
	 * 
	 * C. DoubleStream
	 * 
	 * D. DoubleFunction
	 * 
	 * E. Stream<Double>
	 * 
	 * F. Function<Double, Double>
	 * 
	 * G. DoubleUnaryOperator
	 * 
	 * C, D, and G are correct. All these interfaces are used with primitive double values.
	 * A, B, E, and F are incorrect. These interfaces all work with Double (object) values and would require autoboxing.
	 * 
	 * คำอธิบาย:
	 * - C: DoubleStream เป็นอินเตอร์เฟซที่ใช้สำหรับการทำงานกับค่าประเภท primitive double โดยตรง 
	 * 		และสามารถประมวลผลข้อมูลจำนวนมากได้อย่างมีประสิทธิภาพ
	 * - D: DoubleFunction เป็นอินเตอร์เฟซที่ใช้รับค่า primitive double และคืนค่าเป็น primitive double 
	 * 		ซึ่งช่วยหลีกเลี่ยงการทำ autoboxing
	 * - G: DoubleUnaryOperator เป็นอินเตอร์เฟซที่ทำงานกับค่าประเภท primitive double 
	 * 		โดยตรง เช่นเดียวกับ DoubleStream และ DoubleFunction
	 * 
	 * - A, B, E, F: อินเตอร์เฟซเหล่านี้ทำงานกับ Double (เป็นออบเจกต์) และจะต้องทำ autoboxing ข้อมูล
	 * 		 ซึ่งอาจส่งผลต่อประสิทธิภาพเมื่อทำงานกับข้อมูลจำนวนมาก
	 */

}
