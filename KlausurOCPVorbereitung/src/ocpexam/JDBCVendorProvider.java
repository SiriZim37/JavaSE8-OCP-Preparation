package ocpexam;

public class JDBCVendorProvider {

/*
 * 65. For which three objects must a vendor provide implementations in its JDBC driver?

	A. Time
	B. Date
	C. Statement
	D. ResultSet
	E. Connection
	F. SQLException
	G. DriverManager

	Answer: C, D, E
	
	Explanation: 
	Database vendors support JDBC through the JDBC driver interface or
	through the ODBC connection. Each driver must provide implementations of
	java.sql.Connection, java.sql.Statement, java.sql.PreparedStatement,
	java.sql.CallableStatement, and java.sql.Re sultSet. They must also implement the
	java.sql.Driver interface for use by the generic java.sql.DriverManager interface.
	
	1: All JDBC drivers implement the four important JDBC classes: 
	
		Driver, Connection, Statement, and ResultSet.
	
	Ref 1: http://www.aiotestking.com/oracle/for-which-three-objects-must-a-vendor-provide-implementations-in-its-jdbc-driver/
	Ref 2: http://vceguide.com/which-three-objects-must-a-vendor-provide-implementations-in-its-jdbc-driver/
 */
}
