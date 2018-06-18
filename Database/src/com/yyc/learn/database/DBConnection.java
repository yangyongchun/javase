package com.yyc.learn.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection getConn() {
		String url="jdbc:mysql://localhost:3306/shiyan4";
		String username="root";
		String password="yyc19970204";
		String driver="com.mysql.jdbc.Driver";
		Connection conn = null;
		
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
