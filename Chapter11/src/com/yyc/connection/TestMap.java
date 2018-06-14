package com.yyc.connection;

import java.util.*;

public class TestMap {

	public static void main(String[] args) {
		Map<Integer, String> m=new HashMap<Integer, String>();
		m.put(1, "one");
		m.put(2, "two");
		Set<Map.Entry<Integer, String>> entrys=m.entrySet();
		//存的是map的键值对，类型是键值对
		for(Map.Entry<Integer, String> entry:entrys) {
			System.out.println(entry.getKey()+"="+entry.getValue());
		}
		Set<Integer> keys=m.keySet();//存的是map的键，类型是键的类型
		for(Integer i:keys) {
			System.out.println(i+"="+m.get(i));
		}
		
		
	}
}
