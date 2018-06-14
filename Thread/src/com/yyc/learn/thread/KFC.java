package com.yyc.learn.thread;
import java.util.ArrayList;
import java.util.List;

class Pools{
	private List<String> foods;
	public Pools(){
		foods=new ArrayList<String>();
		for(int i=0;i<2;i++) {
			foods.add("超级无敌汉堡包");
		}
	}
	public List<String> getFoods() {
		return foods;
	}
	public void setFoods(List<String> foods) {
		this.foods = foods;
	}
	public void add() {
		foods.add("超级无敌汉堡包");
	}
	public void remove() {
		foods.remove("超级无敌汉堡包");
	}
}
class CustomerThread implements Runnable{
	private Pools p;

	public CustomerThread(Pools p) {
		super();
		this.p = p;
	}

	@Override
	public void run() {
		synchronized(p) {
			while(true){
				System.out.println("消费前库存汉堡数量："+p.getFoods().size());
				p.remove();
				System.out.println(Thread.currentThread().getName()+"消费了一个汉堡");
				System.out.println("消费后库存汉堡数量："+p.getFoods().size());
			while(p.getFoods().size()==0) {
				System.out.println(Thread.currentThread().getName()+"消费完毕，消费者休息！");
				p.notify();
				try {
					System.out.println(Thread.currentThread().getName()+"消费者线程等待开始");
					p.wait();
					System.out.println(Thread.currentThread().getName()+"消费者线程等待结束");
					System.out.println("开始消费！");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
		}
		// TODO Auto-generated method stub
		
	}
	
	
}
class WaiterThread implements Runnable{
	private Pools p;

	public WaiterThread(Pools p) {
		super();
		this.p = p;
	}

	@Override
public void run() {
		// TODO Auto-generated method stub
		synchronized(p) {
			while(true) {
				System.out.println("生产前库存汉堡数量："+p.getFoods().size());
				p.add();
				System.out.println(Thread.currentThread().getName()+"生产了一个汉堡");
				System.out.println("生产后库存汉堡数量："+p.getFoods().size());
				while(p.getFoods().size()>2) {
					System.out.println(Thread.currentThread().getName()+"生产完毕，生产者休息！");
					p.notify();
					try {
						System.out.println(Thread.currentThread().getName()+"生产者线程等待开始");
						p.wait();
						System.out.println(Thread.currentThread().getName()+"生产者线程等待结束");
						System.out.println("开始生产!");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		
	}
	
}
public class KFC{
	public static void main(String[] args) {

		Pools p=new Pools();
		new Thread(new CustomerThread(p),"消费者线程：").start();
		new Thread(new WaiterThread(p),"生产者线程：").start();
	}
}