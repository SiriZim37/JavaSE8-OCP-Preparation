package ocp;

public class JDBC3 {

	/*
	 * try {
	 *   Connection c = … // connection is created here…
	 *   Statement s = c.createStatement();
	 *   ResultSet rs = s.executeQuery("select * from cust"); // get 3 records
	 *   s.close();
	 *   while (rs.next()) {
	 *     // assume that there is a column named "name"
	 *     System.out.println("Name: " + rs.getString("name"));
	 *   }
	 *   rs.close();
	 *   c.close();
	 * } catch (SQLException exception) {
	 *   System.out.println("Exception: " + exception.getMessage());
	 * }
	 * And if the code that compiles the ResultSet contains three records, what is the result?
	 * 
	 * A. The instruction on line 18 is executed two times
	 * 
	 * B. The instruction on line 18 is executed three times
	 * 
	 * C. A SQLException is thrown on line 15
	 * 
	 * D. A SQLException is thrown on line 16
	 * 
	 * E. Compilation fails
	 * 
	 * F. A different exception is thrown at runtime
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * D is correct. The ResultSet rs is created on line 14, originated from the Statement s, created on line 13. On line 15, s is closed, which automatically closes any associated resources with it—that is, the ResultSet rs. When line 16 is reached, a SQLException is thrown because rs has automatically been closed.
	 * 
	 * A, B, C, E, and F are incorrect based on the above.
	 * 
	 * คำอธิบาย:
	 * - ข้อ D ถูกต้อง เพราะในบรรทัดที่ 15 เราจะปิด Statement s ซึ่งจะปิด Resource ที่เกี่ยวข้องทั้งหมด รวมถึง ResultSet rs ด้วย ดังนั้นเมื่อไปถึงบรรทัดที่ 16 ซึ่งพยายามใช้ rs ต่อ จะเกิด SQLException เพราะ rs ถูกปิดแล้ว
	 * - ข้อ A และ B ไม่ถูกต้อง เนื่องจากการปิด Statement จะทำให้ ResultSet ถูกปิดโดยอัตโนมัติ
	 * - ข้อ C ไม่ถูกต้อง เพราะไม่มี SQLException เกิดขึ้นที่บรรทัดที่ 15
	 * - ข้อ E ไม่ถูกต้อง การคอมไพล์จะไม่ล้มเหลว
	 * - ข้อ F ไม่ถูกต้อง ไม่มีข้อผิดพลาดอื่น ๆ ที่จะเกิดขึ้น
	 */

	
}
