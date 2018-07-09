package com.yyc.connection;

import java.util.*;

public class TestStack {
LinkedList<Object> l=new LinkedList<Object>();
public void push(Object o) {
	l.addFirst(o);
	
}
public Object pop() {
	if((!l.isEmpty())) {
		return l.removeFirst();
	}
	return "栈空";
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TestStack ts=new TestStack();
		ts.push("a");
		ts.push("b");
		ts.push("c");
		ts.pop();
		System.out.println(ts.pop());
		System.out.println(ts.pop());
		System.out.println(ts.pop());
	}

}
