package com.yyc.learn.database1;

import java.util.List;

public class TestPerson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PersonDao dao=new PersonDao();
		Person p1=new Person();
		p1.setPid(1);
		p1.setName("杨永春");
		p1.setSex("男");
		p1.setTel("123242341");
		p1.setAddress("南京");
		p1.setEmail("xx@xx.com");

		//dao.addPerson(p1);
		
		List p2 = dao.getPersonByname("杨永春");
		System.out.print(p2);
		
	}

}
