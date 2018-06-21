package com.yyc.learn.xml;

public class Student {

	@Override
	public String toString() {
		return "Student [学号=" + 学号 + ", 姓名=" + 姓名 + ", 性别=" + 性别 + ", 年龄=" + 年龄 + "]";
	}
	private String 学号;
	private String 姓名;
	private String 性别;
	private String 年龄;
	public String get学号() {
		return 学号;
	}
	public void set学号(String 学号) {
		this.学号 = 学号;
	}
	public String get姓名() {
		return 姓名;
	}
	public void set姓名(String 姓名) {
		this.姓名 = 姓名;
	}
	public String get性别() {
		return 性别;
	}
	public void set性别(String 性别) {
		this.性别 = 性别;
	}
	public String get年龄() {
		return 年龄;
	}
	public void set年龄(String 年龄) {
		this.年龄 = 年龄;
	}
	
}
