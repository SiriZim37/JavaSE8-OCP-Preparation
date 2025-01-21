package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class B14_ResultSet_Scroll {

	/*
	 * การใช้เมธอดต่างๆ ของ ResultSet สำหรับการเคลื่อนที่ภายในข้อมูล
	 *
	 * 1. next():  				- ใช้เพื่อเลื่อนไปยังแถวถัดไปใน ResultSet. ถ้าเลื่อนไปไม่ถึงแถวที่มีข้อมูลจะคืนค่าเป็น false.
	 * 2. previous(): boolean 			- ใช้เพื่อเลื่อนไปยังแถวก่อนหน้าใน ResultSet. ถ้าไม่สามารถเลื่อนไปได้จะคืนค่าเป็น false.
	 * 3. isBeforeFirst() : boolean		- ใช้เพื่อตรวจสอบว่าเคอร์เซอร์อยู่ก่อนแถวแรกหรือไม่. ถ้าเคอร์เซอร์อยู่ก่อนแถวแรกจะคืนค่าเป็น true.
	 * 4. isAfterLast(): boolean 		- ใช้เพื่อตรวจสอบว่าเคอร์เซอร์อยู่หลังแถวสุดท้ายหรือไม่. ถ้าเคอร์เซอร์อยู่หลังแถวสุดท้ายจะคืนค่าเป็น true.
	 * 5. afterLast() : void			- ใช้เพื่อย้ายเคอร์เซอร์ไปยังแถวหลังสุดใน ResultSet. เมื่อเคอร์เซอร์อยู่ที่แถวหลังสุดแล้ว, 
	 *      							  การเรียกเมธอด next() จะคืนค่าเป็น false เนื่องจากไม่มีข้อมูลหลังจากนั้น.
	 * 6. beforeFirst() : void 			- ใช้เพื่อย้ายเคอร์เซอร์ไปยังแถวก่อนหน้าแถวแรกใน ResultSet. เมื่อเคอร์เซอร์อยู่ที่ก่อนแถวแรกแล้ว, 
	 *      							  การเรียกเมธอด next() จะคืนค่าเป็น true เนื่องจากเคอร์เซอร์สามารถเริ่มต้นจากแถวแรกได้.
	 * 7. absolute(int row) : boolean	- ใช้เพื่อเคลื่อนที่ไปยังแถวที่ระบุด้วยหมายเลขแถวที่ส่งเข้าไป. สามารถใช้หมายเลขแถวที่เป็นบวก (นับจากแถวแรก) 
	 *      							  หรือเป็นลบ (นับจากแถวสุดท้าย). คืนค่า: boolean (คืนค่า true ถ้าเคอร์เซอร์เคลื่อนที่สำเร็จ, false ถ้าไม่มีแถวที่ระบุ)
	 */
	
	public static void main(String[] args) {
//		String url = "jdbc:derby:C:\\path\\to\\mydb;";
		String url = "jdbc:derby:/Users/sirivimonmeuntup/Documents/Dev_Project/Java-Workspace/javaocpse8/JDBC/mydb";

		JDBCUtils.rebuildTestTable();

		/*
		 * Standard-Typ von einem ResultSet ist TYPE_FORWARD_ONLY
		 * ค่าเริ่มต้นของประเภท (Standard-Typ) ของ ResultSet คือ TYPE_FORWARD_ONLY
		 * 
		 * Damit der Cursor auch rückwärts bewegt werden kann,
		 * muss das ResultSet den Typ TYPE_SCROLL_INSENSITIVE 
		 * oder TYPE_SCROLL_SENSITIVE haben.
		 * เพื่อให้เคอร์เซอร์ (Cursor) สามารถเคลื่อนที่ถอยหลังได้,
		 * ต้องกำหนดให้ ResultSet มีประเภทเป็น TYPE_SCROLL_INSENSITIVE 
		 * หรือ TYPE_SCROLL_SENSITIVE
		 * 
		 */
		try (Connection c = DriverManager.getConnection(url);
				Statement stm = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY)){
			
			stm.executeUpdate("insert into kunden(id,name,kontostand) values (4,'Tom',12345)");
			stm.executeUpdate("insert into kunden(id,name,kontostand) values (5,'Jerry',50000)");
			
			
			JDBCUtils.printTestTable();
			
			try (ResultSet res = stm.executeQuery("select * from kunden")){
				/*
					    | ID|      Name|Kontostand|
						---------------------------
					 ->
						|  1|     Peter|      2000|
						|  2|      Paul|       111|
						|  3|      Mary|      7500|
						|  4|       Tom|     12345|
						|  5|     Jerry|     50000|
				 */
				
				//------------------------------------------------------------------------------//
				/*
				 *  boolean next() throws SQLException;
				 */
				boolean result = res.next();
				
				/*
					    | ID|      Name|Kontostand|
						---------------------------
					 ->	|  1|     Peter|      2000|
						|  2|      Paul|       111|
						|  3|      Mary|      7500|
						|  4|       Tom|     12345|
						|  5|     Jerry|     50000|
				 */
				System.out.println("1. " + res.getString("name"));		// Peter
				System.out.println("2. " + result);						// true
				
				//------------------------------------------------------------------------------//
				
				res.next();
				result = res.next();
				
				/*
					    | ID|      Name|Kontostand|
						---------------------------
					 	|  1|     Peter|      2000|
						|  2|      Paul|       111|
					->	|  3|      Mary|      7500|
					 	|  4|       Tom|     12345|
						|  5|     Jerry|     50000|
				 */
				
				System.out.println("3. " + res.getString("name"));		// Mary
				System.out.println("4. " + result);						// true
				
				//------------------------------------------------------------------------------//
				
				res.next();
				res.next();
				result = res.next();
				
				/*
					    | ID|      Name|Kontostand|
						---------------------------
					 	|  1|     Peter|      2000|
						|  2|      Paul|       111|
						|  3|      Mary|      7500|
						|  4|       Tom|     12345|
						|  5|     Jerry|     50000|
					 -> 
				 */
				
//				System.out.println("5. " + res.getString("name"));		//Exception
				System.out.println("6. " + result);						// false
				
				//------------------------------------------------------------------------------//
				
				try {				
					result = res.next();   
					System.out.println("7. " + res.getString("name"));		// Error: SQLException: Invalid cursor state - no current row.				
			
				} catch (SQLException e) {
					System.out.println("7. java.sql.SQLException: Invalid cursor state - no current row.");
				}
				//------------------------------------------------------------------------------//
				
												// Important! ResultSet.TYPE_SCROLL_INSENSITIVE  !! 
				result = res.previous();		//  The 'previous()' method is only allowed on scroll cursors.!!!
				
				/*
					    | ID|      Name|Kontostand|
						---------------------------
					 	|  1|     Peter|      2000|
						|  2|      Paul|       111|
						|  3|      Mary|      7500|
						|  4|       Tom|     12345|
					  ->|  5|     Jerry|     50000|
					 
				 */
				
				System.out.println("8. " + res.getString("name"));		// Jerry
				System.out.println("9. " + result);						// true
				
				//------------------------------------------------------------------------------//
				
				/*
				 *     boolean isBeforeFirst() throws SQLException  ( คือเมธอดที่ใช้ในการตรวจสอบว่าเคอร์เซอร์ (Cursor) อยู่ก่อนแถวแรกใน ResultSet หรือไม่ )
				 *     boolean isAfterLast() throws SQLException;   ( คือเมธอดที่ใช้ในการตรวจสอบว่าเคอร์เซอร์อยู่หลังแถวสุดท้ายใน ResultSet หรือไม่ )
				 */
				result = res.isBeforeFirst();
				System.out.println("10. " + res.getString("name"));		// Jerry
				System.out.println("11. " + result);					// false
				System.out.println("12 " + res.isAfterLast());			// false
				
				//------------------------------------------------------------------------------//	
				
				/*
				 *     void afterLast() throws SQLException;
				 *     void beforeFirst() throws SQLException;
				 */
				res.afterLast();			
				/*
					    | ID|      Name|Kontostand|
						---------------------------
					 	|  1|     Peter|      2000|
						|  2|      Paul|       111|
						|  3|      Mary|      7500|
						|  4|       Tom|     12345|
					    |  5|     Jerry|     50000|
					-> 
				 */	
				System.out.println("12.A " + res.isAfterLast());			// true
				
				res.beforeFirst();
				/*
					    | ID|      Name|Kontostand|
						---------------------------
					-> 	
					 	|  1|     Peter|      2000|
						|  2|      Paul|       111|
						|  3|      Mary|      7500|
						|  4|       Tom|     12345|
					    |  5|     Jerry|     50000|
					
				 */
				System.out.println("11.A " + res.isBeforeFirst());			// true
				//------------------------------------------------------------------------------//		
				
				/*
				 *  boolean absolute( int row ) throws SQLException;
				 */
				int rowNr = 4;
				res.absolute(rowNr);
				
				/*									Negative Rückwärtsnummerierung
					    | ID|      Name|Kontostand|
						---------------------------
					 	|  1|     Peter|      2000|  -5
						|  2|      Paul|       111|  -4
						|  3|      Mary|      7500|  -3
					->	|  4|       Tom|     12345|  -2
					    |  5|     Jerry|     50000|  -1
					
				 */
				
				System.out.println("13. " + res.getString("name"));			// Tom
				
				rowNr = 7;
				System.out.println("14. " + res.absolute(rowNr));			// false
				
				res.absolute(-4);	
				/*									Negative Rückwärtsnummerierung
					    | ID|      Name|Kontostand|
						---------------------------
					 	|  1|     Peter|      2000|  -5
					->	|  2|      Paul|       111|  -4
						|  3|      Mary|      7500|  -3
						|  4|       Tom|     12345|  -2
					    |  5|     Jerry|     50000|  -1
					
				 */
				System.out.println("15. " + res.getString("name"));			// Paul
				System.out.println("16. " + res.absolute(-4));				// true
				
				//------------------------------------------------------------------------------//	
				
				/*
				 * 
				 */
				int delta = 3 ;			// forwärts  (Move 3 forward )
				res.relative(delta);
				/*								
					    | ID|      Name|Kontostand|
						---------------------------
					 	|  1|     Peter|      2000|  
						|  2|      Paul|       111|  
						|  3|      Mary|      7500|  
						|  4|       Tom|     12345|  
				     -> |  5|     Jerry|     50000|  
					
				 */
				System.out.println("17. " + res.getString("name"));		// Jerry
				
				delta = -2 ;			// rückwärts  (Move 3 backward )
				res.relative(delta);
				/*								
					    | ID|      Name|Kontostand|
						---------------------------
					 	|  1|     Peter|      2000|  
						|  2|      Paul|       111|  
					->	|  3|      Mary|      7500|  
						|  4|       Tom|     12345|  
				        |  5|     Jerry|     50000|  
					
				 */
				System.out.println("18. " + res.getString("name"));		// Mary
				
			} // ResultSet schließen
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
