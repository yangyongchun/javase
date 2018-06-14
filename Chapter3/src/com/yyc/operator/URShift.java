package com.yyc.operator;
/**
 * test移位操作
 * @author yyc
 *
 */
public class URShift {
 
	public static void main(String[] args) {
		int i=-65;
		System.out.println(Integer.toBinaryString(i));
		System.out.println(Integer.toBinaryString(i>>>5));
	}
}
