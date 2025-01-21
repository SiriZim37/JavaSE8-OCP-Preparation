package ocp;

public class JDBC1 {
	/*
	 * Which are true about ResultSets in JDBC? (Choose all that apply.)
	 * 
	 * A. Before you read the first entry in a ResultSet, you must invoke next().
	 * 
	 * B. Columns in ResultSets can be accessed via column name or index.
	 * 
	 * C. ResultSet column indexes start at 0.
	 * 
	 * D. The ResultSetMetaData interface is often used to provide information about the columns and rows returned from a query so that well formatted reports can be generated.
	 * 
	 * E. The default JDBC cursor allows only forward scrolling through a ResultSet.
	 * 
	 * F. Some JDBC cursors allow both absolute and relative cursor positioning.
	 * 
	 * A, B, E, and F are correct.
	 * C is incorrect because when accessing columns by index, the first column is at index 1.
	 * D is incorrect ResultSetMetaData does not provide information about the number of rows returned by a query.
	 * 
	 * คำอธิบาย:
	 * - A: ก่อนที่เราจะอ่านข้อมูลใน ResultSet ครั้งแรก เราต้องเรียกใช้ next() เพื่อเลื่อนไปยังแถวแรก
	 * - B: เราสามารถเข้าถึงคอลัมน์ใน ResultSet ได้ทั้งผ่านชื่อคอลัมน์หรือดัชนีของคอลัมน์
	 * - C: ข้อนี้ไม่ถูกต้อง เพราะดัชนีของคอลัมน์ใน ResultSet เริ่มต้นที่ 1 เมื่อเข้าถึงผ่านดัชนี
	 * - D: ข้อนี้ไม่ถูกต้อง เพราะ ResultSetMetaData จะให้ข้อมูลเกี่ยวกับคอลัมน์ของ ResultSet แต่ไม่เกี่ยวข้องกับจำนวนแถวที่ได้รับจากการ query
	 * - E: โดยค่าเริ่มต้น JDBC cursor จะสามารถเลื่อนไปข้างหน้าเท่านั้นใน ResultSet
	 * - F: บางประเภทของ JDBC cursor อนุญาตให้เราตั้งตำแหน่งของ cursor ได้ทั้งแบบสัมบูรณ์ (absolute) และเชิงสัมพันธ์ (relative)
	 */

}
