package com.yyc.learn.database2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;




	public class StudentDao {
		Connection conn=null;
		PreparedStatement ps=null;
		{conn=DBConnection.getConn();}
		public void addStudent(Student s) {
			String sql="insert into student values(?,?,?,?)";
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, s.get学号());
				ps.setString(2, s.get姓名());
				ps.setString(3, s.get性别());
				ps.setString(4, s.get年龄());
				
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
