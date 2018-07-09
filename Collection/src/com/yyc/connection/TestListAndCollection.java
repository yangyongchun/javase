package com.yyc.connection;

import java.util.*;
/**
 * 帮商品编号
 * @author yyc
 *
 */
class Apple {
	private static int counter=1;//计数器从1开始
	private final int id=counter++;//计数器先把值赋给id,然后自增；
	public int getId() {
		return id;
	}
	
}
/**
 * 
 * @author yyc
 *
 */
public class TestListAndCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List l=new ArrayList();
		l.add(new Apple());
		l.add(new Apple());
		l.add(new Apple());
		for(int i=0;i<l.size();i++) {
			System.out.println(((Apple)l.get(i)).getId());//collection
			//Collection没有get(i)方法需要先转型
		}
		Collections.addAll(l, Arrays.asList(1,2,3,4,5,6));
		
		System.out.println(l);
		
		
	}

}
