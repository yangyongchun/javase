package com.yyc.allisobject;
/**
 * test
 * @author yyc
 *
 */
public class ShowProperties {
/**
 * 
 * @param args 存储命令行参数
 */
	public static void main(String[] args) {
		System.getProperties().list(System.out);
		System.out.println(System.getProperty("user.name"));
		System.out.println(System.getProperty("java.library.path"));
	}
}
