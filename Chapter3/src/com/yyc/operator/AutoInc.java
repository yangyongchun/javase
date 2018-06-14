package com.yyc.operator;
/**
 * i++和++i
 * @author yyc
 *
 */
public class AutoInc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   int i=0;  
	       i=i++ + ++i;//0+2 
	       int j=0;  
	       j=++j + j++ + j++ + j++;//1+1+2+3
	       int k=0;  
	       k=k++ + k++ + ++k;//0+1+3
	       int h=0;  
	       h=++h + ++h;//1+2 
	       int x=0;  
	       int y=0;
	       x=++y + y++ + y++ + y++ + y++;//1+1+2+3+4
	       int a=0;
	       int b=0;
	       b=a++ + ++a + ++a + a++ + ++a + a++ + a++ + a++ + ++a + ++a;
	       //0+2+3+3+5+5+6+7+9+10
	       int p1=0,p2=0,q1=0,q2=0;  
	       q1=++p1; //1 
	       q2=p2++; //0
	       System.out.println("i:"+i);  
	       System.out.println("j:"+j);  
	       System.out.println("k:"+k);  
	       System.out.println("h:"+h);  
	       System.out.println("p1:"+p1);  
	       System.out.println("p2:"+p2);  
	       System.out.println("q1:"+q1);  
	       System.out.println("q2:"+q2);  
	       System.out.println("x:"+x);  
	       System.out.println("y:"+y);  
	       System.out.println("a:"+a);  
	       System.out.println("b:"+b);  
	       
	       int c=0;
	       for(int o=0;o<99;o++)
	       {
	    	   c=c++;
	       }//c=0
	       System.out.println("c:"+c); 
	       int d=0;
	       int e=0;
	       for(int o=0;o<100  ;o++)
	       {
	    	   e=d++;
	       }//e=99
	       System.out.println("e:"+e); 
	  
		   
	       
	       
		    
	     
	}

}
