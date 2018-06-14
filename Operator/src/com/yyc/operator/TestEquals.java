package com.yyc.operator;
/**
 * equals是object类的方法，
 * 所有没有重写这个方法的类中的这个方法比较的都是地址，
 * 也就是和'=='是一样的，
 * 重写过这个方法的类就按照重写的方法来比较，
 * 比如String类就重写了这个方法，比较的是内容
 * @author yyc
 *
 */
public class TestEquals {

	public static void main(String[] args)
	{
		Integer a=10;
		Integer b=10;//a,b小于128调用缓冲池里的数据相当于int a=10;
		System.out.println(a==b);//true
		System.out.println(a.equals(b));//true
		Integer c=128;
		Integer d=128;//c,d大于等于128缓冲池里没有数据,
		//相当于Integer c=new Integer(128)
		System.out.println(c==d);//flase
		System.out.println(c.equals(d));//true
		Integer e=10;
		Integer f=new Integer(10);
		System.out.println(e==f);//false
		System.out.println(e.equals(f));//true
		Integer g=128;
		Integer h=new Integer(128);
		System.out.println(g==h);//flase
		System.out.println(g.equals(h));//true
		Integer y=new Integer(10);
		int x=10;
		System.out.println(x==y);//true
		System.out.println(y.equals(x));//true
		int i=128;
		Integer j=new Integer(128);
		System.out.println(i==j);//true
		System.out.println(j.equals(i));//true
		
		
		
	}
}
