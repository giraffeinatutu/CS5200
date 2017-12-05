package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectMe {
	
	public static ConnectMe thing;
	
	public ConnectMe() {
		try {
		    conn = DriverManager.getConnection(DB_URL, USER, PASS);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static ConnectMe getThing(){
		if(thing == null) {
			thing = new ConnectMe();
		}
		return thing;
	}
	
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final String DB_URL = "jdbc:mysql://localhost:3306/hw3_riley_caitlin_fall_2017";
	final String USER = "root";
	final String PASS = "12345";
    public Connection conn = null;

    public PreparedStatement pstmt = null;
}
