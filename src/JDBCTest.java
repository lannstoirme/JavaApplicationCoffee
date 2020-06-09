import java.sql.*;

public class JDBCTest {
	
	public JDBCTest () {
		//URL For the SSID
		String url = "jdbc:oracle:thin:@interact-db-f1.its.deakin.edu.au:1521:SSID";
		Connection con;
		Statement stmt;
	

	String createString = "create table COFFEES" + "(COF_NAME varchar(32), " + "SUP_ID int, " + "PRICE float, "
			+ "SALES int, " + "TOTAL int)";
	try {
		//Oracle driver is loaded
		Class.forName("oracle.jdbc.driver.OracleDriver");
	}
	catch (java.lang.ClassNotFoundException e) {
		System.err.print("ClassNotFoundException: ");
	}
	
	try {
		// Supply your username and password for SSID
		con = DriverManager.getConnection(url, "lwoodward", "Vienna1988!");
		
		//create statement from connection
		stmt = con.createStatement();
		
		//create table
		stmt.executeUpdate(createString);
		
		//populate the table
		stmt.executeUpdate("INSERT INTO COFFEES " +
				"VALUES ('Colombian', 101, 7.99, 0, 0)"	);
		
		stmt.executeUpdate("INSERT INTO COFFEES " +
				"VALUES ('Espresso', 150, 9.99, 0, 0)" );
		
		stmt.executeUpdate("INSERT INTO COFFEES " +
				"VALUES ('French_Roast', 49, 8.99, 0,0)" );
		
		stmt.executeUpdate("INSERT INTO COFFEES " +
				"VALUES ('Colombian_Decaf', 101, 8.99, 0, 0)");
		
		stmt.executeUpdate("INSERT INTO COFFEES" +
				"VALUES ('French_Roast_Decaf', 49, 9.99, 0, 0)");
		
		String query = "SELECT COF_NAME, PRICE FROM COFFEES";
		
		//ResultSet object is obtained from the table
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			String s = rs.getString("COF_NAME");
			float n = rs.getFloat("PRICE");
			System.out.println(s + "  " + n);
		}
		
		stmt.close();
		con.close();
			
	}
	catch(SQLException e) {
		System.err.println("SQLException: " + e.getMessage());
	}
	}
	public static void main(String[] args) {
			new JDBCTest();
	}
	
	
}
