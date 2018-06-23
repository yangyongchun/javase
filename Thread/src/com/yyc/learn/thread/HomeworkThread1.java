package com.yyc.learn.thread;
class PrintName implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<20;i++) {
			System.out.println(Thread.currentThread().getName()+":zhangsan"+"------"+i);
		}
		System.out.println("-------------");
	}
	
}

public class HomeworkThread1 {
public static void main(String[] args) {
	Thread t1=new Thread(new PrintName());
	t1.setName("thread t1");
	t1.start();
	try {
		//join()方法表示该线程会一直抢占CPU时间片；
		t1.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Thread t2=new Thread(new PrintName());
	t2.setName("thread t2");
	t2.start();
	
	
}
}
