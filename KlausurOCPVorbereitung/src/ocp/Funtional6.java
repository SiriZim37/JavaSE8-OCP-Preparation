package ocp;

public class Funtional6 {

	/*
	 
	 	________ bf = (a, b) -> a + b;                  // L1
		________ ibf = a -> a/12.0;                     // L2
		________ dbf = (a, b) -> a.doubleValue()/b.doubleValue();   // L3
		________ dif = a -> Math.round(a);                  // L4
		Choose the correct set of type signatures.
		
		
		
		A.
		L1: BiFunction<Integer, Integer>
		
		L2: IntToDoubleFunction
		
		L3: BiFunction<Integer, Double>
		
		L4: DoubleToLongFunction
		
		
		B.
		L1: BiFunction<Integer, Integer, Integer>
		
		L2: Function<Integer, Integer>
		
		L3: BiFunction<Integer, Integer, Double>
		
		L4: DoubleFunction
		
		
		C.
		L1: Function<Integer, Integer, Integer>
		
		L2: IntToDoubleFunction
		
		L3: Function<Integer, Integer, Double>
		
		L4: DoubleToLongFunction
		
		
		D.
		L1: BiFunction<Integer, Integer, Integer>
		
		L2: IntToDoubleFunction
		
		L3: BiFunction<Integer, Integer, Double>
		
		L4: DoubleToLongFunction

	Correct Answer:
	 * 
	 * D. 
	 * L1: BiFunction<Integer, Integer, Integer>
	 * L2: IntToDoubleFunction
	 * L3: BiFunction<Integer, Integer, Double>
	 * L4: DoubleToLongFunction
	 * 
	 * Explanation of correctness:
	 * - L1: BiFunction<Integer, Integer, Integer> is correct because the lambda `(a, b) -> a + b` takes two Integer inputs 
	 *   and returns an Integer result.
	 * - L2: IntToDoubleFunction is correct because the lambda `a -> a / 12.0` takes a single int input 
	 *   and returns a double result.
	 * - L3: BiFunction<Integer, Integer, Double> is correct because the lambda `(a, b) -> a.doubleValue() / b.doubleValue()` 
	 *   takes two Integer inputs and returns a Double result.
	 * - L4: DoubleToLongFunction is correct because the lambda `a -> Math.round(a)` takes a double input 
	 *   and returns a long result.
	 * 
	 * Why A, B, and C are incorrect:
	 * - A: Incorrect for L1 because BiFunction<Integer, Integer> requires a return type to be specified. Missing return type for L1.
	 * - B: Incorrect for L2 because Function<Integer, Integer> expects both input and output as Integer, but here the output is a double.
	 *      Also incorrect for L4 because DoubleFunction requires the return type to be Double, but here it returns a long.
	 * - C: Incorrect for L1 because Function<Integer, Integer, Integer> is not a valid type (Function only accepts one input type and one output type).
	 *      Incorrect for L3 because Function<Integer, Integer, Double> does not match; it requires two inputs, not one.
	 * 
	 * คำอธิบายเพิ่มเติม (ภาษาไทย):
	 * - L1: BiFunction<Integer, Integer, Integer> ถูกต้อง เพราะ lambda `(a, b) -> a + b` รับค่า Integer 2 ค่า และคืนค่าเป็น Integer
	 * - L2: IntToDoubleFunction ถูกต้อง เพราะ lambda `a -> a / 12.0` รับค่า int 1 ค่า และคืนค่าเป็น double
	 * - L3: BiFunction<Integer, Integer, Double> ถูกต้อง เพราะ lambda `(a, b) -> a.doubleValue() / b.doubleValue()` 
	 *       รับค่า Integer 2 ค่า และคืนค่าเป็น Double
	 * - L4: DoubleToLongFunction ถูกต้อง เพราะ lambda `a -> Math.round(a)` รับค่า double 1 ค่า และคืนค่าเป็น long
	 * 
	 * ทำไม A, B, และ C ถึงไม่ถูกต้อง:
	 * - A: ผิดที่ L1 เพราะ BiFunction<Integer, Integer> ขาดชนิดของค่าที่คืนกลับ (return type)
	 * - B: ผิดที่ L2 เพราะ Function<Integer, Integer> คาดหวัง input และ output เป็น Integer แต่ในกรณีนี้ output เป็น double
	 *       และผิดที่ L4 เพราะ DoubleFunction ต้องคืนค่าเป็น Double แต่ที่นี่คืนค่าเป็น long
	 * - C: ผิดที่ L1 เพราะ Function<Integer, Integer, Integer> ไม่ใช่ชนิดข้อมูลที่ถูกต้อง (Function รับแค่ input และ output 2 ชนิด)
	 *       และผิดที่ L3 เพราะ Function<Integer, Integer, Double> ไม่รองรับ input สองตัว
	 */


	
}
