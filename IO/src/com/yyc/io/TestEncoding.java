package com.yyc.io;

import java.io.UnsupportedEncodingException;

public class TestEncoding {
	public static void main(String[] args) {
String str1="杨永春";
byte[] b=str1.getBytes();
try {
	System.out.println(new String(b,"GBK"));
} catch (UnsupportedEncodingException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


try {
	System.out.println(new String(str1.getBytes("UTF-8"),"GBK"));//源编码->目标编码
} catch (UnsupportedEncodingException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
}
