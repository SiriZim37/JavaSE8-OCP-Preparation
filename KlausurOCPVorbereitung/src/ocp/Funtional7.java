package ocp;

public class Funtional7 {


	/*
	 * _class TaxCalc {
	 *     public static void compute() {
	 *         double price = 100.0;
	 *         double tax = findTax(price, (v -> v * 0.08));
	 *         System.out.println("Tax for price " + price + " is " + tax);
	 *     }
	 *     // LINE X
	 * }
	 * 
	 * Which method(s) can be inserted at Line X to enable the code fragment to print:
	 * Tax for price 100.0 is 8.0
	 * when calling new TaxCalc().compute() (Choose all that apply.)
	 * 
	 * A. 
	 * public static double findTax(double p, DoubleUnaryOperator df) {
	 *     return df.applyAsDouble(p);
	 * }
	 * 
	 * B. 
	 * public static double findTax(double p, Function<Double, Double> df) {
	 *     return df.apply(p).doubleValue();
	 * }
	 * 
	 * C. 
	 * public static double findTax(double p, Function<double, double> df) {
	 *     return df.apply(p);
	 * }
	 * 
	 * D. 
	 * public static double findTax(double p, DoubleFunction<Double> df) {
	 *     return df.apply(p).doubleValue();
	 * }
	 * 
	 * E. 
	 * public static double findTax(double p, DoubleFunction<double, double> df) {
	 *     return df.apply(p);
	 * }
	 * 
	 * A, B, and D are correct.
	 * 
	 * Explanation:
	 * - A: Correct. DoubleUnaryOperator is designed to handle primitive `double` as both input and output.
	 * - B: Correct. Function<Double, Double> is compatible because it can convert the primitive `double` into its wrapper class `Double`.
	 * - C: Incorrect. `Function<double, double>` uses primitive types, but `Function` expects wrapper types like `Double`.
	 * - D: Correct. DoubleFunction<Double> accepts a primitive `double` as input and produces a `Double` as output, which works fine here.
	 * - E: Incorrect. `DoubleFunction<double, double>` is invalid syntax because `DoubleFunction` only takes a single parameterized type for its return value.
	 * 
	 * อธิบายเพิ่มเติม (Thai):
	 * - A: ถูกต้อง เพราะ DoubleUnaryOperator รองรับ primitive `double` ทั้งค่า input และ output โดยตรง
	 * - B: ถูกต้อง Function<Double, Double> ใช้ได้ เพราะจะทำการแปลง primitive `double` ให้เป็น wrapper `Double` ได้
	 * - C: ไม่ถูกต้อง เพราะ `Function<double, double>` ใช้ primitive types ซึ่งไม่เข้ากันกับ `Function` ที่ต้องการ object types (เช่น `Double`)
	 * - D: ถูกต้อง DoubleFunction<Double> ใช้ได้ เนื่องจากรับค่า primitive `double` เป็น input และคืนค่าเป็น object `Double`
	 * - E: ไม่ถูกต้อง เพราะ `DoubleFunction<double, double>` ผิด syntax และ `DoubleFunction` ควรใช้ parameterized type เดียวเพื่อกำหนดค่า return เท่านั้น
	 */

}
