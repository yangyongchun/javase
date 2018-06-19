package com.yyc.learn.database1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDao {
	Connection conn=null;
	PreparedStatement ps=null;
	{conn=DBConnection.getConn();}
	public void addPerson(Person p) {
		String sql="insert into person values(?,?,?,?,?,?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, p.getPid());
			ps.setString(2, p.getName());
			ps.setString(3, p.getSex());
			ps.setString(4, p.getTel());
			ps.setString(5, p.getAddress());
			ps.setString(6, p.getEmail());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deletePersonById(int id) {
		String sql="delete from person where id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public List<Person> getPersonByname(String name){
		List<Person> l=new ArrayList<Person>(); 
		String sql="select * from person where name=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Person p=new Person();
				p.setPid(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setSex(rs.getString("sex"));
				p.setTel(rs.getString("tel"));
				p.setAddress(rs.getString("address"));
				p.setEmail(rs.getString("email"));
				l.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
		
		
	}

}
