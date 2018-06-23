package com.yyc.learn.socket1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetIP {
public static void main(String[] args) {
	InetAddress address1 = null;
	InetAddress address2 = null;
	try {
		address1 = InetAddress.getLocalHost();
		address2=InetAddress.getByName("www.baidu.com");
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(address1);
	System.out.println(address2);
}
}
