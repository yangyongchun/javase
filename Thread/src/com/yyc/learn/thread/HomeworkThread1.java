package com.yyc.learn.thread;
class PrintName implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<20;i++) {
			System.out.println("zhangsan");
		}
	}
	
}
class PrintID implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<20;i++) {
			System.out.println("11211101");
		}
	}
	
}

public class HomeworkThread1 {
public static void main(String[] args) {
	new Thread(new PrintName()).start();
	new Thread(new PrintID()).start();
}
}
