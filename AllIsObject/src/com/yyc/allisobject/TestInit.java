package com.yyc.allisobject;

public class TestInit{

	static {
		System.out.println("静态代码块");
	}
	{
		System.out.println("构造代码块");
	}
	public TestInit() {
		System.out.println("构造函数");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TestInit t1=new TestInit();
		System.out.println("--------------");
		TestInit t2=new TestInit();
		System.out.println("--------------");
		TestInit t3=new TestInit();
	}

}
