package com.yyc.learn.thread;

class SellThread implements Runnable {

	private int ticket = 100;

	@Override
	public void run() {
		while (true) {
			 synchronized (this) {
			if (ticket > 0) {
				System.out.println(Thread.currentThread().getName() + ":将要卖一张票编号为：" + ticket);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + ":卖了一张票编号为：" + (ticket--));
				 }
			}
		}
	}

}

public class SellTicket {

	public static void main(String[] args) {
		SellThread st = new SellThread();
		new Thread(st).start();
		new Thread(st).start();
		new Thread(st).start();
	}

}
