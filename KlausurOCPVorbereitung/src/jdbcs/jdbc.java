package jdbcs;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbc {

	/*
	 	1. What will the getDatabaseProductVersion() method of DatabaseMetaData return?
	
		A) The name of the JDBC driver.
		B) The version of the database product.
		C) The version of the Connection object.
		D) The product's database catalog.
		Answer: B) The version of the database product.
		
		
		2. Which method of DatabaseMetaData would you use to retrieve information about the columns of a table?
		
		A) getTables()
		B) getColumns()
		C) getSchemas()
		D) getPrimaryKeys()
		
		Answer: B) getColumns()
		
		3. What 3 are available through an instance of DatabaseMetadata? 
			- The name of JDBC 
			 	ชื่อของ JDBC driver: ใช้ getDriverName() เพื่อดึงชื่อของ JDBC driver ที่ใช้เชื่อมต่อกับฐานข้อมูล
			- The default transaction isolate level
				ระดับการแยกธุรกรรม (Transaction Isolation Level): ใช้ getDefaultTransactionIsolation() เพื่อดึงระดับการแยกธุรกรรมที่ถูกตั้งค่าเป็นค่าเริ่มต้นในฐานข้อมูล
			- The name of stored procedure in db 
				ชื่อของ Stored Procedures: ใช้ getProcedures() เพื่อดึงข้อมูลเกี่ยวกับ stored procedures ที่ฐานข้อมูลรองรับ

	 */
	
	public static void main(String[] args) {
		try {
            // เชื่อมต่อไปยังฐานข้อมูล
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password");
            
            // ดึง DatabaseMetaData
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            
            // 1. ชื่อของ JDBC driver
            String driverName = databaseMetaData.getDriverName();
            System.out.println("ชื่อของ JDBC driver: " + driverName);
            
            // 2. ระดับการแยกธุรกรรมที่ตั้งค่าเริ่มต้น
            int isolationLevel = databaseMetaData.getDefaultTransactionIsolation();
            String isolationLevelName = "";
            switch (isolationLevel) {
                case Connection.TRANSACTION_READ_UNCOMMITTED:
                    isolationLevelName = "Read Uncommitted";
                    break;
                case Connection.TRANSACTION_READ_COMMITTED:
                    isolationLevelName = "Read Committed";
                    break;
                case Connection.TRANSACTION_REPEATABLE_READ:
                    isolationLevelName = "Repeatable Read";
                    break;
                case Connection.TRANSACTION_SERIALIZABLE:
                    isolationLevelName = "Serializable";
                    break;
                default:
                    isolationLevelName = "Unknown";
            }
            System.out.println("ระดับการแยกธุรกรรม (Default): " + isolationLevelName);
            
            // 3. ชื่อของ stored procedure ที่รองรับ
            ResultSet procedures = databaseMetaData.getProcedures(null, null, "%");
            System.out.println("ชื่อของ stored procedures:");
            while (procedures.next()) {
                String procedureName = procedures.getString("PROCEDURE_NAME");
                System.out.println("Stored Procedure: " + procedureName);
            }

            // ปิดการเชื่อมต่อ
            procedures.close();
            connection.close();

        } catch (SQLException e) {
            // การจัดการข้อผิดพลาด SQL
            e.printStackTrace();
        }
	}
}
