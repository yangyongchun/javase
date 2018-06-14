package com.yyc.learn.thread;
import java.util.Random;

class Account {
	private String username;
	private int money;

	public Account() {
	}
	public Account(String username,int money) {
		this.username=username;
		this.money=money;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	public void zhuanZhang(Account a,String name) {
		
		Thread t=new Thread(new MyThread(this,a));
		t.setName(name);
		t.start();
		
	}
	
}

class MyThread implements Runnable {

	
	private Account a1;
	private Account a2;
	public MyThread(Account a1,Account a2) {
		this.a1=a1;
		this.a2=a2;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Account[] a =TestBank.getA();
		Random rand=new Random();
		int x=rand.nextInt(500);
		System.out.println(Thread.currentThread().getName()+a1.getUsername()+"正在转账给："+a2.getUsername()+"...");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(a1.getUsername().equals(a2.getUsername())) {
			System.out.println(Thread.currentThread().getName()+"转账失败，不能转给自己");
		}else {
		synchronized(a2) {
		a2.setMoney(a2.getMoney()+x);
		a1.setMoney(a1.getMoney()-x);
		System.out.println(Thread.currentThread().getName()+a1.getUsername()+"给"+a2.getUsername()+"转账"+x+"成功！");
		System.out.println(Thread.currentThread().getName()+a1.getUsername()+"给"+a2.getUsername()+"转账成功之后剩余金额："+a1.getUsername()+":余额"+a1.getMoney()+","+a2.getUsername()+":余额"+a2.getMoney());
			}
		int result = 0;
		TestBank tb=new TestBank();
		for(int i=0;i<10;i++) {
			result+=a[i].getMoney();
			tb.setTotalMoney(result);
		}
		System.out.println(Thread.currentThread().getName()+a1.getUsername()+"给"+a2.getUsername()+"转账成功之后银行总金额："+tb.getTotalMoney());
		}
	}
	}

class TestBank{
	private static Account[] a=new Account[10];
	private int totalMoney=0;
	static {
		for(int i=0;i<10;i++) {
			a[i]=new Account("account"+i,500);
		}
		
	}
	public static Account[] getA() {
		return a;
	}
	public static void setA(Account[] a) {
		TestBank.a = a;
	}
	public int getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}

}

public class YinHang{
	public static void main(String[] args) {
		System.out.println("------------------我是main线程，测试：10个账户同时向(账户8)转钱--------------------");
		Account[] a =TestBank.getA();
		for(int i=0;i<10;i++) {
			a[i].zhuanZhang(a[8],"线程"+i+":");
		}
		
	}
	
}
	
	

