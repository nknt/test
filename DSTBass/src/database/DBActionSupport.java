package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBActionSupport {
	String url = "jdbc:mysql://localhost:3306/";
	String dbName = "dst_bass";
	String driverName = "com.mysql.jdbc.Driver";
	String userName = "dst";
	String password = "dst";
	Connection con = null;
	public Statement stmt = null;
	
	public void initializeConnection(){
		try {
			Class.forName(driverName).newInstance();
			con = DriverManager.getConnection(url + dbName, userName, password);
			stmt = con.createStatement();
		} catch (Exception e) {
			System.out.println("DB Connection Error: " + e.getMessage());
		}
	}
}
